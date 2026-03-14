package com.example.insight.camera

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.util.Log
import androidx.camera.core.*
import androidx.camera.core.ImageCapture.OnImageCapturedCallback
import androidx.camera.view.PreviewView
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors
import kotlin.math.abs

enum class CaptureMode { CAPTURING, EDITING }

@SuppressLint("UnsafeOptInUsageError")
@Composable
fun CameraCaptureScreen(
    onBack: () -> Unit,
    onImageCaptured: (Bitmap) -> Unit,
    onError: (ImageCaptureException) -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val scope = rememberCoroutineScope()
    
    // Camera Components
    val previewView = remember { PreviewView(context) }
    val imageCapture = remember { ImageCapture.Builder().build() }
    val textRecognizer = remember { TextRecognition.getClient() }
    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }

    // UI States
    var mode by remember { mutableStateOf(CaptureMode.CAPTURING) }
    var capturedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var screenRect by remember { mutableStateOf(Rect.Zero) }
    var cropRect by remember { mutableStateOf(Rect.Zero) } 
    var isInitialized by remember { mutableStateOf(false) }
    var rotationDegrees by remember { mutableIntStateOf(0) }
    var isProcessing by remember { mutableStateOf(false) }
    var activeHandle by remember { mutableStateOf<Handle?>(null) }

    LaunchedEffect(Unit) {
        val cameraProviderFuture = androidx.camera.lifecycle.ProcessCameraProvider.getInstance(context)
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }
            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(lifecycleOwner, CameraSelector.DEFAULT_BACK_CAMERA, preview, imageCapture)
            } catch (exc: Exception) {
                Log.e("CameraCapture", "Use case binding failed", exc)
            }
        }, context.mainExecutor)
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        val fullWidth = constraints.maxWidth.toFloat()
        val fullHeight = constraints.maxHeight.toFloat()

        if (!isInitialized && fullWidth > 0) {
            val rectWidth = fullWidth * 0.85f
            val rectHeight = fullHeight * 0.35f
            val left = (fullWidth - rectWidth) / 2
            val top = (fullHeight - rectHeight) / 2
            cropRect = Rect(left, top, left + rectWidth, top + rectHeight)
            screenRect = Rect(0f, 0f, fullWidth, fullHeight)
            isInitialized = true
        }

        // 1. Viewfinder Layer
        if (mode == CaptureMode.CAPTURING) {
            AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())
        } else {
            capturedBitmap?.let { bitmap ->
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // 2. Interactive Overlay
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(mode) {
                    if (mode == CaptureMode.EDITING) {
                        detectDragGestures(
                            onDragStart = { offset -> activeHandle = hitTest(offset, cropRect) },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                cropRect = applyDelta(cropRect, dragAmount, activeHandle, screenRect)
                            },
                            onDragEnd = { activeHandle = null }
                        )
                    }
                }
        ) {
            if (isInitialized) {
                val cutPath = Path.combine(
                    PathOperation.Difference,
                    Path().apply { addRect(screenRect) },
                    Path().apply { addRoundRect(RoundRect(cropRect, CornerRadius(12.dp.toPx()))) }
                )
                drawPath(cutPath, color = Color.Black.copy(alpha = 0.6f))

                drawRoundRect(
                    color = Color.White,
                    topLeft = cropRect.topLeft,
                    size = cropRect.size,
                    cornerRadius = CornerRadius(12.dp.toPx()),
                    style = Stroke(width = 2.dp.toPx())
                )

                if (mode == CaptureMode.EDITING) {
                    drawEnhancedEditCorners(cropRect, 24.dp.toPx(), 4.dp.toPx())
                }
            }
        }

        // 3. Header Controls
        Row(
            modifier = Modifier.statusBarsPadding().padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            if (mode == CaptureMode.EDITING) {
                Text("调整选区", color = Color.White, fontWeight = FontWeight.Bold)
                IconButton(onClick = { mode = CaptureMode.CAPTURING; capturedBitmap = null }) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = "Retake", tint = Color.White)
                }
            }
        }

        // 4. Footer Console
        Box(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 48.dp).fillMaxWidth()) {
            if (mode == CaptureMode.CAPTURING) {
                Surface(
                    onClick = {
                        if (isProcessing) return@Surface
                        isProcessing = true
                        imageCapture.takePicture(cameraExecutor, object : OnImageCapturedCallback() {
                            override fun onCaptureSuccess(image: ImageProxy) {
                                scope.launch {
                                    val original = image.toBitmapCompat()
                                    rotationDegrees = image.imageInfo.rotationDegrees
                                    capturedBitmap = rotateBitmap(original, rotationDegrees)
                                    image.close()
                                    mode = CaptureMode.EDITING
                                    isProcessing = false
                                }
                            }
                            override fun onError(exception: ImageCaptureException) {
                                onError(exception)
                                isProcessing = false
                            }
                        })
                    },
                    modifier = Modifier.size(80.dp).align(Alignment.Center),
                    shape = CircleShape,
                    color = Color.White
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        if (isProcessing) CircularProgressIndicator(color = Color.Black)
                        else Box(modifier = Modifier.size(60.dp).border(2.dp, Color.Black, CircleShape))
                    }
                }
            } else {
                ExtendedFloatingActionButton(
                    onClick = {
                        scope.launch {
                            isProcessing = true
                            capturedBitmap?.let { bitmap ->
                                val cropped = performCropDirect(bitmap, cropRect, screenRect)
                                onImageCaptured(cropped)
                            }
                        }
                    },
                    modifier = Modifier.align(Alignment.Center),
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(32.dp)
                ) {
                    Icon(Icons.Default.Check, null)
                    @Suppress("DEPRECATION")
                    Spacer(Modifier.width(8.dp))
                    Text("确认识别", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawEnhancedEditCorners(rect: Rect, len: Float, thickness: Float) {
    val color = Color.White
    // Corners
    drawPath(Path().apply {
        moveTo(rect.left, rect.top + len); lineTo(rect.left, rect.top); lineTo(rect.left + len, rect.top)
    }, color, style = Stroke(width = thickness, cap = StrokeCap.Round))
    drawPath(Path().apply {
        moveTo(rect.right, rect.top + len); lineTo(rect.right, rect.top); lineTo(rect.right - len, rect.top)
    }, color, style = Stroke(width = thickness, cap = StrokeCap.Round))
    drawPath(Path().apply {
        moveTo(rect.left, rect.bottom - len); lineTo(rect.left, rect.bottom); lineTo(rect.left + len, rect.bottom)
    }, color, style = Stroke(width = thickness, cap = StrokeCap.Round))
    drawPath(Path().apply {
        moveTo(rect.right, rect.bottom - len); lineTo(rect.right, rect.bottom); lineTo(rect.right - len, rect.bottom)
    }, color, style = Stroke(width = thickness, cap = StrokeCap.Round))
    
    // Edge Indicators (Minimalist lines in the middle of edges)
    val midLen = 16.dp.toPx()
    drawLine(color, Offset(rect.left, rect.center.y - midLen), Offset(rect.left, rect.center.y + midLen), thickness, StrokeCap.Round)
    drawLine(color, Offset(rect.right, rect.center.y - midLen), Offset(rect.right, rect.center.y + midLen), thickness, StrokeCap.Round)
    drawLine(color, Offset(rect.center.x - midLen, rect.top), Offset(rect.center.x + midLen, rect.top), thickness, StrokeCap.Round)
    drawLine(color, Offset(rect.center.x - midLen, rect.bottom), Offset(rect.center.x + midLen, rect.bottom), thickness, StrokeCap.Round)
}

enum class Handle { LEFT, TOP, RIGHT, BOTTOM, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER }

private fun hitTest(offset: Offset, rect: Rect): Handle? {
    val threshold = 40.dp.value
    return when {
        // Corners first (higher priority)
        abs(offset.x - rect.left) < threshold && abs(offset.y - rect.top) < threshold -> Handle.TOP_LEFT
        abs(offset.x - rect.right) < threshold && abs(offset.y - rect.top) < threshold -> Handle.TOP_RIGHT
        abs(offset.x - rect.left) < threshold && abs(offset.y - rect.bottom) < threshold -> Handle.BOTTOM_LEFT
        abs(offset.x - rect.right) < threshold && abs(offset.y - rect.bottom) < threshold -> Handle.BOTTOM_RIGHT
        // Edges
        abs(offset.x - rect.left) < threshold && offset.y in rect.top..rect.bottom -> Handle.LEFT
        abs(offset.x - rect.right) < threshold && offset.y in rect.top..rect.bottom -> Handle.RIGHT
        abs(offset.y - rect.top) < threshold && offset.x in rect.left..rect.right -> Handle.TOP
        abs(offset.y - rect.bottom) < threshold && offset.x in rect.left..rect.right -> Handle.BOTTOM
        // Center
        rect.contains(offset) -> Handle.CENTER
        else -> null
    }
}

private fun applyDelta(rect: Rect, delta: Offset, handle: Handle?, screen: Rect): Rect {
    if (handle == null) return rect
    val minSize = 150f
    return when (handle) {
        Handle.LEFT -> rect.copy(left = (rect.left + delta.x).coerceIn(0f, rect.right - minSize))
        Handle.TOP -> rect.copy(top = (rect.top + delta.y).coerceIn(0f, rect.bottom - minSize))
        Handle.RIGHT -> rect.copy(right = (rect.right + delta.x).coerceIn(rect.left + minSize, screen.right))
        Handle.BOTTOM -> rect.copy(bottom = (rect.bottom + delta.y).coerceIn(rect.top + minSize, screen.bottom))
        Handle.TOP_LEFT -> rect.copy(left = (rect.left + delta.x).coerceIn(0f, rect.right - minSize), top = (rect.top + delta.y).coerceIn(0f, rect.bottom - minSize))
        Handle.TOP_RIGHT -> rect.copy(right = (rect.right + delta.x).coerceIn(rect.left + minSize, screen.right), top = (rect.top + delta.y).coerceIn(0f, rect.bottom - minSize))
        Handle.BOTTOM_LEFT -> rect.copy(left = (rect.left + delta.x).coerceIn(0f, rect.right - minSize), bottom = (rect.bottom + delta.y).coerceIn(rect.top + minSize, screen.bottom))
        Handle.BOTTOM_RIGHT -> rect.copy(right = (rect.right + delta.x).coerceIn(rect.left + minSize, screen.right), bottom = (rect.bottom + delta.y).coerceIn(rect.top + minSize, screen.bottom))
        Handle.CENTER -> {
            val newRect = rect.translate(delta)
            if (screen.contains(newRect.topLeft) && screen.contains(newRect.bottomRight)) newRect else rect
        }
    }
}

private fun rotateBitmap(source: Bitmap, angle: Int): Bitmap {
    val matrix = Matrix().apply { postRotate(angle.toFloat()) }
    return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
}

private suspend fun performCropDirect(bitmap: Bitmap, cropRect: Rect, screenRect: Rect): Bitmap = withContext(Dispatchers.Default) {
    val scaleX = bitmap.width.toFloat() / screenRect.width
    val scaleY = bitmap.height.toFloat() / screenRect.height
    val left = (cropRect.left * scaleX).toInt().coerceAtLeast(0)
    val top = (cropRect.top * scaleY).toInt().coerceAtLeast(0)
    val width = (cropRect.width * scaleX).toInt().coerceAtMost(bitmap.width - left)
    val height = (cropRect.height * scaleY).toInt().coerceAtMost(bitmap.height - top)
    Bitmap.createBitmap(bitmap, left, top, width, height)
}

private fun ImageProxy.toBitmapCompat(): Bitmap {
    val buffer = planes[0].buffer
    val bytes = ByteArray(buffer.remaining())
    buffer.get(bytes)
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}

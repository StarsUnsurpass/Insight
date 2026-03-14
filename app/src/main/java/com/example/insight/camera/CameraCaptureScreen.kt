package com.example.insight.camera

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.util.Log
import androidx.camera.core.*
import androidx.camera.core.ImageCapture.OnImageCapturedCallback
import androidx.camera.view.PreviewView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
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
    
    val previewView = remember { PreviewView(context) }
    val imageCapture = remember { ImageCapture.Builder().build() }
    
    // Use standard client as defined in AppModule
    val textRecognizer = remember { TextRecognition.getClient() }
    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }

    var screenRect by remember { mutableStateOf(Rect.Zero) }
    var cropRect by remember { mutableStateOf(Rect(150f, 400f, 950f, 800f)) }
    var isCapturing by remember { mutableStateOf(false) }
    var detectedTextRect by remember { mutableStateOf<Rect?>(null) }
    var activeHandle by remember { mutableStateOf<Handle?>(null) }

    LaunchedEffect(Unit) {
        val cameraProviderFuture = androidx.camera.lifecycle.ProcessCameraProvider.getInstance(context)
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }

            val imageAnalysis = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()

            imageAnalysis.setAnalyzer(cameraExecutor) { imageProxy ->
                val mediaImage = imageProxy.image
                if (mediaImage != null) {
                    val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
                    textRecognizer.process(image)
                        .addOnSuccessListener { visionText ->
                            val largestBlock = visionText.textBlocks.maxByOrNull { 
                                (it.boundingBox?.width() ?: 0) * (it.boundingBox?.height() ?: 0)
                            }
                            largestBlock?.boundingBox?.let { box ->
                                detectedTextRect = Rect(box.left.toFloat(), box.top.toFloat(), box.right.toFloat(), box.bottom.toFloat())
                            }
                        }
                        .addOnCompleteListener { imageProxy.close() }
                }
            }

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    CameraSelector.DEFAULT_BACK_CAMERA,
                    preview,
                    imageCapture,
                    imageAnalysis
                )
            } catch (exc: Exception) {
                Log.e("CameraCapture", "Use case binding failed", exc)
            }
        }, context.mainExecutor)
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .onGloballyPositioned { coordinates ->
                    screenRect = Rect(0f, 0f, coordinates.size.width.toFloat(), coordinates.size.height.toFloat())
                }
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = { offset -> activeHandle = hitTest(offset, cropRect) },
                        onDrag = { change, dragAmount ->
                            change.consume()
                            cropRect = applyDelta(cropRect, dragAmount, activeHandle, screenRect)
                        },
                        onDragEnd = { activeHandle = null }
                    )
                }
        ) {
            val combinedPath = Path().apply { addRect(screenRect) }
            val holePath = Path().apply { addRoundRect(RoundRect(cropRect, CornerRadius(12.dp.toPx()))) }
            val cutPath = Path.combine(PathOperation.Difference, combinedPath, holePath)
            drawPath(cutPath, color = Color.Black.copy(alpha = 0.6f))

            drawRoundRect(
                color = Color.White,
                topLeft = cropRect.topLeft,
                size = cropRect.size,
                cornerRadius = CornerRadius(12.dp.toPx()),
                style = Stroke(width = 2.dp.toPx())
            )

            drawCorner(cropRect, 20.dp.toPx(), 4.dp.toPx())
        }

        IconButton(
            onClick = onBack,
            modifier = Modifier.statusBarsPadding().padding(16.dp).align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
        }

        Row(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 48.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) { Icon(Icons.Default.FlashOn, null, tint = Color.White) }

            Surface(
                onClick = {
                    if (isCapturing) return@Surface
                    isCapturing = true
                    imageCapture.takePicture(
                        cameraExecutor,
                        object : OnImageCapturedCallback() {
                            override fun onCaptureSuccess(image: ImageProxy) {
                                scope.launch {
                                    val bitmap = image.toBitmap()
                                    val cropped = performCrop(bitmap, cropRect, screenRect, image.imageInfo.rotationDegrees)
                                    onImageCaptured(cropped)
                                    image.close()
                                }
                            }
                            override fun onError(exception: ImageCaptureException) {
                                onError(exception)
                                isCapturing = false
                            }
                        }
                    )
                },
                modifier = Modifier.size(80.dp),
                shape = CircleShape,
                color = Color.White
            ) {
                Box(contentAlignment = Alignment.Center) {
                    if (isCapturing) CircularProgressIndicator(modifier = Modifier.size(40.dp), color = Color.Black)
                    else Box(modifier = Modifier.size(60.dp).border(2.dp, Color.Black, CircleShape))
                }
            }

            IconButton(onClick = {
                detectedTextRect?.let { cropRect = inflateRect(it, 40f) }
            }) {
                Icon(Icons.Default.Check, null, tint = if (detectedTextRect != null) Color.Green else Color.White)
            }
        }
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawCorner(rect: Rect, len: Float, thickness: Float) {
    drawPath(Path().apply {
        moveTo(rect.left, rect.top + len)
        lineTo(rect.left, rect.top)
        lineTo(rect.left + len, rect.top)
    }, Color.White, style = Stroke(width = thickness, cap = StrokeCap.Round))
    drawPath(Path().apply {
        moveTo(rect.right, rect.bottom - len)
        lineTo(rect.right, rect.bottom)
        lineTo(rect.right - len, rect.bottom)
    }, Color.White, style = Stroke(width = thickness, cap = StrokeCap.Round))
}

enum class Handle { TOP_LEFT, BOTTOM_RIGHT, CENTER }

private fun hitTest(offset: Offset, rect: Rect): Handle? {
    val threshold = 40.dp.value
    return when {
        abs(offset.x - rect.left) < threshold && abs(offset.y - rect.top) < threshold -> Handle.TOP_LEFT
        abs(offset.x - rect.right) < threshold && abs(offset.y - rect.bottom) < threshold -> Handle.BOTTOM_RIGHT
        rect.contains(offset) -> Handle.CENTER
        else -> null
    }
}

private fun applyDelta(rect: Rect, delta: Offset, handle: Handle?, screen: Rect): Rect {
    if (handle == null) return rect
    return when (handle) {
        Handle.TOP_LEFT -> rect.copy(left = (rect.left + delta.x).coerceIn(0f, rect.right - 100f), top = (rect.top + delta.y).coerceIn(0f, rect.bottom - 100f))
        Handle.BOTTOM_RIGHT -> rect.copy(right = (rect.right + delta.x).coerceIn(rect.left + 100f, screen.right), bottom = (rect.bottom + delta.y).coerceIn(rect.top + 100f, screen.bottom))
        Handle.CENTER -> {
            val newRect = rect.translate(delta)
            if (screen.contains(newRect.topLeft) && screen.contains(newRect.bottomRight)) newRect else rect
        }
    }
}

private suspend fun performCrop(bitmap: Bitmap, cropRect: Rect, screenRect: Rect, rotation: Int): Bitmap = withContext(Dispatchers.Default) {
    val matrix = Matrix().apply { postRotate(rotation.toFloat()) }
    val rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    val scaleX = rotatedBitmap.width.toFloat() / screenRect.width
    val scaleY = rotatedBitmap.height.toFloat() / screenRect.height
    val left = (cropRect.left * scaleX).toInt().coerceAtLeast(0)
    val top = (cropRect.top * scaleY).toInt().coerceAtLeast(0)
    val width = (cropRect.width * scaleX).toInt().coerceAtMost(rotatedBitmap.width - left)
    val height = (cropRect.height * scaleY).toInt().coerceAtMost(rotatedBitmap.height - top)
    Bitmap.createBitmap(rotatedBitmap, left, top, width, height)
}

private fun inflateRect(rect: Rect, delta: Float): Rect = Rect(rect.left - delta, top = rect.top - delta, right = rect.right + delta, bottom = rect.bottom + delta)

private fun ImageProxy.toBitmap(): Bitmap {
    val buffer = planes[0].buffer
    val bytes = ByteArray(buffer.remaining())
    buffer.get(bytes)
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}

package com.example.insight.camera

import android.util.Log
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.compose.ui.draw.scale
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.Image
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.example.insight.ui.theme.InkBlue
import com.example.insight.ui.theme.SageGreen
import com.example.insight.ui.theme.PaperWhite
import com.example.insight.ui.theme.HighlightYellow
import com.example.insight.ui.theme.DarkText
import java.nio.ByteBuffer

@Composable
fun CameraCaptureScreen(
    onImageCaptured: (ImageProxy?) -> Unit,
    onError: (ImageCaptureException) -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var cameraProvider by remember { mutableStateOf<ProcessCameraProvider?>(null) }
    val imageCapture = remember { ImageCapture.Builder().build() }

    // selectionRect in pixels relative to the Box
    var selectionRect by remember { mutableStateOf<Rect?>(null) }
    
    // UI States
    var capturedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var isFlashActive by remember { mutableStateOf(false) }

    LaunchedEffect(cameraProviderFuture) {
        cameraProvider = cameraProviderFuture.get()
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize().background(InkBlue)) {
        val screenWidth = constraints.maxWidth.toFloat()
        val screenHeight = constraints.maxHeight.toFloat()

        // Initialize selectionRect in center
        LaunchedEffect(screenWidth, screenHeight) {
            if (selectionRect == null && screenWidth > 0) {
                val rectWidth = screenWidth * 0.85f
                val rectHeight = screenHeight * 0.45f
                selectionRect = Rect(
                    offset = Offset((screenWidth - rectWidth) / 2, (screenHeight - rectHeight) / 2),
                    size = Size(rectWidth, rectHeight)
                )
            }
        }

        // --- Camera Preview / Background Layer ---
        Box(modifier = Modifier.fillMaxSize()) {
            if (capturedBitmap != null) {
                Image(
                    bitmap = capturedBitmap!!.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else if (cameraProvider != null) {
                AndroidView(
                    factory = { ctx ->
                        PreviewView(ctx).apply {
                            implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                        }
                    },
                    modifier = Modifier.fillMaxSize(),
                    update = { previewView ->
                        val preview = Preview.Builder().build().also {
                            it.setSurfaceProvider(previewView.surfaceProvider)
                        }
                        try {
                            cameraProvider?.unbindAll()
                            cameraProvider?.bindToLifecycle(
                                lifecycleOwner,
                                CameraSelector.DEFAULT_BACK_CAMERA,
                                preview,
                                imageCapture
                            )
                        } catch (exc: Exception) {
                            Log.e("CameraCapture", "Binding failed", exc)
                        }
                    }
                )
            }
        }

        // --- Overlay Layer (Selection Box) ---
        selectionRect?.let { rect ->
            DraggableSelectionOverlay(
                selectionRect = rect,
                onSelectionChange = { selectionRect = it },
                showScanning = capturedBitmap == null,
                modifier = Modifier.fillMaxSize()
            )
        }

        // --- Flash Effect ---
        androidx.compose.animation.AnimatedVisibility(
            visible = isFlashActive,
            enter = fadeIn(animationSpec = tween(50)),
            exit = fadeOut(animationSpec = tween(150))
        ) {
            Box(Modifier.fillMaxSize().background(Color.White))
        }

        // --- UI Panel (Gentle Efficiency Design) ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            if (capturedBitmap != null) {
                // Review Controls in a "Paper" Card
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .height(100.dp),
                    shape = RoundedCornerShape(32.dp),
                    color = PaperWhite.copy(alpha = 0.9f),
                    tonalElevation = 8.dp
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(
                            onClick = { capturedBitmap = null },
                            colors = ButtonDefaults.textButtonColors(contentColor = InkBlue)
                        ) {
                            Text("重拍", style = MaterialTheme.typography.labelLarge)
                        }
                        
                        Button(
                            onClick = { onImageCaptured(null) },
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = SageGreen),
                            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
                        ) {
                            Text("确认提取", style = MaterialTheme.typography.labelLarge, color = Color.White)
                        }
                    }
                }
            } else {
                // Capture Button with Glassmorphism
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    var isPressed by remember { mutableStateOf(false) }
                    val scale by animateFloatAsState(
                        targetValue = if (isPressed) 0.9f else 1f,
                        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow),
                        label = "shutterScale"
                    )

                    Surface(
                        modifier = Modifier
                            .size(84.dp)
                            .scale(scale)
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = {
                                        isPressed = true
                                        try { awaitRelease() } finally { isPressed = false }
                                    },
                                    onTap = {
                                        isFlashActive = true
                                        imageCapture.takePicture(
                                            ContextCompat.getMainExecutor(context),
                                            object : ImageCapture.OnImageCapturedCallback() {
                                                override fun onCaptureSuccess(image: ImageProxy) {
                                                    capturedBitmap = image.toRotatedBitmap()
                                                    image.close()
                                                    isFlashActive = false
                                                }
                                                override fun onError(exception: ImageCaptureException) {
                                                    onError(exception)
                                                    isFlashActive = false
                                                }
                                            }
                                        )
                                    }
                                )
                            },
                        shape = RoundedCornerShape(42.dp),
                        color = Color.White.copy(alpha = 0.2f),
                        border = androidx.compose.foundation.BorderStroke(4.dp, Color.White.copy(alpha = 0.8f))
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize().padding(8.dp).background(Color.White, RoundedCornerShape(34.dp))
                        )
                    }
                }
            }
        }
    }
}

private fun ImageProxy.toRotatedBitmap(): Bitmap {
    val buffer = planes[0].buffer
    val bytes = ByteArray(buffer.remaining())
    buffer.get(bytes)
    val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    val matrix = Matrix().apply {
        postRotate(imageInfo.rotationDegrees.toFloat())
    }
    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
}

@Composable
fun DraggableSelectionOverlay(
    selectionRect: Rect,
    onSelectionChange: (Rect) -> Unit,
    showScanning: Boolean = false,
    modifier: Modifier = Modifier
) {
    // Local state to sync dragging smoothly
    var localRect by remember { mutableStateOf(selectionRect) }
    
    // Update local state when external selectionRect changes (but not during dragging)
    LaunchedEffect(selectionRect) {
        if (selectionRect != localRect) {
            localRect = selectionRect
        }
    }

    val currentOnSelectionChange by rememberUpdatedState(onSelectionChange)
    var touchMode by remember { mutableStateOf<TouchMode>(TouchMode.None) }
    val handleSize = 30.dp
    val edgeThreshold = 30.dp

    val infiniteTransition = rememberInfiniteTransition(label = "scanning")
    val scanLineProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scanLine"
    )

    Canvas(
        modifier = modifier
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset ->
                        val handlePx = handleSize.toPx()
                        val edgePx = edgeThreshold.toPx()
                        touchMode = when {
                            // Corners
                            offset.isNear(localRect.topLeft, handlePx) -> TouchMode.TopLeft
                            offset.isNear(localRect.topRight, handlePx) -> TouchMode.TopRight
                            offset.isNear(localRect.bottomLeft, handlePx) -> TouchMode.BottomLeft
                            offset.isNear(localRect.bottomRight, handlePx) -> TouchMode.BottomRight
                            // Edges
                            offset.y in (localRect.top - edgePx)..(localRect.top + edgePx) && 
                                offset.x in localRect.left..localRect.right -> TouchMode.Top
                            offset.y in (localRect.bottom - edgePx)..(localRect.bottom + edgePx) && 
                                offset.x in localRect.left..localRect.right -> TouchMode.Bottom
                            offset.x in (localRect.left - edgePx)..(localRect.left + edgePx) && 
                                offset.y in localRect.top..localRect.bottom -> TouchMode.Left
                            offset.x in (localRect.right - edgePx)..(localRect.right + edgePx) && 
                                offset.y in localRect.top..localRect.bottom -> TouchMode.Right
                            // Inside
                            localRect.contains(offset) -> TouchMode.Move
                            else -> TouchMode.None
                        }
                    },
                    onDrag = { change, dragAmount ->
                        change.consume()
                        val newRect = when (touchMode) {
                            TouchMode.Move -> localRect.translate(dragAmount)
                            TouchMode.TopLeft -> localRect.copy(left = localRect.left + dragAmount.x, top = localRect.top + dragAmount.y)
                            TouchMode.TopRight -> localRect.copy(right = localRect.right + dragAmount.x, top = localRect.top + dragAmount.y)
                            TouchMode.BottomLeft -> localRect.copy(left = localRect.left + dragAmount.x, bottom = localRect.bottom + dragAmount.y)
                            TouchMode.BottomRight -> localRect.copy(right = localRect.right + dragAmount.x, bottom = localRect.bottom + dragAmount.y)
                            TouchMode.Top -> localRect.copy(top = localRect.top + dragAmount.y)
                            TouchMode.Bottom -> localRect.copy(bottom = localRect.bottom + dragAmount.y)
                            TouchMode.Left -> localRect.copy(left = localRect.left + dragAmount.x)
                            TouchMode.Right -> localRect.copy(right = localRect.right + dragAmount.x)
                            else -> localRect
                        }
                        
                        // Limit minimum size and keep in bounds (loosely)
                        if (newRect.width > 200f && newRect.height > 100f) {
                            localRect = newRect
                            currentOnSelectionChange(newRect)
                        }
                    },
                    onDragEnd = { touchMode = TouchMode.None }
                )
            }
    ) {
        // Dim background outside
        with(drawContext.canvas.nativeCanvas) {
            val check = saveLayer(null, null)
            drawRect(Color.Black.copy(alpha = 0.4f)) // Softer dimming
            drawRoundRect(
                color = Color.Transparent,
                topLeft = localRect.topLeft,
                size = localRect.size,
                cornerRadius = CornerRadius(24.dp.toPx(), 24.dp.toPx()), // More rounded
                blendMode = BlendMode.Clear
            )
            restoreToCount(check)
        }

        // Draw selection border
        drawRoundRect(
            color = SageGreen,
            topLeft = localRect.topLeft,
            size = localRect.size,
            cornerRadius = CornerRadius(24.dp.toPx(), 24.dp.toPx()),
            style = Stroke(width = 2.dp.toPx()) // Slightly thinner, more delicate
        )

        // Draw scanning line
        if (showScanning) {
            val currentLineY = localRect.top + (localRect.height * scanLineProgress)
            val scanColor = SageGreen.copy(alpha = 0.8f)
            
            drawLine(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Transparent, scanColor, Color.Transparent)
                ),
                start = Offset(localRect.left + 10.dp.toPx(), currentLineY),
                end = Offset(localRect.right - 10.dp.toPx(), currentLineY),
                strokeWidth = 2.dp.toPx()
            )
            
            // Glow effect
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(scanColor.copy(alpha = 0.3f), Color.Transparent),
                    startY = currentLineY,
                    endY = currentLineY + 40.dp.toPx()
                ),
                topLeft = Offset(localRect.left, currentLineY),
                size = Size(localRect.width, 40.dp.toPx())
            )
        }

        // Draw corner handles
        val handleLength = 20.dp.toPx()
        val handleStroke = 4.dp.toPx()
        
        // Top-Left
        drawCorner(localRect.topLeft, handleLength, handleStroke, type = 0)
        // Top-Right
        drawCorner(Offset(localRect.right, localRect.top), handleLength, handleStroke, type = 1)
        // Bottom-Left
        drawCorner(Offset(localRect.left, localRect.bottom), handleLength, handleStroke, type = 2)
        // Bottom-Right
        drawCorner(localRect.bottomRight, handleLength, handleStroke, type = 3)
    }
}

// ... rest of implementation (omitted for brevity)

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawCorner(
    pos: Offset,
    len: Float,
    stroke: Float,
    type: Int
) {
    val horizontal = when(type) {
        0, 2 -> Offset(pos.x + len, pos.y)
        1, 3 -> Offset(pos.x - len, pos.y)
        else -> pos
    }
    val vertical = when(type) {
        0, 1 -> Offset(pos.x, pos.y + len)
        2, 3 -> Offset(pos.x, pos.y - len)
        else -> pos
    }
    
    drawLine(SageGreen, pos, horizontal, stroke, cap = StrokeCap.Round)
    drawLine(SageGreen, pos, vertical, stroke, cap = StrokeCap.Round)
}

private fun Offset.isNear(target: Offset, threshold: Float): Boolean {
    return (this - target).getDistance() < threshold
}

enum class TouchMode {
    None, Move, TopLeft, TopRight, BottomLeft, BottomRight, Top, Bottom, Left, Right
}

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
import com.example.insight.ui.theme.AetherTeal
import com.example.insight.ui.theme.DeepVoid
import com.example.insight.ui.theme.LunarFrost
import com.example.insight.ui.theme.OrchidMist

@Composable
fun CameraCaptureScreen(
    onImageCaptured: (ImageProxy) -> Unit,
    onError: (ImageCaptureException) -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var cameraProvider by remember { mutableStateOf<ProcessCameraProvider?>(null) }
    val imageCapture = remember { ImageCapture.Builder().build() }

    // selectionRect in pixels relative to the Box
    var selectionRect by remember { mutableStateOf<Rect?>(null) }

    LaunchedEffect(cameraProviderFuture) {
        cameraProvider = cameraProviderFuture.get()
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val screenWidth = constraints.maxWidth.toFloat()
        val screenHeight = constraints.maxHeight.toFloat()

        // Initialize selectionRect in center
        if (selectionRect == null) {
            val rectWidth = screenWidth * 0.8f
            val rectHeight = screenHeight * 0.4f
            selectionRect = Rect(
                offset = Offset((screenWidth - rectWidth) / 2, (screenHeight - rectHeight) / 2),
                size = Size(rectWidth, rectHeight)
            )
        }

        if (cameraProvider != null) {
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
                        Log.e("CameraCapture", "Use case binding failed", exc)
                        try {
                            cameraProvider?.bindToLifecycle(
                                lifecycleOwner,
                                CameraSelector.DEFAULT_FRONT_CAMERA,
                                preview,
                                imageCapture
                            )
                        } catch (e2: Exception) {
                            Log.e("CameraCapture", "Front camera binding also failed", e2)
                        }
                    }
                }
            )
        } else {
            Box(
                modifier = Modifier.fillMaxSize().background(DeepVoid),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = AetherTeal)
            }
        }

        // 2. Custom Draggable Selection Overlay
        selectionRect?.let { rect ->
            DraggableSelectionOverlay(
                selectionRect = rect,
                onSelectionChange = { selectionRect = it },
                modifier = Modifier.fillMaxSize()
            )
        }

        // 3. UI Controls
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 48.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            IconButton(
                onClick = {
                    imageCapture.takePicture(
                        ContextCompat.getMainExecutor(context),
                        object : ImageCapture.OnImageCapturedCallback() {
                            override fun onCaptureSuccess(image: ImageProxy) {
                                // TODO: Cropping based on selectionRect can be done here or in the caller
                                // For now, pass the image as is, but we could crop it to selectionRect
                                onImageCaptured(image)
                            }
                            override fun onError(exception: ImageCaptureException) {
                                onError(exception)
                            }
                        }
                    )
                },
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(40.dp))
                    .border(2.dp, Color.White, RoundedCornerShape(40.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.PhotoCamera,
                    contentDescription = "Capture",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}

@Composable
fun DraggableSelectionOverlay(
    selectionRect: Rect,
    onSelectionChange: (Rect) -> Unit,
    modifier: Modifier = Modifier
) {
    var touchMode by remember { mutableStateOf<TouchMode>(TouchMode.None) }
    val handleSize = 30.dp
    
    Canvas(
        modifier = modifier
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset ->
                        val handlePx = handleSize.toPx()
                        touchMode = when {
                            // Corners
                            offset.isNear(selectionRect.topLeft, handlePx) -> TouchMode.TopLeft
                            offset.isNear(selectionRect.topRight, handlePx) -> TouchMode.TopRight
                            offset.isNear(selectionRect.bottomLeft, handlePx) -> TouchMode.BottomLeft
                            offset.isNear(selectionRect.bottomRight, handlePx) -> TouchMode.BottomRight
                            // Inside
                            selectionRect.contains(offset) -> TouchMode.Move
                            else -> TouchMode.None
                        }
                    },
                    onDrag = { change, dragAmount ->
                        change.consume()
                        val newRect = when (touchMode) {
                            TouchMode.Move -> selectionRect.translate(dragAmount)
                            TouchMode.TopLeft -> selectionRect.copy(
                                left = selectionRect.left + dragAmount.x,
                                top = selectionRect.top + dragAmount.y
                            )
                            TouchMode.TopRight -> selectionRect.copy(
                                right = selectionRect.right + dragAmount.x,
                                top = selectionRect.top + dragAmount.y
                            )
                            TouchMode.BottomLeft -> selectionRect.copy(
                                left = selectionRect.left + dragAmount.x,
                                bottom = selectionRect.bottom + dragAmount.y
                            )
                            TouchMode.BottomRight -> selectionRect.copy(
                                right = selectionRect.right + dragAmount.x,
                                bottom = selectionRect.bottom + dragAmount.y
                            )
                            else -> selectionRect
                        }
                        
                        // Limit minimum size
                        if (newRect.width > 100f && newRect.height > 100f) {
                            onSelectionChange(newRect)
                        }
                    },
                    onDragEnd = { touchMode = TouchMode.None }
                )
            }
    ) {
        // Dim background outside
        with(drawContext.canvas.nativeCanvas) {
            val check = saveLayer(null, null)
            drawRect(Color.Black.copy(alpha = 0.6f))
            drawRoundRect(
                color = Color.Transparent,
                topLeft = selectionRect.topLeft,
                size = selectionRect.size,
                cornerRadius = CornerRadius(12.dp.toPx(), 12.dp.toPx()),
                blendMode = BlendMode.Clear
            )
            restoreToCount(check)
        }

        // Draw selection border
        drawRoundRect(
            color = AetherTeal,
            topLeft = selectionRect.topLeft,
            size = selectionRect.size,
            cornerRadius = CornerRadius(12.dp.toPx(), 12.dp.toPx()),
            style = Stroke(width = 3.dp.toPx())
        )

        // Draw corner handles
        val handleLength = 20.dp.toPx()
        val handleStroke = 4.dp.toPx()
        
        // Top-Left
        drawCorner(selectionRect.topLeft, handleLength, handleStroke, type = 0)
        // Top-Right
        drawCorner(Offset(selectionRect.right, selectionRect.top), handleLength, handleStroke, type = 1)
        // Bottom-Left
        drawCorner(Offset(selectionRect.left, selectionRect.bottom), handleLength, handleStroke, type = 2)
        // Bottom-Right
        drawCorner(selectionRect.bottomRight, handleLength, handleStroke, type = 3)
    }
}

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
    
    drawLine(AetherTeal, pos, horizontal, stroke)
    drawLine(AetherTeal, pos, vertical, stroke)
}

private fun Offset.isNear(target: Offset, threshold: Float): Boolean {
    return (this - target).getDistance() < threshold
}

enum class TouchMode {
    None, Move, TopLeft, TopRight, BottomLeft, BottomRight
}

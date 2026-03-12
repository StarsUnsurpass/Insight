package com.example.insight.camera

import android.util.Log
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
    val previewView = remember { PreviewView(context) }
    val imageCapture = remember { ImageCapture.Builder().build() }
    val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

    LaunchedEffect(Unit) {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector,
                    preview,
                    imageCapture
                )
            } catch (exc: Exception) {
                Log.e("CameraCapture", "Use case binding failed", exc)
            }
        }, ContextCompat.getMainExecutor(context))
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // 1. Camera Preview
        AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())

        // 2. Custom Scanning Overlay
        ScanningOverlay()

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
fun ScanningOverlay() {
    val infiniteTransition = rememberInfiniteTransition(label = "scanning")
    val scanLineY by infiniteTransition.animateFloat(
        initialValue = 0.25f,
        targetValue = 0.75f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scanLine"
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        val rectWidth = width * 0.8f
        val rectHeight = height * 0.5f
        val left = (width - rectWidth) / 2
        val top = (height - rectHeight) / 2
        val rect = Rect(left, top, left + rectWidth, top + rectHeight)

        // Dim background outside the crop area
        with(drawContext.canvas.nativeCanvas) {
            val check = saveLayer(null, null)
            drawRect(Color.Black.copy(alpha = 0.6f))
            drawRoundRect(
                color = Color.Transparent,
                topLeft = Offset(left, top),
                size = Size(rectWidth, rectHeight),
                cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx()),
                blendMode = BlendMode.Clear
            )
            restoreToCount(check)
        }

        // Draw crop area border
        drawRoundRect(
            color = AetherTeal.copy(alpha = 0.5f),
            topLeft = Offset(left, top),
            size = Size(rectWidth, rectHeight),
            cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx()),
            style = Stroke(width = 2.dp.toPx())
        )

        // Draw scanning line
        val currentLineY = top + (rectHeight * ((scanLineY - 0.25f) / 0.5f))
        drawLine(
            brush = Brush.horizontalGradient(
                colors = listOf(Color.Transparent, AetherTeal, Color.Transparent)
            ),
            start = Offset(left, currentLineY),
            end = Offset(left + rectWidth, currentLineY),
            strokeWidth = 3.dp.toPx()
        )
        
        // Glow effect for scanning line
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(AetherTeal.copy(alpha = 0.2f), Color.Transparent),
                startY = currentLineY,
                endY = currentLineY + 20.dp.toPx()
            ),
            topLeft = Offset(left, currentLineY),
            size = Size(rectWidth, 20.dp.toPx())
        )
    }
}

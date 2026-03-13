package com.example.insight.camera

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.util.Log
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.insight.ui.theme.*
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

    var selectionRect by remember { mutableStateOf<Rect?>(null) }
    var capturedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var isFlashActive by remember { mutableStateOf(false) }
    var scanMode by remember { mutableIntStateOf(0) } // 0: 单题解析, 1: 整页速搜

    LaunchedEffect(cameraProviderFuture) {
        cameraProvider = cameraProviderFuture.get()
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        val screenWidth = constraints.maxWidth.toFloat()
        val screenHeight = constraints.maxHeight.toFloat()

        LaunchedEffect(screenWidth, screenHeight) {
            if (selectionRect == null && screenWidth > 0) {
                val rectWidth = screenWidth * 0.85f
                val rectHeight = screenHeight * 0.4f
                selectionRect = Rect(
                    offset = Offset((screenWidth - rectWidth) / 2, (screenHeight - rectHeight) / 2 - 50f),
                    size = Size(rectWidth, rectHeight)
                )
            }
        }

        // 1. Camera Preview / Background Layer
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

        // 2. Overlay Layer (The Mask & Cutout)
        selectionRect?.let { rect ->
            DraggableSelectionOverlay(
                selectionRect = rect,
                onSelectionChange = { selectionRect = it },
                showScanning = capturedBitmap == null,
                modifier = Modifier.fillMaxSize()
            )
        }

        // 3. Flash Effect
        AnimatedVisibility(
            visible = isFlashActive,
            enter = fadeIn(animationSpec = tween(50)),
            exit = fadeOut(animationSpec = tween(150))
        ) {
            Box(Modifier.fillMaxSize().background(Color.White))
        }

        // 4. Top Tool Bar (Minimal)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Flash Toggle */ }) {
                Icon(Icons.Outlined.FlashAuto, "Flash", tint = Color.White)
            }
            IconButton(onClick = { /* History */ }) {
                Icon(Icons.Outlined.History, "History", tint = Color.White)
            }
        }

        // 5. Bottom Control Panel (The Center Piece)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mode Tabs
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black.copy(alpha = 0.3f))
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("单题解析", "整页速搜").forEachIndexed { index, title ->
                    val isSelected = scanMode == index
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (isSelected) Color.White.copy(alpha = 0.2f) else Color.Transparent)
                            .clickable { scanMode = index }
                            .padding(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = title,
                            color = if (isSelected) Color.White else Color.White.copy(alpha = 0.6f),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Main Control Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Gallery Entrance
                IconButton(
                    onClick = { /* Gallery */ },
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.White.copy(alpha = 0.15f), CircleShape)
                        .border(1.dp, Color.White.copy(alpha = 0.2f), CircleShape)
                ) {
                    Icon(Icons.Outlined.PhotoLibrary, "Gallery", tint = Color.White)
                }

                // Shutter Button
                ShutterButton(
                    onClick = {
                        isFlashActive = true
                        imageCapture.takePicture(
                            ContextCompat.getMainExecutor(context),
                            object : ImageCapture.OnImageCapturedCallback() {
                                override fun onCaptureSuccess(image: ImageProxy) {
                                    capturedBitmap = image.toRotatedBitmap()
                                    image.close()
                                    isFlashActive = false
                                    // Trigger navigation to solution
                                    onImageCaptured(null)
                                }
                                override fun onError(exception: ImageCaptureException) {
                                    onError(exception)
                                    isFlashActive = false
                                }
                            }
                        )
                    }
                )

                // Flash Toggle / Settings
                IconButton(
                    onClick = { /* Settings */ },
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.White.copy(alpha = 0.15f), CircleShape)
                        .border(1.dp, Color.White.copy(alpha = 0.2f), CircleShape)
                ) {
                    Icon(Icons.Outlined.Tune, "Settings", tint = Color.White)
                }
            }
        }
    }
}

@Composable
fun ShutterButton(onClick: () -> Unit) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.88f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow),
        label = "shutterScale"
    )

    val infiniteTransition = rememberInfiniteTransition(label = "shimmer")
    val shimmerProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmerProgress"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(88.dp)
            .scale(scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        try { awaitRelease() } finally { isPressed = false }
                    },
                    onTap = { onClick() }
                )
            }
    ) {
        // Outer shimmering ring
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color.White.copy(alpha = 0.2f),
                style = Stroke(width = 4.dp.toPx())
            )
            drawArc(
                brush = Brush.sweepGradient(
                    colors = listOf(Color.Transparent, SageGreen, Color.Transparent),
                    center = center
                ),
                startAngle = shimmerProgress,
                sweepAngle = 90f,
                useCenter = false,
                style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
            )
        }

        // Inner button
        Box(
            modifier = Modifier
                .size(68.dp)
                .background(Color.White, CircleShape)
                .padding(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(2.dp, InkBlue.copy(alpha = 0.1f), CircleShape)
            )
        }
    }
}

@Composable
fun DraggableSelectionOverlay(
    selectionRect: Rect,
    onSelectionChange: (Rect) -> Unit,
    showScanning: Boolean = false,
    modifier: Modifier = Modifier
) {
    var localRect by remember { mutableStateOf(selectionRect) }

    LaunchedEffect(selectionRect) {
        if (selectionRect != localRect) localRect = selectionRect
    }

    val currentOnSelectionChange by rememberUpdatedState(onSelectionChange)
    var touchMode by remember { mutableStateOf<TouchMode>(TouchMode.None) }
    val handleSize = 40.dp

    val infiniteTransition = rememberInfiniteTransition(label = "scanning")
    val scanLineProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = FastOutSlowInEasing),
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
                        touchMode = when {
                            offset.isNear(localRect.topLeft, handlePx) -> TouchMode.TopLeft
                            offset.isNear(localRect.topRight, handlePx) -> TouchMode.TopRight
                            offset.isNear(localRect.bottomLeft, handlePx) -> TouchMode.BottomLeft
                            offset.isNear(localRect.bottomRight, handlePx) -> TouchMode.BottomRight
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
                            else -> localRect
                        }

                        if (newRect.width > 150f && newRect.height > 80f) {
                            localRect = newRect
                            currentOnSelectionChange(newRect)
                        }
                    },
                    onDragEnd = { touchMode = TouchMode.None }
                )
            }
    ) {
        // 1. Dark Mask with Cutout (Alpha 0.6)
        val path = Path().apply {
            addRect(Rect(0f, 0f, size.width, size.height))
            addRoundRect(
                RoundRect(
                    localRect,
                    CornerRadius(24.dp.toPx(), 24.dp.toPx())
                )
            )
            fillType = PathFillType.EvenOdd
        }
        drawPath(path, color = Color.Black.copy(alpha = 0.6f))

        // 2. Highlighting Selection Border
        drawRoundRect(
            color = Color.White.copy(alpha = 0.8f),
            topLeft = localRect.topLeft,
            size = localRect.size,
            cornerRadius = CornerRadius(24.dp.toPx(), 24.dp.toPx()),
            style = Stroke(width = 1.dp.toPx())
        )

        // 3. Dynamic Scanning Line
        if (showScanning) {
            val currentLineY = localRect.top + (localRect.height * scanLineProgress)
            val scanColor = SageGreen.copy(alpha = 0.9f)

            drawLine(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Transparent, scanColor, Color.Transparent)
                ),
                start = Offset(localRect.left + 8.dp.toPx(), currentLineY),
                end = Offset(localRect.right - 8.dp.toPx(), currentLineY),
                strokeWidth = 2.dp.toPx()
            )

            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(scanColor.copy(alpha = 0.2f), Color.Transparent),
                    startY = currentLineY,
                    endY = currentLineY + 60.dp.toPx()
                ),
                topLeft = Offset(localRect.left, currentLineY),
                size = Size(localRect.width, 60.dp.toPx())
            )
        }

        // 4. Premium Corner Handles
        val len = 24.dp.toPx()
        val thick = 4.dp.toPx()
        val cornerColor = Color.White

        // TL
        drawCorner(localRect.topLeft, len, thick, 0, cornerColor)
        // TR
        drawCorner(Offset(localRect.right, localRect.top), len, thick, 1, cornerColor)
        // BL
        drawCorner(Offset(localRect.left, localRect.bottom), len, thick, 2, cornerColor)
        // BR
        drawCorner(localRect.bottomRight, len, thick, 3, cornerColor)
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawCorner(
    pos: Offset, len: Float, stroke: Float, type: Int, color: Color
) {
    val h = when(type) { 0, 2 -> Offset(pos.x + len, pos.y); else -> Offset(pos.x - len, pos.y) }
    val v = when(type) { 0, 1 -> Offset(pos.x, pos.y + len); else -> Offset(pos.x, pos.y - len) }
    drawLine(color, pos, h, stroke, cap = StrokeCap.Round)
    drawLine(color, pos, v, stroke, cap = StrokeCap.Round)
}

private fun Offset.isNear(target: Offset, threshold: Float) = (this - target).getDistance() < threshold

private fun ImageProxy.toRotatedBitmap(): Bitmap {
    val buffer = planes[0].buffer
    val bytes = ByteArray(buffer.remaining())
    buffer.get(bytes)
    val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    val matrix = Matrix().apply { postRotate(imageInfo.rotationDegrees.toFloat()) }
    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
}

enum class TouchMode { None, Move, TopLeft, TopRight, BottomLeft, BottomRight }


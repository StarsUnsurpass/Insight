package com.example.insight.camera

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.camera.core.*
import androidx.camera.core.ImageCapture.OnImageCapturedCallback
import androidx.camera.view.PreviewView
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.insight.ui.state.UserPreferences
import com.example.insight.util.triggerHaptic
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors
import kotlin.math.abs
import kotlin.math.atan2

enum class CaptureStep { VIEWFINDER, CAPTURED_SHRINK, EDIT_CROP, SCANNING, RESULT_REVEAL, REVIEW_TEXT }

@SuppressLint("UnsafeOptInUsageError")
@Composable
fun CameraCaptureScreen(
    onBack: () -> Unit,
    onImageCaptured: (Bitmap) -> Unit,
    onTextCaptured: (String) -> Unit,
    onError: (ImageCaptureException) -> Unit,
    preferences: UserPreferences = UserPreferences()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val scope = rememberCoroutineScope()
    
    // Camera Components
    val previewView = remember { PreviewView(context) }
    val imageCapture = remember { ImageCapture.Builder().build() }
    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }
    val recognizer = remember { TextRecognition.getClient(ChineseTextRecognizerOptions.Builder().build()) }

    // UI States
    var step by remember { mutableStateOf(CaptureStep.VIEWFINDER) }
    var capturedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var detectedTextBlocks by remember { mutableStateOf<List<Text.TextBlock>>(emptyList()) }
    var fullDetectedText by remember { mutableStateOf("") }
    var isProcessing by remember { mutableStateOf(false) }

    // Crop Selection State (Normalized 0.0 - 1.0)
    var cropRect by remember { mutableStateOf(Rect(0.1f, 0.2f, 0.9f, 0.6f)) }
    
    // Leveler State
    var roll by remember { mutableFloatStateOf(0f) }
    val sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    val accelerometer = remember { sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) }

    // Animations
    val shrinkScale by animateFloatAsState(
        targetValue = if (step == CaptureStep.VIEWFINDER) 1f else 0.94f,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = Spring.StiffnessLow),
        label = "shrinkScale"
    )
    val scanProgress = remember { Animatable(0f) }
    val auraAlpha = remember { Animatable(0f) }
    
    // Flowing Aura Animation
    val auraFlow = rememberInfiniteTransition(label = "auraFlow").animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(3000, easing = LinearEasing)),
        label = "auraFlow"
    )

    // Sensor Listener for Leveler
    DisposableEffect(Unit) {
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                    val x = event.values[0]
                    val y = event.values[1]
                    roll = Math.toDegrees(atan2(x.toDouble(), y.toDouble())).toFloat()
                }
            }
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }
        sensorManager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_UI)
        onDispose { sensorManager.unregisterListener(listener) }
    }

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

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val primaryColor = MaterialTheme.colorScheme.primary

        // 1. Immersive Layer (Viewfinder or Shrunk Preview)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .scale(shrinkScale)
                .clip(RoundedCornerShape(if (step == CaptureStep.VIEWFINDER) 0.dp else 24.dp))
                .background(Color.DarkGray)
        ) {
            if (step == CaptureStep.VIEWFINDER) {
                AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())
            } else {
                capturedBitmap?.let { bitmap ->
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        colorFilter = if (step == CaptureStep.RESULT_REVEAL || step == CaptureStep.REVIEW_TEXT) 
                            ColorFilter.tint(Color.Black.copy(alpha = 0.6f), BlendMode.Darken) else null
                    )
                }
            }
        }

        // 2. Crop Selection UI (Manual Adjustment with Gestures)
        if (step == CaptureStep.EDIT_CROP) {
            val density = androidx.compose.ui.platform.LocalDensity.current
            val layoutWidthPx = with(density) { maxWidth.toPx() }
            val layoutHeightPx = with(density) { maxHeight.toPx() }

            Box(modifier = Modifier
                .fillMaxSize()
                .scale(shrinkScale)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        val sensitivityX = 1f / layoutWidthPx
                        val sensitivityY = 1f / layoutHeightPx
                        
                        val touchX = change.position.x / layoutWidthPx
                        val touchY = change.position.y / layoutHeightPx
                        
                        // 1. 判断触摸区域
                        val edgeThreshold = 0.15f // 增大边缘判定范围，让调整大小更容易
                        val isLeft = abs(touchX - cropRect.left) < edgeThreshold
                        val isRight = abs(touchX - cropRect.right) < edgeThreshold
                        val isTop = abs(touchY - cropRect.top) < edgeThreshold
                        val isBottom = abs(touchY - cropRect.bottom) < edgeThreshold
                        
                        // 判定是否在中间区域：不在任何边缘，且在框内
                        val isMiddle = !isLeft && !isRight && !isTop && !isBottom &&
                                       touchX > cropRect.left && touchX < cropRect.right &&
                                       touchY > cropRect.top && touchY < cropRect.bottom

                        if (isMiddle) {
                            // 整体移动：计算偏移量并应用到所有边界
                            val deltaX = dragAmount.x * sensitivityX
                            val deltaY = dragAmount.y * sensitivityY
                            
                            val width = cropRect.right - cropRect.left
                            val height = cropRect.bottom - cropRect.top
                            
                            // 限制范围，防止框体划出屏幕
                            val newLeft = (cropRect.left + deltaX).coerceIn(0f, 1f - width)
                            val newTop = (cropRect.top + deltaY).coerceIn(0f, 1f - height)
                            
                            cropRect = Rect(
                                left = newLeft,
                                top = newTop,
                                right = newLeft + width,
                                bottom = newTop + height
                            )
                        } else {
                            // 边界调整逻辑保持，但加入限制防止框体反向
                            val newLeft = if (isLeft) (cropRect.left + dragAmount.x * sensitivityX).coerceIn(0f, cropRect.right - 0.05f) else cropRect.left
                            val newTop = if (isTop) (cropRect.top + dragAmount.y * sensitivityY).coerceIn(0f, cropRect.bottom - 0.05f) else cropRect.top
                            val newRight = if (isRight) (cropRect.right + dragAmount.x * sensitivityX).coerceIn(cropRect.left + 0.05f, 1f) else cropRect.right
                            val newBottom = if (isBottom) (cropRect.bottom + dragAmount.y * sensitivityY).coerceIn(cropRect.top + 0.05f, 1f) else cropRect.bottom
                            
                            cropRect = Rect(newLeft, newTop, newRight, newBottom)
                        }
                    }
                }
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    // 遮罩层逻辑保持不变...
                    val strokeWidth = 2.dp.toPx()
                    val path = Path().apply {
                        fillType = PathFillType.EvenOdd
                        addRect(Rect(Offset.Zero, size))
                        addRoundRect(RoundRect(
                            left = cropRect.left * size.width,
                            top = cropRect.top * size.height,
                            right = cropRect.right * size.width,
                            bottom = cropRect.bottom * size.height,
                            cornerRadius = CornerRadius(12.dp.toPx())
                        ))
                    }
                    drawPath(path, Color.Black.copy(alpha = 0.7f))
                    
                    // 绘制选区边框...
                    drawRoundRect(
                        color = primaryColor,
                        topLeft = Offset(cropRect.left * size.width, cropRect.top * size.height),
                        size = Size((cropRect.right - cropRect.left) * size.width, (cropRect.bottom - cropRect.top) * size.height),
                        cornerRadius = CornerRadius(12.dp.toPx()),
                        style = Stroke(strokeWidth)
                    )
                    
                    // 绘制装饰角标...
                    val handleLen = 20.dp.toPx()
                    val corners = listOf(
                        Offset(cropRect.left * size.width, cropRect.top * size.height),
                        Offset(cropRect.right * size.width, cropRect.top * size.height),
                        Offset(cropRect.left * size.width, cropRect.bottom * size.height),
                        Offset(cropRect.right * size.width, cropRect.bottom * size.height)
                    )
                    corners.forEachIndexed { index, point ->
                        drawCircle(Color.White, radius = 6.dp.toPx(), center = point)
                        val pathL = Path().apply {
                            when(index) {
                                0 -> { moveTo(point.x + handleLen, point.y); lineTo(point.x, point.y); lineTo(point.x, point.y + handleLen) }
                                1 -> { moveTo(point.x - handleLen, point.y); lineTo(point.x, point.y); lineTo(point.x, point.y + handleLen) }
                                2 -> { moveTo(point.x + handleLen, point.y); lineTo(point.x, point.y); lineTo(point.x, point.y - handleLen) }
                                3 -> { moveTo(point.x - handleLen, point.y); lineTo(point.x, point.y); lineTo(point.x, point.y - handleLen) }
                            }
                        }
                        drawPath(pathL, Color.White, style = Stroke(3.dp.toPx()))
                    }
                }
            }
        }
// ... 此处逻辑稍后更新 OCR 裁剪部分 ...


        // 3. Volumetric Scan Animation Layer (Scanning Only Selection)
        if (step == CaptureStep.SCANNING) {
            Canvas(modifier = Modifier.fillMaxSize().scale(shrinkScale)) {
                val left = cropRect.left * size.width
                val right = cropRect.right * size.width
                val top = cropRect.top * size.height
                val bottom = cropRect.bottom * size.height
                
                val currentY = top + (bottom - top) * scanProgress.value
                val sweepHeight = 120.dp.toPx()
                
                clipRect(left, top, right, bottom) {
                    // Holographic sweep
                    drawRect(
                        brush = Brush.verticalGradient(
                            0f to Color.Transparent,
                            0.7f to primaryColor.copy(alpha = 0.1f),
                            0.9f to primaryColor.copy(alpha = 0.4f),
                            1f to Color.White.copy(alpha = 0.7f)
                        ),
                        topLeft = Offset(left, currentY - sweepHeight),
                        size = Size(right - left, sweepHeight)
                    )
                    
                    // Laser Blade
                    drawLine(
                        color = Color.White,
                        start = Offset(left, currentY),
                        end = Offset(right, currentY),
                        strokeWidth = 3.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                    
                    // Side Glow
                    drawRect(
                        color = primaryColor.copy(alpha = 0.05f),
                        topLeft = Offset(left, top),
                        size = Size(right - left, currentY - top)
                    )
                }
            }
        }

        // 4. Flowing Aura Layer (Text Reveal)
        if (step == CaptureStep.RESULT_REVEAL) {
            Canvas(modifier = Modifier.fillMaxSize().scale(shrinkScale)) {
                detectedTextBlocks.forEach { block ->
                    val rect = block.boundingBox?.toComposeRect() ?: return@forEach
                    val scaleX = size.width / (capturedBitmap?.width ?: 1)
                    val scaleY = size.height / (capturedBitmap?.height ?: 1)
                    val mappedRect = Rect(rect.left * scaleX, rect.top * scaleY, rect.right * scaleX, rect.bottom * scaleY).inflate(4.dp.toPx())

                    if (cropRect.contains(Offset(mappedRect.center.x / size.width, mappedRect.center.y / size.height))) {
                        drawRoundRect(
                            color = primaryColor.copy(alpha = 0.2f * auraAlpha.value),
                            topLeft = mappedRect.topLeft,
                            size = mappedRect.size,
                            cornerRadius = CornerRadius(6.dp.toPx())
                        )
                        drawRoundRect(
                            color = Color.White.copy(alpha = 0.4f * auraAlpha.value),
                            topLeft = mappedRect.topLeft,
                            size = mappedRect.size,
                            cornerRadius = CornerRadius(6.dp.toPx()),
                            style = Stroke(1.dp.toPx())
                        )
                    }
                }
            }
        }

        // 5. Header
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(Color.Black.copy(alpha = 0.4f))
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.Close, null, tint = Color.White)
            }
            Text(
                text = when(step) {
                    CaptureStep.VIEWFINDER -> "准备拍摄"
                    CaptureStep.EDIT_CROP -> "调整选区"
                    CaptureStep.SCANNING -> "智能扫描"
                    CaptureStep.RESULT_REVEAL -> "识别完成"
                    else -> "预览结果"
                },
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = {}) { Icon(Icons.Default.FlashOff, null, tint = Color.White) }
        }

        // 6. Footer Controls
        Box(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 60.dp).fillMaxWidth()
        ) {
            when(step) {
                CaptureStep.VIEWFINDER -> {
                    // Shutter
                    Box(
                        modifier = Modifier.size(80.dp).align(Alignment.Center).clickable {
                            if (isProcessing) return@clickable
                            isProcessing = true
                            triggerHaptic(preferences, context)
                            imageCapture.takePicture(cameraExecutor, object : OnImageCapturedCallback() {
                                override fun onCaptureSuccess(image: ImageProxy) {
                                    val original = image.toBitmapCompat()
                                    capturedBitmap = rotateBitmap(original, image.imageInfo.rotationDegrees)
                                    image.close()
                                    scope.launch {
                                        step = CaptureStep.CAPTURED_SHRINK
                                        delay(400)
                                        step = CaptureStep.EDIT_CROP
                                        isProcessing = false
                                    }
                                }
                                override fun onError(exception: ImageCaptureException) { isProcessing = false }
                            })
                        }
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawCircle(Color.White, radius = size.minDimension / 2, style = Stroke(3.dp.toPx()))
                            drawCircle(primaryColor, radius = size.minDimension / 2 - 8.dp.toPx())
                        }
                    }
                }
                CaptureStep.EDIT_CROP -> {
                    Button(
                        onClick = {
                            scope.launch {
                                val bitmap = capturedBitmap ?: return@launch
                                step = CaptureStep.SCANNING
                                
                                // 开启扫描线动画
                                scanProgress.animateTo(1f, tween(1500, easing = LinearOutSlowInEasing))
                                
                                // 根据 cropRect (0-1) 计算物理裁剪坐标
                                val left = (cropRect.left * bitmap.width).toInt().coerceIn(0, bitmap.width - 1)
                                val top = (cropRect.top * bitmap.height).toInt().coerceIn(0, bitmap.height - 1)
                                val width = ((cropRect.right - cropRect.left) * bitmap.width).toInt().coerceIn(1, bitmap.width - left)
                                val height = ((cropRect.bottom - cropRect.top) * bitmap.height).toInt().coerceIn(1, bitmap.height - top)
                                
                                // 执行物理裁剪，仅识别框选区域
                                val croppedBitmap = Bitmap.createBitmap(bitmap, left, top, width, height)
                                
                                val inputImage = InputImage.fromBitmap(croppedBitmap, 0)
                                recognizer.process(inputImage).addOnSuccessListener { visionText ->
                                    detectedTextBlocks = visionText.textBlocks
                                    fullDetectedText = visionText.text
                                    scope.launch {
                                        step = CaptureStep.RESULT_REVEAL
                                        auraAlpha.animateTo(1f, tween(500))
                                        delay(1000)
                                        step = CaptureStep.REVIEW_TEXT
                                    }
                                }
                            }
                        },
                        modifier = Modifier.align(Alignment.Center).height(56.dp).padding(horizontal = 32.dp),
                        shape = RoundedCornerShape(28.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                    ) {
                        Icon(Icons.Default.QrCodeScanner, null)
                        Spacer(Modifier.width(8.dp))
                        Text("开始扫描区域", fontWeight = FontWeight.Bold)
                    }
                }
                else -> {}
            }
        }

        // 7. Review Text Sheet (Bottom Sheet Style)
        if (step == CaptureStep.REVIEW_TEXT) {
            Box(
                modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.4f)),
                contentAlignment = Alignment.BottomCenter
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f),
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Article, null, tint = primaryColor)
                            Spacer(Modifier.width(8.dp))
                            Text("核对文字内容", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        }
                        
                        Spacer(Modifier.height(16.dp))
                        
                        Box(
                            modifier = Modifier.weight(1f).fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                                .padding(16.dp)
                                .verticalScroll(rememberScrollState())
                        ) {
                            Text(text = fullDetectedText, style = MaterialTheme.typography.bodyMedium)
                        }
                        
                        Spacer(Modifier.height(24.dp))
                        
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            OutlinedButton(
                                onClick = { step = CaptureStep.EDIT_CROP },
                                modifier = Modifier.weight(1f).height(56.dp),
                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Text("重选区域")
                            }
                            Button(
                                onClick = { onTextCaptured(fullDetectedText) },
                                modifier = Modifier.weight(1f).height(56.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                            ) {
                                Text("开始 AI 深度解析", fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun android.graphics.Rect.toComposeRect(): Rect {
    return Rect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
}

private fun rotateBitmap(source: Bitmap, angle: Int): Bitmap {
    val matrix = Matrix().apply { postRotate(angle.toFloat()) }
    return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
}

private fun ImageProxy.toBitmapCompat(): Bitmap {
    val buffer = planes[0].buffer
    val bytes = ByteArray(buffer.remaining())
    buffer.get(bytes)
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}

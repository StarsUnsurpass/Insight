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
import androidx.compose.ui.graphics.drawscope.Stroke
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

enum class CaptureStep { VIEWFINDER, CAPTURED_SHRINK, SCANNING, RESULT_REVEAL, EDIT_CROP }

@SuppressLint("UnsafeOptInUsageError")
@Composable
fun CameraCaptureScreen(
    onBack: () -> Unit,
    onImageCaptured: (Bitmap) -> Unit,
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
    var isProcessing by remember { mutableStateOf(false) }
    
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
                        colorFilter = if (step == CaptureStep.RESULT_REVEAL || step == CaptureStep.EDIT_CROP) 
                            ColorFilter.tint(Color.Black.copy(alpha = 0.4f), BlendMode.Darken) else null
                    )
                }
            }
        }

        // 2. Volumetric Scan Animation Layer
        if (step == CaptureStep.SCANNING) {
            Canvas(modifier = Modifier.fillMaxSize().scale(shrinkScale).clip(RoundedCornerShape(24.dp))) {
                val y = scanProgress.value * size.height
                val sweepHeight = 160.dp.toPx()
                
                // Holographic sweep (Volumetric Light)
                drawRect(
                    brush = Brush.verticalGradient(
                        0f to Color.Transparent,
                        0.6f to primaryColor.copy(alpha = 0.2f),
                        0.95f to primaryColor.copy(alpha = 0.5f),
                        1f to Color.White.copy(alpha = 0.8f)
                    ),
                    topLeft = Offset(0f, y - sweepHeight),
                    size = Size(size.width, sweepHeight)
                )
                
                // Sharp Light Blade
                drawLine(
                    color = Color.White,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = 2.dp.toPx()
                )
            }
        }

        // 3. Flowing Aura Layer (Text Reveal)
        if (step == CaptureStep.RESULT_REVEAL || step == CaptureStep.EDIT_CROP) {
            Canvas(modifier = Modifier.fillMaxSize().scale(shrinkScale).clip(RoundedCornerShape(24.dp))) {
                detectedTextBlocks.forEach { block ->
                    val rect = block.boundingBox?.toComposeRect() ?: return@forEach
                    
                    // coordinate mapping (simple version for full screen crop)
                    val scaleX = size.width / (capturedBitmap?.width ?: 1)
                    val scaleY = size.height / (capturedBitmap?.height ?: 1)
                    val mappedRect = Rect(
                        rect.left * scaleX, rect.top * scaleY,
                        rect.right * scaleX, rect.bottom * scaleY
                    ).inflate(6.dp.toPx())

                    val path = Path().apply { addRoundRect(RoundRect(mappedRect, CornerRadius(8.dp.toPx()))) }
                    
                    // 1. Background Glow
                    drawPath(
                        path = path,
                        color = primaryColor.copy(alpha = 0.15f * auraAlpha.value),
                        style = Stroke(width = 8.dp.toPx())
                    )
                    
                    // 2. Flowing Path (Aura)
                    val pathMeasure = android.graphics.PathMeasure(path.asAndroidPath(), false)
                    val length = pathMeasure.length
                    val segmentLength = length * 0.4f
                    val currentPos = length * auraFlow.value
                    
                    val segmentPath = android.graphics.Path()
                    pathMeasure.getSegment(currentPos, (currentPos + segmentLength) % length, segmentPath, true)
                    if (currentPos + segmentLength > length) {
                        pathMeasure.getSegment(0f, (currentPos + segmentLength) % length, segmentPath, true)
                    }

                    drawPath(
                        path = segmentPath.asComposePath(),
                        brush = Brush.linearGradient(
                            listOf(primaryColor.copy(alpha = 0f), primaryColor, Color.White, primaryColor, primaryColor.copy(alpha = 0f)),
                            start = Offset(mappedRect.left, mappedRect.top),
                            end = Offset(mappedRect.right, mappedRect.bottom)
                        ),
                        style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
                    )
                    
                    // 3. Highlight text area
                    drawRoundRect(
                        color = Color.White.copy(alpha = 0.05f * auraAlpha.value),
                        topLeft = mappedRect.topLeft,
                        size = mappedRect.size,
                        cornerRadius = CornerRadius(8.dp.toPx()),
                        blendMode = BlendMode.Screen
                    )
                }
            }
        }

        // 4. Smart Leveler
        if (step == CaptureStep.VIEWFINDER) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Canvas(modifier = Modifier.size(180.dp)) {
                    val isLevel = abs(roll) < 0.8f || abs(roll - 180) < 0.8f || abs(roll + 180) < 0.8f
                    val color = if (isLevel) Color(0xFF81C784) else Color.White.copy(alpha = 0.4f)
                    
                    // Crosshair
                    drawLine(color, Offset(size.width/2 - 15, size.height/2), Offset(size.width/2 + 15, size.height/2), 1.5.dp.toPx())
                    drawLine(color, Offset(size.width/2, size.height/2 - 15), Offset(size.width/2, size.height/2 + 15), 1.5.dp.toPx())
                    
                    // Level Line
                    withTransform({
                        rotate(degrees = -roll, pivot = center)
                    }) {
                        drawLine(color, Offset(size.width/2 - 50, size.height/2), Offset(size.width/2 + 50, size.height/2), 2.dp.toPx())
                    }
                    
                    if (isLevel) {
                        drawCircle(color.copy(alpha = 0.1f), radius = 30.dp.toPx(), center = center)
                    }
                }
            }
        }

        // 5. Header (Glassmorphism)
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(Color.White.copy(alpha = 0.1f))
                .border(0.5.dp, Color.White.copy(alpha = 0.2f), RoundedCornerShape(28.dp))
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, null, tint = Color.White)
            }
            Text(
                text = when(step) {
                    CaptureStep.VIEWFINDER -> "准备拍摄"
                    CaptureStep.SCANNING -> "智能解析中"
                    else -> "识别完成"
                },
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            IconButton(onClick = { /* Flash control could go here */ }) {
                Icon(Icons.Default.FlashOn, null, tint = Color.White)
            }
        }

        // 6. Footer Controls
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp)
                .fillMaxWidth()
        ) {
            if (step == CaptureStep.VIEWFINDER) {
                // Professional Bionic Shutter
                Box(
                    modifier = Modifier
                        .size(88.dp)
                        .align(Alignment.Center)
                        .clickable {
                            if (isProcessing) return@clickable
                            isProcessing = true
                            triggerHaptic(preferences, context)
                            
                            imageCapture.takePicture(cameraExecutor, object : OnImageCapturedCallback() {
                                override fun onCaptureSuccess(image: ImageProxy) {
                                    scope.launch {
                                        val original = image.toBitmapCompat()
                                        capturedBitmap = rotateBitmap(original, image.imageInfo.rotationDegrees)
                                        image.close()
                                        step = CaptureStep.CAPTURED_SHRINK
                                        delay(400)
                                        
                                        // Start Scanning Animation
                                        step = CaptureStep.SCANNING
                                        scanProgress.animateTo(1f, tween(1800, easing = LinearOutSlowInEasing))
                                        
                                        // Run AI Recognition
                                        val inputImage = InputImage.fromBitmap(capturedBitmap!!, 0)
                                        recognizer.process(inputImage)
                                            .addOnSuccessListener { visionText ->
                                                detectedTextBlocks = visionText.textBlocks
                                                step = CaptureStep.RESULT_REVEAL
                                                scope.launch {
                                                    // Haptic sequence for "awakening"
                                                    repeat(3) {
                                                        triggerHaptic(preferences, context)
                                                        delay(100)
                                                    }
                                                    auraAlpha.animateTo(1f, tween(800))
                                                }
                                            }
                                        isProcessing = false
                                    }
                                }
                                override fun onError(exception: ImageCaptureException) {
                                    onError(exception)
                                    isProcessing = false
                                }
                            })
                        }
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCircle(Color.White.copy(alpha = 0.2f), radius = size.minDimension / 2)
                        drawCircle(Color.White, radius = size.minDimension / 2 - 4.dp.toPx(), style = Stroke(2.dp.toPx()))
                        drawCircle(primaryColor, radius = size.minDimension / 2 - 12.dp.toPx())
                    }
                }
            } else if (step == CaptureStep.RESULT_REVEAL) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { 
                            step = CaptureStep.VIEWFINDER
                            capturedBitmap = null
                            scope.launch { scanProgress.snapTo(0f); auraAlpha.snapTo(0f) }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.15f)),
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier.height(48.dp).weight(1f)
                    ) {
                        Icon(Icons.Default.Refresh, null, tint = Color.White)
                        Spacer(Modifier.width(8.dp))
                        Text("重拍", color = Color.White)
                    }
                    
                    Spacer(Modifier.width(16.dp))
                    
                    Button(
                        onClick = { capturedBitmap?.let { onImageCaptured(it) } },
                        colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier.height(48.dp).weight(1f),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
                    ) {
                        Icon(Icons.Default.Check, null)
                        Spacer(Modifier.width(8.dp))
                        Text("确认文字", fontWeight = FontWeight.Bold)
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

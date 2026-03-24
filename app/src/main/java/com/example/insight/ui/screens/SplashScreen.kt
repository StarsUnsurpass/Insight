package com.example.insight.ui.screens

import android.os.Build
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs

@Composable
fun SplashScreen(onAnimationFinished: () -> Unit) {
    val haptic = LocalHapticFeedback.current
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    val textMeasurer = rememberTextMeasurer()
    
    val screenWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }
    
    val textStyle = TextStyle(
        fontSize = 68.sp,
        fontWeight = FontWeight.W600,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Serif,
        letterSpacing = 1.sp,
        color = Color(0xFF1A2980) 
    )
    
    val textLayoutResult = remember { textMeasurer.measure("nsight", textStyle) }
    
    // --- 核心坐标系统 ---
    val baseY = screenHeightPx / 2f + with(density) { 30.dp.toPx() }
    val wordStartX = (screenWidthPx - textLayoutResult.size.width) / 2f + with(density){ 8.dp.toPx() }
    
    // 计算首字母 i (小写) 的竖线位置
    val iStemX = wordStartX - with(density) { 14.dp.toPx() } // 与后续 nsight 间距调整
    val iStemHeight = with(density) { 32.dp.toPx() } // x-height
    val iStemTopY = baseY - iStemHeight
    val dotRadius = with(density) { 5.dp.toPx() }
    val stemWidth = with(density) { 7.dp.toPx() }
    
    // --- 动画状态 ---
    val dot1DropY = remember { Animatable(baseY - 600f) }
    val dot1X = remember { Animatable(iStemX - 150f) }
    val squashX = remember { Animatable(1f) }
    val squashY = remember { Animatable(1f) }
    
    val traceProgress = remember { Animatable(0f) }
    val dot1Alpha = remember { Animatable(1f) }
    
    val dot2DropY = remember { Animatable(baseY - 800f) }
    val dot2Alpha = remember { Animatable(0f) }
    
    val stemBend = remember { Animatable(0f) }
    val dot2Bounce = remember { Animatable(0f) }
    
    val shimmerProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        // ACT 1: 点1坠落
        launch { dot1X.animateTo(iStemX, tween(650, easing = LinearOutSlowInEasing)) }
        dot1DropY.animateTo(baseY, tween(650, easing = CubicBezierEasing(0.42f, 0f, 1f, 1f)))
        haptic.performHapticFeedback(HapticFeedbackType.LongPress) 
        
        launch { squashX.animateTo(2.4f, tween(100, easing = FastOutSlowInEasing)) }
        squashY.animateTo(0.25f, tween(100, easing = FastOutSlowInEasing))
        
        launch { squashX.animateTo(1f, spring(dampingRatio = 0.5f, stiffness = 400f)) }
        squashY.animateTo(1f, spring(dampingRatio = 0.5f, stiffness = 400f))
        
        // 画首个小写的 i 竖线
        dot1DropY.animateTo(iStemTopY, tween(250, easing = FastOutSlowInEasing))
        
        // ACT 2: 流光揭示右侧文本 nsight
        val totalDist = textLayoutResult.size.width.toFloat() + 40f
        
        launch {
            traceProgress.animateTo(1f, tween(2400, easing = CubicBezierEasing(0.2f, 0f, 0.2f, 1f)))
        }
        launch {
            // 点1向右划过
            dot1X.animateTo(iStemX + totalDist, tween(2400, easing = CubicBezierEasing(0.2f, 0f, 0.2f, 1f)))
        }
        launch {
            // S型上下震荡，中心线大约在 iStemTopY 和 baseY 之间，模拟运笔
            val midY = baseY - iStemHeight / 2f
            repeat(3) {
                dot1DropY.animateTo(midY - iStemHeight * 0.4f, tween(400, easing = FastOutLinearInEasing))
                dot1DropY.animateTo(midY + iStemHeight * 0.4f, tween(400, easing = LinearOutSlowInEasing))
            }
        }
        
        delay(2200)
        dot1Alpha.animateTo(0f, tween(200))
        delay(300) 
        
        // ACT 3: 第二颗点空降，精准对齐小写 i 的顶部
        dot2Alpha.snapTo(1f)
        val perfectDotY = iStemTopY - with(density) { 14.dp.toPx() } // 黄金比例间距
        
        dot2DropY.animateTo(perfectDotY, tween(500, easing = CubicBezierEasing(0.5f, 0f, 1f, 1f)))
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        
        launch {
            // 物理弯曲
            stemBend.snapTo(with(density) { 12.dp.toPx() }) 
            stemBend.animateTo(0f, spring(dampingRatio = 0.2f, stiffness = 140f))
        }
        launch {
            // 阻尼弹跳
            dot2Bounce.snapTo(with(density) { 8.dp.toPx() }) 
            dot2Bounce.animateTo(0f, spring(dampingRatio = 0.3f, stiffness = 180f))
        }
        
        delay(1400) 
        shimmerProgress.animateTo(1f, tween(1000, easing = FastOutSlowInEasing))
        delay(200)
        onAnimationFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val dotBrush = Brush.linearGradient(
            colors = listOf(Color(0xFF26D0CE), Color(0xFF1A2980)),
            start = Offset(-dotRadius, -dotRadius),
            end = Offset(dotRadius, dotRadius)
        )
        
        fun DrawScope.drawScene(isReflection: Boolean) {
            val reflectionAlpha = if (isReflection) 0.2f else 1f
            val drawColor = textStyle.color.copy(alpha = reflectionAlpha)
            
            // 1. 点1 (划过屏幕的流光点)
            if (dot1Alpha.value > 0f) {
                withTransform({
                    translate(dot1X.value, dot1DropY.value)
                    if (!isReflection) {
                        scale(squashX.value, squashY.value, pivot = Offset(0f, dotRadius))
                    }
                }) {
                    drawCircle(
                        brush = if(isReflection) SolidColor(drawColor) else dotBrush, 
                        radius = dotRadius, 
                        alpha = dot1Alpha.value * reflectionAlpha
                    )
                }
            }
            
            // 2. 小写 i 的竖线 (支持弹性弯曲)
            val currentStemTopX = iStemX + stemBend.value
            val currentStemTopY = iStemTopY + abs(stemBend.value) * 0.15f 
            
            if (traceProgress.value > 0f || dot1DropY.value <= baseY - 5f) {
                val stemPath = Path().apply {
                    moveTo(iStemX, baseY)
                    quadraticBezierTo(
                        x1 = iStemX + stemBend.value * 1.5f, 
                        y1 = baseY - iStemHeight / 2f, 
                        x2 = currentStemTopX, 
                        y2 = currentStemTopY
                    )
                }
                drawPath(
                    path = stemPath,
                    color = drawColor,
                    style = Stroke(width = stemWidth, cap = StrokeCap.Round)
                )
            }
            
            // 3. 右侧标准文本 "nsight" 动态揭示
            if (traceProgress.value > 0f) {
                clipRect(
                    left = wordStartX - 20f,
                    top = -1000f,
                    right = wordStartX + (textLayoutResult.size.width * traceProgress.value),
                    bottom = 1000f
                ) {
                    drawText(
                        textMeasurer = textMeasurer,
                        text = "nsight",
                        topLeft = Offset(wordStartX, baseY - textLayoutResult.firstBaseline),
                        style = textStyle.copy(color = drawColor)
                    )
                }
            }
            
            // 4. 小写 i 上的最终圆点 (第二颗点)
            if (dot2Alpha.value > 0f) {
                val finalDot2X = if (dot2DropY.value >= iStemTopY - 30f) currentStemTopX else iStemX
                val finalDot2Y = dot2DropY.value + dot2Bounce.value
                
                withTransform({ translate(finalDot2X, finalDot2Y) }) {
                    drawCircle(
                        brush = if(isReflection) SolidColor(drawColor) else dotBrush, 
                        radius = dotRadius, 
                        alpha = dot2Alpha.value * reflectionAlpha
                    )
                }
            }
            
            // 5. 高光
            if (!isReflection && shimmerProgress.value > 0f) {
                val glowX = iStemX - 200f + shimmerProgress.value * (textLayoutResult.size.width + 400f)
                withTransform({
                    translate(glowX, baseY - iStemHeight)
                    rotate(20f)
                }) {
                    drawRect(
                        brush = Brush.horizontalGradient(
                            0f to Color.Transparent,
                            0.5f to Color(0xFF26D0CE).copy(alpha = 0.4f),
                            1f to Color.Transparent
                        ),
                        topLeft = Offset(-40f, -100f),
                        size = Size(80f, 300f),
                        blendMode = BlendMode.SrcOver
                    )
                }
            }
        }

        // ==========================================
        // 渲染层 1：玻璃倒影系统
        // ==========================================
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    translationY = 2f 
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        renderEffect = android.graphics.RenderEffect.createBlurEffect(
                            12f, 12f, android.graphics.Shader.TileMode.DECAL
                        ).asComposeRenderEffect()
                    }
                }
        ) {
            withTransform({
                scale(1f, -1f, pivot = Offset(0f, baseY))
            }) {
                val fadeBrush = Brush.verticalGradient(
                    colors = listOf(Color.White, Color.Transparent), 
                    startY = baseY,
                    endY = baseY - with(density){ 30.dp.toPx() } 
                )
                
                // Native saveLayer implementation for Compose
                val rect = Rect(0f, 0f, size.width, size.height)
                val paint = Paint()
                drawContext.canvas.saveLayer(rect, paint)
                
                drawScene(isReflection = true)
                
                drawRect(
                    brush = fadeBrush,
                    blendMode = BlendMode.DstIn // 强力裁剪透明度
                )
                
                drawContext.canvas.restore()
            }
        }
        
        // ==========================================
        // 渲染层 2：实体世界
        // ==========================================
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawScene(isReflection = false)
        }
    }
}
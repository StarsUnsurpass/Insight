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
import androidx.compose.ui.graphics.TileMode
import kotlinx.coroutines.launch
import kotlin.math.*

@Composable
fun SplashScreen(onAnimationFinished: () -> Unit) {
    val haptic = LocalHapticFeedback.current
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    val textMeasurer = rememberTextMeasurer()
    
    val screenWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }
    
    // 终极高饱和方案：通过大幅提升边缘明度，彻底消除“阴影感”，让字母通体明亮、浓郁
    val auroraColors = listOf(
        Color(0xFF00838F), // 边缘色：显著提亮，消除阴影
        Color(0xFF00E5FF), // 核心色：极亮霓虹
        Color(0xFF00E5FF), // 核心色：保持高亮
        Color(0xFF00838F)  // 边缘色：显著提亮，消除阴影
    )
    
    val solidNeon = Color(0xFF00E5FF)
    
    val textStyle = TextStyle(
        fontSize = 72.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Serif,
        letterSpacing = 1.sp,
        color = solidNeon
    )
    
    val textLayoutResult = remember(textStyle) { textMeasurer.measure("nsight", textStyle) }
    
    val baseY = screenHeightPx / 2f + with(density) { 30.dp.toPx() }
    val wordStartX = (screenWidthPx - textLayoutResult.size.width) / 2f + with(density){ 8.dp.toPx() }
    
    // 几何参数回归：极致的点线同轴数学模型
    val iStemX = wordStartX - with(density) { 14.dp.toPx() } 
    val iStemHeight = with(density) { 36.dp.toPx() } 
    val italicSlantOffset = with(density) { 6.dp.toPx() } 
    val slantRate = italicSlantOffset / iStemHeight // 斜率计算核心
    val iStemTopY = baseY - iStemHeight
    val dotRadius = with(density) { 5.dp.toPx() }
    val stemWidth = with(density) { 10.dp.toPx() }
    
    val dotY = remember { Animatable(baseY - 600f) }
    val dotX = remember { Animatable(iStemX - 150f) }
    val squashX = remember { Animatable(1f) }
    val squashY = remember { Animatable(1f) }
    
    var isPinned by remember { mutableStateOf(false) } 
    val traceProgress = remember { Animatable(0f) }
    
    val stemBend = remember { Animatable(0f) }
    val dotBounce = remember { Animatable(0f) }
    val shimmerProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        // 第一幕：坠落
        launch { dotX.animateTo(iStemX, tween(650, easing = LinearOutSlowInEasing)) }
        dotY.animateTo(baseY, tween(650, easing = CubicBezierEasing(0.42f, 0f, 1f, 1f)))
        haptic.performHapticFeedback(HapticFeedbackType.LongPress) 
        
        launch { squashX.animateTo(2.4f, tween(100, easing = FastOutSlowInEasing)) }
        squashY.animateTo(0.25f, tween(100, easing = FastOutSlowInEasing))
        
        launch { squashX.animateTo(1f, spring(dampingRatio = 0.5f, stiffness = 400f)) }
        squashY.animateTo(1f, spring(dampingRatio = 0.5f, stiffness = 400f))
        
        // 第二幕：弹起
        val apexY = iStemTopY - with(density){ 140.dp.toPx() }
        
        launch {
            delay(200)
            traceProgress.animateTo(1f, tween(1200, easing = CubicBezierEasing(0.25f, 0.1f, 0.25f, 1f)))
        }
        
        launch {
            dotX.animateTo(iStemX + italicSlantOffset * 0.5f, tween(900, easing = LinearOutSlowInEasing))
        }
        
        dotY.animateTo(apexY, tween(900, easing = CubicBezierEasing(0.2f, 0f, 0.2f, 1f)))
        
        // 第三幕：落下形成 i
        val perfectDotY = iStemTopY - with(density) { 12.dp.toPx() } 
        dotY.animateTo(perfectDotY, tween(900, easing = CubicBezierEasing(0.5f, 0f, 1f, 1f)))
        isPinned = true
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        
        // 第四幕：弹性谐振
        launch {
            stemBend.snapTo(with(density) { 14.dp.toPx() }) 
            stemBend.animateTo(0f, spring(dampingRatio = 0.2f, stiffness = 140f)) 
        }
        launch {
            dotBounce.snapTo(with(density) { 8.dp.toPx() }) 
            dotBounce.animateTo(0f, spring(dampingRatio = 0.3f, stiffness = 180f)) 
        }
        
        delay(500) 
        shimmerProgress.animateTo(1f, tween(800, easing = FastOutSlowInEasing))
        delay(50)
        onAnimationFinished()
    }

    // 材质垂直渐变：范围紧凑在文字区域，消除采样边缘产生的阴影
    val materialBrush = Brush.verticalGradient(
        colors = auroraColors,
        startY = iStemTopY - with(density){ 10.dp.toPx() }, 
        endY = baseY + with(density){ 10.dp.toPx() }
    )
    
    val materialTextStyle = TextStyle(
        brush = materialBrush,
        fontSize = 72.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Serif,
        letterSpacing = 1.sp
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF001212)) // 固定极暗青背景，强化发光文字的对比度
    ) {
        fun DrawScope.drawScene(isReflection: Boolean) {
            val reflectionAlpha = if (isReflection) 0.12f else 1f
            val reflectionColor = solidNeon.copy(alpha = reflectionAlpha)
            
            // ─── 1. i 竖线 ───
            val drawnStemLength = (baseY - dotY.value).coerceIn(0f, iStemHeight)
            val slantProgress = (drawnStemLength / iStemHeight).coerceIn(0f, 1f)
            val currentSlantX = italicSlantOffset * slantProgress
            
            val currentStemTopX = iStemX + currentSlantX + (if(!isPinned) stemBend.value else 0f)
            val currentStemTopY = baseY - drawnStemLength
            
            if (drawnStemLength > 0f) {
                val stemPath = Path().apply {
                    moveTo(iStemX, baseY)
                    if (isPinned) {
                        quadraticBezierTo(
                            x1 = iStemX + italicSlantOffset * 0.5f + stemBend.value * 1.5f, 
                            y1 = baseY - iStemHeight / 2f, 
                            x2 = iStemX + italicSlantOffset + stemBend.value, 
                            y2 = iStemTopY
                        )
                    } else {
                        lineTo(currentStemTopX, currentStemTopY)
                    }
                }
                if (isReflection) {
                    drawPath(path = stemPath, color = reflectionColor, style = Stroke(width = stemWidth, cap = StrokeCap.Round))
                } else {
                    drawPath(path = stemPath, brush = materialBrush, style = Stroke(width = stemWidth, cap = StrokeCap.Round))
                }
            }
            
            // ─── 2. "nsight" 文本 ───
            if (traceProgress.value > 0f) {
                clipRect(
                    left = wordStartX - 20f,
                    top = 0f, 
                    right = wordStartX + (textLayoutResult.size.width * traceProgress.value),
                    bottom = screenHeightPx * 2.5f 
                ) {
                    if (isReflection) {
                        drawText(
                            textMeasurer = textMeasurer,
                            text = "nsight",
                            topLeft = Offset(wordStartX, baseY - textLayoutResult.firstBaseline),
                            style = textStyle.copy(color = reflectionColor)
                        )
                    } else {
                        drawText(
                            textMeasurer = textMeasurer,
                            text = "nsight",
                            topLeft = Offset(wordStartX, baseY - textLayoutResult.firstBaseline),
                            style = materialTextStyle
                        )
                    }
                }
            }
            
            // ─── 3. 圆点 ───
            val finalDotY = if (isPinned) dotY.value + dotBounce.value else dotY.value
            // 终极修复：使用标准直线斜率方程，确保圆点绝对在竖线的物理延长线上
            val finalDotX = if (isPinned) {
                iStemX + (baseY - finalDotY) * slantRate + stemBend.value
            } else {
                dotX.value
            }
            
            withTransform({
                translate(finalDotX, finalDotY)
                if (!isReflection && !isPinned && dotY.value >= baseY - 5f) {
                    scale(squashX.value, squashY.value, pivot = Offset(0f, dotRadius))
                }
            }) {
                if (isReflection) {
                    drawCircle(color = reflectionColor, radius = dotRadius, center = Offset.Zero)
                } else {
                    // 圆点与整词绝对同步的材质系统
                    drawCircle(brush = materialBrush, radius = dotRadius, center = Offset.Zero)
                    // 球面拟物光感
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(Color.White.copy(alpha = 0.7f), Color.Transparent),
                            center = Offset(-dotRadius * 0.4f, -dotRadius * 0.4f),
                            radius = dotRadius
                        ),
                        radius = dotRadius,
                        center = Offset.Zero
                    )
                }
            }
            
            // ─── 4. 高光光带 ───
            if (!isReflection && shimmerProgress.value > 0f) {
                val glowX = iStemX - 200f + shimmerProgress.value * (textLayoutResult.size.width + 500f)
                withTransform({
                    translate(glowX, baseY - iStemHeight * 1.5f)
                    rotate(25f)
                }) {
                    drawRect(
                        brush = Brush.horizontalGradient(
                            0f to Color.Transparent, 0.5f to Color.White.copy(alpha = 0.6f), 1f to Color.Transparent
                        ),
                        topLeft = Offset(-50f, -100f),
                        size = Size(100f, 400f)
                    )
                }
            }
        }

        // 反射层：大幅下移并增加基准线隔离，防止模糊溢出
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    translationY = with(density){ 16.dp.toPx() } // 下移 16dp，确保模糊永远无法向上渗透
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        renderEffect = android.graphics.RenderEffect.createBlurEffect(
                            16f, 16f, android.graphics.Shader.TileMode.DECAL
                        ).asComposeRenderEffect()
                    }
                }
        ) {
            clipRect(top = baseY) {
                withTransform({
                    scale(1f, -1f, pivot = Offset(0f, baseY))
                }) {
                    val fadeBrush = Brush.verticalGradient(
                        colors = listOf(Color.White, Color.Transparent), 
                        startY = baseY,
                        endY = baseY - with(density){ 40.dp.toPx() } 
                    )
                    val rect = Rect(0f, 0f, size.width, size.height)
                    val paint = Paint()
                    drawContext.canvas.saveLayer(rect, paint)
                    drawScene(isReflection = true)
                    drawRect(brush = fadeBrush, blendMode = BlendMode.DstIn)
                    drawContext.canvas.restore()
                }
            }
        }
        
        // 主场景
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawScene(isReflection = false)
        }
    }
}

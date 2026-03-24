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
        fontSize = 72.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Serif,
        letterSpacing = 1.sp,
        color = Color(0xFF1A2980) 
    )
    
    val textLayoutResult = remember(textStyle) { textMeasurer.measure("nsight", textStyle) }
    
    val baseY = screenHeightPx / 2f + with(density) { 30.dp.toPx() }
    val wordStartX = (screenWidthPx - textLayoutResult.size.width) / 2f + with(density){ 8.dp.toPx() }
    
    val iStemX = wordStartX - with(density) { 14.dp.toPx() } 
    val iStemHeight = with(density) { 34.dp.toPx() } 
    val italicSlantOffset = with(density) { 6.dp.toPx() } 
    val iStemTopY = baseY - iStemHeight
    val dotRadius = with(density) { 4.5f.dp.toPx() }
    val stemWidth = with(density) { 9.dp.toPx() }
    
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
        launch { dotX.animateTo(iStemX, tween(650, easing = LinearOutSlowInEasing)) }
        dotY.animateTo(baseY, tween(650, easing = CubicBezierEasing(0.42f, 0f, 1f, 1f)))
        haptic.performHapticFeedback(HapticFeedbackType.LongPress) 
        
        launch { squashX.animateTo(2.4f, tween(100, easing = FastOutSlowInEasing)) }
        squashY.animateTo(0.25f, tween(100, easing = FastOutSlowInEasing))
        
        launch { squashX.animateTo(1f, spring(dampingRatio = 0.5f, stiffness = 400f)) }
        squashY.animateTo(1f, spring(dampingRatio = 0.5f, stiffness = 400f))
        
        val upTime = 900
        val downTime = 900
        val apexY = iStemTopY - with(density){ 140.dp.toPx() }
        
        launch {
            delay(150)
            traceProgress.animateTo(1f, tween(upTime + downTime - 150, easing = LinearOutSlowInEasing))
        }
        
        launch {
            dotX.animateTo(iStemX + italicSlantOffset, tween(200, easing = LinearOutSlowInEasing))
        }
        
        dotY.animateTo(apexY, tween(upTime, easing = CubicBezierEasing(0.2f, 0f, 0.2f, 1f)))
        
        val perfectDotY = iStemTopY - with(density) { 13.dp.toPx() } 
        dotY.animateTo(perfectDotY, tween(downTime, easing = CubicBezierEasing(0.5f, 0f, 1f, 1f)))
        isPinned = true
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        
        launch {
            stemBend.snapTo(with(density) { 14.dp.toPx() }) 
            stemBend.animateTo(0f, spring(dampingRatio = 0.2f, stiffness = 140f)) 
        }
        launch {
            dotBounce.snapTo(with(density) { 8.dp.toPx() }) 
            dotBounce.animateTo(0f, spring(dampingRatio = 0.3f, stiffness = 180f)) 
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
            val reflectionAlpha = if (isReflection) 0.15f else 1f
            val drawColor = textStyle.color.copy(alpha = reflectionAlpha)
            
            val drawnStemLength = (baseY - dotY.value).coerceIn(0f, iStemHeight)
            val slantProgress = (drawnStemLength / iStemHeight).coerceIn(0f, 1f)
            val currentSlantX = italicSlantOffset * slantProgress
            
            val currentStemTopX = iStemX + currentSlantX + stemBend.value
            val currentStemTopY = baseY - drawnStemLength + abs(stemBend.value) * 0.15f 
            
            if (drawnStemLength > 0f) {
                val stemPath = Path().apply {
                    moveTo(iStemX, baseY)
                    if (drawnStemLength >= iStemHeight) {
                        quadraticBezierTo(
                            x1 = iStemX + italicSlantOffset * 0.5f + stemBend.value * 1.5f, 
                            y1 = baseY - iStemHeight / 2f, 
                            x2 = currentStemTopX, 
                            y2 = currentStemTopY
                        )
                    } else {
                        lineTo(currentStemTopX, currentStemTopY)
                    }
                }
                drawPath(
                    path = stemPath,
                    color = drawColor,
                    style = Stroke(width = stemWidth, cap = StrokeCap.Round)
                )
            }
            
            if (traceProgress.value > 0f) {
                clipRect(
                    left = wordStartX - 20f,
                    top = 0f, 
                    right = wordStartX + (textLayoutResult.size.width * traceProgress.value),
                    bottom = screenHeightPx * 2f 
                ) {
                    drawText(
                        textMeasurer = textMeasurer,
                        text = "nsight",
                        topLeft = Offset(wordStartX, baseY - textLayoutResult.firstBaseline),
                        style = textStyle.copy(color = drawColor)
                    )
                }
            }
            
            val finalDotX = if (isPinned) currentStemTopX else dotX.value
            val finalDotY = if (isPinned) dotY.value + dotBounce.value else dotY.value
            
            withTransform({
                translate(finalDotX, finalDotY)
                if (!isReflection && !isPinned && dotY.value >= baseY - 5f) {
                    scale(squashX.value, squashY.value, pivot = Offset(0f, dotRadius))
                }
            }) {
                drawCircle(
                    brush = if(isReflection) SolidColor(drawColor) else dotBrush, 
                    radius = dotRadius, 
                    alpha = reflectionAlpha,
                    center = Offset.Zero 
                )
            }
            
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

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    translationY = 1f 
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
                
                drawIntoLayer(
                    bounds = Rect(0f, 0f, size.width, size.height),
                    paint = Paint()
                ) {
                    drawScene(isReflection = true)
                    drawRect(
                        brush = fadeBrush,
                        blendMode = BlendMode.DstIn
                    )
                }
            }
        }
        
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawScene(isReflection = false)
        }
    }
}

private inline fun DrawScope.drawIntoLayer(
    bounds: Rect,
    paint: Paint,
    block: DrawScope.() -> Unit
) {
    drawContext.canvas.saveLayer(bounds, paint)
    try {
        block()
    } finally {
        drawContext.canvas.restore()
    }
}
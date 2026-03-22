package com.example.insight.ui.screens

import android.graphics.PathMeasure
import androidx.compose.runtime.Composable
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(onAnimationFinished: () -> Unit) {
    val haptic = LocalHapticFeedback.current
    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary
    
    // 动画状态记录
    var animationState by remember { mutableStateOf(0) } // 0: 坠落, 1: 挤压, 2: 弹起到文字
    
    // 1. 坠落阶段动画
    val dropProgress = remember { Animatable(0f) }
    
    // 2. 挤压变形阶段
    val scaleX = remember { Animatable(1f) }
    val scaleY = remember { Animatable(1f) }
    
    // 3. 路径绘制阶段
    val drawProgress = remember { Animatable(0f) }
    val textAlpha = remember { Animatable(0f) }

    // 真正具备高级感的 Insight 连笔路径 (居中优化的相对坐标)
    val brandPath = remember {
        Path().apply {
            moveTo(0f, 0f)
            
            // I (连笔大写)
            cubicTo(-20f, -50f, -40f, -150f, 0f, -250f)
            cubicTo(20f, -150f, 40f, -50f, 30f, 0f)
            
            // n
            relativeCubicTo(10f, -80f, 60f, -80f, 80f, 0f)
            relativeCubicTo(10f, -80f, 60f, -80f, 80f, 0f)
            
            // s
            relativeCubicTo(20f, -120f, -60f, -120f, -20f, -150f)
            relativeCubicTo(40f, -30f, 80f, 30f, 40f, 100f)
            
            // i
            relativeMoveTo(20f, 0f)
            relativeCubicTo(10f, -80f, 50f, -80f, 60f, 0f)
            
            // g
            relativeCubicTo(10f, -80f, 80f, -80f, 80f, 0f)
            relativeCubicTo(0f, 100f, -80f, 180f, -80f, 100f)
            relativeCubicTo(0f, -40f, 40f, -80f, 80f, -120f)
            
            // h
            relativeMoveTo(20f, 120f)
            relativeCubicTo(10f, -250f, 30f, -350f, 0f, -450f)
            relativeMoveTo(0f, 450f)
            relativeCubicTo(20f, -100f, 80f, -100f, 100f, 0f)
            
            // t
            relativeLineTo(30f, -350f)
            relativeMoveTo(-50f, 150f)
            relativeLineTo(100f, 0f)
        }
    }

    LaunchedEffect(Unit) {
        // 1. 坠落
        dropProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(700, easing = CubicBezierEasing(0.42f, 0f, 1f, 1f))
        )
        
        // 触地瞬间
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        animationState = 1
        
        // 2. 挤压 (Squash)
        launch { 
            scaleY.animateTo(0.35f, tween(120))
            scaleY.animateTo(1f, spring(dampingRatio = 0.55f, stiffness = Spring.StiffnessLow))
        }
        launch {
            scaleX.animateTo(1.7f, tween(120))
            scaleX.animateTo(1f, spring(dampingRatio = 0.55f, stiffness = Spring.StiffnessLow))
        }
        
        delay(150)
        animationState = 2
        
        // 3. 路径绘制 (Trace)
        launch { textAlpha.animateTo(1f, tween(1200)) }
        drawProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(2800, easing = FastOutSlowInEasing)
        )
        
        delay(600)
        onAnimationFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val groundY = h * 0.65f
            val centerX = w / 2f
            
            val gradientMain = Brush.linearGradient(
                colors = listOf(primaryColor, secondaryColor, primaryColor.copy(alpha = 0.8f)),
                start = Offset(0f, 0f),
                end = Offset(w, h)
            )
            
            val gradientSub = Brush.linearGradient(
                colors = listOf(secondaryColor, primaryColor, secondaryColor.copy(alpha = 0.6f)),
                start = Offset(w, 0f),
                end = Offset(0f, h)
            )

            if (animationState == 0) {
                // 抛物线下落渲染
                val currentX = (centerX - 400f) + 400f * dropProgress.value
                val currentY = -100f + (groundY + 100f) * dropProgress.value
                
                withTransform({
                    translate(currentX, currentY)
                    rotate(lerp(0f, 15f, dropProgress.value))
                    scale(scaleX = 0.85f, scaleY = 1.15f)
                }) {
                    drawCircle(brush = gradientMain, radius = 12.dp.toPx())
                }
            } else if (animationState == 1 || animationState == 2) {
                val pathMeasure = PathMeasure(brandPath.asAndroidPath(), false)
                val totalLength = pathMeasure.length
                
                withTransform({
                    translate(centerX - 350f, groundY)
                    scale(1.2f, 1.2f, pivot = Offset.Zero)
                }) {
                    if (animationState == 2) {
                        val currentDist = totalLength * drawProgress.value
                        val trailPath = android.graphics.Path()
                        pathMeasure.getSegment(0f, currentDist, trailPath, true)
                        
                        // 多层笔刷实现 Apple 级流光效果
                        drawPath(
                            path = trailPath.asComposePath(),
                            brush = gradientSub,
                            style = Stroke(width = 10.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round),
                            alpha = textAlpha.value * 0.4f
                        )
                        drawPath(
                            path = trailPath.asComposePath(),
                            brush = gradientMain,
                            style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round),
                            alpha = textAlpha.value
                        )

                        val pos = FloatArray(2)
                        if (pathMeasure.getPosTan(currentDist, pos, null)) {
                            withTransform({
                                translate(pos[0], pos[1])
                                scale(scaleX = scaleX.value, scaleY = scaleY.value)
                            }) {
                                drawCircle(brush = gradientMain, radius = 12.dp.toPx())
                            }
                        }
                    } else {
                        withTransform({
                            scale(scaleX = scaleX.value, scaleY = scaleY.value)
                        }) {
                            drawCircle(brush = gradientMain, radius = 12.dp.toPx())
                        }
                    }
                }
            }
        }
    }
}

fun lerp(start: Float, stop: Float, fraction: Float): Float {
    return (1 - fraction) * start + fraction * stop
}

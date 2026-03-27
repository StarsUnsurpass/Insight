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
import kotlin.math.*

@Composable
fun SplashScreen(onAnimationFinished: () -> Unit) {
    val haptic = LocalHapticFeedback.current
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    val textMeasurer = rememberTextMeasurer()
    
    val screenWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }
    
    // 【拟物色彩系统】
    val neonCyan = Color(0xFF00E5FF)      
    val deepCyan = Color(0xFF00D1E5)      
    val thicknessColor = Color(0xFF00796B) 
    val glossWhite = Color.White.copy(alpha = 0.6f) 
    
    val textStyle = TextStyle(
        fontSize = 72.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Serif,
        letterSpacing = 2.sp
    )
    
    val iLayout = remember(textStyle) { textMeasurer.measure("i", textStyle) }
    val nsightLayout = remember(textStyle) { textMeasurer.measure("nsight", textStyle) }
    
    val baseY = screenHeightPx / 2f + with(density) { 30.dp.toPx() }
    val charGap = with(density) { 6.dp.toPx() } 
    val totalWidth = iLayout.size.width + charGap + nsightLayout.size.width
    val startX = (screenWidthPx - totalWidth) / 2f
    
    val iX = startX
    val nsightX = iX + iLayout.size.width + charGap
    
    val iTopLeft = Offset(iX, baseY - iLayout.firstBaseline)
    val nsightTopLeft = Offset(nsightX, baseY - nsightLayout.firstBaseline)

    val thickOff = with(density) { 1.2.dp.toPx() }
    val rimOff = with(density) { 0.8.dp.toPx() }
    
    // 动画状态
    val dotY = remember { Animatable(baseY - 600f) }
    val dotX = remember { Animatable(iX - 120f) }
    val squashX = remember { Animatable(1f) }
    val squashY = remember { Animatable(1f) }
    
    // 【关键】竖线的弹性高度因子
    val stemScaleY = remember { Animatable(0f) }
    val nsightAlpha = remember { Animatable(0f) }
    val shimmerProgress = remember { Animatable(0f) }
    
    var isPinned by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // 第一幕：坠落撞击
        launch { dotX.animateTo(iX, tween(700, easing = LinearOutSlowInEasing)) }
        dotY.animateTo(baseY, tween(700, easing = CubicBezierEasing(0.42f, 0f, 1f, 1f)))
        haptic.performHapticFeedback(HapticFeedbackType.LongPress) 
        
        // 【冲击瞬间】竖线以压缩状态“弹出”，并与圆点同步挤压
        launch {
            stemScaleY.snapTo(0.1f) // 被砸扁的初始状态
            // 随圆点弹起而进行弹性回弹
            delay(100)
            stemScaleY.animateTo(1f, spring(dampingRatio = 0.45f, stiffness = Spring.StiffnessLow))
        }

        launch { squashX.animateTo(2.2f, tween(100)) }
        squashY.animateTo(0.3f, tween(100))
        launch { squashX.animateTo(1f, spring(dampingRatio = 0.5f)) }
        squashY.animateTo(1f, spring(dampingRatio = 0.5f))
        
        // 第二幕：点回弹
        val apexY = iTopLeft.y - with(density){ 40.dp.toPx() }
        launch {
            delay(200)
            nsightAlpha.animateTo(1f, tween(1000))
        }
        dotY.animateTo(apexY, tween(800, easing = LinearOutSlowInEasing))
        
        // 第三幕：归位
        dotY.animateTo(iTopLeft.y, tween(800, easing = BounceInterpolator().asEasing()))
        isPinned = true
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        
        delay(300)
        shimmerProgress.animateTo(1f, tween(1200))
        onAnimationFinished()
    }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF000808))) {
        fun DrawScope.drawSkeuomorphicText(
            layout: TextLayoutResult,
            topLeft: Offset,
            alpha: Float = 1f,
            clipRect: Rect? = null
        ) {
            val mainBrush = Brush.verticalGradient(
                colors = listOf(neonCyan.copy(alpha = alpha), deepCyan.copy(alpha = alpha)),
                startY = iTopLeft.y,
                endY = baseY
            )
            
            fun drawLayers() {
                drawText(layout, topLeft = topLeft + Offset(thickOff, thickOff), color = thicknessColor.copy(alpha = alpha))
                drawText(layout, topLeft = topLeft, brush = mainBrush)
                drawText(layout, topLeft = topLeft - Offset(rimOff, rimOff), color = glossWhite.copy(alpha = 0.45f * alpha))
                drawText(layout, topLeft = topLeft, brush = Brush.radialGradient(listOf(neonCyan.copy(alpha = 0.35f * alpha), Color.Transparent), center = Offset(layout.size.width/2f, layout.size.height/2f), radius = layout.size.width.toFloat()), blendMode = BlendMode.Plus)
            }

            if (clipRect != null) {
                clipRect(left = clipRect.left, top = clipRect.top, right = clipRect.right, bottom = clipRect.bottom) {
                    drawLayers()
                }
            } else {
                drawLayers()
            }
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            val relativeSplitY = iLayout.size.height * 0.32f
            val absoluteSplitY = iTopLeft.y + relativeSplitY
            
            // ─── 1. 第一个 i 的竖线 (物理弹性压缩回弹) ───
            if (stemScaleY.value > 0.01f) {
                withTransform({
                    // 以底部基线为中心进行垂直缩放，实现“压缩感”
                    scale(1f, stemScaleY.value, pivot = Offset(iX + iLayout.size.width/2, baseY))
                }) {
                    drawSkeuomorphicText(
                        layout = iLayout,
                        topLeft = iTopLeft,
                        clipRect = Rect(0f, absoluteSplitY, screenWidthPx, baseY + 20f) // 固定裁剪区，通过缩放实现生长
                    )
                }
            }
            
            // ─── 2. 第一个 i 的圆点 (点从天而降) ───
            val currentDotTopLeft = if (isPinned) iTopLeft else Offset(iX, dotY.value)
            drawSkeuomorphicText(
                layout = iLayout,
                topLeft = currentDotTopLeft,
                clipRect = Rect(
                    left = 0f, 
                    top = currentDotTopLeft.y - 50f, 
                    right = screenWidthPx, 
                    bottom = currentDotTopLeft.y + relativeSplitY
                )
            )

            // ─── 3. 后续 "nsight" 文本 ───
            if (nsightAlpha.value > 0f) {
                drawSkeuomorphicText(
                    layout = nsightLayout, 
                    topLeft = nsightTopLeft, 
                    alpha = nsightAlpha.value
                )
            }
            
            // ─── 4. 扫描高光 ───
            if (shimmerProgress.value > 0f) {
                val shimmerX = startX - 250f + shimmerProgress.value * (totalWidth + 500f)
                withTransform({
                    translate(shimmerX, baseY - iLayout.size.height/2)
                    rotate(25f)
                }) {
                    drawRect(
                        brush = Brush.horizontalGradient(listOf(Color.Transparent, Color.White.copy(alpha = 0.4f), Color.Transparent)),
                        topLeft = Offset(-35f, -160f),
                        size = Size(70f, 320f)
                    )
                }
            }
        }
    }
}

class BounceInterpolator {
    fun asEasing() = Easing { t ->
        if (t < 0.3636f) 7.5625f * t * t
        else if (t < 0.7272f) 7.5625f * (t - 0.5454f) * (t - 0.5454f) + 0.75f
        else if (t < 0.9090f) 7.5625f * (t - 0.8181f) * (t - 0.8181f) + 0.9375f
        else 7.5625f * (t - 0.9545f) * (t - 0.9545f) + 0.984375f
    }
}

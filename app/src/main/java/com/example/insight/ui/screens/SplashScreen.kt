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
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
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
    
    // 【背景色对齐主题 - PaperWhite】
    val bgColor = Color(0xFFFDFCF0)
    val neonCyan = Color(0xFF00ACC1)      
    val deepCyan = Color(0xFF00838F)      
    val thicknessColor = Color(0xFF004D40).copy(alpha = 0.4f) 
    val glossWhite = Color.White.copy(alpha = 0.8f)
    
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

    val thickOff = with(density) { 1.5.dp.toPx() }
    val rimOff = with(density) { 1.0.dp.toPx() }
    
    // --- 物理同步动画变量 ---
    val dotY = remember { Animatable(baseY - 700f) }
    val dotX = remember { Animatable(iX - 100f) }
    val jellySkewX = remember { Animatable(0f) } // 水平剪切因子 (果冻感)
    val squashX = remember { Animatable(1f) }
    val squashY = remember { Animatable(1f) }
    val stemScaleY = remember { Animatable(0f) } // 垂直缩放因子 (压缩感)
    val nsightAlpha = remember { Animatable(0f) }
    val shimmerProgress = remember { Animatable(0f) }
    
    var isPinned by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // 1. 初次掉落撞击
        launch { dotX.animateTo(iX, tween(650, easing = LinearOutSlowInEasing)) }
        dotY.animateTo(baseY, tween(650, easing = CubicBezierEasing(0.5f, 0f, 1f, 1f)))
        
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        
        // 【冲击瞬间】
        launch {
            // 圆点挤压
            squashX.animateTo(2.3f, tween(80))
            squashY.animateTo(0.35f, tween(80))
            squashX.animateTo(1f, spring(dampingRatio = 0.5f))
            squashY.animateTo(1f, spring(dampingRatio = 0.5f))
        }

        launch {
            // 竖线被“砸扁”后回弹
            stemScaleY.snapTo(0.1f)
            delay(60)
            stemScaleY.animateTo(1.15f, spring(dampingRatio = 0.4f, stiffness = Spring.StiffnessLow))
            stemScaleY.animateTo(1f, spring(dampingRatio = 0.6f))
        }

        launch {
            delay(80)
            // 触发果冻左右摆动
            jellySkewX.animateTo(-0.18f, tween(300, easing = FastOutSlowInEasing))
            jellySkewX.animateTo(0.12f, tween(400, easing = FastOutSlowInEasing))
            jellySkewX.animateTo(0f, spring(dampingRatio = 0.3f, stiffness = Spring.StiffnessLow))
        }

        val apexY = iTopLeft.y - with(density){ 45.dp.toPx() }
        launch {
            delay(250)
            nsightAlpha.animateTo(1f, tween(800))
        }
        
        dotY.animateTo(apexY, tween(600, easing = LinearOutSlowInEasing))
        
        // 2. 再次落位
        dotY.animateTo(iTopLeft.y, spring(dampingRatio = 0.6f, stiffness = Spring.StiffnessLow))
        
        // 落地后的微弱余震果冻感
        launch {
            delay(100)
            jellySkewX.animateTo(0.05f, tween(150))
            jellySkewX.animateTo(0f, spring(dampingRatio = 0.5f))
        }

        isPinned = true
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        
        delay(400)
        shimmerProgress.animateTo(1f, tween(1000))
        onAnimationFinished()
    }

    Box(modifier = Modifier.fillMaxSize().background(bgColor)) {
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
                drawText(layout, topLeft = topLeft + Offset(thickOff, thickOff), color = thicknessColor.copy(alpha = alpha * 0.4f))
                drawText(layout, topLeft = topLeft, brush = mainBrush)
                drawText(layout, topLeft = topLeft - Offset(rimOff, rimOff), color = glossWhite.copy(alpha = 0.8f * alpha))
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
            val relativeSplitY = iLayout.size.height * 0.35f
            val absoluteSplitY = iTopLeft.y + relativeSplitY
            val stemFullHeight = baseY - absoluteSplitY
            
            // ─── 1. 第一个 i 的竖线 (果冻弹性形变) ───
            if (stemScaleY.value > 0.01f) {
                drawIntoCanvas { canvas ->
                    canvas.save()
                    // 以底部基线为支点进行剪切(Skew)变换
                    canvas.translate(0f, baseY)
                    // nativeCanvas.skew(sx, sy) 这里的 sx 是 tan(angle)
                    canvas.nativeCanvas.skew(-jellySkewX.value, 0f)
                    canvas.translate(0f, -baseY)
                    
                    // 配合垂直缩放
                    withTransform({
                        scale(1f, stemScaleY.value, pivot = Offset(iX + iLayout.size.width/2, baseY))
                    }) {
                        drawSkeuomorphicText(
                            layout = iLayout,
                            topLeft = iTopLeft,
                            clipRect = Rect(0f, absoluteSplitY, screenWidthPx, baseY + 40f)
                        )
                    }
                    canvas.restore()
                }
            }
            
            // ─── 2. 第一个 i 的圆点 (与竖线顶端同步) ───
            // 圆点需要实时跟随竖线顶端的剪切位移
            // 位移 = -jellySkewX * 距离支点的垂直距离
            val currentSwayX = jellySkewX.value * stemFullHeight * stemScaleY.value
            val currentDotTopLeft = if (isPinned) iTopLeft else Offset(iX + currentSwayX, dotY.value)
            
            withTransform({
                if (!isPinned && dotY.value >= baseY - 15f) {
                    scale(squashX.value, squashY.value, pivot = Offset(iX + currentSwayX + iLayout.size.width/2, dotY.value + relativeSplitY))
                }
            }) {
                drawSkeuomorphicText(
                    layout = iLayout,
                    topLeft = currentDotTopLeft,
                    clipRect = Rect(0f, currentDotTopLeft.y - 100f, screenWidthPx, currentDotTopLeft.y + relativeSplitY)
                )
            }

            // 3. 后续 "nsight" 文本
            if (nsightAlpha.value > 0f) {
                drawSkeuomorphicText(
                    layout = nsightLayout, 
                    topLeft = nsightTopLeft, 
                    alpha = nsightAlpha.value
                )
            }
            
            // 4. 扫描高光
            if (shimmerProgress.value > 0f) {
                val shimmerX = startX - 250f + shimmerProgress.value * (totalWidth + 500f)
                withTransform({
                    translate(shimmerX, baseY - iLayout.size.height/2)
                    rotate(20f)
                }) {
                    drawRect(
                        brush = Brush.horizontalGradient(listOf(Color.Transparent, Color.White.copy(alpha = 0.5f), Color.Transparent)),
                        topLeft = Offset(-40f, -180f),
                        size = Size(80f, 360f)
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

package com.example.insight.ui.screens.analytics

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CognitiveRadar(
    dimensions: Map<String, Float>,
    modifier: Modifier = Modifier
) {
    val transition = rememberInfiniteTransition(label = "RadarGlow")
    val glowAlpha by transition.animateFloat(
        initialValue = 0.2f, 
        targetValue = 0.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Alpha"
    )

    // 生长动画：进入页面时从中心点平滑向外扩张
    val animProgress = remember { Animatable(0f) }
    LaunchedEffect(dimensions) {
        animProgress.animateTo(
            targetValue = 1f, 
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    }

    Canvas(modifier = modifier
        .aspectRatio(1f)
        .padding(32.dp)) {
        val center = androidx.compose.ui.geometry.Offset(size.width / 2, size.height / 2)
        val radius = size.width / 2
        val sides = dimensions.size
        val angleStep = (2 * PI / sides).toFloat()

        // 1. 绘制极细背景网格（4层五边形/多边形）
        for (i in 1..4) {
            val r = radius * (i / 4f)
            val path = Path()
            for (j in 0 until sides) {
                val angle = j * angleStep - PI.toFloat() / 2
                val x = center.x + r * cos(angle)
                val y = center.y + r * sin(angle)
                if (j == 0) path.moveTo(x, y) else path.lineTo(x, y)
            }
            path.close()
            drawPath(
                path = path, 
                color = Color.Gray.copy(alpha = 0.15f), 
                style = Stroke(width = 1f)
            )
        }

        // 2. 绘制放射状轴线
        for (j in 0 until sides) {
            val angle = j * angleStep - PI.toFloat() / 2
            val x = center.x + radius * cos(angle)
            val y = center.y + radius * sin(angle)
            drawLine(
                color = Color.Gray.copy(alpha = 0.1f),
                start = center,
                end = androidx.compose.ui.geometry.Offset(x, y),
                strokeWidth = 1f
            )
        }

        // 3. 绘制能力覆盖区域 (带有柔和填充和流光描边)
        val valuePath = Path()
        val values = dimensions.values.toList()
        values.forEachIndexed { index, value ->
            val angle = index * angleStep - PI.toFloat() / 2
            val r = radius * value * animProgress.value
            val x = center.x + r * cos(angle)
            val y = center.y + r * sin(angle)
            if (index == 0) valuePath.moveTo(x, y) else valuePath.lineTo(x, y)
        }
        if (values.isNotEmpty()) valuePath.close()

        // 填充黛蓝色（主色调）半透明背景
        drawPath(
            path = valuePath, 
            color = Color(0xFF5B8FF9).copy(alpha = 0.25f)
        )
        
        // 描边流光效果
        drawPath(
            path = valuePath, 
            color = Color(0xFF5B8FF9).copy(alpha = glowAlpha + 0.3f), 
            style = Stroke(width = 6f)
        )
    }
}

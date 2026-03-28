package com.example.insight.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * 成绩分布直方图
 * 展示不同分数段的人数分布
 */
@Composable
fun ScoreDistributionChart(
    data: List<Int>, // 每个分段的人数，例如 [2, 5, 12, 8, 3]
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val animationProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animationProgress.animateTo(1f, tween(1000, easing = FastOutSlowInEasing))
    }

    Canvas(modifier = modifier) {
        val barCount = data.size
        val spacing = 12.dp.toPx()
        val barWidth = (size.width - (barCount - 1) * spacing) / barCount
        val maxCount = data.maxOrNull()?.toFloat() ?: 1f

        data.forEachIndexed { index, count ->
            val barHeight = (count / maxCount) * size.height * animationProgress.value
            val x = index * (barWidth + spacing)
            val y = size.height - barHeight

            drawRoundRect(
                brush = Brush.verticalGradient(listOf(primaryColor, primaryColor.copy(alpha = 0.6f))),
                topLeft = Offset(x, y),
                size = Size(barWidth, barHeight),
                cornerRadius = CornerRadius(4.dp.toPx(), 4.dp.toPx())
            )
        }
    }
}

/**
 * 横向能力对比条形图
 */
@Composable
fun HorizontalComparisonBar(
    label: String,
    currentValue: Float, // 0..1
    benchmarkValue: Float, // 0..1 (例如年级平均)
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.outlineVariant

    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(label, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
            Text("${(currentValue * 100).toInt()}%", style = MaterialTheme.typography.labelSmall, color = primaryColor)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.fillMaxWidth().height(8.dp).clip(CircleShape).background(secondaryColor.copy(alpha = 0.3f))) {
            // Benchmark (背景参考线)
            Box(modifier = Modifier.fillMaxWidth(benchmarkValue).fillMaxHeight().background(Color.Gray.copy(alpha = 0.2f)))
            // Current Value (当前进度)
            Box(modifier = Modifier.fillMaxWidth(currentValue).fillMaxHeight().background(primaryColor))
        }
    }
}

/**
 * 教学能力雷达图
 */
@Composable
fun CapabilityRadarChart(
    scores: List<Float>,
    modifier: Modifier = Modifier
) {
    val labels = listOf("听力", "口语", "阅读", "写作", "词汇", "语法")
    val primaryColor = MaterialTheme.colorScheme.primary
    
    val animationProgress = remember { Animatable(0f) }
    LaunchedEffect(scores) {
        animationProgress.animateTo(1f, tween(1200, easing = FastOutSlowInEasing))
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize().padding(40.dp)) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.width.coerceAtMost(size.height) / 2
            val angleStep = (2 * PI / 6).toFloat()

            for (i in 1..5) {
                val currentRadius = radius * (i / 5f)
                val path = Path()
                for (j in 0 until 6) {
                    val angle = j * angleStep - (PI / 2).toFloat()
                    val x = center.x + currentRadius * cos(angle)
                    val y = center.y + currentRadius * sin(angle)
                    if (j == 0) path.moveTo(x, y) else path.lineTo(x, y)
                }
                path.close()
                drawPath(path, Color.Gray.copy(alpha = 0.15f), style = Stroke(width = 1.dp.toPx()))
            }

            val dataPath = Path()
            val points = mutableListOf<Offset>()
            for (j in 0 until 6) {
                val score = scores.getOrElse(j) { 0.5f } * animationProgress.value
                val angle = j * angleStep - (PI / 2).toFloat()
                val x = center.x + radius * score * cos(angle)
                val y = center.y + radius * score * sin(angle)
                points.add(Offset(x, y))
                if (j == 0) dataPath.moveTo(x, y) else dataPath.lineTo(x, y)
            }
            dataPath.close()

            drawPath(
                path = dataPath,
                brush = Brush.radialGradient(listOf(primaryColor.copy(alpha = 0.6f), primaryColor.copy(alpha = 0.2f))),
            )
            drawPath(
                path = dataPath,
                color = primaryColor,
                style = Stroke(width = 2.dp.toPx(), pathEffect = PathEffect.cornerPathEffect(8.dp.toPx()))
            )
        }

        labels.forEachIndexed { index, label ->
            val angle = index * (2 * PI / 6).toFloat() - (PI / 2).toFloat()
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.offset(x = (cos(angle) * 110).dp, y = (sin(angle) * 110).dp)
                )
            }
        }
    }
}

/**
 * 学习进度曲线图
 */
@Composable
fun LearningCurveChart(
    points: List<Float>,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val animationProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animationProgress.animateTo(1f, tween(1500, easing = FastOutSlowInEasing))
    }

    Canvas(modifier = modifier) {
        if (points.size < 2) return@Canvas
        val width = size.width
        val height = size.height
        val spacing = width / (points.size - 1)
        val path = Path()
        val fillPath = Path()
        fillPath.moveTo(0f, height)
        points.forEachIndexed { index, value ->
            val x = index * spacing
            val y = height - (value * height * animationProgress.value)
            if (index == 0) {
                path.moveTo(x, y)
                fillPath.lineTo(x, y)
            } else {
                val prevX = (index - 1) * spacing
                val prevY = height - (points[index - 1] * height * animationProgress.value)
                path.cubicTo(prevX + spacing / 2, prevY, prevX + spacing / 2, y, x, y)
                fillPath.cubicTo(prevX + spacing / 2, prevY, prevX + spacing / 2, y, x, y)
            }
        }
        fillPath.lineTo(width, height)
        fillPath.close()
        drawPath(path = fillPath, brush = Brush.verticalGradient(listOf(primaryColor.copy(alpha = 0.2f), Color.Transparent)))
        drawPath(path = path, color = primaryColor, style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round))
    }
}

/**
 * 环形掌握度进度条
 */
@Composable
fun MasteryProgressCircle(
    percentage: Float,
    label: String,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val progress = animateFloatAsState(targetValue = percentage, animationSpec = tween(1000))

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(60.dp)) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(Color.Gray.copy(alpha = 0.1f), style = Stroke(width = 4.dp.toPx()))
                drawArc(
                    color = primaryColor,
                    startAngle = -90f,
                    sweepAngle = 360 * progress.value,
                    useCenter = false,
                    style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
                )
            }
            Text(
                text = "${(percentage * 100).toInt()}%",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
    }
}

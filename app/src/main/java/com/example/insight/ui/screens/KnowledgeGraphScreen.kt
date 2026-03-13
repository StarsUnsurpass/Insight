package com.example.insight.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.theme.*
import kotlin.math.cos
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KnowledgeGraphScreen(
    onClose: () -> Unit
) {
    Scaffold(
        containerColor = PaperWhite,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("学情诊断报告", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onClose) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = DarkText)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = PaperWhite)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // 1. Greeting & Overview
            item {
                Column {
                    Text(
                        "Hi, 同学 👋",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = InkBlue
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "本周已攻克 24 道易错题，语法基础的薄弱点正在减少。",
                        style = MaterialTheme.typography.bodyMedium,
                        color = DarkText.copy(alpha = 0.7f)
                    )
                }
            }

            // 2. Ability Radar Chart Card
            item {
                DashboardCard(title = "五维能力评估") {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        RadarChart(
                            data = listOf(0.8f, 0.6f, 0.9f, 0.5f, 0.7f),
                            labels = listOf("词汇储备", "语法结构", "篇章阅读", "跨文化", "信息提取"),
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            // 3. Error Attribution Card
            item {
                DashboardCard(title = "弱点归因分析") {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        ErrorFactorRow("🔴 概念混淆", 0.45f, Color(0xFFE57373))
                        ErrorFactorRow("🟡 粗心/审题偏差", 0.30f, Color(0xFFFFD54F))
                        ErrorFactorRow("🔵 前置知识盲区", 0.25f, Color(0xFF64B5F6))
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            color = SageGreen.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(imageVector = Icons.Default.Info, contentDescription = null, tint = SageGreen, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "建议：重点复习'分词作定语'的相关概念。",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = SageGreen
                                )
                            }
                        }
                    }
                }
            }

            // 4. Actionable Measures
            item {
                Column {
                    Text(
                        "对策行动",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = SageGreen
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedButton(
                        onClick = { /* Action */ },
                        modifier = Modifier.fillMaxWidth().height(56.dp),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, InkBlue.copy(alpha = 0.1f))
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("生成针对【定语从句】的 10 道巩固特训", color = InkBlue)
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, tint = InkBlue)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DashboardCard(title: String, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                title,
                style = MaterialTheme.typography.labelMedium,
                color = SageGreen,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            content()
        }
    }
}

@Composable
fun ErrorFactorRow(label: String, percentage: Float, color: Color) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, style = MaterialTheme.typography.bodySmall, color = DarkText)
            Text("${(percentage * 100).toInt()}%", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(CircleShape)
                .background(color.copy(alpha = 0.1f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(percentage)
                    .background(color, CircleShape)
            )
        }
    }
}

@Composable
fun RadarChart(
    data: List<Float>,
    labels: List<String>,
    modifier: Modifier = Modifier
) {
    val alphaAnim = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        alphaAnim.animateTo(1f, animationSpec = tween(1000))
    }

    Canvas(modifier = modifier) {
        val center = Offset(size.width / 2, size.height / 2)
        val radius = size.minDimension / 2.5f
        val numPoints = data.size
        val angleStep = (2 * Math.PI / numPoints).toFloat()

        // 1. Draw Background Polygons
        for (i in 1..4) {
            val scale = i / 4f
            val path = Path()
            for (j in 0 until numPoints) {
                val angle = j * angleStep - Math.PI.toFloat() / 2
                val x = center.x + radius * scale * cos(angle)
                val y = center.y + radius * scale * sin(angle)
                if (j == 0) path.moveTo(x, y) else path.lineTo(x, y)
            }
            path.close()
            drawPath(path, color = Color.LightGray.copy(alpha = 0.2f), style = Stroke(width = 1.dp.toPx()))
        }

        // 2. Draw Data Area
        val dataPath = Path()
        for (j in 0 until numPoints) {
            val angle = j * angleStep - Math.PI.toFloat() / 2
            val x = center.x + radius * data[j] * cos(angle)
            val y = center.y + radius * data[j] * sin(angle)
            if (j == 0) dataPath.moveTo(x, y) else dataPath.lineTo(x, y)
        }
        dataPath.close()
        drawPath(
            dataPath,
            color = SageGreen.copy(alpha = 0.3f * alphaAnim.value)
        )
        drawPath(
            dataPath,
            color = SageGreen.copy(alpha = alphaAnim.value),
            style = Stroke(width = 2.dp.toPx())
        )

        // 3. Labels
        labels.forEachIndexed { j, _ ->
            val angle = j * angleStep - Math.PI.toFloat() / 2
            val _x = center.x + (radius + 25.dp.toPx()) * cos(angle)
            val _y = center.y + (radius + 20.dp.toPx()) * sin(angle)
            
            // Note: In real implementation, we'd use nativeCanvas or a custom text drawer
            // For brevity, we focus on the geometry
        }
    }
}

package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.TipsAndUpdates
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.state.UserPreferences
import com.example.insight.ui.state.UserRole
import com.example.insight.ui.theme.*
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun KnowledgeGraphScreen(preferences: UserPreferences) {
    val scrollState = rememberScrollState()
    
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState)
        ) {
            // 1. AI Insight Header (Gradient + Typewriter)
            AIInsightHeader(preferences)

            Spacer(modifier = Modifier.height(24.dp))

            // 2. The Multi-Dimensional Radar
            DashboardCard(title = "五维能力评估 (Cognitive Radar)") {
                RadarChartAnimated(
                    data = listOf(0.85f, 0.62f, 0.78f, 0.45f, 0.92f),
                    labels = listOf("词汇运用", "语法重构", "语境理解", "篇章逻辑", "跨文化")
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 3. GitHub-style Learning Heatmap
            DashboardCard(title = "学习强度趋势 (Learning Intensity)") {
                LearningHeatmap()
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 4. Error Attribution (Donut Logic)
            DashboardCard(title = "错误深度剖析 (Attribution)") {
                ErrorAttributionSection()
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 5. AI Prescriptions
            Text(
                "AI 处方与对策",
                modifier = Modifier.padding(horizontal = 24.dp),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = SageGreen
            )
            Spacer(modifier = Modifier.height(12.dp))
            PrescriptionRow()
            
            Spacer(modifier = Modifier.height(100.dp)) // Dock spacing
        }
    }
}

@Composable
fun AIInsightHeader(preferences: UserPreferences) {
    val fullText = if (preferences.role == UserRole.Student) {
        "这周你非常努力，攻克了 15 道长难句！不过我发现，在处理‘过去完成时’时，你常常忽略了时间状语的先后顺序。别灰心，我们针对性地补一补就好啦。"
    } else {
        "班级整体表现平稳。但在【阅读理解】的推断题上，30% 的同学表现出‘母语负迁移’迹象。建议下周针对性布置 2 组逻辑对比训练。"
    }
    
    var displayedText by remember { mutableStateOf("") }
    
    LaunchedEffect(Unit) {
        fullText.forEachIndexed { index, _ ->
            displayedText = fullText.substring(0, index + 1)
            delay(30)
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(SageGreen.copy(alpha = 0.15f), MaterialTheme.colorScheme.background)
                    )
                )
                .padding(24.dp)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Psychology,
                        contentDescription = null,
                        tint = SageGreen,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        "本周学情洞察",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = displayedText,
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Composable
fun RadarChartAnimated(data: List<Float>, labels: List<String>) {
    val animationProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animationProgress.animateTo(
            targetValue = 1f,
            animationSpec = spring(dampingRatio = 0.7f, stiffness = Spring.StiffnessLow)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension / 2.8f
            val numPoints = data.size
            val angleStep = (2 * Math.PI / numPoints).toFloat()

            // 1. Draw Web
            for (i in 1..4) {
                val r = radius * (i / 4f)
                val path = Path()
                for (j in 0 until numPoints) {
                    val angle = j * angleStep - Math.PI.toFloat() / 2
                    val x = center.x + r * cos(angle)
                    val y = center.y + r * sin(angle)
                    if (j == 0) path.moveTo(x, y) else path.lineTo(x, y)
                }
                path.close()
                drawPath(path, Color.Gray.copy(alpha = 0.15f), style = Stroke(width = 1.dp.toPx()))
            }

            // 2. Draw Data Path (Animated)
            val dataPath = Path()
            for (j in 0 until numPoints) {
                val angle = j * angleStep - Math.PI.toFloat() / 2
                val currentRadius = radius * data[j] * animationProgress.value
                val x = center.x + currentRadius * cos(angle)
                val y = center.y + currentRadius * sin(angle)
                if (j == 0) dataPath.moveTo(x, y) else dataPath.lineTo(x, y)
            }
            dataPath.close()
            
            drawPath(dataPath, color = SageGreen.copy(alpha = 0.3f))
            drawPath(dataPath, color = SageGreen, style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round))
            
            // 3. Draw Nodes and Labels
            for (j in 0 until numPoints) {
                val angle = j * angleStep - Math.PI.toFloat() / 2
                
                // Draw small dots at data points
                val dataX = center.x + radius * data[j] * animationProgress.value * cos(angle)
                val dataY = center.y + radius * data[j] * animationProgress.value * sin(angle)
                drawCircle(SageGreen, 4.dp.toPx(), Offset(dataX, dataY))
            }
        }
        
        // Labels handled by Box overlay for better text rendering
        labels.forEachIndexed { j, label ->
            val angle = j * (2 * Math.PI / data.size).toFloat() - Math.PI.toFloat() / 2
            val r = 135.dp
            Box(modifier = Modifier.offset(
                x = (r.value * cos(angle)).dp,
                y = (r.value * sin(angle)).dp
            )) {
                Text(label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
            }
        }
    }
}

@Composable
fun LearningHeatmap() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("近 30 天学习负荷", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
            Text("连续打卡 12 天", style = MaterialTheme.typography.labelSmall, color = SageGreen, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            repeat(15) { week ->
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    repeat(7) { day ->
                        val alpha = remember { (1..10).random() / 10f }
                        Box(
                            modifier = Modifier
                                .size(14.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(SageGreen.copy(alpha = if ((week + day) % 3 == 0) alpha else 0.05f))
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorAttributionSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ErrorDonutRow("🔴 概念盲区", 0.45f, Color(0xFFE57373))
        ErrorDonutRow("🟡 审题偏差", 0.30f, Color(0xFFFFD54F))
        ErrorDonutRow("🔵 词汇不足", 0.25f, Color(0xFF64B5F6))
        
        Surface(
            color = SageGreen.copy(alpha = 0.05f),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, SageGreen.copy(alpha = 0.1f))
        ) {
            Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.TipsAndUpdates, null, tint = SageGreen, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "教研建议：你在‘非谓语动词’上的错误多属于‘母语负迁移’，尝试用英语逻辑重新建模。",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun ErrorDonutRow(label: String, percentage: Float, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .weight(1f)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(percentage)
                    .background(color, CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "$label ${(percentage * 100).toInt()}%",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.width(100.dp)
        )
    }
}

@Composable
fun PrescriptionRow() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PrescriptionCard(
                title = "3分钟复习微课",
                subtitle = "非谓语动词的3个陷阱",
                icon = Icons.Default.AutoAwesome,
                color = SageGreen
            )
        }
        item {
            PrescriptionCard(
                title = "靶向特训",
                subtitle = "为您生成5道针对性练习",
                icon = Icons.Default.TipsAndUpdates,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun PrescriptionCard(title: String, subtitle: String, icon: ImageVector, color: Color) {
    Card(
        modifier = Modifier.size(width = 240.dp, height = 120.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, color.copy(alpha = 0.1f))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(32.dp).background(color.copy(alpha = 0.1f), CircleShape), contentAlignment = Alignment.Center) {
                    Icon(icon, null, tint = color, modifier = Modifier.size(18.dp))
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(title, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold, color = color)
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(subtitle, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun DashboardCard(title: String, content: @Composable () -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            title,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(28.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
        ) {
            Box(modifier = Modifier.padding(24.dp)) {
                content()
            }
        }
    }
}

package com.example.insight.ui.screens.analytics

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Print
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.state.AnalyticsState
import com.example.insight.ui.state.AnalyticsViewType
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearningAnalyticsScreen(
    state: AnalyticsState,
    onViewChange: (AnalyticsViewType) -> Unit
) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF8F9FA))
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "学情全景仪表盘",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A1A1A)
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))
                AnalyticsSegmentedControl(
                    selectedView = state.selectedView,
                    onViewChange = onViewChange
                )
            }
        },
        containerColor = Color(0xFFF8F9FA)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // 面板 1：AI 导师晨报区
            item { AiSummaryCard(summary = state.aiSummary) }

            // 面板 2：能力雷达
            item {
                DashboardCard(title = "五维能力认知图谱") {
                    CognitiveRadar(
                        dimensions = state.cognitiveDimensions,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp)
                    )
                }
            }

            // 面板 3：错因溯源
            item {
                DashboardCard(title = "错因溯源矩阵") {
                    AttributionMatrix(causes = state.errorCauses)
                }
            }

            // 面板 4：学习节律热力图
            item {
                DashboardCard(title = "学习节律与连击") {
                    LearningHeatmap(data = state.heatmapData)
                }
            }

            // 面板 5：AI 靶向处方区 (横向滑动)
            item {
                Column {
                    Text(
                        text = "AI 靶向处方",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A)
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(end = 16.dp)
                    ) {
                        item { PrescriptionCard("三分钟微课", "针对‘篇章逻辑’的进阶技巧", Icons.Default.Lightbulb, Color(0xFF5C6BC0)) }
                        item { PrescriptionCard("举一反三特训", "5 道高匹配度变式题单", Icons.Default.AutoAwesome, Color(0xFF26A69A)) }
                        item { PrescriptionCard("打印专属错题本", "生成手写风格复习卷", Icons.Default.Print, Color(0xFFEC407A)) }
                    }
                }
            }
            
            item { Spacer(modifier = Modifier.height(40.dp)) }
        }
    }
}

@Composable
fun PrescriptionCard(title: String, desc: String, icon: ImageVector, color: Color) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(120.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(icon, contentDescription = null, tint = color)
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = color)
                Text(desc, fontSize = 11.sp, color = color.copy(alpha = 0.7f), lineHeight = 14.sp)
            }
        }
    }
}

@Composable
fun AnalyticsSegmentedControl(
    selectedView: AnalyticsViewType,
    onViewChange: (AnalyticsViewType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.Black.copy(alpha = 0.05f))
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnalyticsViewType.values().forEach { view ->
            val isSelected = selectedView == view
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(20.dp))
                    .background(if (isSelected) Color.White else Color.Transparent)
                    .clickableWithoutRipple { onViewChange(view) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (view == AnalyticsViewType.INDIVIDUAL) "个体诊断" else "班级群像",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color.Black else Color.Gray
                    )
                )
            }
        }
    }
}

@Composable
fun AiSummaryCard(summary: String) {
    var displayedText by remember { mutableStateOf("") }
    
    LaunchedEffect(summary) {
        displayedText = ""
        summary.forEach { char ->
            displayedText += char
            delay(30)
        }
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFFFE082).copy(alpha = 0.1f), Color.White)
                    )
                )
                .padding(20.dp)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(Color(0xFFFFB300)))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("AI 导师晨报", style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFFFB8C00), fontWeight = FontWeight.Bold))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(displayedText, style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 24.sp, color = Color(0xFF424242)))
            }
        }
    }
}

@Composable
fun DashboardCard(title: String, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = Color(0xFF1A1A1A)))
            Spacer(modifier = Modifier.height(16.dp))
            content()
        }
    }
}

@Composable
fun Modifier.clickableWithoutRipple(onClick: () -> Unit): Modifier = this.then(
    Modifier.clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
        onClick = onClick
    )
)


package com.example.insight.ui.screens.analytics

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
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
    onViewChange: (AnalyticsViewType) -> Unit,
    onNavigateToDetail: (String, String) -> Unit
) {
    // 直接使用透明背景或继承自父容器，确保与主题色完全一致
    // 移除所有 Column 顶部的白色 Box 和 Divider
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        // 严格对齐首页 Padding (24, 24, 24)
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 40.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // 1. 标题项目：直接作为 LazyColumn 的第一个 item，实现滚动联动
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "学情分析",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                
                Surface(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFF4CAF50)))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("实时同步中", fontSize = 10.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // 2. 模式切换
        item {
            AnalyticsSegmentedControl(
                selectedView = state.selectedView,
                onViewChange = onViewChange
            )
        }

        // 3. AI 核心诊断
        item { AiSummaryCard(summary = state.aiSummary) }

        // 4. 核心指标卡片（阴影增强）
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                ScorePredictCardWithShadow(
                    title = "综合健康度",
                    value = "${state.overallMastery}",
                    subValue = "基于记录统计",
                    onClick = { onNavigateToDetail("综合健康度", "诊断报告内容...") },
                    color = Color(0xFF5C6BC0),
                    modifier = Modifier.weight(1f)
                )
                ScorePredictCardWithShadow(
                    title = "预估中考分",
                    value = "${state.predictedScoreRange.first}-${state.predictedScoreRange.second}",
                    subValue = "120 分制模拟",
                    onClick = { onNavigateToDetail("中考预测分", "预测报告内容...") },
                    color = Color(0xFF26A69A),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // 5. 班级群像
        if (state.selectedView == AnalyticsViewType.CLASS) {
            item {
                DashboardCard(title = "全班成绩区间分布") {
                    ClassScoreDistributionChart(
                        distribution = state.classScoreDistribution,
                        onItemClick = { stage -> onNavigateToDetail("${stage}阶段统计", "详情数据...") }
                    )
                }
            }
        }

        // 6. 五维模型
        item {
            DashboardCard(title = "英语能力五维细分模型") {
                Box(modifier = Modifier.fillMaxWidth().clickable { onNavigateToDetail("能力五维模型", "深度解析报告...") }) {
                    CognitiveRadar(dimensions = state.cognitiveDimensions, modifier = Modifier.fillMaxWidth().height(260.dp))
                }
            }
        }

        // 7. 行动指南
        item {
            Column {
                Text("智能化行动指南", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    item { PrescriptionCard("靶向路径", state.targetedPath, Icons.AutoMirrored.Filled.DirectionsRun, Color(0xFF5C6BC0)) }
                    item { PrescriptionCard("教材建议", state.syncAdvice, Icons.AutoMirrored.Filled.MenuBook, Color(0xFF26A69A)) }
                }
            }
        }
        
        // 8. 底部占位，由 MainScreen 统一管理，此处仅作为内容留白
        item { Spacer(modifier = Modifier.height(100.dp)) }
    }
}

// --- 卡片组件定义 ---

@Composable
fun ScorePredictCardWithShadow(
    title: String,
    value: String,
    subValue: String,
    onClick: () -> Unit,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(110.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color.copy(alpha = 0.05f))
                .padding(16.dp)
        ) {
            Column {
                Text(title, fontSize = 12.sp, color = color.copy(alpha = 0.8f))
                Text(value, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, color = color)
                Text(subValue, fontSize = 10.sp, color = Color.Gray, maxLines = 1)
            }
        }
    }
}

@Composable
fun AiSummaryCard(summary: String) {
    var displayedText by remember { mutableStateOf("") }
    LaunchedEffect(summary) { displayedText = ""; summary.forEach { char -> displayedText += char; delay(20) } }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.AutoAwesome, null, tint = Color(0xFFFB8C00), modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("AI 核心诊断", style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFFFB8C00), fontWeight = FontWeight.Bold))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(displayedText, style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 26.sp, color = Color(0xFF424242)))
        }
    }
}

@Composable
fun DashboardCard(title: String, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(16.dp))
            content()
        }
    }
}

@Composable
fun PrescriptionCard(title: String, desc: String, icon: ImageVector, color: Color) {
    Card(
        modifier = Modifier.width(170.dp).height(120.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(color.copy(alpha = 0.05f)).padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(icon, contentDescription = null, tint = color)
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = color)
                Text(desc, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 2, lineHeight = 14.sp)
            }
        }
    }
}

@Composable
fun ClassScoreDistributionChart(
    distribution: List<com.example.insight.data.local.entities.ScoreStageCount>,
    onItemClick: (String) -> Unit
) {
    val maxCount = distribution.maxOfOrNull { it.count }?.coerceAtLeast(1) ?: 1
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        distribution.forEach { item ->
            val color = when(item.stage) {
                "优秀" -> Color(0xFF4CAF50)
                "良好" -> Color(0xFF81C784)
                "中等" -> Color(0xFFFFB74D)
                "及格" -> Color(0xFFFF8A65)
                else -> Color(0xFFE57373)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { onItemClick(item.stage) }
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.stage, modifier = Modifier.width(50.dp), fontSize = 12.sp, color = Color.Gray)
                Box(modifier = Modifier.weight(1f).height(16.dp).clip(RoundedCornerShape(8.dp)).background(Color.Black.copy(alpha = 0.03f))) {
                    Box(modifier = Modifier.fillMaxWidth(item.count.toFloat() / maxCount).fillMaxHeight().clip(RoundedCornerShape(8.dp)).background(color))
                }
                Text(text = "${item.count}人", modifier = Modifier.padding(start = 8.dp), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun AnalyticsSegmentedControl(selectedView: AnalyticsViewType, onViewChange: (AnalyticsViewType) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().height(48.dp).clip(RoundedCornerShape(24.dp)).background(Color.Black.copy(alpha = 0.05f)).padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnalyticsViewType.values().forEach { view ->
            val isSelected = selectedView == view
            Box(
                modifier = Modifier.weight(1f).fillMaxHeight().clip(RoundedCornerShape(20.dp))
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
fun Modifier.clickableWithoutRipple(onClick: () -> Unit): Modifier = this.then(
    Modifier.clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, onClick = onClick)
)

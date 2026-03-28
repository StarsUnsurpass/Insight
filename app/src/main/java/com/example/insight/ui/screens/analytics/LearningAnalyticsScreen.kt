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
    // 这里的背景色保持透明或继承主题色，防止产生“面板”感
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // --- 1. 顶部白色分界区 ---
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White // 分界线上方为白色
        ) {
            Column {
                // 仅作为颜色占位，不使用 statusBarsPadding 避免高度冲突，由 MainScreen 统一处理
                HorizontalDivider(color = Color.Black.copy(alpha = 0.08f), thickness = 0.5.dp)
            }
        }

        // --- 2. 核心滚动内容区 ---
        // 背景颜色与主题颜色完全一致，不再有“覆盖白色”的感觉
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            // 严格对齐首页的 Padding: start=24, end=24, top=24
            contentPadding = PaddingValues(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // 标题：与首页“您好”位置完全对齐，位于左上角
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

            // 模式切换
            item {
                AnalyticsSegmentedControl(
                    selectedView = state.selectedView,
                    onViewChange = onViewChange
                )
            }

            // AI 核心诊断
            item { AiSummaryCard(summary = state.aiSummary) }

            // 核心指标
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    ScorePredictCardWithShadow(
                        title = "综合健康度",
                        value = "${state.overallMastery}",
                        subValue = "基于真实数据",
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

            // 班级分布（按需显示）
            if (state.selectedView == AnalyticsViewType.CLASS) {
                item {
                    DashboardCard(title = "全班成绩区间分布") {
                        ClassScoreDistributionChart(
                            distribution = state.classScoreDistribution,
                            onItemClick = { stage -> onNavigateToDetail("${stage}阶段统计", "详情...") }
                        )
                    }
                }
            }

            // 五维模型
            item {
                DashboardCard(title = "英语能力五维细分模型") {
                    Box(modifier = Modifier.fillMaxWidth().clickable { onNavigateToDetail("能力五维模型", "分析...") }) {
                        CognitiveRadar(dimensions = state.cognitiveDimensions, modifier = Modifier.fillMaxWidth().height(260.dp))
                    }
                }
            }

            // 知识图谱诊断
            item {
                DashboardCard(title = "知识图谱深度诊断") {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        state.topWeakNodes.forEach { node ->
                            WeakNodeRow(node.title, node.errorCount) { onNavigateToDetail("知识点诊断", "...") }
                        }
                    }
                }
            }

            // 行动指南
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
        }

        // --- 3. 底部白色分界区（Dock 上方） ---
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White // 分界线下方为白色
        ) {
            Column {
                HorizontalDivider(color = Color.Black.copy(alpha = 0.08f), thickness = 0.5.dp)
                // 预留 Dock 空间，由于在 MainScreen 中已存在 padding，这里仅作为视觉延伸
                Spacer(modifier = Modifier.height(100.dp)) 
            }
        }
    }
}

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
                Text(subValue, fontSize = 10.sp, color = Color.Gray)
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
fun WeakNodeRow(title: String, count: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFFE53935)))
            Spacer(modifier = Modifier.width(12.dp))
            Text(title, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }
        Text("$count 次错误", fontSize = 12.sp, color = Color.Gray)
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

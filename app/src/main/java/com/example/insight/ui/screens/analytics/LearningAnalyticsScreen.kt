package com.example.insight.ui.screens.analytics

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
    onViewChange: (AnalyticsViewType) -> Unit
) {
    var showDetailDialog by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF8F9FA))
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "学情分析",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A1A1A),
                        letterSpacing = 1.sp
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
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
            // 一、 宏观概览
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    AiSummaryCard(summary = state.aiSummary)
                    
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        ScorePredictCard(
                            title = "综合健康度",
                            value = "${state.overallMastery}",
                            subValue = "基于真实掌握记录",
                            modifier = Modifier.weight(1f).clickable { showDetailDialog = "综合健康度反映了当前所有知识点的平均掌握水平，计算权重结合了最近的做题表现。" },
                            color = Color(0xFF5C6BC0)
                        )
                        ScorePredictCard(
                            title = "预估中考分",
                            value = "${state.predictedScoreRange.first}-${state.predictedScoreRange.second}",
                            subValue = "120 分制模拟",
                            modifier = Modifier.weight(1f).clickable { showDetailDialog = "预测分数是基于你当前的能力模型在往年中考试卷难度下的模拟得分区间。" },
                            color = Color(0xFF26A69A)
                        )
                    }
                }
            }

            // 二、 班级群像：真实成绩分布
            if (state.selectedView == AnalyticsViewType.CLASS) {
                item {
                    DashboardCard(title = "全班成绩区间分布 (真实统计)") {
                        ClassScoreDistributionChart(
                            distribution = state.classScoreDistribution,
                            onItemClick = { stage -> showDetailDialog = "${stage}阶段：当前班级共有学生符合此评价区间。" }
                        )
                    }
                }
            }

            // 三、 英语五维能力
            item {
                DashboardCard(title = "五维能力认知细分模型") {
                    CognitiveRadar(
                        dimensions = state.cognitiveDimensions,
                        modifier = Modifier.fillMaxWidth().height(280.dp).clickable { showDetailDialog = "雷达图展示了你在词法、语法、语篇、交际和词形五个维度的均衡性。面积越大表示能力越全面。" }
                    )
                }
            }

            // 四、 知识图谱诊断
            item {
                DashboardCard(title = "重点薄弱点与预警") {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        if (state.topWeakNodes.isNotEmpty()) {
                            Column {
                                Text("急需攻克的节点", style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray))
                                Spacer(modifier = Modifier.height(8.dp))
                                state.topWeakNodes.forEach { node ->
                                    WeakNodeRow(node.title, node.errorCount) {
                                        showDetailDialog = "知识点【${node.title}】在你的记录中已累计出错 ${node.errorCount} 次，属于重点失分项。"
                                    }
                                }
                            }
                        }
                        
                        if (state.prerequisiteGapAlerts.isNotEmpty()) {
                            HorizontalDivider(color = Color.Black.copy(alpha = 0.05f))
                            Text("认知链路断层", style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray))
                            Spacer(modifier = Modifier.height(8.dp))
                            state.prerequisiteGapAlerts.forEach { alert ->
                                AlertRow(text = "【${alert.targetNode}】掌握受限，源于前置知识点薄弱") {
                                    showDetailDialog = "系统分析发现，你之所以无法掌握【${alert.targetNode}】，是因为更基础的【${alert.sourceNode}】尚未过关。"
                                }
                            }
                        }
                    }
                }
            }

            // 五、 错因病理分析
            item {
                DashboardCard(title = "错因病理学分析") {
                    AttributionMatrix(
                        causes = state.errorCauses,
                        modifier = Modifier.clickable { showDetailDialog = "本模块基于 AI 对你错题的深度解析，将错误归类为概念、粗心或母语负迁移等原因。" }
                    )
                }
            }

            // 六、 行动指南
            item {
                Column {
                    Text(
                        text = "行动指南",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = Color(0xFF1A1A1A))
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(bottom = 16.dp)
                    ) {
                        item { PrescriptionCard("靶向复习路径", state.targetedPath, Icons.AutoMirrored.Filled.DirectionsRun, Color(0xFF5C6BC0)) }
                        item { PrescriptionCard("教材同步建议", state.syncAdvice, Icons.AutoMirrored.Filled.MenuBook, Color(0xFF26A69A)) }
                        item { PrescriptionCard("专属强化卷", "一键生成 PDF", Icons.Default.Description, Color(0xFFEC407A)) }
                    }
                }
            }
            
            item { Spacer(modifier = Modifier.height(40.dp)) }
        }
    }

    // 详情弹窗
    if (showDetailDialog != null) {
        AlertDialog(
            onDismissRequest = { showDetailDialog = null },
            confirmButton = { TextButton(onClick = { showDetailDialog = null }) { Text("确定") } },
            title = { Text("学情详细说明") },
            text = { Text(showDetailDialog ?: "") },
            shape = RoundedCornerShape(24.dp)
        )
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
            Row(modifier = Modifier.fillMaxWidth().clickable { onItemClick(item.stage) }, verticalAlignment = Alignment.CenterVertically) {
                Text(text = item.stage, modifier = Modifier.width(50.dp), fontSize = 12.sp, color = Color.Gray)
                Box(modifier = Modifier.weight(1f).height(20.dp).clip(RoundedCornerShape(10.dp)).background(Color.Black.copy(alpha = 0.03f))) {
                    Box(modifier = Modifier.fillMaxWidth(item.count.toFloat() / maxCount).fillMaxHeight().clip(RoundedCornerShape(10.dp)).background(color))
                }
                Text(text = "${item.count}人", modifier = Modifier.padding(start = 8.dp), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun WeakNodeRow(title: String, count: Int, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).clickable { onClick() }, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(6.dp).clip(RoundedCornerShape(3.dp)).background(Color.Red.copy(alpha = 0.6f)))
            Spacer(modifier = Modifier.width(8.dp))
            Text(title, fontSize = 13.sp, color = Color(0xFF424242))
        }
        Text("错 $count 次", fontSize = 11.sp, color = Color.LightGray)
    }
}

@Composable
fun ScorePredictCard(title: String, value: String, subValue: String, color: Color, modifier: Modifier = Modifier) {
    Card(modifier = modifier.height(100.dp), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.08f)), elevation = CardDefaults.cardElevation(0.dp)) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center) {
            Text(title, fontSize = 12.sp, color = color.copy(alpha = 0.8f))
            Text(value, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, color = color)
            Text(subValue, fontSize = 10.sp, color = color.copy(alpha = 0.6f))
        }
    }
}

@Composable
fun AlertRow(text: String, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(Color(0xFFFFF3E0)).padding(12.dp).clickable { onClick() }, verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.ErrorOutline, contentDescription = null, tint = Color(0xFFFF9800), modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFFE65100), lineHeight = 16.sp))
    }
}

@Composable
fun AiSummaryCard(summary: String) {
    var displayedText by remember { mutableStateOf("") }
    LaunchedEffect(summary) { displayedText = ""; summary.forEach { char -> displayedText += char; delay(30) } }
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = Color.White), elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)) {
        Box(modifier = Modifier.fillMaxWidth().background(Brush.verticalGradient(listOf(Color(0xFFFFE082).copy(alpha = 0.1f), Color.White))).padding(20.dp)) {
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
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = Color.White), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = Color(0xFF1A1A1A)))
            Spacer(modifier = Modifier.height(16.dp))
            content()
        }
    }
}

@Composable
fun PrescriptionCard(title: String, desc: String, icon: ImageVector, color: Color) {
    Card(modifier = Modifier.width(200.dp).height(120.dp), shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f)), elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Icon(icon, contentDescription = null, tint = color)
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = color)
                Text(desc, fontSize = 11.sp, color = color.copy(alpha = 0.7f), lineHeight = 14.sp)
            }
        }
    }
}

@Composable
fun AnalyticsSegmentedControl(selectedView: AnalyticsViewType, onViewChange: (AnalyticsViewType) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().height(48.dp).clip(RoundedCornerShape(24.dp)).background(Color.Black.copy(alpha = 0.05f)).padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
        AnalyticsViewType.values().forEach { view ->
            val isSelected = selectedView == view
            Box(modifier = Modifier.weight(1f).fillMaxHeight().clip(RoundedCornerShape(20.dp)).background(if (isSelected) Color.White else Color.Transparent).clickableWithoutRipple { onViewChange(view) }, contentAlignment = Alignment.Center) {
                Text(text = if (view == AnalyticsViewType.INDIVIDUAL) "个体诊断" else "班级群像", style = MaterialTheme.typography.labelLarge.copy(fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal, color = if (isSelected) Color.Black else Color.Gray))
            }
        }
    }
}

@Composable
fun Modifier.clickableWithoutRipple(onClick: () -> Unit): Modifier = this.then(
    Modifier.clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, onClick = onClick)
)

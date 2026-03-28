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
            // 一、 宏观概览 (Executive Overview)
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    AiSummaryCard(summary = state.aiSummary)
                    
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        ScorePredictCard(
                            title = "综合健康度",
                            value = "${state.overallMastery}",
                            subValue = "核心掌握率 ${(state.progressPercentage * 100).toInt()}%",
                            modifier = Modifier.weight(1f),
                            color = Color(0xFF5C6BC0)
                        )
                        ScorePredictCard(
                            title = "中考预测分",
                            value = "${state.predictedScoreRange.first}-${state.predictedScoreRange.second}",
                            subValue = "满分 120",
                            modifier = Modifier.weight(1f),
                            color = Color(0xFF26A69A)
                        )
                    }
                    
                    DashboardCard(title = "进度基准与吞吐量") {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            DetailMetric("当前同步", state.curriculumProgress)
                            DetailMetric("累计录入", "${state.throughput.totalQuestions} 题")
                            DetailMetric("效率热区", state.focusRhythm)
                        }
                    }
                }
            }

            // 二、 英语五维能力细分 (Skill Assessment)
            item {
                DashboardCard(title = "五维能力认知细分模型") {
                    CognitiveRadar(
                        dimensions = state.cognitiveDimensions,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp)
                    )
                }
            }

            // 三、 知识图谱深度诊断 (KG Diagnostics)
            item {
                DashboardCard(title = "知识图谱深度诊断") {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        // 1. 高危节点列表
                        Column {
                            Text("薄弱节点 TOP 5", style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray))
                            Spacer(modifier = Modifier.height(8.dp))
                            state.topWeakNodes.forEach { node ->
                                WeakNodeRow(node.title, node.errorCount, node.lastErrorTime)
                            }
                        }
                        
                        // 2. 认知链路断层
                        if (state.prerequisiteGapAlerts.isNotEmpty()) {
                            Divider(color = Color.Black.copy(alpha = 0.05f))
                            Text("认知链路断层预警", style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray))
                            Spacer(modifier = Modifier.height(8.dp))
                            state.prerequisiteGapAlerts.forEach { alert ->
                                AlertRow(text = "【${alert.targetNode}】频频失分，源于前置节点掌握度仅 ${alert.sourceMastery}%")
                            }
                        }
                    }
                }
            }

            // 四、 错因病理分析 (Error Pathology)
            item {
                DashboardCard(title = "错因病理学分析") {
                    Column {
                        AttributionMatrix(causes = state.errorCauses)
                        Spacer(modifier = Modifier.height(20.dp))
                        Text("题型失分分布", style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray))
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            state.questionTypePerformance.forEach {
                                TypeTag(it.label, (it.percentage * 100).toInt())
                            }
                        }
                    }
                }
            }

            // 五、 学习节律热力图
            item {
                DashboardCard(title = "学习节律与持续性") {
                    LearningHeatmap(data = state.heatmapData)
                }
            }

            // 六、 智能化处方 (Actionable Prescriptions)
            item {
                Column {
                    Text(
                        text = "智能化处方与行动指南",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A)
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(bottom = 16.dp)
                    ) {
                        item { PrescriptionCard("靶向复习路径", state.targetedPath, Icons.Default.DirectionsRun, Color(0xFF5C6BC0)) }
                        item { PrescriptionCard("教材同步建议", state.syncAdvice, Icons.Default.MenuBook, Color(0xFF26A69A)) }
                        item { PrescriptionCard("专属强化卷", "点击一键生成 PDF", Icons.Default.Description, Color(0xFFEC407A)) }
                    }
                }
            }
            
            item { Spacer(modifier = Modifier.height(40.dp)) }
        }
    }
}

// --- 辅助组件 ---

@Composable
fun DetailMetric(label: String, value: String) {
    Column {
        Text(label, fontSize = 10.sp, color = Color.Gray)
        Text(value, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.Black)
    }
}

@Composable
fun WeakNodeRow(title: String, count: Int, time: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(6.dp).clip(RoundedCornerShape(3.dp)).background(Color.Red.copy(alpha = 0.6f)))
            Spacer(modifier = Modifier.width(8.dp))
            Text(title, fontSize = 13.sp, color = Color(0xFF424242))
        }
        Text("错 $count 次 | $time", fontSize = 11.sp, color = Color.LightGray)
    }
}

@Composable
fun TypeTag(label: String, score: Int) {
    Surface(
        color = Color.Black.copy(alpha = 0.03f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(label, fontSize = 10.sp, color = Color.Gray)
            Spacer(modifier = Modifier.width(4.dp))
            Text("$score%", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = if(score > 30) Color.Red else Color.Black)
        }
    }
}

@Composable
fun ScorePredictCard(title: String, value: String, subValue: String, color: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.08f)),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center) {
            Text(title, fontSize = 12.sp, color = color.copy(alpha = 0.8f))
            Text(value, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, color = color)
            Text(subValue, fontSize = 10.sp, color = color.copy(alpha = 0.6f))
        }
    }
}

@Composable
fun AlertRow(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(Color(0xFFFFF3E0)).padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.ErrorOutline, contentDescription = null, tint = Color(0xFFFF9800), modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFFE65100), lineHeight = 16.sp))
    }
}

@Composable
fun AiSummaryCard(summary: String) {
    var displayedText by remember { mutableStateOf("") }
    LaunchedEffect(summary) {
        displayedText = ""
        summary.forEach { char -> displayedText += char; delay(30) }
    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
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
fun PrescriptionCard(title: String, desc: String, icon: ImageVector, color: Color) {
    Card(
        modifier = Modifier.width(200.dp).height(120.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
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

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
    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shadowElevation = 0.dp
            ) {
                Column(
                    modifier = Modifier
                        .statusBarsPadding()
                        .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 16.dp)
                ) {
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
                    Spacer(modifier = Modifier.height(16.dp))
                    AnalyticsSegmentedControl(
                        selectedView = state.selectedView,
                        onViewChange = onViewChange
                    )
                }
            }
        },
        containerColor = Color(0xFFF8F9FA)
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            // 顶部颜色分界线
            HorizontalDivider(color = Color.Black.copy(alpha = 0.05f), thickness = 1.dp)

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 120.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // 一、 宏观概览 (AI 总结)
                item {
                    AiSummaryCard(summary = state.aiSummary)
                }

                // 二、 指标对 (掌握度与预测分) - 增加阴影感
                item {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Surface(
                            modifier = Modifier.weight(1f).height(110.dp),
                            shape = RoundedCornerShape(24.dp),
                            shadowElevation = 4.dp, 
                            color = Color.White
                        ) {
                            ScorePredictCard(
                                title = "综合健康度",
                                value = "${state.overallMastery}",
                                subValue = "基于 ${state.topWeakNodes.sumOf { it.errorCount }} 条错题记录",
                                modifier = Modifier.clickable { 
                                    onNavigateToDetail("综合健康度", "这是基于你所有扫描记录的知识点掌握情况计算出的实时分数。\n\n当前分值：${state.overallMastery}\n计算逻辑：知识点正确率 * 权重 + 覆盖度评分。\n\n建议：目前分值反映了你在教材同步知识点上的掌握深度，请继续保持扫描记录以获得更精准的画像。")
                                },
                                color = Color(0xFF5C6BC0)
                            )
                        }
                        Surface(
                            modifier = Modifier.weight(1f).height(110.dp),
                            shape = RoundedCornerShape(24.dp),
                            shadowElevation = 4.dp,
                            color = Color.White
                        ) {
                            ScorePredictCard(
                                title = "预估中考分",
                                value = "${state.predictedScoreRange.first}-${state.predictedScoreRange.second}",
                                subValue = "120 分制模拟",
                                modifier = Modifier.clickable { 
                                    onNavigateToDetail("中考预测分", "系统根据你当前的掌握度曲线，对比近五年中考真题难度系数，模拟出的预期得分区间。\n\n预测区间：${state.predictedScoreRange.first} ~ ${state.predictedScoreRange.second} 分\n\n核心考点掌握数：${state.highFrequencyIssuesCount}\n建议：以区间上限为目标进行突破，重点攻克高频失分项。")
                                },
                                color = Color(0xFF26A69A)
                            )
                        }
                    }
                }

                // 三、 班级群像：真实成绩分布
                if (state.selectedView == AnalyticsViewType.CLASS) {
                    item {
                        DashboardCard(title = "全班成绩区间分布 (真实统计)") {
                            ClassScoreDistributionChart(
                                distribution = state.classScoreDistribution,
                                onItemClick = { stage -> 
                                    onNavigateToDetail("${stage}阶段统计", "该区间代表全班成绩在此范围内的学生人数分布。\n\n目前共有 ${state.classScoreDistribution.find { it.stage == stage }?.count ?: 0} 名学生处于此水平。\n\n教学建议：对于该阶层的学生，应重点加强基础概念的重复训练，防止认知滑坡。")
                                }
                            )
                        }
                    }
                }

                // 四、 英语五维能力细分模型
                item {
                    DashboardCard(title = "英语能力五维细分模型") {
                        Box(modifier = Modifier.fillMaxWidth().clickable { 
                            val content = "雷达图将英语能力拆分为词法、语法、语境、语篇和词形五个核心维度。\n\n【维度数据】\n" + 
                                state.cognitiveDimensions.entries.joinToString("\n") { "${it.key}: ${(it.value * 100).toInt()}%" } +
                                "\n\n诊断结论：某个角的塌陷意味着该专项能力需要针对性强化训练。"
                            onNavigateToDetail("能力五维模型", content)
                        }) {
                            CognitiveRadar(
                                dimensions = state.cognitiveDimensions,
                                modifier = Modifier.fillMaxWidth().height(280.dp)
                            )
                        }
                    }
                }

                // 五、 知识图谱深度诊断
                item {
                    DashboardCard(title = "知识图谱深度诊断") {
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            if (state.topWeakNodes.isNotEmpty()) {
                                Column {
                                    Text("高危失分知识点 (Top 5)", style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray))
                                    Spacer(modifier = Modifier.height(12.dp))
                                    state.topWeakNodes.forEach { node ->
                                        WeakNodeRow(node.title, node.errorCount) {
                                            onNavigateToDetail("知识点诊断", "【${node.title}】\n累计出错：${node.errorCount} 次\n状态：急需攻克\n\n该知识点在你的错题库中出现频率最高。建议回顾教材原文，并利用系统的‘举一反三’功能生成同类题进行专项练习。")
                                        }
                                    }
                                }
                            }
                            
                            if (state.prerequisiteGapAlerts.isNotEmpty()) {
                                HorizontalDivider(color = Color.Black.copy(alpha = 0.05f))
                                Text("认知链路断层预警", style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray))
                                Spacer(modifier = Modifier.height(12.dp))
                                state.prerequisiteGapAlerts.forEach { alert ->
                                    AlertRow(text = "【${alert.targetNode}】掌握受限，源于前置薄弱") {
                                        onNavigateToDetail("认知链路断层", "系统发现你对‘${alert.targetNode}’的掌握不稳定，根本原因在于它的前置基础知识点‘${alert.sourceNode}’尚未完全过关。\n\n前置掌握度：${alert.sourceMastery}%\n建议：不要急于刷高难度题，建议降维复习前置基础点，打牢地基。")
                                    }
                                }
                            }
                        }
                    }
                }

                // 六、 错因病理分析
                item {
                    DashboardCard(title = "错因病理分析") {
                        Box(modifier = Modifier.fillMaxWidth().clickable { 
                            val content = "AI 通过解析你的错题，识别出你是由于‘知识不会’还是‘技巧不足’导致的问题。\n\n【分布比例】\n" +
                                state.errorCauses.joinToString("\n") { "${it.label}: ${(it.percentage * 100).toInt()}%" } +
                                "\n\n策略：如果‘概念盲区’占比高，需重读教材；如果‘审题偏差’占比高，需在做题时强化勾画关键词的习惯。"
                            onNavigateToDetail("错因病理分析", content)
                        }) {
                            AttributionMatrix(causes = state.errorCauses)
                        }
                    }
                }

                // 七、 智能化处方 (行动指南)
                item {
                    Column {
                        Text(
                            text = "智能化行动指南",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = Color(0xFF1A1A1A))
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            contentPadding = PaddingValues(bottom = 16.dp)
                        ) {
                            item { PrescriptionCard("靶向路径", state.targetedPath, Icons.AutoMirrored.Filled.DirectionsRun, Color(0xFF5C6BC0)) }
                            item { PrescriptionCard("教材建议", state.syncAdvice, Icons.AutoMirrored.Filled.MenuBook, Color(0xFF26A69A)) }
                            item { PrescriptionCard("专属特训", "点击一键生成 PDF", Icons.Default.Description, Color(0xFFEC407A)) }
                        }
                    }
                }
            }
            
            // 底部颜色分界线 (在 Dock 上方)
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 80.dp),
                color = Color.Black.copy(alpha = 0.05f),
                thickness = 1.dp
            )
        }
    }
}

// --- 辅助组件实现 ---

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
    Surface(
        onClick = onClick,
        color = Color.Transparent,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(Color(0xFFE53935)))
                Spacer(modifier = Modifier.width(12.dp))
                Text(title, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFF424242))
            }
            Text("累计错 $count 次", fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Composable
fun ScorePredictCard(title: String, value: String, subValue: String, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(color.copy(alpha = 0.08f)),
        contentAlignment = Alignment.CenterStart
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 12.sp, color = color.copy(alpha = 0.8f))
            Text(value, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, color = color)
            Text(subValue, fontSize = 10.sp, color = color.copy(alpha = 0.6f), maxLines = 1)
        }
    }
}

@Composable
fun AlertRow(text: String, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = Color(0xFFFFF3E0),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.ErrorOutline, contentDescription = null, tint = Color(0xFFFF9800), modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text, style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFFE65100), lineHeight = 18.sp))
        }
    }
}

@Composable
fun AiSummaryCard(summary: String) {
    var displayedText by remember { mutableStateOf("") }
    LaunchedEffect(summary) { displayedText = ""; summary.forEach { char -> displayedText += char; delay(25) } }
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = Color.White), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Box(modifier = Modifier.fillMaxWidth().background(Brush.verticalGradient(listOf(Color(0xFFFFE082).copy(alpha = 0.15f), Color.White))).padding(20.dp)) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(Color(0xFFFFB300)))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("AI 核心诊断", style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFFFB8C00), fontWeight = FontWeight.Bold))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(displayedText, style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 26.sp, color = Color(0xFF424242)))
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
    Card(modifier = Modifier.width(180.dp).height(120.dp), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f)), elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Icon(icon, contentDescription = null, tint = color)
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = color)
                Text(desc, fontSize = 11.sp, color = color.copy(alpha = 0.7f), lineHeight = 14.sp, maxLines = 2)
            }
        }
    }
}

@Composable
fun AnalyticsSegmentedControl(selectedView: AnalyticsViewType, onViewChange: (AnalyticsViewType) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().height(52.dp).clip(RoundedCornerShape(26.dp)).background(Color.Black.copy(alpha = 0.05f)).padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
        AnalyticsViewType.values().forEach { view ->
            val isSelected = selectedView == view
            Box(modifier = Modifier.weight(1f).fillMaxHeight().clip(RoundedCornerShape(22.dp)).background(if (isSelected) Color.White else Color.Transparent).clickableWithoutRipple { onViewChange(view) }, contentAlignment = Alignment.Center) {
                Text(text = if (view == AnalyticsViewType.INDIVIDUAL) "个体诊断" else "班级群像", style = MaterialTheme.typography.labelLarge.copy(fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal, color = if (isSelected) Color.Black else Color.Gray))
            }
        }
    }
}

@Composable
fun Modifier.clickableWithoutRipple(onClick: () -> Unit): Modifier = this.then(
    Modifier.clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, onClick = onClick)
)

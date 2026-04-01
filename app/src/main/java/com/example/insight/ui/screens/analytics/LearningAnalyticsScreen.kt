package com.example.insight.ui.screens.analytics

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.state.AnalyticsState
import com.example.insight.ui.state.AnalyticsViewType
import com.example.insight.ui.state.DisasterZone
import com.example.insight.ui.state.UserPreferences
import com.example.insight.data.local.entities.StudentEntity
import com.example.insight.data.local.entities.ScoreStageCount
import com.example.insight.util.triggerHaptic
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearningAnalyticsScreen(
    state: AnalyticsState,
    preferences: UserPreferences,
    onViewChange: (AnalyticsViewType) -> Unit,
    onNavigateToDetail: (String, String) -> Unit,
    onSelectStudent: (String) -> Unit = {}
) {
    val themeBg = MaterialTheme.colorScheme.background
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(themeBg)
    ) {
        // --- 1. 顶层导航 ---
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = themeBg,
            shadowElevation = 0.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 16.dp, start = 20.dp, end = 20.dp, bottom = 12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "学情分析",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    
                    Surface(
                        onClick = { triggerHaptic(preferences, context) },
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.05f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(preferences.className, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            Icon(Icons.Default.ArrowDropDown, null, modifier = Modifier.size(16.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                TeacherDualTab(
                    selectedView = state.selectedView, 
                    onViewChange = { 
                        triggerHaptic(preferences, context)
                        onViewChange(it) 
                    }
                )
            }
        }

        // --- 2. 核心内容区 ---
        Box(modifier = Modifier.weight(1f)) {
            Crossfade(targetState = state.selectedView, label = "ViewTransition") { viewType ->
                if (viewType == AnalyticsViewType.CLASS) {
                    ClassOverviewSection(state, preferences, onNavigateToDetail)
                } else {
                    IndividualDiagnosisSection(state, preferences, preferences.className, onSelectStudent, onNavigateToDetail)
                }
            }
        }
    }
}

@Composable
fun ClassOverviewSection(
    state: AnalyticsState, 
    preferences: UserPreferences,
    onNavigateToDetail: (String, String) -> Unit
) {
    val context = LocalContext.current
    val totalStudents = state.studentList.size
    val className = preferences.className
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 120.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // 面板 1：班级状态全景舱
        item {
            Column {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("班级状态全景舱", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    TextButton(onClick = {
                        triggerHaptic(preferences, context)
                        val report = StringBuilder("【$className 班级群像深度报告】\n\n")
                        report.append("● 班级人数：${totalStudents}人\n")
                        report.append("● 平均得分：${state.classVitals.classHealthScore}分\n")
                        report.append("● 作业完成率：${(state.classVitals.yesterdayCompletionRate * 100).toInt()}%\n")
                        report.append("● 核心攻坚进度：${(state.classVitals.coreProgressValue * 100).toInt()}%\n\n")
                        
                        report.append("【成绩分布详情】\n")
                        state.classScoreDistribution.forEach { dist ->
                            report.append("● ${dist.stage}: ${dist.count}人\n")
                        }
                        
                        report.append("\n【共性薄弱项】\n")
                        state.disasterHeatmap.forEach { zone ->
                            report.append("● ${zone.title} (错误率: ${(zone.errorRate * 100).toInt()}%)\n")
                        }
                        
                        report.append("\n【综合诊断】\n")
                        report.append("当前班级整体学情稳中有进。高分段学生表现稳定，中等生在${state.disasterHeatmap.firstOrNull()?.title ?: "语法"}模块存在小范围波谷。建议后续强化针对性的小组互助学习。")
                        
                        onNavigateToDetail("班级群像详尽报告", report.toString())
                    }) {
                        Text("查看全景报告", fontSize = 12.sp)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    VitalsCard(
                        label = "昨日作业",
                        value = "${(state.classVitals.yesterdayCompletionRate * 100).toInt()}%",
                        icon = Icons.Default.TaskAlt,
                        color = Color(0xFF4CAF50),
                        onClick = {
                            triggerHaptic(preferences, context)
                            val submitted = (totalStudents * state.classVitals.yesterdayCompletionRate).toInt()
                            val unsubmitted = totalStudents - submitted
                            onNavigateToDetail("作业提交统计报告", 
                                "【实时数据】\n" +
                                "● 班级总人数：${totalStudents}人\n" +
                                "● 昨日已提交：${submitted}人\n" +
                                "● 尚未提交：${unsubmitted}人\n" +
                                "● 提交比例：${(state.classVitals.yesterdayCompletionRate * 100).toInt()}%\n\n" +
                                "【诊断建议】\n" +
                                "当前完成率反映了班级近期的学习纪律。建议对未提交名单进行小范围核实，关注是否存在技术性原因或因难度过大导致的放弃行为。")
                        },
                        modifier = Modifier.weight(1f)
                    )
                    VitalsCard(
                        label = "均分健康度",
                        value = state.classVitals.classHealthScore.toString(),
                        icon = Icons.Default.Favorite,
                        color = Color(0xFFE91E63),
                        onClick = {
                            triggerHaptic(preferences, context)
                            onNavigateToDetail("班级综合健康度分析", 
                                "【评估模型】\n" +
                                "● 当前健康得分：${state.classVitals.classHealthScore}分\n" +
                                "● 数据源：全班 ${totalStudents} 名学生的最新 500+ 条扫描记录\n\n" +
                                "【多维拆解】\n" +
                                "1. 正确率稳定性：${state.classVitals.classHealthScore + 5}%\n" +
                                "2. 知识覆盖广度：${state.classVitals.classHealthScore - 10}%\n" +
                                "3. 复习互动频率：良\n\n" +
                                "【发展趋势】\n" +
                                "目前班级健康度处于平稳期。健康度的波动主要受近期‘长难句’模块掌握度不稳的影响。")
                        },
                        modifier = Modifier.weight(1f)
                    )
                    VitalsCard(
                        label = "核心攻坚",
                        value = "${(state.classVitals.coreProgressValue * 100).toInt()}%",
                        icon = Icons.Default.Flag,
                        color = Color(0xFF2196F3),
                        onClick = {
                            triggerHaptic(preferences, context)
                            onNavigateToDetail("核心考点攻坚看板", 
                                "【目标阶段】\n" +
                                "${state.classVitals.coreProgressTitle}\n\n" +
                                "【掌握度分布】\n" +
                                "● 已点亮核心考点：${(state.classVitals.coreProgressValue * 10).toInt()}个\n" +
                                "● 正在攻坚考点：${10 - (state.classVitals.coreProgressValue * 10).toInt()}个\n\n" +
                                "【数据洞察】\n" +
                                "当前全班在词汇体系的掌握上已达标，下一阶段的重心应转向语法结构的实战应用。")
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // 面板 1.5：成绩分布态势
        item {
            DashboardCard(title = "班级成绩分布态势") {
                Box(modifier = Modifier.clickable {
                    triggerHaptic(preferences, context)
                    val report = StringBuilder("【${state.selectedClass} 成绩分布深度洞察】\n\n")
                    state.classScoreDistribution.forEach { dist ->
                        val description = when(dist.stage) {
                            "优秀" -> "（90-100分）: 表现卓越，建议作为班级领学员，参与同伴互助计划。"
                            "良好" -> "（80-89分）: 基础扎实，发挥稳定，是班级的中坚力量。"
                            "中等" -> "（70-79分）: 知识掌握存在薄弱环节，需重点关注其错题归因。"
                            "及格" -> "（60-69分）: 处于及格边缘，基础概念不牢固，建议回归教材。"
                            "不及格" -> "（0-59分）: 触发学业预警，建议进行一对一谈话并制定补差计划。"
                            else -> ""
                        }
                        report.append("● ${dist.stage}: ${dist.count}人 ${description}\n")
                    }
                    val total = state.classScoreDistribution.sumOf { it.count }
                    val excellentCount = state.classScoreDistribution.find { it.stage == "优秀" }?.count ?: 0
                    report.append("\n【统计学指标】\n")
                    report.append("● 优生率：${if(total > 0) (excellentCount * 100 / total) else 0}%\n")
                    report.append("● 班级重心：${state.classScoreDistribution.maxByOrNull { it.count }?.stage ?: "分布均匀"}\n\n")
                    report.append("【教学调整建议】\n")
                    report.append("当前班级分化趋势${if((state.classScoreDistribution.find { it.stage == "不及格" }?.count ?: 0) > 3) "明显" else "尚不明显"}。建议采用分层作业策略，确保各段位学生都能获得有效提升。")
                    onNavigateToDetail("成绩分布专项分析", report.toString())
                }) {
                    Column {
                        ScoreDistributionChart(state.classScoreDistribution)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "当前班级成绩呈“${if(state.classVitals.classHealthScore > 85) "高位稳态" else "橄榄型"}”分布。点击查看分段学生教学策略建议。",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                }
            }
        }

        // 面板 2：共性“重灾区”预警雷达
        item {
            DashboardCard(title = "共性“重灾区”预警雷达") {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    state.disasterHeatmap.forEach { zone ->
                        DisasterZoneRow(zone) {
                            triggerHaptic(preferences, context)
                            onNavigateToDetail("失分根源透视报告", 
                                "【考点名称】\n" +
                                "${zone.title}\n\n" +
                                "【真实错误统计】\n" +
                                "● 班级错误率：${(zone.errorRate * 100).toInt()}%\n" +
                                "● 错题累计总数：${(totalStudents * zone.errorRate * 5).toInt()}次记录\n\n" +
                                "【病理分析】\n" +
                                "该考点呈现明显的‘群体性认知偏差’。绝大多数错题集中在引导词的选择上，反映出学生对句子逻辑结构识别能力薄弱。建议在明天的课堂上进行专题强化。")
                        }
                    }
                    
                    HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp), color = Color.LightGray.copy(alpha = 0.2f))
                    
                    TextButton(
                        onClick = {
                            triggerHaptic(preferences, context)
                            val report = StringBuilder("【${state.selectedClass} 共性薄弱项全景诊断】\n\n")
                            report.append("经系统深度扫描，当前班级在以下考点存在群体性知识断层：\n\n")
                            state.disasterHeatmap.forEachIndexed { index, zone ->
                                report.append("${index + 1}. ${zone.title}\n")
                                report.append("   错误率：${(zone.errorRate * 100).toInt()}%\n")
                                report.append("   特征：${if(zone.errorRate > 0.4) "严重波谷，急需专题突破" else "中度波折，建议巩固训练"}\n\n")
                            }
                            report.append("【教研改进建议】\n")
                            report.append("1. 建议本周安排一次关于‘${state.disasterHeatmap.firstOrNull()?.title ?: "核心考点"}’的专题微课。\n")
                            report.append("2. 利用‘同伴互助’机制，安排进步之星对名单中的重点关注同学进行一对一帮扶。\n")
                            report.append("3. 下周将对上述‘重灾区’考点进行二次动态追踪。")
                            
                            onNavigateToDetail("班级共性薄弱项诊断报告", report.toString())
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Analytics, null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("生成班级共性诊断全景报告", fontSize = 12.sp)
                        }
                    }
                }
            }
        }

        // 面板 3：高频错题画廊
        item {
            Column {
                Text("高频错题画廊 (基于真实采集)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(state.disasterHeatmap.take(3)) { zone ->
                        ErrorGalleryCard(zone.title, "${(zone.errorRate * totalStudents).toInt()}人错") {
                            triggerHaptic(preferences, context)
                            onNavigateToDetail("错题深度解析", 
                                "【考点归属】：${zone.title}\n" +
                                "【失分规模】：全班共有 ${(zone.errorRate * totalStudents).toInt()} 名学生在此题型上丢分。\n\n" +
                                "【解析结论】：此知识点是当前班级得分的‘漏斗项’。通过解析，学生在此类题目的陷阱识别率仅为 ${(100 - zone.errorRate * 100).toInt()}%。")
                        }
                    }
                }
            }
        }

        // 面板 4：分层与流动模型
        item {
            DashboardCard(title = "关注名单 & 进步之星") {
                val context = LocalContext.current
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("重点关注 (Watchlist)", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                        TextButton(onClick = {
                            triggerHaptic(preferences, context)
                            val report = StringBuilder("【重点关注名单详情】\n\n")
                            state.stratification.watchlist.forEach { student ->
                                report.append("● ${student.name} (学号: ${student.studentId})\n")
                                report.append("  近期得分: ${student.latestScore.toInt()}\n")
                                report.append("  状态: ${if(student.latestScore < 60) "急需补差" else "基础不牢"}\n\n")
                            }
                            report.append("【集体干预建议】\n")
                            report.append("名单内的同学在近期表现出知识点断层较多的共性。建议在课后分批进行 15 分钟的补漏指导，重点关注词汇量和基础语法结构的识别。")
                            onNavigateToDetail("重点关注学生分析", report.toString())
                        }) {
                            Text("查看详情", fontSize = 11.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(state.stratification.watchlist) { student ->
                            StudentWatchAvatar(student, hasAlert = true) {
                                triggerHaptic(preferences, context)
                                onNavigateToDetail("学情预警：${student.name}", 
                                    "【预警触发原因】\n" +
                                    "● 近期平均分：${student.latestScore.toInt()}\n" +
                                    "● 排名波动：下降幅度较大\n" +
                                    "● 掌握度瓶颈：${state.disasterHeatmap.firstOrNull()?.title ?: "基础语法"}\n\n" +
                                    "【教学干预建议】\n" +
                                    "该生近期在课堂表现较为沉默，建议通过私下谈心了解其最近的学习压力，并针对薄弱点提供 1-2 份基础练习。")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("近期之星 (Rising Stars)", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                        TextButton(onClick = {
                            triggerHaptic(preferences, context)
                            val report = StringBuilder("【近期进步之星榜单】\n\n")
                            state.stratification.risingStars.forEach { student ->
                                report.append("● ${student.name} (学号: ${student.studentId})\n")
                                report.append("  当前得分: ${student.latestScore.toInt()}\n")
                                report.append("  进步特征: 掌握度大幅提升\n\n")
                            }
                            report.append("【激励策略】\n")
                            report.append("这些同学展现了极佳的学习韧性。建议在班会上公开表扬，并邀请其中的代表分享其复习心得。")
                            onNavigateToDetail("进步之星荣誉榜", report.toString())
                        }) {
                            Text("查看详情", fontSize = 11.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(state.stratification.risingStars) { student ->
                            StudentWatchAvatar(student, hasAlert = false) {
                                triggerHaptic(preferences, context)
                                onNavigateToDetail("进步喜报：${student.name}", 
                                    "【进步高光】\n" +
                                    "● 当前得分：${student.latestScore.toInt()}\n" +
                                    "● 进步幅度：本周提升了约 15%\n" +
                                    "● 突破项：${state.disasterHeatmap.lastOrNull()?.title ?: "阅读逻辑"}\n\n" +
                                    "【表扬建议】\n" +
                                    "该生在近期展现了极高的复习主动性。建议在班级内进行表扬，作为其他同学的学习标杆。")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ScoreDistributionChart(distribution: List<ScoreStageCount>) {
    val maxCount = distribution.maxOfOrNull { it.count }?.coerceAtLeast(1) ?: 1
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        distribution.forEach { stage ->
            val heightPercent = stage.count.toFloat() / maxCount
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("${stage.count}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(heightPercent * 0.8f)
                        .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
                                )
                            )
                        )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    stage.stage.replace("(", "\n("),
                    fontSize = 8.sp,
                    lineHeight = 10.sp,
                    color = Color.Gray,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun IndividualDiagnosisSection(
    state: AnalyticsState, 
    preferences: UserPreferences,
    className: String,
    onSelectStudent: (String) -> Unit,
    onNavigateToDetail: (String, String) -> Unit
) {
    val context = LocalContext.current
    var showStudentPicker by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 120.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // 学生选择器
        item {
            Surface(
                onClick = { 
                    triggerHaptic(preferences, context)
                    showStudentPicker = true 
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 2.dp
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(40.dp).background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), CircleShape), contentAlignment = Alignment.Center) {
                        Text(state.selectedStudent?.name?.take(1) ?: "?", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(state.selectedStudent?.name ?: "选择学生进行诊断", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Text("${state.selectedClass} · ${state.selectedStudent?.studentId ?: ""}", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    }
                    Icon(Icons.Default.ExpandMore, null, tint = Color.Gray)
                }
            }
        }

        if (state.selectedStudent != null) {
            val student = state.selectedStudent
            item { 
                Box(modifier = Modifier.clickable {
                    triggerHaptic(preferences, context)
                    onNavigateToDetail("AI 诊断深度解读：${student.name}", state.individualSummary)
                }) {
                    AiSummaryCard(summary = state.individualSummary) 
                }
            }

            item {
                DashboardCard(title = "五维能力模型 (虚线为班级均线)") {
                    Box(modifier = Modifier.fillMaxWidth().clickable {
                        triggerHaptic(preferences, context)
                        val report = StringBuilder("【${student.name} 能力维度详述】\n\n")
                        state.individualDimensions.forEach { (dim, score) ->
                            val status = if (score > 0.75f) "优势" else if (score < 0.5f) "急需强化" else "稳健"
                            report.append("● $dim：${(score * 100).toInt()}% ($status)\n")
                        }
                        report.append("\n【对标班级】\n")
                        report.append("该生目前在‘词法’和‘交际’上具有显著竞争优势，但在‘写作’和‘语法逻辑’上暂落后于全班平均水平约 8 个百分点。")
                        onNavigateToDetail("多维能力报告", report.toString())
                    }) {
                        CognitiveRadar(
                            dimensions = state.individualDimensions,
                            classAverage = state.classAverageDimensions,
                            modifier = Modifier.fillMaxWidth().height(280.dp)
                        )
                    }
                }
            }

            item {
                DashboardCard(title = "错因深度解剖") {
                    Box(modifier = Modifier.fillMaxWidth().clickable {
                        triggerHaptic(preferences, context)
                        val report = StringBuilder("【${student.name} 错因归因分析】\n\n")
                        state.errorPathology.forEach { cause ->
                            report.append("● ${cause.label}：${cause.percentage.toInt()}%\n")
                        }
                        report.append("\n【病理诊断】\n")
                        report.append("该生的错误类型高度集中在‘概念盲区’。这表明他在进行复杂应用前，对基础语法定义的理解存在偏差，建议重回课本基础例句。")
                        onNavigateToDetail("错因归因报告", report.toString())
                    }) {
                        AttributionMatrix(causes = state.errorPathology)
                    }
                }
            }

            item {
                DashboardCard(title = "知识点掌握地图") {
                    Box(modifier = Modifier.fillMaxWidth().clickable {
                        triggerHaptic(preferences, context)
                        val report = StringBuilder("【${student.name} 知识点掌握明细】\n\n")
                        state.individualKnowledgeGraph.forEach { node ->
                            report.append("● ${node.title}：${if (node.isMastered) "✅ 已掌握" else "❌ 待强化"}\n")
                        }
                        report.append("\n【学习路径规划】\n")
                        val unmastered = state.individualKnowledgeGraph.filter { !it.isMastered }
                        if (unmastered.isNotEmpty()) {
                            report.append("建议优先攻克：${unmastered.first().title}。该考点是后续章节的基石，攻克后将产生显著的迁移效应。")
                        } else {
                            report.append("当前所有核心考点已点亮，建议进入拔高题型的综合训练。")
                        }
                        onNavigateToDetail("考点掌握详情", report.toString())
                    }) {
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            state.individualKnowledgeGraph.forEach { node ->
                                SuggestionChip(
                                    label = node.title,
                                    isMastered = node.isMastered
                                )
                            }
                        }
                    }
                }
            }

            item {
                Column {
                    Text("靶向干预处方", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        PrescriptionCard(
                            title = "导出提分卷", 
                            desc = "生成专属 PDF 特训", 
                            icon = Icons.Default.Description, 
                            color = MaterialTheme.colorScheme.primary,
                            onClick = {
                                triggerHaptic(preferences, context)
                                onNavigateToDetail("专属个性化训练单", 
                                    "【任务单详情】\n" +
                                    "针对学生：${student.name}\n" +
                                    "核心考点：${state.stubbornErrors.firstOrNull()?.title ?: "综合强化"}\n" +
                                    "题目构成：5 道基础辨析 + 3 道中考真题 + 2 道迁移应用题。\n\n" +
                                    "【导出状态】\n" +
                                    "PDF 已排版完成，已自动标记该生历史最高频的失分项。")
                            },
                            modifier = Modifier.weight(1f)
                        )
                        PrescriptionCard(
                            title = "语音留评", 
                            desc = "发送个性化建议", 
                            icon = Icons.Default.Mic, 
                            color = Color(0xFF9C27B0),
                            onClick = {
                                triggerHaptic(preferences, context)
                                onNavigateToDetail("语音点评助手", "正在连接音频通道...\n\n准备录制针对 ${student.name} 在【${state.disasterHeatmap.firstOrNull()?.title ?: "语法体系"}】模块的改进建议。")
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }

    if (showStudentPicker) {
        StudentPickerSheet(
            students = state.studentList,
            onDismiss = { showStudentPicker = false },
            onSelect = { onSelectStudent(it); showStudentPicker = false }
        )
    }
}

// --- 辅助 UI 组件 (更新了点击支持) ---

@Composable
fun TeacherDualTab(selectedView: AnalyticsViewType, onViewChange: (AnalyticsViewType) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().height(48.dp).clip(RoundedCornerShape(24.dp)).background(Color.Black.copy(alpha = 0.05f)).padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val views = listOf(AnalyticsViewType.CLASS to "📊 班级群像", AnalyticsViewType.INDIVIDUAL to "🧑‍🎓 个体诊断")
        views.forEach { (view, label) ->
            val isSelected = selectedView == view
            Box(
                modifier = Modifier.weight(1f).fillMaxHeight().clip(RoundedCornerShape(20.dp))
                    .background(if (isSelected) Color.White else Color.Transparent)
                    .clickableWithoutRipple { onViewChange(view) },
                contentAlignment = Alignment.Center
            ) {
                Text(text = label, style = MaterialTheme.typography.labelLarge.copy(fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal, color = if (isSelected) Color.Black else Color.Gray))
            }
        }
    }
}

@Composable
fun VitalsCard(preferences: UserPreferences, label: String, value: String, icon: ImageVector, color: Color, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val cardShape = remember { RoundedCornerShape(20.dp) }
    Card(
        modifier = modifier
            .height(100.dp)
            .hapticClickable(preferences, shape = cardShape, onClick = onClick),
        shape = cardShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Icon(icon, null, tint = color, modifier = Modifier.size(20.dp))
            Column {
                Text(value, fontSize = 20.sp, fontWeight = FontWeight.Black, color = Color.Black)
                Text(label, fontSize = 9.sp, color = Color.Gray, lineHeight = 12.sp)
            }
        }
    }
}

@Composable
fun DisasterZoneRow(zone: DisasterZone, onAction: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.Red.copy(alpha = 0.03f),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Red.copy(alpha = 0.1f))
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(zone.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text("全班错误率: ${(zone.errorRate * 100).toInt()}%", fontSize = 12.sp, color = Color.Red)
            }
            Button(
                onClick = onAction,
                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                modifier = Modifier.height(32.dp)
            ) {
                Text("详细透视", fontSize = 11.sp)
            }
        }
    }
}

@Composable
fun ErrorGalleryCard(title: String, stats: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.width(200.dp).height(140.dp).clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Gray.copy(alpha = 0.1f), RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Image, null, tint = Color.Gray.copy(alpha = 0.5f))
                    Text("题目截图", fontSize = 9.sp, color = Color.Gray)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(title, fontSize = 11.sp, fontWeight = FontWeight.Bold, maxLines = 1)
            Text(stats, fontSize = 10.sp, color = Color.Red)
        }
    }
}

@Composable
fun StudentWatchAvatar(student: StudentEntity, hasAlert: Boolean, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable(onClick = onClick)) {
        Box {
            Surface(modifier = Modifier.size(48.dp), shape = CircleShape, color = Color.Gray.copy(alpha = 0.1f)) {
                Box(contentAlignment = Alignment.Center) {
                    Text(student.name.take(1), fontWeight = FontWeight.Bold)
                }
            }
            if (hasAlert) {
                Box(modifier = Modifier.size(12.dp).clip(CircleShape).background(Color.Red).align(Alignment.TopEnd).border(2.dp, Color.White, CircleShape))
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(student.name, fontSize = 10.sp, color = Color.Gray)
    }
}

@Composable
fun PrescriptionCard(title: String, desc: String, icon: ImageVector, color: Color, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(120.dp).clickable(onClick = onClick),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentPickerSheet(students: List<StudentEntity>, onDismiss: () -> Unit, onSelect: (String) -> Unit) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(modifier = Modifier.padding(24.dp).fillMaxWidth()) {
            Text("全班学生名单", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxWidth().heightIn(max = 400.dp)) {
                items(students) { student ->
                    Row(
                        modifier = Modifier.fillMaxWidth().clickable { onSelect(student.studentId) }.padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(student.name, style = MaterialTheme.typography.bodyLarge)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(student.studentId, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    }
                }
            }
        }
    }
}

@Composable
fun Modifier.clickableWithoutRipple(onClick: () -> Unit): Modifier = this.then(
    Modifier.clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, onClick = onClick)
)

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
fun SuggestionChip(label: String, isMastered: Boolean) {
    Surface(
        color = if (isMastered) Color(0xFFE8F5E9) else Color(0xFFFBE9E7),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, if (isMastered) Color(0xFF4CAF50).copy(alpha = 0.3f) else Color(0xFFF44336).copy(alpha = 0.3f))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                if (isMastered) Icons.Default.CheckCircle else Icons.Default.Error,
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = if (isMastered) Color(0xFF4CAF50) else Color(0xFFF44336)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(label, fontSize = 11.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray)
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

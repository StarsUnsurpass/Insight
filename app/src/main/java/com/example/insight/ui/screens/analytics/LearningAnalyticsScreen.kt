package com.example.insight.ui.screens.analytics

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
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
import com.example.insight.util.triggerHaptic
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearningAnalyticsScreen(
    state: AnalyticsState,
    preferences: UserPreferences, // 新增偏好传入用于震感
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
                            Text(state.selectedClass, fontSize = 12.sp, fontWeight = FontWeight.Bold)
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
                    IndividualDiagnosisSection(state, preferences, onSelectStudent, onNavigateToDetail)
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
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 120.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // 面板 1：班级状态全景舱
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                VitalsCard(
                    label = "昨日作业完成率",
                    value = "${(state.classVitals.yesterdayCompletionRate * 100).toInt()}%",
                    icon = Icons.Default.TaskAlt,
                    color = Color(0xFF4CAF50),
                    onClick = {
                        triggerHaptic(preferences, context)
                        onNavigateToDetail("作业完成率报告", "【昨日作业概况】\n已提交：38人\n未提交：4人\n平均耗时：22分钟\n\n数据解析：目前班级整体完成度较好，但有3名同学连续两天未提交，建议通过系统发送提醒。")
                    },
                    modifier = Modifier.weight(1f)
                )
                VitalsCard(
                    label = "班级健康度",
                    value = state.classVitals.classHealthScore.toString(),
                    icon = Icons.Default.Favorite,
                    color = Color(0xFFE91E63),
                    onClick = {
                        triggerHaptic(preferences, context)
                        onNavigateToDetail("班级健康度分析", "【综合评估】\n当前分值：${state.classVitals.classHealthScore}\n评估维度：知识点正确率(40%)、复习主动性(30%)、课堂活跃度(30%)。\n\n趋势：近一周健康度上升 12%，主要得益于词汇模块掌握度的普遍提升。")
                    },
                    modifier = Modifier.weight(1f)
                )
                VitalsCard(
                    label = "核心攻坚进度",
                    value = "${(state.classVitals.coreProgressValue * 100).toInt()}%",
                    icon = Icons.Default.Flag,
                    color = Color(0xFF2196F3),
                    onClick = {
                        triggerHaptic(preferences, context)
                        onNavigateToDetail("教学攻坚看板", "【当前攻坚单元】\n${state.classVitals.coreProgressTitle}\n\n详细进度：\n- 词汇辨析：85%\n- 句型应用：62%\n- 语法逻辑：45%\n\n建议：语法逻辑部分存在明显的群体性认知困难，建议明天第二节课进行专项拆解。")
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // 面板 2：共性“重灾区”预警雷达
        item {
            DashboardCard(title = "共性“重灾区”预警雷达") {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    state.disasterHeatmap.forEach { zone ->
                        DisasterZoneRow(zone) {
                            triggerHaptic(preferences, context)
                            onNavigateToDetail("失分根源透视", "【知识点：${zone.title}】\n\n诊断结论：该考点错误率高达 ${(zone.errorRate * 100).toInt()}%。主要症结在于：\n1. 固定搭配混淆(45%)\n2. 语境语义理解偏差(30%)\n\n系统已为您准备好复习教案，包含 5 道典型例题。")
                        }
                    }
                }
            }
        }

        // 面板 3：高频错题画廊
        item {
            Column {
                Text("高频错题画廊", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(3) { index ->
                        ErrorGalleryCard {
                            triggerHaptic(preferences, context)
                            onNavigateToDetail("错题深度解析", "【典型错题 #$index】\n\n全班做错人数：15人\n难度系数：4.2 (困难)\n\n详细分析：此题考察了定语从句的引导词省略规则。选错的学生中，60% 是由于没识别出句子谓语，40% 是因为对先行词判断错误。")
                        }
                    }
                }
            }
        }

        // 面板 4：分层与流动模型
        item {
            DashboardCard(title = "关注名单 & 进步之星") {
                Column {
                    Text("重点关注 (Watchlist)", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(state.stratification.watchlist) { student ->
                            StudentWatchAvatar(student, hasAlert = true) {
                                triggerHaptic(preferences, context)
                                onNavigateToDetail("学情预警：${student.name}", "【预警原因】\n近期正确率下降：-15%\n连续3天未扫描错题。\n\n建议：建议课后与其谈心，了解最近是否由于情绪或基础薄弱导致学习动力下降。")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("近期之星 (Rising Stars)", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(state.stratification.risingStars) { student ->
                            StudentWatchAvatar(student, hasAlert = false) {
                                triggerHaptic(preferences, context)
                                onNavigateToDetail("学霸喜报：${student.name}", "【进步亮点】\n本周突破：Unit 8 知识点全点亮。\n正确率提升：+22%\n\n建议：可在明天课堂上进行口头表扬，树立正面典型。")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun IndividualDiagnosisSection(
    state: AnalyticsState, 
    preferences: UserPreferences,
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
            item { 
                Box(modifier = Modifier.clickable {
                    triggerHaptic(preferences, context)
                    onNavigateToDetail("AI 诊断深度解读", state.individualSummary)
                }) {
                    AiSummaryCard(summary = state.individualSummary) 
                }
            }

            item {
                DashboardCard(title = "五维能力模型 (虚线为班级均线)") {
                    Box(modifier = Modifier.fillMaxWidth().clickable {
                        triggerHaptic(preferences, context)
                        onNavigateToDetail("能力维度报告：${state.selectedStudent.name}", "【维度优劣势】\n- 优势项：词法、交际（均高于班级 15%）\n- 薄弱项：写作、语法（低于班级 8%）\n\n核心诊断：词汇积累非常扎实，但由于对复合句引导词理解不深，导致在写作和长难句解析中频频失分。")
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
                        onNavigateToDetail("错因归因分析", "【${state.selectedStudent.name} 错因画像】\n- 概念盲区：45%（核心病根）\n- 审题偏差：25%\n- 母语负迁移：20%\n\n解析：该生做错题并非因为马虎，而是由于基础语法概念（如时态的一致性）存在盲区。")
                    }) {
                        AttributionMatrix(causes = state.errorPathology)
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
                                onNavigateToDetail("个性化训练单", "【提分任务单】\n针对：${state.selectedStudent.name}\n内容：10 道定语从句专项变式题。\n生成状态：已就绪，可连接蓝牙打印机。")
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
                                onNavigateToDetail("语音点评助手", "正在录制针对 ${state.selectedStudent.name} 的学情反馈...\n\n点击界面麦克风图标即可开始。")
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

// --- 辅助 UI 组件 ---

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
fun VitalsCard(label: String, value: String, icon: ImageVector, color: Color, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(100.dp).clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
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
fun ErrorGalleryCard(onClick: () -> Unit) {
    Card(
        modifier = Modifier.width(200.dp).height(140.dp).clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Gray.copy(alpha = 0.1f), RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center) {
                Text("题目截图预览", fontSize = 10.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("15人错 (35%)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Box(modifier = Modifier.fillMaxWidth().height(4.dp).clip(CircleShape).background(Color.Red.copy(alpha = 0.1f))) {
                Box(modifier = Modifier.fillMaxWidth(0.35f).fillMaxHeight().background(Color.Red))
            }
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

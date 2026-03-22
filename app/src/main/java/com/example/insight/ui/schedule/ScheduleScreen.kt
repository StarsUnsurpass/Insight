package com.example.insight.ui.schedule

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.PickVisualMediaRequest
import android.net.Uri
import androidx.compose.ui.platform.LocalContext
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions
import com.example.insight.util.ScheduleAlarmManager
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(
    onBack: () -> Unit,
    viewModel: ScheduleViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    
    val allSchedules by viewModel.allSchedules.collectAsState()
    val activeSchedule by viewModel.activeSchedule.collectAsState()
    val scheduleData by viewModel.currentScheduleData.collectAsState()
    val lessonTimes by viewModel.lessonTimes.collectAsState()
    
    var currentWeek by remember { mutableStateOf(1) }
    var showAddCourseDialog by remember { mutableStateOf(false) }
    var showCreateScheduleDialog by remember { mutableStateOf(false) }
    var showTimeSettingsDialog by remember { mutableStateOf(false) }
    
    // Quick Add State
    var prefillDay by remember { mutableStateOf(1) }
    var prefillPeriod by remember { mutableStateOf(1) }
    
    var showImportMenu by remember { mutableStateOf(false) }
    var showCorrectionDialog by remember { mutableStateOf<List<ParsedGridItem>?>(null) }
    
    val context = LocalContext.current
    LaunchedEffect(scheduleData, lessonTimes) {
        if (scheduleData.isNotEmpty() && lessonTimes.isNotEmpty()) {
            val alarmManager = ScheduleAlarmManager(context)
            scheduleData.forEach { courseData ->
                alarmManager.scheduleCourseAlarm(courseData, lessonTimes)
            }
        }
    }

    // Photo Picker for importing schedule image
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri: Uri? ->
            uri?.let {
                val image = InputImage.fromFilePath(context, it)
                val recognizer = TextRecognition.getClient(ChineseTextRecognizerOptions.Builder().build())
                recognizer.process(image)
                    .addOnSuccessListener { visionText ->
                        val items = ScheduleImportEngine.parseGrid(visionText.textBlocks, image.width, image.height)
                        showCorrectionDialog = items
                    }
                    .addOnFailureListener { _ ->
                        // Handle failure
                    }
            }
        }
    )
    
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                Text("课表管理", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
                HorizontalDivider()
                allSchedules.forEach { schedule ->
                    NavigationDrawerItem(
                        label = { Text(schedule.scheduleName) },
                        selected = schedule.scheduleId == activeSchedule?.scheduleId,
                        onClick = {
                            viewModel.switchSchedule(schedule.scheduleId)
                            scope.launch { drawerState.close() }
                        },
                        icon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
                NavigationDrawerItem(
                    label = { Text("新建课表") },
                    selected = false,
                    onClick = { showCreateScheduleDialog = true },
                    icon = { Icon(Icons.Default.Add, contentDescription = null) },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { 
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(activeSchedule?.scheduleName ?: "全能课表", style = MaterialTheme.typography.titleMedium)
                            Text("第 $currentWeek 周", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "返回")
                        }
                    },
                    actions = {
                        IconButton(onClick = { showTimeSettingsDialog = true }) {
                            Icon(Icons.Default.Settings, contentDescription = "时间模板设置")
                        }
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "菜单")
                        }
                    }
                )
            },
            floatingActionButton = {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FloatingActionButton(onClick = { showImportMenu = true }) {
                        Icon(Icons.Default.Add, contentDescription = "操作菜单")
                    }
                    FloatingActionButton(onClick = {
                        val active = activeSchedule ?: return@FloatingActionButton
                        val text = buildString {
                            appendLine("【${active.scheduleName}】")
                            scheduleData.forEach { courseData ->
                                appendLine("- ${courseData.course.courseName} (${courseData.course.location})")
                                courseData.timeSlots.forEach { slot ->
                                    appendLine("  周${slot.dayOfWeek} 第${slot.startPeriod}-${slot.endPeriod}节")
                                }
                            }
                        }
                        val intent = android.content.Intent(android.content.Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(android.content.Intent.EXTRA_TEXT, text)
                        }
                        context.startActivity(android.content.Intent.createChooser(intent, "分享课表"))
                    }) {
                        Icon(Icons.Default.Share, contentDescription = "分享课表")
                    }
                }
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                if (activeSchedule == null) {
                    EmptyScheduleState(onCreateClick = { showCreateScheduleDialog = true })
                } else {
                    ScheduleGrid(
                        courseWithSlots = scheduleData,
                        lessonTimes = lessonTimes,
                        onCourseClick = { /* Edit Detail */ },
                        onEmptyCellClick = { day, period ->
                            prefillDay = day
                            prefillPeriod = period
                            showAddCourseDialog = true
                        }
                    )
                }
            }
        }
    }

    if (showCreateScheduleDialog) {
        var name by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showCreateScheduleDialog = false },
            title = { Text("新建课表") },
            text = {
                OutlinedTextField(value = name, onValueChange = { name = it }, placeholder = { Text("例如：2026春季课表") })
            },
            confirmButton = {
                Button(onClick = {
                    if (name.isNotBlank()) {
                        viewModel.createSchedule(name)
                        showCreateScheduleDialog = false
                    }
                }) { Text("确定") }
            }
        )
    }
    if (showAddCourseDialog) {
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        ModalBottomSheet(
            onDismissRequest = { showAddCourseDialog = false },
            sheetState = sheetState
        ) {
            AddCourseBottomSheetContent(
                initialDay = prefillDay,
                initialStart = prefillPeriod,
                onConfirm = { name, teacher, location, color, day, start, end, weeks ->
                    viewModel.addCourse(name, teacher, location, color, day, start, end, weeks)
                    scope.launch { sheetState.hide() }.invokeOnCompletion { 
                        if (!sheetState.isVisible) showAddCourseDialog = false
                    }
                }
            )
        }
    }
    
    if (showTimeSettingsDialog) {
        TimeSettingsMenu(
            onDismiss = { showTimeSettingsDialog = false },
            currentLessonTimes = lessonTimes,
            onSave = { updatedTimes ->
                viewModel.updateLessonTimes(updatedTimes)
                showTimeSettingsDialog = false
            }
        )
    }

    if (showImportMenu) {
        ModalBottomSheet(onDismissRequest = { showImportMenu = false }) {
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                ListItem(
                    headlineContent = { Text("手动添加") },
                    leadingContent = { Icon(Icons.Default.Add, contentDescription = null) },
                    modifier = Modifier.clickable { 
                        showImportMenu = false
                        prefillDay = 1
                        prefillPeriod = 1
                        showAddCourseDialog = true 
                    }
                )
                ListItem(
                    headlineContent = { Text("从相册导入") },
                    leadingContent = { Icon(Icons.Default.Image, contentDescription = null) },
                    modifier = Modifier.clickable { 
                        showImportMenu = false
                        photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    }
                )
                ListItem(
                    headlineContent = { Text("拍照导入") },
                    leadingContent = { Icon(Icons.Default.CameraAlt, contentDescription = null) },
                    modifier = Modifier.clickable { 
                        showImportMenu = false
                        // TODO: Implement camera capture
                    }
                )
            }
        }
    }

    if (showCorrectionDialog != null) {
        CorrectionDialog(
            items = showCorrectionDialog!!,
            onDismiss = { showCorrectionDialog = null },
            onConfirm = { correctedItems ->
                correctedItems.forEach {
                    viewModel.addCourse(
                        name = it.text,
                        teacher = "",
                        location = "",
                        color = 0xFFBBDEFB.toInt(),
                        dayOfWeek = it.dayOfWeek,
                        startPeriod = it.startPeriod,
                        endPeriod = it.endPeriod,
                        weeks = (1..20).toList()
                    )
                }
                showCorrectionDialog = null
            }
        )
    }}

@Composable
fun CorrectionDialog(
    items: List<ParsedGridItem>,
    onDismiss: () -> Unit,
    onConfirm: (List<ParsedGridItem>) -> Unit
) {
    var editableItems by remember(items) { mutableStateOf(items) }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("AI 识别校对") },
        text = {
            LazyColumn {
                items(editableItems) { item ->
                    val index = editableItems.indexOf(item)
                    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = item.text,
                            onValueChange = { newText ->
                                val newList = editableItems.toMutableList()
                                newList[index] = item.copy(text = newText)
                                editableItems = newList
                            },
                            modifier = Modifier.weight(1f),
                            label = { Text("周${item.dayOfWeek} 第${item.startPeriod}-${item.endPeriod}节") }
                        )
                        IconButton(onClick = { 
                            val newList = editableItems.toMutableList()
                            newList.removeAt(index)
                            editableItems = newList
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = "删除")
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(editableItems) }) {
                Text("确认并导入")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("取消")
            }
        }
    )
}

@Composable
fun EmptyScheduleState(onCreateClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.DateRange, 
            contentDescription = null, 
            modifier = Modifier.size(64.dp), 
            tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
        )
        Spacer(Modifier.height(16.dp))
        Text("还没有课表", style = MaterialTheme.typography.titleMedium)
        Text("点击下方按钮创建一个吧", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onCreateClick) {
            Text("创建我的第一张课表")
        }
    }
}

@Composable
fun AddCourseBottomSheetContent(
    initialDay: Int,
    initialStart: Int,
    onConfirm: (String, String, String, Int, Int, Int, Int, List<Int>) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var teacher by remember { mutableStateOf("") }
    var span by remember { mutableStateOf(1) }
    
    val days = listOf("周一", "周二", "周三", "周四", "周五", "周六", "周日")
    
    // Morandi colors
    val colors = listOf(0xFFB1BFC3, 0xFFE0C1B3, 0xFFD2D8B3, 0xFFE2D4C5, 0xFFB9C4C6, 0xFFD9B8C4, 0xFFF2E3C6, 0xFFA5B8A8)
    var selectedColor by remember { mutableStateOf(colors[0]) }

    var selectedWeeks by remember { mutableStateOf((1..20).toSet()) }

    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp).verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("添加课程", style = MaterialTheme.typography.titleLarge)
        
        Row(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surfaceVariant, MaterialTheme.shapes.medium).padding(12.dp)) {
            Text("${days[initialDay - 1]} 第 $initialStart 节起", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        
        OutlinedTextField(
            value = name, 
            onValueChange = { name = it }, 
            label = { Text("课程名称 (必填)") }, 
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = location, 
                onValueChange = { location = it }, 
                label = { Text("上课地点 (选填)") }, 
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            OutlinedTextField(
                value = teacher, 
                onValueChange = { teacher = it }, 
                label = { Text("任课教师 (选填)") }, 
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }
        
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text("连上几节", style = MaterialTheme.typography.bodyMedium)
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { if (span > 1) span-- }) { Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "减少") }
                Text(span.toString(), style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(horizontal = 8.dp))
                IconButton(onClick = { if (span < 5) span++ }) { Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "增加") }
            }
        }
        
        Text("颜色选择", style = MaterialTheme.typography.bodyMedium)
        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            colors.forEach { colorInt ->
                Box(
                    modifier = Modifier.size(36.dp).clip(androidx.compose.foundation.shape.CircleShape).background(Color(colorInt))
                        .clickable { selectedColor = colorInt }
                        .border(
                            width = if (selectedColor == colorInt) 2.dp else 0.dp,
                            color = if (selectedColor == colorInt) MaterialTheme.colorScheme.primary else Color.Transparent,
                            shape = androidx.compose.foundation.shape.CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedColor == colorInt) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                    }
                }
            }
        }
        
        // Simplified Weekly Picker for now
        Text("周次 (${selectedWeeks.size}周)", style = MaterialTheme.typography.bodyMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(selected = selectedWeeks.size == 20, onClick = { selectedWeeks = (1..20).toSet() }, label = { Text("全选") })
            FilterChip(selected = selectedWeeks.all { it % 2 != 0 }, onClick = { selectedWeeks = (1..20).filter { it % 2 != 0 }.toSet() }, label = { Text("单周") })
            FilterChip(selected = selectedWeeks.all { it % 2 == 0 }, onClick = { selectedWeeks = (1..20).filter { it % 2 == 0 }.toSet() }, label = { Text("双周") })
        }
        
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                if (name.isNotBlank()) {
                    onConfirm(name.trim(), teacher.trim(), location.trim(), selectedColor.toInt(), initialDay, initialStart, initialStart + span - 1, selectedWeeks.toList())
                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            enabled = name.isNotBlank()
        ) {
            Text("保存课程")
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun TimeSettingsMenu(
    onDismiss: () -> Unit,
    currentLessonTimes: List<com.example.insight.data.local.entities.LessonTimeEntity>,
    onSave: (List<com.example.insight.data.local.entities.LessonTimeEntity>) -> Unit
) {
    var morningCount by remember { mutableStateOf(4) }
    var afternoonCount by remember { mutableStateOf(4) }
    var eveningCount by remember { mutableStateOf(3) }
    var classDuration by remember { mutableStateOf(40) }
    var breakDuration by remember { mutableStateOf(10) }
    var startTimeInput by remember { mutableStateOf("08:00") }
    var longBreakDuration by remember { mutableStateOf(30) }
    var longBreakAfter by remember { mutableStateOf(2) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("作息时间模板") },
        text = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("节次结构配置", style = MaterialTheme.typography.titleSmall)
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text("上午节数")
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (morningCount > 0) morningCount-- }) { Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, null) }
                        Text("$morningCount", modifier = Modifier.padding(horizontal = 8.dp))
                        IconButton(onClick = { if (morningCount < 8) morningCount++ }) { Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null) }
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text("下午节数")
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (afternoonCount > 0) afternoonCount-- }) { Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, null) }
                        Text("$afternoonCount", modifier = Modifier.padding(horizontal = 8.dp))
                        IconButton(onClick = { if (afternoonCount < 8) afternoonCount++ }) { Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null) }
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text("晚自习节数")
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (eveningCount > 0) eveningCount-- }) { Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, null) }
                        Text("$eveningCount", modifier = Modifier.padding(horizontal = 8.dp))
                        IconButton(onClick = { if (eveningCount < 6) eveningCount++ }) { Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null) }
                    }
                }

                HorizontalDivider()

                Text("一键时间推算", style = MaterialTheme.typography.titleSmall)
                OutlinedTextField(
                    value = startTimeInput, 
                    onValueChange = { startTimeInput = it }, 
                    label = { Text("第一节课开始 (HH:MM)") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = classDuration.toString(), 
                        onValueChange = { classDuration = it.toIntOrNull() ?: classDuration }, 
                        label = { Text("每节课时长(分)") },
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = breakDuration.toString(), 
                        onValueChange = { breakDuration = it.toIntOrNull() ?: breakDuration }, 
                        label = { Text("课间休息(分)") },
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = longBreakDuration.toString(), 
                        onValueChange = { longBreakDuration = it.toIntOrNull() ?: longBreakDuration }, 
                        label = { Text("大课间时长(分)") },
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = longBreakAfter.toString(), 
                        onValueChange = { longBreakAfter = it.toIntOrNull() ?: longBreakAfter }, 
                        label = { Text("在第几节课后") },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        },
        confirmButton = { 
            Button(onClick = { 
                val timeParts = startTimeInput.split(":")
                val startHour = timeParts.getOrNull(0)?.toIntOrNull() ?: 8
                val startMin = timeParts.getOrNull(1)?.toIntOrNull() ?: 0
                var currentMin = startHour * 60 + startMin

                val newTimes = mutableListOf<com.example.insight.data.local.entities.LessonTimeEntity>()
                val totalCount = morningCount + afternoonCount + eveningCount
                
                for (i in 1..totalCount) {
                    val sh = currentMin / 60
                    val sm = currentMin % 60
                    
                    currentMin += classDuration
                    val eh = currentMin / 60
                    val em = currentMin % 60
                    
                    val section = when {
                        i <= morningCount -> 0
                        i <= morningCount + afternoonCount -> 1
                        else -> 2
                    }
                    val currentScheduleId = currentLessonTimes.firstOrNull()?.scheduleId ?: 0L
                    
                    newTimes.add(
                        com.example.insight.data.local.entities.LessonTimeEntity(
                            scheduleId = currentScheduleId,
                            period = i,
                            startTime = String.format("%02d:%02d", sh, sm),
                            endTime = String.format("%02d:%02d", eh, em),
                            section = section
                        )
                    )
                    
                    if (i == longBreakAfter) {
                        currentMin += longBreakDuration
                    } else if (i == morningCount || i == morningCount + afternoonCount) {
                        currentMin += 120 // 默认午休晚饭两个小时
                    } else {
                        currentMin += breakDuration
                    }
                }
                onSave(newTimes)
            }) { 
                Text("一键生成并保存") 
            } 
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("取消") }
        }
    )
}


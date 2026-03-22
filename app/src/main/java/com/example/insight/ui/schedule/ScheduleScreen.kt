package com.example.insight.ui.schedule

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
                    .addOnFailureListener { e ->
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
                        IconButton(onClick = { /* Settings */ }) {
                            Icon(Icons.Default.Settings, contentDescription = "设置")
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
    }

    if (showAddCourseDialog) {
        AddCourseDialog(
            initialDay = prefillDay,
            initialStart = prefillPeriod,
            onDismiss = { showAddCourseDialog = false },
            onConfirm = { name, teacher, loc, color, day, start, end, weeks ->
                viewModel.addCourse(name, teacher, loc, color, day, start, end, weeks)
                showAddCourseDialog = false
            }
        )
    }
}

@Composable
fun CorrectionDialog(
    items: List<ParsedGridItem>,
    onDismiss: () -> Unit,
    onConfirm: (List<ParsedGridItem>) -> Unit
) {
    var editableItems by remember { mutableStateOf(items) }
    
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
fun AddCourseDialog(
    initialDay: Int,
    initialStart: Int,
    onDismiss: () -> Unit,
    onConfirm: (String, String, String, Int, Int, Int, Int, List<Int>) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var teacher by remember { mutableStateOf("") }
    var day by remember { mutableStateOf(initialDay) }
    var start by remember { mutableStateOf(initialStart) }
    var end by remember { mutableStateOf(initialStart) }
    
    val colors = listOf(0xFFBBDEFB, 0xFFC8E6C9, 0xFFFFF9C4, 0xFFFFE0B2, 0xFFF8BBD0, 0xFFE1BEE7)

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("课程信息") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("课程名称") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = location, onValueChange = { location = it }, label = { Text("上课地点") }, modifier = Modifier.fillMaxWidth())
                
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    // Simplified selectors
                    Text("周 $day", modifier = Modifier.weight(1f))
                    Text("第 $start - $end 节", modifier = Modifier.weight(1f))
                }
                
                Text("选择颜色", style = MaterialTheme.typography.labelSmall)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    colors.forEach { colorInt ->
                        RadioButton(selected = false, onClick = { /* Select */ }, colors = RadioButtonDefaults.colors(selectedColor = Color(colorInt.toInt())))
                    }
                }
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(name, teacher, location, 0xFFBBDEFB.toInt(), day, start, end, (1..20).toList()) }) {
                Text("保存")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("取消") }
        }
    )
}

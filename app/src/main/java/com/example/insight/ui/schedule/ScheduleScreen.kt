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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
                FloatingActionButton(onClick = { 
                    prefillDay = 1
                    prefillPeriod = 1
                    showAddCourseDialog = true 
                }) {
                    Icon(Icons.Default.Add, contentDescription = "添加课程")
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
                TextField(value = name, onValueChange = { name = it }, placeholder = { Text("例如：2026春季课表") })
            },
            confirmButton = {
                Button(onClick = {
                    viewModel.createSchedule(name)
                    showCreateScheduleDialog = false
                }) { Text("确定") }
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

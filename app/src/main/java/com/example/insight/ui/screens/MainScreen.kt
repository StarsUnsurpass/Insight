package com.example.insight.ui.screens

import android.os.Build
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.insight.ui.state.InsightViewModel
import com.example.insight.ui.state.UserPreferences
import com.example.insight.ui.state.UserRole
import com.example.insight.graph.*
import com.example.insight.ui.theme.*
import kotlin.math.hypot
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.LazyRow
import com.example.insight.data.model.sampleCoursewares
import com.example.insight.data.model.Courseware
import com.example.insight.data.model.sampleLessonPlans
import com.example.insight.data.model.LessonPlanSample

enum class InsightTab(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val index: Int,
    val bias: Float
) {
    Home("首页", Icons.Filled.Home, Icons.Outlined.Home, 0, -2f),
    Map("图谱", Icons.Filled.AccountTree, Icons.Outlined.AccountTree, 1, -1f),
    Analysis("学情", Icons.Filled.Analytics, Icons.Outlined.Analytics, 2, 1f), 
    Profile("我的", Icons.Filled.Person, Icons.Outlined.Person, 3, 2f)
}

@Composable
fun MainScreen(
    viewModel: InsightViewModel,
    onNavigateToScanner: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToExport: () -> Unit,
    onNavigateToStudentList: () -> Unit,
    onNavigateToLessonPlans: () -> Unit,
    onNavigateToMindMap: () -> Unit,
    onNavigateToCourseware: (String) -> Unit,
    onNavigateToCoursewareEditor: (String?) -> Unit,
    onNavigateToLessonPlanSample: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val preferences = uiState.preferences

    var selectedTab by rememberSaveable { mutableStateOf(InsightTab.Home) }
    var isDockVisible by remember { mutableStateOf(true) }
    var isRevealing by remember { mutableStateOf(false) }
    var isInitialized by remember { mutableStateOf(false) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                if (available.y < -12f && !isRevealing && isDockVisible) {
                    isDockVisible = false
                } else if (available.y > 12f && !isRevealing && !isDockVisible) {
                    isDockVisible = true
                }
                return Offset.Zero
            }
        }
    }

    val dockBounceY = remember { Animatable(0f) }
    LaunchedEffect(selectedTab) {
        if (isInitialized) {
            launch {
                dockBounceY.animateTo(-10f, spring(stiffness = Spring.StiffnessMediumLow))
                dockBounceY.animateTo(0f, spring(dampingRatio = 0.65f, stiffness = Spring.StiffnessLow))
            }
        } else {
            isInitialized = true
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(containerColor = MaterialTheme.colorScheme.background) { innerPadding ->
            Box(modifier = Modifier.fillMaxSize().nestedScroll(nestedScrollConnection)) {
                Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                    AnimatedContent(
                        targetState = selectedTab,
                        transitionSpec = {
                            (scaleIn(initialScale = 0.85f, animationSpec = tween(300, easing = FastOutSlowInEasing)) + 
                             fadeIn(animationSpec = tween(300)))
                            .togetherWith(
                             scaleOut(targetScale = 1.15f, animationSpec = tween(300, easing = FastOutSlowInEasing)) + 
                             fadeOut(animationSpec = tween(300)))
                        },
                        label = "tab_transition"
                    ) { targetTab ->
                        when (targetTab) {
                            InsightTab.Home -> HomeTab(preferences = preferences)
                            InsightTab.Map -> MapTab(preferences)
                            InsightTab.Analysis -> KnowledgeGraphScreen(preferences)
                            InsightTab.Profile -> ProfileTab(
                                preferences = preferences,
                                onManageStudents = onNavigateToStudentList,
                                onManageLessonPlans = onNavigateToLessonPlans,
                                onNavigateToMindMap = onNavigateToMindMap,
                                onNavigateToSettings = onNavigateToSettings,
                                onNavigateToExport = onNavigateToExport,
                                onNavigateToCourseware = onNavigateToCourseware,
                                onNavigateToCoursewareEditor = onNavigateToCoursewareEditor,
                                onNavigateToLessonPlanSample = onNavigateToLessonPlanSample
                            )
                        }
                    }
                }

                val dockWidth by animateDpAsState(
                    targetValue = if (isDockVisible) 340.dp else 72.dp,
                    animationSpec = spring(dampingRatio = 0.75f, stiffness = 50f),
                    label = "dock_width"
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 32.dp)
                        .width(dockWidth)
                        .height(72.dp)
                        .graphicsLayer { translationY = dockBounceY.value }
                ) {
                    GooeyDockContent(
                        selectedTab = selectedTab,
                        isVisible = isDockVisible,
                        currentDockWidth = dockWidth,
                        onTabSelected = { selectedTab = it },
                        onCameraClick = { isRevealing = true }
                    )
                }
            }
        }

        if (isRevealing) {
            val revealProgress = remember { Animatable(0f) }
            val themePrimary = MaterialTheme.colorScheme.primary
            LaunchedEffect(Unit) {
                revealProgress.animateTo(1f, animationSpec = tween(500, easing = FastOutSlowInEasing))
                onNavigateToScanner()
                delay(300) 
                isRevealing = false
            }
            Canvas(modifier = Modifier.fillMaxSize()) {
                val centerOffset = Offset(size.width / 2, size.height - 68.dp.toPx())
                val maxRadius = hypot(size.width, size.height)
                drawCircle(color = themePrimary, radius = maxRadius * revealProgress.value, center = centerOffset)
            }
        }
    }
}

@Composable
fun GooeyDockContent(
    selectedTab: InsightTab,
    isVisible: Boolean,
    currentDockWidth: Dp,
    onTabSelected: (InsightTab) -> Unit,
    onCameraClick: () -> Unit
) {
    val haptic = LocalHapticFeedback.current
    val primaryColor = MaterialTheme.colorScheme.primary
    val slotWidth = currentDockWidth / 5
    
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(36.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            shadowElevation = 12.dp,
            border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.05f))
        ) {}

        if (currentDockWidth > 200.dp) {
            val indicatorSize = 52.dp
            val targetCenterX = slotWidth * selectedTab.bias
            val leftEdge by animateDpAsState(
                targetValue = targetCenterX - (indicatorSize / 2),
                animationSpec = spring(dampingRatio = 0.8f, stiffness = 90f)
            )
            val rightEdge by animateDpAsState(
                targetValue = targetCenterX + (indicatorSize / 2),
                animationSpec = spring(dampingRatio = 0.8f, stiffness = 90f)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(x = (leftEdge + rightEdge) / 2)
                    .size(width = (rightEdge - leftEdge).coerceAtLeast(indicatorSize), height = indicatorSize)
                    .background(primaryColor.copy(alpha = 0.12f), CircleShape)
            )
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            val alpha by animateFloatAsState(
                targetValue = if (isVisible && currentDockWidth > 200.dp) 1f else 0f,
                animationSpec = tween(250)
            )

            TabIconFluid(InsightTab.Home, selectedTab, alpha, slotWidth, onTabSelected)
            TabIconFluid(InsightTab.Map, selectedTab, alpha, slotWidth, onTabSelected)
            
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .requiredSize(64.dp)
                    .clip(CircleShape)
                    .background(primaryColor)
                    .clickable { 
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        onCameraClick() 
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Default.CameraAlt, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
            }

            TabIconFluid(InsightTab.Analysis, selectedTab, alpha, slotWidth, onTabSelected)
            TabIconFluid(InsightTab.Profile, selectedTab, alpha, slotWidth, onTabSelected)
        }
    }
}

@Composable
fun BoxScope.TabIconFluid(
    tab: InsightTab,
    selectedTab: InsightTab,
    alpha: Float,
    slotWidth: Dp,
    onTabSelected: (InsightTab) -> Unit
) {
    val haptic = LocalHapticFeedback.current
    val isSelected = selectedTab == tab
    val primaryColor = MaterialTheme.colorScheme.primary
    val xOffset = slotWidth * tab.bias
    
    if (alpha > 0.01f) {
        val tint by animateColorAsState(if (isSelected) primaryColor else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f), tween(300))
        val scale by animateFloatAsState(if (isSelected) 1.25f else 1f, spring(Spring.DampingRatioMediumBouncy))

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = xOffset)
                .size(56.dp)
                .alpha(alpha)
                .scale(scale)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        if (!isSelected) {
                            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                            onTabSelected(tab)
                        }
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (isSelected) tab.selectedIcon else tab.unselectedIcon,
                contentDescription = tab.title,
                tint = tint,
                modifier = Modifier.size(26.dp)
            )
        }
    }
}

@Composable
fun HomeTab(preferences: UserPreferences) {
    val primaryColor = MaterialTheme.colorScheme.primary
    var searchQuery by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(modifier = Modifier.padding(vertical = 12.dp)) {
                Text(
                    text = if (preferences.role == UserRole.Student) "早上好，${preferences.username} 同学 📚" else "您好，${preferences.username} 老师 🎓",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = if (preferences.role == UserRole.Student) "今天也要保持思考哦。" else "准备好开始今天的教学了吗？",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                )
            }
        }

        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("搜索题目或知识点...", color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f)) },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                shape = RoundedCornerShape(20.dp),
                singleLine = true,
                leadingIcon = { Icon(Icons.Default.Search, null, tint = primaryColor) },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f),
                    focusedBorderColor = primaryColor,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                    focusedContainerColor = MaterialTheme.colorScheme.surface
                )
            )
        }

        if (searchQuery.isEmpty()) {
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(if (preferences.role == UserRole.Student) "最近扫描" else "班级动态", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                    TextButton(onClick = { }) { Text("全部", color = primaryColor) }
                }
            }
            items(5) { index -> HistoryCard(index) }
        } else {
            items(3) { index -> SearchResultItem(index) }
        }
    }
}

@Composable
fun ProfileTab(
    preferences: UserPreferences,
    onManageStudents: () -> Unit,
    onManageLessonPlans: () -> Unit,
    onNavigateToMindMap: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToExport: () -> Unit,
    onNavigateToCourseware: (String) -> Unit,
    onNavigateToCoursewareEditor: (String?) -> Unit,
    onNavigateToLessonPlanSample: (String) -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary

    LazyColumn(modifier = Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(64.dp).background(MaterialTheme.colorScheme.surfaceVariant, CircleShape), contentAlignment = Alignment.Center) {        
                    Icon(imageVector = when(preferences.role) {
                        UserRole.Student -> Icons.Default.Person
                        UserRole.Teacher -> Icons.Default.CastForEducation
                    }, contentDescription = null, modifier = Modifier.size(32.dp), tint = primaryColor)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("${preferences.username} ", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Surface(color = primaryColor.copy(alpha = 0.1f), shape = RoundedCornerShape(8.dp)) {
                            Text(text = when(preferences.role) { UserRole.Student -> "同学"; UserRole.Teacher -> "老师" }, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp), style = MaterialTheme.typography.labelSmall, color = primaryColor)
                        }
                    }
                    Text(preferences.className, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f))       
                }
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                StatCard(if (preferences.role == UserRole.Student) "累计扫描" else "我的教案", if (preferences.role == UserRole.Student) "128" else "12", Modifier.weight(1f))
                StatCard(if (preferences.role == UserRole.Student) "攻克考点" else "批改人次", if (preferences.role == UserRole.Student) "42" else "356", Modifier.weight(1f))
            }
        }

        if (preferences.role == UserRole.Teacher) {
            item {
                Text("教务管理", style = MaterialTheme.typography.labelMedium, color = primaryColor, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                
                // --- Class Management ---
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { onManageStudents() },
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
                ) {
                    Row(modifier = Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(48.dp).background(primaryColor.copy(alpha = 0.1f), CircleShape), contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.Group, null, tint = primaryColor, modifier = Modifier.size(24.dp))
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("班级学生名册", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Text("批量导入名单、管理学生及查看档案", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                        }
                        Icon(Icons.Default.ChevronRight, null, tint = primaryColor.copy(alpha = 0.5f))
                    }
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                // --- Lesson Plan Management ---
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { onManageLessonPlans() },
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
                ) {
                    Row(modifier = Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(48.dp).background(primaryColor.copy(alpha = 0.1f), CircleShape), contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.AutoAwesome, null, tint = primaryColor, modifier = Modifier.size(24.dp))
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("AI 智能教案管理", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Text("AI 辅助备课、教案编写与教学输出", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                        }
                        Icon(Icons.Default.ChevronRight, null, tint = primaryColor.copy(alpha = 0.5f))
                    }
                }
            }
        }

        item {
            Text("AI 实验室", style = MaterialTheme.typography.labelMedium, color = primaryColor, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            Card(
                modifier = Modifier.fillMaxWidth().clickable { onNavigateToMindMap() },
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
            ) {
                Row(modifier = Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(48.dp).background(primaryColor.copy(alpha = 0.1f), CircleShape), contentAlignment = Alignment.Center) {
                        Icon(Icons.Default.AccountTree, null, tint = primaryColor, modifier = Modifier.size(24.dp))
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text("AI 智能思维导图", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Text("AI 驱动的内容创建与可视化思维导图", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    }
                    Icon(Icons.Default.ChevronRight, null, tint = primaryColor.copy(alpha = 0.5f))
                }
            }
        }

        // --- Featured Lesson Plan Library ---
        item {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.AutoStories, null, tint = primaryColor, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("精品教案库", style = MaterialTheme.typography.labelMedium, color = primaryColor, fontWeight = FontWeight.Bold)
                }
                IconButton(onClick = { onManageLessonPlans() }) {
                    Icon(Icons.Default.ChevronRight, null, tint = primaryColor)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 4.dp)
            ) {
                items(sampleLessonPlans) { plan ->
                    LessonPlanSampleCard(
                        plan = plan, 
                        onClick = { onNavigateToLessonPlanSample(plan.id) }
                    )
                }
            }
        }

        // --- Featured Courseware Library ---
        item {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Lightbulb, null, tint = primaryColor, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("精品教学课件库", style = MaterialTheme.typography.labelMedium, color = primaryColor, fontWeight = FontWeight.Bold)
                }
                IconButton(onClick = { onNavigateToCoursewareEditor(null) }) {
                    Icon(Icons.Default.AddCircleOutline, null, tint = primaryColor)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 4.dp)
            ) {
                items(sampleCoursewares) { courseware ->
                    CoursewareCard(
                        courseware = courseware, 
                        onClick = { onNavigateToCourseware(courseware.id) },
                        onEdit = { onNavigateToCoursewareEditor(courseware.id) }
                    )
                }
            }
        }

        item {
            Text("应用配置", style = MaterialTheme.typography.labelMedium, color = primaryColor, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    val exportTitle = if (preferences.role == UserRole.Student) "导出错题本 (PDF)" else "导出班级报告 (PDF)"
                    SettingRow(icon = Icons.Default.PictureAsPdf, title = exportTitle, onClick = onNavigateToExport)
                    SettingRow(icon = Icons.Default.Settings, title = "偏好设置", onClick = onNavigateToSettings)
                    SettingRow(Icons.Default.CloudUpload, "同步云端数据")
                }
            }
        }
    }
}

@Composable
fun LessonPlanSampleCard(plan: LessonPlanSample, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(240.dp)
            .height(140.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.dp, plan.themeColor.copy(alpha = 0.1f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Surface(
                color = plan.themeColor.copy(alpha = 0.1f),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = plan.category,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = plan.themeColor,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Text(
                text = plan.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                maxLines = 2,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )
            
            Text(
                text = plan.targetClass,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun SearchResultItem(index: Int) {
    val results = listOf("如何在句子中识别【定语从句】", "定语从句中 that 和 which 的区别", "2023 中考英语语法真题集")
    val resultText = results[index % results.size]
    Card(modifier = Modifier.fillMaxWidth().clickable { }, colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
        Row(modifier = Modifier.padding(vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Outlined.History, contentDescription = null, tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f), modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = resultText, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
fun HistoryCard(index: Int) {
    val labels = listOf("定语从句", "虚拟语气", "分词结构", "阅读理解", "长难句")
    val status = listOf("已掌握", "练习中", "待复习")
    val primaryColor = MaterialTheme.colorScheme.primary
    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), shape = RoundedCornerShape(20.dp)) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(80.dp).clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.surfaceVariant), contentAlignment = Alignment.Center) {
                Icon(Icons.Outlined.Description, null, tint = primaryColor.copy(alpha = 0.5f))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(labels[index % labels.size], style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                Text("扫描时间: 2024.03.1${index}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                Spacer(modifier = Modifier.height(8.dp))
                Surface(color = when(index % 3) { 0 -> primaryColor.copy(alpha = 0.1f); 1 -> HighlightYellow.copy(alpha = 0.2f); else -> Color.Red.copy(alpha = 0.05f) }, shape = RoundedCornerShape(8.dp)) {
                    Text(text = status[index % 3], modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp), style = MaterialTheme.typography.labelSmall, color = when(index % 3) { 0 -> primaryColor; 1 -> Color(0xFFB8860B); else -> Color.Red })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapTab(preferences: UserPreferences) {
    val sheetState = rememberModalBottomSheetState()
    var selectedNode by remember { mutableStateOf<KnowledgeNode?>(null) }
    var showSheet by remember { mutableStateOf(false) }
    val mockGraphState = remember { GraphState(
        nodes = listOf(KnowledgeNode("n1", "初中核心语法", 0.9f, 500f, 300f), KnowledgeNode("n2", "时态体系", 0.6f, 300f, 600f), KnowledgeNode("n3", "从句基础", 0.8f, 700f, 600f)),
        edges = listOf(KnowledgeEdge("n1", "n2"), KnowledgeEdge("n1", "n3"))
    ) }
    Box(modifier = Modifier.fillMaxSize()) {
        StarfieldComponent(graphState = mockGraphState, onNodeClick = { node -> selectedNode = node; showSheet = true }, modifier = Modifier.fillMaxSize())
        Column(modifier = Modifier.padding(20.dp).align(Alignment.TopStart)) {
            Text("知识图谱", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Text(text = if (preferences.role == UserRole.Student) "探索你的星系" else "班级知识图谱", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f))
        }
    }
    if (showSheet && selectedNode != null) {
        ModalBottomSheet(onDismissRequest = { showSheet = false }, sheetState = sheetState) {
            Column(modifier = Modifier.fillMaxWidth().padding(24.dp).padding(bottom = 32.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(text = "考点: ${selectedNode!!.title}", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text("掌握度: ${(selectedNode!!.masteryLevel * 100).toInt()}%")
                Button(onClick = { }, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(16.dp)) { Text("获取高频真题") }
            }
        }
    }
}

@Composable
fun StatCard(label: String, value: String, modifier: Modifier = Modifier) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Card(
        modifier = modifier, 
        shape = RoundedCornerShape(24.dp), 
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(label, style = MaterialTheme.typography.labelSmall, color = primaryColor.copy(alpha = 0.6f))
            Text(value, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = primaryColor)
        }
    }
}

@Composable
fun SettingRow(icon: ImageVector, title: String, onClick: (() -> Unit)? = null) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .padding(vertical = 10.dp, horizontal = 8.dp), 
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(primaryColor.copy(alpha = 0.1f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(18.dp), tint = primaryColor)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null, modifier = Modifier.size(16.dp), tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f))
    }
}

@Composable
fun ExportProgressDialog(role: UserRole) {
    Dialog(onDismissRequest = { }, properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)) {
        Surface(modifier = Modifier.width(280.dp), shape = RoundedCornerShape(28.dp), color = MaterialTheme.colorScheme.surface, tonalElevation = 6.dp) {
            Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator(modifier = Modifier.size(48.dp), color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = if (role == UserRole.Teacher) "正在分析班级数据..." else "正在整理错题集...", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                Text(text = "生成 PDF 报告中，请稍候", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
            }
        }
    }
}

@Composable
fun CoursewareCard(courseware: Courseware, onClick: () -> Unit, onEdit: () -> Unit) {
    Card(
        modifier = Modifier
            .width(280.dp)
            .height(160.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.05f))
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // 背景装饰
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    color = courseware.themeColor.copy(alpha = 0.1f),
                    radius = size.width / 2,
                    center = Offset(size.width, 0f)
                )
            }
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        color = courseware.themeColor.copy(alpha = 0.12f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = courseware.category,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = courseware.themeColor,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    
                    IconButton(onClick = { onEdit() }, modifier = Modifier.size(24.dp)) {
                        Icon(Icons.Default.Edit, null, tint = Color.Gray.copy(alpha = 0.5f), modifier = Modifier.size(16.dp))
                    }
                }
                
                Column {
                    Text(
                        text = courseware.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A1C1E),
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = courseware.description,
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Gray,
                        maxLines = 2
                    )
                }
            }
        }
    }
}

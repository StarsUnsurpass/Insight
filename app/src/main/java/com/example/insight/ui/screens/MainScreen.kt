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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.material.icons.automirrored.filled.*
import com.example.insight.data.model.Courseware
import com.example.insight.data.model.sampleLessonPlans
import com.example.insight.data.model.LessonPlanSample
import com.example.insight.data.model.KnowledgeProvider
import kotlin.collections.*

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
    onNavigateToLessonPlanSample: (String) -> Unit,
    onNavigateToKnowledgeDetail: (String) -> Unit
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
                            InsightTab.Home -> HomeTab(preferences = preferences, onNavigateToKnowledgeDetail = onNavigateToKnowledgeDetail)
                            InsightTab.Map -> MapTab(preferences)
                            InsightTab.Analysis -> AnalysisTab(preferences, uiState.students, uiState.allScans)
                            InsightTab.Profile -> ProfileTab(
                                preferences = preferences,
                                studentCount = uiState.students.size,
                                lessonPlanCount = uiState.lessonPlans.size,
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
fun HomeTab(preferences: UserPreferences, onNavigateToKnowledgeDetail: (String) -> Unit) {
    val primaryColor = MaterialTheme.colorScheme.primary
    var searchQuery by remember { mutableStateOf("") }
    val expandedSections = remember { mutableStateListOf("板块一：词法体系 (Morphology)", "板块二：时态与语态体系 (Tenses & Voices)", "板块三：句法体系 (Syntax)") }

    val focusManager = androidx.compose.ui.platform.LocalFocusManager.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                    if (searchQuery.isEmpty()) {
                        // Just clear focus, we are already showing default view
                    }
                })
            },
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp, top = 4.dp, bottom = 120.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            val calendar = java.util.Calendar.getInstance()
            val dayOfYear = calendar.get(java.util.Calendar.DAY_OF_YEAR)
            
            val dailyQuotes = listOf(
                "Education is the most powerful weapon which you can use to change the world.",
                "The roots of education are bitter, but the fruit is sweet.",
                "A teacher affects eternity; he can never tell where his influence stops.",
                "I hear and I forget. I see and I remember. I do and I understand."
            )
            
            val todayQuote = dailyQuotes[dayOfYear % dailyQuotes.size]
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "您好，${preferences.username}${if (preferences.role == UserRole.Teacher) "老师" else "学生"}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = if (preferences.role == UserRole.Teacher) Icons.Default.School else Icons.AutoMirrored.Filled.MenuBook,
                    contentDescription = null,
                    tint = primaryColor.copy(alpha = 0.8f),
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Gray.copy(alpha = 0.08f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black.copy(alpha = 0.05f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = todayQuote,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    lineHeight = 16.sp
                )
            }
    }

    item {
        // Equal spacing between Quote -> Search and Search -> Modules
        Spacer(modifier = Modifier.height(4.dp))
    }

    item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("搜索题目或知识点...", color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp, bottom = 0.dp),
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
            val sections = listOf("板块一：词法体系 (Morphology)", "板块二：时态与语态体系 (Tenses & Voices)", "板块三：句法体系 (Syntax)")
            
            sections.forEach { sectionName ->
                val isExpanded = expandedSections.contains(sectionName)
                item {
                    Spacer(modifier = Modifier.height(4.dp))
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                if (isExpanded) expandedSections.remove(sectionName)
                                else expandedSections.add(sectionName)
                            }
                            .padding(top = 12.dp, bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = sectionName,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = primaryColor
                        )
                        Icon(
                            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = if (isExpanded) "Collapse" else "Expand",
                            tint = primaryColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                
                item {
                    val sectionPoints = KnowledgeProvider.allPoints.filter { it.section == sectionName }
                    AnimatedVisibility(
                        visible = isExpanded,
                        enter = expandVertically(
                            animationSpec = spring(dampingRatio = 0.65f, stiffness = 300f)
                        ) + fadeIn(animationSpec = tween(250)),
                        exit = shrinkVertically(
                            animationSpec = spring(dampingRatio = 0.7f, stiffness = 400f)
                        ) + fadeOut(animationSpec = tween(200))
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.padding(bottom = 8.dp)
                        ) {
                            sectionPoints.forEach { point ->
                                HistoryCardByPoint(point) { onNavigateToKnowledgeDetail(point.id) }
                            }
                        }
                    }
                }
            }
        } else {
            val searchResults = KnowledgeProvider.allPoints.filter { point ->
                val q = searchQuery.lowercase()
                point.title.lowercase().contains(q) ||
                point.description.lowercase().contains(q) ||
                point.syllabusDetails.any { it.lowercase().contains(q) } ||
                point.teachingNotes.any { note -> 
                    note.title.lowercase().contains(q) || 
                    note.content.lowercase().contains(q) 
                } ||
                point.textbookParagraphs.any { it.content.lowercase().contains(q) } ||
                point.exampleSentences.any { 
                    it.english.lowercase().contains(q) || 
                    it.chinese.lowercase().contains(q) 
                } ||
                point.exampleProblems.any { 
                    it.question.lowercase().contains(q) || 
                    it.explanation.lowercase().contains(q)
                } ||
                point.pastExamQuestions.any {
                    it.question.lowercase().contains(q) ||
                    it.explanation.lowercase().contains(q)
                }
            }

            if (searchResults.isEmpty()) {
                item {
                    Box(modifier = Modifier.fillMaxWidth().padding(32.dp), contentAlignment = Alignment.Center) {
                        Text("未找到相关知识点", color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f))
                    }
                }
            } else {
                items(searchResults) { point ->
                    SearchResultItemData(point, searchQuery) { onNavigateToKnowledgeDetail(point.id) }
                }
            }
        }
    }
}

@Composable
fun HistoryCardByPoint(point: com.example.insight.data.model.KnowledgePoint, onClick: () -> Unit) {
    val status = listOf("已掌握", "练习中", "待复习")
    val primaryColor = MaterialTheme.colorScheme.primary
    val index = point.id.toIntOrNull() ?: 0
    
    Card(modifier = Modifier.fillMaxWidth().clickable { onClick() }, colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), shape = RoundedCornerShape(20.dp)) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(64.dp).clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.surfaceVariant), contentAlignment = Alignment.Center) {
                val iconVec = when (point.section) {
                    com.example.insight.data.model.KnowledgeProvider.SEC_1 -> Icons.Outlined.Spellcheck
                    com.example.insight.data.model.KnowledgeProvider.SEC_2 -> Icons.Outlined.Schedule
                    com.example.insight.data.model.KnowledgeProvider.SEC_3 -> Icons.Outlined.AccountTree
                    else -> Icons.Outlined.Description
                }
                Icon(iconVec, null, tint = primaryColor.copy(alpha = 0.5f))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(point.title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                val previewText = point.description
                    .replace(Regex("#+\\s*"), "")
                    .replace(Regex("\\*\\*"), "")
                    .replace(Regex("\\*"), "")
                    .replace(Regex("\\\\n"), " ")
                    .replace("\n", " ")
                    .replace(Regex("\\s+"), " ")
                    .trim()
                Text(previewText, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f), maxLines = 1)
                Spacer(modifier = Modifier.height(8.dp))
                Surface(color = when(index % 3) { 0 -> primaryColor.copy(alpha = 0.1f); 1 -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.15f); else -> Color.Red.copy(alpha = 0.05f) }, shape = RoundedCornerShape(8.dp)) {
                    Text(text = status[index % 3], modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp), style = MaterialTheme.typography.labelSmall, color = when(index % 3) { 0 -> primaryColor; 1 -> MaterialTheme.colorScheme.secondary; else -> Color.Red })
                }
            }
        }
    }
}

@Composable
fun ProfileTab(
    preferences: UserPreferences,
    studentCount: Int,
    lessonPlanCount: Int,
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

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 120.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
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
                StatCard(
                    label = if (preferences.role == UserRole.Student) "累计扫描" else "我的教案", 
                    value = if (preferences.role == UserRole.Student) "128" else lessonPlanCount.toString(), 
                    modifier = Modifier.weight(1f),
                    onClick = { if (preferences.role == UserRole.Teacher) onManageLessonPlans() }
                )
                StatCard(
                    label = if (preferences.role == UserRole.Student) "攻克考点" else "班级人数", 
                    value = if (preferences.role == UserRole.Student) "42" else studentCount.toString(), 
                    modifier = Modifier.weight(1f),
                    onClick = { if (preferences.role == UserRole.Teacher) onManageStudents() }
                )
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
fun SearchResultItem(index: Int, onClick: () -> Unit) {
    val point = KnowledgeProvider.allPoints[index % KnowledgeProvider.allPoints.size]
    val resultText = "关于【${point.title}】的知识点详解"
    Card(modifier = Modifier.fillMaxWidth().clickable { onClick() }, colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
        Row(modifier = Modifier.padding(vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Outlined.History, contentDescription = null, tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f), modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = resultText, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

@Composable
fun HighlightedText(
    text: String,
    keyword: String,
    style: androidx.compose.ui.text.TextStyle,
    color: androidx.compose.ui.graphics.Color,
    highlightColor: androidx.compose.ui.graphics.Color,
    maxLines: Int = Int.MAX_VALUE,
    overflow: androidx.compose.ui.text.style.TextOverflow = androidx.compose.ui.text.style.TextOverflow.Clip
) {
    if (keyword.isEmpty() || !text.lowercase().contains(keyword.lowercase())) {
        Text(text = text, style = style, color = color, maxLines = maxLines, overflow = overflow)
        return
    }

    val builder = androidx.compose.ui.text.AnnotatedString.Builder(text)
    var startIndex = 0
    val lowerText = text.lowercase()
    val lowerKeyword = keyword.lowercase()
    
    while (startIndex < text.length) {
        val index = lowerText.indexOf(lowerKeyword, startIndex)
        if (index == -1) break
        builder.addStyle(
            style = androidx.compose.ui.text.SpanStyle(
                background = highlightColor.copy(alpha = 0.3f), 
                color = highlightColor
            ),
            start = index,
            end = index + keyword.length
        )
        startIndex = index + keyword.length
    }

    Text(
        text = builder.toAnnotatedString(),
        style = style,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun SearchResultItemData(point: com.example.insight.data.model.KnowledgePoint, query: String, onClick: () -> Unit) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val snippet = getSnippet(point, query)
    
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                val iconVec = when (point.section) {
                    com.example.insight.data.model.KnowledgeProvider.SEC_1 -> Icons.Outlined.Spellcheck
                    com.example.insight.data.model.KnowledgeProvider.SEC_2 -> Icons.Outlined.Schedule
                    com.example.insight.data.model.KnowledgeProvider.SEC_3 -> Icons.Outlined.AccountTree
                    else -> Icons.Outlined.Description
                }
                Icon(iconVec, contentDescription = null, tint = primaryColor, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(12.dp))
                HighlightedText(
                    text = point.title, 
                    keyword = query, 
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), 
                    color = MaterialTheme.colorScheme.onSurface,
                    highlightColor = primaryColor
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            HighlightedText(
                text = snippet,
                keyword = query,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                highlightColor = primaryColor,
                maxLines = 3,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )
        }
    }
}

fun getSnippet(point: com.example.insight.data.model.KnowledgePoint, query: String): String {
    val q = query.lowercase()
    if (point.title.lowercase().contains(q)) return point.description.replace(Regex("[#*`\\n]"), " ").replace(Regex("\\s+"), " ").take(100) + "..."
    if (point.description.lowercase().contains(q)) return extractSnippet(point.description, q)
    
    val syllabusMatch = point.syllabusDetails.find { it.lowercase().contains(q) }
    if (syllabusMatch != null) return "[考纲要求] " + extractSnippet(syllabusMatch, q)
    
    val noteMatch = point.teachingNotes.find { it.content.lowercase().contains(q) || it.title.lowercase().contains(q) }
    if (noteMatch != null) return "[教学笔记 - ${noteMatch.title}] " + extractSnippet(noteMatch.content, q)
    
    val textMatch = point.textbookParagraphs.find { it.content.lowercase().contains(q) }
    if (textMatch != null) return "[教材原句] " + extractSnippet(textMatch.content, q)
    
    val sentenceMatch = point.exampleSentences.find { it.english.lowercase().contains(q) || it.chinese.lowercase().contains(q) }
    if (sentenceMatch != null) return "[例句] " + sentenceMatch.english + " " + sentenceMatch.chinese
    
    val probMatch = point.exampleProblems.find { it.question.lowercase().contains(q) || it.explanation.lowercase().contains(q) }
    if (probMatch != null) return "[典型例题] " + extractSnippet(probMatch.question + " " + probMatch.explanation, q)
    
    val examMatch = point.pastExamQuestions.find { it.question.lowercase().contains(q) || it.explanation.lowercase().contains(q) }
    if (examMatch != null) return "[真题] " + extractSnippet(examMatch.question + " " + examMatch.explanation, q)
    
    return point.description.replace(Regex("[#*`\\n]"), " ").replace(Regex("\\s+"), " ").take(100) + "..."
}

fun extractSnippet(text: String, query: String): String {
    val cleanText = text.replace(Regex("[#*`\\n]"), " ").replace(Regex("\\s+"), " ").trim()
    val index = cleanText.lowercase().indexOf(query.lowercase())
    if (index == -1) return cleanText.take(100)
    
    val start = kotlin.math.max(0, index - 30)
    val end = kotlin.math.min(cleanText.length, index + query.length + 50)
    var snippet = cleanText.substring(start, end)
    if (start > 0) snippet = "...$snippet"
    if (end < cleanText.length) snippet = "$snippet..."
    return snippet
}

@Composable
fun HistoryCard(index: Int, onClick: () -> Unit) {
    val point = KnowledgeProvider.allPoints[index % KnowledgeProvider.allPoints.size]
    val status = listOf("已掌握", "练习中", "待复习")
    val primaryColor = MaterialTheme.colorScheme.primary
    Card(modifier = Modifier.fillMaxWidth().clickable { onClick() }, colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), shape = RoundedCornerShape(20.dp)) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(80.dp).clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.surfaceVariant), contentAlignment = Alignment.Center) {
                Icon(Icons.Outlined.Description, null, tint = primaryColor.copy(alpha = 0.5f))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(point.title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                Text("扫描时间: 2024.03.1${index}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                Spacer(modifier = Modifier.height(8.dp))
                Surface(color = when(index % 3) { 0 -> primaryColor.copy(alpha = 0.1f); 1 -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.15f); else -> Color.Red.copy(alpha = 0.05f) }, shape = RoundedCornerShape(8.dp)) {
                    Text(text = status[index % 3], modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp), style = MaterialTheme.typography.labelSmall, color = when(index % 3) { 0 -> primaryColor; 1 -> MaterialTheme.colorScheme.secondary; else -> Color.Red })
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
    
    // Mock data for initial view
    val mockGraphState = remember { GraphState(
        nodes = kotlin.collections.listOf(
            KnowledgeNode(id = "r1", title = "词法体系", level = 0, masteryLevel = 0.85f, x = 300f, y = 300f),
            KnowledgeNode(id = "r2", title = "句法体系", level = 0, masteryLevel = 0.60f, x = 800f, y = 350f),
            KnowledgeNode(id = "r3", title = "时态语态", level = 0, masteryLevel = 0.45f, x = 550f, y = 600f)
        ),
        edges = kotlin.collections.listOf()
    ) }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF0F1218))) {
        StarfieldComponent(
            graphState = mockGraphState,
            onNodeClick = { node -> 
                selectedNode = node
                showSheet = true 
            },
            modifier = Modifier.fillMaxSize()
        )
        
        // Header
        Column(modifier = Modifier.padding(top = 24.dp, start = 24.dp).align(Alignment.TopStart)) {
            Text(
                "知识图谱", 
                style = MaterialTheme.typography.headlineMedium, 
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = if (preferences.role == UserRole.Teacher) "班级认知链路全景图" else "你的 AI 知识大脑", 
                style = MaterialTheme.typography.bodyMedium, 
                color = Color.White.copy(alpha = 0.6f)
            )
        }
    }
    
    if (showSheet && selectedNode != null) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.surface,
            dragHandle = { BottomSheetDefaults.DragHandle(color = Color.Gray.copy(alpha = 0.4f)) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .padding(bottom = 40.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    val color = when {
                        selectedNode!!.masteryLevel >= 0.85f -> Color(0xFF43A047)
                        selectedNode!!.masteryLevel >= 0.60f -> Color(0xFFFFB300)
                        else -> MaterialTheme.colorScheme.error
                    }
                    Box(modifier = Modifier.size(12.dp).background(color, CircleShape))
                    Spacer(Modifier.width(12.dp))
                    Text(
                        text = selectedNode!!.title, 
                        style = MaterialTheme.typography.headlineSmall, 
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("当前掌握度", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                        Text("${(selectedNode!!.masteryLevel * 100).toInt()}%", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Black)
                        Spacer(Modifier.height(8.dp))
                        LinearProgressIndicator(
                            progress = { selectedNode!!.masteryLevel },
                            modifier = Modifier.fillMaxWidth().height(8.dp).clip(CircleShape),
                        )
                    }
                }
                
                Button(
                    onClick = { showSheet = false },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(Icons.Default.AutoAwesome, null)
                    Spacer(Modifier.width(8.dp))
                    Text("开启认知链路溯源")
                }
            }
        }
    }
}

@Composable
fun GraphPreviewCard(onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().height(160.dp).clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F1218))
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Static background or mini canvas could go here
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.AutoAwesome, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("点击探索多维认知图谱", color = Color.White, style = MaterialTheme.typography.titleSmall)
                }
                Spacer(Modifier.weight(1f))
                Text("AI 动态追踪 42 个核心考点", color = Color.White.copy(alpha = 0.5f), style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

@Composable
fun LearningAnalysisSummary(students: List<com.example.insight.data.local.entities.StudentEntity>, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text("当前班级平均分", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    val avg = if (students.isEmpty()) "0" else students.map { it.latestScore }.average().toInt().toString()
                    Text(avg, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                }
                Icon(Icons.Default.TrendingUp, null, tint = MaterialTheme.colorScheme.primary)
            }
            Spacer(Modifier.height(12.dp))
            Text("班级近期进步最快：句法结构模块", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
fun AnalysisTab(
    preferences: UserPreferences,
    students: List<com.example.insight.data.local.entities.StudentEntity>,
    scans: List<com.example.insight.data.local.entities.ScanRecordEntity>
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 120.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Column {
                Text("学情分析", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                Text(text = "实时掌握学生的认知状态与成长趋势", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f))
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                StatCard(
                    label = "班级平均分", 
                    value = if (students.isEmpty()) "0" else (students.map { it.latestScore }.average().toInt()).toString(), 
                    modifier = Modifier.weight(1f)
                )
                StatCard(
                    label = "活跃考点数", 
                    value = "24", 
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.TrendingUp, null, tint = primaryColor)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("全班掌握度概览", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(200.dp).background(primaryColor.copy(alpha = 0.05f), RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center) {
                        Text("近期全班考点掌握度趋于稳定，从句法模块有显著提升", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                    }
                }
            }
        }

        item {
            Text("按掌握度查看学生", style = MaterialTheme.typography.labelMedium, color = primaryColor, fontWeight = FontWeight.Bold)
        }

        items(students.sortedByDescending { it.latestScore }.take(5)) { student ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(40.dp).background(primaryColor.copy(alpha = 0.1f), CircleShape), contentAlignment = Alignment.Center) {
                        Text(student.name.take(1), fontWeight = FontWeight.Bold, color = primaryColor)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(student.name, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        Text(student.className, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    }
                    Text("${student.latestScore.toInt()}", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black, color = primaryColor)
                }
            }
        }
    }
}

@Composable
fun StatCard(label: String, value: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Card(
        modifier = modifier.clickable { onClick() }, 
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

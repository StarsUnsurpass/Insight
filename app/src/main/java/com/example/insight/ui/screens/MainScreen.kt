package com.example.insight.ui.screens

import android.os.Build
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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.insight.ui.state.InsightViewModel
import com.example.insight.ui.state.UserPreferences
import com.example.insight.ui.state.UserRole
import com.example.insight.ui.theme.*
import kotlin.math.hypot
import kotlinx.coroutines.launch

enum class InsightTab(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val index: Int,
    val bias: Float // Unified bias: -2, -1, 1, 2 representing slots relative to center
) {
    Home("首页", Icons.Filled.Home, Icons.Outlined.Home, 0, -2f),
    Map("图谱", Icons.Filled.AccountTree, Icons.Outlined.AccountTree, 1, -1f),
    Analysis("学情", Icons.Filled.Analytics, Icons.Outlined.Analytics, 3, 1f), 
    Profile("我的", Icons.Filled.Person, Icons.Outlined.Person, 4, 2f)
}

@Composable
fun MainScreen(
    onNavigateToScanner: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    val viewModel: InsightViewModel = hiltViewModel()
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

    // --- High-Fidelity Physics ---
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
                // 1. Main Content with Z-Axis Zoom Transition
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
                            InsightTab.Home -> HomeTab()
                            InsightTab.Map -> MapTab()
                            InsightTab.Analysis -> KnowledgeGraphScreen()
                            InsightTab.Profile -> ProfileTab(
                                preferences = preferences,
                                onNavigateToSettings = onNavigateToSettings
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
                revealProgress.animateTo(1f, animationSpec = tween(600, easing = FastOutSlowInEasing))
                onNavigateToScanner()
                revealProgress.snapTo(0f)
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
        // 1. Background Liquid Surface
        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(36.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            shadowElevation = 12.dp,
            border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.05f))
        ) {}

        // 2. Liquid Elastic Indicator (Synchronized with Icons)
        if (currentDockWidth > 200.dp) {
            val indicatorSize = 52.dp
            val targetCenterX = slotWidth * selectedTab.bias
            
            // Separate spring engines for left/right to achieve stretching
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
                    .offset(x = (leftEdge + rightEdge) / 2) // Precision centering
                    .size(width = (rightEdge - leftEdge).coerceAtLeast(indicatorSize), height = indicatorSize)
                    .background(primaryColor.copy(alpha = 0.12f), CircleShape)
            )
        }

        // 3. Icon Layer (Unified Positioning)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            val alpha by animateFloatAsState(
                targetValue = if (isVisible && currentDockWidth > 200.dp) 1f else 0f,
                animationSpec = tween(250)
            )

            TabIconFluid(InsightTab.Home, selectedTab, alpha, slotWidth, onTabSelected)
            TabIconFluid(InsightTab.Map, selectedTab, alpha, slotWidth, onTabSelected)
            
            // Central Camera: FIXED SIZE, CENTERED
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
    
    // Exact center alignment based on the same slotWidth used by indicator
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

// --- Content Tabs (Retained for Integrity) ---

@Composable
fun HomeTab() {
    val primaryColor = MaterialTheme.colorScheme.primary
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            Column(modifier = Modifier.padding(vertical = 12.dp)) {
                Text("早上好，同学 📚", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                Text("今天也要保持思考哦。", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
            }
        }
        item {
            OutlinedTextField(
                value = "", onValueChange = {}, placeholder = { Text("搜索题目或知识点...", style = MaterialTheme.typography.bodyMedium) },
                modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp),
                leadingIcon = { Icon(Icons.Default.Search, null, tint = primaryColor) },
                trailingIcon = { Icon(Icons.Default.Mic, null, tint = primaryColor) },
                colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f), focusedBorderColor = primaryColor)
            )
        }
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("最近扫描", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                TextButton(onClick = { }) { Text("全部", color = primaryColor, style = MaterialTheme.typography.labelMedium) }
            }
        }
        items(5) { index -> HistoryCard(index) }
    }
}

@Composable
fun HistoryCard(index: Int) {
    val labels = listOf("定语从句", "虚拟语气", "分词结构", "阅读理解", "长难句")
    val status = listOf("已掌握", "练习中", "待复习")
    val primaryColor = MaterialTheme.colorScheme.primary
    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), shape = RoundedCornerShape(20.dp)) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(80.dp).clip(RoundedCornerShape(12.dp)).background(SoftOatmeal), contentAlignment = Alignment.Center) {
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

@Composable
fun MapTab() {
    val primaryColor = MaterialTheme.colorScheme.primary
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("知识图谱", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
        Text("系统化掌握 12 个核心考点领域", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f))
        Spacer(modifier = Modifier.height(20.dp))
        val domains = listOf("时态语态", "从句结构", "词汇辨析", "阅读技巧", "写作模板", "听力精听")
        LazyVerticalGrid(columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(domains) { domain ->
                Card(modifier = Modifier.height(140.dp), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Box(modifier = Modifier.size(40.dp).background(primaryColor.copy(alpha = 0.1f), CircleShape), contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.AutoGraph, null, tint = primaryColor, modifier = Modifier.size(20.dp))
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(domain, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        LinearProgressIndicator(progress = { 0.6f }, modifier = Modifier.fillMaxWidth().height(4.dp).clip(CircleShape), color = primaryColor, trackColor = primaryColor.copy(alpha = 0.1f))
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileTab(preferences: UserPreferences, onNavigateToSettings: () -> Unit) {
    val primaryColor = MaterialTheme.colorScheme.primary
    LazyColumn(modifier = Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(64.dp).background(SoftOatmeal, CircleShape), contentAlignment = Alignment.Center) {
                    Icon(imageVector = when(preferences.role) {
                        UserRole.Student -> Icons.Default.Person
                        UserRole.Teacher -> Icons.Default.CastForEducation
                    }, contentDescription = null, modifier = Modifier.size(32.dp), tint = primaryColor)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("${preferences.username} ", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Surface(
                            color = primaryColor.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = when(preferences.role) {
                                    UserRole.Student -> "同学"
                                    UserRole.Teacher -> "老师"
                                },
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                style = MaterialTheme.typography.labelSmall,
                                color = primaryColor
                            )
                        }
                    }
                    Text(preferences.className, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f))
                }
            }
        }
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                StatCard(if (preferences.role == UserRole.Student) "累计扫描" else "教学课件", if (preferences.role == UserRole.Student) "128" else "12", Modifier.weight(1f))
                StatCard(if (preferences.role == UserRole.Student) "攻克考点" else "批改人次", if (preferences.role == UserRole.Student) "42" else "356", Modifier.weight(1f))
            }
        }
        item {
            DashboardCard(title = "学习设置") {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    SettingRow(Icons.Default.PictureAsPdf, if (preferences.role == UserRole.Student) "导出错题本 (PDF)" else "导出班级报告 (PDF)")
                    SettingRow(Icons.Default.CloudUpload, "数据同步")
                    SettingRow(icon = Icons.Default.Settings, title = "偏好设置", onClick = onNavigateToSettings)
                }
            }
        }
    }
}

@Composable
fun StatCard(label: String, value: String, modifier: Modifier = Modifier) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Card(modifier = modifier, shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = primaryColor.copy(alpha = 0.1f))) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(label, style = MaterialTheme.typography.labelSmall, color = primaryColor); Text(value, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = primaryColor)
        }
    }
}

@Composable
fun SettingRow(icon: ImageVector, title: String, onClick: (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(20.dp), tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
        Spacer(modifier = Modifier.width(16.dp)); Text(title, style = MaterialTheme.typography.bodyMedium); Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.LightGray)
    }
}

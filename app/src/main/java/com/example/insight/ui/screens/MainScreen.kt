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
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.insight.ui.theme.*
import kotlin.math.hypot
import kotlinx.coroutines.launch

// Precise positioning helper
data class TabBounds(val left: Dp, val right: Dp) {
    val width: Dp get() = right - left
}

enum class InsightTab(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val index: Int
) {
    Home("首页", Icons.Filled.Home, Icons.Outlined.Home, 0),
    Map("图谱", Icons.Filled.AccountTree, Icons.Outlined.AccountTree, 1),
    Analysis("学情", Icons.Filled.Analytics, Icons.Outlined.Analytics, 3), 
    Profile("我的", Icons.Filled.Person, Icons.Outlined.Person, 4)
}

@Composable
fun MainScreen(
    onNavigateToScanner: () -> Unit,
    onNavigateToSolution: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(InsightTab.Home) }
    var isDockVisible by remember { mutableStateOf(true) }
    var isRevealing by remember { mutableStateOf(false) }

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

    // Squash and Stretch wobble for the entire Dock instead of translationY
    val dockWobbleScaleX = remember { Animatable(1f) }
    val dockWobbleScaleY = remember { Animatable(1f) }
    
    LaunchedEffect(selectedTab) {
        launch {
            dockWobbleScaleX.animateTo(1.06f, spring(stiffness = Spring.StiffnessMediumLow))
            dockWobbleScaleX.animateTo(1f, spring(dampingRatio = Spring.DampingRatioMediumBouncy))
        }
        launch {
            dockWobbleScaleY.animateTo(0.96f, spring(stiffness = Spring.StiffnessMediumLow))
            dockWobbleScaleY.animateTo(1f, spring(dampingRatio = Spring.DampingRatioMediumBouncy))
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(containerColor = PaperWhite) { innerPadding ->
            Box(modifier = Modifier.fillMaxSize().nestedScroll(nestedScrollConnection)) {
                Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                    when (selectedTab) {
                        InsightTab.Home -> HomeTab()
                        InsightTab.Map -> MapTab()
                        InsightTab.Analysis -> KnowledgeGraphScreen(onClose = { /* Not applicable */ })
                        InsightTab.Profile -> ProfileTab()
                    }
                }

                val dockWidth by animateDpAsState(
                    targetValue = if (isDockVisible) 340.dp else 76.dp,
                    animationSpec = spring(dampingRatio = 0.7f, stiffness = 60f),
                    label = "dock_width"
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 32.dp)
                        .width(dockWidth)
                        .height(72.dp) // Explicitly fixed height for better internal alignment
                        .graphicsLayer {
                            scaleX = dockWobbleScaleX.value
                            scaleY = dockWobbleScaleY.value
                        }
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
            LaunchedEffect(Unit) {
                revealProgress.animateTo(1f, animationSpec = tween(600, easing = FastOutSlowInEasing))
                onNavigateToScanner()
                revealProgress.snapTo(0f)
                isRevealing = false
            }
            Canvas(modifier = Modifier.fillMaxSize()) {
                val centerOffset = Offset(size.width / 2, size.height - 68.dp.toPx())
                val maxRadius = hypot(size.width, size.height)
                drawCircle(color = SageGreen, radius = maxRadius * revealProgress.value, center = centerOffset)
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
    val slotWidth = currentDockWidth / 5
    
    // Exact center-based calculation for indicators
    val tabBounds = remember(currentDockWidth) {
        List(5) { i ->
            val center = slotWidth * (i + 0.5f)
            TabBounds(left = center - 26.dp, right = center + 26.dp)
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        // 1. Fluid Background Pill
        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(36.dp),
            color = Color.White,
            tonalElevation = 6.dp,
            shadowElevation = 12.dp,
            border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.05f))
        ) {}

        // 2. Liquid Elastic Indicator
        if (currentDockWidth > 200.dp) {
            val target = tabBounds[selectedTab.index]
            
            // Separate spring engines for left/right to achieve stretching
            val leftEdge by animateDpAsState(
                targetValue = target.left,
                animationSpec = spring(dampingRatio = 0.8f, stiffness = 100f),
                label = "liquid_left"
            )
            val rightEdge by animateDpAsState(
                targetValue = target.right,
                animationSpec = spring(dampingRatio = 0.8f, stiffness = 100f),
                label = "liquid_right"
            )

            Box(
                modifier = Modifier
                    .size(width = rightEdge - leftEdge, height = 52.dp)
                    .align(Alignment.CenterStart)
                    .offset(x = leftEdge)
                    .background(SageGreen.copy(alpha = 0.12f), CircleShape)
            )
        }

        // 3. Tab Slot Row
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            val contentAlpha by animateFloatAsState(
                targetValue = if (isVisible && currentDockWidth > 250.dp) 1f else 0f,
                animationSpec = tween(250)
            )

            TabItemPrecision(InsightTab.Home, selectedTab, contentAlpha, onTabSelected)
            TabItemPrecision(InsightTab.Map, selectedTab, contentAlpha, onTabSelected)
            
            // Central Camera Button (Fixed position)
            Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(SageGreen)
                        .clickable { 
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                            onCameraClick() 
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Default.CameraAlt, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
                }
            }

            TabItemPrecision(InsightTab.Analysis, selectedTab, contentAlpha, onTabSelected)
            TabItemPrecision(InsightTab.Profile, selectedTab, contentAlpha, onTabSelected)
        }
    }
}

@Composable
fun RowScope.TabItemPrecision(
    tab: InsightTab,
    selectedTab: InsightTab,
    alpha: Float,
    onTabSelected: (InsightTab) -> Unit
) {
    val haptic = LocalHapticFeedback.current
    val isSelected = selectedTab == tab
    
    Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
        if (alpha > 0.01f) {
            // Smooth color dye effect
            val tint by animateColorAsState(
                targetValue = if (isSelected) SageGreen else InkBlue.copy(alpha = 0.4f),
                animationSpec = tween(300)
            )
            val scale by animateFloatAsState(
                targetValue = if (isSelected) 1.2f else 1f,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
            )

            // Custom clickable box instead of IconButton to ensure 100% centering
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .alpha(alpha)
                    .scale(scale)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null, // Custom visual feedback via indicator
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
}

// --- Content Tabs (Retained for Integrity) ---

@Composable
fun HomeTab() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(modifier = Modifier.padding(vertical = 12.dp)) {
                Text("早上好，同学 📚", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = InkBlue)
                Text("今天也要保持思考哦。", style = MaterialTheme.typography.bodyMedium, color = InkBlue.copy(alpha = 0.6f))
            }
        }
        item {
            OutlinedTextField(
                value = "", onValueChange = {},
                placeholder = { Text("搜索题目或知识点...", style = MaterialTheme.typography.bodyMedium) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = { Icon(Icons.Default.Search, null, tint = SageGreen) },
                trailingIcon = { Icon(Icons.Default.Mic, null, tint = SageGreen) },
                colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = InkBlue.copy(alpha = 0.1f), focusedBorderColor = SageGreen)
            )
        }
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("最近扫描", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                TextButton(onClick = { /* View All */ }) {
                    Text("全部", color = SageGreen, style = MaterialTheme.typography.labelMedium)
                }
            }
        }
        items(5) { index -> HistoryCard(index) }
    }
}

@Composable
fun HistoryCard(index: Int) {
    val labels = listOf("定语从句", "虚拟语气", "分词结构", "阅读理解", "长难句")
    val status = listOf("已掌握", "练习中", "待复习")
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(80.dp).clip(RoundedCornerShape(12.dp)).background(SoftOatmeal), contentAlignment = Alignment.Center) {
                Icon(Icons.Outlined.Description, null, tint = SageGreen.copy(alpha = 0.5f))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(labels[index % labels.size], style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = InkBlue)
                Spacer(modifier = Modifier.height(4.dp))
                Text("扫描时间: 2024.03.1${index}", style = MaterialTheme.typography.labelSmall, color = InkBlue.copy(alpha = 0.5f))
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    color = when(index % 3) { 0 -> SageGreen.copy(alpha = 0.1f); 1 -> HighlightYellow.copy(alpha = 0.2f); else -> Color.Red.copy(alpha = 0.05f) },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = status[index % 3], modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp), style = MaterialTheme.typography.labelSmall, color = when(index % 3) { 0 -> SageGreen; 1 -> Color(0xFFB8860B); else -> Color.Red })
                }
            }
        }
    }
}

@Composable
fun MapTab() {
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("知识图谱", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = InkBlue)
        Text("系统化掌握 12 个核心考点领域", style = MaterialTheme.typography.bodySmall, color = InkBlue.copy(alpha = 0.5f))
        Spacer(modifier = Modifier.height(20.dp))
        val domains = listOf("时态语态", "从句结构", "词汇辨析", "阅读技巧", "写作模板", "听力精听")
        LazyVerticalGrid(columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(domains) { domain ->
                Card(modifier = Modifier.height(140.dp), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = Color.White), border = BorderStroke(1.dp, InkBlue.copy(alpha = 0.05f))) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Box(modifier = Modifier.size(40.dp).background(SageGreen.copy(alpha = 0.1f), CircleShape), contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.AutoGraph, null, tint = SageGreen, modifier = Modifier.size(20.dp))
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(domain, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(4.dp))
                        LinearProgressIndicator(progress = 0.6f, modifier = Modifier.fillMaxWidth().height(4.dp).clip(CircleShape), color = SageGreen, trackColor = SageGreen.copy(alpha = 0.1f))
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileTab() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(64.dp).background(SoftOatmeal, CircleShape), contentAlignment = Alignment.Center) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null, modifier = Modifier.size(32.dp), tint = SageGreen)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("王小明 同学", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text("初三 (2) 班", style = MaterialTheme.typography.bodySmall, color = InkBlue.copy(alpha = 0.5f))
                }
            }
        }
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                StatCard("累计扫描", "128", Modifier.weight(1f))
                StatCard("攻克考点", "42", Modifier.weight(1f))
            }
        }
        item {
            DashboardCard(title = "学习设置") {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    SettingRow(Icons.Default.PictureAsPdf, "导出错题本 (PDF)")
                    SettingRow(Icons.Default.CloudUpload, "数据同步")
                    SettingRow(Icons.Default.Settings, "偏好设置")
                }
            }
        }
    }
}

@Composable
fun StatCard(label: String, value: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier, shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = SageGreen.copy(alpha = 0.1f))) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(label, style = MaterialTheme.typography.labelSmall, color = SageGreen)
            Text(value, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = SageGreen)
        }
    }
}

@Composable
fun SettingRow(icon: ImageVector, title: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(20.dp), tint = InkBlue.copy(alpha = 0.6f))
        Spacer(modifier = Modifier.width(16.dp))
        Text(title, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.LightGray)
    }
}

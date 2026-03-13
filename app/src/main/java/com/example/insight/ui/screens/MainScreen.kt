package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.LocalConfiguration
import kotlin.math.hypot
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.insight.ui.theme.*

enum class InsightTab(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    Home("首页", Icons.Filled.Home, Icons.Outlined.Home),
    Map("图谱", Icons.Filled.AccountTree, Icons.Outlined.AccountTree),
    Analysis("学情", Icons.Filled.Analytics, Icons.Outlined.Analytics),
    Profile("我的", Icons.Filled.Person, Icons.Outlined.Person)
}

@Composable
fun MainScreen(
    onNavigateToScanner: () -> Unit,
    onNavigateToSolution: () -> Unit // For testing or direct access
) {
    var selectedTab by remember { mutableStateOf(InsightTab.Home) }
    var isDockVisible by remember { mutableStateOf(true) }
    var isRevealing by remember { mutableStateOf(false) }

    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp.dp
    val screenHeight = config.screenHeightDp.dp

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                if (available.y < -10f && !isRevealing) {
                    isDockVisible = false
                } else if (available.y > 10f && !isRevealing) {
                    isDockVisible = true
                }
                return Offset.Zero
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            containerColor = PaperWhite,
        ) { innerPadding ->
            Box(modifier = Modifier.fillMaxSize().nestedScroll(nestedScrollConnection)) {
                // 1. Main Content
                Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                    when (selectedTab) {
                        InsightTab.Home -> HomeTab()
                        InsightTab.Map -> MapTab()
                        InsightTab.Analysis -> KnowledgeGraphScreen(onClose = { /* Not applicable */ })
                        InsightTab.Profile -> ProfileTab()
                    }
                }

                // 2. Floating Dock & Gooey Container
                val offsetY by animateFloatAsState(
                    targetValue = if (isDockVisible) 0f else 250f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    ),
                    label = "dock_offset"
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 24.dp)
                        .graphicsLayer { translationY = offsetY }
                ) {
                    GooeyDock(
                        selectedTab = selectedTab,
                        onTabSelected = { selectedTab = it },
                        onCameraClick = {
                            isRevealing = true
                        }
                    )
                }
            }
        }

        // 3. Circular Reveal Layer
        if (isRevealing) {
            val revealProgress = remember { Animatable(0f) }
            LaunchedEffect(Unit) {
                revealProgress.animateTo(1f, animationSpec = tween(600, easing = FastOutSlowInEasing))
                onNavigateToScanner()
                // Reset after a delay or upon return
                revealProgress.snapTo(0f)
                isRevealing = false
            }

            Canvas(modifier = Modifier.fillMaxSize()) {
                val center = Offset(size.width / 2, size.height - 66.dp.toPx() - 24.dp.toPx())
                val maxRadius = hypot(size.width, size.height)
                drawCircle(
                    color = SageGreen,
                    radius = maxRadius * revealProgress.value,
                    center = center
                )
            }
        }
    }
}

@Composable
fun GooeyDock(
    selectedTab: InsightTab,
    onTabSelected: (InsightTab) -> Unit,
    onCameraClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        // The Dock Background (Mac Style)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(36.dp),
            color = Color.White.copy(alpha = 0.95f),
            tonalElevation = 8.dp,
            shadowElevation = 12.dp,
            border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.05f))
        ) {
            Row(
                modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left Tabs
                Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                    TabItem(InsightTab.Home, selectedTab == InsightTab.Home) { onTabSelected(InsightTab.Home) }
                    TabItem(InsightTab.Map, selectedTab == InsightTab.Map) { onTabSelected(InsightTab.Map) }
                }

                // Middle Gap
                Spacer(modifier = Modifier.width(80.dp))

                // Right Tabs
                Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
                    TabItem(InsightTab.Analysis, selectedTab == InsightTab.Analysis) { onTabSelected(InsightTab.Analysis) }
                    TabItem(InsightTab.Profile, selectedTab == InsightTab.Profile) { onTabSelected(InsightTab.Profile) }
                }
            }
        }

        // The Separated Camera Button (The Water Drop)
        var isPressed by remember { mutableStateOf(false) }
        val dropScale by animateFloatAsState(
            targetValue = if (isPressed) 0.85f else 1f,
            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
            label = "drop_scale"
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 4.dp)
                .size(76.dp)
                .scale(dropScale)
                .clip(CircleShape)
                .background(SageGreen)
                .clickable { 
                    onCameraClick()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = "扫描",
                modifier = Modifier.size(32.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
fun TabItem(tab: InsightTab, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable(onClick = onClick).padding(8.dp)
    ) {
        Icon(
            imageVector = if (isSelected) tab.selectedIcon else tab.unselectedIcon,
            contentDescription = tab.title,
            tint = if (isSelected) SageGreen else InkBlue.copy(alpha = 0.5f),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = tab.title,
            style = MaterialTheme.typography.labelSmall,
            color = if (isSelected) SageGreen else InkBlue.copy(alpha = 0.5f),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

// Placeholder Tabs
@Composable
fun HomeTab() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(modifier = Modifier.padding(vertical = 12.dp)) {
                Text(
                    "早上好，同学 📚",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = InkBlue
                )
                Text(
                    "今天也要保持思考哦。",
                    style = MaterialTheme.typography.bodyMedium,
                    color = InkBlue.copy(alpha = 0.6f)
                )
            }
        }
        
        item {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("搜索题目或知识点...", style = MaterialTheme.typography.bodyMedium) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = { Icon(Icons.Default.Search, null, tint = SageGreen) },
                trailingIcon = { Icon(Icons.Default.Mic, null, tint = SageGreen) },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = InkBlue.copy(alpha = 0.1f),
                    focusedBorderColor = SageGreen
                )
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("最近扫描", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                TextButton(onClick = { /* View All */ }) {
                    Text("全部", color = SageGreen, style = MaterialTheme.typography.labelMedium)
                }
            }
        }

        items(5) { index ->
            HistoryCard(index)
        }
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
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Mock Image Thumbnail
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(SoftOatmeal),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Outlined.Description, null, tint = SageGreen.copy(alpha = 0.5f))
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column {
                Text(
                    labels[index % labels.size],
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = InkBlue
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "扫描时间: 2024.03.1${index}",
                    style = MaterialTheme.typography.labelSmall,
                    color = InkBlue.copy(alpha = 0.5f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    color = when(index % 3) {
                        0 -> SageGreen.copy(alpha = 0.1f)
                        1 -> HighlightYellow.copy(alpha = 0.2f)
                        else -> Color.Red.copy(alpha = 0.05f)
                    },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = status[index % 3],
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = when(index % 3) {
                            0 -> SageGreen
                            1 -> Color(0xFFB8860B)
                            else -> Color.Red
                        }
                    )
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
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(domains) { domain ->
                Card(
                    modifier = Modifier.height(140.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, InkBlue.copy(alpha = 0.05f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Box(modifier = Modifier.size(40.dp).background(SageGreen.copy(alpha = 0.1f), CircleShape), contentAlignment = Alignment.Center) {
                            Icon(imageVector = Icons.Default.AutoGraph, contentDescription = null, tint = SageGreen, modifier = Modifier.size(20.dp))
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(domain, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(4.dp))
                        LinearProgressIndicator(
                            progress = 0.6f,
                            modifier = Modifier.fillMaxWidth().height(4.dp).clip(CircleShape),
                            color = SageGreen,
                            trackColor = SageGreen.copy(alpha = 0.1f)
                        )
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
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.LightGray)
    }
}

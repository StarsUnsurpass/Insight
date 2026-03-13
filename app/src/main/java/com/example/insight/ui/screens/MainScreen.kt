package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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

    Scaffold(
        containerColor = PaperWhite,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ScanningFAB(onClick = onNavigateToScanner)
        },
        bottomBar = {
            MainBottomBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when (selectedTab) {
                InsightTab.Home -> HomeTab()
                InsightTab.Map -> MapTab()
                InsightTab.Analysis -> KnowledgeGraphScreen(onClose = { /* Not applicable here */ })
                InsightTab.Profile -> ProfileTab()
            }
        }
    }
}

@Composable
fun ScanningFAB(onClick: () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition(label = "ripple")
    val rippleScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rippleScale"
    )
    val rippleAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rippleAlpha"
    )

    Box(contentAlignment = Alignment.Center) {
        // Ripple Effect
        Box(
            modifier = Modifier
                .size(64.dp)
                .scale(rippleScale)
                .background(SageGreen.copy(alpha = rippleAlpha), CircleShape)
        )
        
        FloatingActionButton(
            onClick = onClick,
            shape = CircleShape,
            containerColor = SageGreen,
            contentColor = Color.White,
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            modifier = Modifier.size(64.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = "扫描",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun MainBottomBar(
    selectedTab: InsightTab,
    onTabSelected: (InsightTab) -> Unit
) {
    BottomAppBar(
        containerColor = Color.White,
        contentPadding = PaddingValues(horizontal = 8.dp),
        tonalElevation = 8.dp,
        modifier = Modifier.height(72.dp)
    ) {
        // Left Tabs
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
            TabItem(InsightTab.Home, selectedTab == InsightTab.Home) { onTabSelected(InsightTab.Home) }
            TabItem(InsightTab.Map, selectedTab == InsightTab.Map) { onTabSelected(InsightTab.Map) }
        }

        Spacer(modifier = Modifier.width(72.dp)) // Space for FAB

        // Right Tabs
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceEvenly) {
            TabItem(InsightTab.Analysis, selectedTab == InsightTab.Analysis) { onTabSelected(InsightTab.Analysis) }
            TabItem(InsightTab.Profile, selectedTab == InsightTab.Profile) { onTabSelected(InsightTab.Profile) }
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
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("知识图谱系统", style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
fun ProfileTab() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("个人中心", style = MaterialTheme.typography.titleMedium)
    }
}

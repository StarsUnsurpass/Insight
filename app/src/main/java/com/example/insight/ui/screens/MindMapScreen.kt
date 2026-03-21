package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.state.UserPreferences

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MindMapScreen(
    preferences: UserPreferences,
    viewModel: MindMapViewModel,
    onBack: () -> Unit
) {
    val rootNode by viewModel.rootNode.collectAsState()
    val isGenerating by viewModel.isGenerating.collectAsState()
    
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    var searchQuery by remember { mutableStateOf("") }
    var isInputExpanded by remember { mutableStateOf(false) }

    // 用于绘制连接线的全局状态，记录节点的位置
    val nodePositions = remember { mutableStateMapOf<String, Offset>() }
    var treeCoordinates by remember { mutableStateOf<androidx.compose.ui.layout.LayoutCoordinates?>(null) }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFF8F9FB))) {
        
        // --- The Native Infinite Canvas ---
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        scale = (scale * zoom).coerceIn(0.2f, 5f)
                        offset += pan
                    }
                }
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offset.x
                    translationY = offset.y
                }
        ) {
            if (rootNode != null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .onGloballyPositioned { treeCoordinates = it },
                    contentAlignment = Alignment.Center
                ) {
                    MindMapTree(
                        node = rootNode!!,
                        level = 0,
                        onPositioned = { id, coords ->
                            treeCoordinates?.let { root ->
                                val localPos = root.localPositionOf(coords, Offset.Zero)
                                val size = coords.size
                                nodePositions["${id}_right"] = localPos + Offset(size.width.toFloat(), size.height / 2f)
                                nodePositions["${id}_left"] = localPos + Offset(0f, size.height / 2f)
                            }
                        },
                        onToggleExpand = { node ->
                            node.isExpanded = !node.isExpanded
                        }
                    )
                    
                    // 绘制连线
                    Canvas(modifier = Modifier.matchParentSize()) {
                        drawConnections(rootNode!!, nodePositions)
                    }
                }
            } else {
                EmptyStateView()
            }
        }

        // --- Top Bar ---
        TopAppBar(
            title = { Text("AI 智能思维导图", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White.copy(alpha = 0.8f))
        )

        // --- Bottom Magic Input ---
        Box(modifier = Modifier.align(Alignment.BottomCenter).padding(32.dp)) {
            if (isInputExpanded) {
                InputCard(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    onSend = {
                        if (searchQuery.isNotBlank()) {
                            viewModel.generateMindMap(searchQuery, preferences.deepSeekApiKey)
                            isInputExpanded = false
                        }
                    }
                )
            } else {
                MagicButton(onClick = { isInputExpanded = true })
            }
        }

        if (isGenerating) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter), color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
fun MindMapTree(
    node: MindMapNode,
    level: Int,
    onPositioned: (String, androidx.compose.ui.layout.LayoutCoordinates) -> Unit,
    onToggleExpand: (MindMapNode) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 12.dp)
    ) {
        // 当前节点
        NodeItem(
            node = node,
            level = level,
            onToggleExpand = { onToggleExpand(node) },
            modifier = Modifier.onGloballyPositioned { coordinates ->
                onPositioned(node.id, coordinates)
            }
        )

        // 子节点列表
        if (node.children.isNotEmpty() && node.isExpanded) {
            Spacer(modifier = Modifier.width(60.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                node.children.forEach { child ->
                    MindMapTree(child, level + 1, onPositioned, onToggleExpand)
                }
            }
        }
    }
}

@Composable
fun NodeItem(
    node: MindMapNode,
    level: Int,
    onToggleExpand: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bgColor = when (level) {
        0 -> MaterialTheme.colorScheme.primary
        1 -> Color(0xFFE3F2FD) // 莫兰迪蓝
        2 -> Color(0xFFE8F5E9) // 莫兰迪绿
        else -> Color.White
    }
    
    val textColor = if (level == 0) Color.White else Color.DarkGray
    val shadowElev = if (level == 0) 8.dp else 2.dp
    
    Card(
        modifier = modifier
            .shadow(shadowElev, RoundedCornerShape(12.dp))
            .clickable { onToggleExpand() }
            .border(
                width = 1.dp,
                color = if (level > 2) Color.LightGray else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = node.title,
                    color = textColor,
                    fontWeight = if (level <= 1) FontWeight.Bold else FontWeight.Normal,
                    fontSize = if (level == 0) 18.sp else 14.sp
                )
            }
            if (node.tags.isNotEmpty()) {
                Row(modifier = Modifier.padding(top = 4.dp)) {
                    node.tags.take(2).forEach { tag ->
                        Surface(
                            color = Color.Red.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier.padding(end = 4.dp)
                        ) {
                            Text(
                                text = tag,
                                color = Color.Red,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

// 绘制贝塞尔连接线
fun androidx.compose.ui.graphics.drawscope.DrawScope.drawConnections(
    node: MindMapNode,
    positions: Map<String, Offset>
) {
    val startPos = positions["${node.id}_right"] ?: return
    
    node.children.forEach { child ->
        val endPos = positions["${child.id}_left"] ?: return
        
        val path = Path().apply {
            moveTo(startPos.x, startPos.y)
            val control1 = Offset(startPos.x + (endPos.x - startPos.x) / 2, startPos.y)
            val control2 = Offset(startPos.x + (endPos.x - startPos.x) / 2, endPos.y)
            cubicTo(
                control1.x, control1.y,
                control2.x, control2.y,
                endPos.x, endPos.y
            )
        }
        
        drawPath(
            path = path,
            color = Color(0xFFBDBDBD),
            style = Stroke(width = 1.5f)
        )
        
        // 递归子节点
        drawConnections(child, positions)
    }
}

@Composable
fun EmptyStateView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.AutoAwesome,
            contentDescription = null,
            modifier = Modifier.size(64.dp).graphicsLayer { alpha = 0.3f },
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(16.dp))
        Text(
            "输入英语教学主题\nAI 瞬间生成结构化教案导图",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            lineHeight = 24.sp
        )
    }
}

@Composable
fun MagicButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(modifier = Modifier.padding(horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.AutoAwesome, null)
            Spacer(Modifier.width(12.dp))
            Text("魔法一键生成", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun InputCard(
    value: String,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(0.9f).padding(bottom = 16.dp),
        shape = RoundedCornerShape(28.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = { Text("如：初中英语定语从句知识点梳理") },
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                maxLines = 2
            )
            IconButton(
                onClick = onSend,
                modifier = Modifier.background(MaterialTheme.colorScheme.primary, CircleShape)
            ) {
                Icon(Icons.Default.AutoAwesome, contentDescription = "Send", tint = Color.White)
            }
        }
    }
}

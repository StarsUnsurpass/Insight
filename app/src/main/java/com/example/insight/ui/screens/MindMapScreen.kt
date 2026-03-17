package com.example.insight.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.state.UserPreferences
import java.util.UUID

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

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFF7F7F7))) {
        
        // --- The Native Infinite Canvas ---
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        scale *= zoom
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
                MindMapRenderer(rootNode!!)
            } else {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("输入主题，让 AI 开启你的思维导图", color = Color.Gray)
                }
            }
        }

        // --- Top Bar & Controls ---
        TopAppBar(
            title = { Text("AI 智能思维导图", style = MaterialTheme.typography.titleMedium) },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White.copy(alpha = 0.9f))
        )

        // --- AI Input Floating Bar ---
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(32.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isInputExpanded) {
                Card(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    shape = RoundedCornerShape(24.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = { Text("如：初中英语定语从句...") },
                            modifier = Modifier.weight(1f),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                        )
                        IconButton(onClick = { 
                            if (searchQuery.isNotBlank()) {
                                viewModel.generateMindMap(searchQuery, preferences.deepSeekApiKey)
                                isInputExpanded = false
                            }
                        }) {
                            Icon(Icons.Default.AutoAwesome, contentDescription = "Generate", tint = MaterialTheme.colorScheme.primary)
                        }
                    }
                }
            } else {
                FloatingActionButton(
                    onClick = { isInputExpanded = true },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White,
                    shape = CircleShape
                ) {
                    Row(modifier = Modifier.padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("魔法生成")
                    }
                }
            }
        }

        if (isGenerating) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter))
        }
    }
}

@Composable
fun MindMapRenderer(root: MindMapNode) {
    // 递归布局与渲染
    // 在生产环境中，这里应使用自定义 Layout 或通过 ViewModel 计算所有节点的坐标。
    // 这里展示如何使用 Canvas 画连线，以及手动布置节点。
    
    // 我们定义一些莫兰迪色系
    val colorPalette = listOf(
        Color(0xFFE8F5E9), // 浅绿
        Color(0xFFFFF3E0), // 浅橙
        Color(0xFFE3F2FD), // 浅蓝
        Color(0xFFF3E5F5)  // 浅紫
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        // 后续在这里画贝塞尔曲线
    }

    // 简单布局：根节点在中心，子节点水平分布
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        NodeComponent(root, 0, colorPalette[0])
    }
}

@Composable
fun NodeComponent(node: MindMapNode, level: Int, backgroundColor: Color) {
    // 这是一个示意组件。真正的布局需要根据深度递归计算偏移量。
    // Root -> 大、深色、圆角
    // Branch -> 中、浅色、带线
    // Leaf -> 简练
    
    Column(
        modifier = Modifier
            .background(
                if (level == 0) MaterialTheme.colorScheme.primary else backgroundColor,
                RoundedCornerShape(if (level == 0) 12.dp else 8.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = node.title,
                color = if (level == 0) Color.White else Color.Black,
                fontWeight = if (level == 0) FontWeight.Bold else FontWeight.Normal,
                fontSize = if (level == 0) 18.sp else 14.sp
            )
            if (node.tags.isNotEmpty()) {
                Spacer(Modifier.width(4.dp))
                Surface(
                    color = Color.Red.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        node.tags[0], 
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp),
                        fontSize = 10.sp, 
                        color = Color.Red
                    )
                }
            }
        }
    }
    
    // 递归绘制子节点（由于布局算法极其复杂，此处仅实现数据结构的映射逻辑）
}

// 贝塞尔连线辅助函数
fun drawBezierLine(path: Path, start: Offset, end: Offset) {
    path.moveTo(start.x, start.y)
    val controlPoint1 = Offset(start.x + (end.x - start.x) / 2, start.y)
    val controlPoint2 = Offset(start.x + (end.x - start.x) / 2, end.y)
    path.cubicTo(
        controlPoint1.x, controlPoint1.y,
        controlPoint2.x, controlPoint2.y,
        end.x, end.y
    )
}

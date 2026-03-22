package com.example.insight.graph

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.data.local.entities.KnowledgeNodeEntity
import com.example.insight.data.local.entities.KnowledgeEdgeEntity
import com.example.insight.data.local.entities.StudentMasteryEntity
import kotlin.math.*

/**
 * 高性能结构化知识图谱渲染组件
 */
@OptIn(ExperimentalTextApi::class)
@Composable
fun StarfieldComponent(
    nodes: List<KnowledgeNodeEntity>,
    edges: List<KnowledgeEdgeEntity>,
    mastery: List<StudentMasteryEntity>,
    onNodeClick: (KnowledgeNodeEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    val textMeasurer = rememberTextMeasurer()
    val haptic = LocalHapticFeedback.current
    
    val themePrimary = MaterialTheme.colorScheme.primary
    val themeError = MaterialTheme.colorScheme.error
    
    // Camera state
    var scale by remember { mutableFloatStateOf(0.8f) }
    var offset by remember { mutableStateOf(Offset(0f, 0f)) }
    
    // Interaction
    var focusedNodeId by remember { mutableStateOf<String?>(null) }
    var highlightedPathNodes by remember { mutableStateOf<Set<String>>(emptySet()) }
    
    // Pulse animation for mastery halo
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F1218))
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        scale = (scale * zoom).coerceIn(0.2f, 3f)
                        offset += pan
                    }
                }
                .pointerInput(Unit) {
                    detectTapGestures(onTap = { tapOffset ->
                        // Reverse transform tap to world coordinates
                        val worldTapX = (tapOffset.x - size.width / 2 - offset.x) / scale + 500f
                        val worldTapY = (tapOffset.y - size.height / 2 - offset.y) / scale + 500f
                        
                        val clicked = nodes.find { n ->
                            val dx = worldTapX - n.canvasX
                            val dy = worldTapY - n.canvasY
                            sqrt(dx * dx + dy * dy) < 60.dp.toPx() / scale
                        }
                        
                        if (clicked != null) {
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                            focusedNodeId = clicked.nodeId
                            // Calculate highlighted path (prerequisites)
                            highlightedPathNodes = findPrerequisites(clicked.nodeId, edges)
                            onNodeClick(clicked)
                        } else {
                            focusedNodeId = null
                            highlightedPathNodes = emptySet()
                        }
                    })
                }
        ) {
            val canvasCenter = Offset(size.width / 2, size.height / 2)
            
            withTransform({
                translate(canvasCenter.x + offset.x, canvasCenter.y + offset.y)
                scale(scale, scale, Offset(0f, 0f))
                translate(-500f, -500f) // Center around 500, 500 in world coordinates
            }) {
                // 1. Draw Edges (Layer 1)
                edges.forEach { edge ->
                    val from = nodes.find { it.nodeId == edge.sourceNodeId }
                    val to = nodes.find { it.nodeId == edge.targetNodeId }
                    
                    if (from != null && to != null) {
                        val isHighlighted = (focusedNodeId != null && 
                                           from.nodeId in highlightedPathNodes && 
                                           to.nodeId in highlightedPathNodes)
                        
                        val color = if (isHighlighted) themePrimary else Color.Gray.copy(alpha = 0.2f)
                        val strokeWidth = if (isHighlighted) 3.dp.toPx() else 1.dp.toPx()
                        
                        drawLine(
                            color = color,
                            start = Offset(from.canvasX, from.canvasY),
                            end = Offset(to.canvasX, to.canvasY),
                            strokeWidth = strokeWidth,
                            cap = StrokeCap.Round
                        )
                    }
                }

                // 2. Draw Nodes (Layer 2 & 3)
                nodes.forEach { node ->
                    // Viewport Culling logic could go here
                    
                    val nodeMastery = mastery.find { it.nodeId == node.nodeId }?.masteryScore ?: 60f
                    val masteryColor = when {
                        nodeMastery >= 85f -> Color(0xFF43A047)
                        nodeMastery >= 60f -> Color(0xFFFFB300)
                        else -> themeError
                    }
                    
                    val baseRadius = (30.dp + (node.importanceLevel * 4).dp).toPx()
                    val isFocused = focusedNodeId == node.nodeId
                    val isPath = node.nodeId in highlightedPathNodes
                    val alpha = if (focusedNodeId == null || isFocused || isPath) 1f else 0.3f

                    // Glow/Halo
                    if (nodeMastery < 60f) { // Warn for low mastery
                        drawCircle(
                            brush = Brush.radialGradient(
                                listOf(masteryColor.copy(alpha = 0.3f * pulseAlpha * alpha), Color.Transparent),
                                center = Offset(node.canvasX, node.canvasY),
                                radius = baseRadius * 2.5f
                            ),
                            center = Offset(node.canvasX, node.canvasY),
                            radius = baseRadius * 2.5f
                        )
                    }

                    // Node Core
                    drawCircle(
                        color = masteryColor.copy(alpha = alpha),
                        center = Offset(node.canvasX, node.canvasY),
                        radius = baseRadius
                    )
                    
                    // Border for focused node
                    if (isFocused) {
                        drawCircle(
                            color = Color.White.copy(alpha = alpha),
                            center = Offset(node.canvasX, node.canvasY),
                            radius = baseRadius + 4.dp.toPx(),
                            style = Stroke(width = 2.dp.toPx())
                        )
                    }

                    // Label
                    if (scale > 0.4f) {
                        val textResult = textMeasurer.measure(
                            text = AnnotatedString(node.title),
                            style = TextStyle(
                                color = Color.White.copy(alpha = alpha),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                shadow = Shadow(Color.Black, blurRadius = 4f)
                            )
                        )
                        drawText(
                            textLayoutResult = textResult,
                            topLeft = Offset(
                                node.canvasX - textResult.size.width / 2,
                                node.canvasY + baseRadius + 8.dp.toPx()
                            )
                        )
                    }
                }
            }
        }

        // Floating Controls
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FloatingActionButton(
                onClick = { scale = 0.8f; offset = Offset.Zero; focusedNodeId = null; highlightedPathNodes = emptySet() },
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
                contentColor = themePrimary,
                shape = CircleShape
            ) { Icon(Icons.Default.MyLocation, "Recenter") }
        }
        
        // AI Diagnostic Insight
        AnimatedVisibility(
            visible = focusedNodeId != null,
            enter = slideInVertically { it } + fadeIn(),
            exit = slideOutVertically { it } + fadeOut(),
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 80.dp)
        ) {
            val node = nodes.find { it.nodeId == focusedNodeId }
            val m = mastery.find { it.nodeId == focusedNodeId }?.masteryScore ?: 60f
            
            Surface(
                color = Color.Black.copy(alpha = 0.8f),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, if (m < 60f) themeError.copy(alpha = 0.5f) else themePrimary.copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (m < 60f) Icons.Default.AutoAwesome else Icons.Default.AutoAwesome, 
                        null, 
                        tint = if (m < 60f) themeError else themePrimary, 
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        text = if (m < 60f) "诊断：检测到「${node?.title}」前置知识薄弱，请回溯练习" else "状态：已构建「${node?.title}」认知闭环",
                        color = Color.White,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

/**
 * 查找节点的所有前置依赖路径上的节点（简单递归版，适用于小规模图）
 */
private fun findPrerequisites(nodeId: String, edges: List<KnowledgeEdgeEntity>): Set<String> {
    val result = mutableSetOf(nodeId)
    val queue = mutableListOf(nodeId)
    
    while (queue.isNotEmpty()) {
        val current = queue.removeAt(0)
        edges.filter { it.targetNodeId == current && it.relationType == "PREREQUISITE" }
            .forEach { edge ->
                if (result.add(edge.sourceNodeId)) {
                    queue.add(edge.sourceNodeId)
                }
            }
    }
    return result
}

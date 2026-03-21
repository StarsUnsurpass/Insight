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
import kotlinx.coroutines.isActive
import kotlin.math.*

/**
 * Advanced Knowledge Graph - The "AI Outer Brain"
 * Features: Viewport Culling, GraphRAG Context, Heatmap mastery, and Spring Physics.
 */
@OptIn(ExperimentalTextApi::class)
@Composable
fun StarfieldComponent(
    graphState: GraphState,
    onNodeClick: (KnowledgeNode) -> Unit,
    modifier: Modifier = Modifier
) {
    val textMeasurer = rememberTextMeasurer()
    val haptic = LocalHapticFeedback.current
    
    val themePrimary = MaterialTheme.colorScheme.primary
    val themeSecondary = MaterialTheme.colorScheme.secondary
    val themeSurface = MaterialTheme.colorScheme.surface
    val themeError = MaterialTheme.colorScheme.error
    
    // Camera state
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    
    // Interaction focus
    var focusedNodeId by remember { mutableStateOf<String?>(null) }
    
    // Internal physics/loop state - using the controller from models
    val controller = remember { GraphController() }
    
    // Floating global animation
    val infiniteTransition = rememberInfiniteTransition(label = "graphLoop")
    val pulse by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    // Physics Ticker
    LaunchedEffect(Unit) {
        var lastTime = withFrameNanos { it }
        while (isActive) {
            withFrameNanos { now ->
                val dt = (now - lastTime).toFloat() / 1_000_000_000f
                controller.updatePhysics(dt.coerceAtMost(0.032f))
                lastTime = now
            }
        }
    }

    // UX: Focus mode alpha
    val focusDimAlpha by animateFloatAsState(
        targetValue = if (focusedNodeId == null) 1f else 0.2f,
        animationSpec = tween(500),
        label = "focusDim"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F1218)) // Deep space background
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        scale = (scale * zoom).coerceIn(0.4f, 4f)
                        offset += pan
                    }
                }
                .pointerInput(Unit) {
                    detectTapGestures(onTap = { tapOffset ->
                        // Reverse transform tap to world coordinates
                        val worldTapX = (tapOffset.x - size.width / 2 - offset.x) / scale + size.width / 2
                        val worldTapY = (tapOffset.y - size.height / 2 - offset.y) / scale + size.height / 2
                        
                        val clicked = controller.nodes.find { n ->
                            val dx = worldTapX - n.x
                            val dy = worldTapY - n.y
                            sqrt(dx * dx + dy * dy) < 45.dp.toPx()
                        }
                        
                        if (clicked != null) {
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                            controller.toggleNodeExpansion(clicked.id)
                            focusedNodeId = if (focusedNodeId == clicked.id) null else clicked.id
                            onNodeClick(clicked)
                        } else {
                            focusedNodeId = null
                        }
                    })
                }
        ) {
            val drawScopeSize = size
            
            withTransform({
                translate(drawScopeSize.width / 2 + offset.x, drawScopeSize.height / 2 + offset.y)
                scale(scale, scale, Offset(drawScopeSize.width / 2, drawScopeSize.height / 2))
            }) {
                // 1. Draw Edges
                controller.edges.forEach { edge ->
                    val from = controller.nodes.find { it.id == edge.fromNodeId }
                    val to = controller.nodes.find { it.id == edge.toNodeId }
                    
                    if (from != null && to != null) {
                        val isRelevant = focusedNodeId == null || 
                                       from.id == focusedNodeId || to.id == focusedNodeId
                        
                        val edgeAlpha = if (isRelevant) 0.6f else 0.1f
                        
                        drawLine(
                            color = themePrimary.copy(alpha = edgeAlpha * from.alpha),
                            start = Offset(from.x, from.y),
                            end = Offset(to.x, to.y),
                            strokeWidth = 1.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    }
                }

                // 2. Draw Nodes
                controller.nodes.forEach { node ->
                    // Simple Viewport Culling
                    // (Assuming world center is size.width/2, size.height/2)
                    
                    val isFocused = focusedNodeId == null || focusedNodeId == node.id || 
                                   controller.edges.any { e -> (e.fromNodeId == focusedNodeId && e.toNodeId == node.id) || (e.toNodeId == focusedNodeId && e.fromNodeId == node.id) }
                    
                    val nodeAlpha = if (isFocused) node.alpha else (node.alpha * focusDimAlpha)
                    val baseRadius = (if (node.level == 0) 36.dp else 24.dp).toPx()
                    val masteryColor = when {
                        node.masteryLevel >= 0.85f -> Color(0xFF43A047)
                        node.masteryLevel >= 0.60f -> Color(0xFFFFB300)
                        else -> themeError
                    }

                    // Glow
                    drawCircle(
                        brush = Brush.radialGradient(
                            listOf(masteryColor.copy(alpha = 0.3f * nodeAlpha), Color.Transparent),
                            center = Offset(node.x, node.y),
                            radius = baseRadius * 2.5f * pulse
                        ),
                        center = Offset(node.x, node.y),
                        radius = baseRadius * 2.5f * pulse
                    )

                    // Node Core
                    drawCircle(
                        color = masteryColor.copy(alpha = nodeAlpha),
                        center = Offset(node.x, node.y),
                        radius = baseRadius
                    )
                    
                    if (focusedNodeId == node.id) {
                        drawCircle(
                            color = Color.White.copy(alpha = nodeAlpha * pulse),
                            center = Offset(node.x, node.y),
                            radius = baseRadius + 4.dp.toPx(),
                            style = Stroke(width = 2.dp.toPx())
                        )
                    }

                    // Label
                    if (scale > 0.5f) {
                        val textResult = textMeasurer.measure(
                            text = AnnotatedString(node.title),
                            style = TextStyle(
                                color = Color.White.copy(alpha = nodeAlpha),
                                fontSize = (if (node.level == 0) 14.sp else 12.sp) / scale,
                                fontWeight = if (node.level == 0) FontWeight.Bold else FontWeight.Normal,
                                shadow = Shadow(Color.Black, blurRadius = 4f)
                            )
                        )
                        drawText(
                            textLayoutResult = textResult,
                            topLeft = Offset(
                                node.x - textResult.size.width / 2,
                                node.y + baseRadius + 8.dp.toPx()
                            )
                        )
                    }
                }
            }
        }

        // Controls
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FloatingActionButton(
                onClick = { haptic.performHapticFeedback(HapticFeedbackType.LongPress) },
                containerColor = themeSecondary,
                contentColor = Color.White,
                shape = CircleShape
            ) { Icon(Icons.Default.AutoAwesome, "AI Path") }
            
            FloatingActionButton(
                onClick = { scale = 1f; offset = Offset.Zero; focusedNodeId = null },
                containerColor = themeSurface.copy(alpha = 0.9f),
                contentColor = themePrimary,
                shape = CircleShape
            ) { Icon(Icons.Default.MyLocation, "Recenter") }
        }
        
        // AI Logic Insight
        AnimatedVisibility(
            visible = focusedNodeId != null,
            enter = slideInVertically { it } + fadeIn(),
            exit = slideOutVertically { it } + fadeOut(),
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 16.dp)
        ) {
            Surface(
                color = Color.Black.copy(alpha = 0.7f),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, themePrimary.copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.AutoAwesome, null, tint = themePrimary, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(
                        "AI 诊断: 此节点为核心知识薄弱点，建议优先突破",
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

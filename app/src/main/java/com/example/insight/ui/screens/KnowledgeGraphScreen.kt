package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.TipsAndUpdates
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.state.UserPreferences
import com.example.insight.ui.state.UserRole
import com.example.insight.ui.theme.*
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.scale as drawScale
import androidx.compose.ui.draw.alpha

@Suppress("UNUSED_PARAMETER")
@Composable
fun KnowledgeGraphScreen(preferences: UserPreferences) {
    val controller = remember { com.example.insight.graph.GraphController() }
    
    // Viewport transform states
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    // State to trigger recomposition only for drawing (less recompositions for structure)
    var tick by remember { mutableStateOf(0L) }

    val haptic = androidx.compose.ui.platform.LocalHapticFeedback.current

    // Physics Loop
    LaunchedEffect(Unit) {
        var lastFrame = 0L
        while (true) {
            withFrameNanos { time ->
                if (lastFrame != 0L) {
                    val dt = (time - lastFrame) / 1_000_000_000f
                    controller.updatePhysics(minOf(dt, 0.03f))
                    tick = time // force Canvas redraw
                }
                lastFrame = time
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    scale = (scale * zoom).coerceIn(0.2f, 3f)
                    // damping when panning out of bounds could be added here
                    offset += pan
                }
            }
            .pointerInput(Unit) {
                val currentSize = size
                detectTapGestures(
                    onTap = { tapOffset ->
                        // Transform tap to canvas coordinates
                        val canvasX = (tapOffset.x - offset.x - currentSize.width / 2f) / scale
                        val canvasY = (tapOffset.y - offset.y - currentSize.height / 2f) / scale
                        
                        // Hit test nodes (reverse z-order)
                        val hitNode = controller.nodes.lastOrNull { node ->
                            val r = 40f // node base radius
                            val dist = kotlin.math.hypot(node.x - canvasX, node.y - canvasY)
                            dist <= r
                        }
                        
                        if (hitNode != null) {
                            haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.LongPress)
                            controller.toggleNodeExpansion(hitNode.id)
                        } else {
                            // tapped empty space
                            controller.focusedNodeId = null
                            controller.nodes.forEach { it.targetAlpha = 1f }
                            controller.edges.forEach { it.alpha = 1f }
                        }
                    }
                )
            }
    ) {
        // Read tick to trigger redraw on animation frame
        tick.hashCode()

        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2f, size.height / 2f)
            
            // Viewport Culling Bounds (expanded slightly to avoid clipping)
            val leftBound = -offset.x / scale - center.x / scale - 100f
            val rightBound = (size.width - offset.x) / scale - center.x / scale + 100f
            val topBound = -offset.y / scale - center.y / scale - 100f
            val bottomBound = (size.height - offset.y) / scale - center.y / scale + 100f

            translate(offset.x + center.x, offset.y + center.y) {
                drawScale(scale, scale) {
                    // Draw Edges
                    controller.edges.forEach { edge ->
                        val from = controller.nodes.find { it.id == edge.fromNodeId }
                        val to = controller.nodes.find { it.id == edge.toNodeId }
                        if (from != null && to != null) {
                            // Viewport Culling for Edges
                            val minX = minOf(from.x, to.x)
                            val maxX = maxOf(from.x, to.x)
                            val minY = minOf(from.y, to.y)
                            val maxY = maxOf(from.y, to.y)
                            
                            if (maxX >= leftBound && minX <= rightBound && maxY >= topBound && minY <= bottomBound) {
                                val currentAlpha = edge.alpha.coerceIn(0f, 1f)
                                if (currentAlpha > 0.01f) {
                                    drawLine(
                                        color = SageGreen.copy(alpha = 0.3f * currentAlpha),
                                        start = Offset(from.x, from.y),
                                        end = Offset(to.x, to.y),
                                        strokeWidth = 2.dp.toPx()
                                    )
                                }
                            }
                        }
                    }

                    // Draw Nodes
                    controller.nodes.forEach { node ->
                        // Viewport Culling for Nodes
                        if (node.x >= leftBound && node.x <= rightBound && node.y >= topBound && node.y <= bottomBound) {
                            val alpha = node.alpha.coerceIn(0f, 1f)
                            if (alpha > 0.01f) {
                                // Color based on mastery
                                val nodeColor = when {
                                    node.masteryLevel >= 0.8f -> SageGreen
                                    node.masteryLevel >= 0.6f -> Color(0xFFFFB74D) // Amber
                                    else -> Color(0xFFE57373) // Red
                                }
                                
                                val baseRadius = if (node.level == 0) 40f else 30f - (node.level * 5f)
                                
                                // Glow ring for expanded root nodes
                                if (node.isExpanded) {
                                    drawCircle(
                                        color = nodeColor.copy(alpha = 0.2f * alpha),
                                        radius = baseRadius * 1.5f,
                                        center = Offset(node.x, node.y)
                                    )
                                }

                                drawCircle(
                                    color = nodeColor.copy(alpha = alpha),
                                    radius = baseRadius,
                                    center = Offset(node.x, node.y)
                                )
                                
                                // Node border
                                drawCircle(
                                    color = Color.White.copy(alpha = 0.8f * alpha),
                                    radius = baseRadius,
                                    center = Offset(node.x, node.y),
                                    style = androidx.compose.ui.graphics.drawscope.Stroke(width = 2.dp.toPx())
                                )

                                // Expansion Icon (+ for not expanded, - for expanded)
                                if (node.level < 2) { // Only show for higher levels as leaves don't expand much
                                    val iconSize = baseRadius * 0.5f
                                    val strokeWidth = 1.5.dp.toPx()
                                    // Draw Horizontal Line (for both + and -)
                                    drawLine(
                                        color = Color.White.copy(alpha = alpha),
                                        start = Offset(node.x - iconSize/2f, node.y),
                                        end = Offset(node.x + iconSize/2f, node.y),
                                        strokeWidth = strokeWidth
                                    )
                                    // Draw Vertical Line (only for +)
                                    if (!node.isExpanded) {
                                        drawLine(
                                            color = Color.White.copy(alpha = alpha),
                                            start = Offset(node.x, node.y - iconSize/2f),
                                            end = Offset(node.x, node.y + iconSize/2f),
                                            strokeWidth = strokeWidth
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // We draw text as separate composables in a layout to get good typography,
        // Using graphicsLayer so we don't trigger huge recompositions when panning.
        // We only show text for nodes within viewport and alpha > 0.2 to save rendering.
        // We only show text for nodes within viewport and alpha > 0.2 to save rendering.
        
        // Let's use BoxWithConstraints for node text overlays
        BoxWithConstraints(modifier = Modifier.fillMaxSize().alpha(0.99f)) { // alpha 0.99 bounds the layer
            val cx = constraints.maxWidth / 2f
            val cy = constraints.maxHeight / 2f
            
            controller.nodes.forEach { node ->
                val alpha = node.alpha.coerceIn(0f, 1f)
                if (alpha > 0.15f) { // only render text for visible nodes
                    Text(
                        text = node.title,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .graphicsLayer {
                                this.alpha = alpha
                                this.scaleX = scale
                                this.scaleY = scale
                                this.translationX = cx + offset.x + node.x * scale - 20f * scale // approx center
                                this.translationY = cy + offset.y + node.y * scale + (if (node.level == 0) 45f else 35f) * scale
                            }
                            // background pill for readability
                            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f * alpha), RoundedCornerShape(4.dp))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                }
            }
        }
        
        // Floating Controls / Legends
        Column(modifier = Modifier.align(Alignment.TopStart).padding(top = 16.dp, start = 20.dp, end = 20.dp)) {
            Text("知识图谱", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text("点击节点进行认知链路追踪", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(10.dp).background(SageGreen, CircleShape))
                Spacer(modifier = Modifier.width(6.dp))
                Text("掌握优秀", style = MaterialTheme.typography.labelSmall)
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier.size(10.dp).background(Color(0xFFFFB74D), CircleShape))
                Spacer(modifier = Modifier.width(6.dp))
                Text("需巩固", style = MaterialTheme.typography.labelSmall)
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier.size(10.dp).background(Color(0xFFE57373), CircleShape))
                Spacer(modifier = Modifier.width(6.dp))
                Text("薄弱环节", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

package com.example.insight.graph

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.theme.AetherTeal
import com.example.insight.ui.theme.LunarFrost
import com.example.insight.ui.theme.OrchidMist
import kotlin.math.sin

@OptIn(ExperimentalTextApi::class)
@Composable
fun StarfieldComponent(
    graphState: GraphState,
    modifier: Modifier = Modifier
) {
    val textMeasurer = rememberTextMeasurer()
    
    // Physics-ish state for nodes
    val nodeOffsets = remember { 
        mutableStateMapOf<String, Offset>().apply {
            graphState.nodes.forEach { put(it.id, it.initialOffset) }
        }
    }

    // Animation for breathing/shimmering
    val infiniteTransition = rememberInfiniteTransition(label = "starfield")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    // Simple global offset/drag, in a real app we'd map to specific nodes
                    nodeOffsets.keys.forEach { id ->
                        nodeOffsets[id] = nodeOffsets[id]!! + Offset(dragAmount.x / size.width, dragAmount.y / size.height)
                    }
                }
            }
    ) {
        val width = size.width
        val height = size.height

        // 1. Draw Edges (Threads)
        graphState.edges.forEach { edge ->
            val startNode = nodeOffsets[edge.fromId] ?: return@forEach
            val endNode = nodeOffsets[edge.toId] ?: return@forEach
            
            val startPx = Offset(startNode.x * width, startNode.y * height)
            val endPx = Offset(endNode.x * width, endNode.y * height)

            drawLine(
                brush = Brush.linearGradient(
                    colors = listOf(AetherTeal.copy(alpha = 0.3f), OrchidMist.copy(alpha = 0.3f))
                ),
                start = startPx,
                end = endPx,
                strokeWidth = 1.dp.toPx()
            )
        }

        // 2. Draw Nodes
        graphState.nodes.forEach { node ->
            val offset = nodeOffsets[node.id] ?: return@forEach
            val centerPx = Offset(offset.x * width, offset.y * height)
            val baseRadius = 12.dp.toPx() * node.weight
            
            // Glow Effect
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        (if (node.type == NodeType.CENTER) AetherTeal else OrchidMist).copy(alpha = 0.4f * pulseScale),
                        Color.Transparent
                    ),
                    center = centerPx,
                    radius = baseRadius * 3
                ),
                center = centerPx,
                radius = baseRadius * 3
            )

            // Core Sphere
            drawCircle(
                color = if (node.type == NodeType.CENTER) AetherTeal else LunarFrost,
                center = centerPx,
                radius = baseRadius
            )

            // Label
            val textLayoutResult = textMeasurer.measure(
                text = AnnotatedString(node.label),
                style = TextStyle(
                    color = LunarFrost,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            
            drawText(
                textLayoutResult = textLayoutResult,
                topLeft = Offset(
                    centerPx.x - textLayoutResult.size.width / 2,
                    centerPx.y + baseRadius + 4.dp.toPx()
                )
            )
        }
    }
}

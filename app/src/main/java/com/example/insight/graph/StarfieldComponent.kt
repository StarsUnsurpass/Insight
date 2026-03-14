package com.example.insight.graph

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import com.example.insight.ui.theme.SageGreen
import com.example.insight.ui.theme.HighlightYellow
import com.example.insight.ui.theme.SoftShadow

@OptIn(androidx.compose.ui.text.ExperimentalTextApi::class)
@Composable
fun StarfieldComponent(
    graphState: GraphState,
    modifier: Modifier = Modifier
) {
    val textMeasurer = rememberTextMeasurer()
    
    // Move theme color resolution OUTSIDE the Canvas lambda
    val themePrimary = MaterialTheme.colorScheme.primary
    val themeOnSurface = MaterialTheme.colorScheme.onSurface

    // Physics-ish state for nodes
    val nodeOffsets = remember { 
        mutableStateMapOf<String, Offset>().apply {
            graphState.nodes.forEach { put(it.id, it.initialOffset) }
        }
    }

    // Animation for breathing/shimmering
    val infiniteTransition = rememberInfiniteTransition(label = "conceptMap")
    val floatOffset by infiniteTransition.animateFloat(
        initialValue = -5f,
        targetValue = 5f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "floating"
    )

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    nodeOffsets.keys.forEach { id ->
                        nodeOffsets[id] = nodeOffsets[id]!! + Offset(dragAmount.x / size.width, dragAmount.y / size.height)
                    }
                }
            }
    ) {
        val width = size.width
        val height = size.height

        // 1. Draw Edges
        graphState.edges.forEach { edge ->
            val startNode = nodeOffsets[edge.fromId] ?: return@forEach
            val endNode = nodeOffsets[edge.toId] ?: return@forEach
            
            val startPx = Offset(startNode.x * width, startNode.y * height)
            val endPx = Offset(endNode.x * width, endNode.y * height)

            drawLine(
                color = SageGreen.copy(alpha = 0.2f),
                start = startPx,
                end = endPx,
                strokeWidth = 2.dp.toPx(),
                cap = androidx.compose.ui.graphics.StrokeCap.Round
            )
        }

        // 2. Draw Nodes
        graphState.nodes.forEach { node ->
            val offset = nodeOffsets[node.id] ?: return@forEach
            val centerPx = Offset(offset.x * width, (offset.y * height) + floatOffset)
            val baseRadius = 8.dp.toPx() * node.weight
            
            // Soft Shadow/Glow
            drawCircle(
                color = SoftShadow,
                center = centerPx + Offset(2.dp.toPx(), 2.dp.toPx()),
                radius = baseRadius + 4.dp.toPx()
            )

            // Core Node - Use the pre-resolved themePrimary
            val nodeColor = when(node.type) {
                NodeType.CENTER -> themePrimary
                NodeType.PREREQUISITE -> HighlightYellow
                else -> SageGreen
            }

            drawCircle(
                color = nodeColor,
                center = centerPx,
                radius = baseRadius
            )

            // Label - Use the pre-resolved themeOnSurface
            val textLayoutResult = textMeasurer.measure(
                text = AnnotatedString(node.label),
                style = TextStyle(
                    color = themeOnSurface,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            
            val textTopLeft = Offset(
                centerPx.x - textLayoutResult.size.width / 2,
                centerPx.y + baseRadius + 6.dp.toPx()
            )
            
            drawText(
                textLayoutResult = textLayoutResult,
                topLeft = textTopLeft
            )
        }
    }
}

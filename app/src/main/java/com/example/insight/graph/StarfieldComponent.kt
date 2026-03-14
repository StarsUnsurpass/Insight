package com.example.insight.graph

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.math.sqrt

@OptIn(ExperimentalTextApi::class)
@Composable
fun StarfieldComponent(
    graphState: GraphState,
    onNodeClick: (KnowledgeNode) -> Unit,
    modifier: Modifier = Modifier
) {
    val textMeasurer = rememberTextMeasurer()
    val scope = rememberCoroutineScope()
    
    val themePrimary = MaterialTheme.colorScheme.primary
    val themeOnBackground = MaterialTheme.colorScheme.onBackground
    val themeSurface = MaterialTheme.colorScheme.surface
    
    // Camera Transform State
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    // Floating animation
    val infiniteTransition = rememberInfiniteTransition(label = "conceptMap")
    val floatOffset by infiniteTransition.animateFloat(
        initialValue = -8f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "floating"
    )

    // Staggered enter animation
    val enterAnim = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        enterAnim.animateTo(1f, animationSpec = tween(1500, easing = LinearOutSlowInEasing))
    }

    Box(modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        val newScale = (scale * zoom).coerceIn(0.5f, 3f)
                        // Adjust offset to zoom around the center point, but keep it simple for now
                        scale = newScale
                        offset += pan
                    }
                }
                .pointerInput(Unit) {
                    detectTapGestures { tapOffset ->
                        // Reverse transform to find clicked node
                        val transformedX = (tapOffset.x - offset.x) / scale
                        val transformedY = (tapOffset.y - offset.y) / scale
                        
                        // Find nearest node within radius
                        val clickedNode = graphState.nodes.find { node ->
                            val dx = node.x - transformedX
                            val dy = node.y - transformedY
                            val distance = sqrt((dx * dx + dy * dy).toDouble())
                            distance < 40f // click radius
                        }
                        if (clickedNode != null) {
                            onNodeClick(clickedNode)
                        }
                    }
                }
        ) {
            // Apply Camera Transform
            withTransform({
                translate(left = offset.x, top = offset.y)
                scale(scaleX = scale, scaleY = scale, pivot = Offset.Zero)
            }) {
                // 1. Draw Edges with Bezier curves
                graphState.edges.forEach { edge ->
                    val fromNode = graphState.nodes.find { it.id == edge.fromNodeId }
                    val toNode = graphState.nodes.find { it.id == edge.toNodeId }
                    
                    if (fromNode != null && toNode != null) {
                        val path = Path().apply {
                            moveTo(fromNode.x, fromNode.y)
                            // Smooth Bezier Curve (control points halfway)
                            val cp1x = fromNode.x
                            val cp1y = fromNode.y + (toNode.y - fromNode.y) / 2
                            val cp2x = toNode.x
                            val cp2y = fromNode.y + (toNode.y - fromNode.y) / 2
                            cubicTo(cp1x, cp1y, cp2x, cp2y, toNode.x, toNode.y)
                        }
                        
                        // Animate line drawing based on staggered enterAnim
                        drawPath(
                            path = path,
                            color = themePrimary.copy(alpha = 0.2f * enterAnim.value),
                            style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
                        )
                        
                        // Draw flow logic if both mastered
                        if (fromNode.masteryLevel > 0.8f && toNode.masteryLevel > 0.8f) {
                            drawPath(
                                path = path,
                                color = themePrimary.copy(alpha = 0.5f * enterAnim.value),
                                style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
                            )
                        }
                    }
                }

                // 2. Draw Nodes
                graphState.nodes.forEachIndexed { index, node ->
                    // Staggered effect: nodes further down the list appear slightly later
                    val nodeEnterProgress = (enterAnim.value * 2f - (index * 0.1f)).coerceIn(0f, 1f)
                    if (nodeEnterProgress > 0f) {
                        val nodeColor = if (node.masteryLevel > 0.8f) {
                            Color(0xFF81C784) // Mastery Green
                        } else if (node.masteryLevel < 0.4f) {
                            Color(0xFFE57373) // Warning Red/Amber
                        } else {
                            themePrimary // Learning primary
                        }
                        
                        val centerPx = Offset(node.x, node.y + floatOffset)
                        val radius = 24.dp.toPx() * nodeEnterProgress

                        // Glow effect for struggling nodes
                        if (node.masteryLevel < 0.4f) {
                            drawCircle(
                                color = nodeColor.copy(alpha = 0.3f),
                                center = centerPx,
                                radius = radius + (8.dp.toPx() * (1f + (floatOffset/8f)))
                            )
                        } else if (node.masteryLevel > 0.8f) {
                             drawCircle(
                                color = nodeColor.copy(alpha = 0.2f),
                                center = centerPx,
                                radius = radius + 4.dp.toPx()
                            )
                        }

                        drawCircle(
                            color = nodeColor,
                            center = centerPx,
                            radius = radius
                        )

                        // Draw Text Label
                        val textLayoutResult = textMeasurer.measure(
                            text = AnnotatedString(node.title),
                            style = TextStyle(
                                color = themeOnBackground.copy(alpha = nodeEnterProgress),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        
                        drawText(
                            textLayoutResult = textLayoutResult,
                            topLeft = Offset(
                                centerPx.x - textLayoutResult.size.width / 2,
                                centerPx.y + radius + 8.dp.toPx()
                            )
                        )
                    }
                }
            }
        }

        // HUD: Recenter Button
        Surface(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
                .size(48.dp),
            shape = CircleShape,
            color = themeSurface,
            shadowElevation = 8.dp,
            onClick = {
                // Reset camera with animation
                scope.launch {
                    scale = 1f
                    offset = Offset.Zero
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.MyLocation,
                contentDescription = "Recenter",
                modifier = Modifier.padding(12.dp),
                tint = themePrimary
            )
        }
    }
}

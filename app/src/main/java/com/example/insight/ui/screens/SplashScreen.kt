package com.example.insight.ui.screens

import android.graphics.PathMeasure
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs

fun buildDynamicInsightPath(bend: Float): Path {
    val p = Path()
    // fly up from ground bounce
    p.moveTo(-10f, 0f)
    val topX = 10f + bend
    val topY = -50f + abs(bend) * 0.2f
    p.cubicTo(-5f, -30f, topX - 5f, topY, topX, topY)
    
    // 'ı' stem (the first 'i' without dot)
    p.quadraticBezierTo(10f + bend * 1.5f, topY / 2f, 10f, 0f)
    
    // 'n'
    p.cubicTo(10f, -40f, 25f, -40f, 25f, -10f)
    p.lineTo(25f, 0f)
    p.cubicTo(25f, -40f, 40f, -40f, 40f, -10f)
    p.lineTo(40f, 0f)
    
    // 's'
    p.cubicTo(45f, 0f, 50f, -30f, 55f, -30f) 
    p.cubicTo(65f, -30f, 60f, 0f, 50f, 0f)   
    p.cubicTo(45f, 0f, 45f, -10f, 55f, -15f) 
    p.cubicTo(65f, -20f, 70f, -20f, 75f, -40f) 
    
    // 'ı' (2nd i, no dot yet)
    p.lineTo(75f, 0f) 
    p.cubicTo(80f, 0f, 85f, -10f, 90f, -35f) 
    
    // 'g'
    p.cubicTo(80f, -40f, 80f, 0f, 90f, 0f) 
    p.cubicTo(100f, 0f, 100f, -40f, 90f, -40f) 
    p.lineTo(90f, 40f) // descender
    p.cubicTo(80f, 50f, 70f, 30f, 80f, 15f) 
    p.cubicTo(90f, 0f, 100f, -30f, 110f, -100f) // sweep up
    
    // 'h'
    p.lineTo(110f, 0f) 
    p.cubicTo(110f, -40f, 130f, -40f, 130f, -10f) 
    p.lineTo(130f, 0f) 
    p.cubicTo(135f, 0f, 140f, -10f, 145f, -80f) 
    
    // 't'
    p.lineTo(145f, 0f) 
    p.cubicTo(150f, 0f, 155f, -5f, 160f, -15f) 
    
    return p
}

@Composable
fun SplashScreen(onAnimationFinished: () -> Unit) {
    val haptic = LocalHapticFeedback.current
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    
    val screenWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }
    
    // --- ANIMATION STATES ---
    
    // Phase 1: Dot 1 Drop
    val dot1Drop = remember { Animatable(0f) } 
    val dot1ScaleX = remember { Animatable(1f) }
    val dot1ScaleY = remember { Animatable(1f) }
    
    // Phase 2: Trace
    val traceProgress = remember { Animatable(0f) }
    val dot1Alpha = remember { Animatable(1f) }
    
    // Phase 3 & 4: Dot 2 Impact
    val dot2Drop = remember { Animatable(0f) } 
    val dot2Alpha = remember { Animatable(0f) }
    val stemBendOffset = remember { Animatable(0f) }
    val dot2BounceOffset = remember { Animatable(0f) }
    
    // Phase 5: Final details and Glow
    val finalDetailsAlpha = remember { Animatable(0f) }
    val glowProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        // ACT 1: Drop
        launch {
            delay(100)
            dot1ScaleY.animateTo(2.2f, tween(300))
            dot1ScaleX.animateTo(0.4f, tween(300))
        }
        dot1Drop.animateTo(1f, tween(700, easing = CubicBezierEasing(0.4f, 0f, 1f, 1f)))
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        
        // Squash & Stretch
        launch {
            dot1ScaleY.animateTo(0.2f, tween(100, easing = FastOutSlowInEasing))
            dot1ScaleY.animateTo(1f, spring(dampingRatio = 0.45f, stiffness = 300f))
        }
        launch {
            dot1ScaleX.animateTo(2.5f, tween(100, easing = FastOutSlowInEasing))
            dot1ScaleX.animateTo(1f, spring(dampingRatio = 0.45f, stiffness = 300f))
        }
        delay(200) 
        
        // ACT 2: Trace "insight" 
        // Elegant, slow handwriting pace (3.2 seconds)
        traceProgress.animateTo(1f, tween(3200, easing = CubicBezierEasing(0.3f, 0f, 0.7f, 1f)))
        
        // Fade out writing dot
        dot1Alpha.animateTo(0f, tween(200))
        delay(300)
        
        // ACT 3: Second Dot Drops on the first 'ı'
        dot2Alpha.snapTo(1f)
        dot2Drop.animateTo(1f, tween(500, easing = CubicBezierEasing(0.5f, 0f, 1f, 1f)))
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        
        // ACT 4: Impact and Bending Physics
        launch {
            stemBendOffset.snapTo(14f) // max right bend 
            stemBendOffset.animateTo(0f, spring(dampingRatio = 0.25f, stiffness = 120f)) // High bouncy, low stiffness
        }
        launch {
            dot2BounceOffset.snapTo(10f) // pushed down
            dot2BounceOffset.animateTo(0f, spring(dampingRatio = 0.35f, stiffness = 180f)) // Slight phase difference
        }
        
        // Reveal 2nd 'i' dot and 't' crossbar naturally
        finalDetailsAlpha.animateTo(1f, tween(500))
        
        delay(1400) // wait for physics to settle
        
        // ACT 5: Glow effect across the word
        glowProgress.animateTo(1f, tween(900, easing = FastOutSlowInEasing))
        delay(200)
        
        onAnimationFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val pathScale = screenWidthPx / 200f
            val startX = (screenWidthPx - 160f * pathScale) / 2f
            val baseY = screenHeightPx / 2f + 20f * pathScale
            
            // Build the dynamic path (it bends if stemBendOffset > 0)
            val dynamicPath = buildDynamicInsightPath(stemBendOffset.value)
            val pathMeasure = PathMeasure(dynamicPath.asAndroidPath(), false)
            val totalLength = pathMeasure.length
            val currentTraceLen = totalLength * traceProgress.value
            
            val trailPath = android.graphics.Path()
            pathMeasure.getSegment(0f, currentTraceLen, trailPath, true)
            
            // Colors
            val strokeColor = Color(0xFF1A2980) // Deep Blue base
            val glowColor = Color(0xFF26D0CE) // Mint Green glow
            
            val dotBrush = Brush.radialGradient(
                colors = listOf(glowColor, strokeColor),
                center = Offset.Zero,
                radius = 4f * pathScale
            )

            withTransform({
                translate(startX, baseY)
                scale(pathScale, pathScale, pivot = Offset.Zero)
            }) {
                // Outer subtle glow
                drawPath(
                    path = trailPath.asComposePath(),
                    color = glowColor.copy(alpha = 0.3f),
                    style = Stroke(width = 6f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                )
                // Core solid ink
                drawPath(
                    path = trailPath.asComposePath(),
                    color = strokeColor,
                    style = Stroke(width = 3.5f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                )
                
                // Static details (2nd 'i' dot & 't' crossbar)
                if (finalDetailsAlpha.value > 0f) {
                    drawCircle(
                        color = strokeColor,
                        radius = 2.5f,
                        center = Offset(75f, -50f),
                        alpha = finalDetailsAlpha.value
                    )
                    drawLine(
                        color = strokeColor,
                        start = Offset(135f, -40f),
                        end = Offset(155f, -40f),
                        strokeWidth = 3f,
                        cap = StrokeCap.Round,
                        alpha = finalDetailsAlpha.value
                    )
                }
            }
            
            // --- Draw Dot 1 (The Calligraphy Skater) ---
            if (dot1Alpha.value > 0f) {
                var dot1LocX = -10f
                var dot1LocY = 0f
                
                if (traceProgress.value == 0f) {
                    val dropY = -(screenHeightPx / pathScale) * (1f - dot1Drop.value)
                    dot1LocX = -10f
                    dot1LocY = dropY
                } else {
                    val pos = FloatArray(2)
                    if (pathMeasure.getPosTan(currentTraceLen, pos, null)) {
                        dot1LocX = pos[0]
                        dot1LocY = pos[1]
                    }
                }
                
                withTransform({
                    translate(startX + dot1LocX * pathScale, baseY + dot1LocY * pathScale)
                    // Only apply severe stretch during the initial drop
                    if (traceProgress.value == 0f) {
                        scale(dot1ScaleX.value, dot1ScaleY.value)
                    }
                }) {
                    drawCircle(brush = dotBrush, radius = 4f * pathScale, alpha = dot1Alpha.value)
                }
            }
            
            // --- Draw Dot 2 (The Impact Dot) ---
            if (dot2Alpha.value > 0f) {
                // The position of the top of the 1st stem
                val topX = 10f + stemBendOffset.value
                val topY = -50f + abs(stemBendOffset.value) * 0.2f
                
                val targetX = startX + topX * pathScale
                val targetY = baseY + topY * pathScale
                
                // Track the bending stem, and apply gravity & bounce
                val currentDot2Y = targetY - screenHeightPx * (1f - dot2Drop.value) + dot2BounceOffset.value * pathScale
                
                withTransform({
                    translate(targetX, currentDot2Y)
                }) {
                    drawCircle(brush = dotBrush, radius = 4f * pathScale, alpha = dot2Alpha.value)
                }
            }
            
            // --- Final Settling Glow ---
            if (glowProgress.value > 0f) {
                val glowX = startX - 300f + (glowProgress.value * (160f * pathScale + 600f))
                withTransform({
                    translate(glowX, baseY - 50f * pathScale)
                    rotate(25f)
                }) {
                    drawRect(
                        brush = Brush.horizontalGradient(
                            0f to Color.Transparent,
                            0.5f to Color.White.copy(alpha = 0.6f),
                            1f to Color.Transparent
                        ),
                        topLeft = Offset(-100f, -300f),
                        size = Size(200f, 600f),
                        blendMode = BlendMode.Overlay // Adds a beautiful sheen
                    )
                }
            }
        }
    }
}
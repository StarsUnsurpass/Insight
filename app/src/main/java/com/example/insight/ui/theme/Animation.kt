package com.example.insight.ui.theme

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

/**
 * iOS 风格的弹性动画配置
 */
object InsightAnimation {
    
    // 基础的 iOS 丝滑弹簧 (高阻尼，适中刚度)
    val IosSpring = spring<Float>(
        dampingRatio = 0.82f,
        stiffness = 380f
    )

    // Dp 类型的 iOS 弹簧
    val IosDpSpring = spring<Dp>(
        dampingRatio = 0.82f,
        stiffness = 380f
    )

    // 偏移量类型的 iOS 弹簧
    val IosOffsetSpring = spring<IntOffset>(
        dampingRatio = 0.82f,
        stiffness = 380f
    )

    // 更有弹性的动画 (中阻尼，低刚度)
    val BouncySpring = spring<Float>(
        dampingRatio = 0.65f,
        stiffness = 180f
    )

    // 快速响应的弹簧
    val FastSpring = spring<Float>(
        dampingRatio = Spring.DampingRatioNoBouncy,
        stiffness = Spring.StiffnessMedium
    )
    
    // 列表项进入/退出的默认动画规格
    fun <T> springSpec() = spring<T>(
        dampingRatio = 0.8f,
        stiffness = 400f
    )
}

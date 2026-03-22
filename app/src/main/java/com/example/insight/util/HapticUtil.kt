package com.example.insight.util

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import com.example.insight.ui.state.UserPreferences

/**
 * 支持震感反馈的点击修饰符
 */
fun Modifier.hapticClickable(
    preferences: UserPreferences,
    enabled: Boolean = true,
    onClick: () -> Unit
): Modifier = composed {
    val haptic = LocalHapticFeedback.current
    
    this.clickable(
        enabled = enabled,
        onClick = {
            if (preferences.hapticEnabled) {
                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
            }
            onClick()
        }
    )
}

/**
 * 触发一次标准震感
 */
fun triggerHaptic(preferences: UserPreferences, haptic: androidx.compose.ui.hapticfeedback.HapticFeedback) {
    if (preferences.hapticEnabled) {
        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
    }
}

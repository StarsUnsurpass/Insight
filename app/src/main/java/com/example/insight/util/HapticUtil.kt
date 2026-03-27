package com.example.insight.util

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalContext
import com.example.insight.ui.state.HapticIntensity
import com.example.insight.ui.state.UserPreferences
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

/**
 * 支持震感反馈的点击修饰符
 */
fun Modifier.hapticClickable(
    preferences: UserPreferences,
    enabled: Boolean = true,
    onClick: () -> Unit
): Modifier = composed {
    val context = LocalContext.current
    
    this.clickable(
        enabled = enabled,
        onClick = {
            if (preferences.hapticEnabled) {
                performVibration(context, preferences.hapticIntensity)
            }
            onClick()
        }
    )
}

/**
 * 触发一次标准震感
 */
fun triggerHaptic(preferences: UserPreferences, context: Context) {
    if (preferences.hapticEnabled) {
        performVibration(context, preferences.hapticIntensity)
    }
}

/**
 * 执行物理震动
 */
private fun performVibration(context: Context, intensity: HapticIntensity) {
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    val (duration, amplitude) = when (intensity) {
        HapticIntensity.NONE -> return // No vibration
        HapticIntensity.WEAK -> 15L to 40
        HapticIntensity.MEDIUM -> 30L to 150
        HapticIntensity.STRONG -> 60L to 255
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        try {
            vibrator.vibrate(VibrationEffect.createOneShot(duration, amplitude))
        } catch (e: Exception) {
            // Fallback for some devices
            @Suppress("DEPRECATION")
            vibrator.vibrate(duration)
        }
    } else {
        @Suppress("DEPRECATION")
        vibrator.vibrate(duration)
    }
}

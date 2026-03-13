package com.example.insight.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.insight.ui.state.ThemeStyle

private val LightColorScheme = lightColorScheme(
    primary = InkBlue,
    secondary = SageGreen,
    tertiary = HighlightYellow,
    background = PaperWhite,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = DarkText,
    onSurface = DarkText
)

private val ModernColorScheme = lightColorScheme(
    primary = InkBlue,
    secondary = SageGreen,
    background = Color.White,
    surface = SoftOatmeal
)

private val OceanColorScheme = lightColorScheme(
    primary = OceanPrimary,
    secondary = OceanSecondary,
    background = OceanBackground,
    surface = Color.White
)

private val SunsetColorScheme = lightColorScheme(
    primary = SunsetPrimary,
    secondary = SunsetSecondary,
    background = SunsetBackground,
    surface = Color.White
)

private val SakuraColorScheme = lightColorScheme(
    primary = SakuraPrimary,
    secondary = SakuraSecondary,
    background = SakuraBackground,
    surface = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = SageGreen,
    secondary = InkBlue,
    tertiary = HighlightYellow,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun InsightTheme(
    style: ThemeStyle = ThemeStyle.Default,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> when (style) {
            ThemeStyle.Default -> LightColorScheme
            ThemeStyle.Minimal -> LightColorScheme.copy(background = Color.White, surface = Color.White)
            ThemeStyle.Modern -> ModernColorScheme
            ThemeStyle.Ocean -> OceanColorScheme
            ThemeStyle.Sunset -> SunsetColorScheme
            ThemeStyle.Sakura -> SakuraColorScheme
        }
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            @Suppress("DEPRECATION")
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

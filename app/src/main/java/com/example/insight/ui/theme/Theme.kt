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

// --- Dark Color Schemes ---

private val DarkDefaultColorScheme = darkColorScheme(
    primary = Color(0xFF90CAF9), // Light Blue 200
    secondary = Color(0xFFA5D6A7), // Green 200
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.Black,
    onSecondary = Color.Black
)

private val DarkOceanColorScheme = darkColorScheme(
    primary = Color(0xFF48CAE4),
    secondary = Color(0xFF0077B6),
    background = Color(0xFF03045E),
    surface = Color(0xFF023E8A),
    onPrimary = Color.Black,
    onSurface = Color.White
)

private val DarkSunsetColorScheme = darkColorScheme(
    primary = Color(0xFFFCBF49),
    secondary = Color(0xFFF77F00),
    background = Color(0xFF003049),
    surface = Color(0xFFD62828),
    onPrimary = Color.Black,
    onSurface = Color.White
)

private val DarkSakuraColorScheme = darkColorScheme(
    primary = Color(0xFFFFB7C5),
    secondary = Color(0xFFF28482),
    background = Color(0xFF2D1B2E),
    surface = Color(0xFF4A2F4D),
    onPrimary = Color.Black,
    onSurface = Color.White
)

@Composable
fun InsightTheme(
    style: ThemeStyle = ThemeStyle.Default,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        when (style) {
            ThemeStyle.Default, ThemeStyle.Minimal, ThemeStyle.Modern -> DarkDefaultColorScheme
            ThemeStyle.Ocean -> DarkOceanColorScheme
            ThemeStyle.Sunset -> DarkSunsetColorScheme
            ThemeStyle.Sakura -> DarkSakuraColorScheme
        }
    } else {
        when (style) {
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

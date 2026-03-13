package com.example.insight.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme // Added import for lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = InkBlue,
    secondary = SageGreen,
    tertiary = HighlightYellow,
    background = PaperWhite,
    surface = SoftOatmeal,
    onPrimary = PaperWhite,
    onSecondary = PaperWhite,
    onBackground = DarkText,
    onSurface = DarkText
)

private val DarkColorScheme = darkColorScheme(
    primary = SageGreen,
    secondary = InkBlue,
    tertiary = HighlightYellow,
    background = InkBlue,
    surface = DarkText,
    onPrimary = PaperWhite,
    onSecondary = PaperWhite,
    onBackground = PaperWhite,
    onSurface = PaperWhite
)

@Composable
fun InsightTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
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

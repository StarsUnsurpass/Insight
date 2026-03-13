package com.example.insight.ui.state

sealed class ScreenState {
    object Scanning : ScreenState()
    data class Analyzing(val capturedText: String) : ScreenState()
    data class Solution(val content: String, val concepts: List<String>) : ScreenState()
    object Graph : ScreenState()
}

enum class ThemeStyle {
    Default, Minimal, Modern, Ocean, Sunset, Sakura
}

data class UserPreferences(
    val username: String = "王小明",
    val isDarkMode: Boolean = false,
    val themeStyle: ThemeStyle = ThemeStyle.Default,
    val hapticEnabled: Boolean = true
)

data class InsightUiState(
    val screen: ScreenState = ScreenState.Scanning,
    val isStreaming: Boolean = false,
    val preferences: UserPreferences = UserPreferences()
)

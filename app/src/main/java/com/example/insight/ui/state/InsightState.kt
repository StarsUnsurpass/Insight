package com.example.insight.ui.state

sealed class ScreenState {
    object Scanning : ScreenState()
    data class Analyzing(val capturedText: String) : ScreenState()
    data class Solution(val content: String, val concepts: List<String>) : ScreenState()
    object Graph : ScreenState()
}

data class InsightUiState(
    val screen: ScreenState = ScreenState.Scanning,
    val isStreaming: Boolean = false
)

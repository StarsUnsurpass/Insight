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

enum class UserRole {
    Student, Teacher
}

enum class DetailLevel {
    MINIMAL, STANDARD, DETAILED
}

enum class ReportFont {
    SAN_SERIF, SERIF, MONOSPACE
}

enum class ChartStyle {
    RADAR, BAR, PIE
}

data class ReportConfig(
    val reportTitle: String = "学情分析周报",
    val themeColor: Int = 0xFF8BA18E.toInt(),
    val fontStyle: ReportFont = ReportFont.SAN_SERIF,
    val chartStyle: ChartStyle = ChartStyle.RADAR,
    val includeRadarChart: Boolean = true,
    val includeStudentList: Boolean = true,
    val detailLevel: DetailLevel = DetailLevel.STANDARD
)

data class UserPreferences(
    val username: String = "用户",
    val className: String = "一年级一班",
    val role: UserRole = UserRole.Teacher,
    val isDarkMode: Boolean = false,
    val themeStyle: ThemeStyle = ThemeStyle.Default,
    val hapticEnabled: Boolean = true
)

data class InsightUiState(
    val screen: ScreenState = ScreenState.Scanning,
    val isStreaming: Boolean = false,
    val preferences: UserPreferences = UserPreferences()
)

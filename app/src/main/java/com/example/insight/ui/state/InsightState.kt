package com.example.insight.ui.state

sealed class ScreenState {
    object Scanning : ScreenState()
    data class Analyzing(val capturedText: String) : ScreenState()
    data class Solution(val content: String, val concepts: List<String>, val capturedText: String = "") : ScreenState()
    object Graph : ScreenState()
    object StudentList : ScreenState()
    data class StudentDetail(val studentId: String) : ScreenState()
    object LessonPlanList : ScreenState()
    data class LessonPlanEditor(val planId: String?) : ScreenState()
    object MindMap : ScreenState()
    data class KnowledgeDetail(val nodeId: String) : ScreenState()
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

enum class PaperType {
    NONE, LINED, GRID, OLD_PAPER
}

data class HandwritingConfig(
    val fontName: String = "handwriting_default.ttf",
    val paperType: PaperType = PaperType.LINED,
    val fontSize: Int = 18,
    val sizeJitter: Float = 0.05f,
    val rotationJitter: Float = 2.0f,
    val positionJitter: Float = 1.5f,
    val spacingJitter: Float = 1.0f,
    val inkBlur: Float = 0.4f,
    val paperColor: String = "#FFF9C4", // Warm paper color
    val lineOpacity: Float = 0.3f
)

data class ReportConfig(
    val reportTitle: String = "学情分析周报",
    val themeColor: Int = 0xFF8BA18E.toInt(),
    val fontStyle: ReportFont = ReportFont.SAN_SERIF,
    val chartStyle: ChartStyle = ChartStyle.RADAR,
    val includeRadarChart: Boolean = true,
    val includeStudentList: Boolean = true,
    val detailLevel: DetailLevel = DetailLevel.STANDARD,
    val isHandwritingMode: Boolean = false,
    val handwritingConfig: HandwritingConfig = HandwritingConfig()
)

data class UserPreferences(
    val username: String = "用户",
    val className: String = "一年级一班",
    val role: UserRole = UserRole.Teacher,
    val isDarkMode: Boolean = false,
    val themeStyle: ThemeStyle = ThemeStyle.Default,
    val hapticEnabled: Boolean = true,
    val deepSeekApiKey: String = "sk-83c0282197994bbd8fa34948f7872ebf"
)

data class InsightUiState(
    val screen: ScreenState = ScreenState.Scanning,
    val isStreaming: Boolean = false,
    val preferences: UserPreferences = UserPreferences(),
    val students: List<com.example.insight.data.local.entities.StudentEntity> = emptyList(),
    val selectedStudent: com.example.insight.data.local.entities.StudentEntity? = null,
    val studentScans: List<com.example.insight.data.local.entities.ScanRecordEntity> = emptyList(),
    val studentReport: com.example.insight.data.local.entities.DiagnosticReportEntity? = null,
    val lessonPlans: List<com.example.insight.data.local.entities.LessonPlanEntity> = emptyList(),
    val selectedPlan: com.example.insight.data.local.entities.LessonPlanEntity? = null,
    val planQuestions: List<com.example.insight.data.local.entities.ScanRecordEntity> = emptyList(),
    val knowledgeNodes: List<com.example.insight.data.local.entities.KnowledgeNodeEntity> = emptyList(),
    val allScans: List<com.example.insight.data.local.entities.ScanRecordEntity> = emptyList()
)

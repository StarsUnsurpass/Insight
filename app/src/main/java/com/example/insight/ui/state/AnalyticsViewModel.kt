package com.example.insight.ui.state

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.local.entities.StudentEntity
import com.example.insight.data.repository.InsightRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val repository: InsightRepository
) : ViewModel() {

    private val _viewType = MutableStateFlow(AnalyticsViewType.CLASS)
    private val _selectedStudentId = MutableStateFlow<String?>(null)

    val uiState: StateFlow<AnalyticsState> = combine(
        _viewType,
        _selectedStudentId,
        repository.userPreferencesFlow,
        repository.getAllStudents(),
        repository.getAllScans()
    ) { viewType, studentId, preferences, students, scans ->
        
        val selectedStudent = students.find { it.studentId == studentId } ?: students.firstOrNull()
        val className = preferences.className
        
        // --- 班级数据计算 ---
        val vitals = ClassVitals(
            yesterdayCompletionRate = 0.92f,
            classHealthScore = if (students.isEmpty()) 0 else (students.map { it.latestScore }.average()).toInt(),
            healthTrend = listOf(75f, 78f, 82f, 80f, 81f, 83f, 82f),
            coreProgressTitle = "Unit 8 Terms & Grammar",
            coreProgressValue = 0.72f
        )

        val zones = listOf(
            DisasterZone("现在完成时 - 标志词混淆", 0.65f, "present_perfect"),
            DisasterZone("完形填空 - 上下文逻辑", 0.58f, "reading_logic"),
            DisasterZone("被动语态 - 时态对应", 0.42f, "passive_voice")
        )

        val stratification = StratificationData(
            watchlist = students.filter { it.latestScore < 70 }.take(3),
            risingStars = students.filter { it.latestScore > 90 }.take(3)
        )

        // --- 个体诊断数据计算 ---
        val pathology = listOf(
            ErrorCause("概念盲区", 0.45f, Color(0xFFEF5350)),
            ErrorCause("审题偏差", 0.25f, Color(0xFFFFB74D)),
            ErrorCause("母语负迁移", 0.20f, Color(0xFFAB47BC)),
            ErrorCause("搭配混淆", 0.10f, Color(0xFF42A5F5))
        )

        AnalyticsState(
            selectedView = viewType,
            isLoading = false,
            classVitals = vitals,
            disasterHeatmap = zones,
            stratification = stratification,
            studentList = students,
            selectedClass = className,
            selectedStudent = selectedStudent,
            individualSummary = generateIndividualSummary(selectedStudent),
            individualDimensions = mapOf("词法" to 0.8f, "语法" to 0.65f, "阅读" to 0.72f, "交际" to 0.85f, "写作" to 0.6f),
            classAverageDimensions = mapOf("词法" to 0.75f, "语法" to 0.72f, "阅读" to 0.78f, "交际" to 0.7f, "写作" to 0.72f),
            errorPathology = pathology,
            stubbornErrors = listOf(StubbornError("宾语从句语序", 3), StubbornError("动词过去分词不规则变化", 2))
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = AnalyticsState(isLoading = true)
    )

    fun updateView(viewType: AnalyticsViewType) {
        _viewType.value = viewType
    }

    fun selectStudent(studentId: String) {
        _selectedStudentId.value = studentId
        _viewType.value = AnalyticsViewType.INDIVIDUAL
    }

    private fun generateIndividualSummary(student: StudentEntity?): String {
        if (student == null) return "暂无学生数据。"
        return "${student.name}近期学习态度积极，词汇量稳步提升。但图谱显示他在【复合句】相关模块（如宾语从句的语序）存在底层认知断层。建议放缓做题速度，回归课本原典进行长难句精读。"
    }
}

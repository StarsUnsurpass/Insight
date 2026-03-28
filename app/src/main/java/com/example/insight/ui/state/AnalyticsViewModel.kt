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

    // 基础流：偏好设置、学生列表、全班成绩分布
    private val baseDataFlow = combine(
        _viewType,
        _selectedStudentId,
        repository.userPreferencesFlow,
        repository.getAllStudents(),
        repository.getClassScoreDistribution()
    ) { viewType, studentId, prefs, students, classDist ->
        BaseData(viewType, studentId, prefs, students, classDist)
    }

    // 动态流：根据选中的视图和学生，获取详细诊断数据
    val uiState: StateFlow<AnalyticsState> = baseDataFlow.flatMapLatest { base ->
        if (base.viewType == AnalyticsViewType.CLASS) {
            getClassAnalytics(base)
        } else {
            getIndividualAnalytics(base)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = AnalyticsState(isLoading = true)
    )

    private fun getClassAnalytics(base: BaseData): Flow<AnalyticsState> {
        return repository.getAllScans().map { allScans ->
            val students = base.students
            val avgScore = if (students.isEmpty()) 0 else students.map { it.latestScore }.average().toInt()
            
            // 计算昨日作业完成率 (假设昨日有扫描即为完成)
            val yesterday = System.currentTimeMillis() - 86400000
            val scansYesterday = allScans.filter { it.createdAt > yesterday }
            val studentsActiveYesterday = scansYesterday.map { it.studentId }.distinct().size
            val completionRate = if (students.isEmpty()) 0f else studentsActiveYesterday.toFloat() / students.size

            // 统计班级重灾区 (错误率最高的知识点)
            val errorScans = allScans.filter { !it.isMastered && it.coreKnowledgeId != null }
            val disasterZones = errorScans.groupBy { it.coreKnowledgeId }
                .map { (id, scans) -> 
                    DisasterZone(
                        title = scans.first().coreKnowledgeId ?: "未知考点",
                        errorRate = scans.size.toFloat() / allScans.size.coerceAtLeast(1),
                        knowledgeId = id ?: ""
                    )
                }
                .sortedByDescending { it.errorRate }
                .take(3)

            val vitals = ClassVitals(
                yesterdayCompletionRate = completionRate.coerceAtMost(1f),
                classHealthScore = avgScore,
                healthTrend = listOf(75f, 78f, 82f, 80f, 81f, 83f, 82f),
                coreProgressTitle = "全册核心考点",
                coreProgressValue = (allScans.filter { it.isMastered }.size.toFloat() / allScans.size.coerceAtLeast(1)).coerceAtMost(1f)
            )

            val stratification = StratificationData(
                watchlist = students.filter { it.latestScore < 75 }.take(5),
                risingStars = students.filter { it.latestScore > 90 }.take(5)
            )

            AnalyticsState(
                selectedView = AnalyticsViewType.CLASS,
                isLoading = false,
                classVitals = vitals,
                disasterHeatmap = disasterZones,
                stratification = stratification,
                studentList = students,
                selectedClass = base.prefs.className,
                classScoreDistribution = base.classDist
            )
        }
    }

    private fun getIndividualAnalytics(base: BaseData): Flow<AnalyticsState> {
        val studentId = base.studentId ?: base.students.firstOrNull()?.studentId ?: ""
        if (studentId.isEmpty()) return flowOf(AnalyticsState(selectedView = AnalyticsViewType.INDIVIDUAL, studentList = base.students))

        return combine(
            repository.getSkillDimensionStats(studentId),
            repository.getErrorCategoryStats(studentId),
            repository.getRealWeakNodeCounts(studentId)
        ) { skillStats, errorStats, weakNodes ->
            val student = base.students.find { it.studentId == studentId }
            
            val dimensions = skillStats.associate { 
                mapCategoryIdToName(it.categoryId) to it.score / 100f 
            }.ifEmpty { 
                mapOf("词法" to 0.5f, "语法" to 0.5f, "阅读" to 0.5f, "交际" to 0.5f, "写作" to 0.5f) 
            }

            val pathology = errorStats.map { 
                ErrorCause(mapErrorLabel(it.label), it.count.toFloat(), getErrorColor(it.label)) 
            }

            val totalErrors = errorStats.sumOf { it.count }

            AnalyticsState(
                selectedView = AnalyticsViewType.INDIVIDUAL,
                isLoading = false,
                selectedStudent = student,
                studentList = base.students,
                selectedClass = base.prefs.className,
                individualSummary = generateIndividualSummary(student, totalErrors, weakNodes.firstOrNull()?.label),
                individualDimensions = dimensions,
                classAverageDimensions = mapOf("词法" to 0.75f, "语法" to 0.72f, "阅读" to 0.78f, "交际" to 0.7f, "写作" to 0.72f), // 班级均线暂用模拟值
                errorPathology = pathology,
                stubbornErrors = weakNodes.map { StubbornError(it.label, it.count) }
            )
        }
    }

    fun updateView(viewType: AnalyticsViewType) {
        _viewType.value = viewType
    }

    fun selectStudent(studentId: String) {
        _selectedStudentId.value = studentId
        _viewType.value = AnalyticsViewType.INDIVIDUAL
    }

    private fun generateIndividualSummary(student: StudentEntity?, errorCount: Int, mainWeakness: String?): String {
        if (student == null) return "暂无学生数据。"
        val weaknessText = if (mainWeakness != null) "核心症结集中在【$mainWeakness】。" else "近期表现较为均衡。"
        return "${student.name}目前累计记录错题 $errorCount 道。$weaknessText 图谱显示他在相关模块存在底层认知断层。建议放缓做题速度，回归课本原典进行长难句精读。"
    }

    private fun mapCategoryIdToName(id: Int) = when(id) {
        1 -> "词法"
        2 -> "语法"
        3 -> "阅读"
        4 -> "交际"
        else -> "写作"
    }

    private fun mapErrorLabel(tag: String) = when(tag) {
        "CONCEPT_GAP" -> "概念盲区"
        "MOTHER_TONGUE" -> "母语负迁移"
        "COUPLING_ERROR" -> "固定搭配混淆"
        "CARELESSNESS" -> "审题偏差"
        else -> "基础薄弱"
    }

    private fun getErrorColor(tag: String) = when(tag) {
        "CONCEPT_GAP" -> Color(0xFFEF5350)
        "MOTHER_TONGUE" -> Color(0xFFAB47BC)
        "COUPLING_ERROR" -> Color(0xFF42A5F5)
        else -> Color(0xFFFFB74D)
    }
}

private data class BaseData(
    val viewType: AnalyticsViewType,
    val studentId: String?,
    val prefs: UserPreferences,
    val students: List<StudentEntity>,
    val classDist: List<com.example.insight.data.local.entities.ScoreStageCount>
)

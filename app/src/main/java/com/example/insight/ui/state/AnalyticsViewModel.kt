package com.example.insight.ui.state

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.local.dao.*
import com.example.insight.data.local.entities.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import java.text.SimpleDateFormat
import java.util.*

@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val scanDao: ScanDao,
    private val knowledgeDao: KnowledgeDao,
    private val studentDao: StudentDao
) : ViewModel() {

    private val _viewType = MutableStateFlow(AnalyticsViewType.INDIVIDUAL)
    
    // 动态获取当前选中的学生 ID (如果没有则使用 DEFAULT)
    private val activeStudentId = studentDao.getAllStudentsFlow()
        .map { it.firstOrNull()?.studentId ?: "DEFAULT_STUDENT" }
        .distinctUntilChanged()

    val uiState: StateFlow<AnalyticsState> = activeStudentId.flatMapLatest { studentId ->
        combine(
            _viewType,
            knowledgeDao.getSkillDimensionStats(studentId),
            knowledgeDao.getHighFrequencyVulnerabilities(studentId),
            knowledgeDao.getPrerequisiteGapAlerts(studentId),
            knowledgeDao.getClassScoreDistribution(),
            scanDao.getErrorCategoryStats(studentId),
            scanDao.getRealWeakNodeCounts(studentId),
            scanDao.getLearningRhythm(studentId, System.currentTimeMillis() - 35L * 86400000)
        ) { params ->
            val viewType = params[0] as AnalyticsViewType
            val skills = params[1] as List<SkillDimensionScore>
            val highFreq = params[2] as List<KnowledgeNodeEntity>
            val gaps = params[3] as List<KnowledgeNodeEntity>
            val classDist = params[4] as List<ScoreStageCount>
            val errorStats = params[5] as List<CategoryCount>
            val weakCounts = params[6] as List<CategoryCount>
            val rhythm = params[7] as List<DailyActivityData>

            // 1. 五维能力 (真实百分比)
            val dimensionMap = mapOf(
                "词法储备" to (skills.find { it.categoryId == 1 }?.score ?: 0f) / 100f,
                "语法重构" to (skills.find { it.categoryId == 2 }?.score ?: 0f) / 100f,
                "语境推理" to (skills.find { it.categoryId == 3 }?.score ?: 0f) / 100f,
                "篇章逻辑" to (skills.find { it.categoryId == 4 }?.score ?: 0f) / 100f,
                "词形变异" to (skills.find { it.categoryId == 5 }?.score ?: 0f) / 100f
            )

            // 2. 真实薄弱点 (Top 5)
            val topWeakNodes = weakCounts.map { 
                KnowledgePointInfo(it.label, it.count, "最近出错") 
            }

            // 3. 错因分布 (真实计数)
            val totalErrors = errorStats.sumOf { it.count }.coerceAtLeast(1)
            val causes = errorStats.map { 
                ErrorCause(mapErrorLabel(it.label), it.count.toFloat() / totalErrors, getErrorColor(it.label))
            }

            // 4. 预测分 (真实转换)
            val avgMastery = if (skills.isEmpty()) 0f else skills.map { it.score }.average().toFloat()
            val scoreBase = (avgMastery * 1.2f).toInt().coerceIn(0, 120)

            AnalyticsState(
                selectedView = viewType,
                overallMastery = avgMastery.toInt(),
                predictedScoreRange = scoreBase to (scoreBase + 5).coerceAtMost(120),
                cognitiveDimensions = dimensionMap,
                errorCauses = causes,
                heatmapData = rhythm.map { DailyActivity(it.timestamp, it.intensity) },
                highFrequencyIssuesCount = highFreq.size,
                prerequisiteGapAlerts = gaps.map { PrerequisiteAlert(it.title, "基础前置", 40) },
                topWeakNodes = topWeakNodes,
                classScoreDistribution = sortClassDistribution(classDist),
                aiSummary = generateRealDataSummary(highFreq.size, gaps.size, totalErrors)
            )
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = AnalyticsState(isLoading = true)
    )

    private fun sortClassDistribution(dist: List<ScoreStageCount>): List<ScoreStageCount> {
        val order = listOf("优秀", "良好", "中等", "及格", "不及格")
        return order.map { stage -> dist.find { it.stage == stage } ?: ScoreStageCount(stage, 0) }
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

    private fun generateRealDataSummary(highFreqCount: Int, gapCount: Int, totalError: Int): String {
        return "【真实诊断】数据库记录显示该生共有 $totalError 处错题。其中 $highFreqCount 处属于中考高频。系统检测到 $gapCount 处显著认知链路断层，建议降维复习。"
    }

    fun updateView(viewType: AnalyticsViewType) {
        _viewType.value = viewType
    }
}

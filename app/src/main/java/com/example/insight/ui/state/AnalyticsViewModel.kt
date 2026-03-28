package com.example.insight.ui.state

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.local.dao.*
import com.example.insight.data.local.entities.KnowledgeNodeEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import java.text.SimpleDateFormat
import java.util.*

@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val scanDao: ScanDao,
    private val knowledgeDao: KnowledgeDao
) : ViewModel() {

    private val _viewType = MutableStateFlow(AnalyticsViewType.INDIVIDUAL)
    private val studentId = "DEFAULT_STUDENT"
    private val sdf = SimpleDateFormat("MM-dd HH:mm", Locale.CHINA)

    // 组合知识图谱统计
    private val knowledgeStatsFlow = combine(
        knowledgeDao.getSkillDimensionStats(studentId),
        knowledgeDao.getHighFrequencyVulnerabilities(studentId),
        knowledgeDao.getPrerequisiteGapAlerts(studentId)
    ) { skills, highFreq, gaps ->
        Triple(skills, highFreq, gaps)
    }

    // 组合错题统计
    private val errorStatsFlow = combine(
        scanDao.getErrorCategoryStats(studentId),
        scanDao.getQuestionTypeFailureStats(studentId),
        scanDao.getScanCountFlow(),
        scanDao.getMasteredCountFlow()
    ) { errors, qTypes, total, mastered ->
        ErrorStats(errors, qTypes, total, mastered)
    }

    val uiState: StateFlow<AnalyticsState> = combine(
        _viewType,
        knowledgeStatsFlow,
        errorStatsFlow,
        scanDao.getLearningRhythm(studentId, System.currentTimeMillis() - 35L * 86400000)
    ) { viewType, kStats, eStats, rhythm ->
        
        val (skills, highFreq, gaps) = kStats

        // 1. 五维能力映射
        val dimensionMap = mapOf(
            "词法储备" to (skills.find { it.categoryId == 1 }?.score ?: 75f) / 100f,
            "语法重构" to (skills.find { it.categoryId == 2 }?.score ?: 62f) / 100f,
            "语境推理" to (skills.find { it.categoryId == 3 }?.score ?: 80f) / 100f,
            "篇章逻辑" to (skills.find { it.categoryId == 4 }?.score ?: 45f) / 100f,
            "词形变异" to (skills.find { it.categoryId == 5 }?.score ?: 90f) / 100f
        )

        // 2. 错因病理映射
        val totalErrors = eStats.errors.sumOf { it.count }.coerceAtLeast(1)
        val errorCauses = eStats.errors.map { 
            ErrorCause(
                label = mapErrorLabel(it.label),
                percentage = it.count.toFloat() / totalErrors,
                color = getErrorColor(it.label)
            )
        }

        // 3. 认知断层逻辑转换
        val alertList = gaps.map { gap ->
            PrerequisiteAlert(
                targetNode = gap.title,
                sourceNode = "前置基础", // 简化处理，实际可查表
                sourceMastery = 40
            )
        }

        // 4. 预测分区间逻辑 (简单模型: 基础分 + 掌握度加权)
        val baseScore = 80
        val bonus = (skills.map { it.score }.average().toInt() / 4).coerceIn(0, 30)
        val predictedRange = (baseScore + bonus) to (baseScore + bonus + 8)

        AnalyticsState(
            selectedView = viewType,
            overallMastery = (skills.map { it.score }.average().toInt()).coerceIn(0, 100),
            cognitiveDimensions = dimensionMap,
            errorCauses = errorCauses,
            questionTypePerformance = eStats.qTypes.map { CategoryPercentage(it.label, it.percentage) },
            heatmapData = rhythm.map { DailyActivity(it.timestamp, it.intensity) },
            highFrequencyIssuesCount = highFreq.size,
            prerequisiteGapAlerts = alertList,
            topWeakNodes = highFreq.take(5).map { 
                KnowledgePointInfo(it.title, (1..5).random(), sdf.format(Date())) 
            },
            predictedScoreRange = predictedRange,
            throughput = ThroughputMetrics(eStats.totalCount, listOf(0.6f, 0.7f, 0.65f, 0.8f)),
            aiSummary = generateMedicalGradeSummary(highFreq.size, gaps.size)
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = AnalyticsState(isLoading = true)
    )

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

    private fun generateMedicalGradeSummary(highFreqCount: Int, gapCount: Int): String {
        return "【深度分析】本周学习进入‘平台期’。虽然攻克了 $highFreqCount 个高频考点，但系统监测到 $gapCount 处显著的认知链路断层。目前的错误主要集中在‘母语负迁移’，反映出地道表达积累不足。建议优先降维复习前置节点，以防后续语法塔坍塌。"
    }

    fun updateView(viewType: AnalyticsViewType) {
        _viewType.value = viewType
    }
}

data class ErrorStats(
    val errors: List<com.example.insight.data.local.entities.CategoryCount>,
    val qTypes: List<com.example.insight.data.local.entities.CategoryPercentage>,
    val totalCount: Int,
    val masteredCount: Int
)

package com.example.insight.ui.state

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.local.dao.*
import com.example.insight.data.local.entities.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
    private val sdf = SimpleDateFormat("MM-dd HH:mm", Locale.CHINA)

    // 动态获取当前活动的学生
    @OptIn(ExperimentalCoroutinesApi::class)
    private val activeStudentId = studentDao.getAllStudentsFlow()
        .map { it.firstOrNull()?.studentId ?: "DEFAULT_STUDENT" }
        .distinctUntilChanged()

    // 结构化组合知识图谱统计，避免 vararg combine 导致的类型丢失
    private fun getKnowledgeStatsFlow(studentId: String) = combine(
        knowledgeDao.getSkillDimensionStats(studentId),
        knowledgeDao.getHighFrequencyVulnerabilities(studentId),
        knowledgeDao.getPrerequisiteGapAlerts(studentId),
        knowledgeDao.getClassScoreDistribution()
    ) { skills, highFreq, gaps, classDist ->
        KnowledgeStats(skills, highFreq, gaps, classDist)
    }

    // 结构化组合错题统计
    private fun getErrorStatsFlow(studentId: String) = combine(
        scanDao.getErrorCategoryStats(studentId),
        scanDao.getRealWeakNodeCounts(studentId),
        scanDao.getLearningRhythm(studentId, System.currentTimeMillis() - 35L * 86400000)
    ) { errors, weakCounts, rhythm ->
        Triple(errors, weakCounts, rhythm)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val uiState: StateFlow<AnalyticsState> = activeStudentId.flatMapLatest { studentId ->
        combine(
            _viewType,
            getKnowledgeStatsFlow(studentId),
            getErrorStatsFlow(studentId)
        ) { viewType, kStats, eStats ->
            
            val (errorStats, weakCounts, rhythm) = eStats
            val skills = kStats.skills

            // 1. 五维能力映射
            val dimensionMap = mapOf(
                "词法储备" to (skills.find { it.categoryId == 1 }?.score ?: 0f) / 100f,
                "语法重构" to (skills.find { it.categoryId == 2 }?.score ?: 0f) / 100f,
                "语境推理" to (skills.find { it.categoryId == 3 }?.score ?: 0f) / 100f,
                "篇章逻辑" to (skills.find { it.categoryId == 4 }?.score ?: 0f) / 100f,
                "词形变异" to (skills.find { it.categoryId == 5 }?.score ?: 0f) / 100f
            )

            // 2. 真实薄弱点
            val topWeakNodes = weakCounts.map { 
                KnowledgePointInfo(it.label, it.count, "最近出错") 
            }

            // 3. 错因分布
            val totalErrors = errorStats.sumOf { it.count }.coerceAtLeast(1)
            val causes = errorStats.map { 
                ErrorCause(mapErrorLabel(it.label), it.count.toFloat() / totalErrors, getErrorColor(it.label))
            }

            // 4. 预测分逻辑
            val avgMastery = if (skills.isEmpty()) 0f else skills.map { it.score }.average().toFloat()
            val scoreBase = (avgMastery * 1.2f).toInt().coerceIn(0, 120)

            AnalyticsState(
                selectedView = viewType,
                overallMastery = avgMastery.toInt(),
                predictedScoreRange = scoreBase to (scoreBase + 5).coerceAtMost(120),
                cognitiveDimensions = dimensionMap,
                errorCauses = causes,
                heatmapData = rhythm.map { DailyActivity(it.timestamp, it.intensity) },
                highFrequencyIssuesCount = kStats.highFreq.size,
                prerequisiteGapAlerts = kStats.gaps.map { PrerequisiteAlert(it.title, "前置基础", 40) },
                topWeakNodes = topWeakNodes,
                classScoreDistribution = sortClassDistribution(kStats.classDist),
                aiSummary = generateRealDataSummary(topWeakNodes.firstOrNull()?.title, kStats.highFreq.size, kStats.gaps.size, totalErrors)
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

    private fun generateRealDataSummary(mainWeakness: String?, highFreqCount: Int, gapCount: Int, totalError: Int): String {
        val weaknessText = if (mainWeakness != null) "核心症结集中在【$mainWeakness】。" else "近期表现较为均衡。"
        return "数据库真实记录：累计扫描错题 $totalError 道。$weaknessText 其中 $highFreqCount 项为中考高频考点。系统在图谱中定位到 $gapCount 个由于前置不牢导致的认知断层。建议针对性强化。"
    }

    fun updateView(viewType: AnalyticsViewType) {
        _viewType.value = viewType
    }
}

data class KnowledgeStats(
    val skills: List<SkillDimensionScore>,
    val highFreq: List<KnowledgeNodeEntity>,
    val gaps: List<KnowledgeNodeEntity>,
    val classDist: List<ScoreStageCount>
)

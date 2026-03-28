package com.example.insight.ui.state

import androidx.compose.ui.graphics.Color
import com.example.insight.data.local.entities.CategoryPercentage
import com.example.insight.data.local.entities.ScoreStageCount
import com.example.insight.data.local.entities.StudentEntity

data class AnalyticsState(
    val selectedView: AnalyticsViewType = AnalyticsViewType.CLASS, // 默认班级群像
    val isLoading: Boolean = false,
    
    // --- 🏛️ 班级群像 (Class Overview) ---
    val classVitals: ClassVitals = ClassVitals(),
    val disasterHeatmap: List<DisasterZone> = emptyList(),
    val highFreqErrors: List<HighFreqError> = emptyList(),
    val stratification: StratificationData = StratificationData(),
    val studentList: List<StudentEntity> = emptyList(),
    val selectedClass: String = "初三 (2) 班",
    val classScoreDistribution: List<ScoreStageCount> = emptyList(),

    // --- 🔬 个体诊断 (Individual Diagnosis) ---
    val selectedStudent: StudentEntity? = null,
    val individualSummary: String = "",
    val individualDimensions: Map<String, Float> = emptyMap(),
    val classAverageDimensions: Map<String, Float> = emptyMap(),
    val individualKnowledgeGraph: List<KnowledgeNodeStatus> = emptyList(),
    val errorPathology: List<ErrorCause> = emptyList(),
    val stubbornErrors: List<StubbornError> = emptyList(),
    
    // 通用旧数据（兼容）
    val aiSummary: String = ""
)

data class ClassVitals(
    val yesterdayCompletionRate: Float = 0.95f,
    val classHealthScore: Int = 82,
    val healthTrend: List<Float> = listOf(78f, 80f, 79f, 82f, 81f, 83f, 82f),
    val coreProgressTitle: String = "八年级下册 Unit 8",
    val coreProgressValue: Float = 0.78f
)

data class DisasterZone(
    val title: String,
    val errorRate: Float,
    val knowledgeId: String
)

data class HighFreqError(
    val id: String,
    val questionImage: String?,
    val errorCount: Int,
    val totalCount: Int,
    val distribution: List<OptionDistribution>
)

data class OptionDistribution(
    val label: String,
    val percentage: Float,
    val studentNames: List<String>
)

data class StratificationData(
    val watchlist: List<StudentEntity> = emptyList(),
    val risingStars: List<StudentEntity> = emptyList()
)

data class KnowledgeNodeStatus(
    val id: String,
    val title: String,
    val isMastered: Boolean
)

data class StubbornError(
    val title: String,
    val repeatCount: Int
)

enum class AnalyticsViewType { CLASS, INDIVIDUAL }

data class ErrorCause(val label: String, val percentage: Float, val color: Color)
data class DailyActivity(val timestamp: Long, val intensity: Int)

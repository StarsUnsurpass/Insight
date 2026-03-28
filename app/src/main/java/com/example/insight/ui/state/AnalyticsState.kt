package com.example.insight.ui.state

import androidx.compose.ui.graphics.Color

data class AnalyticsState(
    val selectedView: AnalyticsViewType = AnalyticsViewType.INDIVIDUAL,
    val isLoading: Boolean = false,
    val aiSummary: String = "正在深度解析本周学情...",
    val studentName: String = "张三",
    
    // 一、 宏观概览 (Executive Overview)
    val overallMastery: Int = 0,               // 综合得分
    val curriculumProgress: String = "人教版八年级下册", 
    val progressPercentage: Float = 0.85f,     // 进度百分比
    val throughput: ThroughputMetrics = ThroughputMetrics(),
    val focusRhythm: String = "上午第一节课",     // 效率热区
    
    // 二、 五维能力 (Skill Assessment)
    val cognitiveDimensions: Map<String, Float> = emptyMap(),
    
    // 三、 知识图谱诊断 (KG Diagnostics)
    val topWeakNodes: List<KnowledgePointInfo> = emptyList(),
    val prerequisiteGapAlerts: List<PrerequisiteAlert> = emptyList(),
    val forgottenNodesCount: Int = 0,
    
    // 四、 错因分析 (Error Pathology)
    val errorCauses: List<ErrorCause> = emptyList(),
    val questionTypePerformance: List<CategoryPercentage> = emptyList(),
    
    // 五、 中考对标 (Exam Benchmark)
    val highFrequencyIssuesCount: Int = 0,
    val predictedScoreRange: Pair<Int, Int> = 90 to 105,
    
    // 六、 智能化处方 (Prescriptions)
    val targetedPath: String = "优先攻克【状语从句】",
    val syncAdvice: String = "建议精读 八年级下册 Unit 8 Grammar Focus",
    
    // 节律数据 (Heatmap)
    val heatmapData: List<DailyActivity> = emptyList(),
    val streakCount: Int = 0
)

data class ThroughputMetrics(
    val totalQuestions: Int = 0,
    val accuracyTrend: List<Float> = emptyList()
)

data class KnowledgePointInfo(
    val title: String,
    val errorCount: Int,
    val lastErrorTime: String
)

data class PrerequisiteAlert(
    val targetNode: String,
    val sourceNode: String,
    val sourceMastery: Int
)

enum class AnalyticsViewType { INDIVIDUAL, CLASS }

data class ErrorCause(val label: String, val percentage: Float, val color: Color)
data class DailyActivity(val timestamp: Long, val intensity: Int)
data class CategoryPercentage(val label: String, val percentage: Float)

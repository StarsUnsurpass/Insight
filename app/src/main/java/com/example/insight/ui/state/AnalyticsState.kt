package com.example.insight.ui.state

import androidx.compose.ui.graphics.Color

data class AnalyticsState(
    val selectedView: AnalyticsViewType = AnalyticsViewType.INDIVIDUAL,
    val isLoading: Boolean = false,
    val aiSummary: String = "正在深度解析本周学情...",
    val studentName: String = "张三",
    val cognitiveDimensions: Map<String, Float> = mapOf(
        "词汇储量" to 0.85f,
        "语法重构" to 0.62f,
        "语境推理" to 0.75f,
        "篇章逻辑" to 0.45f,
        "跨文化交际" to 0.90f
    ),
    val errorCauses: List<ErrorCause> = listOf(
        ErrorCause("概念盲区", 0.45f, Color(0xFFEF5350)),
        ErrorCause("粗心/审题偏差", 0.30f, Color(0xFFFFB74D)),
        ErrorCause("词汇量掣肘", 0.25f, Color(0xFF42A5F5))
    ),
    val heatmapData: List<DailyActivity> = List(35) { index -> 
        DailyActivity(System.currentTimeMillis() - (35 - index) * 86400000L, (0..4).random())
    },
    val streakCount: Int = 7
)

enum class AnalyticsViewType { INDIVIDUAL, CLASS }

data class ErrorCause(val label: String, val percentage: Float, val color: Color)
data class DailyActivity(val timestamp: Long, val intensity: Int)

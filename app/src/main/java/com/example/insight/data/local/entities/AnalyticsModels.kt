package com.example.insight.data.local.entities

/**
 * 错因统计辅助类
 */
data class CategoryCount(
    val label: String,
    val count: Int
)

/**
 * 题型比例辅助类
 */
data class CategoryPercentage(
    val label: String,
    val percentage: Float
)

/**
 * 学习节律辅助类
 */
data class DailyActivityData(
    val timestamp: Long,
    val intensity: Int
)

/**
 * 成绩区间分布辅助类
 */
data class ScoreStageCount(
    val stage: String, // 不及格, 及格, 中等, 良好, 优秀
    val count: Int
)

/**
 * 能力维度分值辅助类
 */
data class SkillDimensionScore(
    val categoryId: Int,
    val score: Float
)

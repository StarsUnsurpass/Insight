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
 * 能力维度分值辅助类
 */
data class SkillDimensionScore(
    val categoryId: Int,
    val score: Float
)

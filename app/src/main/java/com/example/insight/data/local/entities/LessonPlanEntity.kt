package com.example.insight.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "lesson_plan_table")
data class LessonPlanEntity(
    @PrimaryKey val planId: String = UUID.randomUUID().toString(),
    val title: String,
    val lessonType: String = "常规课",
    val keyPoints: String = "",
    val difficulties: String = "",
    val contentMarkdown: String = "",
    val blocksJson: String = "[]",
    val targetClassName: String,
    val relatedKnowledgeNodeId: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "lesson_question_cross_ref", primaryKeys = ["planId", "questionId"])
data class LessonQuestionCrossRef(
    val planId: String,
    val questionId: String
)

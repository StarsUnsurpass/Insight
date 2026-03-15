package com.example.insight.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diagnostic_report_table")
data class DiagnosticReportEntity(
    @PrimaryKey val reportId: String,
    val aiInsightText: String,
    val radarVocabulary: Float,
    val radarGrammar: Float,
    val radarContext: Float,
    val radarLogic: Float,
    val radarCulture: Float,
    val studentId: String = "", // Foreign key to student_table
    val errorCauseJson: String,
    val createdAt: Long = System.currentTimeMillis()
)

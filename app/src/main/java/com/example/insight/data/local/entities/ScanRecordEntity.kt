package com.example.insight.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "scan_record_table")
data class ScanRecordEntity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val originalImagePath: String,
    val ocrText: String,
    val llmAnalysisJson: String,
    val coreKnowledgeId: String,
    val studentId: String = "", // Foreign key to student_table
    val isMastered: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

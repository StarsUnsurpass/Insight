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
    val studentId: String = "", 
    val isMastered: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    
    // 扩展字段：支持诊断级分析
    val errorCategory: String? = null, // CONCEPT_GAP, MOTHER_TONGUE, COUPLING_ERROR, CARELESSNESS
    val questionType: String? = null,  // MULTI_CHOICE, CLOZE, READING, WRITING
    val difficulty: Int = 3,           // 1-5
    val timeSpentMillis: Long = 0      // 用于效率分析
)

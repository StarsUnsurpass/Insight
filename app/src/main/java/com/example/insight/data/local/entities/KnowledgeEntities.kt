package com.example.insight.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * 知识图谱节点表
 */
@Entity(tableName = "knowledge_nodes")
data class KnowledgeNodeEntity(
    @PrimaryKey val nodeId: String,
    val title: String,
    val category: Int, // 1: 词法, 2: 时态, 3: 句法, 4: 语篇, 5: 词形
    val importanceLevel: Int, // 1-5星
    val isHighFrequency: Boolean = false, // 是否为中考高频必考点
    val canvasX: Float,
    val canvasY: Float,
    val description: String = ""
)

/**
 * 知识图谱关系边表
 */
@Entity(
    tableName = "knowledge_edges",
    foreignKeys = [
        ForeignKey(
            entity = KnowledgeNodeEntity::class,
            parentColumns = ["nodeId"],
            childColumns = ["sourceNodeId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = KnowledgeNodeEntity::class,
            parentColumns = ["nodeId"],
            childColumns = ["targetNodeId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("sourceNodeId"), Index("targetNodeId")]
)
data class KnowledgeEdgeEntity(
    @PrimaryKey(autoGenerate = true) val edgeId: Long = 0,
    val sourceNodeId: String,
    val targetNodeId: String,
    val relationType: String // PREREQUISITE, CONFLICT, INCLUDE
)

/**
 * 闭包表 (Closure Table) 用于高效查询祖先和后代关系
 */
@Entity(
    tableName = "knowledge_closure_table",
    primaryKeys = ["ancestorId", "descendantId"]
)
data class KnowledgeClosureEntity(
    val ancestorId: String,
    val descendantId: String,
    val depth: Int
)

/**
 * 学生知识点掌握度表
 */
@Entity(
    tableName = "student_mastery",
    primaryKeys = ["studentId", "nodeId"]
)
data class StudentMasteryEntity(
    val studentId: String,
    val nodeId: String,
    val masteryScore: Float, // 0-100
    val lastUpdateTime: Long = System.currentTimeMillis()
)

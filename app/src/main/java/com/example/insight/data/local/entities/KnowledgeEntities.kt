package com.example.insight.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "knowledge_node_table")
data class KnowledgeNodeEntity(
    @PrimaryKey val nodeId: String,
    val title: String,
    val masteryLevel: Float,
    val canvasX: Float,
    val canvasY: Float
)

@Entity(tableName = "knowledge_edge_table")
data class KnowledgeEdgeEntity(
    @PrimaryKey(autoGenerate = true) val edgeId: Int = 0,
    val fromNodeId: String,
    val toNodeId: String
)

package com.example.insight.graph

import androidx.compose.ui.geometry.Offset

data class KnowledgeNode(
    val id: String,
    val title: String,
    val masteryLevel: Float, // 0.0f to 1.0f
    val x: Float, // Canvas X
    val y: Float  // Canvas Y
)

data class KnowledgeEdge(
    val fromNodeId: String,
    val toNodeId: String
)

data class GraphState(
    val nodes: List<KnowledgeNode>,
    val edges: List<KnowledgeEdge>
)

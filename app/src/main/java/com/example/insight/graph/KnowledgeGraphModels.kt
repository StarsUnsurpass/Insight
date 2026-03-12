package com.example.insight.graph

import androidx.compose.ui.geometry.Offset

data class GraphNode(
    val id: String,
    val label: String,
    val initialOffset: Offset, // Normalized 0.0 to 1.0 within the viewport
    val weight: Float = 1.0f,    // Influences size
    val type: NodeType = NodeType.CONCEPT
)

data class GraphEdge(
    val fromId: String,
    val toId: String
)

enum class NodeType {
    CENTER,    // The current main topic
    CONCEPT,   // Related concepts
    PREREQUISITE // Foundational topics
}

data class GraphState(
    val nodes: List<GraphNode>,
    val edges: List<GraphEdge>
)

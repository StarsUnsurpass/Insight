package com.example.insight.graph

import androidx.compose.ui.geometry.Offset
import java.util.UUID
import kotlin.random.Random

data class GraphState(
    val nodes: List<KnowledgeNode>,
    val edges: List<KnowledgeEdge>
)

data class KnowledgeNode(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val level: Int,
    val parentId: String? = null,
    var isExpanded: Boolean = false,
    val masteryLevel: Float, // 0.0 to 1.0
    // Physics / Positions
    var x: Float = 0f,
    var y: Float = 0f,
    var targetX: Float = 0f,
    var targetY: Float = 0f,
    var vx: Float = 0f,
    var vy: Float = 0f,
    // Visual states
    var alpha: Float = 1f,
    var targetAlpha: Float = 1f
)

data class KnowledgeEdge(
    val fromNodeId: String,
    val toNodeId: String,
    var alpha: Float = 1f
)

// Represents the dynamic state of our interactive graph
class GraphController {
    val nodes = mutableListOf<KnowledgeNode>()
    val edges = mutableListOf<KnowledgeEdge>()
    var focusedNodeId: String? = null

    init {
        // Initialize with 5-8 root nodes
        val rootTitles = listOf("词法体系", "句法体系", "时态与语态", "阅读理解", "完形填空", "写作重构")
        val radius = 300f
        rootTitles.forEachIndexed { index, title ->
            val angle = index * (2 * Math.PI / rootTitles.size).toFloat()
            val tx = radius * kotlin.math.cos(angle)
            val ty = radius * kotlin.math.sin(angle)
            nodes.add(
                KnowledgeNode(
                    id = "root_$index",
                    title = title,
                    level = 0,
                    masteryLevel = Random.nextFloat() * 0.4f + 0.6f, // 0.6 - 1.0
                    x = 0f, y = 0f, // Start from center and animate out
                    targetX = tx, targetY = ty
                )
            )
        }
        // Build initial edges between adjacent roots just for visualization, or star shape
        // For progressive disclosure, roots don't need to be strictly connected to each other, but let's connect them to a hidden 'center' conceptually, or just leave them.
    }

    // Toggle expansion of a node
    fun toggleNodeExpansion(nodeId: String) {
        val node = nodes.find { it.id == nodeId } ?: return
        if (node.isExpanded) {
            // Collapse: remove all descendants
            collapseNode(nodeId)
            node.isExpanded = false
            focusedNodeId = null
            resetFocus()
        } else {
            // Expand: add children and set focus
            expandNode(node)
            node.isExpanded = true
            focusedNodeId = nodeId
            applyFocusMode(nodeId)
        }
    }

    private fun expandNode(parent: KnowledgeNode) {
        // Create 3-5 subnodes
        val childCount = kotlin.random.Random.nextInt(3, 6)
        val childRadius = 250f / (parent.level + 1)
        val parentAngle = kotlin.math.atan2(parent.targetY.toDouble(), parent.targetX.toDouble()).toFloat()
        
        for (i in 0 until childCount) {
            val childId = "${parent.id}_child_$i"
            val angleSpread = kotlin.math.PI.toFloat() * 0.8f
            val angle = parentAngle - (angleSpread / 2f) + (angleSpread / (childCount - 1).coerceAtLeast(1)) * i
            
            nodes.add(
                KnowledgeNode(
                    id = childId,
                    title = "子节点 ${i+1}",
                    level = parent.level + 1,
                    parentId = parent.id,
                    masteryLevel = kotlin.random.Random.nextFloat(),
                    x = parent.x, y = parent.y, // Start at parent
                    targetX = parent.targetX + childRadius * kotlin.math.cos(angle.toDouble()).toFloat(),
                    targetY = parent.targetY + childRadius * kotlin.math.sin(angle.toDouble()).toFloat()
                )
            )
            edges.add(KnowledgeEdge(fromNodeId = parent.id, toNodeId = childId))
        }
    }

    private fun collapseNode(nodeId: String) {
        val descendants = getDescendants(nodeId)
        nodes.removeAll { it.id in descendants }
        edges.removeAll { it.fromNodeId in descendants || it.toNodeId in descendants }
    }

    private fun getDescendants(nodeId: String): Set<String> {
        val children = nodes.filter { it.parentId == nodeId }.map { it.id }.toSet()
        val allDescendants = children.toMutableSet()
        children.forEach { allDescendants.addAll(getDescendants(it)) }
        return allDescendants
    }

    private fun applyFocusMode(nodeId: String) {
        // Find relatives (parent, children)
        val relatives = mutableSetOf(nodeId)
        val node = nodes.find { it.id == nodeId }
        if (node?.parentId != null) relatives.add(node.parentId)
        relatives.addAll(nodes.filter { it.parentId == nodeId }.map { it.id })

        nodes.forEach { 
            it.targetAlpha = if (it.id in relatives || it.id == nodeId) 1f else 0.2f 
        }
        edges.forEach {
            it.alpha = if (it.fromNodeId in relatives && it.toNodeId in relatives) 1f else 0.1f
        }
    }

    private fun resetFocus() {
        nodes.forEach { it.targetAlpha = 1f }
        edges.forEach { it.alpha = 1f }
    }

    // Physics step
    fun updatePhysics(dt: Float) {
        val stiffness = 50.0f // Faster snappier physics
        val damping = 0.42f // Quicker settling with minimal bounce

        nodes.forEach { node ->
            // Spring force towards target
            val fx = (node.targetX - node.x) * stiffness
            val fy = (node.targetY - node.y) * stiffness
            
            node.vx = (node.vx + fx * dt) * (1f - damping)
            node.vy = (node.vy + fy * dt) * (1f - damping)
            
            node.x = node.x + node.vx * dt
            node.y = node.y + node.vy * dt

            // Alpha easing - even faster fade
            node.alpha = node.alpha + (node.targetAlpha - node.alpha) * 20f * dt
        }
    }
}

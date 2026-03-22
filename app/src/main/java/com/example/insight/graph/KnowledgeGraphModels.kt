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
    var masteryLevel: Float, // 0.0 to 1.0
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
    
    // Virtual storage for all available data (to enable progressive disclosure)
    private var allNodesData: List<com.example.insight.data.local.entities.KnowledgeNodeEntity> = emptyList()
    private var allEdgesData: List<com.example.insight.data.local.entities.KnowledgeEdgeEntity> = emptyList()
    private var allMasteryData: List<com.example.insight.data.local.entities.StudentMasteryEntity> = emptyList()

    /**
     * Synchronize with real database data
     */
    fun syncWithData(
        dbNodes: List<com.example.insight.data.local.entities.KnowledgeNodeEntity>,
        dbEdges: List<com.example.insight.data.local.entities.KnowledgeEdgeEntity>,
        dbMastery: List<com.example.insight.data.local.entities.StudentMasteryEntity>
    ) {
        allNodesData = dbNodes
        allEdgesData = dbEdges
        allMasteryData = dbMastery

        if (nodes.isEmpty() && dbNodes.isNotEmpty()) {
            initInitialView()
        } else {
            // Update existing nodes with latest mastery
            nodes.forEach { node ->
                val mastery = dbMastery.find { it.nodeId == node.id }?.masteryScore ?: 60f
                node.masteryLevel = mastery / 100f
            }
        }
    }

    private fun initInitialView() {
        // Create virtual nodes for 3 categories as roots
        val categories = listOf(
            Triple("cat_1", "词法基础", 1),
            Triple("cat_2", "时态语态", 2),
            Triple("cat_3", "句法体系", 3)
        )
        
        val radius = 400f
        categories.forEachIndexed { index, (id, title, cat) ->
            val angle = index * (2 * Math.PI / categories.size).toFloat()
            val tx = radius * kotlin.math.cos(angle.toDouble()).toFloat()
            val ty = radius * kotlin.math.sin(angle.toDouble()).toFloat()
            
            val node = KnowledgeNode(
                id = id,
                title = title,
                level = 0,
                masteryLevel = 0.8f, // Categories represent progress
                x = 0f, y = 0f,
                targetX = tx, targetY = ty
            )
            nodes.add(node)
        }
    }

    fun toggleNodeExpansion(nodeId: String) {
        val node = nodes.find { it.id == nodeId } ?: return
        if (node.isExpanded) {
            collapseNode(nodeId)
            node.isExpanded = false
            focusedNodeId = null
            resetFocus()
        } else {
            expandNode(node)
            node.isExpanded = true
            focusedNodeId = nodeId
            applyFocusMode(nodeId)
        }
    }

    private fun expandNode(parent: KnowledgeNode) {
        if (parent.id.startsWith("cat_")) {
            // Expand category to show individual points
            val catId = parent.id.substringAfter("_").toInt()
            val childrenData = allNodesData.filter { it.category == catId }
            
            val childRadius = 300f
            val parentAngle = kotlin.math.atan2(parent.targetY.toDouble(), parent.targetX.toDouble()).toFloat()
            val spread = 1.2f // angle spread
            
            childrenData.forEachIndexed { i, data ->
                if (nodes.none { it.id == data.nodeId }) {
                    val angle = parentAngle - (spread/2f) + (spread / (childrenData.size.coerceAtLeast(2) - 1)) * i
                    val mastery = allMasteryData.find { it.nodeId == data.nodeId }?.masteryScore ?: 50f
                    
                    val childNode = KnowledgeNode(
                        id = data.nodeId,
                        title = data.title,
                        level = 1,
                        parentId = parent.id,
                        masteryLevel = mastery / 100f,
                        x = parent.x, y = parent.y,
                        targetX = parent.targetX + childRadius * kotlin.math.cos(angle.toDouble()).toFloat(),
                        targetY = parent.targetY + childRadius * kotlin.math.sin(angle.toDouble()).toFloat()
                    )
                    nodes.add(childNode)
                    edges.add(KnowledgeEdge(fromNodeId = parent.id, toNodeId = data.nodeId))
                }
            }
        } else {
            // Expand individual point to show its PREREQUISITES from DB
            val prerequisiteEdges = allEdgesData.filter { it.targetNodeId == parent.id }
            val childRadius = 250f
            val parentAngle = kotlin.math.atan2(parent.targetY.toDouble(), parent.targetX.toDouble()).toFloat()
            
            prerequisiteEdges.forEachIndexed { i, edge ->
                val sourceData = allNodesData.find { it.nodeId == edge.sourceNodeId } ?: return@forEachIndexed
                if (nodes.none { it.id == sourceData.nodeId }) {
                    val angle = parentAngle + (i + 1) * 0.8f // just offset a bit
                    val mastery = allMasteryData.find { it.nodeId == sourceData.nodeId }?.masteryScore ?: 50f
                    
                    val childNode = KnowledgeNode(
                        id = sourceData.nodeId,
                        title = sourceData.title,
                        level = parent.level + 1,
                        parentId = parent.id,
                        masteryLevel = mastery / 100f,
                        x = parent.x, y = parent.y,
                        targetX = parent.targetX + childRadius * kotlin.math.cos(angle.toDouble()).toFloat(),
                        targetY = parent.targetY + childRadius * kotlin.math.sin(angle.toDouble()).toFloat()
                    )
                    nodes.add(childNode)
                    edges.add(KnowledgeEdge(fromNodeId = parent.id, toNodeId = sourceData.nodeId))
                }
            }
        }
    }

    private fun collapseNode(nodeId: String) {
        val descendants = getDescendants(nodeId)
        nodes.removeAll { it.id in descendants }
        edges.removeAll { it.fromNodeId in descendants || it.toNodeId in descendants || it.toNodeId == nodeId && it.fromNodeId != nodeId }
        // Keep the edge from parent to this node
    }

    private fun getDescendants(nodeId: String): Set<String> {
        val children = nodes.filter { it.parentId == nodeId }.map { it.id }.toSet()
        val allDescendants = children.toMutableSet()
        children.forEach { allDescendants.addAll(getDescendants(it)) }
        return allDescendants
    }

    private fun applyFocusMode(nodeId: String) {
        val relatives = mutableSetOf(nodeId)
        // Add parent and children in visible graph
        val node = nodes.find { it.id == nodeId }
        if (node?.parentId != null) relatives.add(node.parentId!!)
        relatives.addAll(nodes.filter { it.parentId == nodeId }.map { it.id })
        
        // Also find DB prerequisites to highlight even if not expanded? 
        // No, let's stick to visible graph for focus, but maybe highlight the "path"
        
        nodes.forEach { 
            it.targetAlpha = if (it.id in relatives) 1f else 0.2f 
        }
        edges.forEach {
            it.alpha = if (it.fromNodeId in relatives && it.toNodeId in relatives) 1f else 0.1f
        }
    }

    private fun resetFocus() {
        nodes.forEach { it.targetAlpha = 1f }
        edges.forEach { it.alpha = 1f }
    }

    /**
     * BFS Pathfinding for "Shortest Learning Path"
     */
    fun findShortestPath(startNodeId: String, targetNodeId: String): List<String>? {
        val queue = mutableListOf(listOf(startNodeId))
        val visited = mutableSetOf(startNodeId)
        
        while (queue.isNotEmpty()) {
            val path = queue.removeAt(0)
            val current = path.last()
            
            if (current == targetNodeId) return path
            
            val nextNodes = allEdgesData
                .filter { it.sourceNodeId == current }
                .map { it.targetNodeId }
                
            for (next in nextNodes) {
                if (next !in visited) {
                    visited.add(next)
                    queue.add(path + next)
                }
            }
        }
        return null
    }

    fun updatePhysics(dt: Float) {
        val stiffness = 60.0f
        val damping = 0.45f

        nodes.forEach { node ->
            val fx = (node.targetX - node.x) * stiffness
            val fy = (node.targetY - node.y) * stiffness
            
            node.vx = (node.vx + fx * dt) * (1f - damping)
            node.vy = (node.vy + fy * dt) * (1f - damping)
            
            node.x += node.vx * dt
            node.y += node.vy * dt

            node.alpha += (node.targetAlpha - node.alpha) * 15f * dt
        }
    }
}

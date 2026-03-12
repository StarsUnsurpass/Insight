package com.example.insight.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.insight.graph.*
import com.example.insight.ui.theme.DeepVoid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KnowledgeGraphScreen(
    onClose: () -> Unit
) {
    // Mock data for the demonstration
    val mockGraph = GraphState(
        nodes = listOf(
            GraphNode("1", "虚拟语气", Offset(0.5f, 0.4f), 1.5f, NodeType.CENTER),
            GraphNode("2", "If 条件句", Offset(0.3f, 0.6f), 1.0f, NodeType.CONCEPT),
            GraphNode("3", "过去完成时", Offset(0.7f, 0.6f), 1.0f, NodeType.PREREQUISITE),
            GraphNode("4", "混合时态", Offset(0.5f, 0.8f), 1.2f, NodeType.CONCEPT),
            GraphNode("5", "wish 结构", Offset(0.2f, 0.3f), 0.8f, NodeType.CONCEPT)
        ),
        edges = listOf(
            GraphEdge("1", "2"),
            GraphEdge("1", "3"),
            GraphEdge("1", "4"),
            GraphEdge("2", "4"),
            GraphEdge("1", "5")
        )
    )

    Box(modifier = Modifier.fillMaxSize().background(DeepVoid)) {
        StarfieldComponent(
            graphState = mockGraph,
            modifier = Modifier.fillMaxSize()
        )

        // Overlay UI
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = { Text("知识星图 (Beta)", style = MaterialTheme.typography.titleLarge) },
                    actions = {
                        IconButton(onClick = onClose) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
                )
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                // Future metadata or card details
            }
        }
    }
}

package com.example.insight.ui.screens.analytics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.insight.ui.state.DailyActivity
import java.util.*

@Composable
fun LearningHeatmap(
    data: List<DailyActivity>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "过去 35 天学习分布",
                style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray)
            )
            Text(
                text = "🔥 7 天连击!",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = Color(0xFFFFA000),
                    fontWeight = FontWeight.Bold
                )
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))

        // 热力图矩阵
        BoxWithConstraints(modifier = Modifier.fillMaxWidth().height(120.dp)) {
            val cellSize = (maxWidth - 32.dp) / 7
            
            LazyHorizontalGrid(
                rows = GridCells.Fixed(7),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(data) { activity ->
                    Box(
                        modifier = Modifier
                            .size(cellSize - 4.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(getHeatmapColor(activity.intensity))
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // 图例
        Row(
            modifier = Modifier.align(Alignment.End),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("较少", style = MaterialTheme.typography.labelSmall.copy(color = Color.Gray))
            Spacer(modifier = Modifier.width(4.dp))
            listOf(0, 1, 2, 3, 4).forEach { level ->
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .padding(horizontal = 1.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(getHeatmapColor(level))
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Text("密集", style = MaterialTheme.typography.labelSmall.copy(color = Color.Gray))
        }
    }
}

private fun getHeatmapColor(intensity: Int): Color {
    return when (intensity) {
        0 -> Color.Black.copy(alpha = 0.05f)
        1 -> Color(0xFFC8E6C9)
        2 -> Color(0xFF81C784)
        3 -> Color(0xFF4CAF50)
        4 -> Color(0xFF2E7D32)
        else -> Color.Transparent
    }
}

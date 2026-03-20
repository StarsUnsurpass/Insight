package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.data.local.entities.DiagnosticReportEntity
import com.example.insight.data.local.entities.ScanRecordEntity
import com.example.insight.data.local.entities.StudentEntity
import com.example.insight.ui.theme.SageGreen
import com.example.insight.ui.util.MarkdownText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentDetailScreen(
    student: StudentEntity?,
    scans: List<ScanRecordEntity>,
    aiOutput: String,
    isStreaming: Boolean,
    onBack: () -> Unit,
    onAnalyze: () -> Unit
) {
    if (student == null) return

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(student.name, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = { /* Export Student Report */ }) {
                        Icon(Icons.Default.PictureAsPdf, null)
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // 1. Basic Info Header
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = student.name.take(1),
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Column {
                        Text(
                            text = "${student.age} 岁 | ${if (student.gender == 1) "男" else "女"}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                        Text(
                            text = student.className,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            color = SageGreen.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "最近分数: ${student.latestScore.toInt()}",
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelMedium,
                                color = SageGreen,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // 2. AI Insight Section
            item {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.AutoAwesome, null, tint = SageGreen, modifier = Modifier.size(20.dp))
                        @Suppress("DEPRECATION")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("AI 学情深度诊断", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(1f))
                        if (!isStreaming) {
                            TextButton(onClick = onAnalyze) {
                                Text("立即分析", style = MaterialTheme.typography.labelMedium, color = SageGreen)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = SageGreen.copy(alpha = 0.05f)),
                        border = BorderStroke(1.dp, SageGreen.copy(alpha = 0.1f)),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Box(modifier = Modifier.padding(20.dp)) {
                            if (isStreaming || aiOutput.isNotBlank()) {
                                MarkdownText(markdown = if (aiOutput.isNotBlank()) aiOutput else "DeepSeek 正在调取该生历史档案...", modifier = Modifier.fillMaxWidth())
                            } else {
                                Text("点击“立即分析”获取 DeepSeek 专属教学建议", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                            }
                        }
                    }
                }
            }

            // 3. Mistake Timeline
            item {
                Text("错题记录 (${scans.size})", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
            }

            items(scans) { scan ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.History, null, modifier = Modifier.size(14.dp), tint = Color.Gray)
                            @Suppress("DEPRECATION")
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "2024-03-15",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.Gray
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = scan.ocrText,
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 2,
                            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

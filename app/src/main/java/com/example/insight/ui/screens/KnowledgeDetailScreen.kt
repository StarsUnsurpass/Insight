package com.example.insight.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.data.model.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KnowledgeDetailScreen(
    nodeId: String,
    onBack: () -> Unit
) {
    val point = remember(nodeId) { KnowledgeProvider.getPoint(nodeId) } ?: return

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(point.title, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item {
                SectionHeader(title = "知识点详情", icon = Icons.Default.Info)
                DetailCard {
                    Text(
                        text = point.description,
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 24.sp
                    )
                }
            }

            item {
                SectionHeader(title = "关联知识点", icon = Icons.Default.Link)
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    mainAxisSpacing = 8.dp,
                    crossAxisSpacing = 8.dp
                ) {
                    point.relatedPoints.forEach { tag ->
                        SuggestionChip(
                            onClick = { },
                            label = { Text(tag) },
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                labelColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }
            }

            if (point.exampleProblems.isNotEmpty()) {
                item {
                    SectionHeader(title = "核心例题", icon = Icons.Default.Assignment)
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        point.exampleProblems.forEach { problem ->
                            ExampleProblemItem(
                                question = problem.question,
                                options = problem.options,
                                answer = problem.answer,
                                explanation = problem.explanation
                            )
                        }
                    }
                }
            }

            if (point.textbookParagraphs.isNotEmpty()) {
                item {
                    SectionHeader(title = "课本文章段落", icon = Icons.Default.AutoStories)
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        point.textbookParagraphs.forEach { paragraph ->
                            DetailCard {
                                Text(
                                    text = paragraph.content,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                                    fontFamily = FontFamily.Serif
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = paragraph.source,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }

            if (point.exampleSentences.isNotEmpty()) {
                item {
                    SectionHeader(title = "常用例句", icon = Icons.Default.Translate)
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        point.exampleSentences.forEach { sentence ->
                            ExampleSentenceItem(
                                english = sentence.english,
                                chinese = sentence.chinese
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SectionHeader(title: String, icon: ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun DetailCard(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            content()
        }
    }
}

@Composable
fun ExampleProblemItem(
    question: String,
    options: List<String>,
    answer: String,
    explanation: String
) {
    var showExplanation by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = question, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(12.dp))
            options.forEach { option ->
                Text(text = option, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (showExplanation) "答案: $answer" else "点击查看解析",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.clickable { showExplanation = !showExplanation }
                )
                IconButton(onClick = { showExplanation = !showExplanation }, modifier = Modifier.size(24.dp)) {
                    Icon(
                        imageVector = if (showExplanation) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            if (showExplanation) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "解析: $explanation",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun ExampleSentenceItem(english: String, chinese: String) {
    Column {
        Text(text = english, fontWeight = FontWeight.Medium, fontSize = 15.sp)
        Text(text = chinese, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    mainAxisSpacing: androidx.compose.ui.unit.Dp = 0.dp,
    crossAxisSpacing: androidx.compose.ui.unit.Dp = 0.dp,
    content: @Composable () -> Unit
) {
    androidx.compose.foundation.layout.FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(mainAxisSpacing),
        verticalArrangement = Arrangement.spacedBy(crossAxisSpacing)
    ) {
        content()
    }
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KnowledgeDetailScreen(
    nodeId: String,
    onBack: () -> Unit
) {
    // Mock data based on nodeId
    val title = when (nodeId) {
        "0" -> "定语从句"
        "1" -> "虚拟语气"
        "2" -> "分词结构"
        "3" -> "阅读理解"
        "4" -> "长难句"
        else -> nodeId
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title, fontWeight = FontWeight.Bold) },
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
                        text = "定语从句（Attributive Clause）是在复合句中修饰某一名词或代词的从句。被修饰的名词或代词叫做先行词，引导定语从句的词叫关系词。",
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
                    listOf("关系代词", "关系副词", "限制性定语从句", "非限制性定语从句", "先行词").forEach { tag ->
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

            item {
                SectionHeader(title = "核心例题", icon = Icons.Default.Assignment)
                ExampleProblemItem(
                    question = "This is the car ________ I bought last year.",
                    options = listOf("A. who", "B. whom", "C. which", "D. whose"),
                    answer = "C",
                    explanation = "which 引导定语从句，先行词 car 是物，且关系词在从句中充当宾语。"
                )
            }

            item {
                SectionHeader(title = "课本文章段落", icon = Icons.Default.AutoStories)
                DetailCard {
                    Text(
                        text = "The Great Wall, which is one of the eight wonders in the world, attracts millions of tourists every year.",
                        style = MaterialTheme.typography.bodyMedium,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "—— 摘自《九年级英语全一册》Unit 5",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Gray
                    )
                }
            }

            item {
                SectionHeader(title = "常用例句", icon = Icons.Default.Translate)
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    ExampleSentence(
                        english = "The man who is wearing a red hat is my uncle.",
                        chinese = "那个戴红帽子的男人是我叔叔。"
                    )
                    ExampleSentence(
                        english = "I still remember the day when we first met.",
                        chinese = "我仍然记得我们初次见面的那一天。"
                    )
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
                if (showExplanation) {
                    Icon(Icons.Default.ExpandLess, null)
                } else {
                    Icon(Icons.Default.ExpandMore, null)
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
fun ExampleSentence(english: String, chinese: String) {
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

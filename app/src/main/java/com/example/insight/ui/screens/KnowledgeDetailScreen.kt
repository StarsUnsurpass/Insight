package com.example.insight.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.insight.data.model.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KnowledgeDetailScreen(
    nodeId: String,
    onBack: () -> Unit
) {
    val point = remember(nodeId) { KnowledgeProvider.getPoint(nodeId) } ?: return
    
    var selectedRelatedPoint by remember { mutableStateOf<RelatedPoint?>(null) }
    var selectedSentenceAnalysis by remember { mutableStateOf<HighlightedSentence?>(null) }

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
            contentPadding = PaddingValues(bottom = 40.dp)
        ) {
            // 1. 知识点概览
            item {
                SectionHeader(title = "考纲要求", icon = Icons.Default.Assignment)
                DetailCard {
                    Text(
                        text = point.description,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    point.syllabusDetails.forEach { detail ->
                        Row(modifier = Modifier.padding(vertical = 4.dp)) {
                            Text("• ", fontWeight = FontWeight.Bold)
                            Text(text = detail, style = MaterialTheme.typography.bodyMedium, lineHeight = 22.sp)
                        }
                    }
                }
            }

            // 2. 关联知识点 (点击弹出)
            item {
                SectionHeader(title = "关联知识点", icon = Icons.Default.Link)
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    mainAxisSpacing = 8.dp,
                    crossAxisSpacing = 8.dp
                ) {
                    point.relatedPoints.forEach { rp ->
                        SuggestionChip(
                            onClick = { selectedRelatedPoint = rp },
                            label = { Text(rp.title) },
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                labelColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }
            }

            // 3. 中考真题 (按年份排序)
            if (point.pastExamQuestions.isNotEmpty()) {
                item {
                    SectionHeader(title = "近十年中考真题", icon = Icons.Default.AutoAwesome)
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        point.pastExamQuestions.forEach { question ->
                            PastExamQuestionItem(question)
                        }
                    }
                }
            }

            // 4. 核心例题
            if (point.exampleProblems.isNotEmpty()) {
                item {
                    SectionHeader(title = "经典模拟题", icon = Icons.Default.Quiz)
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

            // 5. 课本文章段落 (点击句子分析)
            if (point.textbookParagraphs.isNotEmpty()) {
                item {
                    SectionHeader(title = "课本文章段落", icon = Icons.Default.AutoStories)
                    point.textbookParagraphs.forEach { paragraph ->
                        TextbookParagraphCard(paragraph) { selectedSentenceAnalysis = it }
                    }
                }
            }

            // 6. 常用例句 (提升难度)
            if (point.exampleSentences.isNotEmpty()) {
                item {
                    SectionHeader(title = "高阶应用例句", icon = Icons.Default.Translate)
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        point.exampleSentences.forEach { sentence ->
                            DetailCard {
                                Text(text = sentence.english, fontWeight = FontWeight.Bold, fontSize = 16.sp, lineHeight = 24.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = sentence.chinese, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                                Spacer(modifier = Modifier.height(8.dp))
                                Surface(color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.3f), shape = RoundedCornerShape(4.dp)) {
                                    Text(text = sentence.difficulty, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.secondary)
                                }
                            }
                        }
                    }
                }
            }

            // 7. 授课与学情备忘 (新增)
            if (point.teachingNotes.isNotEmpty()) {
                item {
                    SectionHeader(title = "授课与学情备忘", icon = Icons.Default.Lightbulb)
                    DetailCard {
                        point.teachingNotes.forEach { note ->
                            Text(text = note.title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.secondary)
                            Text(text = note.content, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 4.dp, bottom = 12.dp), lineHeight = 22.sp)
                        }
                    }
                }
            }

            // 8. 名人名言
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.FormatQuote, null, tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), modifier = Modifier.size(48.dp))
                    Text(
                        text = point.famousQuote,
                        style = MaterialTheme.typography.titleMedium,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        lineHeight = 28.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "— ${point.quoteAuthor}",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }

    // 弹窗：关联知识点详情
    selectedRelatedPoint?.let { rp ->
        AlertDialog(
            onDismissRequest = { selectedRelatedPoint = null },
            title = { Text(text = "关联：${rp.title}", fontWeight = FontWeight.Bold) },
            text = {
                Column {
                    Text(text = rp.description, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "为什么关联？", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    Text(text = rp.connectionReason, style = MaterialTheme.typography.bodySmall)
                }
            },
            confirmButton = {
                TextButton(onClick = { selectedRelatedPoint = null }) { Text("知道了") }
            },
            shape = RoundedCornerShape(24.dp)
        )
    }

    // 弹窗：句子详细分析
    selectedSentenceAnalysis?.let { hs ->
        Dialog(onDismissRequest = { selectedSentenceAnalysis = null }) {
            Card(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Analytics, null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "深度句法分析", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = hs.text, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium, lineHeight = 24.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(color = MaterialTheme.colorScheme.outlineVariant)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = hs.analysis, style = MaterialTheme.typography.bodyMedium, lineHeight = 22.sp)
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { selectedSentenceAnalysis = null },
                        modifier = Modifier.align(Alignment.End),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("关闭")
                    }
                }
            }
        }
    }
}

@Composable
fun TextbookParagraphCard(paragraph: TextbookParagraph, onSentenceClick: (HighlightedSentence) -> Unit) {
    val annotatedString = buildAnnotatedString {
        val fullContent = paragraph.content
        append(fullContent)
        
        paragraph.highlightedSentences.forEach { hs ->
            val startIndex = fullContent.indexOf(hs.text)
            if (startIndex != -1) {
                addStyle(
                    style = SpanStyle(
                        background = Color.Yellow.copy(alpha = 0.3f),
                        fontWeight = FontWeight.Bold,
                        textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    start = startIndex,
                    end = startIndex + hs.text.length
                )
                addStringAnnotation(
                    tag = "ANALYSIS",
                    annotation = hs.text,
                    start = startIndex,
                    end = startIndex + hs.text.length
                )
            }
        }
    }

    DetailCard {
        ClickableText(
            text = annotatedString,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = FontFamily.Serif,
                lineHeight = 28.sp,
                color = MaterialTheme.colorScheme.onSurface
            ),
            onClick = { offset ->
                annotatedString.getStringAnnotations(tag = "ANALYSIS", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        paragraph.highlightedSentences.find { it.text == annotation.item }?.let {
                            onSentenceClick(it)
                        }
                    }
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = paragraph.source,
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "💡 点击黄色高亮句子查看深度分析",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary,
            fontStyle = FontStyle.Italic
        )
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
fun PastExamQuestionItem(examQuestion: PastExamQuestion) {
    var showExplanation by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = "真题",
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${examQuestion.year} · ${examQuestion.location}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = examQuestion.question, fontWeight = FontWeight.SemiBold, lineHeight = 22.sp)
            Spacer(modifier = Modifier.height(12.dp))
            examQuestion.options.forEach { option ->
                Text(text = option, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 2.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (showExplanation) "正确答案: ${examQuestion.answer}" else "查看深度解析",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
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
                Divider(color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f))
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = examQuestion.explanation,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 20.sp
                )
            }
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
                Text(text = option, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 2.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (showExplanation) "答案: $answer" else "查看解析",
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
                    text = "【解析】$explanation",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
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

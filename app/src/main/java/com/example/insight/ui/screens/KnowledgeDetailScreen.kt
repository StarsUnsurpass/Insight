package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
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
                title = { Text("📌 知识点名称：${point.title}", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "返回")
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
            // 1. 📖 知识点详解 (Core Explanation)
            item {
                Text("1. 📖 知识点详解 (Core Explanation)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(point.description, style = MaterialTheme.typography.bodyMedium, lineHeight = 24.sp)
                    }
                }
            }

            // 2. 📚 课本相关段落 (Textbook Mapping)
            if (point.textbookParagraphs.isNotEmpty()) {
                item {
                    Text("2. 📚 课本相关段落 (Textbook Mapping)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(12.dp))
                }
                
                items(point.textbookParagraphs) { paragraph ->
                    TextbookParagraphCard(paragraph) { selectedSentenceAnalysis = it }
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { /* TODO: Open PDF */ },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), contentColor = MaterialTheme.colorScheme.primary),
                        elevation = ButtonDefaults.buttonElevation(0.dp)
                    ) {
                        Icon(Icons.Default.PictureAsPdf, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("点击直接打开对应的电子课本扫描件")
                    }
                }
            }

            // 3. 💬 经典例句 (Example Sentences)
            if (point.exampleSentences.isNotEmpty()) {
                item {
                    Text("3. 💬 经典例句 (Example Sentences)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(12.dp))
                }
                
                items(point.exampleSentences) { sentence ->
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            Column {
                                Text(sentence.english, fontWeight = FontWeight.Bold, fontSize = 16.sp, lineHeight = 24.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(sentence.chinese, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                                
                                sentence.analysis?.let { analysis ->
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Surface(
                                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f),
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                                    ) {
                                        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.Top) {
                                            Icon(Icons.Default.Analytics, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(18.dp))
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(analysis, style = MaterialTheme.typography.bodySmall, lineHeight = 20.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 4. 🔗 关联知识点 (Knowledge Graph Links)
            if (point.relatedPoints.isNotEmpty()) {
                item {
                    Text("4. 🔗 关联知识点 (Knowledge Graph Links)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(12.dp))
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            point.relatedPoints.forEach { rp ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.clickable { selectedRelatedPoint = rp }
                                ) {
                                    Text("👉 ", fontSize = 16.sp)
                                    Text(
                                        text = rp.title, 
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Medium,
                                        textDecoration = TextDecoration.Underline
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 5. 📝 近十年相关中考真题 (10-Year Real Exam Questions)
            if (point.pastExamQuestions.isNotEmpty()) {
                item {
                    Text("5. 📝 近十年相关中考真题 (10-Year Real Exam Questions)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("(这里应该是一个可互动的题库列表，默认隐藏答案)", style = MaterialTheme.typography.labelMedium, color = Color.Gray)
                    Spacer(modifier = Modifier.height(12.dp))
                }
                
                items(point.pastExamQuestions) { question ->
                    PastExamQuestionItem(question)
                }
            }

            // 6. 💡 授课与学情备忘 (Teaching & Insight Notes)
            if (point.teachingNotes.isNotEmpty()) {
                item {
                    Text("6. 💡 授课与学情备忘 (Teaching & Insight Notes)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("(这是一个非常有价值的专属板块，平时供备课参考，诊断时供调用)", style = MaterialTheme.typography.labelMedium, color = Color.Gray)
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.2f)),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            point.teachingNotes.forEach { note ->
                                Column {
                                    Text(note.title + "：", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.secondary)
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(note.content, style = MaterialTheme.typography.bodyMedium, lineHeight = 24.sp)
                                }
                            }
                        }
                    }
                }
            }

            // 7. 名人名言
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
            title = { Text(text = "🔗 关联知识点：${rp.title}", fontWeight = FontWeight.Bold) },
            text = {
                Column {
                    Text(text = rp.description, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "💡 进阶关联：为什么关联？", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = rp.connectionReason, style = MaterialTheme.typography.bodySmall, lineHeight = 22.sp)
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
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
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
                        textDecoration = TextDecoration.Underline,
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

    Surface(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
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
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "💡 提示：点击黄色高亮句子查看深度分析",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Composable
fun PastExamQuestionItem(examQuestion: PastExamQuestion) {
    var showExplanation by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "[${examQuestion.year}·${examQuestion.location}]",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(text = "题目：\n${examQuestion.question}", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium, lineHeight = 22.sp)
            Spacer(modifier = Modifier.height(12.dp))
            
            val optionsText = examQuestion.options.joinToString("   ")
            Text(text = optionsText, style = MaterialTheme.typography.bodyMedium)
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showExplanation = !showExplanation }
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (showExplanation) "隐藏解析" else "点击查看深度解析",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = if (showExplanation) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            
            AnimatedVisibility(visible = showExplanation) {
                Column {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Text(
                        text = examQuestion.explanation,
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 22.sp
                    )
                    
                    examQuestion.errorProne?.let { errorProne ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            color = Color.Red.copy(alpha = 0.05f),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Red.copy(alpha = 0.1f))
                        ) {
                            Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.Top) {
                                Icon(Icons.Default.Warning, contentDescription = null, tint = Color.Red.copy(alpha = 0.8f), modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("易错点：$errorProne", style = MaterialTheme.typography.bodySmall, color = Color.Red.copy(alpha = 0.8f), lineHeight = 20.sp)
                            }
                        }
                    }

                    examQuestion.translation?.let { translation ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f))
                        ) {
                            Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.Top) {
                                Icon(Icons.Default.Translate, contentDescription = null, tint = MaterialTheme.colorScheme.secondary, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("翻译：$translation", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, lineHeight = 20.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}

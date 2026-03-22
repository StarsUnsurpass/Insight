package com.example.insight.ui.screens

import android.widget.TextView
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
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import com.example.insight.data.model.*
import io.noties.markwon.Markwon
import io.noties.markwon.ext.tables.TablePlugin
import io.noties.markwon.html.HtmlPlugin
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.insight.ui.state.KnowledgeStatus
import com.example.insight.ui.theme.SageGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KnowledgeDetailScreen(
    nodeId: String,
    currentStatus: KnowledgeStatus,
    onStatusChange: (KnowledgeStatus) -> Unit,
    onBack: () -> Unit
) {
    val haptic = LocalHapticFeedback.current
    val point = remember(nodeId) { KnowledgeProvider.getPoint(nodeId) } ?: return
    
    var selectedRelatedPoint by remember { mutableStateOf<RelatedPoint?>(null) }
    var selectedSentenceAnalysis by remember { mutableStateOf<HighlightedSentence?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(point.title, fontWeight = FontWeight.Bold) },
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
            // 📌 核心标题与状态切换
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f)),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("📌", fontSize = 24.sp)
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("知识点名称", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                                Text(point.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.ExtraBold)
                            }
                        }
                        
                        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                        
                        Text("当前进度学习状态 (Learning Status)", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.secondary)
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            KnowledgeStatus.values().forEach { status ->
                                val isSelected = currentStatus == status
                                val color = when(status) {
                                    KnowledgeStatus.TO_REVIEW -> Color(0xFFE57373)
                                    KnowledgeStatus.PRACTICING -> Color(0xFFFFB74D)
                                    KnowledgeStatus.COMPLETED -> SageGreen
                                }
                                
                                OutlinedCard(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable { 
                                            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                                            onStatusChange(status) 
                                        },
                                    colors = CardDefaults.outlinedCardColors(
                                        containerColor = if (isSelected) color.copy(alpha = 0.15f) else Color.Transparent,
                                    ),
                                    border = BorderStroke(1.5.dp, if (isSelected) color else MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Box(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp), contentAlignment = Alignment.Center) {
                                        Text(
                                            status.label,
                                            style = MaterialTheme.typography.labelMedium,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                            color = if (isSelected) color else MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 1. 📋 考纲要求 (ORDER: FIRST)
            if (point.syllabusDetails.isNotEmpty()) {
                item {
                    SectionHeader(title = "1. 📋 考纲要求 (Syllabus Requirements)", icon = Icons.AutoMirrored.Filled.ListAlt)
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            point.syllabusDetails.forEach { detail ->
                                Row(verticalAlignment = Alignment.Top) {
                                    Text("• ", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(top = 2.dp))
                                    MarkdownText(
                                        markdown = detail, 
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 2. 📖 知识点详解 (Markdown Rendering)
            item {
                SectionHeader(title = "2. 📖 知识点详解 (Core Explanation)", icon = Icons.AutoMirrored.Filled.Assignment)
                MarkdownText(
                    markdown = point.description,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                )
            }

            // 3. 📚 课本相关段落
            if (point.textbookParagraphs.isNotEmpty()) {
                item {
                    SectionHeader(title = "3. 📚 课本相关段落 (Textbook Mapping)", icon = Icons.Default.AutoStories)
                }
                
                items(point.textbookParagraphs) { paragraph ->
                    TextbookParagraphCard(paragraph) { selectedSentenceAnalysis = it }
                }

                item {
                    Button(
                        onClick = { /* TODO: Open PDF */ },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), contentColor = MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.PictureAsPdf, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("查看电子课本原件")
                    }
                }
            }

            // 4. 💬 经典例句 (With Analysis)
            if (point.exampleSentences.isNotEmpty()) {
                item {
                    SectionHeader(title = "4. 💬 经典例句 (Example Sentences)", icon = Icons.Default.Translate)
                }
                
                items(point.exampleSentences) { sentence ->
                    ExampleSentenceCard(sentence)
                }
            }

            // 5. 🔗 关联知识点 (Detailed Analysis)
            if (point.relatedPoints.isNotEmpty()) {
                item {
                    SectionHeader(title = "5. 🔗 关联知识点 (Knowledge Links)", icon = Icons.Default.Link)
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            point.relatedPoints.forEach { rp ->
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { selectedRelatedPoint = rp }
                                        .padding(8.dp)
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.Link, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(16.dp))
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = rp.title, 
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = MaterialTheme.colorScheme.primary,
                                            fontWeight = FontWeight.Bold,
                                            textDecoration = TextDecoration.Underline
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(rp.description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f), maxLines = 1)
                                }
                            }
                        }
                    }
                }
            }

            // 6. 📝 近十年相关中考真题
            if (point.pastExamQuestions.isNotEmpty()) {
                item {
                    SectionHeader(title = "6. 📝 近十年相关中考真题 (Real Exam Questions)", icon = Icons.Default.Quiz)
                }
                
                items(point.pastExamQuestions) { question ->
                    PastExamQuestionItem(question)
                }
            }

            // 7. 💡 授课与学情备忘
            if (point.teachingNotes.isNotEmpty()) {
                item {
                    SectionHeader(title = "7. 💡 授课与学情备忘 (Teaching Notes)", icon = Icons.Default.Lightbulb)
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.2f)),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            point.teachingNotes.forEach { note ->
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Box(modifier = Modifier.size(8.dp).background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(2.dp)))
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(note.title, fontWeight = FontWeight.ExtraBold, color = MaterialTheme.colorScheme.secondary, style = MaterialTheme.typography.titleSmall)
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    MarkdownText(markdown = note.content, modifier = Modifier.fillMaxWidth())
                                }
                            }
                        }
                    }
                }
            }

            // 🌟 名人名言
            item {
                Spacer(modifier = Modifier.height(16.dp))
                FamousQuoteCard(point.famousQuote, point.quoteAuthor, point.quoteTranslation)
            }
        }
    }

    // 弹窗逻辑
    selectedRelatedPoint?.let { rp ->
        RelatedPointDialog(rp) { selectedRelatedPoint = null }
    }

    selectedSentenceAnalysis?.let { hs ->
        SentenceAnalysisDialog(hs) { selectedSentenceAnalysis = null }
    }
}

@Composable
fun MarkdownText(markdown: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val markwon = remember {
        Markwon.builder(context)
            .usePlugin(HtmlPlugin.create())
            .usePlugin(TablePlugin.create(context))
            .build()
    }

    AndroidView(
        factory = { ctx ->
            TextView(ctx).apply {
                textSize = 16f
                setLineSpacing(0f, 1.4f)
                setTextColor(android.graphics.Color.DKGRAY)
            }
        },
        update = { view ->
            // Markwon needs the text to be correctly escaped for actual newlines
            var cleanMarkdown = markdown.replace("\\n", "\n")
            
            // Format inline numbered lists (e.g. "1. xxx 2. yyy") to separate paragraphs
            cleanMarkdown = cleanMarkdown.replace(Regex("([^\\n])\\s*(?=\\d+\\.(?!\\d))"), "$1\n\n")
            
            markwon.setMarkdown(view, cleanMarkdown)
        },
        modifier = modifier
    )
}

@Composable
fun SectionHeader(title: String, icon: ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
    ) {
        Icon(icon, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
    }
}

@Composable
fun TextbookParagraphCard(paragraph: TextbookParagraph, onSentenceClick: (HighlightedSentence) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
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
                        addStringAnnotation(tag = "ANALYSIS", annotation = hs.text, start = startIndex, end = startIndex + hs.text.length)
                    }
                }
            }

            ClickableText(
                text = annotatedString,
                style = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Serif, lineHeight = 28.sp, color = MaterialTheme.colorScheme.onSurface),
                onClick = { offset ->
                    annotatedString.getStringAnnotations("ANALYSIS", offset, offset).firstOrNull()?.let { ann ->
                        paragraph.highlightedSentences.find { it.text == ann.item }?.let { onSentenceClick(it) }
                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("💡 点击高亮部分查看语法剖析", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.secondary, fontStyle = FontStyle.Italic)
                Text(paragraph.source, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            }
        }
    }
}

@Composable
fun ExampleSentenceCard(sentence: ExampleSentence) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(sentence.english, fontWeight = FontWeight.Bold, fontSize = 17.sp, lineHeight = 24.sp)
            Text(sentence.chinese, style = MaterialTheme.typography.bodyMedium, color = Color.Gray, modifier = Modifier.padding(top = 4.dp))
            
            sentence.analysis?.let { analysis ->
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.Top) {
                        Icon(Icons.Default.Analytics, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        MarkdownText(markdown = analysis, modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}

@Composable
fun FamousQuoteCard(quote: String, author: String, translation: String) {
    if (quote.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Default.FormatQuote, null, tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), modifier = Modifier.size(48.dp))
            Text(
                text = quote,
                style = MaterialTheme.typography.titleMedium,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                lineHeight = 28.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "— $author", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
            
            if (translation.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f))
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = translation,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun RelatedPointDialog(rp: RelatedPoint, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(rp.title, fontWeight = FontWeight.Bold) },
        text = {
            Column {
                MarkdownText(markdown = rp.description)
                Spacer(modifier = Modifier.height(16.dp))
                Text("💡 关联逻辑：", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                MarkdownText(markdown = rp.connectionReason)
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text("知道了") } },
        shape = RoundedCornerShape(24.dp)
    )
}

@Composable
fun SentenceAnalysisDialog(hs: HighlightedSentence, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text("深度句法分析", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(16.dp))
                Text(hs.text, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(16.dp))
                MarkdownText(markdown = hs.analysis, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = onDismiss, modifier = Modifier.align(Alignment.End)) { Text("确认") }
            }
        }
    }
}

@Composable
fun PastExamQuestionItem(examQuestion: PastExamQuestion) {
    var showExplanation by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("[${examQuestion.year}·${examQuestion.location}]", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(8.dp))
            Text(examQuestion.question, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium, lineHeight = 24.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Text(examQuestion.options.joinToString("   "), style = MaterialTheme.typography.bodyMedium)
            
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth().clickable { showExplanation = !showExplanation }.padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(if (showExplanation) "收起解析" else "点击查看深度解析", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
                Icon(if (showExplanation) Icons.Default.ExpandLess else Icons.Default.ExpandMore, null, tint = MaterialTheme.colorScheme.primary)
            }
            
            AnimatedVisibility(visible = showExplanation) {
                Column {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                    MarkdownText(markdown = examQuestion.explanation, modifier = Modifier.fillMaxWidth())
                    
                    examQuestion.errorProne?.let {
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(color = Color.Red.copy(alpha = 0.05f), shape = RoundedCornerShape(8.dp), border = BorderStroke(1.dp, Color.Red.copy(alpha = 0.1f))) {
                            MarkdownText(markdown = "**⚠️ 易错点**：$it", modifier = Modifier.padding(12.dp))
                        }
                    }
                    
                    examQuestion.translation?.let {
                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.3f), shape = RoundedCornerShape(8.dp)) {
                            MarkdownText(markdown = "**🌐 翻译**：$it", modifier = Modifier.padding(12.dp))
                        }
                    }
                }
            }
        }
    }
}

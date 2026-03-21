package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                title = { Text("📌 知识点名称：${point.title}", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "返回")
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
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            point.textbookParagraphs.forEach { paragraph ->
                                Text("出处同步：${paragraph.source}", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 8.dp))
                            }
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
                }
            }

            // 3. 💬 经典例句 (Example Sentences)
            if (point.exampleSentences.isNotEmpty()) {
                item {
                    Text("3. 💬 经典例句 (Example Sentences)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(12.dp))
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            point.exampleSentences.forEach { sentence ->
                                Column {
                                    Text(sentence.english, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                    Text(sentence.chinese, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
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
                                    modifier = Modifier.clickable { /* TODO: Navigate to related point */ }
                                ) {
                                    Text("👉 ", fontSize = 16.sp)
                                    Text(
                                        text = "${rp.title}：[${rp.description}] (点击跳转)", 
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Medium
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
                    
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        point.pastExamQuestions.forEachIndexed { index, question ->
                            PastExamQuestionItem(index + 1, question)
                        }
                    }
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
        }
    }
}

@Composable
fun PastExamQuestionItem(index: Int, examQuestion: PastExamQuestion) {
    var showExplanation by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "真题 $index [${examQuestion.year}·${examQuestion.location}]",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(text = "题目：${examQuestion.question}", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium, lineHeight = 22.sp)
            Spacer(modifier = Modifier.height(8.dp))
            
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
                    text = if (showExplanation) "隐藏解析" else "点击查看解析",
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
                        text = "解析：${examQuestion.explanation}",
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 22.sp
                    )
                }
            }
        }
    }
}

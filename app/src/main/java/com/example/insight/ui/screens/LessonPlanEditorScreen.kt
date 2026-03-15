package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import com.example.insight.data.local.entities.LessonPlanEntity
import com.example.insight.data.local.entities.ScanRecordEntity
import com.example.insight.ui.theme.SageGreen
import com.example.insight.ui.util.MarkdownText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonPlanEditorScreen(
    plan: LessonPlanEntity?,
    aiOutput: String,
    @Suppress("UNUSED_PARAMETER") isStreaming: Boolean,
    onBack: () -> Unit,
    onSave: (String, String, String) -> Unit,
    onGenerateAi: (String) -> Unit
) {
    var title by remember { mutableStateOf(plan?.title ?: "") }
    var content by remember { mutableStateOf(plan?.contentMarkdown ?: "") }
    var targetClass by remember { mutableStateOf(plan?.targetClassName ?: "") }
    var showAiDialog by remember { mutableStateOf(false) }
    var isPreviewMode by remember { mutableStateOf(false) }

    // Sync AI output to content when streaming finishes or during streaming
    LaunchedEffect(aiOutput) {
        if (aiOutput.isNotBlank()) {
            content = aiOutput
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (plan == null) "新建教案" else "编辑教案", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, null) }
                },
                actions = {
                    IconButton(onClick = { isPreviewMode = !isPreviewMode }) {
                        Icon(if (isPreviewMode) Icons.Default.Edit else Icons.Default.Visibility, null)
                    }
                    IconButton(onClick = { onSave(title, content, targetClass) }) {
                        Icon(Icons.Default.Save, null, tint = MaterialTheme.colorScheme.primary)
                    }
                }
            )
        },
        floatingActionButton = {
            if (!isPreviewMode) {
                FloatingActionButton(
                    onClick = { showAiDialog = true },
                    containerColor = SageGreen,
                    contentColor = Color.White
                ) {
                    Icon(Icons.Default.AutoAwesome, null)
                }
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            if (isPreviewMode) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        Text(title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                        Text("适用班级: $targetClass", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                        Spacer(modifier = Modifier.height(16.dp))
                        MarkdownText(markdown = content, modifier = Modifier.fillMaxWidth())
                    }
                }
            } else {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("教案标题") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = targetClass,
                    onValueChange = { targetClass = it },
                    label = { Text("适用班级") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("教案内容 (Markdown)") },
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    placeholder = { Text("在此输入教案内容或使用 AI 生成...") }
                )
            }
        }
    }

    if (showAiDialog) {
        var prompt by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showAiDialog = false },
            title = { Text("AI 智能备课") },
            text = {
                Column {
                    Text("描述你想生成的教案主题、核心语法点或教学环节：", style = MaterialTheme.typography.bodySmall)
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = prompt,
                        onValueChange = { prompt = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("例如：初一英语现在完成时讲解，包含3个例句...") }
                    )
                }
            },
            confirmButton = {
                Button(onClick = { 
                    onGenerateAi(prompt)
                    showAiDialog = false
                }) { Text("生成教案") }
            },
            dismissButton = {
                TextButton(onClick = { showAiDialog = false }) { Text("取消") }
            }
        )
    }
}

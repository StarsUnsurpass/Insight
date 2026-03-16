package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.data.local.entities.LessonPlanEntity
import com.example.insight.data.local.entities.ScanRecordEntity
import com.example.insight.data.local.entities.KnowledgeNodeEntity
import com.example.insight.ui.theme.SageGreen
import com.example.insight.ui.theme.HighlightYellow
import com.example.insight.ui.util.MarkdownText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import java.util.UUID

data class LessonBlock(
    val id: String = UUID.randomUUID().toString(),
    val type: String, // 导入, 呈现, 练习, 产出, 总结, 自定义
    val content: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonPlanEditorScreen(
    plan: LessonPlanEntity?,
    aiOutput: String,
    isStreaming: Boolean,
    allKnowledgeNodes: List<KnowledgeNodeEntity> = emptyList(),
    allQuestions: List<ScanRecordEntity> = emptyList(),
    onBack: () -> Unit,
    onSave: (String, String, String, String?, String, String, String, String) -> Unit,
    onGenerateAi: (String) -> Unit
) {
    val gson = remember { Gson() }
    
    var title by remember { mutableStateOf(plan?.title ?: "") }
    var targetClass by remember { mutableStateOf(plan?.targetClassName ?: "") }
    var lessonType by remember { mutableStateOf(plan?.lessonType ?: "听说课") }
    var keyPoints by remember { mutableStateOf(plan?.keyPoints ?: "") }
    var difficulties by remember { mutableStateOf(plan?.difficulties ?: "") }
    
    val initialBlocks = remember(plan) {
        if (plan != null && plan.blocksJson.isNotBlank() && plan.blocksJson != "[]") {
            try {
                val type = object : TypeToken<List<LessonBlock>>() {}.type
                gson.fromJson<List<LessonBlock>>(plan.blocksJson, type)
            } catch (e: Exception) {
                listOf(
                    LessonBlock(type = "导入"),
                    LessonBlock(type = "呈现"),
                    LessonBlock(type = "练习"),
                    LessonBlock(type = "产出"),
                    LessonBlock(type = "总结")
                )
            }
        } else {
            listOf(
                LessonBlock(type = "导入"),
                LessonBlock(type = "呈现"),
                LessonBlock(type = "练习"),
                LessonBlock(type = "产出"),
                LessonBlock(type = "总结")
            )
        }
    }
    
    var blocks by remember { mutableStateOf(initialBlocks) }
    var showAiDialog by remember { mutableStateOf(false) }
    var isPreviewMode by remember { mutableStateOf(false) }
    
    // For linking
    var selectedNodeId by remember { mutableStateOf(plan?.relatedKnowledgeNodeId) }
    var showNodeLinker by remember { mutableStateOf(false) }
    var showQuestionLinker by remember { mutableStateOf(false) }

    // Auto-save logic (simplified)
    LaunchedEffect(title, targetClass, lessonType, keyPoints, difficulties, blocks, selectedNodeId) {
        if (title.isNotBlank()) {
            delay(2000) // Debounce
            // In a real app, we'd call onSave here for auto-save
        }
    }

    // Handle AI output
    LaunchedEffect(aiOutput) {
        if (aiOutput.isNotBlank() && !isStreaming) {
            // If AI generated something, maybe append it to a "Custom" block or prompt user
            // For now, we'll just add it as a new block if it's fresh
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (plan == null) "新建教案" else "编辑教案", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, null) }
                },
                actions = {
                    IconButton(onClick = { isPreviewMode = !isPreviewMode }) {
                        Icon(if (isPreviewMode) Icons.Default.Edit else Icons.Default.Visibility, null)
                    }
                    IconButton(onClick = { 
                        val blocksJson = gson.toJson(blocks)
                        val contentMarkdown = buildMarkdown(title, lessonType, targetClass, keyPoints, difficulties, blocks)
                        onSave(title, contentMarkdown, targetClass, selectedNodeId, lessonType, keyPoints, difficulties, blocksJson) 
                    }) {
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
        if (isPreviewMode) {
            val contentMarkdown = buildMarkdown(title, lessonType, targetClass, keyPoints, difficulties, blocks)
            PreviewMode(padding, title, targetClass, contentMarkdown)
        } else {
            EditorMode(
                padding = padding,
                title = title, onTitleChange = { title = it },
                targetClass = targetClass, onTargetClassChange = { targetClass = it },
                lessonType = lessonType, onLessonTypeChange = { lessonType = it },
                keyPoints = keyPoints, onKeyPointsChange = { keyPoints = it },
                difficulties = difficulties, onDifficultiesChange = { difficulties = it },
                blocks = blocks,
                onBlockChange = { index, newContent ->
                    val newList = blocks.toMutableList()
                    newList[index] = newList[index].copy(content = newContent)
                    blocks = newList
                },
                onAddBlock = {
                    blocks = blocks + LessonBlock(type = "自定义")
                },
                onRemoveBlock = { index ->
                    if (blocks.size > 1) {
                        blocks = blocks.toMutableList().apply { removeAt(index) }
                    }
                },
                onMoveBlock = { index, up ->
                    val newList = blocks.toMutableList()
                    if (up && index > 0) {
                        val temp = newList[index]
                        newList[index] = newList[index - 1]
                        newList[index - 1] = temp
                    } else if (!up && index < blocks.size - 1) {
                        val temp = newList[index]
                        newList[index] = newList[index + 1]
                        newList[index + 1] = temp
                    }
                    blocks = newList
                },
                selectedNodeId = selectedNodeId,
                onLinkNode = { showNodeLinker = true },
                onLinkQuestion = { showQuestionLinker = true }
            )
        }
    }

    if (showAiDialog) {
        AiDialog(onDismiss = { showAiDialog = false }, onConfirm = onGenerateAi)
    }
    
    if (showNodeLinker) {
        NodeLinkerSheet(
            nodes = allKnowledgeNodes,
            selectedNodeId = selectedNodeId,
            onNodeSelected = { 
                selectedNodeId = it
                showNodeLinker = false
            },
            onDismiss = { showNodeLinker = false }
        )
    }

    if (showQuestionLinker) {
        QuestionLinkerSheet(
            questions = allQuestions,
            onQuestionSelected = { question ->
                // Insert question text or link into the current block? 
                // For now, let's just append to the last block or current focused one.
                val lastIndex = blocks.size - 1
                if (lastIndex >= 0) {
                    val newList = blocks.toMutableList()
                    val insertion = "\n\n> **[插入题目]**\n> ${question.ocrText}\n"
                    newList[lastIndex] = newList[lastIndex].copy(content = newList[lastIndex].content + insertion)
                    blocks = newList
                }
                showQuestionLinker = false
            },
            onDismiss = { showQuestionLinker = false }
        )
    }
}

@Composable
fun PreviewMode(padding: PaddingValues, title: String, targetClass: String, content: String) {
    LazyColumn(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
        item {
            Text(title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("适用班级: $targetClass", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            MarkdownText(markdown = content, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun EditorMode(
    padding: PaddingValues,
    title: String, onTitleChange: (String) -> Unit,
    targetClass: String, onTargetClassChange: (String) -> Unit,
    lessonType: String, onLessonTypeChange: (String) -> Unit,
    keyPoints: String, onKeyPointsChange: (String) -> Unit,
    difficulties: String, onDifficultiesChange: (String) -> Unit,
    blocks: List<LessonBlock>,
    onBlockChange: (Int, String) -> Unit,
    onAddBlock: () -> Unit,
    onRemoveBlock: (Int) -> Unit,
    onMoveBlock: (Int, Boolean) -> Unit,
    selectedNodeId: String?,
    onLinkNode: () -> Unit,
    onLinkQuestion: () -> Unit
) {
    LazyColumn(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
        item {
            // Header Section
            MetadataHeader(
                title, onTitleChange,
                targetClass, onTargetClassChange,
                lessonType, onLessonTypeChange,
                keyPoints, onKeyPointsChange,
                difficulties, onDifficultiesChange,
                selectedNodeId, onLinkNode
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            Text("教学环节", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = SageGreen)
            Spacer(modifier = Modifier.height(8.dp))
        }

        itemsIndexed(blocks) { index, block ->
            BlockItem(
                index = index,
                block = block,
                onContentChange = { onBlockChange(index, it) },
                onRemove = { onRemoveBlock(index) },
                onMoveUp = { onMoveBlock(index, true) },
                onMoveDown = { onMoveBlock(index, false) },
                isFirst = index == 0,
                isLast = index == blocks.size - 1,
                onLinkQuestion = onLinkQuestion
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Button(
                onClick = onAddBlock,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = SageGreen.copy(alpha = 0.1f), contentColor = SageGreen),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.Add, null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("添加教学环节")
            }
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun MetadataHeader(
    title: String, onTitleChange: (String) -> Unit,
    targetClass: String, onTargetClassChange: (String) -> Unit,
    lessonType: String, onLessonTypeChange: (String) -> Unit,
    keyPoints: String, onKeyPointsChange: (String) -> Unit,
    difficulties: String, onDifficultiesChange: (String) -> Unit,
    selectedNodeId: String?,
    onLinkNode: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = title,
                onValueChange = onTitleChange,
                label = { Text("教案标题") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
            )
            Spacer(modifier = Modifier.height(12.dp))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = targetClass,
                    onValueChange = onTargetClassChange,
                    label = { Text("适用班级") },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
                )
                
                var expanded by remember { mutableStateOf(false) }
                Box(modifier = Modifier.weight(1f)) {
                    OutlinedTextField(
                        value = lessonType,
                        onValueChange = { },
                        label = { Text("课型") },
                        readOnly = true,
                        modifier = Modifier.fillMaxWidth().clickable { expanded = true },
                        shape = RoundedCornerShape(12.dp),
                        trailingIcon = { IconButton(onClick = { expanded = true }) { Icon(Icons.Default.ArrowDropDown, null) } },
                        colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
                    )
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        listOf("听说课", "阅读课", "语法课", "复习课", "测试课").forEach { type ->
                            DropdownMenuItem(text = { Text(type) }, onClick = { onLessonTypeChange(type); expanded = false })
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            OutlinedTextField(
                value = keyPoints,
                onValueChange = onKeyPointsChange,
                label = { Text("教学重点") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text("例如：掌握定语从句...") },
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            OutlinedTextField(
                value = difficulties,
                onValueChange = onDifficultiesChange,
                label = { Text("教学难点") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text("例如：区分 who 和 which...") },
                colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White)
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Button(
                onClick = onLinkNode,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = HighlightYellow.copy(alpha = 0.2f), contentColor = Color(0xFFB8860B)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.Link, null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(if (selectedNodeId == null) "关联知识图谱节点" else "已关联: $selectedNodeId")
            }
        }
    }
}

@Composable
fun BlockItem(
    index: Int,
    block: LessonBlock,
    onContentChange: (String) -> Unit,
    onRemove: () -> Unit,
    onMoveUp: () -> Unit,
    onMoveDown: () -> Unit,
    isFirst: Boolean,
    isLast: Boolean,
    onLinkQuestion: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    color = SageGreen.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "${index + 1}. ${block.type}",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        color = SageGreen,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                
                IconButton(onClick = onMoveUp, enabled = !isFirst) { Icon(Icons.Default.ArrowUpward, null, modifier = Modifier.size(16.dp)) }
                IconButton(onClick = onMoveDown, enabled = !isLast) { Icon(Icons.Default.ArrowDownward, null, modifier = Modifier.size(16.dp)) }
                IconButton(onClick = onRemove) { Icon(Icons.Default.DeleteOutline, null, modifier = Modifier.size(16.dp), tint = Color.Red.copy(alpha = 0.6f)) }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Rich Text Toolbar (Simplified)
            Row(modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                ToolbarButton(Icons.Default.FormatBold) { onContentChange(block.content + "**粗体**") }
                ToolbarButton(Icons.Default.FormatItalic) { onContentChange(block.content + "*斜体*") }
                ToolbarButton(Icons.Default.TextFields) { onContentChange(block.content + " [填空] ") }
                ToolbarButton(Icons.Default.QuestionMark) { onLinkQuestion() }
            }
            
            OutlinedTextField(
                value = block.content,
                onValueChange = onContentChange,
                modifier = Modifier.fillMaxWidth().heightIn(min = 120.dp),
                placeholder = { Text("在此输入教学设计...") },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color.Transparent, focusedBorderColor = SageGreen.copy(alpha = 0.3f))
            )
        }
    }
}

@Composable
fun ToolbarButton(icon: ImageVector, onClick: () -> Unit) {
    IconButton(onClick = onClick, modifier = Modifier.size(32.dp).background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f), CircleShape)) {
        Icon(icon, null, modifier = Modifier.size(16.dp))
    }
}

@Composable
fun AiDialog(onDismiss: () -> Unit, onConfirm: (String) -> Unit) {
    var prompt by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("AI 智能备课") },
        text = {
            Column {
                Text("描述你想生成的教案主题、核心语法点或教学环节：", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = prompt,
                    onValueChange = { prompt = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("例如：初一英语现在完成时讲解...") }
                )
            }
        },
        confirmButton = {
            Button(onClick = { 
                onConfirm(prompt)
                onDismiss()
            }) { Text("生成教案") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("取消") }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NodeLinkerSheet(
    nodes: List<KnowledgeNodeEntity>,
    selectedNodeId: String?,
    onNodeSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(modifier = Modifier.fillMaxWidth().padding(24.dp).padding(bottom = 32.dp)) {
            Text("选择关联的知识节点", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            if (nodes.isEmpty()) {
                Text("暂无知识节点数据", color = Color.Gray, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            } else {
                LazyColumn(modifier = Modifier.heightIn(max = 400.dp)) {
                    items(nodes.size) { index ->
                        val node = nodes[index]
                        val isSelected = node.nodeId == selectedNodeId
                        Card(
                            onClick = { onNodeSelected(node.nodeId) },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = if (isSelected) SageGreen.copy(alpha = 0.1f) else Color.Transparent),
                            border = if (isSelected) BorderStroke(1.dp, SageGreen) else null
                        ) {
                            Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.AccountTree, null, tint = if (isSelected) SageGreen else Color.Gray)
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(node.title, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = onDismiss, modifier = Modifier.fillMaxWidth()) { Text("关闭") }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionLinkerSheet(
    questions: List<ScanRecordEntity>,
    onQuestionSelected: (ScanRecordEntity) -> Unit,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(modifier = Modifier.fillMaxWidth().padding(24.dp).padding(bottom = 32.dp)) {
            Text("插入班级错题", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            if (questions.isEmpty()) {
                Text("该班级暂无错题记录", color = Color.Gray, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            } else {
                LazyColumn(modifier = Modifier.heightIn(max = 400.dp)) {
                    items(questions.size) { index ->
                        val question = questions[index]
                        Card(
                            onClick = { onQuestionSelected(question) },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(question.ocrText, maxLines = 2, style = MaterialTheme.typography.bodySmall)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("扫码时间: ${java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(java.util.Date(question.createdAt))}", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = onDismiss, modifier = Modifier.fillMaxWidth()) { Text("取消") }
        }
    }
}

private fun buildMarkdown(
    title: String,
    lessonType: String,
    targetClass: String,
    keyPoints: String,
    difficulties: String,
    blocks: List<LessonBlock>
): String {
    val sb = StringBuilder()
    sb.append("# $title\n\n")
    sb.append("**课型**: $lessonType | **班级**: $targetClass\n\n")
    sb.append("## 核心目标\n")
    sb.append("- **重点**: $keyPoints\n")
    sb.append("- **难点**: $difficulties\n\n")
    
    blocks.forEachIndexed { index, block ->
        sb.append("## ${index + 1}. ${block.type}\n")
        sb.append("${block.content}\n\n")
    }
    
    return sb.toString()
}

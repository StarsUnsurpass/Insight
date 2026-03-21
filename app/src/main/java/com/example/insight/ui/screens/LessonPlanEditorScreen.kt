package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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

enum class PaperStyle(val title: String) {
    WhiteBlank("纯白无纹"),
    WhiteLined("横行信纸"),
    Grid("网格纸"),
    KraftBlank("牛皮纸"),
    EnglishRuled("英语四线")
}

enum class HandwritingFont(val title: String, val fontFamilyName: String) {
    Normal("常规系统", "sans-serif"),
    Serif("宋体模拟", "serif"),
    Cursive("草书手写", "cursive"),
    Monospace("行楷模拟", "monospace")
}

data class HandwritingSettings(
    val fontStyle: HandwritingFont = HandwritingFont.Normal,
    val paperStyle: PaperStyle = PaperStyle.WhiteLined,
    
    val showLines: Boolean = true,
    val marginTop: Float = 50f,
    val marginLeft: Float = 30f,
    val marginRight: Float = 30f,
    val marginBottom: Float = 50f,

    val fontSize: Float = 16f,
    val textColor: Color = Color.Black,
    val textAlignment: Int = android.view.Gravity.START,
    val textEffect: Int = 0,
    val resolution: Int = 2,

    val lightingEffect: Boolean = false,
    val crumpleEffect: Boolean = false,
    val otherEffect: Boolean = false,

    val verticalPosition: Float = 0f,
    val wordSpacing: Float = 0f,
    val letterSpacing: Float = 0.05f,
    
    val lineSpacing: Float = 1.8f
)

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
                    IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, null) }
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
    var selectedTabIndex by remember { mutableStateOf(0) }
    var hwSettings by remember { mutableStateOf(HandwritingSettings()) }
    
    Column(modifier = Modifier.padding(padding).fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            Tab(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0 }, text = { Text("普通预览") })
            Tab(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1 }, text = { Text("手写模拟生成", fontWeight = FontWeight.Bold, color = SageGreen) })
        }
        
        if (selectedTabIndex == 0) {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                item {
                    Text(title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                    Text("适用班级: $targetClass", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    Spacer(modifier = Modifier.height(16.dp))
                    MarkdownText(markdown = content, modifier = Modifier.fillMaxWidth())
                }
            }
        } else {
            HandwritingSimulationMode(
                title = title,
                content = content,
                settings = hwSettings,
                onSettingsChange = { hwSettings = it }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HandwritingSimulationMode(
    title: String, 
    content: String, 
    settings: HandwritingSettings, 
    onSettingsChange: (HandwritingSettings) -> Unit
) {
    var showConfigSheet by remember { mutableStateOf(false) }
    
    Box(modifier = Modifier.fillMaxSize()) {
        val paperColor = when(settings.paperStyle) {
            PaperStyle.KraftBlank -> Color(0xFFEAD8B1)
            else -> Color.White
        }
        val lineColor = when(settings.paperStyle) {
            PaperStyle.KraftBlank -> Color(0x40000000)
            else -> Color(0xFFD0D0D0)
        }
        
        Box(modifier = Modifier.fillMaxSize().background(Color(0xFFE5E5E5)).padding(16.dp)) {
            Box(modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(4.dp))
                .background(paperColor)
            ) {
                androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
                    val lineGapPx = 32.dp.toPx() * settings.lineSpacing
                    if (settings.showLines) {
                        when(settings.paperStyle) {
                            PaperStyle.WhiteLined, PaperStyle.EnglishRuled -> {
                                var y = settings.marginTop.dp.toPx() + lineGapPx
                                while (y < size.height) {
                                    drawLine(lineColor, androidx.compose.ui.geometry.Offset(0f, y), androidx.compose.ui.geometry.Offset(size.width, y), 2f)
                                    if (settings.paperStyle == PaperStyle.EnglishRuled) {
                                        val dashEffect = androidx.compose.ui.graphics.PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                                        drawLine(lineColor, androidx.compose.ui.geometry.Offset(0f, y + lineGapPx/3), androidx.compose.ui.geometry.Offset(size.width, y + lineGapPx/3), 1f, pathEffect = dashEffect)
                                        drawLine(lineColor, androidx.compose.ui.geometry.Offset(0f, y + lineGapPx*2/3), androidx.compose.ui.geometry.Offset(size.width, y + lineGapPx*2/3), 1f, pathEffect = dashEffect)
                                        y += lineGapPx
                                    }
                                    y += lineGapPx
                                }
                            }
                            PaperStyle.Grid -> {
                                var y = settings.marginTop.dp.toPx()
                                while (y < size.height) {
                                    drawLine(lineColor, androidx.compose.ui.geometry.Offset(0f, y), androidx.compose.ui.geometry.Offset(size.width, y), 2f)
                                    y += lineGapPx
                                }
                                var x = settings.marginLeft.dp.toPx()
                                while (x < size.width) {
                                    drawLine(lineColor, androidx.compose.ui.geometry.Offset(x, 0f), androidx.compose.ui.geometry.Offset(x, size.height), 2f)
                                    x += lineGapPx
                                }
                            }
                            else -> {}
                        }
                    }
                    if (settings.crumpleEffect) {
                        val crumplePath = androidx.compose.ui.graphics.Path()
                        for (i in 0..10) {
                            crumplePath.moveTo((size.width * Math.random()).toFloat(), (size.height * Math.random()).toFloat())
                            crumplePath.lineTo((size.width * Math.random()).toFloat(), (size.height * Math.random()).toFloat())
                            crumplePath.lineTo((size.width * Math.random()).toFloat(), (size.height * Math.random()).toFloat())
                        }
                        drawPath(crumplePath, Color(0x30000000), style = androidx.compose.ui.graphics.drawscope.Stroke(width = 2f))
                    }
                    if (settings.otherEffect) {
                        drawRect(androidx.compose.ui.graphics.Brush.radialGradient(
                            colors = listOf(Color.Transparent, Color(0x40000000)),
                            center = androidx.compose.ui.geometry.Offset(size.width / 2, size.height / 2),
                            radius = size.height * 0.8f
                        ))
                    }
                    if (settings.lightingEffect) {
                        drawRect(androidx.compose.ui.graphics.Brush.linearGradient(
                            colors = listOf(Color(0x40FFFFFF), Color.Transparent, Color(0x10000000)),
                            start = androidx.compose.ui.geometry.Offset(0f, 0f),
                            end = androidx.compose.ui.geometry.Offset(size.width, size.height)
                        ))
                    }
                }
                
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(start = settings.marginLeft.dp, end = settings.marginRight.dp, top = settings.marginTop.dp, bottom = settings.marginBottom.dp)
                ) {
                    item {
                        MarkdownText(
                            markdown = "# $title\n\n$content",
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                            color = settings.textColor,
                            textSize = settings.fontSize,
                            lineSpacingMultiplier = settings.lineSpacing,
                            letterSpacing = settings.letterSpacing,
                            wordSpacing = settings.wordSpacing,
                            typeface = android.graphics.Typeface.create(settings.fontStyle.fontFamilyName, android.graphics.Typeface.NORMAL),
                            textAlign = settings.textAlignment,
                            textEffect = settings.textEffect
                        )
                    }
                }
            }
        }
        
        FloatingActionButton(
            onClick = { showConfigSheet = true },
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
            containerColor = SageGreen
        ) {
            Icon(Icons.Default.Tune, "Settings", tint = Color.White)
        }
    }
    
    if (showConfigSheet) {
        ModalBottomSheet(onDismissRequest = { showConfigSheet = false }) {
            androidx.compose.foundation.layout.Column(
                modifier = androidx.compose.ui.Modifier.verticalScroll(androidx.compose.foundation.rememberScrollState())
            ) {
                HandwritingConfigPanel(settings, onSettingsChange = onSettingsChange)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HandwritingConfigPanel(settings: HandwritingSettings, onSettingsChange: (HandwritingSettings) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(bottom = 32.dp)) {
        Column {
            Text("1. 手写选项", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = SageGreen, modifier = Modifier.padding(top = 16.dp))
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 4.dp)) {
                Text("手写字体:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                androidx.compose.foundation.lazy.LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    val fonts = HandwritingFont.values()
                    items(fonts.size) { index ->
                        val font = fonts[index]
                        FilterChip(
                            selected = settings.fontStyle == font,
                            onClick = { onSettingsChange(settings.copy(fontStyle = font)) },
                            label = { Text(font.title) }
                        )
                    }
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 4.dp)) {
                Text("纸张类型:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                androidx.compose.foundation.lazy.LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    val papers = PaperStyle.values()
                    items(papers.size) { index ->
                        val style = papers[index]
                        FilterChip(
                            selected = settings.paperStyle == style,
                            onClick = { onSettingsChange(settings.copy(paperStyle = style)) },
                            label = { Text(style.title) }
                        )
                    }
                }
            }
        }
        
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Text("2. 边距和线条选项", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("线条 (隐藏/显示)")
                Switch(checked = settings.showLines, onCheckedChange = { onSettingsChange(settings.copy(showLines = it)) })
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("顶部边距:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                Slider(value = settings.marginTop, onValueChange = { onSettingsChange(settings.copy(marginTop = it)) }, valueRange = 0f..180f, modifier = Modifier.weight(1f))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("左边边距:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                Slider(value = settings.marginLeft, onValueChange = { onSettingsChange(settings.copy(marginLeft = it)) }, valueRange = 0f..180f, modifier = Modifier.weight(1f))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("右边边距:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                Slider(value = settings.marginRight, onValueChange = { onSettingsChange(settings.copy(marginRight = it)) }, valueRange = 0f..180f, modifier = Modifier.weight(1f))
            }
        }

        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Text("3. 页面和文字选项", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("字体大小:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                Slider(value = settings.fontSize, onValueChange = { onSettingsChange(settings.copy(fontSize = it)) }, valueRange = 12f..32f, modifier = Modifier.weight(1f))
            }
            Row(modifier = Modifier.padding(vertical = 8.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("字体颜色:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                val colors = listOf(Color.Black to "纯黑", Color(0xFF00008B) to "深蓝", Color(0xFF8B0000) to "暗红", Color(0xFF006400) to "孔雀绿")
                colors.forEach { (c, _) ->
                    Box(
                        modifier = Modifier.size(24.dp).clip(CircleShape).background(c)
                            .clickable { onSettingsChange(settings.copy(textColor = c)) }
                            .border(2.dp, if (settings.textColor == c) SageGreen else Color.Transparent, CircleShape)
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("文字对齐:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                androidx.compose.foundation.lazy.LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    item { FilterChip(selected = settings.textAlignment == android.view.Gravity.START, onClick = { onSettingsChange(settings.copy(textAlignment = android.view.Gravity.START)) }, label = { Text("居左") }) }
                    item { FilterChip(selected = settings.textAlignment == android.view.Gravity.CENTER, onClick = { onSettingsChange(settings.copy(textAlignment = android.view.Gravity.CENTER)) }, label = { Text("居中") }) }
                    item { FilterChip(selected = settings.textAlignment == android.view.Gravity.END, onClick = { onSettingsChange(settings.copy(textAlignment = android.view.Gravity.END)) }, label = { Text("居右") }) }
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("效果:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                androidx.compose.foundation.lazy.LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    item { FilterChip(selected = settings.textEffect == 0, onClick = { onSettingsChange(settings.copy(textEffect = 0)) }, label = { Text("无效果") }) }
                    item { FilterChip(selected = settings.textEffect == 1, onClick = { onSettingsChange(settings.copy(textEffect = 1)) }, label = { Text("阴影") }) }
                    item { FilterChip(selected = settings.textEffect == 2, onClick = { onSettingsChange(settings.copy(textEffect = 2)) }, label = { Text("扫描") }) }
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("分辨率:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                androidx.compose.foundation.lazy.LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    item { FilterChip(selected = settings.resolution == 0, onClick = { onSettingsChange(settings.copy(resolution = 0)) }, label = { Text("极低") }) }
                    item { FilterChip(selected = settings.resolution == 1, onClick = { onSettingsChange(settings.copy(resolution = 1)) }, label = { Text("低清") }) }
                    item { FilterChip(selected = settings.resolution == 2, onClick = { onSettingsChange(settings.copy(resolution = 2)) }, label = { Text("正常") }) }
                    item { FilterChip(selected = settings.resolution == 3, onClick = { onSettingsChange(settings.copy(resolution = 3)) }, label = { Text("高清") }) }
                    item { FilterChip(selected = settings.resolution == 4, onClick = { onSettingsChange(settings.copy(resolution = 4)) }, label = { Text("超清") }) }
                }
            }
        }
        
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Text("4. 特殊效果", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("光影 (环境光干扰)")
                Switch(checked = settings.lightingEffect, onCheckedChange = { onSettingsChange(settings.copy(lightingEffect = it)) })
            }
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("褶皱 (真实受潮或揉搓)")
                Switch(checked = settings.crumpleEffect, onCheckedChange = { onSettingsChange(settings.copy(crumpleEffect = it)) })
            }
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("其他 (复印暗角微调)")
                Switch(checked = settings.otherEffect, onCheckedChange = { onSettingsChange(settings.copy(otherEffect = it)) })
            }
        }

        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Text("5. 间距选项", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("垂直位置:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                Slider(value = settings.lineSpacing, onValueChange = { onSettingsChange(settings.copy(lineSpacing = it)) }, valueRange = 1f..3f, modifier = Modifier.weight(1f))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("字间距:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                Slider(value = settings.wordSpacing, onValueChange = { onSettingsChange(settings.copy(wordSpacing = it)) }, valueRange = 0f..0.5f, modifier = Modifier.weight(1f))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("字符间距:", modifier = Modifier.width(80.dp), style = MaterialTheme.typography.bodySmall)
                Slider(value = settings.letterSpacing, onValueChange = { onSettingsChange(settings.copy(letterSpacing = it)) }, valueRange = 0f..0.3f, modifier = Modifier.weight(1f))
            }
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

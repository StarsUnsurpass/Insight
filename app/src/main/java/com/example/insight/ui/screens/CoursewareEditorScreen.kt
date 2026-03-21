@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.data.model.*
import java.util.*

@Composable
fun CoursewareEditorScreen(
    coursewareId: String?, // null means create new
    onBack: () -> Unit,
    onSave: (Courseware) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("语法突破") }
    var themeColor by remember { mutableStateOf(Color(0xFF6200EE)) }
    var selectedStyle by remember { mutableStateOf(CoursewareStyle.MODERN) }
    var slides by remember { mutableStateOf(mutableListOf<com.example.insight.data.model.Slide>()) }
    
    // Load existing data if editing
    LaunchedEffect(coursewareId) {
        if (coursewareId != null) {
            val existing = sampleCoursewares.find { it.id == coursewareId }
            existing?.let {
                title = it.title
                description = it.description
                category = it.category
                themeColor = it.themeColor
                selectedStyle = it.style
                slides = it.slides.toMutableList()
            }
        } else if (slides.isEmpty()) {
            slides.add(com.example.insight.data.model.Slide(UUID.randomUUID().toString(), "New Slide", ""))
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (coursewareId == null) "创建课件" else "编辑课件") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                    }
                },
                actions = {
                    Button(
                        onClick = {
                            val newCourseware = Courseware(
                                id = coursewareId ?: UUID.randomUUID().toString(),
                                title = title,
                                description = description,
                                category = category,
                                themeColor = themeColor,
                                slides = slides,
                                style = selectedStyle
                            )
                            onSave(newCourseware)
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(Icons.Default.Save, null, Modifier.size(18.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("保存")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // 1. 全局配置
            item {
                EditorSection(title = "全局配置", icon = Icons.Default.Settings) {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("课件标题") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("课件简介") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(16.dp))
                    Text("模板风格", style = MaterialTheme.typography.titleSmall)
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        items(CoursewareStyle.values()) { style ->
                            FilterChip(
                                selected = selectedStyle == style,
                                onClick = { selectedStyle = style },
                                label = { Text(style.name) }
                            )
                        }
                    }
                }
            }

            // 2. 幻灯片列表
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("幻灯片管理 (${slides.size})", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    IconButton(onClick = { 
                        slides = slides.toMutableList().apply { add(com.example.insight.data.model.Slide(UUID.randomUUID().toString(), "New Slide", "")) }
                    }) {
                        Icon(Icons.Default.AddCircle, null, tint = MaterialTheme.colorScheme.primary)
                    }
                }
            }

            itemsIndexed(slides) { index, slide ->
                SlideEditorCard(
                    index = index,
                    slide = slide,
                    onUpdate = { updatedSlide ->
                        val newList = slides.toMutableList()
                        newList[index] = updatedSlide
                        slides = newList
                    },
                    onDelete = {
                        val newList = slides.toMutableList()
                        newList.removeAt(index)
                        slides = newList
                    }
                )
            }
        }
    }
}

@Composable
fun EditorSection(title: String, icon: ImageVector, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
    ) {
        Column(Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, null, modifier = Modifier.size(20.dp), tint = MaterialTheme.colorScheme.primary)
                Spacer(Modifier.width(8.dp))
                Text(title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(16.dp))
            content()
        }
    }
}

@Composable
fun SlideEditorCard(
    index: Int,
    slide: com.example.insight.data.model.Slide,
    onUpdate: (com.example.insight.data.model.Slide) -> Unit,
    onDelete: () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(32.dp).background(MaterialTheme.colorScheme.primary, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("${index + 1}", color = Color.White, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(12.dp))
                Text(slide.title.ifEmpty { "未命名幻灯片" }, modifier = Modifier.weight(1f), fontWeight = FontWeight.Medium)
                IconButton(onClick = { isExpanded = !isExpanded }) {
                    Icon(if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore, null)
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, null, tint = MaterialTheme.colorScheme.error)
                }
            }

            AnimatedVisibility(visible = isExpanded) {
                Column(Modifier.padding(top = 16.dp)) {
                    OutlinedTextField(
                        value = slide.title,
                        onValueChange = { onUpdate(slide.copy(title = it)) },
                        label = { Text("标题") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = slide.content,
                        onValueChange = { onUpdate(slide.copy(content = it)) },
                        label = { Text("主要内容") },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 3
                    )
                    
                    Spacer(Modifier.height(16.dp))
                    Text("布局与交互", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                    
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        // 布局选择
                        Box(Modifier.weight(1f)) {
                            var expanded by remember { mutableStateOf(false) }
                            OutlinedCard(onClick = { expanded = true }) {
                                Text(slide.layoutType.name, Modifier.padding(12.dp), fontSize = 12.sp)
                            }
                            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                                SlideLayoutType.values().forEach { layout ->
                                    DropdownMenuItem(text = { Text(layout.name) }, onClick = { 
                                        onUpdate(slide.copy(layoutType = layout))
                                        expanded = false
                                    })
                                }
                            }
                        }
                        
                        // 交互选择
                        Box(Modifier.weight(1f)) {
                            var expanded by remember { mutableStateOf(false) }
                            OutlinedCard(onClick = { expanded = true }) {
                                Text(slide.interactionType.name, Modifier.padding(12.dp), fontSize = 12.sp)
                            }
                            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                                InteractionType.values().forEach { type ->
                                    DropdownMenuItem(text = { Text(type.name) }, onClick = { 
                                        onUpdate(slide.copy(interactionType = type))
                                        expanded = false
                                    })
                                }
                            }
                        }
                    }

                    if (slide.interactionType != InteractionType.NONE) {
                        Spacer(Modifier.height(8.dp))
                        OutlinedTextField(
                            value = slide.correctAnswer,
                            onValueChange = { onUpdate(slide.copy(correctAnswer = it)) },
                            label = { Text("正确答案/解析") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = slide.visualHint,
                        onValueChange = { onUpdate(slide.copy(visualHint = it)) },
                        label = { Text("视觉提示 (插图描述)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import com.example.insight.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SolutionScreen(
    content: String,
    concepts: List<String>,
    onBack: () -> Unit,
    onShowGraph: () -> Unit
) {
    val scrollState = rememberLazyListState()
    var isOcrVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize().background(InkBlue)) {
        // 1. Background Layer (Blurred context)
        Box(modifier = Modifier.fillMaxSize().blur(20.dp).alpha(0.4f).background(Color.Black))

        // 2. The Sheet Content
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(top = 20.dp),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            color = Color.White
        ) {
            LazyColumn(
                state = scrollState,
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 40.dp)
            ) {
                // Header: Drag Handle & Navigation
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp, 4.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray.copy(alpha = 0.5f))
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = onBack) {
                                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = DarkText)
                            }
                            Text(
                                "深度解析",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = DarkText
                            )
                            IconButton(onClick = { /* Share */ }) {
                                Icon(imageVector = Icons.Outlined.Share, contentDescription = "Share", tint = DarkText)
                            }
                        }
                    }
                }

                // Module 1: Original Problem & OCR Toggle
                item {
                    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(SoftOatmeal)
                                .border(1.dp, Color.LightGray.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
                        ) {
                            if (!isOcrVisible) {
                                // Placeholder for original image
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                    Icon(imageVector = Icons.Outlined.Image, contentDescription = "Original", modifier = Modifier.size(48.dp), tint = SageGreen.copy(alpha = 0.5f))
                                    Text("原题重现", style = MaterialTheme.typography.labelSmall, modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 12.dp), color = SageGreen)
                                }
                            } else {
                                // OCR Text View
                                Text(
                                    text = "Which of the following best describes the author's attitude towards the new policy?",
                                    modifier = Modifier.padding(20.dp),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = DarkText
                                )
                            }
                            
                            // OCR Toggle
                            TextButton(
                                onClick = { isOcrVisible = !isOcrVisible },
                                modifier = Modifier.align(Alignment.BottomEnd).padding(8.dp),
                                colors = ButtonDefaults.textButtonColors(contentColor = InkBlue)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = if (isOcrVisible) Icons.Default.Image else Icons.Default.TextFields, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(if (isOcrVisible) "查看原图" else "查看文本", style = MaterialTheme.typography.labelSmall)
                                }
                            }
                        }
                    }
                }

                // Module 2: Core Result (Standard Answer)
                item {
                    Card(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                        colors = CardDefaults.cardColors(containerColor = InkBlue),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = SageGreen, modifier = Modifier.size(20.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("标准答案 / Standard Answer", style = MaterialTheme.typography.labelMedium, color = Color.White.copy(alpha = 0.7f))
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                "Option C: The policy is viewed as a necessary but ambitious step.",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                // Module 3: Knowledge Tags
                item {
                    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)) {
                        Text("考点标签", style = MaterialTheme.typography.labelMedium, color = SageGreen, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(12.dp))
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            concepts.forEach { concept ->
                                Surface(
                                    color = SoftOatmeal,
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.dp, InkBlue.copy(alpha = 0.05f))
                                ) {
                                    Text(
                                        text = concept,
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                        style = MaterialTheme.typography.labelMedium,
                                        color = InkBlue
                                    )
                                }
                            }
                        }
                    }
                }

                // Module 4: Analysis Flow
                item {
                    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)) {
                        AnalysisStepCard(
                            title = "破题思路",
                            content = content,
                            icon = Icons.Outlined.Lightbulb
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        AnalysisStepCard(
                            title = "干扰项排除",
                            content = "A选项中的 'skeptical' 与原文中的 'essential' 矛盾；B选项过度解读了作者的担忧。",
                            icon = Icons.Outlined.GppBad
                        )
                    }
                }

                // Module 5: Extension (Related Knowledge)
                item {
                    Column(modifier = Modifier.padding(top = 12.dp)) {
                        Text(
                            "知识延展",
                            style = MaterialTheme.typography.labelMedium,
                            color = SageGreen,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(3) { index ->
                                Card(
                                    modifier = Modifier.width(240.dp),
                                    colors = CardDefaults.cardColors(containerColor = SoftOatmeal),
                                    shape = RoundedCornerShape(16.dp)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp)) {
                                        Text(
                                            if (index == 0) "复习：一般过去时" else "类似真题：2023 模拟 B 篇",
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = InkBlue
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            "在掌握此考点前，建议先巩固基础概念。",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = DarkText.copy(alpha = 0.7f)
                                        )
                                        Spacer(modifier = Modifier.height(12.dp))
                                        TextButton(onClick = { /* Jump */ }, contentPadding = PaddingValues(0.dp)) {
                                            Text("点击跳转 ->", style = MaterialTheme.typography.labelSmall, color = SageGreen)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Action Button
                item {
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = onShowGraph,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = InkBlue),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(12.dp))
                        Text("进入能力映射星图", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun AnalysisStepCard(title: String, content: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(SoftOatmeal)
            .padding(16.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = SageGreen, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = InkBlue)
            Spacer(modifier = Modifier.height(4.dp))
            Text(content, style = MaterialTheme.typography.bodyMedium, color = DarkText, lineHeight = 22.sp)
        }
    }
}

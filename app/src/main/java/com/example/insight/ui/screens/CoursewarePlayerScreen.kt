@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.insight.data.model.Courseware
import com.example.insight.data.model.InteractionType
import com.example.insight.data.model.Slide
import com.example.insight.data.model.sampleCoursewares
import kotlin.math.absoluteValue

@Composable
fun CoursewarePlayerScreen(
    coursewareId: String,
    onBack: () -> Unit
) {
    val courseware = remember(coursewareId) {
        sampleCoursewares.find { it.id == coursewareId } ?: sampleCoursewares[0]
    }
    
    val pagerState = rememberPagerState(pageCount = { courseware.slides.size })
    val scope = rememberCoroutineScope()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(courseware.title, style = MaterialTheme.typography.titleMedium) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF9F6F0),
                    titleContentColor = Color(0xFF1A1C1E)
                )
            )
        },
        containerColor = Color(0xFFF9F6F0) // 浅燕麦色背景
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 进度条
            LinearProgressIndicator(
                progress = { (pagerState.currentPage + 1).toFloat() / courseware.slides.size },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp),
                color = courseware.themeColor,
                trackColor = courseware.themeColor.copy(alpha = 0.1f)
            )
            
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 32.dp),
                pageSpacing = 16.dp
            ) { page ->
                SlideContent(
                    slide = courseware.slides[page],
                    themeColor = courseware.themeColor,
                    modifier = Modifier
                        .graphicsLayer {
                            val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue
                            
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                            
                            scaleY = lerp(
                                start = 0.9f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                )
            }
            
            // 底部页码指示器
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(courseware.slides.size) { iteration ->
                    val color = if (pagerState.currentPage == iteration) courseware.themeColor else courseware.themeColor.copy(alpha = 0.2f)
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(if (pagerState.currentPage == iteration) 12.dp else 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SlideContent(
    slide: Slide,
    themeColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f)
            .padding(vertical = 16.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // 顶部角标
            Surface(
                color = themeColor.copy(alpha = 0.1f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Slide ${slide.id.replace("s", "")}",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.labelMedium,
                    color = themeColor,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = slide.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1C1E),
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 视觉辅助展示区 (模拟插图/动画)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(themeColor.copy(alpha = 0.05f), themeColor.copy(alpha = 0.15f))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = null,
                        tint = themeColor,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = slide.visualHint,
                        style = MaterialTheme.typography.bodySmall,
                        color = themeColor.copy(alpha = 0.7f),
                        textAlign = TextAlign.Center
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Text(
                text = slide.content,
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF44474E),
                textAlign = TextAlign.Center,
                lineHeight = 28.sp
            )
            
            if (slide.subContent.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = slide.subContent,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF44474E).copy(alpha = 0.7f),
                    textAlign = TextAlign.Center
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // 交互部分
            InteractionView(slide, themeColor)
        }
    }
}

@Composable
fun InteractionView(slide: Slide, themeColor: Color) {
    var revealed by remember(slide.id) { mutableStateOf(false) }
    
    when (slide.interactionType) {
        InteractionType.CLICK_TO_REVEAL, InteractionType.FLIP_CARD -> {
            Button(
                onClick = { revealed = !revealed },
                colors = ButtonDefaults.buttonColors(containerColor = themeColor),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(if (revealed) "隐藏解析" else "点击显示")
            }
            
            AnimatedVisibility(visible = revealed) {
                Text(
                    text = if (slide.options.isNotEmpty()) slide.options.joinToString(" | ") else slide.correctAnswer,
                    modifier = Modifier.padding(top = 16.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = themeColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        InteractionType.FILL_IN_BLANK -> {
            var input by remember { mutableStateOf("") }
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                label = { Text("输入你的答案") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )
            if (input.lowercase() == slide.correctAnswer.lowercase().split(", ")[0]) {
                Icon(Icons.Default.CheckCircle, null, tint = Color.Green, modifier = Modifier.padding(top = 8.dp))
            }
        }
        InteractionType.MULTIPLE_CHOICE -> {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                slide.options.forEach { option ->
                    var selected by remember { mutableStateOf(false) }
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selected = !selected },
                        color = if (selected) themeColor.copy(alpha = 0.1f) else Color.Transparent,
                        border = BorderStroke(1.dp, if (selected) themeColor else Color.LightGray),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            option,
                            modifier = Modifier.padding(12.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
        else -> {}
    }
}

@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.insight.data.model.*
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
    
    // 主题背景色
    val backgroundColor = when(courseware.style) {
        CoursewareStyle.PAPER -> Color(0xFFF9F6F0)
        CoursewareStyle.DETECTIVE -> Color(0xFF1A1C1E)
        CoursewareStyle.TECH -> Color(0xFF0D1117)
        CoursewareStyle.WATERCOLOR -> Color(0xFFF0FDF4)
        else -> Color(0xFFF8F9FA)
    }

    val contentColor = when(courseware.style) {
        CoursewareStyle.DETECTIVE, CoursewareStyle.TECH -> Color.White
        else -> Color(0xFF1A1C1E)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(courseware.title, style = MaterialTheme.typography.titleMedium) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor,
                    titleContentColor = contentColor,
                    navigationIconContentColor = contentColor
                )
            )
        },
        containerColor = backgroundColor
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
                contentPadding = PaddingValues(horizontal = 24.dp),
                pageSpacing = 16.dp
            ) { page ->
                SlideContent(
                    courseware = courseware,
                    slide = courseware.slides[page],
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
    courseware: Courseware,
    slide: com.example.insight.data.model.Slide,
    modifier: Modifier = Modifier
) {
    val themeColor = courseware.themeColor
    val style = courseware.style

    val cardColor = when(style) {
        CoursewareStyle.DETECTIVE -> Color(0xFF2C2E33)
        CoursewareStyle.TECH -> Color(0xFF161B22)
        CoursewareStyle.PAPER -> Color.White
        else -> Color.White
    }

    val textColor = when(style) {
        CoursewareStyle.DETECTIVE, CoursewareStyle.TECH -> Color.White
        else -> Color(0xFF1A1C1E)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .padding(vertical = 8.dp),
        shape = when(style) {
            CoursewareStyle.TECH -> RoundedCornerShape(4.dp)
            CoursewareStyle.WATERCOLOR -> RoundedCornerShape(40.dp)
            else -> RoundedCornerShape(32.dp)
        },
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        border = if (style == CoursewareStyle.TECH) BorderStroke(1.dp, themeColor.copy(alpha = 0.5f)) else null
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // 背景装饰
            when(style) {
                CoursewareStyle.PAPER -> {
                    Canvas(Modifier.fillMaxSize()) {
                        // 模拟纸张线条
                        for (i in 0 until 20) {
                            drawLine(Color.LightGray.copy(alpha = 0.2f), start = Offset(0f, i * 60f), end = Offset(size.width, i * 60f))
                        }
                    }
                }
                CoursewareStyle.TECH -> {
                    // 科技感网格
                }
                else -> {}
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 顶部角标
                Surface(
                    color = themeColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = slide.id.uppercase(),
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        color = themeColor,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Spacer(modifier = Modifier.height(20.dp))
                
                Text(
                    text = slide.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    textAlign = TextAlign.Center,
                    fontFamily = if (style == CoursewareStyle.DETECTIVE) FontFamily.Serif else FontFamily.Default
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 动态布局内容区
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    when (slide.layoutType) {
                        SlideLayoutType.SPLIT_LR -> {
                            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                                    VisualHintView(slide.visualHint, themeColor, style)
                                }
                                Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                                    MainTextView(slide.content, textColor)
                                }
                            }
                        }
                        SlideLayoutType.TIMELINE -> {
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                                Box(modifier = Modifier.width(4.dp).fillMaxHeight().background(themeColor.copy(alpha = 0.3f)))
                                Column(verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxHeight()) {
                                    MainTextView(slide.content, textColor)
                                    VisualHintView(slide.visualHint, themeColor, style)
                                }
                            }
                        }
                        else -> {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                VisualHintView(slide.visualHint, themeColor, style)
                                Spacer(Modifier.height(24.dp))
                                MainTextView(slide.content, textColor)
                            }
                        }
                    }
                }
                
                if (slide.subContent.isNotEmpty()) {
                    Text(
                        text = slide.subContent,
                        style = MaterialTheme.typography.bodyMedium,
                        color = textColor.copy(alpha = 0.7f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 交互部分
                InteractionView(slide, themeColor, textColor)
            }
        }
    }
}

@Composable
fun VisualHintView(hint: String, themeColor: Color, style: CoursewareStyle) {
    if (hint.isEmpty()) return
    
    Box(
        modifier = Modifier
            .size(160.dp)
            .clip(if (style == CoursewareStyle.WATERCOLOR) CircleShape else RoundedCornerShape(24.dp))
            .background(
                Brush.radialGradient(
                    colors = listOf(themeColor.copy(alpha = 0.1f), themeColor.copy(alpha = 0.02f))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(12.dp)) {
            Icon(
                imageVector = when(style) {
                    CoursewareStyle.DETECTIVE -> Icons.Default.Search
                    CoursewareStyle.TECH -> Icons.Default.AutoAwesome
                    CoursewareStyle.GAME -> Icons.Default.SportsEsports
                    else -> Icons.Default.Lightbulb
                },
                contentDescription = null,
                tint = themeColor,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = hint,
                style = MaterialTheme.typography.bodySmall,
                color = themeColor.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                fontSize = 10.sp,
                lineHeight = 14.sp
            )
        }
    }
}

@Composable
fun MainTextView(text: String, color: Color) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = color,
        textAlign = TextAlign.Center,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun InteractionView(slide: com.example.insight.data.model.Slide, themeColor: Color, textColor: Color) {
    var revealed by remember(slide.id) { mutableStateOf(false) }
    
    when (slide.interactionType) {
        InteractionType.CLICK_TO_REVEAL, InteractionType.FLIP_CARD -> {
            Button(
                onClick = { revealed = !revealed },
                colors = ButtonDefaults.buttonColors(containerColor = themeColor),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(if (revealed) "隐藏解析" else "点击显示", color = Color.White)
            }
            
            AnimatedVisibility(visible = revealed) {
                Text(
                    text = if (slide.options.isNotEmpty()) slide.options.joinToString(" | ") else slide.correctAnswer,
                    modifier = Modifier.padding(top = 12.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = themeColor,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        InteractionType.FILL_IN_BLANK -> {
            var input by remember { mutableStateOf("") }
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                label = { Text("输入你的答案", color = textColor.copy(alpha = 0.5f)) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = textColor,
                    unfocusedTextColor = textColor,
                    focusedBorderColor = themeColor,
                    unfocusedBorderColor = textColor.copy(alpha = 0.2f)
                )
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
                        color = if (selected) themeColor.copy(alpha = 0.15f) else Color.Transparent,
                        border = BorderStroke(1.dp, if (selected) themeColor else textColor.copy(alpha = 0.1f)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            option,
                            modifier = Modifier.padding(12.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (selected) themeColor else textColor
                        )
                    }
                }
            }
        }
        InteractionType.SKETCH_BOARD -> {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(textColor.copy(alpha = 0.05f), RoundedCornerShape(16.dp))
                    .border(1.dp, textColor.copy(alpha = 0.1f), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("绘图互动区：请在屏幕上圈出重点", color = textColor.copy(alpha = 0.4f), fontSize = 12.sp)
            }
        }
        else -> {}
    }
}

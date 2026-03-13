package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import com.example.insight.ui.theme.*
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SolutionScreen(
    content: String,
    concepts: List<String>,
    onBack: () -> Unit,
    onShowGraph: () -> Unit
) {
    val scrollState = rememberScrollState()
    
    // Animation states for staggered entry
    var startAnimations by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        startAnimations = true
    }

    Scaffold(
        containerColor = PaperWhite,
        topBar = {
            TopAppBar(
                title = { Text("智能批改解析", style = MaterialTheme.typography.headlineMedium) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = DarkText)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PaperWhite)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(PaperWhite)
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // 1. Captured Summary Card (The "Original" area)
            AnalysisSectionCard(
                title = "题目摘要",
                visible = startAnimations,
                delay = 0
            ) {
                Text(
                    text = "Reading Comprehension - Section B",
                    style = MaterialTheme.typography.bodyLarge,
                    color = InkBlue,
                    fontWeight = FontWeight.SemiBold
                )
            }

            // 2. The Answer Card
            AnalysisSectionCard(
                title = "核心答案",
                visible = startAnimations,
                delay = 200
            ) {
                Surface(
                    color = HighlightYellow.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Correct Option: [C] - Refers to the psychological resilience.",
                        modifier = Modifier.padding(12.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = DarkText
                    )
                }
            }

            // 3. Grammar Chips
            AnalysisSectionCard(
                title = "重点考点",
                visible = startAnimations,
                delay = 400
            ) {
                @OptIn(ExperimentalLayoutApi::class)
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    concepts.forEach { concept ->
                        SuggestionChip(
                            onClick = {},
                            label = { Text(concept, style = MaterialTheme.typography.labelMedium) },
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                containerColor = SoftOatmeal,
                                labelColor = InkBlue
                            ),
                            border = BorderStroke(1.dp, SageGreen.copy(alpha = 0.3f)),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }
                }
            }

            // 4. Detailed Analysis (The Text)
            AnalysisSectionCard(
                title = "深度解析",
                visible = startAnimations,
                delay = 600
            ) {
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 28.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Bottom Action
            Button(
                onClick = onShowGraph,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .animateContentSize(),
                colors = ButtonDefaults.buttonColors(containerColor = InkBlue),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
            ) {
                Icon(Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text("进入知识映射星图", style = MaterialTheme.typography.labelLarge)
            }
            
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun AnalysisSectionCard(
    title: String,
    visible: Boolean,
    delay: Int,
    content: @Composable () -> Unit
) {
    androidx.compose.animation.AnimatedVisibility(
        visible = visible,
        enter = expandVertically(animationSpec = tween(500, delayMillis = delay)) + 
                fadeIn(animationSpec = tween(500, delayMillis = delay))
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = SoftOatmeal.copy(alpha = 0.5f)),
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.dp, InkBlue.copy(alpha = 0.05f))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                    color = SageGreen,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                content()
            }
        }
    }
}

package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var displayedText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    LaunchedEffect(content) {
        content.forEach { char ->
            displayedText += char
            delay(30)
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(DeepVoid)) {
        // Decorative Background Glows
        Box(
            modifier = Modifier
                .offset(x = (-100).dp, y = 100.dp)
                .size(300.dp)
                .blur(80.dp)
                .background(AetherTeal.copy(alpha = 0.1f), CircleShape)
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = 100.dp, y = 100.dp)
                .size(400.dp)
                .blur(100.dp)
                .background(OrchidMist.copy(alpha = 0.1f), CircleShape)
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = { Text("AI 深度解析", style = MaterialTheme.typography.headlineMedium) },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
                    .verticalScroll(scrollState)
            ) {
                // Concept Tags (The "Starfield" preview)
                Text(
                    text = "关联考点",
                    style = MaterialTheme.typography.labelMedium,
                    color = AetherTeal,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
                ) {
                    items(concepts) { concept ->
                        SuggestionChip(
                            onClick = {},
                            label = { Text(concept) },
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                containerColor = GlassOverlay,
                                labelColor = LunarFrost
                            ),
                            border = BorderStroke(
                                width = 1.dp,
                                color = Color.White.copy(alpha = 0.1f)
                            )
                        )
                    }
                }

                // The Solution Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(GlassOverlay),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.AutoAwesome,
                                contentDescription = null,
                                tint = AetherTeal,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "解析思路",
                                style = MaterialTheme.typography.labelMedium,
                                color = LunarFrost.copy(alpha = 0.5f)
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Text(
                            text = displayedText,
                            style = MaterialTheme.typography.bodyLarge,
                            color = LunarFrost,
                            lineHeight = 28.sp
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // Interaction Button (The "Magnetic" Feel)
                Button(
                    onClick = onShowGraph,
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AetherTeal),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("查看知识星图", color = DeepVoid, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

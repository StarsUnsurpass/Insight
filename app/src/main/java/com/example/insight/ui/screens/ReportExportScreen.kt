package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.state.ReportConfig
import com.example.insight.ui.state.UserPreferences
import com.example.insight.util.PdfExportHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportExportScreen(
    preferences: UserPreferences,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var config by remember { mutableStateOf(ReportConfig(reportTitle = "${preferences.className} 学情周报")) }
    var isGenerating by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("导出预览", style = MaterialTheme.typography.titleMedium) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    TextButton(onClick = {
                        isGenerating = true
                        PdfExportHelper.exportReport(context, config, preferences) { file ->
                            isGenerating = false
                            file?.let { PdfExportHelper.sharePdf(context, it) }
                        }
                    }) {
                        Text("导出", fontWeight = FontWeight.Bold)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.LightGray.copy(alpha = 0.2f))
        ) {
            // 1. WYSIWYG Previewer (A4 Ratio)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier
                        .aspectRatio(1f / 1.414f)
                        .fillMaxHeight()
                        .shadow(8.dp, RoundedCornerShape(4.dp)),
                    color = Color.White,
                    shape = RoundedCornerShape(4.dp)
                ) {
                    ReportA4Preview(config, preferences)
                }
            }

            // 2. Controller Panel
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text("导出设置", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                    
                    // Title Editor
                    OutlinedTextField(
                        value = config.reportTitle,
                        onValueChange = { config = config.copy(reportTitle = it) },
                        label = { Text("报告标题") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    // Color Selector
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("主题色彩", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                        val colors = listOf(Color(0xFF8BA18E), Color(0xFF2C3E50), Color(0xFFE57373), Color(0xFF64B5F6))
                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            colors.forEach { color ->
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(color)
                                        .border(
                                            width = if (config.themeColor == color.toArgb()) 2.dp else 0.dp,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            shape = CircleShape
                                        )
                                        .clickable { config = config.copy(themeColor = color.toArgb()) }
                                )
                            }
                        }
                    }

                    // Toggles
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("包含成绩单", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                        Switch(
                            checked = config.includeStudentList,
                            onCheckedChange = { config = config.copy(includeStudentList = it) }
                        )
                    }
                }
            }
        }
    }

    if (isGenerating) {
        ExportProgressDialog(role = preferences.role)
    }
}

@Composable
fun ReportA4Preview(config: ReportConfig, preferences: UserPreferences) {
    val themeColor = Color(config.themeColor)
    Column(modifier = Modifier.padding(20.dp)) {
        // Header
        Box(modifier = Modifier.fillMaxWidth().height(2.dp).background(themeColor))
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = config.reportTitle,
            style = MaterialTheme.typography.titleLarge,
            color = themeColor,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "班级：${preferences.className} | 2024-03-14",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Mock Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp, 16.dp) // Section indicator
                .background(themeColor.copy(alpha = 0.1f), RoundedCornerShape(2.dp))
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text("总体表现评估", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = themeColor)
        
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.fillMaxWidth().height(60.dp).background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp)))
        
        if (config.includeStudentList) {
            Spacer(modifier = Modifier.height(24.dp))
            Text("学生成绩单", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = themeColor)
            Spacer(modifier = Modifier.height(8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                repeat(3) {
                    Box(modifier = Modifier.fillMaxWidth().height(20.dp).background(Color(0xFFF5F5F5)))
                }
            }
        }
    }
}

private fun Modifier.height(_min: Dp, max: Dp) = this.size(width = _min, height = max)

package com.example.insight.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insight.ui.state.*
import com.example.insight.ui.theme.SageGreen
import com.example.insight.util.PdfExportHelper
import com.example.insight.ui.util.MarkdownText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportExportScreen(
    preferences: UserPreferences,
    aiOutput: String,
    isStreaming: Boolean,
    onGenerateAiReport: () -> Unit,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var config by remember { mutableStateOf(ReportConfig(reportTitle = "${preferences.className} 学情周报")) }
    var isGenerating by remember { mutableStateOf(false) }
    var hwSettings by remember { mutableStateOf(HandwritingSettings()) }

    // ... (rest of the functions remain same until LazyColumn)

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
                        PdfExportHelper.exportReport(context, config, preferences, aiOutput) { _ ->
                            isGenerating = false
                            // file is null here because printManager.print handles the dialog
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
            // 1. WYSIWYG Previewer
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                if (config.isHandwritingMode) {
                    HandwritingSimulationMode(
                        title = config.reportTitle,
                        content = if (aiOutput.isNotBlank()) aiOutput else "DeepSeek 正在分析海量学情数据...",
                        settings = hwSettings,
                        onSettingsChange = { hwSettings = it }
                    )
                } else {
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
            }

            // 2. Advanced Controller Panel
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp
            ) {
                LazyColumn(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item { Text("导出个性化设置", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold) }
                    
                    item {
                        OutlinedTextField(
                            value = config.reportTitle,
                            onValueChange = { config = config.copy(reportTitle = it) },
                            label = { Text("报告标题") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }

                    item {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("模拟手写导出", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                                Text("开启后将模拟逼真的手写教案效果", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                            }
                            Switch(
                                checked = config.isHandwritingMode,
                                onCheckedChange = { config = config.copy(isHandwritingMode = it) }
                            )
                        }
                    }

                    if (config.isHandwritingMode) {
                        item {
                            HandwritingConfigPanel(
                                settings = hwSettings,
                                onSettingsChange = { hwSettings = it }
                            )
                        }
                    } else {
                        item {
                            StyleSelector(
                                label = "字体风格",
                                options = listOf("无衬线" to ReportFont.SAN_SERIF, "衬线" to ReportFont.SERIF, "等宽" to ReportFont.MONOSPACE),
                                selected = config.fontStyle,
                                onSelect = { config = config.copy(fontStyle = it) }
                            )
                        }

                        item {
                            StyleSelector(
                                label = "图表类型",
                                options = listOf("雷达图" to ChartStyle.RADAR, "柱状图" to ChartStyle.BAR, "饼图" to ChartStyle.PIE),
                                selected = config.chartStyle,
                                onSelect = { config = config.copy(chartStyle = it) }
                            )
                        }
                    }

                    item {
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
                    }

                    item {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("包含成绩单", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                            Switch(
                                checked = config.includeStudentList,
                                onCheckedChange = { config = config.copy(includeStudentList = it) }
                            )
                        }
                    }

                    item {
                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("DeepSeek 智能学情分析", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                                Text("基于本周全班数据自动生成洞察报告", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                            }
                            Button(
                                onClick = onGenerateAiReport,
                                enabled = !isStreaming,
                                colors = ButtonDefaults.buttonColors(containerColor = SageGreen),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                if (isStreaming) {
                                    CircularProgressIndicator(modifier = Modifier.size(16.dp), color = Color.White, strokeWidth = 2.dp)
                                } else {
                                    Icon(Icons.Default.AutoAwesome, null, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(8.dp))
                                    Text("生成报告", style = MaterialTheme.typography.labelMedium)
                                }
                            }
                        }
                    }

                    if (aiOutput.isNotBlank() || isStreaming) {
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(containerColor = SageGreen.copy(alpha = 0.1f)),
                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text("AI 洞察预览", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold, color = SageGreen)
                                        if (isStreaming) {
                                            @Suppress("DEPRECATION")
                                            Spacer(Modifier.width(8.dp))
                                            LinearProgressIndicator(modifier = Modifier.weight(1f).height(2.dp), color = SageGreen)
                                        }
                                    }
                                    Spacer(Modifier.height(12.dp))
                                    MarkdownText(
                                        markdown = if (aiOutput.isNotBlank()) aiOutput else "DeepSeek 正在分析海量学情数据...",
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
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
fun <T> StyleSelector(
    label: String,
    options: List<Pair<String, T>>,
    selected: T,
    onSelect: (T) -> Unit
) {
    Column {
        Text(label, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            options.forEach { (name, value) ->
                FilterChip(
                    selected = selected == value,
                    onClick = { onSelect(value) },
                    label = { Text(name) }
                )
            }
        }
    }
}

@Composable
fun ReportA4Preview(config: ReportConfig, preferences: UserPreferences) {
    val themeColor = Color(config.themeColor)
    val fontFamily = when(config.fontStyle) {
        ReportFont.SAN_SERIF -> FontFamily.SansSerif
        ReportFont.SERIF -> FontFamily.Serif
        ReportFont.MONOSPACE -> FontFamily.Monospace
    }

    Column(modifier = Modifier.padding(20.dp)) {
        Box(modifier = Modifier.fillMaxWidth().height(2.dp).background(themeColor))
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = config.reportTitle,
            style = MaterialTheme.typography.titleLarge,
            color = themeColor,
            fontWeight = FontWeight.Bold,
            fontFamily = fontFamily,
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
        
        Text("总体表现评估", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = themeColor, fontFamily = fontFamily)
        Spacer(modifier = Modifier.height(8.dp))
        
        // Mock Chart Illustration
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(themeColor.copy(alpha = 0.05f), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = when(config.chartStyle) {
                    ChartStyle.RADAR -> Icons.Default.Hub
                    ChartStyle.BAR -> Icons.Default.BarChart
                    ChartStyle.PIE -> Icons.Default.PieChart
                },
                contentDescription = null,
                tint = themeColor.copy(alpha = 0.4f),
                modifier = Modifier.size(48.dp)
            )
        }
        
        if (config.includeStudentList) {
            Spacer(modifier = Modifier.height(24.dp))
            Text("学生成绩单", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = themeColor, fontFamily = fontFamily)
            Spacer(modifier = Modifier.height(8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                repeat(3) {
                    Box(modifier = Modifier.fillMaxWidth().height(16.dp).background(Color(0xFFF5F5F5)))
                }
            }
        }
    }
}

private fun Modifier.height(_min: Dp, max: Dp) = this.size(width = _min, height = max)

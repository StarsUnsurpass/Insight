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
    var config by remember { mutableStateOf(ReportConfig(reportTitle = "${preferences.className} 瀛︽儏鍛ㄦ姤")) }
    var isGenerating by remember { mutableStateOf(false) }

    // ... (rest of the functions remain same until LazyColumn)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("瀵煎嚭棰勮", style = MaterialTheme.typography.titleMedium) },
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
                        Text("瀵煎嚭", fontWeight = FontWeight.Bold)
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
                Surface(
                    modifier = Modifier
                        .aspectRatio(1f / 1.414f)
                        .fillMaxHeight()
                        .shadow(8.dp, RoundedCornerShape(4.dp)),
                    color = if (config.isHandwritingMode) Color(android.graphics.Color.parseColor(config.handwritingConfig.paperColor)) else Color.White,
                    shape = RoundedCornerShape(4.dp)
                ) {
                    ReportA4Preview(config, preferences)
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
                    item { Text("瀵煎嚭涓€у寲璁剧疆", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold) }
                    
                    item {
                        OutlinedTextField(
                            value = config.reportTitle,
                            onValueChange = { config = config.copy(reportTitle = it) },
                            label = { Text("鎶ュ憡鏍囬") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }

                    item {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("妯℃嫙鎵嬪啓瀵煎嚭", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                                Text("寮€鍚悗灏嗘ā鎷熼€肩湡鐨勬墜鍐欐暀妗堟晥鏋?, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                            }
                            Switch(
                                checked = config.isHandwritingMode,
                                onCheckedChange = { config = config.copy(isHandwritingMode = it) }
                            )
                        }
                    }

                    if (config.isHandwritingMode) {
                        item {
                            HandwritingSettingsPanel(
                                config = config.handwritingConfig,
                                onConfigChange = { config = config.copy(handwritingConfig = it) }
                            )
                        }
                    } else {
                        item {
                            StyleSelector(
                                label = "瀛椾綋椋庢牸",
                                options = listOf("鏃犺‖绾? to ReportFont.SAN_SERIF, "琛嚎" to ReportFont.SERIF, "绛夊" to ReportFont.MONOSPACE),
                                selected = config.fontStyle,
                                onSelect = { config = config.copy(fontStyle = it) }
                            )
                        }

                        item {
                            StyleSelector(
                                label = "鍥捐〃绫诲瀷",
                                options = listOf("闆疯揪鍥? to ChartStyle.RADAR, "鏌辩姸鍥? to ChartStyle.BAR, "楗煎浘" to ChartStyle.PIE),
                                selected = config.chartStyle,
                                onSelect = { config = config.copy(chartStyle = it) }
                            )
                        }
                    }

                    item {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("涓婚鑹插僵", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
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
                            Text("鍖呭惈鎴愮哗鍗?, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
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
                                Text("DeepSeek 鏅鸿兘瀛︽儏鍒嗘瀽", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                                Text("鍩轰簬鏈懆鍏ㄧ彮鏁版嵁鑷姩鐢熸垚娲炲療鎶ュ憡", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
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
                                    Text("鐢熸垚鎶ュ憡", style = MaterialTheme.typography.labelMedium)
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
                                        Text("AI 娲炲療棰勮", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold, color = SageGreen)
                                        if (isStreaming) {
                                            @Suppress("DEPRECATION")
                                            Spacer(Modifier.width(8.dp))
                                            LinearProgressIndicator(modifier = Modifier.weight(1f).height(2.dp), color = SageGreen)
                                        }
                                    }
                                    Spacer(Modifier.height(12.dp))
                                    MarkdownText(
                                        markdown = if (aiOutput.isNotBlank()) aiOutput else "DeepSeek 姝ｅ湪鍒嗘瀽娴烽噺瀛︽儏鏁版嵁...",
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
fun HandwritingSettingsPanel(
    config: HandwritingConfig,
    onConfigChange: (HandwritingConfig) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("鎵嬪啓缁嗚妭璋冭妭", style = MaterialTheme.typography.labelMedium, color = SageGreen, fontWeight = FontWeight.Bold)
        
        HandwritingSlider(
            label = "瀛楀彿闅忔満鎶栧姩",
            value = config.sizeJitter,
            onValueChange = { onConfigChange(config.copy(sizeJitter = it)) },
            valueRange = 0f..0.2f
        )

        HandwritingSlider(
            label = "鍊炬枩闅忔満瑙掑害",
            value = config.rotationJitter,
            onValueChange = { onConfigChange(config.copy(rotationJitter = it)) },
            valueRange = 0f..10f
        )

        HandwritingSlider(
            label = "绗旂敾绮楃粏(鏅曟煋)",
            value = config.inkBlur,
            onValueChange = { onConfigChange(config.copy(inkBlur = it)) },
            valueRange = 0f..2f
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            PaperTypeChip(
                label = "妯嚎绾?, 
                selected = config.paperType == PaperType.LINED,
                onClick = { onConfigChange(config.copy(paperType = PaperType.LINED)) }
            )
            PaperTypeChip(
                label = "缃戞牸绾?, 
                selected = config.paperType == PaperType.GRID,
                onClick = { onConfigChange(config.copy(paperType = PaperType.GRID)) }
            )
            PaperTypeChip(
                label = "鐧界焊", 
                selected = config.paperType == PaperType.NONE,
                onClick = { onConfigChange(config.copy(paperType = PaperType.NONE)) }
            )
        }
    }
}

@Composable
fun HandwritingSlider(
    label: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float>
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(label, style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(1f))
            Text(String.format("%.2f", value), style = MaterialTheme.typography.labelSmall, color = SageGreen)
        }
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = valueRange,
            colors = SliderDefaults.colors(thumbColor = SageGreen, activeTrackColor = SageGreen)
        )
    }
}

@Composable
fun PaperTypeChip(label: String, selected: Boolean, onClick: () -> Unit) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(label) },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = SageGreen.copy(alpha = 0.2f),
            selectedLabelColor = SageGreen
        )
    )
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
            text = "鐝骇锛?{preferences.className} | 2024-03-14",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text("鎬讳綋琛ㄧ幇璇勪及", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = themeColor, fontFamily = fontFamily)
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
            Text("瀛︾敓鎴愮哗鍗?, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = themeColor, fontFamily = fontFamily)
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

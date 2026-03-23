package com.example.insight.ui.util

import android.graphics.Typeface
import android.text.style.BackgroundColorSpan
import android.view.Gravity
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import io.noties.markwon.AbstractMarkwonPlugin
import io.noties.markwon.Markwon
import io.noties.markwon.MarkwonSpansFactory
import io.noties.markwon.core.CorePlugin
import io.noties.markwon.ext.tables.TablePlugin
import io.noties.markwon.html.HtmlPlugin
import org.commonmark.node.StrongEmphasis

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

/**
 * A custom span for highlighting. 
 */
class TallHighlightSpan(val color: Int) : BackgroundColorSpan(color)

@Composable
fun MarkdownText(
    markdown: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textSize: Float = 16f,
    lineSpacingMultiplier: Float = 1.4f,
    letterSpacing: Float? = null,
    wordSpacing: Float? = null,
    typeface: Typeface? = null,
    textAlign: Int = Gravity.START,
    textEffect: Int = 0, // 0=None, 1=Shadow, 2=Scan
    isHighlightBold: Boolean = false,
    highlightColor: Color = Color(0xFFFFEB3B).copy(alpha = 0.6f) 
) {
    val context = LocalContext.current
    val hColor = highlightColor.toArgb()
    
    val markwon = remember(isHighlightBold, hColor) {
        Markwon.builder(context)
            .usePlugin(CorePlugin.create())
            .usePlugin(TablePlugin.create(context))
            .usePlugin(HtmlPlugin.create())
            .apply {
                if (isHighlightBold) {
                    usePlugin(object : AbstractMarkwonPlugin() {
                        override fun configureSpansFactory(builder: MarkwonSpansFactory.Builder) {
                            val originFactory = builder.getFactory(StrongEmphasis::class.java)
                            builder.setFactory(StrongEmphasis::class.java) { configuration, props ->
                                val spans = mutableListOf<Any>()
                                originFactory?.getSpans(configuration, props)?.let { original ->
                                    if (original is Array<*>) {
                                        original.filterNotNull().forEach { spans.add(it) }
                                    } else {
                                        spans.add(original)
                                    }
                                }
                                spans.add(TallHighlightSpan(hColor))
                                spans.toTypedArray()
                            }
                        }
                    })
                }
            }
            .build()
    }

    AndroidView(
        modifier = modifier,
        factory = { ctx ->
            TextView(ctx).apply {
                setTextColor(color.toArgb())
                this.textSize = textSize
                setLineSpacing(0f, lineSpacingMultiplier)
                if (typeface != null) {
                    this.typeface = typeface
                }
                this.gravity = textAlign
            }
        },
        update = { view ->
            view.setTextColor(color.toArgb())
            view.textSize = textSize
            view.setLineSpacing(0f, lineSpacingMultiplier)
            
            // 重新实现 textEffect 逻辑
            when (textEffect) {
                1 -> view.setShadowLayer(5f, 2f, 2f, android.graphics.Color.parseColor("#66000000"))
                2 -> view.setShadowLayer(4f, 0f, 0f, android.graphics.Color.parseColor("#44333333"))
                else -> view.setShadowLayer(0f, 0f, 0f, android.graphics.Color.TRANSPARENT)
            }
            
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                wordSpacing?.let { view.letterSpacing = it }
            }
            letterSpacing?.let { view.letterSpacing = it }

            try {
                // 预处理：修复换行符
                var cleanMarkdown = markdown.replace("\\n", "\n")
                
                // 移除冗余标题（增强正则表达式）
                cleanMarkdown = cleanMarkdown.replace(Regex("(?m)^###.*核心概念详解.*$"), "").trim()
                
                // 核心修复：处理每一行的缩进
                val lines = cleanMarkdown.split("\n")
                val processedLines = mutableListOf<String>()
                var inTable = false
                
                for (line in lines) {
                    val trimmed = line.trim()
                    
                    if (trimmed.startsWith("|")) {
                        // 表格行必须顶格，且上方确保有空行
                        if (!inTable) {
                            if (processedLines.isNotEmpty() && processedLines.last().isNotBlank()) {
                                processedLines.add("")
                            }
                            inTable = true
                        }
                        processedLines.add(trimmed)
                    } else if (trimmed.isEmpty()) {
                        inTable = false
                        processedLines.add("")
                    } else {
                        inTable = false
                        // 关键修复：除了显式的列表项或引用，其余行统一去除首位空格
                        // 这样可以防止 Markwon 将其识别为 indented code block (4个空格以上)
                        if (trimmed.startsWith("* ") || trimmed.startsWith("- ") || trimmed.startsWith(">") || Regex("^\\d+\\.").containsMatchIn(trimmed)) {
                            processedLines.add(trimmed)
                        } else {
                            processedLines.add(trimmed)
                        }
                    }
                }
                cleanMarkdown = processedLines.joinToString("\n")
                
                markwon.setMarkdown(view, cleanMarkdown)
            } catch (e: Exception) {
                view.text = markdown
            }
        }
    )
}

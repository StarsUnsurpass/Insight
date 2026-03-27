package com.example.insight.ui.util

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.text.style.LineBackgroundSpan
import android.text.style.ReplacementSpan
import android.view.Gravity
import android.widget.TextView
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import io.noties.markwon.AbstractMarkwonPlugin
import io.noties.markwon.Markwon
import io.noties.markwon.MarkwonSpansFactory
import io.noties.markwon.core.CorePlugin
import io.noties.markwon.ext.tables.TablePlugin
import io.noties.markwon.html.HtmlPlugin
import org.commonmark.node.StrongEmphasis

/**
 * 自定义荧光笔高亮 Span
 * 1. 颜色鲜艳
 * 2. 高度略窄于行高，防止上下行粘连
 */
class VividMarkerSpan(private val color: Int) : ReplacementSpan() {
    override fun getSize(paint: Paint, text: CharSequence, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
        return paint.measureText(text, start, end).toInt()
    }

    override fun draw(canvas: Canvas, text: CharSequence, start: Int, end: Int, x: Float, top: Int, y: Int, bottom: Int, paint: Paint) {
        val width = paint.measureText(text, start, end)
        val rect = RectF()
        
        // 关键：控制高亮高度，顶部和底部留出 2dp 的空白，防止粘连
        val padding = 4f 
        rect.set(x, top.toFloat() + padding, x + width, bottom.toFloat() - padding)
        
        val oldColor = paint.color
        paint.color = color
        canvas.drawRect(rect, paint)
        
        paint.color = oldColor
        canvas.drawText(text, start, end, x, y.toFloat(), paint)
    }
}

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
    textEffect: Int = 0,
    isHighlightBold: Boolean = false,
    highlightColor: Color = Color(0xFFFFEA00) // 默认使用更鲜艳的荧光黄
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
                                // 使用自定义的窄幅高光 Span
                                spans.add(VividMarkerSpan(hColor))
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
                var cleanMarkdown = markdown.replace("\\n", "\n")
                cleanMarkdown = cleanMarkdown.replace(Regex("(?m)^###.*核心概念详解.*$"), "").trim()
                
                val lines = cleanMarkdown.split("\n")
                val processedLines = mutableListOf<String>()
                var inTable = false
                
                for (line in lines) {
                    val trimmed = line.trim()
                    if (trimmed.startsWith("|")) {
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
                        processedLines.add(trimmed)
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

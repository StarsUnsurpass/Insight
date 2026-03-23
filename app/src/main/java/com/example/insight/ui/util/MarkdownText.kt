package com.example.insight.ui.util

import android.graphics.Typeface
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.CharacterStyle
import android.view.Gravity
import android.widget.TextView
import androidx.annotation.NonNull
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
 * A custom span for highlighting that is slightly taller than the text.
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
    highlightColor: Color = Color(0xFFFFEB3B).copy(alpha = 0.6f) // Default yellow highlight
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
                                // Keep original bold if any
                                originFactory?.getSpans(configuration, props)?.let { spans.addAll(it as Array<Any>) }
                                // Add our highlight span
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
                
                when (textEffect) {
                    1 -> setShadowLayer(5f, 2f, 2f, android.graphics.Color.parseColor("#66000000"))
                    2 -> setShadowLayer(4f, 0f, 0f, android.graphics.Color.parseColor("#44333333"))
                    else -> setShadowLayer(0f, 0f, 0f, android.graphics.Color.TRANSPARENT)
                }
                
                wordSpacing?.let { 
                    if (android.os.Build.VERSION.SDK_INT >= 29) this.letterSpacing = it 
                }
                letterSpacing?.let { this.letterSpacing = it }
            }
        },
        update = { view ->
            view.setTextColor(color.toArgb())
            view.textSize = textSize
            view.setLineSpacing(0f, lineSpacingMultiplier)
            if (typeface != null) {
                view.typeface = typeface
            }
            view.gravity = textAlign
            
            when (textEffect) {
                1 -> view.setShadowLayer(5f, 2f, 2f, android.graphics.Color.parseColor("#66000000"))
                2 -> view.setShadowLayer(4f, 0f, 0f, android.graphics.Color.parseColor("#44333333"))
                else -> view.setShadowLayer(0f, 0f, 0f, android.graphics.Color.TRANSPARENT)
            }
            
            wordSpacing?.let { 
                if (android.os.Build.VERSION.SDK_INT >= 29) view.letterSpacing = it 
            }
            letterSpacing?.let { view.letterSpacing = it }

            // Aggressive Pre-processing
            var cleanMarkdown = markdown.replace("\\n", "\n")
            
            // Remove leading/trailing empty lines
            cleanMarkdown = cleanMarkdown.trim()
            
            // Fix Tables: Markwon TablePlugin is sensitive to indentation and blank lines.
            // We need to ensure each line of a table starts with | and has no leading spaces.
            val lines = cleanMarkdown.split("\n")
            val processedLines = lines.map { line ->
                val trimmed = line.trim()
                if (trimmed.startsWith("|") && trimmed.endsWith("|")) {
                    trimmed // Force table lines to be start-of-line
                } else {
                    line
                }
            }
            cleanMarkdown = processedLines.joinToString("\n")
            
            // Ensure blank line before tables
            cleanMarkdown = cleanMarkdown.replace(Regex("([^\\n])\\n\\|"), "$1\n\n|")
            
            // Fix redundant headers often found in description
            cleanMarkdown = cleanMarkdown.replace(Regex("^###\\s*(馃摉|📖)?\\s*核心概念详解\\s*\\n+"), "")
            
            markwon.setMarkdown(view, cleanMarkdown)
        }
    )
}

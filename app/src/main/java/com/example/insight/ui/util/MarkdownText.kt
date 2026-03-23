package com.example.insight.ui.util

import android.graphics.Typeface
import android.view.Gravity
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import io.noties.markwon.Markwon
import io.noties.markwon.ext.tables.TablePlugin
import io.noties.markwon.html.HtmlPlugin
import io.noties.markwon.core.CorePlugin

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

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
    textEffect: Int = 0 // 0=None, 1=Shadow, 2=Scan
) {
    val context = LocalContext.current
    val markwon = remember {
        Markwon.builder(context)
            .usePlugin(CorePlugin.create())
            .usePlugin(TablePlugin.create(context))
            .usePlugin(HtmlPlugin.create())
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
                
                // Set shadow layer based on textEffect
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

            // Pre-process markdown to fix common issues
            var cleanMarkdown = markdown.replace("\\n", "\n")
            
            // Ensure blank line before tables (CommonMark requirement for many parsers)
            cleanMarkdown = cleanMarkdown.replace(Regex("([^\\n])\\n\\|"), "$1\n\n|")
            
            // Ensure blank line before lists if they follow text directly
            cleanMarkdown = cleanMarkdown.replace(Regex("([^\\n])\\n(\\d+\\.)"), "$1\n\n$2")
            cleanMarkdown = cleanMarkdown.replace(Regex("([^\\n])\\n(\\* )"), "$1\n\n$2")
            
            markwon.setMarkdown(view, cleanMarkdown)
        }
    )
}

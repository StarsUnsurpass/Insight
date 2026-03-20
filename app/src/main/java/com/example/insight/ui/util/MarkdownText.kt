package com.example.insight.ui.util

import android.graphics.Typeface
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import io.noties.markwon.Markwon
import io.noties.markwon.ext.tables.TablePlugin
import io.noties.markwon.html.HtmlPlugin

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

@Composable
fun MarkdownText(
    markdown: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textSize: Float? = null,
    lineSpacingMultiplier: Float? = null,
    letterSpacing: Float? = null,
    typeface: Typeface? = null
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            TextView(context).apply {
                setTextColor(color.toArgb())
                textSize?.let { this.textSize = it }
                lineSpacingMultiplier?.let { setLineSpacing(0f, it) }
                letterSpacing?.let { this.letterSpacing = it }
                if (typeface != null) {
                    this.typeface = typeface
                }
                val markwon = Markwon.builder(context)
                    .usePlugin(TablePlugin.create(context))
                    .usePlugin(HtmlPlugin.create())
                    .build()
                tag = markwon
            }
        },
        update = { view ->
            view.setTextColor(color.toArgb())
            textSize?.let { view.textSize = it }
            lineSpacingMultiplier?.let { view.setLineSpacing(0f, it) }
            letterSpacing?.let { view.letterSpacing = it }
            if (typeface != null) {
                view.typeface = typeface
            }
            val markwon = view.tag as Markwon
            markwon.setMarkdown(view, markdown)
        }
    )
}

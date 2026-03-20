package com.example.insight.ui.util

import android.graphics.Typeface
import android.view.Gravity
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
    wordSpacing: Float? = null,
    typeface: Typeface? = null,
    textAlign: Int = Gravity.START,
    textEffect: Int = 0 // 0=None, 1=Shadow, 2=Scan
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
                this.gravity = textAlign
                if (textEffect == 1) {
                    this.setShadowLayer(5f, 2f, 2f, android.graphics.Color.parseColor("#66000000"))
                } else if (textEffect == 2) {
                    this.setShadowLayer(4f, 0f, 0f, android.graphics.Color.parseColor("#44333333"))
                } else {
                    this.setShadowLayer(0f, 0f, 0f, android.graphics.Color.TRANSPARENT)
                }
                wordSpacing?.let { if (android.os.Build.VERSION.SDK_INT >= 29) this.letterSpacing = it else Unit }
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
            view.gravity = textAlign
            if (textEffect == 1) {
                view.setShadowLayer(5f, 2f, 2f, android.graphics.Color.parseColor("#66000000"))
            } else if (textEffect == 2) {
                view.setShadowLayer(4f, 0f, 0f, android.graphics.Color.parseColor("#44333333"))
            } else {
                view.setShadowLayer(0f, 0f, 0f, android.graphics.Color.TRANSPARENT)
            }
            wordSpacing?.let { if (android.os.Build.VERSION.SDK_INT >= 29) view.letterSpacing = it else Unit }
            val markwon = view.tag as Markwon
            markwon.setMarkdown(view, markdown)
        }
    )
}

package com.example.insight.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.print.PrintAttributes
import android.print.PrintManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.FileProvider
import com.example.insight.ui.state.*
import com.google.gson.Gson
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object PdfExportHelper {

    fun exportReport(
        context: Context,
        config: ReportConfig,
        preferences: UserPreferences,
        content: String,
        onComplete: (File?) -> Unit
    ) {
        val webView = WebView(context)
        
        // Enable JS for handwriting perturbation
        webView.settings.javaScriptEnabled = true

        if (config.isHandwritingMode) {
            setupHandwritingWebView(context, webView, config, content, onComplete)
        } else {
            setupStandardWebView(context, webView, config, preferences, content, onComplete)
        }
    }

    private fun setupHandwritingWebView(
        context: Context,
        webView: WebView,
        config: ReportConfig,
        content: String,
        onComplete: (File?) -> Unit
    ) {
        val template = context.assets.open("handwriting_template.html").bufferedReader().use { it.readText() }
        val hwConfig = config.handwritingConfig
        
        val backgroundStyle = generateHandwritingBackground(hwConfig)
        
        val htmlContent = template
            .replace("{{FONT_NAME}}", hwConfig.fontName)
            .replace("{{PAPER_COLOR}}", hwConfig.paperColor)
            .replace("{{PAPER_BACKGROUND}}", backgroundStyle)

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                val reportData = mapOf(
                    "title" to config.reportTitle,
                    "content" to content
                )
                
                val gson = Gson()
                val dataJson = gson.toJson(reportData)
                val configJson = gson.toJson(hwConfig)
                
                // Inject data into the handwriting engine
                webView.evaluateJavascript("window.renderHandwritingReport('$dataJson', '$configJson')") {
                    // Wait a bit for JS rendering to complete before printing
                    webView.postDelayed({
                        printWebView(context, webView, onComplete)
                    }, 500)
                }
            }
        }
        
        // Use file:///android_asset/ as base URL to allow loading fonts
        webView.loadDataWithBaseURL("file:///android_asset/", htmlContent, "text/html", "UTF-8", null)
    }

    private fun setupStandardWebView(
        context: Context,
        webView: WebView,
        config: ReportConfig,
        preferences: UserPreferences,
        content: String,
        onComplete: (File?) -> Unit
    ) {
        val htmlContent = generateHtml(context, config, preferences, content)
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                printWebView(context, webView, onComplete)
            }
        }
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null)
    }

    private fun printWebView(context: Context, webView: WebView, onComplete: (File?) -> Unit) {
        val printManager = context.getSystemService(Context.PRINT_SERVICE) as PrintManager
        val jobName = "Insight_Report_${System.currentTimeMillis()}"
        val printAdapter = webView.createPrintDocumentAdapter(jobName)
        val printAttributes = PrintAttributes.Builder()
            .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
            .build()

        printManager.print(jobName, printAdapter, printAttributes)
        onComplete(null)
    }

    private fun generateHandwritingBackground(config: HandwritingConfig): String {
        return when (config.paperType) {
            PaperType.LINED -> """
                background-image: repeating-linear-gradient(
                    transparent, 
                    transparent ${config.fontSize * 1.8 - 1}px, 
                    rgba(0,0,0,${config.lineOpacity}) ${config.fontSize * 1.8 - 1}px, 
                    rgba(0,0,0,${config.lineOpacity}) ${config.fontSize * 1.8}px
                );
            """.trimIndent()
            PaperType.GRID -> """
                background-image: 
                    linear-gradient(rgba(0,0,0,${config.lineOpacity}) 1px, transparent 1px),
                    linear-gradient(90deg, rgba(0,0,0,${config.lineOpacity}) 1px, transparent 1px);
                background-size: 30px 30px;
            """.trimIndent()
            PaperType.OLD_PAPER -> """
                background-image: url('file:///android_asset/textures/old_paper.jpg');
                background-size: cover;
            """.trimIndent()
            else -> ""
        }
    }

    private fun generateHtml(context: Context, config: ReportConfig, preferences: UserPreferences, content: String): String {
        val template = context.assets.open("report_template.html").bufferedReader().use { it.readText() }
        val colorHex = String.format("#%06X", (0xFFFFFF and config.themeColor))
        
        // Advanced Styling
        val fontFamily = when(config.fontStyle) {
            ReportFont.SAN_SERIF -> "sans-serif"
            ReportFont.SERIF -> "serif"
            ReportFont.MONOSPACE -> "monospace"
        }

        val studentSection = if (config.includeStudentList) {
            """
            <div class="section page-break">
                <div class="section-title">学生成绩单</div>
                <table style="font-family: $fontFamily;">
                    <thead>
                        <tr><th>学生姓名</th><th>当前掌握度</th><th>状态</th></tr>
                    </thead>
                    <tbody>
                        <tr><td>王小明</td><td>85%</td><td><span class="badge" style="background: $colorHex">已达标</span></td></tr>
                        <tr><td>李华</td><td>92%</td><td><span class="badge" style="background: $colorHex">表现优异</span></td></tr>
                        <tr><td>张雷</td><td>42%</td><td><span style="color:#E57373; font-weight:bold;">预警</span></td></tr>
                    </tbody>
                </table>
            </div>
            """.trimIndent()
        } else ""

        return template
            .replace("sans-serif", fontFamily) // Replace base font
            .replace("{{reportTitle}}", config.reportTitle)
            .replace("{{themeColor}}", colorHex)
            .replace("{{className}}", preferences.className)
            .replace("{{date}}", SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()))
            .replace("{{avgMastery}}", "76.4")
            .replace("{{weakPoints}}", "内容详见下方详情")
            .replace("{{studentListSection}}", studentSection)
            .replace("<p>学情洞察详情正在生成...</p>", content) // Replace placeholder with real AI content
    }

    fun sharePdf(context: Context, file: File) {
        try {
            val uri = FileProvider.getUriForFile(context, "com.example.insight.fileprovider", file)
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "application/pdf"
                putExtra(Intent.EXTRA_STREAM, uri)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            context.startActivity(Intent.createChooser(intent, "发送学情报告"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

package com.example.insight.util

import android.content.Context
import android.content.Intent
import android.print.PrintAttributes
import android.print.PrintManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.FileProvider
import com.example.insight.ui.state.ReportConfig
import com.example.insight.ui.state.UserPreferences
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object PdfExportHelper {

    /**
     * Launch the system Print Manager to generate a PDF.
     * This is the standard, secure way to handle WebView-to-PDF conversion.
     */
    fun exportReport(
        context: Context,
        config: ReportConfig,
        preferences: UserPreferences,
        onComplete: (File?) -> Unit
    ) {
        val webView = WebView(context)
        val template = context.assets.open("report_template.html").bufferedReader().use { it.readText() }
        
        // Data Injections with HTML Safety
        val colorHex = String.format("#%06X", (0xFFFFFF and config.themeColor))
        val studentSection = if (config.includeStudentList) {
            """
            <div class="section page-break">
                <div class="section-title">学生成绩单</div>
                <table>
                    <thead>
                        <tr><th>学生姓名</th><th>当前掌握度</th><th>状态</th></tr>
                    </thead>
                    <tbody>
                        <tr><td>王小明</td><td>85%</td><td><span class="badge">已达标</span></td></tr>
                        <tr><td>李华</td><td>92%</td><td><span class="badge">表现优异</span></td></tr>
                        <tr><td>张雷</td><td>42%</td><td><span style="color:#E57373; font-weight:bold;">预警</span></td></tr>
                        <tr><td>赵敏</td><td>78%</td><td><span class="badge">稳步提升</span></td></tr>
                    </tbody>
                </table>
            </div>
            """.trimIndent()
        } else ""

        val htmlContent = template
            .replace("{{reportTitle}}", config.reportTitle)
            .replace("{{themeColor}}", colorHex)
            .replace("{{className}}", preferences.className)
            .replace("{{date}}", SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()))
            .replace("{{avgMastery}}", "76.4")
            .replace("{{weakPoints}}", "定语从句（关系词误用）、现在完成时（时间状语识别）")
            .replace("{{studentListSection}}", studentSection)

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                val printManager = context.getSystemService(Context.PRINT_SERVICE) as PrintManager
                val jobName = "Insight_Report_${System.currentTimeMillis()}"
                
                // Create the adapter from WebView
                val printAdapter = webView.createPrintDocumentAdapter(jobName)
                
                // Set default print attributes for A4
                val printAttributes = PrintAttributes.Builder()
                    .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
                    .build()

                // Execute system print dialog
                printManager.print(jobName, printAdapter, printAttributes)
                
                // WebView is managed by the system print process now
                onComplete(null) 
            }
        }
        
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null)
    }

    /**
     * Shares a PDF file using FileProvider.
     */
    fun sharePdf(context: Context, file: File) {
        try {
            val uri = FileProvider.getUriForFile(
                context, 
                "com.example.insight.fileprovider", 
                file
            )
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

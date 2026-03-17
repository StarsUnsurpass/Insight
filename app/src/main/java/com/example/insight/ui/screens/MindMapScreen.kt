package com.example.insight.ui.screens

import android.annotation.SuppressLint
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.viewinterop.AndroidView
import com.example.insight.ui.state.UserPreferences

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MindMapScreen(
    preferences: UserPreferences,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("AI 思维导图", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            MindMapWebView(preferences)
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun MindMapWebView(preferences: UserPreferences) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                webChromeClient = WebChromeClient()
                settings.apply {
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    loadWithOverviewMode = true
                    useWideViewPort = true
                    builtInZoomControls = true
                    displayZoomControls = false
                    mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                }
                
                // Interface for API injection
                addJavascriptInterface(object {
                    @JavascriptInterface
                    fun getApiUrl(): String {
                        // DeepSeek URL is fixed
                        return "https://api.deepseek.com/chat/completions"
                    }

                    @JavascriptInterface
                    fun getApiKey(): String {
                        return preferences.deepSeekApiKey
                    }
                }, "InsightApp")

                loadUrl("file:///android_asset/mindmap.html")
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

package com.example.insight

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.LinearEasing
import androidx.core.view.WindowCompat
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.insight.ui.navigation.InsightNavHost
import com.example.insight.ui.screens.SplashScreen
import com.example.insight.ui.state.InsightViewModel
import com.example.insight.ui.theme.InsightTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            showContent()
        } else {
            Toast.makeText(this, "需要摄像头权限才能使用扫描功能", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                showContent()
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun showContent() {
        androidx.core.view.WindowCompat.setDecorFitsSystemWindows(window, false)
        
        setContent {
            // 首先独立显示开屏，不等待 ViewModel 初始化
            var showSplash by remember { mutableStateOf(true) }

            if (showSplash) {
                // 在极简主题下渲染开屏，确保第一帧秒出
                SplashScreen {
                    showSplash = false
                }
            } else {
                // 仅在动画结束后进行 Hilt/ViewModel 的重型初始化
                val viewModel: InsightViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsState()
                val preferences = uiState.preferences

                InsightTheme(
                    style = preferences.themeStyle,
                    darkTheme = preferences.isDarkMode
                ) {
                    androidx.compose.animation.Crossfade(
                        targetState = false, // 此时由于 showSplash 为 false，实际上这里执行切换
                        animationSpec = tween(durationMillis = 800),
                        label = "AppReveal"
                    ) { _ ->
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            InsightNavHost(viewModel)
                        }
                    }
                }
            }
        }
    }
}

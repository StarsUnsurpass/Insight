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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

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
        installSplashScreen()
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
            var showSplash by remember { mutableStateOf(true) }

            InsightTheme { // 使用默认主题渲染
                androidx.compose.animation.Crossfade(
                    targetState = showSplash,
                    animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
                    label = "AppReveal"
                ) { isSplash ->
                    if (isSplash) {
                        SplashScreen {
                            showSplash = false
                        }
                    } else {
                        // 动画结束后正式初始化 ViewModel
                        val viewModel: InsightViewModel = hiltViewModel()
                        val uiState by viewModel.uiState.collectAsState()
                        val preferences = uiState.preferences

                        // 再次应用正式主题（支持暗色模式/样式切换）
                        InsightTheme(
                            style = preferences.themeStyle,
                            darkTheme = preferences.isDarkMode
                        ) {
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
}

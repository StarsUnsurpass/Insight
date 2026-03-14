package com.example.insight.ui.state

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class InsightViewModel @Inject constructor(
    private val application: Application
) : ViewModel() {
    
    private val prefs = application.getSharedPreferences("insight_prefs", Context.MODE_PRIVATE)

    private val _uiState = MutableStateFlow(InsightUiState(preferences = loadPreferences()))
    val uiState: StateFlow<InsightUiState> = _uiState.asStateFlow()

    private fun loadPreferences(): UserPreferences {
        return UserPreferences(
            username = prefs.getString("username", "用户") ?: "用户",
            className = prefs.getString("className", "一年级一班") ?: "一年级一班",
            role = UserRole.valueOf(prefs.getString("role", UserRole.Teacher.name) ?: UserRole.Teacher.name),
            isDarkMode = prefs.getBoolean("isDarkMode", false),
            themeStyle = ThemeStyle.valueOf(prefs.getString("themeStyle", ThemeStyle.Default.name) ?: ThemeStyle.Default.name),
            hapticEnabled = prefs.getBoolean("hapticEnabled", true)
        )
    }

    private fun savePreference(key: String, value: Any) {
        with(prefs.edit()) {
            when (value) {
                is String -> putString(key, value)
                is Boolean -> putBoolean(key, value)
                is Int -> putInt(key, value)
                is Enum<*> -> putString(key, value.name)
            }
            apply()
        }
    }

    fun onTextCaptured(text: String) {
        _uiState.update { it.copy(screen = ScreenState.Analyzing(text)) }
        startAnalysis(text)
    }

    private fun startAnalysis(text: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isStreaming = true) }
            android.util.Log.d("InsightVM", "Analyzing text: $text")
            delay(2000)
            val mockSolution = "基于题目解析：这是一个经典的虚拟语气结构。在本句中，'If' 引导的条件句使用了过去完成时，表示对过去的虚拟..."
            val mockConcepts = listOf("虚拟语气", "混合时态", "If条件句")
            
            _uiState.update { 
                it.copy(
                    screen = ScreenState.Solution(mockSolution, mockConcepts),
                    isStreaming = false
                ) 
            }
        }
    }

    fun updateUsername(name: String) {
        _uiState.update { it.copy(preferences = it.preferences.copy(username = name)) }
        savePreference("username", name)
    }

    fun updateClassName(name: String) {
        _uiState.update { it.copy(preferences = it.preferences.copy(className = name)) }
        savePreference("className", name)
    }

    fun updateUserRole(role: UserRole) {
        _uiState.update { it.copy(preferences = it.preferences.copy(role = role)) }
        savePreference("role", role)
    }

    fun updateDarkMode(enabled: Boolean) {
        _uiState.update { it.copy(preferences = it.preferences.copy(isDarkMode = enabled)) }
        savePreference("isDarkMode", enabled)
    }

    fun updateThemeStyle(style: ThemeStyle) {
        _uiState.update { it.copy(preferences = it.preferences.copy(themeStyle = style)) }
        savePreference("themeStyle", style)
    }

    fun updateHapticFeedback(enabled: Boolean) {
        _uiState.update { it.copy(preferences = it.preferences.copy(hapticEnabled = enabled)) }
        savePreference("hapticEnabled", enabled)
    }

    fun reset() {
        _uiState.update { it.copy(screen = ScreenState.Scanning) }
    }

    fun showGraph() {
        _uiState.update { it.copy(screen = ScreenState.Graph) }
    }

    fun closeGraph() {
        _uiState.update { it.copy(screen = it.screen) }
    }
}

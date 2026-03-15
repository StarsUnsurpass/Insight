package com.example.insight.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.repository.InsightRepository
import com.example.insight.data.repository.DeepSeekRepository
import com.example.insight.data.remote.DeepSeekMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import javax.inject.Inject

import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognizer
import android.graphics.Bitmap

@HiltViewModel
class InsightViewModel @Inject constructor(
    private val repository: InsightRepository,
    private val deepSeekRepository: DeepSeekRepository,
    private val textRecognizer: TextRecognizer
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(InsightUiState())
    val uiState: StateFlow<InsightUiState> = _uiState.asStateFlow()

    private val _aiOutput = MutableStateFlow("")
    val aiOutput: StateFlow<String> = _aiOutput.asStateFlow()

    init {
        // Collect preferences from DataStore
        viewModelScope.launch {
            repository.userPreferencesFlow.collect { prefs ->
                _uiState.update { it.copy(preferences = prefs) }
            }
        }
    }

    fun onImageCaptured(bitmap: Bitmap) {
        val image = InputImage.fromBitmap(bitmap, 0)
        _uiState.update { it.copy(screen = ScreenState.Analyzing("正在识别文字...")) }
        
        textRecognizer.process(image)
            .addOnSuccessListener { visionText ->
                val text = visionText.text
                if (text.isNotBlank()) {
                    onTextCaptured(text)
                } else {
                    _uiState.update { it.copy(screen = ScreenState.Scanning) }
                }
            }
            .addOnFailureListener {
                _uiState.update { it.copy(screen = ScreenState.Scanning) }
            }
    }

    fun onTextCaptured(text: String) {
        _uiState.update { it.copy(screen = ScreenState.Solution(content = "", concepts = emptyList(), capturedText = text)) }
        startAnalysis(text)
    }

    private fun startAnalysis(text: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isStreaming = true) }
            _aiOutput.value = ""
            
            val apiKey = uiState.value.preferences.deepSeekApiKey
            if (apiKey.isBlank()) {
                _aiOutput.value = "请先在设置中配置 DeepSeek API Key"
                _uiState.update { it.copy(isStreaming = false) }
                return@launch
            }

            try {
                deepSeekRepository.streamChat(
                    apiKey,
                    listOf(
                        DeepSeekMessage("system", "你是一位资深的英语老师。请详细解析以下内容，指出考点和解题思路。使用 Markdown 格式。"),
                        DeepSeekMessage("user", text)
                    )
                ).collect { chunk ->
                    _aiOutput.value += chunk
                }
            } catch (e: Exception) {
                _aiOutput.value = "分析出错: ${e.message}"
            } finally {
                _uiState.update { it.copy(isStreaming = false) }
            }
        }
    }

    fun generateWeeklyReport() {
        viewModelScope.launch {
            val apiKey = uiState.value.preferences.deepSeekApiKey
            if (apiKey.isBlank()) {
                _aiOutput.value = "请先在设置中配置 DeepSeek API Key"
                return@launch
            }

            _uiState.update { it.copy(isStreaming = true) }
            _aiOutput.value = ""
            
            try {
                deepSeekRepository.generateWeeklyReport(apiKey).collect { chunk ->
                    _aiOutput.value += chunk
                }
            } catch (e: Exception) {
                _aiOutput.value = "生成报告出错: ${e.message}"
            } finally {
                _uiState.update { it.copy(isStreaming = false) }
            }
        }
    }

    fun generateSimilarQuestions(text: String) {
        viewModelScope.launch {
            val apiKey = uiState.value.preferences.deepSeekApiKey
            if (apiKey.isBlank()) {
                _aiOutput.value = "请先在设置中配置 DeepSeek API Key"
                return@launch
            }

            _uiState.update { it.copy(isStreaming = true) }
            _aiOutput.value = ""
            
            try {
                deepSeekRepository.getSimilarQuestions(apiKey, text).collect { chunk ->
                    _aiOutput.value += chunk
                }
            } catch (e: Exception) {
                _aiOutput.value = "生成相似题出错: ${e.message}"
            } finally {
                _uiState.update { it.copy(isStreaming = false) }
            }
        }
    }

    fun updateDeepSeekApiKey(key: String) {
        viewModelScope.launch { repository.updateDeepSeekApiKey(key) }
    }

    fun updateUsername(name: String) {
        viewModelScope.launch { repository.updateUsername(name) }
    }

    fun updateClassName(name: String) {
        viewModelScope.launch { repository.updateClassName(name) }
    }

    fun updateUserRole(role: UserRole) {
        viewModelScope.launch { repository.updateUserRole(role) }
    }

    fun updateDarkMode(enabled: Boolean) {
        viewModelScope.launch { repository.updateDarkMode(enabled) }
    }

    fun updateThemeStyle(style: ThemeStyle) {
        viewModelScope.launch { repository.updateThemeStyle(style) }
    }

    fun updateHapticFeedback(enabled: Boolean) {
        viewModelScope.launch { repository.updateHapticFeedback(enabled) }
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

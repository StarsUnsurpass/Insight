package com.example.insight.ui.state

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
class InsightViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(InsightUiState())
    val uiState: StateFlow<InsightUiState> = _uiState.asStateFlow()

    fun onTextCaptured(text: String) {
        _uiState.update { it.copy(screen = ScreenState.Analyzing(text)) }
        startAnalysis(text)
    }

    private fun startAnalysis(text: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isStreaming = true) }
            // Simulate AI delay and logic
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

    fun reset() {
        _uiState.update { InsightUiState(screen = ScreenState.Scanning) }
    }

    fun showGraph() {
        _uiState.update { it.copy(screen = ScreenState.Graph) }
    }

    fun closeGraph() {
        // Return to the last solution or scan
        _uiState.update { it.copy(screen = it.screen) } // Simple toggle for now
    }
}

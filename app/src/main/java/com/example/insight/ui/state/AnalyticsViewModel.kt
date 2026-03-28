package com.example.insight.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.repository.DeepSeekRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val repository: DeepSeekRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AnalyticsState())
    val uiState: StateFlow<AnalyticsState> = _uiState.asStateFlow()

    init {
        // 模拟加载真实学情
        loadAnalytics()
    }

    private fun loadAnalytics() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            // 未来这里将调用 repository 获取真实数据并请求 AI 诊断
            // 暂时使用 AnalyticsState 的默认 Mock 数据
            _uiState.update { 
                it.copy(
                    isLoading = false,
                    aiSummary = "本周你非常努力，完成了 45 道题的攻克！我注意到你在‘语法重构’上进步显著，但‘篇章逻辑’依然是你的软肋。别担心，系统已为你准备了针对性处方。"
                ) 
            }
        }
    }

    fun updateView(viewType: AnalyticsViewType) {
        _uiState.update { it.copy(selectedView = viewType) }
    }
}

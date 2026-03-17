package com.example.insight.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.repository.DeepSeekRepository
import com.example.insight.data.remote.DeepSeekMessage
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import java.lang.StringBuilder

@HiltViewModel
class MindMapViewModel @Inject constructor(private val repository: DeepSeekRepository) : ViewModel() {

    private val _rootNode = MutableStateFlow<MindMapNode?>(null)
    val rootNode = _rootNode.asStateFlow()

    private val _isGenerating = MutableStateFlow(false)
    val isGenerating = _isGenerating.asStateFlow()

    private val gson = Gson()

    private fun generateSystemPrompt() = """
        你是一个资深的初中英语教研专家兼数据结构工程师。
        你的任务是：根据用户提供的教学主题，提取核心知识框架，并将其转化为一个层级分明的思维导图。

        【输出格式绝对要求】
        你必须且只能输出合法的、纯净的 JSON 字符串。
        绝对禁止输出任何 Markdown 标记（如 ```json 和 ```）。
        绝对禁止包含任何解释性文本、问候语或总结语。你的输出必须以 "{" 开始，以 "}" 结束。

        【数据结构定义 (JSON Schema)】
        {
          "id": "root_01",
          "title": "核心主题名称",
          "nodeType": "root",
          "tags": ["重点"],
          "children": [
            {
              "id": "branch_01",
              "title": "一级子分类",
              "nodeType": "branch",
              "tags": [],
              "children": []
            }
          ]
        }
        要求：最多嵌套 4 层。文本精简。
    """.trimIndent()

    fun generateMindMap(topic: String, apiKey: String) {
        viewModelScope.launch {
            _isGenerating.value = true
            try {
                val fullPrompt = "用户给定的教学主题是：[${topic}]\n请立即输出 JSON："
                val messages = listOf(
                    DeepSeekMessage("system", generateSystemPrompt()),
                    DeepSeekMessage("user", fullPrompt)
                )
                
                val contentBuilder = StringBuilder()
                repository.streamChat(apiKey, messages).collect { chunk ->
                    contentBuilder.append(chunk)
                }
                
                parseAndSetNode(contentBuilder.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isGenerating.value = false
            }
        }
    }

    private fun parseAndSetNode(rawJson: String) {
        try {
            val cleanJson = rawJson
                .replace("```json", "")
                .replace("```", "")
                .trim()
            val node = gson.fromJson(cleanJson, MindMapNode::class.java)
            _rootNode.value = node
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

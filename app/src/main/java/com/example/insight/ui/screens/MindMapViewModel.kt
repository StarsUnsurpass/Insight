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
            _rootNode.value = null // 清空旧的
            try {
                val fullPrompt = "用户给定的教学主题是：[${topic}]\n请立即输出 JSON："
                val messages = listOf(
                    DeepSeekMessage("system", generateSystemPrompt()),
                    DeepSeekMessage("user", fullPrompt)
                )
                
                val contentBuilder = StringBuilder()
                repository.streamChat(apiKey, messages).collect { chunk ->
                    contentBuilder.append(chunk)
                    // 尝试在每一步解析，实现流式更新 UI
                    tryParseAndSetNode(contentBuilder.toString())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isGenerating.value = false
            }
        }
    }

    private fun tryParseAndSetNode(rawJson: String) {
        try {
            // 简单清洗逻辑，处理大模型不听话的情况
            val cleanJson = rawJson
                .replace("```json", "")
                .replace("```", "")
                .trim()
            
            // 尝试闭合不完整的 JSON（如果流没结束，Gson 会报错，我们捕捉它）
            // 注意：Gson 不支持解析不完整 JSON。如果需要极高频率更新，
            // 通常需要更复杂的解析器，这里我们利用 try-catch，
            // 只有当一段完整的 JSON 块到达时才更新。
            val node = gson.fromJson(cleanJson, MindMapNode::class.java)
            if (node != null) {
                _rootNode.value = node
            }
        } catch (e: Exception) {
            // 解析失败（数据不完整），保持旧状态，等待下一块数据
        }
    }
}

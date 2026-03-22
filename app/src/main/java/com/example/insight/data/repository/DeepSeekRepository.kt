package com.example.insight.data.repository

import com.example.insight.data.local.dao.DiagnosticDao
import com.example.insight.data.local.dao.KnowledgeDao
import com.example.insight.data.local.dao.ScanDao
import com.example.insight.data.remote.DeepSeekApiService
import com.example.insight.data.remote.DeepSeekMessage
import com.example.insight.data.remote.DeepSeekRequest
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.ResponseBody
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeepSeekRepository @Inject constructor(
    private val apiService: DeepSeekApiService,
    private val scanDao: ScanDao,
    private val knowledgeDao: KnowledgeDao,
    private val diagnosticDao: DiagnosticDao
) {
    private val gson = Gson()

    suspend fun streamChat(apiKey: String, messages: List<DeepSeekMessage>): Flow<String> = flow {
        val request = DeepSeekRequest(messages = messages, stream = true)
        val response = apiService.chatCompletionsStream("Bearer $apiKey", request).execute()
        
        if (response.isSuccessful) {
            val reader = BufferedReader(InputStreamReader(response.body()?.byteStream()))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                if (line?.startsWith("data: ") == true) {
                    val data = line?.substring(6)
                    if (data == "[DONE]") break
                    
                    try {
                        val chunk = gson.fromJson(data, DeepSeekStreamChunk::class.java)
                        val content = chunk.choices.firstOrNull()?.delta?.content
                        if (content != null) {
                            emit(content)
                        }
                    } catch (e: Exception) {
                        // Skip malformed chunks
                    }
                }
            }
        } else {
            throw Exception("DeepSeek API error: ${response.code()}")
        }
    }.flowOn(Dispatchers.IO)

    suspend fun generateWeeklyReport(apiKey: String): Flow<String> = flow {
        val scans = scanDao.getAllScans()
        val nodes = knowledgeDao.getAllNodes().firstOrNull() ?: emptyList()
        
        val contextData = mapOf(
            "total_scans" to scans.size,
            "mastered_count" to scans.count { it.isMastered },
            "knowledge_status" to nodes.map { mapOf("title" to it.title) }
        )

        val systemPrompt = """
            你是一位资深的中学英语高级教师。以下是该生本周的学习数据：
            ${gson.toJson(contextData)}
            
            请分析其核心弱点，并以专业、温和的口吻输出一份包含“学情洞察”、“归因分析”和“下周教学重点建议”的报告，严格使用 Markdown 格式。
        """.trimIndent()

        val messages = listOf(
            DeepSeekMessage("system", systemPrompt),
            DeepSeekMessage("user", "生成本周学情报告")
        )
        
        streamChat(apiKey, messages).collect { emit(it) }
    }.flowOn(Dispatchers.IO)

    suspend fun getSimilarQuestions(apiKey: String, capturedText: String): Flow<String> = flow {
        val systemPrompt = "你是一位英语出题专家。请根据用户提供的错题内容，给出3道难度相近、考点相同的相似练习题，并附带解析。请使用 Markdown 格式。"
        val messages = listOf(
            DeepSeekMessage("system", systemPrompt),
            DeepSeekMessage("user", "基于以下错题：\n$capturedText")
        )
        streamChat(apiKey, messages).collect { emit(it) }
    }.flowOn(Dispatchers.IO)
}

data class DeepSeekStreamChunk(
    val choices: List<DeepSeekStreamChoice>
)

data class DeepSeekStreamChoice(
    val delta: DeepSeekStreamDelta
)

data class DeepSeekStreamDelta(
    val content: String?
)

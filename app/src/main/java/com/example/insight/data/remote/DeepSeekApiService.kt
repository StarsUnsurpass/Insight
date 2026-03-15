package com.example.insight.data.remote

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Streaming

data class DeepSeekRequest(
    val model: String = "deepseek-chat",
    val messages: List<DeepSeekMessage>,
    val stream: Boolean = false,
    val temperature: Float = 0.7f
)

data class DeepSeekMessage(
    val role: String,
    val content: String
)

data class DeepSeekResponse(
    val id: String,
    val choices: List<DeepSeekChoice>
)

data class DeepSeekChoice(
    val message: DeepSeekMessage,
    val finish_reason: String?
)

interface DeepSeekApiService {
    @POST("chat/completions")
    suspend fun chatCompletions(
        @Header("Authorization") apiKey: String,
        @Body request: DeepSeekRequest
    ): DeepSeekResponse

    @Streaming
    @POST("chat/completions")
    fun chatCompletionsStream(
        @Header("Authorization") apiKey: String,
        @Body request: DeepSeekRequest
    ): Call<ResponseBody>
}

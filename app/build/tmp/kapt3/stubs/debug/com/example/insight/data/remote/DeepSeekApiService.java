package com.example.insight.data.remote;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Streaming;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/insight/data/remote/DeepSeekApiService;", "", "chatCompletions", "Lcom/example/insight/data/remote/DeepSeekResponse;", "apiKey", "", "request", "Lcom/example/insight/data/remote/DeepSeekRequest;", "(Ljava/lang/String;Lcom/example/insight/data/remote/DeepSeekRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chatCompletionsStream", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "app_debug"})
public abstract interface DeepSeekApiService {
    
    @retrofit2.http.POST(value = "chat/completions")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object chatCompletions(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.insight.data.remote.DeepSeekRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.insight.data.remote.DeepSeekResponse> $completion);
    
    @retrofit2.http.Streaming()
    @retrofit2.http.POST(value = "chat/completions")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<okhttp3.ResponseBody> chatCompletionsStream(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.insight.data.remote.DeepSeekRequest request);
}
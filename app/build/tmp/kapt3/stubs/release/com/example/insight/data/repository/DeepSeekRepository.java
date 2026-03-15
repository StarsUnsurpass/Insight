package com.example.insight.data.repository;

import com.example.insight.data.local.dao.DiagnosticDao;
import com.example.insight.data.local.dao.KnowledgeDao;
import com.example.insight.data.local.dao.ScanDao;
import com.example.insight.data.remote.DeepSeekApiService;
import com.example.insight.data.remote.DeepSeekMessage;
import com.example.insight.data.remote.DeepSeekRequest;
import com.google.gson.Gson;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import okhttp3.ResponseBody;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0014J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/insight/data/repository/DeepSeekRepository;", "", "apiService", "Lcom/example/insight/data/remote/DeepSeekApiService;", "scanDao", "Lcom/example/insight/data/local/dao/ScanDao;", "knowledgeDao", "Lcom/example/insight/data/local/dao/KnowledgeDao;", "diagnosticDao", "Lcom/example/insight/data/local/dao/DiagnosticDao;", "(Lcom/example/insight/data/remote/DeepSeekApiService;Lcom/example/insight/data/local/dao/ScanDao;Lcom/example/insight/data/local/dao/KnowledgeDao;Lcom/example/insight/data/local/dao/DiagnosticDao;)V", "gson", "Lcom/google/gson/Gson;", "generateWeeklyReport", "Lkotlinx/coroutines/flow/Flow;", "", "apiKey", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSimilarQuestions", "capturedText", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "streamChat", "messages", "", "Lcom/example/insight/data/remote/DeepSeekMessage;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class DeepSeekRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.remote.DeepSeekApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.local.dao.ScanDao scanDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.local.dao.KnowledgeDao knowledgeDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.local.dao.DiagnosticDao diagnosticDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    @javax.inject.Inject()
    public DeepSeekRepository(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.remote.DeepSeekApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.ScanDao scanDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.KnowledgeDao knowledgeDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.DiagnosticDao diagnosticDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object streamChat(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.remote.DeepSeekMessage> messages, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object generateWeeklyReport(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSimilarQuestions(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    java.lang.String capturedText, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.String>> $completion) {
        return null;
    }
}
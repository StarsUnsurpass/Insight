package com.example.insight.data.repository;

import com.example.insight.data.datastore.PreferenceManager;
import com.example.insight.data.local.dao.*;
import com.example.insight.data.local.entities.*;
import com.example.insight.ui.state.*;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\fJ\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110\fJ\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00110\fJ\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\fJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\fJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\fJ*\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010&J\u0016\u0010\'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0086@\u00a2\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010*J\u0016\u00101\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0086@\u00a2\u0006\u0002\u0010.J\u001e\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020)2\u0006\u00104\u001a\u000205H\u0086@\u00a2\u0006\u0002\u00106J\u0016\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0086@\u00a2\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020=H\u0086@\u00a2\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010*R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006@"}, d2 = {"Lcom/example/insight/data/repository/InsightRepository;", "", "preferenceManager", "Lcom/example/insight/data/datastore/PreferenceManager;", "scanDao", "Lcom/example/insight/data/local/dao/ScanDao;", "knowledgeDao", "Lcom/example/insight/data/local/dao/KnowledgeDao;", "diagnosticDao", "Lcom/example/insight/data/local/dao/DiagnosticDao;", "(Lcom/example/insight/data/datastore/PreferenceManager;Lcom/example/insight/data/local/dao/ScanDao;Lcom/example/insight/data/local/dao/KnowledgeDao;Lcom/example/insight/data/local/dao/DiagnosticDao;)V", "userPreferencesFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/insight/ui/state/UserPreferences;", "getUserPreferencesFlow", "()Lkotlinx/coroutines/flow/Flow;", "getAllEdges", "", "Lcom/example/insight/data/local/entities/KnowledgeEdgeEntity;", "getAllNodes", "Lcom/example/insight/data/local/entities/KnowledgeNodeEntity;", "getAllScans", "Lcom/example/insight/data/local/entities/ScanRecordEntity;", "getLatestReport", "Lcom/example/insight/data/local/entities/DiagnosticReportEntity;", "getMasteredCount", "", "getScanCount", "initializeGraph", "", "nodes", "edges", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveReport", "report", "(Lcom/example/insight/data/local/entities/DiagnosticReportEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveScanResult", "record", "(Lcom/example/insight/data/local/entities/ScanRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateClassName", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDarkMode", "enabled", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeepSeekApiKey", "apiKey", "updateHapticFeedback", "updateNodeMastery", "nodeId", "level", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateThemeStyle", "style", "Lcom/example/insight/ui/state/ThemeStyle;", "(Lcom/example/insight/ui/state/ThemeStyle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserRole", "role", "Lcom/example/insight/ui/state/UserRole;", "(Lcom/example/insight/ui/state/UserRole;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUsername", "app_debug"})
public final class InsightRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.datastore.PreferenceManager preferenceManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.local.dao.ScanDao scanDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.local.dao.KnowledgeDao knowledgeDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.local.dao.DiagnosticDao diagnosticDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.insight.ui.state.UserPreferences> userPreferencesFlow = null;
    
    @javax.inject.Inject()
    public InsightRepository(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.datastore.PreferenceManager preferenceManager, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.ScanDao scanDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.KnowledgeDao knowledgeDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.DiagnosticDao diagnosticDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.insight.ui.state.UserPreferences> getUserPreferencesFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateClassName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateUserRole(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserRole role, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateDarkMode(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateThemeStyle(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ThemeStyle style, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateHapticFeedback(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateDeepSeekApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.ScanRecordEntity>> getAllScans() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveScanResult(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.ScanRecordEntity record, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getScanCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getMasteredCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity>> getAllNodes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.KnowledgeEdgeEntity>> getAllEdges() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object initializeGraph(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity> nodes, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeEdgeEntity> edges, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateNodeMastery(@org.jetbrains.annotations.NotNull()
    java.lang.String nodeId, float level, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.insight.data.local.entities.DiagnosticReportEntity> getLatestReport() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveReport(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.DiagnosticReportEntity report, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
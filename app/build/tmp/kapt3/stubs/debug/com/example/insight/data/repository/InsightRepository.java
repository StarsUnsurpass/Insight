package com.example.insight.data.repository;

import com.example.insight.data.datastore.PreferenceManager;
import com.example.insight.data.local.dao.*;
import com.example.insight.data.local.entities.*;
import com.example.insight.ui.state.*;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u000eJ\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00180\u000eJ\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00180\u000eJ\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00180\u000eJ\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000eJ\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000e2\u0006\u0010\"\u001a\u00020#J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000eJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000eJ\u001a\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00180\u000e2\u0006\u0010\"\u001a\u00020#J\u0018\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020#H\u0086@\u00a2\u0006\u0002\u0010*J*\u0010+\u001a\u00020\u00132\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0086@\u00a2\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u00101J\u0016\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u00104J\u0016\u00105\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u001c\u00106\u001a\u00020\u00132\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0086@\u00a2\u0006\u0002\u00108J\u001a\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00180\u000e2\u0006\u0010:\u001a\u00020#J\u0016\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020#H\u0086@\u00a2\u0006\u0002\u0010*J\u0016\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0086@\u00a2\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020#H\u0086@\u00a2\u0006\u0002\u0010*J\u0016\u0010C\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0086@\u00a2\u0006\u0002\u0010@J\u001e\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020GH\u0086@\u00a2\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010J\u001a\u00020\u00132\u0006\u0010K\u001a\u00020LH\u0086@\u00a2\u0006\u0002\u0010MJ\u0016\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020PH\u0086@\u00a2\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u00020\u00132\u0006\u0010<\u001a\u00020#H\u0086@\u00a2\u0006\u0002\u0010*R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006S"}, d2 = {"Lcom/example/insight/data/repository/InsightRepository;", "", "preferenceManager", "Lcom/example/insight/data/datastore/PreferenceManager;", "scanDao", "Lcom/example/insight/data/local/dao/ScanDao;", "knowledgeDao", "Lcom/example/insight/data/local/dao/KnowledgeDao;", "diagnosticDao", "Lcom/example/insight/data/local/dao/DiagnosticDao;", "studentDao", "Lcom/example/insight/data/local/dao/StudentDao;", "(Lcom/example/insight/data/datastore/PreferenceManager;Lcom/example/insight/data/local/dao/ScanDao;Lcom/example/insight/data/local/dao/KnowledgeDao;Lcom/example/insight/data/local/dao/DiagnosticDao;Lcom/example/insight/data/local/dao/StudentDao;)V", "userPreferencesFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/insight/ui/state/UserPreferences;", "getUserPreferencesFlow", "()Lkotlinx/coroutines/flow/Flow;", "deleteStudent", "", "student", "Lcom/example/insight/data/local/entities/StudentEntity;", "(Lcom/example/insight/data/local/entities/StudentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEdges", "", "Lcom/example/insight/data/local/entities/KnowledgeEdgeEntity;", "getAllNodes", "Lcom/example/insight/data/local/entities/KnowledgeNodeEntity;", "getAllScans", "Lcom/example/insight/data/local/entities/ScanRecordEntity;", "getAllStudents", "getLatestReport", "Lcom/example/insight/data/local/entities/DiagnosticReportEntity;", "getLatestReportForStudent", "studentId", "", "getMasteredCount", "", "getScanCount", "getScansByStudent", "getStudentById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeGraph", "nodes", "edges", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveReport", "report", "(Lcom/example/insight/data/local/entities/DiagnosticReportEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveScanResult", "record", "(Lcom/example/insight/data/local/entities/ScanRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveStudent", "saveStudents", "students", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchStudents", "query", "updateClassName", "name", "updateDarkMode", "enabled", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeepSeekApiKey", "apiKey", "updateHapticFeedback", "updateNodeMastery", "nodeId", "level", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStudent", "updateThemeStyle", "style", "Lcom/example/insight/ui/state/ThemeStyle;", "(Lcom/example/insight/ui/state/ThemeStyle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserRole", "role", "Lcom/example/insight/ui/state/UserRole;", "(Lcom/example/insight/ui/state/UserRole;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUsername", "app_debug"})
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
    private final com.example.insight.data.local.dao.StudentDao studentDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.insight.ui.state.UserPreferences> userPreferencesFlow = null;
    
    @javax.inject.Inject()
    public InsightRepository(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.datastore.PreferenceManager preferenceManager, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.ScanDao scanDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.KnowledgeDao knowledgeDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.DiagnosticDao diagnosticDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.StudentDao studentDao) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.ScanRecordEntity>> getScansByStudent(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.insight.data.local.entities.DiagnosticReportEntity> getLatestReportForStudent(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveReport(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.DiagnosticReportEntity report, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.StudentEntity>> getAllStudents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.StudentEntity>> searchStudents(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStudentById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.insight.data.local.entities.StudentEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveStudent(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.StudentEntity student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveStudents(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.StudentEntity> students, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateStudent(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.StudentEntity student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteStudent(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.StudentEntity student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
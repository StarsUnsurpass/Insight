package com.example.insight.data.repository;

import com.example.insight.data.datastore.PreferenceManager;
import com.example.insight.data.local.dao.*;
import com.example.insight.data.local.entities.*;
import com.example.insight.ui.state.*;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u0010J\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0#0\u0010J\u0012\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0#0\u0010J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0#0\u0010J\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0#0\u0010J\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0#0\u00102\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u0010J\u0016\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u00102\u0006\u00100\u001a\u00020\u0017J\f\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0010J\u0018\u00103\u001a\u0004\u0018\u00010\u001c2\u0006\u00104\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u00105J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020&0#2\u0006\u0010,\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u00105J\u001a\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0#0\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\f\u00108\u001a\b\u0012\u0004\u0012\u0002020\u0010J\u001a\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0#0\u00102\u0006\u00100\u001a\u00020\u0017J\u0018\u0010:\u001a\u0004\u0018\u00010 2\u0006\u00104\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u00105J\u001a\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0#0\u00102\u0006\u00100\u001a\u00020\u0017J8\u0010=\u001a\u00020\u00152\f\u0010>\u001a\b\u0012\u0004\u0012\u00020&0#2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0#H\u0086@\u00a2\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020.H\u0086@\u00a2\u0006\u0002\u0010FJ\u0016\u0010G\u001a\u00020\u00152\u0006\u0010H\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010IJ\u0016\u0010J\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010!J\u001c\u0010K\u001a\u00020\u00152\f\u0010L\u001a\b\u0012\u0004\u0012\u00020 0#H\u0086@\u00a2\u0006\u0002\u0010MJ\u001a\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0#0\u00102\u0006\u0010O\u001a\u00020\u0017J\u0016\u0010P\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u00105J\u0016\u0010R\u001a\u00020\u00152\u0006\u0010S\u001a\u00020TH\u0086@\u00a2\u0006\u0002\u0010UJ\u0016\u0010V\u001a\u00020\u00152\u0006\u0010W\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u00105J\u0016\u0010X\u001a\u00020\u00152\u0006\u0010S\u001a\u00020TH\u0086@\u00a2\u0006\u0002\u0010UJ&\u0010Y\u001a\u00020Z2\u0006\u00100\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00172\u0006\u0010[\u001a\u00020TH\u0086@\u00a2\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010^\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010!J\u0016\u0010_\u001a\u00020\u00152\u0006\u0010`\u001a\u00020aH\u0086@\u00a2\u0006\u0002\u0010bJ\u0016\u0010c\u001a\u00020\u00152\u0006\u0010d\u001a\u00020eH\u0086@\u00a2\u0006\u0002\u0010fJ\u0016\u0010g\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u00105R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006h"}, d2 = {"Lcom/example/insight/data/repository/InsightRepository;", "", "preferenceManager", "Lcom/example/insight/data/datastore/PreferenceManager;", "scanDao", "Lcom/example/insight/data/local/dao/ScanDao;", "knowledgeDao", "Lcom/example/insight/data/local/dao/KnowledgeDao;", "diagnosticDao", "Lcom/example/insight/data/local/dao/DiagnosticDao;", "studentDao", "Lcom/example/insight/data/local/dao/StudentDao;", "lessonPlanDao", "Lcom/example/insight/data/local/dao/LessonPlanDao;", "(Lcom/example/insight/data/datastore/PreferenceManager;Lcom/example/insight/data/local/dao/ScanDao;Lcom/example/insight/data/local/dao/KnowledgeDao;Lcom/example/insight/data/local/dao/DiagnosticDao;Lcom/example/insight/data/local/dao/StudentDao;Lcom/example/insight/data/local/dao/LessonPlanDao;)V", "userPreferencesFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/insight/ui/state/UserPreferences;", "getUserPreferencesFlow", "()Lkotlinx/coroutines/flow/Flow;", "addQuestionToPlan", "", "planId", "", "questionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlan", "plan", "Lcom/example/insight/data/local/entities/LessonPlanEntity;", "(Lcom/example/insight/data/local/entities/LessonPlanEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteStudent", "student", "Lcom/example/insight/data/local/entities/StudentEntity;", "(Lcom/example/insight/data/local/entities/StudentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEdges", "", "Lcom/example/insight/data/local/entities/KnowledgeEdgeEntity;", "getAllNodes", "Lcom/example/insight/data/local/entities/KnowledgeNodeEntity;", "getAllPlans", "getAllScans", "Lcom/example/insight/data/local/entities/ScanRecordEntity;", "getAllStudents", "getAncestors", "nodeId", "getLatestReport", "Lcom/example/insight/data/local/entities/DiagnosticReportEntity;", "getLatestReportForStudent", "studentId", "getMasteredCount", "", "getPlanById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrerequisites", "getQuestionsForPlan", "getScanCount", "getScansByStudent", "getStudentById", "getStudentMastery", "Lcom/example/insight/data/local/entities/StudentMasteryEntity;", "initializeGraph", "nodes", "edges", "closures", "Lcom/example/insight/data/local/entities/KnowledgeClosureEntity;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePlan", "saveReport", "report", "(Lcom/example/insight/data/local/entities/DiagnosticReportEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveScanResult", "record", "(Lcom/example/insight/data/local/entities/ScanRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveStudent", "saveStudents", "students", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchStudents", "query", "updateClassName", "name", "updateDarkMode", "enabled", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeepSeekApiKey", "apiKey", "updateHapticFeedback", "updateMastery", "error/NonExistentClass", "isCorrect", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlan", "updateStudent", "updateThemeStyle", "style", "Lcom/example/insight/ui/state/ThemeStyle;", "(Lcom/example/insight/ui/state/ThemeStyle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserRole", "role", "Lcom/example/insight/ui/state/UserRole;", "(Lcom/example/insight/ui/state/UserRole;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUsername", "app_debug"})
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
    private final com.example.insight.data.local.dao.LessonPlanDao lessonPlanDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.insight.ui.state.UserPreferences> userPreferencesFlow = null;
    
    @javax.inject.Inject()
    public InsightRepository(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.datastore.PreferenceManager preferenceManager, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.ScanDao scanDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.KnowledgeDao knowledgeDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.DiagnosticDao diagnosticDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.StudentDao studentDao, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.LessonPlanDao lessonPlanDao) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.StudentMasteryEntity>> getStudentMastery(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPrerequisites(@org.jetbrains.annotations.NotNull()
    java.lang.String nodeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity>> getAncestors(@org.jetbrains.annotations.NotNull()
    java.lang.String nodeId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object initializeGraph(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity> nodes, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeEdgeEntity> edges, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeClosureEntity> closures, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateMastery(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId, @org.jetbrains.annotations.NotNull()
    java.lang.String nodeId, boolean isCorrect, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.LessonPlanEntity>> getAllPlans() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPlanById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.insight.data.local.entities.LessonPlanEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object savePlan(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.LessonPlanEntity plan, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePlan(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.LessonPlanEntity plan, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deletePlan(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.LessonPlanEntity plan, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addQuestionToPlan(@org.jetbrains.annotations.NotNull()
    java.lang.String planId, @org.jetbrains.annotations.NotNull()
    java.lang.String questionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.ScanRecordEntity>> getQuestionsForPlan(@org.jetbrains.annotations.NotNull()
    java.lang.String planId) {
        return null;
    }
}
package com.example.insight.data.local.dao;

import androidx.room.*;
import com.example.insight.data.local.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\b2\u0006\u0010\u0010\u001a\u00020\fH\'J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/example/insight/data/local/dao/LessonPlanDao;", "", "deletePlan", "", "plan", "Lcom/example/insight/data/local/entities/LessonPlanEntity;", "(Lcom/example/insight/data/local/entities/LessonPlanEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPlansFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getPlanById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuestionsForPlanFlow", "Lcom/example/insight/data/local/entities/ScanRecordEntity;", "planId", "insertPlan", "insertQuestionRef", "ref", "Lcom/example/insight/data/local/entities/LessonQuestionCrossRef;", "(Lcom/example/insight/data/local/entities/LessonQuestionCrossRef;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlan", "app_release"})
@androidx.room.Dao()
public abstract interface LessonPlanDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertPlan(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.LessonPlanEntity plan, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePlan(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.LessonPlanEntity plan, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deletePlan(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.LessonPlanEntity plan, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM lesson_plan_table ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.LessonPlanEntity>> getAllPlansFlow();
    
    @androidx.room.Query(value = "SELECT * FROM lesson_plan_table WHERE planId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlanById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.insight.data.local.entities.LessonPlanEntity> $completion);
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertQuestionRef(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.LessonQuestionCrossRef ref, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "\n        SELECT scan_record_table.* FROM scan_record_table \n        INNER JOIN lesson_question_cross_ref ON scan_record_table.id = lesson_question_cross_ref.questionId \n        WHERE lesson_question_cross_ref.planId = :planId\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.ScanRecordEntity>> getQuestionsForPlanFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String planId);
}
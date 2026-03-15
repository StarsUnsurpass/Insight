package com.example.insight.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.insight.data.local.dao.*;
import com.example.insight.data.local.entities.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/example/insight/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "diagnosticDao", "Lcom/example/insight/data/local/dao/DiagnosticDao;", "knowledgeDao", "Lcom/example/insight/data/local/dao/KnowledgeDao;", "lessonPlanDao", "Lcom/example/insight/data/local/dao/LessonPlanDao;", "scanDao", "Lcom/example/insight/data/local/dao/ScanDao;", "studentDao", "Lcom/example/insight/data/local/dao/StudentDao;", "app_debug"})
@androidx.room.Database(entities = {com.example.insight.data.local.entities.ScanRecordEntity.class, com.example.insight.data.local.entities.KnowledgeNodeEntity.class, com.example.insight.data.local.entities.KnowledgeEdgeEntity.class, com.example.insight.data.local.entities.DiagnosticReportEntity.class, com.example.insight.data.local.entities.StudentEntity.class, com.example.insight.data.local.entities.LessonPlanEntity.class, com.example.insight.data.local.entities.LessonQuestionCrossRef.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.insight.data.local.dao.ScanDao scanDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.insight.data.local.dao.KnowledgeDao knowledgeDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.insight.data.local.dao.DiagnosticDao diagnosticDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.insight.data.local.dao.StudentDao studentDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.insight.data.local.dao.LessonPlanDao lessonPlanDao();
}
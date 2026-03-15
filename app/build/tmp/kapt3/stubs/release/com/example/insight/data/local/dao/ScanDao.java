package com.example.insight.data.local.dao;

import androidx.room.*;
import com.example.insight.data.local.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0007H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007H\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0007H\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00072\u0006\u0010\f\u001a\u00020\rH\'J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/example/insight/data/local/dao/ScanDao;", "", "getAllScans", "", "Lcom/example/insight/data/local/entities/ScanRecordEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllScansFlow", "Lkotlinx/coroutines/flow/Flow;", "getMasteredCountFlow", "", "getScanCountFlow", "getScansByStudentFlow", "studentId", "", "insertScanRecord", "", "record", "(Lcom/example/insight/data/local/entities/ScanRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@androidx.room.Dao()
public abstract interface ScanDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertScanRecord(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.ScanRecordEntity record, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM scan_record_table ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.ScanRecordEntity>> getAllScansFlow();
    
    @androidx.room.Query(value = "SELECT * FROM scan_record_table WHERE studentId = :studentId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.ScanRecordEntity>> getScansByStudentFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId);
    
    @androidx.room.Query(value = "SELECT * FROM scan_record_table")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllScans(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.insight.data.local.entities.ScanRecordEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM scan_record_table")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getScanCountFlow();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM scan_record_table WHERE isMastered = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getMasteredCountFlow();
}
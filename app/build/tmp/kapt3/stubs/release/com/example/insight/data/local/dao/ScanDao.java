package com.example.insight.data.local.dao;

import androidx.room.*;
import com.example.insight.data.local.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\'J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/insight/data/local/dao/ScanDao;", "", "getAllScansFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/insight/data/local/entities/ScanRecordEntity;", "getMasteredCountFlow", "", "getScanCountFlow", "insertScanRecord", "", "record", "(Lcom/example/insight/data/local/entities/ScanRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
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
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM scan_record_table")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getScanCountFlow();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM scan_record_table WHERE isMastered = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getMasteredCountFlow();
}
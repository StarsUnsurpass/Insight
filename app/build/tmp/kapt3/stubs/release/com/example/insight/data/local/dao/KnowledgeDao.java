package com.example.insight.data.local.dao;

import androidx.room.*;
import com.example.insight.data.local.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H\'J\u001c\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/example/insight/data/local/dao/KnowledgeDao;", "", "getAllEdgesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/insight/data/local/entities/KnowledgeEdgeEntity;", "getAllNodesFlow", "Lcom/example/insight/data/local/entities/KnowledgeNodeEntity;", "insertEdges", "", "edges", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNodes", "nodes", "updateMastery", "id", "", "level", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@androidx.room.Dao()
public abstract interface KnowledgeDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNodes(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity> nodes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertEdges(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeEdgeEntity> edges, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM knowledge_node_table")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity>> getAllNodesFlow();
    
    @androidx.room.Query(value = "SELECT * FROM knowledge_edge_table")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.KnowledgeEdgeEntity>> getAllEdgesFlow();
    
    @androidx.room.Query(value = "UPDATE knowledge_node_table SET masteryLevel = :level WHERE nodeId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMastery(@org.jetbrains.annotations.NotNull()
    java.lang.String id, float level, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
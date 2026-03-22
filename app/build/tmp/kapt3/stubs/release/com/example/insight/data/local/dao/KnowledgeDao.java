package com.example.insight.data.local.dao;

import androidx.room.*;
import com.example.insight.data.local.entities.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H\'J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\t\u001a\u00020\nH\'J \u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u00032\u0006\u0010\r\u001a\u00020\nH\'J\u001c\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0097@\u00a2\u0006\u0002\u0010!\u00a8\u0006\""}, d2 = {"Lcom/example/insight/data/local/dao/KnowledgeDao;", "", "getAllEdges", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/insight/data/local/entities/KnowledgeEdgeEntity;", "getAllNodes", "Lcom/example/insight/data/local/entities/KnowledgeNodeEntity;", "getAncestors", "nodeId", "", "getMasterySync", "Lcom/example/insight/data/local/entities/StudentMasteryEntity;", "studentId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrerequisites", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStudentMastery", "insertClosure", "", "closures", "Lcom/example/insight/data/local/entities/KnowledgeClosureEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertEdges", "edges", "insertNodes", "nodes", "updateMastery", "mastery", "(Lcom/example/insight/data/local/entities/StudentMasteryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMasteryWithRules", "isCorrect", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@androidx.room.Dao()
public abstract interface KnowledgeDao {
    
    @androidx.room.Query(value = "SELECT * FROM knowledge_nodes")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity>> getAllNodes();
    
    @androidx.room.Query(value = "SELECT * FROM knowledge_edges")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.KnowledgeEdgeEntity>> getAllEdges();
    
    @androidx.room.Query(value = "\n        SELECT n.* FROM knowledge_nodes n\n        JOIN knowledge_edges e ON n.nodeId = e.sourceNodeId\n        WHERE e.targetNodeId = :nodeId AND e.relationType = \'PREREQUISITE\'\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPrerequisites(@org.jetbrains.annotations.NotNull()
    java.lang.String nodeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity>> $completion);
    
    @androidx.room.Query(value = "\n        SELECT n.* FROM knowledge_nodes n\n        JOIN knowledge_closure_table c ON n.nodeId = c.ancestorId\n        WHERE c.descendantId = :nodeId AND c.depth > 0\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity>> getAncestors(@org.jetbrains.annotations.NotNull()
    java.lang.String nodeId);
    
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
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertClosure(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeClosureEntity> closures, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM student_mastery WHERE studentId = :studentId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.StudentMasteryEntity>> getStudentMastery(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMastery(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.StudentMasteryEntity mastery, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMasteryWithRules(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId, @org.jetbrains.annotations.NotNull()
    java.lang.String nodeId, boolean isCorrect, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM student_mastery WHERE studentId = :studentId AND nodeId = :nodeId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMasterySync(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId, @org.jetbrains.annotations.NotNull()
    java.lang.String nodeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.insight.data.local.entities.StudentMasteryEntity> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction()
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object updateMasteryWithRules(@org.jetbrains.annotations.NotNull()
        com.example.insight.data.local.dao.KnowledgeDao $this, @org.jetbrains.annotations.NotNull()
        java.lang.String studentId, @org.jetbrains.annotations.NotNull()
        java.lang.String nodeId, boolean isCorrect, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}
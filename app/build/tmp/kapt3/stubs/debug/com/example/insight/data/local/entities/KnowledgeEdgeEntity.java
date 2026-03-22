package com.example.insight.data.local.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * 知识图谱关系边表
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/example/insight/data/local/entities/KnowledgeEdgeEntity;", "", "edgeId", "", "sourceNodeId", "", "targetNodeId", "relationType", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEdgeId", "()J", "getRelationType", "()Ljava/lang/String;", "getSourceNodeId", "getTargetNodeId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "knowledge_edges", foreignKeys = {@androidx.room.ForeignKey(entity = com.example.insight.data.local.entities.KnowledgeNodeEntity.class, parentColumns = {"nodeId"}, childColumns = {"sourceNodeId"}, onDelete = 5), @androidx.room.ForeignKey(entity = com.example.insight.data.local.entities.KnowledgeNodeEntity.class, parentColumns = {"nodeId"}, childColumns = {"targetNodeId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"sourceNodeId"}), @androidx.room.Index(value = {"targetNodeId"})})
public final class KnowledgeEdgeEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long edgeId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sourceNodeId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String targetNodeId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String relationType = null;
    
    public KnowledgeEdgeEntity(long edgeId, @org.jetbrains.annotations.NotNull()
    java.lang.String sourceNodeId, @org.jetbrains.annotations.NotNull()
    java.lang.String targetNodeId, @org.jetbrains.annotations.NotNull()
    java.lang.String relationType) {
        super();
    }
    
    public final long getEdgeId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSourceNodeId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTargetNodeId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRelationType() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.local.entities.KnowledgeEdgeEntity copy(long edgeId, @org.jetbrains.annotations.NotNull()
    java.lang.String sourceNodeId, @org.jetbrains.annotations.NotNull()
    java.lang.String targetNodeId, @org.jetbrains.annotations.NotNull()
    java.lang.String relationType) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}
package com.example.insight.graph;

import java.util.UUID;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007\u00a8\u0006\u001e"}, d2 = {"Lcom/example/insight/graph/GraphController;", "", "()V", "edges", "", "Lcom/example/insight/graph/KnowledgeEdge;", "getEdges", "()Ljava/util/List;", "focusedNodeId", "", "getFocusedNodeId", "()Ljava/lang/String;", "setFocusedNodeId", "(Ljava/lang/String;)V", "nodes", "Lcom/example/insight/graph/KnowledgeNode;", "getNodes", "applyFocusMode", "", "nodeId", "collapseNode", "expandNode", "parent", "getDescendants", "", "resetFocus", "toggleNodeExpansion", "updatePhysics", "dt", "", "app_debug"})
public final class GraphController {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.insight.graph.KnowledgeNode> nodes = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.insight.graph.KnowledgeEdge> edges = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String focusedNodeId;
    
    public GraphController() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.insight.graph.KnowledgeNode> getNodes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.insight.graph.KnowledgeEdge> getEdges() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFocusedNodeId() {
        return null;
    }
    
    public final void setFocusedNodeId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final void toggleNodeExpansion(@org.jetbrains.annotations.NotNull()
    java.lang.String nodeId) {
    }
    
    private final void expandNode(com.example.insight.graph.KnowledgeNode parent) {
    }
    
    private final void collapseNode(java.lang.String nodeId) {
    }
    
    private final java.util.Set<java.lang.String> getDescendants(java.lang.String nodeId) {
        return null;
    }
    
    private final void applyFocusMode(java.lang.String nodeId) {
    }
    
    private final void resetFocus() {
    }
    
    public final void updatePhysics(float dt) {
    }
}
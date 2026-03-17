package com.example.insight.ui.screens;

import androidx.lifecycle.ViewModel;
import com.example.insight.data.repository.DeepSeekRepository;
import com.example.insight.data.remote.DeepSeekMessage;
import com.google.gson.Gson;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import java.lang.StringBuilder;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0014H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/example/insight/ui/screens/MindMapViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/insight/data/repository/DeepSeekRepository;", "(Lcom/example/insight/data/repository/DeepSeekRepository;)V", "_isGenerating", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_rootNode", "Lcom/example/insight/ui/screens/MindMapNode;", "gson", "Lcom/google/gson/Gson;", "isGenerating", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "rootNode", "getRootNode", "generateMindMap", "", "topic", "", "apiKey", "generateSystemPrompt", "parseAndSetNode", "rawJson", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MindMapViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.repository.DeepSeekRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.insight.ui.screens.MindMapNode> _rootNode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.screens.MindMapNode> rootNode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isGenerating = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isGenerating = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    @javax.inject.Inject()
    public MindMapViewModel(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.repository.DeepSeekRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.screens.MindMapNode> getRootNode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isGenerating() {
        return null;
    }
    
    private final java.lang.String generateSystemPrompt() {
        return null;
    }
    
    public final void generateMindMap(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey) {
    }
    
    private final void parseAndSetNode(java.lang.String rawJson) {
    }
}
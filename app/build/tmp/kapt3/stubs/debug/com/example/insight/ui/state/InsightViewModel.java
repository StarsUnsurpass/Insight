package com.example.insight.ui.state;

import androidx.lifecycle.ViewModel;
import com.example.insight.data.repository.InsightRepository;
import com.example.insight.data.repository.DeepSeekRepository;
import com.example.insight.data.remote.DeepSeekMessage;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognizer;
import android.graphics.Bitmap;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0015J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u000bJ\u000e\u0010\'\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$J\u000e\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006/"}, d2 = {"Lcom/example/insight/ui/state/InsightViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/insight/data/repository/InsightRepository;", "deepSeekRepository", "Lcom/example/insight/data/repository/DeepSeekRepository;", "textRecognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "(Lcom/example/insight/data/repository/InsightRepository;Lcom/example/insight/data/repository/DeepSeekRepository;Lcom/google/mlkit/vision/text/TextRecognizer;)V", "_aiOutput", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Lcom/example/insight/ui/state/InsightUiState;", "aiOutput", "Lkotlinx/coroutines/flow/StateFlow;", "getAiOutput", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "closeGraph", "", "generateSimilarQuestions", "text", "generateWeeklyReport", "onImageCaptured", "bitmap", "Landroid/graphics/Bitmap;", "onTextCaptured", "reset", "showGraph", "startAnalysis", "updateClassName", "name", "updateDarkMode", "enabled", "", "updateDeepSeekApiKey", "key", "updateHapticFeedback", "updateThemeStyle", "style", "Lcom/example/insight/ui/state/ThemeStyle;", "updateUserRole", "role", "Lcom/example/insight/ui/state/UserRole;", "updateUsername", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class InsightViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.repository.InsightRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.repository.DeepSeekRepository deepSeekRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.text.TextRecognizer textRecognizer = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.insight.ui.state.InsightUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.state.InsightUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _aiOutput = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> aiOutput = null;
    
    @javax.inject.Inject()
    public InsightViewModel(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.repository.InsightRepository repository, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.repository.DeepSeekRepository deepSeekRepository, @org.jetbrains.annotations.NotNull()
    com.google.mlkit.vision.text.TextRecognizer textRecognizer) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.state.InsightUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getAiOutput() {
        return null;
    }
    
    public final void onImageCaptured(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
    }
    
    public final void onTextCaptured(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    private final void startAnalysis(java.lang.String text) {
    }
    
    public final void generateWeeklyReport() {
    }
    
    public final void generateSimilarQuestions(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void updateDeepSeekApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public final void updateUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void updateClassName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void updateUserRole(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserRole role) {
    }
    
    public final void updateDarkMode(boolean enabled) {
    }
    
    public final void updateThemeStyle(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ThemeStyle style) {
    }
    
    public final void updateHapticFeedback(boolean enabled) {
    }
    
    public final void reset() {
    }
    
    public final void showGraph() {
    }
    
    public final void closeGraph() {
    }
}
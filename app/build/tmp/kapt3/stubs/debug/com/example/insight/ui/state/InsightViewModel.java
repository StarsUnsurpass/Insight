package com.example.insight.ui.state;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0010J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0010J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010\'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006*"}, d2 = {"Lcom/example/insight/ui/state/InsightViewModel;", "Landroidx/lifecycle/ViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/insight/ui/state/InsightUiState;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "closeGraph", "", "loadPreferences", "Lcom/example/insight/ui/state/UserPreferences;", "onTextCaptured", "text", "", "reset", "savePreference", "key", "value", "", "showGraph", "startAnalysis", "updateClassName", "name", "updateDarkMode", "enabled", "", "updateHapticFeedback", "updateThemeStyle", "style", "Lcom/example/insight/ui/state/ThemeStyle;", "updateUserRole", "role", "Lcom/example/insight/ui/state/UserRole;", "updateUsername", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class InsightViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application application = null;
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.insight.ui.state.InsightUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.state.InsightUiState> uiState = null;
    
    @javax.inject.Inject()
    public InsightViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.state.InsightUiState> getUiState() {
        return null;
    }
    
    private final com.example.insight.ui.state.UserPreferences loadPreferences() {
        return null;
    }
    
    private final void savePreference(java.lang.String key, java.lang.Object value) {
    }
    
    public final void onTextCaptured(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    private final void startAnalysis(java.lang.String text) {
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
package com.example.insight.ui.state;

import com.example.insight.data.local.entities.KnowledgeEdgeEntity;
import com.example.insight.data.local.entities.KnowledgeNodeEntity;
import com.example.insight.data.local.entities.LessonPlanEntity;
import com.example.insight.data.local.entities.ScanRecordEntity;
import com.example.insight.data.local.entities.StudentEntity;
import com.example.insight.data.local.entities.StudentMasteryEntity;
import com.example.insight.data.local.entities.DiagnosticReportEntity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00032\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0015R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006+"}, d2 = {"Lcom/example/insight/ui/state/UserPreferences;", "", "username", "", "className", "role", "Lcom/example/insight/ui/state/UserRole;", "isDarkMode", "", "themeStyle", "Lcom/example/insight/ui/state/ThemeStyle;", "hapticEnabled", "deepSeekApiKey", "knowledgeStatuses", "", "Lcom/example/insight/ui/state/KnowledgeStatus;", "(Ljava/lang/String;Ljava/lang/String;Lcom/example/insight/ui/state/UserRole;ZLcom/example/insight/ui/state/ThemeStyle;ZLjava/lang/String;Ljava/util/Map;)V", "getClassName", "()Ljava/lang/String;", "getDeepSeekApiKey", "getHapticEnabled", "()Z", "getKnowledgeStatuses", "()Ljava/util/Map;", "getRole", "()Lcom/example/insight/ui/state/UserRole;", "getThemeStyle", "()Lcom/example/insight/ui/state/ThemeStyle;", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class UserPreferences {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String username = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String className = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.state.UserRole role = null;
    private final boolean isDarkMode = false;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.state.ThemeStyle themeStyle = null;
    private final boolean hapticEnabled = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String deepSeekApiKey = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, com.example.insight.ui.state.KnowledgeStatus> knowledgeStatuses = null;
    
    public UserPreferences(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String className, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserRole role, boolean isDarkMode, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ThemeStyle themeStyle, boolean hapticEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String deepSeekApiKey, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends com.example.insight.ui.state.KnowledgeStatus> knowledgeStatuses) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClassName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.UserRole getRole() {
        return null;
    }
    
    public final boolean isDarkMode() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.ThemeStyle getThemeStyle() {
        return null;
    }
    
    public final boolean getHapticEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeepSeekApiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.example.insight.ui.state.KnowledgeStatus> getKnowledgeStatuses() {
        return null;
    }
    
    public UserPreferences() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.UserRole component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.ThemeStyle component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.example.insight.ui.state.KnowledgeStatus> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.UserPreferences copy(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String className, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserRole role, boolean isDarkMode, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ThemeStyle themeStyle, boolean hapticEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String deepSeekApiKey, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends com.example.insight.ui.state.KnowledgeStatus> knowledgeStatuses) {
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
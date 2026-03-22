package com.example.insight.util;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import com.example.insight.ui.state.UserPreferences;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a*\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u00a8\u0006\f"}, d2 = {"triggerHaptic", "", "preferences", "Lcom/example/insight/ui/state/UserPreferences;", "haptic", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hapticClickable", "Landroidx/compose/ui/Modifier;", "enabled", "", "onClick", "Lkotlin/Function0;", "app_debug"})
public final class HapticUtilKt {
    
    /**
     * 支持震感反馈的点击修饰符
     */
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.ui.Modifier hapticClickable(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier $this$hapticClickable, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences, boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
        return null;
    }
    
    /**
     * 触发一次标准震感
     */
    public static final void triggerHaptic(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.hapticfeedback.HapticFeedback haptic) {
    }
}
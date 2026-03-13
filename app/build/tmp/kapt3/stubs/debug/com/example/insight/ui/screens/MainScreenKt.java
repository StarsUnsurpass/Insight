package com.example.insight.ui.screens;

import android.os.Build;
import androidx.compose.animation.*;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material.icons.outlined.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import com.example.insight.ui.state.InsightViewModel;
import com.example.insight.ui.theme.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0007\u001a$\u0010\u0012\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a\b\u0010\u0015\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a*\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00182\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH\u0007\u001a\"\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\"H\u0007\u001a8\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\'2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006("}, d2 = {"GooeyDockContent", "", "selectedTab", "Lcom/example/insight/ui/screens/InsightTab;", "isVisible", "", "currentDockWidth", "Landroidx/compose/ui/unit/Dp;", "onTabSelected", "Lkotlin/Function1;", "onCameraClick", "Lkotlin/Function0;", "GooeyDockContent-TDGSqEk", "(Lcom/example/insight/ui/screens/InsightTab;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "HistoryCard", "index", "", "HomeTab", "MainScreen", "onNavigateToScanner", "onNavigateToSettings", "MapTab", "ProfileTab", "username", "", "SettingRow", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "title", "onClick", "StatCard", "label", "value", "modifier", "Landroidx/compose/ui/Modifier;", "TabIconFluid", "Landroidx/compose/foundation/layout/BoxScope;", "tab", "alpha", "", "app_debug"})
public final class MainScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void MainScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToScanner, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSettings) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TabIconFluid(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.BoxScope $this$TabIconFluid, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.screens.InsightTab tab, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.screens.InsightTab selectedTab, float alpha, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.insight.ui.screens.InsightTab, kotlin.Unit> onTabSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HomeTab() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HistoryCard(int index) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MapTab() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ProfileTab(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSettings) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatCard(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SettingRow(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}
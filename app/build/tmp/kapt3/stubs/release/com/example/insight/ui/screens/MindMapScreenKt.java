package com.example.insight.ui.screens;

import androidx.compose.animation.*;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.example.insight.ui.state.UserPreferences;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a2\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\u0016\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a&\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a0\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007\u001a&\u0010\u001d\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020!0 \u00a8\u0006\""}, d2 = {"EmptyStateView", "", "InputCard", "value", "", "onValueChange", "Lkotlin/Function1;", "onSend", "Lkotlin/Function0;", "MagicButton", "onClick", "MindMapScreen", "preferences", "Lcom/example/insight/ui/state/UserPreferences;", "viewModel", "Lcom/example/insight/ui/screens/MindMapViewModel;", "onBack", "MindMapTree", "node", "Lcom/example/insight/ui/screens/MindMapNode;", "level", "", "onPositioned", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onToggleExpand", "NodeItem", "modifier", "Landroidx/compose/ui/Modifier;", "drawConnections", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "positions", "", "Landroidx/compose/ui/geometry/Offset;", "app_release"})
public final class MindMapScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void MindMapScreen(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.screens.MindMapViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MindMapTree(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.screens.MindMapNode node, int level, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super androidx.compose.ui.layout.LayoutCoordinates, kotlin.Unit> onPositioned, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.insight.ui.screens.MindMapNode, kotlin.Unit> onToggleExpand) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NodeItem(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.screens.MindMapNode node, int level, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleExpand, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    public static final void drawConnections(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.drawscope.DrawScope $this$drawConnections, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.screens.MindMapNode node, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, androidx.compose.ui.geometry.Offset> positions) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyStateView() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MagicButton(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InputCard(@org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSend) {
    }
}
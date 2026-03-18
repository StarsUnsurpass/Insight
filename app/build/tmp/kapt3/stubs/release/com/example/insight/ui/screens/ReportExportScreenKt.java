package com.example.insight.ui.screens;

import androidx.compose.animation.*;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.example.insight.ui.state.*;
import com.example.insight.util.PdfExportHelper;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a:\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0007\u001a&\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u001a\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a<\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u001aQ\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001d0 0\u001f2\u0006\u0010\u000f\u001a\u0002H\u001d2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a2\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006*"}, d2 = {"HandwritingSettingsPanel", "", "config", "Lcom/example/insight/ui/state/HandwritingConfig;", "onConfigChange", "Lkotlin/Function1;", "HandwritingSlider", "label", "", "value", "", "onValueChange", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "PaperTypeChip", "selected", "", "onClick", "Lkotlin/Function0;", "ReportA4Preview", "Lcom/example/insight/ui/state/ReportConfig;", "preferences", "Lcom/example/insight/ui/state/UserPreferences;", "ReportExportScreen", "aiOutput", "isStreaming", "onGenerateAiReport", "onBack", "StyleSelector", "T", "options", "", "Lkotlin/Pair;", "onSelect", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "height", "Landroidx/compose/ui/Modifier;", "_min", "Landroidx/compose/ui/unit/Dp;", "max", "height-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "app_release"})
public final class ReportExportScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ReportExportScreen(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences, @org.jetbrains.annotations.NotNull()
    java.lang.String aiOutput, boolean isStreaming, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onGenerateAiReport, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HandwritingSettingsPanel(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.HandwritingConfig config, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.insight.ui.state.HandwritingConfig, kotlin.Unit> onConfigChange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HandwritingSlider(@org.jetbrains.annotations.NotNull()
    java.lang.String label, float value, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onValueChange, @org.jetbrains.annotations.NotNull()
    kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> valueRange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PaperTypeChip(@org.jetbrains.annotations.NotNull()
    java.lang.String label, boolean selected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final <T extends java.lang.Object>void StyleSelector(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends kotlin.Pair<java.lang.String, ? extends T>> options, T selected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> onSelect) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ReportA4Preview(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ReportConfig config, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences) {
    }
}
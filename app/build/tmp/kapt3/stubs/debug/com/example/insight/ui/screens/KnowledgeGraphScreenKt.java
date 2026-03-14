package com.example.insight.ui.screens;

import androidx.compose.animation.*;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.*;
import androidx.compose.ui.graphics.*;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import com.example.insight.ui.state.UserPreferences;
import com.example.insight.ui.state.UserRole;
import com.example.insight.ui.theme.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a#\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b\u00a2\u0006\u0002\b\tH\u0007\u001a\b\u0010\n\u001a\u00020\u0001H\u0007\u001a*\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\b\u0010\u0014\u001a\u00020\u0001H\u0007\u001a2\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a\b\u0010\u001b\u001a\u00020\u0001H\u0007\u001a$\u0010\u001c\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006 "}, d2 = {"AIInsightHeader", "", "preferences", "Lcom/example/insight/ui/state/UserPreferences;", "DashboardCard", "title", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ErrorAttributionSection", "ErrorDonutRow", "label", "percentage", "", "color", "Landroidx/compose/ui/graphics/Color;", "ErrorDonutRow-mxwnekA", "(Ljava/lang/String;FJ)V", "KnowledgeGraphScreen", "LearningHeatmap", "PrescriptionCard", "subtitle", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PrescriptionCard-g2O1Hgs", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;J)V", "PrescriptionRow", "RadarChartAnimated", "data", "", "labels", "app_debug"})
public final class KnowledgeGraphScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void KnowledgeGraphScreen(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AIInsightHeader(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RadarChartAnimated(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Float> data, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> labels) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LearningHeatmap() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ErrorAttributionSection() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PrescriptionRow() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DashboardCard(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> content) {
    }
}
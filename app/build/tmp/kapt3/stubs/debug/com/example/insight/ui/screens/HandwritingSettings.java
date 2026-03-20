package com.example.insight.ui.screens;

import androidx.compose.animation.*;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material.icons.outlined.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.example.insight.data.local.entities.LessonPlanEntity;
import com.example.insight.data.local.entities.ScanRecordEntity;
import com.example.insight.data.local.entities.KnowledgeNodeEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\u0016\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u001aJ\t\u0010 \u001a\u00020\tH\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tH\u00c6\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020,H\u00d6\u0001J\t\u0010-\u001a\u00020.H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\u00020\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006/"}, d2 = {"Lcom/example/insight/ui/screens/HandwritingSettings;", "", "paperStyle", "Lcom/example/insight/ui/screens/PaperStyle;", "fontStyle", "Lcom/example/insight/ui/screens/HandwritingFont;", "textColor", "Landroidx/compose/ui/graphics/Color;", "fontSize", "", "lineSpacing", "letterSpacing", "marginX", "marginY", "(Lcom/example/insight/ui/screens/PaperStyle;Lcom/example/insight/ui/screens/HandwritingFont;JFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFontSize", "()F", "getFontStyle", "()Lcom/example/insight/ui/screens/HandwritingFont;", "getLetterSpacing", "getLineSpacing", "getMarginX", "getMarginY", "getPaperStyle", "()Lcom/example/insight/ui/screens/PaperStyle;", "getTextColor-0d7_KjU", "()J", "J", "component1", "component2", "component3", "component3-0d7_KjU", "component4", "component5", "component6", "component7", "component8", "copy", "copy-T042LqI", "(Lcom/example/insight/ui/screens/PaperStyle;Lcom/example/insight/ui/screens/HandwritingFont;JFFFFF)Lcom/example/insight/ui/screens/HandwritingSettings;", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class HandwritingSettings {
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.screens.PaperStyle paperStyle = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.screens.HandwritingFont fontStyle = null;
    private final long textColor = 0L;
    private final float fontSize = 0.0F;
    private final float lineSpacing = 0.0F;
    private final float letterSpacing = 0.0F;
    private final float marginX = 0.0F;
    private final float marginY = 0.0F;
    
    private HandwritingSettings(com.example.insight.ui.screens.PaperStyle paperStyle, com.example.insight.ui.screens.HandwritingFont fontStyle, long textColor, float fontSize, float lineSpacing, float letterSpacing, float marginX, float marginY) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.screens.PaperStyle getPaperStyle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.screens.HandwritingFont getFontStyle() {
        return null;
    }
    
    public final float getFontSize() {
        return 0.0F;
    }
    
    public final float getLineSpacing() {
        return 0.0F;
    }
    
    public final float getLetterSpacing() {
        return 0.0F;
    }
    
    public final float getMarginX() {
        return 0.0F;
    }
    
    public final float getMarginY() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.screens.PaperStyle component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.screens.HandwritingFont component2() {
        return null;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    public final float component6() {
        return 0.0F;
    }
    
    public final float component7() {
        return 0.0F;
    }
    
    public final float component8() {
        return 0.0F;
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
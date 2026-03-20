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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b?\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u00c3\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u00a2\u0006\u0002\u0010\u001bJ\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0011H\u00c6\u0003J\t\u00108\u001a\u00020\u0011H\u00c6\u0003J\t\u00109\u001a\u00020\u0011H\u00c6\u0003J\t\u0010:\u001a\u00020\u0007H\u00c6\u0003J\t\u0010;\u001a\u00020\u0007H\u00c6\u0003J\t\u0010<\u001a\u00020\u0007H\u00c6\u0003J\t\u0010=\u001a\u00020\tH\u00c6\u0003J\t\u0010>\u001a\u00020\tH\u00c6\u0003J\t\u0010?\u001a\u00020\tH\u00c6\u0003J\t\u0010@\u001a\u00020\tH\u00c6\u0003J\t\u0010A\u001a\u00020\u0005H\u00c6\u0003J\t\u0010B\u001a\u00020\u0007H\u00c6\u0003J\t\u0010C\u001a\u00020\tH\u00c6\u0003J\t\u0010D\u001a\u00020\tH\u00c6\u0003J\t\u0010E\u001a\u00020\tH\u00c6\u0003J\t\u0010F\u001a\u00020\tH\u00c6\u0003J\t\u0010G\u001a\u00020\tH\u00c6\u0003J\u0016\u0010H\u001a\u00020\u000fH\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u00101J\u00d1\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\tH\u00c6\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001a\u00020\u00072\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010O\u001a\u00020\u0011H\u00d6\u0001J\t\u0010P\u001a\u00020QH\u00d6\u0001R\u0011\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0019\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u001a\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0019\u0010\u000e\u001a\u00020\u000f\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0011\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010-R\u0011\u0010\u0017\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0011\u0010\u0018\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001f\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006R"}, d2 = {"Lcom/example/insight/ui/screens/HandwritingSettings;", "", "fontStyle", "Lcom/example/insight/ui/screens/HandwritingFont;", "paperStyle", "Lcom/example/insight/ui/screens/PaperStyle;", "showLines", "", "marginTop", "", "marginLeft", "marginRight", "marginBottom", "fontSize", "textColor", "Landroidx/compose/ui/graphics/Color;", "textAlignment", "", "textEffect", "resolution", "lightingEffect", "crumpleEffect", "otherEffect", "verticalPosition", "wordSpacing", "letterSpacing", "lineSpacing", "(Lcom/example/insight/ui/screens/HandwritingFont;Lcom/example/insight/ui/screens/PaperStyle;ZFFFFFJIIIZZZFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrumpleEffect", "()Z", "getFontSize", "()F", "getFontStyle", "()Lcom/example/insight/ui/screens/HandwritingFont;", "getLetterSpacing", "getLightingEffect", "getLineSpacing", "getMarginBottom", "getMarginLeft", "getMarginRight", "getMarginTop", "getOtherEffect", "getPaperStyle", "()Lcom/example/insight/ui/screens/PaperStyle;", "getResolution", "()I", "getShowLines", "getTextAlignment", "getTextColor-0d7_KjU", "()J", "J", "getTextEffect", "getVerticalPosition", "getWordSpacing", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component9-0d7_KjU", "copy", "copy-nGkvg6s", "(Lcom/example/insight/ui/screens/HandwritingFont;Lcom/example/insight/ui/screens/PaperStyle;ZFFFFFJIIIZZZFFFF)Lcom/example/insight/ui/screens/HandwritingSettings;", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class HandwritingSettings {
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.screens.HandwritingFont fontStyle = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.screens.PaperStyle paperStyle = null;
    private final boolean showLines = false;
    private final float marginTop = 0.0F;
    private final float marginLeft = 0.0F;
    private final float marginRight = 0.0F;
    private final float marginBottom = 0.0F;
    private final float fontSize = 0.0F;
    private final long textColor = 0L;
    private final int textAlignment = 0;
    private final int textEffect = 0;
    private final int resolution = 0;
    private final boolean lightingEffect = false;
    private final boolean crumpleEffect = false;
    private final boolean otherEffect = false;
    private final float verticalPosition = 0.0F;
    private final float wordSpacing = 0.0F;
    private final float letterSpacing = 0.0F;
    private final float lineSpacing = 0.0F;
    
    private HandwritingSettings(com.example.insight.ui.screens.HandwritingFont fontStyle, com.example.insight.ui.screens.PaperStyle paperStyle, boolean showLines, float marginTop, float marginLeft, float marginRight, float marginBottom, float fontSize, long textColor, int textAlignment, int textEffect, int resolution, boolean lightingEffect, boolean crumpleEffect, boolean otherEffect, float verticalPosition, float wordSpacing, float letterSpacing, float lineSpacing) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.screens.HandwritingFont getFontStyle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.screens.PaperStyle getPaperStyle() {
        return null;
    }
    
    public final boolean getShowLines() {
        return false;
    }
    
    public final float getMarginTop() {
        return 0.0F;
    }
    
    public final float getMarginLeft() {
        return 0.0F;
    }
    
    public final float getMarginRight() {
        return 0.0F;
    }
    
    public final float getMarginBottom() {
        return 0.0F;
    }
    
    public final float getFontSize() {
        return 0.0F;
    }
    
    public final int getTextAlignment() {
        return 0;
    }
    
    public final int getTextEffect() {
        return 0;
    }
    
    public final int getResolution() {
        return 0;
    }
    
    public final boolean getLightingEffect() {
        return false;
    }
    
    public final boolean getCrumpleEffect() {
        return false;
    }
    
    public final boolean getOtherEffect() {
        return false;
    }
    
    public final float getVerticalPosition() {
        return 0.0F;
    }
    
    public final float getWordSpacing() {
        return 0.0F;
    }
    
    public final float getLetterSpacing() {
        return 0.0F;
    }
    
    public final float getLineSpacing() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.screens.HandwritingFont component1() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final float component16() {
        return 0.0F;
    }
    
    public final float component17() {
        return 0.0F;
    }
    
    public final float component18() {
        return 0.0F;
    }
    
    public final float component19() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.screens.PaperStyle component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
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
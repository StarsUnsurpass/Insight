package com.example.insight.ui.screens;

import androidx.compose.animation.*;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.*;
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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/example/insight/ui/screens/HandwritingFont;", "", "title", "", "fontFamilyName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getFontFamilyName", "()Ljava/lang/String;", "getTitle", "Normal", "Serif", "Cursive", "Monospace", "app_debug"})
public enum HandwritingFont {
    /*public static final*/ Normal /* = new Normal(null, null) */,
    /*public static final*/ Serif /* = new Serif(null, null) */,
    /*public static final*/ Cursive /* = new Cursive(null, null) */,
    /*public static final*/ Monospace /* = new Monospace(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String fontFamilyName = null;
    
    HandwritingFont(java.lang.String title, java.lang.String fontFamilyName) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFontFamilyName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.example.insight.ui.screens.HandwritingFont> getEntries() {
        return null;
    }
}
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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/insight/ui/screens/PaperStyle;", "", "title", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "WhiteBlank", "WhiteLined", "Grid", "KraftBlank", "EnglishRuled", "app_debug"})
public enum PaperStyle {
    /*public static final*/ WhiteBlank /* = new WhiteBlank(null) */,
    /*public static final*/ WhiteLined /* = new WhiteLined(null) */,
    /*public static final*/ Grid /* = new Grid(null) */,
    /*public static final*/ KraftBlank /* = new KraftBlank(null) */,
    /*public static final*/ EnglishRuled /* = new EnglishRuled(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    
    PaperStyle(java.lang.String title) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.example.insight.ui.screens.PaperStyle> getEntries() {
        return null;
    }
}
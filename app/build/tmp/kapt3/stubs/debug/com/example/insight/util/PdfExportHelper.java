package com.example.insight.util;

import android.content.Context;
import android.content.Intent;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.content.FileProvider;
import com.example.insight.ui.state.ReportConfig;
import com.example.insight.ui.state.UserPreferences;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00040\fJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r\u00a8\u0006\u0010"}, d2 = {"Lcom/example/insight/util/PdfExportHelper;", "", "()V", "exportReport", "", "context", "Landroid/content/Context;", "config", "Lcom/example/insight/ui/state/ReportConfig;", "preferences", "Lcom/example/insight/ui/state/UserPreferences;", "onComplete", "Lkotlin/Function1;", "Ljava/io/File;", "sharePdf", "file", "app_debug"})
public final class PdfExportHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.insight.util.PdfExportHelper INSTANCE = null;
    
    private PdfExportHelper() {
        super();
    }
    
    /**
     * Launch the system Print Manager to generate a PDF.
     * This is the standard, secure way to handle WebView-to-PDF conversion.
     */
    public final void exportReport(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ReportConfig config, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> onComplete) {
    }
    
    /**
     * Shares a PDF file using FileProvider.
     */
    public final void sharePdf(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.io.File file) {
    }
}
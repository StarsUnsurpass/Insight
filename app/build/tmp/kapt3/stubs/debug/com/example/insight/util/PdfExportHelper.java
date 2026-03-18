package com.example.insight.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.content.FileProvider;
import com.example.insight.ui.state.*;
import com.google.gson.Gson;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00040\u000eJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0011H\u0002J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J.\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00040\u000eH\u0002JF\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00040\u000eH\u0002JF\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00040\u000eH\u0002J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/example/insight/util/PdfExportHelper;", "", "()V", "exportReport", "", "context", "Landroid/content/Context;", "config", "Lcom/example/insight/ui/state/ReportConfig;", "preferences", "Lcom/example/insight/ui/state/UserPreferences;", "content", "", "onComplete", "Lkotlin/Function1;", "Ljava/io/File;", "generateHandwritingBackground", "Lcom/example/insight/ui/state/HandwritingConfig;", "generateHtml", "printWebView", "webView", "Landroid/webkit/WebView;", "setupHandwritingWebView", "setupStandardWebView", "sharePdf", "file", "app_debug"})
public final class PdfExportHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.insight.util.PdfExportHelper INSTANCE = null;
    
    private PdfExportHelper() {
        super();
    }
    
    public final void exportReport(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ReportConfig config, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> onComplete) {
    }
    
    private final void setupHandwritingWebView(android.content.Context context, android.webkit.WebView webView, com.example.insight.ui.state.ReportConfig config, com.example.insight.ui.state.UserPreferences preferences, java.lang.String content, kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> onComplete) {
    }
    
    private final void setupStandardWebView(android.content.Context context, android.webkit.WebView webView, com.example.insight.ui.state.ReportConfig config, com.example.insight.ui.state.UserPreferences preferences, java.lang.String content, kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> onComplete) {
    }
    
    private final void printWebView(android.content.Context context, android.webkit.WebView webView, kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> onComplete) {
    }
    
    private final java.lang.String generateHandwritingBackground(com.example.insight.ui.state.HandwritingConfig config) {
        return null;
    }
    
    private final java.lang.String generateHtml(android.content.Context context, com.example.insight.ui.state.ReportConfig config, com.example.insight.ui.state.UserPreferences preferences, java.lang.String content) {
        return null;
    }
    
    public final void sharePdf(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.io.File file) {
    }
}
package com.example.insight.ui.schedule;

import android.graphics.Rect;
import com.google.mlkit.vision.text.Text;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J,\u0010\u0015\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\u00042\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00050\u0018H\u0002\u00a8\u0006\u0019"}, d2 = {"Lcom/example/insight/ui/schedule/ScheduleImportEngine;", "", "()V", "find1DClusters", "", "", "values", "threshold", "isHeaderOrNoise", "", "text", "", "mapToClosestPeriod", "y", "rowCenters", "parseGrid", "Lcom/example/insight/ui/schedule/ParsedGridItem;", "blocks", "Lcom/google/mlkit/vision/text/Text$TextBlock;", "imageWidth", "imageHeight", "indexOfMinBy", "T", "selector", "Lkotlin/Function1;", "app_debug"})
public final class ScheduleImportEngine {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.insight.ui.schedule.ScheduleImportEngine INSTANCE = null;
    
    private ScheduleImportEngine() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.insight.ui.schedule.ParsedGridItem> parseGrid(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.mlkit.vision.text.Text.TextBlock> blocks, int imageWidth, int imageHeight) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> find1DClusters(java.util.List<java.lang.Integer> values, int threshold) {
        return null;
    }
    
    private final boolean isHeaderOrNoise(java.lang.String text) {
        return false;
    }
    
    private final int mapToClosestPeriod(int y, java.util.List<java.lang.Integer> rowCenters) {
        return 0;
    }
    
    private final <T extends java.lang.Object>int indexOfMinBy(java.util.List<? extends T> $this$indexOfMinBy, kotlin.jvm.functions.Function1<? super T, java.lang.Integer> selector) {
        return 0;
    }
}
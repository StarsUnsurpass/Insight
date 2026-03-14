package com.example.insight.ui.state;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003J\t\u0010!\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\"\u001a\u00020\u000bH\u00c6\u0003J\t\u0010#\u001a\u00020\u000eH\u00c6\u0003JO\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/example/insight/ui/state/ReportConfig;", "", "reportTitle", "", "themeColor", "", "fontStyle", "Lcom/example/insight/ui/state/ReportFont;", "chartStyle", "Lcom/example/insight/ui/state/ChartStyle;", "includeRadarChart", "", "includeStudentList", "detailLevel", "Lcom/example/insight/ui/state/DetailLevel;", "(Ljava/lang/String;ILcom/example/insight/ui/state/ReportFont;Lcom/example/insight/ui/state/ChartStyle;ZZLcom/example/insight/ui/state/DetailLevel;)V", "getChartStyle", "()Lcom/example/insight/ui/state/ChartStyle;", "getDetailLevel", "()Lcom/example/insight/ui/state/DetailLevel;", "getFontStyle", "()Lcom/example/insight/ui/state/ReportFont;", "getIncludeRadarChart", "()Z", "getIncludeStudentList", "getReportTitle", "()Ljava/lang/String;", "getThemeColor", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class ReportConfig {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String reportTitle = null;
    private final int themeColor = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.state.ReportFont fontStyle = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.state.ChartStyle chartStyle = null;
    private final boolean includeRadarChart = false;
    private final boolean includeStudentList = false;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.state.DetailLevel detailLevel = null;
    
    public ReportConfig(@org.jetbrains.annotations.NotNull()
    java.lang.String reportTitle, int themeColor, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ReportFont fontStyle, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ChartStyle chartStyle, boolean includeRadarChart, boolean includeStudentList, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.DetailLevel detailLevel) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReportTitle() {
        return null;
    }
    
    public final int getThemeColor() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.ReportFont getFontStyle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.ChartStyle getChartStyle() {
        return null;
    }
    
    public final boolean getIncludeRadarChart() {
        return false;
    }
    
    public final boolean getIncludeStudentList() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.DetailLevel getDetailLevel() {
        return null;
    }
    
    public ReportConfig() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.ReportFont component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.ChartStyle component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.DetailLevel component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.ReportConfig copy(@org.jetbrains.annotations.NotNull()
    java.lang.String reportTitle, int themeColor, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ReportFont fontStyle, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ChartStyle chartStyle, boolean includeRadarChart, boolean includeStudentList, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.DetailLevel detailLevel) {
        return null;
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
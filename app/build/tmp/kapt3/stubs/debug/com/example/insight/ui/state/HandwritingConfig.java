package com.example.insight.ui.state;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\t\u0010%\u001a\u00020\tH\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\t\u0010\'\u001a\u00020\tH\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\tH\u00c6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\u0007H\u00d6\u0001J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016\u00a8\u0006/"}, d2 = {"Lcom/example/insight/ui/state/HandwritingConfig;", "", "fontName", "", "paperType", "Lcom/example/insight/ui/state/PaperType;", "fontSize", "", "sizeJitter", "", "rotationJitter", "positionJitter", "spacingJitter", "inkBlur", "paperColor", "lineOpacity", "(Ljava/lang/String;Lcom/example/insight/ui/state/PaperType;IFFFFFLjava/lang/String;F)V", "getFontName", "()Ljava/lang/String;", "getFontSize", "()I", "getInkBlur", "()F", "getLineOpacity", "getPaperColor", "getPaperType", "()Lcom/example/insight/ui/state/PaperType;", "getPositionJitter", "getRotationJitter", "getSizeJitter", "getSpacingJitter", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class HandwritingConfig {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String fontName = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.ui.state.PaperType paperType = null;
    private final int fontSize = 0;
    private final float sizeJitter = 0.0F;
    private final float rotationJitter = 0.0F;
    private final float positionJitter = 0.0F;
    private final float spacingJitter = 0.0F;
    private final float inkBlur = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String paperColor = null;
    private final float lineOpacity = 0.0F;
    
    public HandwritingConfig(@org.jetbrains.annotations.NotNull()
    java.lang.String fontName, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.PaperType paperType, int fontSize, float sizeJitter, float rotationJitter, float positionJitter, float spacingJitter, float inkBlur, @org.jetbrains.annotations.NotNull()
    java.lang.String paperColor, float lineOpacity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFontName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.PaperType getPaperType() {
        return null;
    }
    
    public final int getFontSize() {
        return 0;
    }
    
    public final float getSizeJitter() {
        return 0.0F;
    }
    
    public final float getRotationJitter() {
        return 0.0F;
    }
    
    public final float getPositionJitter() {
        return 0.0F;
    }
    
    public final float getSpacingJitter() {
        return 0.0F;
    }
    
    public final float getInkBlur() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPaperColor() {
        return null;
    }
    
    public final float getLineOpacity() {
        return 0.0F;
    }
    
    public HandwritingConfig() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final float component10() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.PaperType component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.ui.state.HandwritingConfig copy(@org.jetbrains.annotations.NotNull()
    java.lang.String fontName, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.PaperType paperType, int fontSize, float sizeJitter, float rotationJitter, float positionJitter, float spacingJitter, float inkBlur, @org.jetbrains.annotations.NotNull()
    java.lang.String paperColor, float lineOpacity) {
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
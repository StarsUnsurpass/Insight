package com.example.insight.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0010H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0012H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\tH\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u000eH\u00c6\u0003J}\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u00c6\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u000205H\u00d6\u0001J\t\u00106\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019\u00a8\u00067"}, d2 = {"Lcom/example/insight/data/model/Slide;", "", "id", "", "title", "content", "subContent", "visualHint", "interactionType", "Lcom/example/insight/data/model/InteractionType;", "options", "", "correctAnswer", "layoutType", "Lcom/example/insight/data/model/SlideLayoutType;", "animationType", "Lcom/example/insight/data/model/SlideAnimationType;", "backgroundType", "Lcom/example/insight/data/model/SlideBackgroundType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/insight/data/model/InteractionType;Ljava/util/List;Ljava/lang/String;Lcom/example/insight/data/model/SlideLayoutType;Lcom/example/insight/data/model/SlideAnimationType;Lcom/example/insight/data/model/SlideBackgroundType;)V", "getAnimationType", "()Lcom/example/insight/data/model/SlideAnimationType;", "getBackgroundType", "()Lcom/example/insight/data/model/SlideBackgroundType;", "getContent", "()Ljava/lang/String;", "getCorrectAnswer", "getId", "getInteractionType", "()Lcom/example/insight/data/model/InteractionType;", "getLayoutType", "()Lcom/example/insight/data/model/SlideLayoutType;", "getOptions", "()Ljava/util/List;", "getSubContent", "getTitle", "getVisualHint", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Slide {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String subContent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String visualHint = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.model.InteractionType interactionType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> options = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String correctAnswer = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.model.SlideLayoutType layoutType = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.model.SlideAnimationType animationType = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.model.SlideBackgroundType backgroundType = null;
    
    public Slide(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.String subContent, @org.jetbrains.annotations.NotNull()
    java.lang.String visualHint, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.InteractionType interactionType, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> options, @org.jetbrains.annotations.NotNull()
    java.lang.String correctAnswer, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.SlideLayoutType layoutType, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.SlideAnimationType animationType, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.SlideBackgroundType backgroundType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVisualHint() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.model.InteractionType getInteractionType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getOptions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCorrectAnswer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.model.SlideLayoutType getLayoutType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.model.SlideAnimationType getAnimationType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.model.SlideBackgroundType getBackgroundType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.model.SlideAnimationType component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.model.SlideBackgroundType component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.model.InteractionType component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.model.SlideLayoutType component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.model.Slide copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.String subContent, @org.jetbrains.annotations.NotNull()
    java.lang.String visualHint, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.InteractionType interactionType, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> options, @org.jetbrains.annotations.NotNull()
    java.lang.String correctAnswer, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.SlideLayoutType layoutType, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.SlideAnimationType animationType, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.SlideBackgroundType backgroundType) {
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
package com.example.insight.camera;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/insight/camera/TextAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "recognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "(Lcom/google/mlkit/vision/text/TextRecognizer;)V", "analyze", "", "imageProxy", "Landroidx/camera/core/ImageProxy;", "app_release"})
public final class TextAnalyzer implements androidx.camera.core.ImageAnalysis.Analyzer {
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.text.TextRecognizer recognizer = null;
    
    @javax.inject.Inject()
    public TextAnalyzer(@org.jetbrains.annotations.NotNull()
    com.google.mlkit.vision.text.TextRecognizer recognizer) {
        super();
    }
    
    @java.lang.Override()
    @androidx.camera.core.ExperimentalGetImage()
    public void analyze(@org.jetbrains.annotations.NotNull()
    androidx.camera.core.ImageProxy imageProxy) {
    }
}
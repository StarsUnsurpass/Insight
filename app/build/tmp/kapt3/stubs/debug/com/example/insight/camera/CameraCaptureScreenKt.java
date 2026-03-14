package com.example.insight.camera;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import androidx.camera.core.*;
import androidx.camera.core.ImageCapture.OnImageCapturedCallback;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.*;
import androidx.compose.ui.graphics.*;
import androidx.compose.ui.graphics.drawscope.Stroke;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import kotlinx.coroutines.Dispatchers;
import java.util.concurrent.Executors;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a$\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0018H\u0002\u001a.\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010\u001f\u001a$\u0010 \u001a\u00020\u0001*\u00020!2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018H\u0002\u001a\f\u0010$\u001a\u00020\u0006*\u00020%H\u0002\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006&"}, d2 = {"CameraCaptureScreen", "", "onBack", "Lkotlin/Function0;", "onImageCaptured", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "onError", "Landroidx/camera/core/ImageCaptureException;", "applyDelta", "Landroidx/compose/ui/geometry/Rect;", "rect", "delta", "Landroidx/compose/ui/geometry/Offset;", "handle", "Lcom/example/insight/camera/Handle;", "screen", "applyDelta-ubNVwUQ", "(Landroidx/compose/ui/geometry/Rect;JLcom/example/insight/camera/Handle;Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "hitTest", "offset", "hitTest-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)Lcom/example/insight/camera/Handle;", "inflateRect", "", "performCrop", "bitmap", "cropRect", "screenRect", "rotation", "", "(Landroid/graphics/Bitmap;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drawCorner", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "len", "thickness", "toBitmap", "Landroidx/camera/core/ImageProxy;", "app_debug"})
public final class CameraCaptureScreenKt {
    
    @android.annotation.SuppressLint(value = {"UnsafeOptInUsageError"})
    @androidx.compose.runtime.Composable()
    public static final void CameraCaptureScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.graphics.Bitmap, kotlin.Unit> onImageCaptured, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super androidx.camera.core.ImageCaptureException, kotlin.Unit> onError) {
    }
    
    private static final void drawCorner(androidx.compose.ui.graphics.drawscope.DrawScope $this$drawCorner, androidx.compose.ui.geometry.Rect rect, float len, float thickness) {
    }
    
    private static final java.lang.Object performCrop(android.graphics.Bitmap bitmap, androidx.compose.ui.geometry.Rect cropRect, androidx.compose.ui.geometry.Rect screenRect, int rotation, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> $completion) {
        return null;
    }
    
    private static final androidx.compose.ui.geometry.Rect inflateRect(androidx.compose.ui.geometry.Rect rect, float delta) {
        return null;
    }
    
    private static final android.graphics.Bitmap toBitmap(androidx.camera.core.ImageProxy $this$toBitmap) {
        return null;
    }
}
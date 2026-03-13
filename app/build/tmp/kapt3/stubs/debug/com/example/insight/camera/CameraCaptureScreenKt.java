package com.example.insight.camera;

import android.util.Log;
import androidx.camera.core.*;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.core.content.ContextCompat;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.compose.ui.layout.ContentScale;
import java.nio.ByteBuffer;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a8\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a6\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\f*\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0014H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0004H\u0002\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006!"}, d2 = {"CameraCaptureScreen", "", "onImageCaptured", "Lkotlin/Function1;", "Landroidx/camera/core/ImageProxy;", "onError", "Landroidx/camera/core/ImageCaptureException;", "DraggableSelectionOverlay", "selectionRect", "Landroidx/compose/ui/geometry/Rect;", "onSelectionChange", "showScanning", "", "modifier", "Landroidx/compose/ui/Modifier;", "drawCorner", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "pos", "Landroidx/compose/ui/geometry/Offset;", "len", "", "stroke", "type", "", "drawCorner-YqVAtuI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFI)V", "isNear", "target", "threshold", "isNear-Wko1d7g", "(JJF)Z", "toRotatedBitmap", "Landroid/graphics/Bitmap;", "app_debug"})
public final class CameraCaptureScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void CameraCaptureScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super androidx.camera.core.ImageProxy, kotlin.Unit> onImageCaptured, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super androidx.camera.core.ImageCaptureException, kotlin.Unit> onError) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DraggableSelectionOverlay(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.geometry.Rect selectionRect, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Rect, kotlin.Unit> onSelectionChange, boolean showScanning, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    private static final android.graphics.Bitmap toRotatedBitmap(androidx.camera.core.ImageProxy $this$toRotatedBitmap) {
        return null;
    }
}
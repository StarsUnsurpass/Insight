package com.example.insight.camera;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import androidx.camera.core.*;
import androidx.camera.core.ImageCapture.OnImageCapturedCallback;
import androidx.camera.view.PreviewView;
import androidx.compose.animation.*;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.*;
import androidx.compose.ui.graphics.*;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.font.FontWeight;
import kotlinx.coroutines.Dispatchers;
import java.util.concurrent.Executors;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/insight/camera/CaptureMode;", "", "(Ljava/lang/String;I)V", "CAPTURING", "EDITING", "app_release"})
public enum CaptureMode {
    /*public static final*/ CAPTURING /* = new CAPTURING() */,
    /*public static final*/ EDITING /* = new EDITING() */;
    
    CaptureMode() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.example.insight.camera.CaptureMode> getEntries() {
        return null;
    }
}
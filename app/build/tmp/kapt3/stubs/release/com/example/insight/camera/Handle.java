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
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import kotlinx.coroutines.Dispatchers;
import java.util.concurrent.Executors;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/insight/camera/Handle;", "", "(Ljava/lang/String;I)V", "LEFT", "TOP", "RIGHT", "BOTTOM", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "CENTER", "app_release"})
public enum Handle {
    /*public static final*/ LEFT /* = new LEFT() */,
    /*public static final*/ TOP /* = new TOP() */,
    /*public static final*/ RIGHT /* = new RIGHT() */,
    /*public static final*/ BOTTOM /* = new BOTTOM() */,
    /*public static final*/ TOP_LEFT /* = new TOP_LEFT() */,
    /*public static final*/ TOP_RIGHT /* = new TOP_RIGHT() */,
    /*public static final*/ BOTTOM_LEFT /* = new BOTTOM_LEFT() */,
    /*public static final*/ BOTTOM_RIGHT /* = new BOTTOM_RIGHT() */,
    /*public static final*/ CENTER /* = new CENTER() */;
    
    Handle() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.example.insight.camera.Handle> getEntries() {
        return null;
    }
}
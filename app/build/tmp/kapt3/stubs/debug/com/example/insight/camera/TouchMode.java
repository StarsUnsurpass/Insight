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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/example/insight/camera/TouchMode;", "", "(Ljava/lang/String;I)V", "None", "Move", "TopLeft", "TopRight", "BottomLeft", "BottomRight", "Top", "Bottom", "Left", "Right", "app_debug"})
public enum TouchMode {
    /*public static final*/ None /* = new None() */,
    /*public static final*/ Move /* = new Move() */,
    /*public static final*/ TopLeft /* = new TopLeft() */,
    /*public static final*/ TopRight /* = new TopRight() */,
    /*public static final*/ BottomLeft /* = new BottomLeft() */,
    /*public static final*/ BottomRight /* = new BottomRight() */,
    /*public static final*/ Top /* = new Top() */,
    /*public static final*/ Bottom /* = new Bottom() */,
    /*public static final*/ Left /* = new Left() */,
    /*public static final*/ Right /* = new Right() */;
    
    TouchMode() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.example.insight.camera.TouchMode> getEntries() {
        return null;
    }
}
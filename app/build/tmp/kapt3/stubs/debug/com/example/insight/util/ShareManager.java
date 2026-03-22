package com.example.insight.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.example.insight.data.local.dao.CourseWithTimeSlot;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/insight/util/ShareManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "generateScheduleToken", "", "courseWithSlots", "", "Lcom/example/insight/data/local/dao/CourseWithTimeSlot;", "parseScheduleToken", "token", "shareScheduleImage", "", "bitmap", "Landroid/graphics/Bitmap;", "app_debug"})
public final class ShareManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    public ShareManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * 将课表数据序列化并生成“口令”
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateScheduleToken(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.dao.CourseWithTimeSlot> courseWithSlots) {
        return null;
    }
    
    /**
     * 解析口令
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.insight.data.local.dao.CourseWithTimeSlot> parseScheduleToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return null;
    }
    
    /**
     * 分享课表图片
     */
    public final void shareScheduleImage(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
    }
}
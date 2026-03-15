package com.example.insight.util;

import android.content.Context;
import android.net.Uri;
import com.example.insight.data.local.entities.StudentEntity;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipInputStream;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\r"}, d2 = {"Lcom/example/insight/util/StudentImporter;", "", "()V", "importFromExcel", "", "Lcom/example/insight/data/local/entities/StudentEntity;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "importFromWord", "importFromZip", "importStudents", "app_release"})
public final class StudentImporter {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.insight.util.StudentImporter INSTANCE = null;
    
    private StudentImporter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.insight.data.local.entities.StudentEntity> importStudents(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    private final java.util.List<com.example.insight.data.local.entities.StudentEntity> importFromExcel(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    private final java.util.List<com.example.insight.data.local.entities.StudentEntity> importFromWord(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    private final java.util.List<com.example.insight.data.local.entities.StudentEntity> importFromZip(android.content.Context context, android.net.Uri uri) {
        return null;
    }
}
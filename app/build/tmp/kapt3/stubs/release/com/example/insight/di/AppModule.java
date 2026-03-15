package com.example.insight.di;

import android.app.Application;
import android.content.Context;
import androidx.room.Room;
import com.example.insight.data.datastore.PreferenceManager;
import com.example.insight.data.local.AppDatabase;
import com.example.insight.data.local.dao.DiagnosticDao;
import com.example.insight.data.local.dao.KnowledgeDao;
import com.example.insight.data.local.dao.ScanDao;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/example/insight/di/AppModule;", "", "()V", "provideAppDatabase", "Lcom/example/insight/data/local/AppDatabase;", "app", "Landroid/app/Application;", "provideDiagnosticDao", "Lcom/example/insight/data/local/dao/DiagnosticDao;", "db", "provideKnowledgeDao", "Lcom/example/insight/data/local/dao/KnowledgeDao;", "providePreferenceManager", "Lcom/example/insight/data/datastore/PreferenceManager;", "provideScanDao", "Lcom/example/insight/data/local/dao/ScanDao;", "provideStudentDao", "Lcom/example/insight/data/local/dao/StudentDao;", "provideTextRecognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.insight.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.google.mlkit.vision.text.TextRecognizer provideTextRecognizer() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.local.AppDatabase provideAppDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.local.dao.ScanDao provideScanDao(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.local.dao.KnowledgeDao provideKnowledgeDao(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.local.dao.DiagnosticDao provideDiagnosticDao(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.local.dao.StudentDao provideStudentDao(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.insight.data.datastore.PreferenceManager providePreferenceManager(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
}
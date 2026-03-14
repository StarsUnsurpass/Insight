package com.example.insight.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.insight.data.datastore.PreferenceManager
import com.example.insight.data.local.AppDatabase
import com.example.insight.data.local.dao.DiagnosticDao
import com.example.insight.data.local.dao.KnowledgeDao
import com.example.insight.data.local.dao.ScanDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTextRecognizer(): TextRecognizer {
        return TextRecognition.getClient()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "insight_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideScanDao(db: AppDatabase): ScanDao = db.scanDao()

    @Provides
    fun provideKnowledgeDao(db: AppDatabase): KnowledgeDao = db.knowledgeDao()

    @Provides
    fun provideDiagnosticDao(db: AppDatabase): DiagnosticDao = db.diagnosticDao()

    @Provides
    @Singleton
    fun providePreferenceManager(app: Application): PreferenceManager {
        return PreferenceManager(app)
    }
}

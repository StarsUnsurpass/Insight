package com.example.insight.di

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
    
    // Future providers for Retrofit, Room, etc. will go here
}

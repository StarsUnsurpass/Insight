package com.example.insight.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.insight.data.local.dao.*
import com.example.insight.data.local.entities.*

@Database(
    entities = [
        ScanRecordEntity::class,
        KnowledgeNodeEntity::class,
        KnowledgeEdgeEntity::class,
        DiagnosticReportEntity::class,
        StudentEntity::class,
        LessonPlanEntity::class,
        LessonQuestionCrossRef::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scanDao(): ScanDao
    abstract fun knowledgeDao(): KnowledgeDao
    abstract fun diagnosticDao(): DiagnosticDao
    abstract fun studentDao(): StudentDao
    abstract fun lessonPlanDao(): LessonPlanDao
}

package com.example.insight.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.insight.data.local.converters.Converters
import com.example.insight.data.local.dao.*
import com.example.insight.data.local.entities.*

@Database(
    entities = [
        ScanRecordEntity::class,
        KnowledgeNodeEntity::class,
        KnowledgeEdgeEntity::class,
        KnowledgeClosureEntity::class,
        StudentMasteryEntity::class,
        DiagnosticReportEntity::class,
        StudentEntity::class,
        LessonPlanEntity::class,
        LessonQuestionCrossRef::class,
        ScheduleEntity::class,
        CourseEntity::class,
        TimeSlotEntity::class,
        LessonTimeEntity::class
    ],
    version = 7,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scanDao(): ScanDao
    abstract fun knowledgeDao(): KnowledgeDao
    abstract fun diagnosticDao(): DiagnosticDao
    abstract fun studentDao(): StudentDao
    abstract fun lessonPlanDao(): LessonPlanDao
    abstract fun scheduleDao(): ScheduleDao
}

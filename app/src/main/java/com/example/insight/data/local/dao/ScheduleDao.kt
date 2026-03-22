package com.example.insight.data.local.dao

import androidx.room.*
import com.example.insight.data.local.entities.CourseEntity
import com.example.insight.data.local.entities.ScheduleEntity
import com.example.insight.data.local.entities.TimeSlotEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {

    // --- Schedule Management ---
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchedule(schedule: ScheduleEntity): Long

    @Query("SELECT * FROM schedule_tables")
    fun getAllSchedules(): Flow<List<ScheduleEntity>>

    @Query("SELECT * FROM schedule_tables WHERE isCurrentActive = 1 LIMIT 1")
    fun getActiveSchedule(): Flow<ScheduleEntity?>

    @Query("UPDATE schedule_tables SET isCurrentActive = 0")
    suspend fun clearActiveSchedules()

    @Transaction
    suspend fun setActiveSchedule(scheduleId: Long) {
        clearActiveSchedules()
        updateScheduleActiveStatus(scheduleId, true)
    }

    @Query("UPDATE schedule_tables SET isCurrentActive = :isActive WHERE scheduleId = :scheduleId")
    suspend fun updateScheduleActiveStatus(scheduleId: Long, isActive: Boolean)

    @Delete
    suspend fun deleteSchedule(schedule: ScheduleEntity)

    // --- Lesson Time Operations ---
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLessonTime(time: com.example.insight.data.local.entities.LessonTimeEntity)

    @Query("SELECT * FROM lesson_times WHERE scheduleId = :scheduleId ORDER BY period ASC")
    fun getLessonTimes(scheduleId: Long): Flow<List<com.example.insight.data.local.entities.LessonTimeEntity>>

    @Query("DELETE FROM lesson_times WHERE scheduleId = :scheduleId")
    suspend fun deleteLessonTimesByScheduleId(scheduleId: Long)

    // --- Course & Time Slot Management ---
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: CourseEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimeSlot(slot: TimeSlotEntity)

    @Query("SELECT * FROM course_metadata WHERE scheduleId = :scheduleId")
    fun getCoursesForSchedule(scheduleId: Long): Flow<List<CourseEntity>>

    @Query("SELECT * FROM time_slots WHERE courseId = :courseId")
    suspend fun getTimeSlotsForCourse(courseId: Long): List<TimeSlotEntity>

    @Transaction
    @Query("""
        SELECT * FROM course_metadata 
        JOIN time_slots ON course_metadata.courseId = time_slots.courseId 
        WHERE course_metadata.scheduleId = :scheduleId
    """)
    fun getFullScheduleData(scheduleId: Long): Flow<List<CourseWithTimeSlot>>

    @Delete
    suspend fun deleteCourse(course: CourseEntity)

    @Query("DELETE FROM time_slots WHERE courseId = :courseId")
    suspend fun deleteTimeSlotsByCourseId(courseId: Long)
}

data class CourseWithTimeSlot(
    @Embedded val course: CourseEntity,
    @Relation(
        parentColumn = "courseId",
        entityColumn = "courseId"
    )
    val timeSlots: List<TimeSlotEntity>
)

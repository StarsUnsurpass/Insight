package com.example.insight.data.repository

import com.example.insight.data.local.dao.CourseWithTimeSlot
import com.example.insight.data.local.dao.ScheduleDao
import com.example.insight.data.local.entities.CourseEntity
import com.example.insight.data.local.entities.ScheduleEntity
import com.example.insight.data.local.entities.TimeSlotEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScheduleRepository @Inject constructor(
    private val scheduleDao: ScheduleDao
) {
    fun getAllSchedules(): Flow<List<ScheduleEntity>> = scheduleDao.getAllSchedules()

    fun getActiveSchedule(): Flow<ScheduleEntity?> = scheduleDao.getActiveSchedule()

    suspend fun setActiveSchedule(scheduleId: Long) = scheduleDao.setActiveSchedule(scheduleId)

    suspend fun insertSchedule(name: String): Long {
        return scheduleDao.insertSchedule(ScheduleEntity(scheduleName = name))
    }

    suspend fun saveLessonTimes(times: List<com.example.insight.data.local.entities.LessonTimeEntity>) {
        if (times.isEmpty()) return
        scheduleDao.deleteLessonTimesByScheduleId(times.first().scheduleId)
        times.forEach { scheduleDao.insertLessonTime(it) }
    }

    fun getLessonTimes(scheduleId: Long): Flow<List<com.example.insight.data.local.entities.LessonTimeEntity>> =
        scheduleDao.getLessonTimes(scheduleId)

    suspend fun deleteSchedule(schedule: ScheduleEntity) = scheduleDao.deleteSchedule(schedule)

    fun getFullScheduleData(scheduleId: Long): Flow<List<CourseWithTimeSlot>> = 
        scheduleDao.getFullScheduleData(scheduleId)

    suspend fun addCourseWithSlots(
        scheduleId: Long,
        name: String,
        teacher: String,
        location: String,
        color: Int,
        slots: List<TimeSlotEntity>
    ) {
        val courseId = scheduleDao.insertCourse(
            CourseEntity(
                scheduleId = scheduleId,
                courseName = name,
                teacherName = teacher,
                location = location,
                themeColor = color
            )
        )
        slots.forEach { 
            scheduleDao.insertTimeSlot(it.copy(courseId = courseId))
        }
    }

    suspend fun deleteCourse(course: CourseEntity) {
        scheduleDao.deleteTimeSlotsByCourseId(course.courseId)
        scheduleDao.deleteCourse(course)
    }
}

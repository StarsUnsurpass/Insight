package com.example.insight.data.local.dao;

import androidx.room.*;
import com.example.insight.data.local.entities.CourseEntity;
import com.example.insight.data.local.entities.ScheduleEntity;
import com.example.insight.data.local.entities.TimeSlotEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014H\'J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00160\u0014H\'J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00160\u00142\u0006\u0010\n\u001a\u00020\u000bH\'J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00160\u00142\u0006\u0010\n\u001a\u00020\u000bH\'J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00160\u00142\u0006\u0010\n\u001a\u00020\u000bH\'J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00162\u0006\u0010\u0012\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001bH\u00a7@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u001dH\u00a7@\u00a2\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0097@\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\'\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u00a7@\u00a2\u0006\u0002\u0010*\u00a8\u0006+"}, d2 = {"Lcom/example/insight/data/local/dao/ScheduleDao;", "", "clearActiveSchedules", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCourse", "course", "Lcom/example/insight/data/local/entities/CourseEntity;", "(Lcom/example/insight/data/local/entities/CourseEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLessonTimesByScheduleId", "scheduleId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSchedule", "schedule", "Lcom/example/insight/data/local/entities/ScheduleEntity;", "(Lcom/example/insight/data/local/entities/ScheduleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTimeSlotsByCourseId", "courseId", "getActiveSchedule", "Lkotlinx/coroutines/flow/Flow;", "getAllSchedules", "", "getCoursesForSchedule", "getFullScheduleData", "Lcom/example/insight/data/local/dao/CourseWithTimeSlot;", "getLessonTimes", "Lcom/example/insight/data/local/entities/LessonTimeEntity;", "getTimeSlotsForCourse", "Lcom/example/insight/data/local/entities/TimeSlotEntity;", "insertCourse", "insertLessonTime", "time", "(Lcom/example/insight/data/local/entities/LessonTimeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSchedule", "insertTimeSlot", "slot", "(Lcom/example/insight/data/local/entities/TimeSlotEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setActiveSchedule", "updateScheduleActiveStatus", "isActive", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ScheduleDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSchedule(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.ScheduleEntity schedule, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM schedule_tables")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.ScheduleEntity>> getAllSchedules();
    
    @androidx.room.Query(value = "SELECT * FROM schedule_tables WHERE isCurrentActive = 1 LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.insight.data.local.entities.ScheduleEntity> getActiveSchedule();
    
    @androidx.room.Query(value = "UPDATE schedule_tables SET isCurrentActive = 0")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearActiveSchedules(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setActiveSchedule(long scheduleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE schedule_tables SET isCurrentActive = :isActive WHERE scheduleId = :scheduleId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateScheduleActiveStatus(long scheduleId, boolean isActive, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSchedule(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.ScheduleEntity schedule, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLessonTime(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.LessonTimeEntity time, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM lesson_times WHERE scheduleId = :scheduleId ORDER BY period ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.LessonTimeEntity>> getLessonTimes(long scheduleId);
    
    @androidx.room.Query(value = "DELETE FROM lesson_times WHERE scheduleId = :scheduleId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteLessonTimesByScheduleId(long scheduleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCourse(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.CourseEntity course, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTimeSlot(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.TimeSlotEntity slot, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM course_metadata WHERE scheduleId = :scheduleId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.CourseEntity>> getCoursesForSchedule(long scheduleId);
    
    @androidx.room.Query(value = "SELECT * FROM time_slots WHERE courseId = :courseId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTimeSlotsForCourse(long courseId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.insight.data.local.entities.TimeSlotEntity>> $completion);
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "\n        SELECT * FROM course_metadata \n        JOIN time_slots ON course_metadata.courseId = time_slots.courseId \n        WHERE course_metadata.scheduleId = :scheduleId\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.dao.CourseWithTimeSlot>> getFullScheduleData(long scheduleId);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteCourse(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.CourseEntity course, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM time_slots WHERE courseId = :courseId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTimeSlotsByCourseId(long courseId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction()
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object setActiveSchedule(@org.jetbrains.annotations.NotNull()
        com.example.insight.data.local.dao.ScheduleDao $this, long scheduleId, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}
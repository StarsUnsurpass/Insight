package com.example.insight.data.repository;

import com.example.insight.data.local.dao.CourseWithTimeSlot;
import com.example.insight.data.local.dao.ScheduleDao;
import com.example.insight.data.local.entities.CourseEntity;
import com.example.insight.data.local.entities.ScheduleEntity;
import com.example.insight.data.local.entities.TimeSlotEntity;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001cJ\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00100\u001cJ\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00100\u001c2\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00100\u001c2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010#J\u001c\u0010$\u001a\u00020\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u0010H\u0086@\u00a2\u0006\u0002\u0010&J\u0016\u0010\'\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/insight/data/repository/ScheduleRepository;", "", "scheduleDao", "Lcom/example/insight/data/local/dao/ScheduleDao;", "(Lcom/example/insight/data/local/dao/ScheduleDao;)V", "addCourseWithSlots", "", "scheduleId", "", "name", "", "teacher", "location", "color", "", "slots", "", "Lcom/example/insight/data/local/entities/TimeSlotEntity;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCourse", "course", "Lcom/example/insight/data/local/entities/CourseEntity;", "(Lcom/example/insight/data/local/entities/CourseEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSchedule", "schedule", "Lcom/example/insight/data/local/entities/ScheduleEntity;", "(Lcom/example/insight/data/local/entities/ScheduleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveSchedule", "Lkotlinx/coroutines/flow/Flow;", "getAllSchedules", "getFullScheduleData", "Lcom/example/insight/data/local/dao/CourseWithTimeSlot;", "getLessonTimes", "Lcom/example/insight/data/local/entities/LessonTimeEntity;", "insertSchedule", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveLessonTimes", "times", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setActiveSchedule", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ScheduleRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.local.dao.ScheduleDao scheduleDao = null;
    
    @javax.inject.Inject()
    public ScheduleRepository(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.ScheduleDao scheduleDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.ScheduleEntity>> getAllSchedules() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.insight.data.local.entities.ScheduleEntity> getActiveSchedule() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setActiveSchedule(long scheduleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertSchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveLessonTimes(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.LessonTimeEntity> times, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.entities.LessonTimeEntity>> getLessonTimes(long scheduleId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteSchedule(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.ScheduleEntity schedule, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.insight.data.local.dao.CourseWithTimeSlot>> getFullScheduleData(long scheduleId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addCourseWithSlots(long scheduleId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String teacher, @org.jetbrains.annotations.NotNull()
    java.lang.String location, int color, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.TimeSlotEntity> slots, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteCourse(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.CourseEntity course, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
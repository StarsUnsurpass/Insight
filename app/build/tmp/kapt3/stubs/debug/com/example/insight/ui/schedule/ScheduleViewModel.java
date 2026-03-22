package com.example.insight.ui.schedule;

import androidx.lifecycle.ViewModel;
import com.example.insight.data.local.dao.CourseWithTimeSlot;
import com.example.insight.data.local.entities.LessonTimeEntity;
import com.example.insight.data.local.entities.ScheduleEntity;
import com.example.insight.data.local.entities.TimeSlotEntity;
import com.example.insight.data.repository.ScheduleRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JL\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\rJ\u0010\u0010%\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\rH\u0002J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020(R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/insight/ui/schedule/ScheduleViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/insight/data/repository/ScheduleRepository;", "(Lcom/example/insight/data/repository/ScheduleRepository;)V", "_currentScheduleData", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/insight/data/local/dao/CourseWithTimeSlot;", "_lessonTimes", "Lcom/example/insight/data/local/entities/LessonTimeEntity;", "activeSchedule", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/insight/data/local/entities/ScheduleEntity;", "getActiveSchedule", "()Lkotlinx/coroutines/flow/StateFlow;", "allSchedules", "getAllSchedules", "currentScheduleData", "getCurrentScheduleData", "lessonTimes", "getLessonTimes", "addCourse", "", "name", "", "teacher", "location", "color", "", "dayOfWeek", "startPeriod", "endPeriod", "weeks", "createSchedule", "deleteSchedule", "schedule", "generateDefaultTimes", "switchSchedule", "scheduleId", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ScheduleViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.repository.ScheduleRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.insight.data.local.entities.ScheduleEntity>> allSchedules = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.insight.data.local.entities.ScheduleEntity> activeSchedule = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.insight.data.local.dao.CourseWithTimeSlot>> _currentScheduleData = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.insight.data.local.dao.CourseWithTimeSlot>> currentScheduleData = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.insight.data.local.entities.LessonTimeEntity>> _lessonTimes = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.insight.data.local.entities.LessonTimeEntity>> lessonTimes = null;
    
    @javax.inject.Inject()
    public ScheduleViewModel(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.repository.ScheduleRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.insight.data.local.entities.ScheduleEntity>> getAllSchedules() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.insight.data.local.entities.ScheduleEntity> getActiveSchedule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.insight.data.local.dao.CourseWithTimeSlot>> getCurrentScheduleData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.insight.data.local.entities.LessonTimeEntity>> getLessonTimes() {
        return null;
    }
    
    private final void generateDefaultTimes(com.example.insight.data.local.entities.ScheduleEntity schedule) {
    }
    
    public final void createSchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void switchSchedule(long scheduleId) {
    }
    
    public final void addCourse(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String teacher, @org.jetbrains.annotations.NotNull()
    java.lang.String location, int color, int dayOfWeek, int startPeriod, int endPeriod, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> weeks) {
    }
    
    public final void deleteSchedule(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.ScheduleEntity schedule) {
    }
}
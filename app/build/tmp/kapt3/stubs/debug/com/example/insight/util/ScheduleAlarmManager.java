package com.example.insight.util;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.example.insight.data.local.dao.CourseWithTimeSlot;
import com.example.insight.data.local.entities.LessonTimeEntity;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/insight/util/ScheduleAlarmManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alarmManager", "Landroid/app/AlarmManager;", "calculateNextOccurrence", "Ljava/util/Calendar;", "dayOfWeek", "", "startPeriod", "lessonTimes", "", "Lcom/example/insight/data/local/entities/LessonTimeEntity;", "scheduleCourseAlarm", "", "courseWithSlots", "Lcom/example/insight/data/local/dao/CourseWithTimeSlot;", "app_debug"})
public final class ScheduleAlarmManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.AlarmManager alarmManager = null;
    
    public ScheduleAlarmManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"ScheduleExactAlarm"})
    public final void scheduleCourseAlarm(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.CourseWithTimeSlot courseWithSlots, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.LessonTimeEntity> lessonTimes) {
    }
    
    private final java.util.Calendar calculateNextOccurrence(int dayOfWeek, int startPeriod, java.util.List<com.example.insight.data.local.entities.LessonTimeEntity> lessonTimes) {
        return null;
    }
}
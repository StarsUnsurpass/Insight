package com.example.insight.util

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.insight.data.local.dao.CourseWithTimeSlot
import com.example.insight.data.local.entities.LessonTimeEntity
import java.util.*

class ScheduleAlarmManager(private val context: Context) {

    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    @SuppressLint("ScheduleExactAlarm")
    fun scheduleCourseAlarm(courseWithSlots: CourseWithTimeSlot, lessonTimes: List<LessonTimeEntity>) {
        courseWithSlots.timeSlots.forEach { slot ->
            val nextOccurrence = calculateNextOccurrence(slot.dayOfWeek, slot.startPeriod, lessonTimes) ?: return@forEach
            
            // 课前 15 分钟提醒
            val triggerTime = nextOccurrence.timeInMillis - 15 * 60 * 1000

            // 如果触发时间已经过去，我们安排下一周的同一时间
            val finalTriggerTime = if (triggerTime <= System.currentTimeMillis()) {
                val nextWeek = Calendar.getInstance()
                nextWeek.timeInMillis = triggerTime
                nextWeek.add(Calendar.WEEK_OF_YEAR, 1)
                nextWeek.timeInMillis
            } else {
                triggerTime
            }

            val requestCode = (courseWithSlots.course.courseId * 100 + slot.dayOfWeek * 10 + slot.startPeriod).toInt()

            val intent = Intent(context, ScheduleAlarmReceiver::class.java).apply {
                putExtra("COURSE_NAME", courseWithSlots.course.courseName)
                putExtra("LOCATION", courseWithSlots.course.location)
                putExtra("COURSE_ID", courseWithSlots.course.courseId)
            }

            val pendingIntent = PendingIntent.getBroadcast(
                context,
                requestCode,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                try {
                    alarmManager.setExactAndAllowWhileIdle(
                        AlarmManager.RTC_WAKEUP,
                        finalTriggerTime,
                        pendingIntent
                    )
                } catch (e: SecurityException) {
                }
            } else {
                alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    finalTriggerTime,
                    pendingIntent
                )
            }
        }
    }

    private fun calculateNextOccurrence(dayOfWeek: Int, startPeriod: Int, lessonTimes: List<LessonTimeEntity>): Calendar? {
        val calendar = Calendar.getInstance()
        val currentDay = calendar.get(Calendar.DAY_OF_WEEK) // 1=Sun, 2=Mon...
        
        // 将 Calendar.DAY_OF_WEEK 转换为我们的 1-7 (Mon-Sun)
        val todayOfWeek = if (currentDay == Calendar.SUNDAY) 7 else currentDay - 1
        
        val lessonTime = lessonTimes.find { it.period == startPeriod } ?: return null
        val timeParts = lessonTime.startTime.split(":")
        if (timeParts.size != 2) return null
        
        val startHour = timeParts[0].toInt()
        val startMinute = timeParts[1].toInt()

        val daysToAdd = if (dayOfWeek >= todayOfWeek) {
            dayOfWeek - todayOfWeek
        } else {
            7 - todayOfWeek + dayOfWeek
        }

        calendar.add(Calendar.DAY_OF_YEAR, daysToAdd)
        calendar.set(Calendar.HOUR_OF_DAY, startHour)
        calendar.set(Calendar.MINUTE, startMinute)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        // 如果计算出的时间已经过去（今天已过这节课），因为前面安排了 if triggerTime 较小就加一周，这里只需要返回计算的日期。
        if (daysToAdd == 0 && calendar.timeInMillis <= System.currentTimeMillis()) {
            calendar.add(Calendar.WEEK_OF_YEAR, 1)
        }

        return calendar
    }
}

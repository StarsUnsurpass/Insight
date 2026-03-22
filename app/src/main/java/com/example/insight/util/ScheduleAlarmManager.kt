package com.example.insight.util

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.insight.data.local.dao.CourseWithTimeSlot
import java.util.*

class ScheduleAlarmManager(private val context: Context) {

    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    @SuppressLint("ScheduleExactAlarm")
    fun scheduleCourseAlarm(courseWithSlots: CourseWithTimeSlot) {
        val nextOccurrence = calculateNextOccurrence(courseWithSlots) ?: return
        
        // 课前 15 分钟提醒
        val triggerTime = nextOccurrence.timeInMillis - 15 * 60 * 1000

        val intent = Intent(context, ScheduleAlarmReceiver::class.java).apply {
            putExtra("COURSE_NAME", courseWithSlots.course.courseName)
            putExtra("LOCATION", courseWithSlots.course.location)
            putExtra("COURSE_ID", courseWithSlots.course.courseId)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            courseWithSlots.course.courseId.toInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                pendingIntent
            )
        } else {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                pendingIntent
            )
        }
    }

    private fun calculateNextOccurrence(course: CourseWithTimeSlot): Calendar? {
        val calendar = Calendar.getInstance()
        val currentDay = calendar.get(Calendar.DAY_OF_WEEK) // 1=Sun, 2=Mon...
        
        // 将 Calendar.DAY_OF_WEEK 转换为我们的 1-7 (Mon-Sun)
        val todayOfWeek = if (currentDay == Calendar.SUNDAY) 7 else currentDay - 1
        
        // 找到该课程在接下来最快发生的一次
        val upcomingSlot = course.timeSlots
            .filter { it.dayOfWeek >= todayOfWeek }
            .sortedBy { it.dayOfWeek * 100 + it.startPeriod }
            .firstOrNull() ?: course.timeSlots.sortedBy { it.dayOfWeek * 100 + it.startPeriod }.firstOrNull()

        if (upcomingSlot == null) return null

        val daysToAdd = if (upcomingSlot.dayOfWeek >= todayOfWeek) {
            upcomingSlot.dayOfWeek - todayOfWeek
        } else {
            7 - todayOfWeek + upcomingSlot.dayOfWeek
        }

        calendar.add(Calendar.DAY_OF_YEAR, daysToAdd)
        // 假设第 1 节课是 08:00
        val hour = 8 + (upcomingSlot.startPeriod - 1)
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        
        // 如果计算出的时间已经过去（今天已过这节课），推迟一周
        if (calendar.timeInMillis <= System.currentTimeMillis()) {
            calendar.add(Calendar.WEEK_OF_YEAR, 1)
        }

        return calendar
    }
}

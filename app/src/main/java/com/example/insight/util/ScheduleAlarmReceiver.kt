package com.example.insight.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.insight.R

class ScheduleAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val courseName = intent.getStringExtra("COURSE_NAME") ?: "课程"
        val location = intent.getStringExtra("LOCATION") ?: "未知地点"
        val courseId = intent.getLongExtra("COURSE_ID", 0)

        showNotification(context, courseName, location, courseId.toInt())
    }

    private fun showNotification(context: Context, name: String, location: String, id: Int) {
        val channelId = "COURSE_REMINDER"
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "课程提醒", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("即将上课：$name")
            .setContentText("地点：$location")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(id, notification)
    }
}

package com.example.insight.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * 课表总表
 */
@Entity(tableName = "schedule_tables")
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val scheduleId: Long = 0,
    val scheduleName: String,
    val isCurrentActive: Boolean = false,
    val termStartDate: Long = System.currentTimeMillis(), // 学期开学日期
    val morningLessonCount: Int = 4,   // 上午节次
    val afternoonLessonCount: Int = 4, // 下午节次
    val eveningLessonCount: Int = 2    // 晚上节次
)

/**
 * 节次时间配置表
 */
@Entity(
    tableName = "lesson_times",
    foreignKeys = [
        ForeignKey(
            entity = ScheduleEntity::class,
            parentColumns = ["scheduleId"],
            childColumns = ["scheduleId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("scheduleId")]
)
data class LessonTimeEntity(
    @PrimaryKey(autoGenerate = true) val timeId: Long = 0,
    val scheduleId: Long,
    val period: Int,       // 第几节
    val startTime: String, // "08:00"
    val endTime: String,   // "08:45"
    val section: Int       // 0:上午, 1:下午, 2:晚上
)

/**
 * 课程元数据表
 */
@Entity(
    tableName = "course_metadata",
    foreignKeys = [
        ForeignKey(
            entity = ScheduleEntity::class,
            parentColumns = ["scheduleId"],
            childColumns = ["scheduleId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("scheduleId")]
)
data class CourseEntity(
    @PrimaryKey(autoGenerate = true) val courseId: Long = 0,
    val scheduleId: Long,
    val courseName: String,
    val teacherName: String = "",
    val location: String = "",
    val themeColor: Int = 0xFFBBDEFB.toInt() // 默认蓝色
)

/**
 * 时间切片表：存储具体的上课时间点和周次
 */
@Entity(
    tableName = "time_slots",
    foreignKeys = [
        ForeignKey(
            entity = CourseEntity::class,
            parentColumns = ["courseId"],
            childColumns = ["courseId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("courseId")]
)
data class TimeSlotEntity(
    @PrimaryKey(autoGenerate = true) val slotId: Long = 0,
    val courseId: Long,
    val dayOfWeek: Int, // 1-7 (Mon-Sun)
    val startPeriod: Int, // 开始节次 (如第1节)
    val endPeriod: Int,   // 结束节次 (如第2节)
    val activeWeeks: List<Int> // 活跃周次 (例如 [1, 2, 3, 4, 5, 7, 9])
)

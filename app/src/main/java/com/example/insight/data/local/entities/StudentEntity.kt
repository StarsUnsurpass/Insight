package com.example.insight.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "student_table")
data class StudentEntity(
    @PrimaryKey val studentId: String = UUID.randomUUID().toString(),
    val name: String,
    val gender: Int, // 0: Unknown, 1: Male, 2: Female
    val age: Int,
    val className: String,
    val latestScore: Float = 0f,
    val createdAt: Long = System.currentTimeMillis()
)

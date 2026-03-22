package com.example.insight.ui.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insight.data.local.dao.CourseWithTimeSlot
import com.example.insight.data.local.entities.LessonTimeEntity
import com.example.insight.data.local.entities.ScheduleEntity
import com.example.insight.data.local.entities.TimeSlotEntity
import com.example.insight.data.repository.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val repository: ScheduleRepository
) : ViewModel() {

    val allSchedules: StateFlow<List<ScheduleEntity>> = repository.getAllSchedules()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activeSchedule: StateFlow<ScheduleEntity?> = repository.getActiveSchedule()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    private val _currentScheduleData = MutableStateFlow<List<CourseWithTimeSlot>>(emptyList())
    val currentScheduleData: StateFlow<List<CourseWithTimeSlot>> = _currentScheduleData.asStateFlow()

    private val _lessonTimes = MutableStateFlow<List<LessonTimeEntity>>(emptyList())
    val lessonTimes: StateFlow<List<LessonTimeEntity>> = _lessonTimes.asStateFlow()

    init {
        viewModelScope.launch {
            activeSchedule.collect { schedule ->
                schedule?.let {
                    // Fetch courses
                    repository.getFullScheduleData(it.scheduleId).collect { data ->
                        _currentScheduleData.value = data
                    }
                }
            }
        }
        
        viewModelScope.launch {
            activeSchedule.collect { schedule ->
                schedule?.let {
                    // Fetch lesson times or generate defaults
                    repository.getLessonTimes(it.scheduleId).collect { times ->
                        if (times.isEmpty()) {
                            generateDefaultTimes(it)
                        } else {
                            _lessonTimes.value = times
                        }
                    }
                }
            }
        }
    }

    private fun generateDefaultTimes(schedule: ScheduleEntity) {
        val defaults = mutableListOf<LessonTimeEntity>()
        var currentStartHour = 8
        var currentStartMin = 0
        
        val total = schedule.morningLessonCount + schedule.afternoonLessonCount + schedule.eveningLessonCount
        for (i in 1..total) {
            val section = when {
                i <= schedule.morningLessonCount -> 0
                i <= schedule.morningLessonCount + schedule.afternoonLessonCount -> 1
                else -> 2
            }
            
            // Simplified: 45 min class, 10 min break
            val start = String.format("%02d:%02d", currentStartHour, currentStartMin)
            currentStartMin += 45
            if (currentStartMin >= 60) {
                currentStartHour += 1
                currentStartMin -= 60
            }
            val end = String.format("%02d:%02d", currentStartHour, currentStartMin)
            
            defaults.add(LessonTimeEntity(
                scheduleId = schedule.scheduleId,
                period = i,
                startTime = start,
                endTime = end,
                section = section
            ))
            
            // Break
            currentStartMin += 10
            if (currentStartMin >= 60) {
                currentStartHour += 1
                currentStartMin -= 60
            }
            
            // Lunch break gap
            if (i == schedule.morningLessonCount) {
                currentStartHour = 14
                currentStartMin = 0
            }
            // Dinner break gap
            if (i == schedule.morningLessonCount + schedule.afternoonLessonCount) {
                currentStartHour = 19
                currentStartMin = 0
            }
        }
        
        viewModelScope.launch {
            repository.saveLessonTimes(defaults)
        }
    }

    fun createSchedule(name: String) {
        viewModelScope.launch {
            val id = repository.insertSchedule(name)
            repository.setActiveSchedule(id)
        }
    }

    fun switchSchedule(scheduleId: Long) {
        viewModelScope.launch {
            repository.setActiveSchedule(scheduleId)
        }
    }

    fun addCourse(
        name: String,
        teacher: String,
        location: String,
        color: Int,
        dayOfWeek: Int,
        startPeriod: Int,
        endPeriod: Int,
        weeks: List<Int>
    ) {
        val currentId = activeSchedule.value?.scheduleId ?: return
        viewModelScope.launch {
            repository.addCourseWithSlots(
                scheduleId = currentId,
                name = name,
                teacher = teacher,
                location = location,
                color = color,
                slots = listOf(
                    TimeSlotEntity(
                        courseId = 0,
                        dayOfWeek = dayOfWeek,
                        startPeriod = startPeriod,
                        endPeriod = endPeriod,
                        activeWeeks = weeks
                    )
                )
            )
        }
    }

    fun deleteSchedule(schedule: ScheduleEntity) {
        viewModelScope.launch {
            repository.deleteSchedule(schedule)
        }
    }
}

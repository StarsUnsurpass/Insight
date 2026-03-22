package com.example.insight.ui.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.compose.animation.core.*
import java.util.Calendar
import com.example.insight.data.local.dao.CourseWithTimeSlot
import com.example.insight.data.local.entities.LessonTimeEntity
import com.example.insight.data.local.entities.TimeSlotEntity

@Composable
fun ScheduleGrid(
    courseWithSlots: List<CourseWithTimeSlot>,
    lessonTimes: List<LessonTimeEntity>,
    modifier: Modifier = Modifier,
    rowHeight: Dp = 72.dp,
    sidebarWidth: Dp = 48.dp,
    headerHeight: Dp = 56.dp,
    onCourseClick: (CourseWithTimeSlot) -> Unit = {},
    onEmptyCellClick: (day: Int, period: Int) -> Unit = { _, _ -> }
) {
    val days = listOf("周一", "周二", "周三", "周四", "周五", "周六", "周日")
    
    // Group periods by section
    val morningPeriods = lessonTimes.filter { it.section == 0 }
    val afternoonPeriods = lessonTimes.filter { it.section == 1 }
    val eveningPeriods = lessonTimes.filter { it.section == 2 }

    Column(modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        // --- X Axis: Days ---
        Row(modifier = Modifier.fillMaxWidth().height(headerHeight).background(MaterialTheme.colorScheme.surface)) {
            Box(modifier = Modifier.width(sidebarWidth))
            days.forEach { day ->
                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = day, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
                }
            }
        }

        Box(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            // --- Background Grid & Y Axis ---
            Column {
                RenderSection(morningPeriods, sidebarWidth, rowHeight, onEmptyCellClick)
                if (afternoonPeriods.isNotEmpty()) {
                    SectionDivider("午休", rowHeight / 2)
                    RenderSection(afternoonPeriods, sidebarWidth, rowHeight, onEmptyCellClick)
                }
                if (eveningPeriods.isNotEmpty()) {
                    SectionDivider("晚修", rowHeight / 2)
                    RenderSection(eveningPeriods, sidebarWidth, rowHeight, onEmptyCellClick)
                }
            }

            // --- Course Cards Overlay ---
            ScheduleLayout(
                modifier = Modifier.padding(start = sidebarWidth),
                rowHeight = rowHeight,
                lessonTimes = lessonTimes
            ) {
                courseWithSlots.forEach { courseData ->
                    courseData.timeSlots.forEach { slot ->
                        CourseCard(
                            courseData = courseData,
                            modifier = Modifier.coursePosition(
                                day = slot.dayOfWeek,
                                start = slot.startPeriod,
                                end = slot.endPeriod
                            ),
                            onClick = { onCourseClick(courseData) }
                        )
                    }
                }
            }
            
            // --- Current Time Indicator Overlay ---
            TimeIndicatorOverlay(
                lessonTimes = lessonTimes,
                rowHeight = rowHeight,
                sidebarWidth = sidebarWidth
            )
        }
    }
}

@Composable
fun TimeIndicatorOverlay(
    lessonTimes: List<LessonTimeEntity>,
    rowHeight: Dp,
    sidebarWidth: Dp
) {
    if (lessonTimes.isEmpty()) return
    
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
    val currentMinutes = hour * 60 + minute
    
    // Calculate Y offset based on current time linearly mapped to periods
    // Simplifying: find if it's within a period or between periods
    var yOffset: Float? = null
    
    for (i in lessonTimes.indices) {
        val time = lessonTimes[i]
        val startParts = time.startTime.split(":")
        val endParts = time.endTime.split(":")
        if (startParts.size == 2 && endParts.size == 2) {
            val startMin = startParts[0].toInt() * 60 + startParts[1].toInt()
            val endMin = endParts[0].toInt() * 60 + endParts[1].toInt()
            
            val periodYStart = (time.period - 1) * rowHeight.value
            var extraSectionGaps = 0f
            if (time.section >= 1) extraSectionGaps += (rowHeight.value / 2)
            if (time.section >= 2) extraSectionGaps += (rowHeight.value / 2)
            
            val absoluteYStart = periodYStart + extraSectionGaps
            
            if (currentMinutes in startMin..endMin) {
                val progress = (currentMinutes - startMin).toFloat() / (endMin - startMin).toFloat()
                yOffset = absoluteYStart + progress * rowHeight.value
                break
            } else if (i < lessonTimes.lastIndex) {
                // Check if in gap
                val nextTime = lessonTimes[i+1]
                val nextStartParts = nextTime.startTime.split(":")
                val nextStartMin = nextStartParts[0].toInt() * 60 + nextStartParts[1].toInt()
                if (currentMinutes in endMin..nextStartMin && endMin != nextStartMin) {
                    val gapProgress = (currentMinutes - endMin).toFloat() / (nextStartMin - endMin).toFloat()
                    
                    var nextExtraSectionGaps = 0f
                    if (nextTime.section >= 1) nextExtraSectionGaps += (rowHeight.value / 2)
                    if (nextTime.section >= 2) nextExtraSectionGaps += (rowHeight.value / 2)
                    
                    val nextAbsoluteYStart = ((nextTime.period - 1) * rowHeight.value) + nextExtraSectionGaps
                    val gapHeight = nextAbsoluteYStart - (absoluteYStart + rowHeight.value)
                    yOffset = (absoluteYStart + rowHeight.value) + gapProgress * gapHeight
                    break
                }
            }
        }
    }
    
    if (yOffset != null) {
        val infiniteTransition = rememberInfiniteTransition()
        val alpha by infiniteTransition.animateFloat(
            initialValue = 0.3f,
            targetValue = 1.0f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = yOffset.dp)
                .height(2.dp)
                .zIndex(10f)
                .background(MaterialTheme.colorScheme.error.copy(alpha = alpha))
        ) {
            Box(
                modifier = Modifier
                    .padding(start = sidebarWidth - 4.dp)
                    .size(6.dp)
                    .offset(y = (-2).dp)
                    .clip(androidx.compose.foundation.shape.CircleShape)
                    .background(MaterialTheme.colorScheme.error)
            )
        }
    }
}

@Composable
fun RenderSection(
    periods: List<LessonTimeEntity>,
    sidebarWidth: Dp,
    rowHeight: Dp,
    onEmptyCellClick: (Int, Int) -> Unit
) {
    periods.forEach { time ->
        Row(modifier = Modifier.fillMaxWidth().height(rowHeight)) {
            // Sidebar Time
            Column(
                modifier = Modifier.width(sidebarWidth).fillMaxHeight().padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = time.period.toString(), style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
                Text(text = time.startTime, style = MaterialTheme.typography.labelSmall, fontSize = 8.sp, color = Color.Gray)
                Text(text = time.endTime, style = MaterialTheme.typography.labelSmall, fontSize = 8.sp, color = Color.Gray)
            }
            
            // Grid Cells
            repeat(7) { dayIndex ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(0.5.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f))
                        .clickable { onEmptyCellClick(dayIndex + 1, time.period) }
                )
            }
        }
    }
}

@Composable
fun SectionDivider(label: String, height: Dp) {
    Row(
        modifier = Modifier.fillMaxWidth().height(height).background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        HorizontalDivider(modifier = Modifier.weight(1f).padding(horizontal = 16.dp), color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = Color.Gray, fontSize = 10.sp)
        HorizontalDivider(modifier = Modifier.weight(1f).padding(horizontal = 16.dp), color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
    }
}

@Composable
fun ScheduleLayout(
    rowHeight: Dp,
    lessonTimes: List<LessonTimeEntity>,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val columnWidth = constraints.maxWidth / 7
        
        val placeables = measurables.map { measurable ->
            val parentData = measurable.parentData as? CoursePositionData
            val span = if (parentData != null) (parentData.end - parentData.start + 1) else 1
            
            measurable.measure(constraints.copy(
                minWidth = columnWidth,
                maxWidth = columnWidth,
                minHeight = span * rowHeight.roundToPx(),
                maxHeight = span * rowHeight.roundToPx()
            ))
        }

        layout(constraints.maxWidth, 1500) { 
            placeables.forEachIndexed { index, placeable ->
                val parentData = measurables[index].parentData as? CoursePositionData
                if (parentData != null) {
                    val x = (parentData.day - 1) * columnWidth
                    
                    val startTime = lessonTimes.find { it.period == parentData.start }
                    var yOffset = 0
                    if (startTime != null) {
                        yOffset = (parentData.start - 1) * rowHeight.roundToPx()
                        if (startTime.section >= 1) yOffset += (rowHeight.roundToPx() / 2) 
                        if (startTime.section >= 2) yOffset += (rowHeight.roundToPx() / 2) 
                    }
                    
                    placeable.placeRelative(x, yOffset)
                }
            }
        }
    }
}

data class CoursePositionData(
    val day: Int,
    val start: Int,
    val end: Int
)

fun Modifier.coursePosition(day: Int, start: Int, end: Int): Modifier = this.then(
    object : androidx.compose.ui.layout.ParentDataModifier {
        override fun androidx.compose.ui.unit.Density.modifyParentData(parentData: Any?): Any = 
            CoursePositionData(day, start, end)
    }
)

@Composable
fun CourseCard(
    courseData: CourseWithTimeSlot,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val color = Color(courseData.course.themeColor)
    Box(
        modifier = modifier
            .padding(2.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color.copy(alpha = 0.9f))
            .clickable { onClick() }
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(4.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = courseData.course.courseName,
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, fontSize = 11.sp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                maxLines = 3
            )
            if (courseData.course.location.isNotEmpty()) {
                Text(
                    text = courseData.course.location,
                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 9.sp),
                    textAlign = TextAlign.Center,
                    color = Color.Black.copy(alpha = 0.7f),
                    maxLines = 2
                )
            }
        }
    }
}

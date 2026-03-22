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

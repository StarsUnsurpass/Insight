package com.example.insight.ui.schedule;

import androidx.compose.foundation.layout.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.example.insight.data.local.dao.CourseWithTimeSlot;
import com.example.insight.data.local.entities.LessonTimeEntity;
import com.example.insight.data.local.entities.TimeSlotEntity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001aJ\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u00a6\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001928\b\u0002\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00010\u0010H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001aE\u0010 \u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\u0002\b\"H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*\u001a\"\u0010+\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006."}, d2 = {"CourseCard", "", "courseData", "Lcom/example/insight/data/local/dao/CourseWithTimeSlot;", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function0;", "RenderSection", "periods", "", "Lcom/example/insight/data/local/entities/LessonTimeEntity;", "sidebarWidth", "Landroidx/compose/ui/unit/Dp;", "rowHeight", "onEmptyCellClick", "Lkotlin/Function2;", "", "RenderSection-ghNngFA", "(Ljava/util/List;FFLkotlin/jvm/functions/Function2;)V", "ScheduleGrid", "courseWithSlots", "lessonTimes", "headerHeight", "onCourseClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "day", "period", "ScheduleGrid-Wz6fEic", "(Ljava/util/List;Ljava/util/List;Landroidx/compose/ui/Modifier;FFFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "ScheduleLayout", "content", "Landroidx/compose/runtime/Composable;", "ScheduleLayout-kHDZbjc", "(FLjava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;)V", "SectionDivider", "label", "", "height", "SectionDivider-3ABfNKs", "(Ljava/lang/String;F)V", "coursePosition", "start", "end", "app_debug"})
public final class ScheduleGridKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final androidx.compose.ui.Modifier coursePosition(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier $this$coursePosition, int day, int start, int end) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CourseCard(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.dao.CourseWithTimeSlot courseData, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}
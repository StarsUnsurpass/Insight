package com.example.insight.ui.screens;

import android.os.Build;
import android.widget.Toast;
import androidx.compose.animation.*;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material.icons.outlined.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import com.example.insight.ui.state.InsightViewModel;
import com.example.insight.ui.state.UserPreferences;
import com.example.insight.ui.state.UserRole;
import com.example.insight.graph.*;
import com.example.insight.ui.theme.*;
import androidx.compose.material.icons.automirrored.filled.*;
import com.example.insight.data.model.Courseware;
import com.example.insight.data.model.LessonPlanSample;
import com.example.insight.data.model.KnowledgeProvider;
import kotlin.collections.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u00a8\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007\u001a,\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0007\u001aL\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a\u0016\u0010\u001a\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001aN\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\'H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)\u001a\u001e\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020%2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u001e\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a$\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u0016H\u0007\u001a$\u00103\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u001e\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u00b6\u0001\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u00162\u0014\u0010A\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u0016H\u0007\u001a\u0010\u0010C\u001a\u00020\u00012\u0006\u00100\u001a\u000201H\u0007\u001a\u00a4\u0001\u0010D\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u00162\u0014\u0010A\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u0016H\u0007\u001a\u001e\u0010I\u001a\u00020\u00012\u0006\u0010+\u001a\u00020%2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a&\u0010J\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.2\u0006\u0010K\u001a\u00020\u001d2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a*\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u001d2\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0007\u001a2\u0010P\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001d2\b\b\u0002\u0010S\u001a\u00020T2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u0016\u0010U\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020\u001d\u001a\u0016\u0010V\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\u0006\u0010K\u001a\u00020\u001d\u001aJ\u0010W\u001a\u00020\u0001*\u00020X2\u0006\u0010Y\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0016H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b]\u0010^\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006_"}, d2 = {"AnalysisTab", "", "students", "", "Lcom/example/insight/data/local/entities/StudentEntity;", "CoursewareCard", "courseware", "Lcom/example/insight/data/model/Courseware;", "onClick", "Lkotlin/Function0;", "onEdit", "ExportProgressDialog", "role", "Lcom/example/insight/ui/state/UserRole;", "GooeyDockContent", "selectedTab", "Lcom/example/insight/ui/screens/InsightTab;", "isVisible", "", "currentDockWidth", "Landroidx/compose/ui/unit/Dp;", "onTabSelected", "Lkotlin/Function1;", "onCameraClick", "GooeyDockContent-TDGSqEk", "(Lcom/example/insight/ui/screens/InsightTab;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "GraphPreviewCard", "HighlightedText", "text", "", "keyword", "style", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "highlightColor", "maxLines", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "HighlightedText-RFTa1QY", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JJII)V", "HistoryCard", "index", "HistoryCardByPoint", "point", "Lcom/example/insight/data/model/KnowledgePoint;", "HomeTab", "preferences", "Lcom/example/insight/ui/state/UserPreferences;", "onNavigateToKnowledgeDetail", "LearningAnalysisSummary", "LessonPlanSampleCard", "plan", "Lcom/example/insight/data/model/LessonPlanSample;", "MainScreen", "viewModel", "Lcom/example/insight/ui/state/InsightViewModel;", "onNavigateToScanner", "onNavigateToSettings", "onNavigateToExport", "onNavigateToStudentList", "onNavigateToLessonPlans", "onNavigateToMindMap", "onNavigateToCourseware", "onNavigateToCoursewareEditor", "onNavigateToLessonPlanSample", "MapTab", "ProfileTab", "studentCount", "lessonPlanCount", "onManageStudents", "onManageLessonPlans", "SearchResultItem", "SearchResultItemData", "query", "SettingRow", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "title", "StatCard", "label", "value", "modifier", "Landroidx/compose/ui/Modifier;", "extractSnippet", "getSnippet", "TabIconFluid", "Landroidx/compose/foundation/layout/BoxScope;", "tab", "alpha", "", "slotWidth", "TabIconFluid-Z4HSEVQ", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/example/insight/ui/screens/InsightTab;Lcom/example/insight/ui/screens/InsightTab;FFLkotlin/jvm/functions/Function1;)V", "app_release"})
public final class MainScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void MainScreen(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.InsightViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToScanner, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSettings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToExport, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToStudentList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToLessonPlans, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToMindMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToCourseware, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToCoursewareEditor, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToLessonPlanSample, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToKnowledgeDetail) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HomeTab(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToKnowledgeDetail) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HistoryCardByPoint(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.KnowledgePoint point, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ProfileTab(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences, int studentCount, int lessonPlanCount, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onManageStudents, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onManageLessonPlans, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToMindMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSettings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToExport, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToCourseware, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToCoursewareEditor, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToLessonPlanSample) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LessonPlanSampleCard(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.LessonPlanSample plan, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SearchResultItem(int index, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SearchResultItemData(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.KnowledgePoint point, @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getSnippet(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.KnowledgePoint point, @org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String extractSnippet(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HistoryCard(int index, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void MapTab(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserPreferences preferences) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GraphPreviewCard(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LearningAnalysisSummary(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.StudentEntity> students, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AnalysisTab(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.StudentEntity> students) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatCard(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SettingRow(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ExportProgressDialog(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserRole role) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CoursewareCard(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.Courseware courseware, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit) {
    }
}
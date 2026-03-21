package com.example.insight.ui.screens;

import androidx.compose.animation.*;
import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.*;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material.icons.outlined.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.example.insight.data.local.entities.LessonPlanEntity;
import com.example.insight.data.local.entities.ScanRecordEntity;
import com.example.insight.data.local.entities.KnowledgeNodeEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001at\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u00a6\u0002\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00062\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\'\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010$2\b\u0010(\u001a\u0004\u0018\u00010\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a$\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a4\u0010.\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u00a4\u0001\u00100\u001a\u00020\u00012\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00112\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u0002060\"2\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002080\"2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032>\u0010:\u001a:\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u00ac\u0001\u0010=\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00062\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001aB\u0010>\u001a\u00020\u00012\f\u0010?\u001a\b\u0012\u0004\u0012\u0002060\"2\b\u0010(\u001a\u0004\u0018\u00010\u00062\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a(\u0010A\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0007\u001a8\u0010B\u001a\u00020\u00012\f\u0010C\u001a\b\u0012\u0004\u0012\u0002080\"2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u001e\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a>\u0010I\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"H\u0002\u00a8\u0006J"}, d2 = {"AiDialog", "", "onDismiss", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function1;", "", "BlockItem", "index", "", "block", "Lcom/example/insight/ui/screens/LessonBlock;", "onContentChange", "onRemove", "onMoveUp", "onMoveDown", "isFirst", "", "isLast", "onLinkQuestion", "EditorMode", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "title", "onTitleChange", "targetClass", "onTargetClassChange", "lessonType", "onLessonTypeChange", "keyPoints", "onKeyPointsChange", "difficulties", "onDifficultiesChange", "blocks", "", "onBlockChange", "Lkotlin/Function2;", "onAddBlock", "onRemoveBlock", "onMoveBlock", "selectedNodeId", "onLinkNode", "HandwritingConfigPanel", "settings", "Lcom/example/insight/ui/screens/HandwritingSettings;", "onSettingsChange", "HandwritingSimulationMode", "content", "LessonPlanEditorScreen", "plan", "Lcom/example/insight/data/local/entities/LessonPlanEntity;", "aiOutput", "isStreaming", "allKnowledgeNodes", "Lcom/example/insight/data/local/entities/KnowledgeNodeEntity;", "allQuestions", "Lcom/example/insight/data/local/entities/ScanRecordEntity;", "onBack", "onSave", "Lkotlin/Function8;", "onGenerateAi", "MetadataHeader", "NodeLinkerSheet", "nodes", "onNodeSelected", "PreviewMode", "QuestionLinkerSheet", "questions", "onQuestionSelected", "ToolbarButton", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "onClick", "buildMarkdown", "app_release"})
public final class LessonPlanEditorScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void LessonPlanEditorScreen(@org.jetbrains.annotations.Nullable()
    com.example.insight.data.local.entities.LessonPlanEntity plan, @org.jetbrains.annotations.NotNull()
    java.lang.String aiOutput, boolean isStreaming, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity> allKnowledgeNodes, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.ScanRecordEntity> allQuestions, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function8<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, kotlin.Unit> onSave, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onGenerateAi) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PreviewMode(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues padding, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String targetClass, @org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HandwritingSimulationMode(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.screens.HandwritingSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.insight.ui.screens.HandwritingSettings, kotlin.Unit> onSettingsChange) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HandwritingConfigPanel(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.screens.HandwritingSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.insight.ui.screens.HandwritingSettings, kotlin.Unit> onSettingsChange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EditorMode(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues padding, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTitleChange, @org.jetbrains.annotations.NotNull()
    java.lang.String targetClass, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTargetClassChange, @org.jetbrains.annotations.NotNull()
    java.lang.String lessonType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onLessonTypeChange, @org.jetbrains.annotations.NotNull()
    java.lang.String keyPoints, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onKeyPointsChange, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulties, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDifficultiesChange, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.ui.screens.LessonBlock> blocks, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onBlockChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddBlock, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onRemoveBlock, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit> onMoveBlock, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedNodeId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLinkNode, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLinkQuestion) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MetadataHeader(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTitleChange, @org.jetbrains.annotations.NotNull()
    java.lang.String targetClass, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTargetClassChange, @org.jetbrains.annotations.NotNull()
    java.lang.String lessonType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onLessonTypeChange, @org.jetbrains.annotations.NotNull()
    java.lang.String keyPoints, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onKeyPointsChange, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulties, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDifficultiesChange, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedNodeId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLinkNode) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BlockItem(int index, @org.jetbrains.annotations.NotNull()
    com.example.insight.ui.screens.LessonBlock block, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onContentChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRemove, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onMoveUp, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onMoveDown, boolean isFirst, boolean isLast, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLinkQuestion) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ToolbarButton(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AiDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConfirm) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void NodeLinkerSheet(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.KnowledgeNodeEntity> nodes, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedNodeId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNodeSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void QuestionLinkerSheet(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.ScanRecordEntity> questions, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.insight.data.local.entities.ScanRecordEntity, kotlin.Unit> onQuestionSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    private static final java.lang.String buildMarkdown(java.lang.String title, java.lang.String lessonType, java.lang.String targetClass, java.lang.String keyPoints, java.lang.String difficulties, java.util.List<com.example.insight.ui.screens.LessonBlock> blocks) {
        return null;
    }
}
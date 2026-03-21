package com.example.insight.ui.screens;

import androidx.compose.animation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.*;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextDecoration;
import com.example.insight.data.model.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a$\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rH\u0007\u00a8\u0006\u000f"}, d2 = {"KnowledgeDetailScreen", "", "nodeId", "", "onBack", "Lkotlin/Function0;", "PastExamQuestionItem", "examQuestion", "Lcom/example/insight/data/model/PastExamQuestion;", "TextbookParagraphCard", "paragraph", "Lcom/example/insight/data/model/TextbookParagraph;", "onSentenceClick", "Lkotlin/Function1;", "Lcom/example/insight/data/model/HighlightedSentence;", "app_debug"})
public final class KnowledgeDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void KnowledgeDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String nodeId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TextbookParagraphCard(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.TextbookParagraph paragraph, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.insight.data.model.HighlightedSentence, kotlin.Unit> onSentenceClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PastExamQuestionItem(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.PastExamQuestion examQuestion) {
    }
}
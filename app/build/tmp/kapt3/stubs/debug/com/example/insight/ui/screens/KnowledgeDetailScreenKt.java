package com.example.insight.ui.screens;

import android.widget.TextView;
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
import io.noties.markwon.Markwon;
import io.noties.markwon.ext.tables.TablePlugin;
import io.noties.markwon.html.HtmlPlugin;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u001a\u001e\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a\u001a\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u001e\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a\u0018\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u001e\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a$\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\"H\u0007\u00a8\u0006#"}, d2 = {"ExampleSentenceCard", "", "sentence", "Lcom/example/insight/data/model/ExampleSentence;", "FamousQuoteCard", "quote", "", "author", "KnowledgeDetailScreen", "nodeId", "onBack", "Lkotlin/Function0;", "MarkdownText", "markdown", "modifier", "Landroidx/compose/ui/Modifier;", "PastExamQuestionItem", "examQuestion", "Lcom/example/insight/data/model/PastExamQuestion;", "RelatedPointDialog", "rp", "Lcom/example/insight/data/model/RelatedPoint;", "onDismiss", "SectionHeader", "title", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SentenceAnalysisDialog", "hs", "Lcom/example/insight/data/model/HighlightedSentence;", "TextbookParagraphCard", "paragraph", "Lcom/example/insight/data/model/TextbookParagraph;", "onSentenceClick", "Lkotlin/Function1;", "app_debug"})
public final class KnowledgeDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void KnowledgeDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String nodeId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MarkdownText(@org.jetbrains.annotations.NotNull()
    java.lang.String markdown, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SectionHeader(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TextbookParagraphCard(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.TextbookParagraph paragraph, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.insight.data.model.HighlightedSentence, kotlin.Unit> onSentenceClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ExampleSentenceCard(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.ExampleSentence sentence) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FamousQuoteCard(@org.jetbrains.annotations.NotNull()
    java.lang.String quote, @org.jetbrains.annotations.NotNull()
    java.lang.String author) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RelatedPointDialog(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.RelatedPoint rp, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SentenceAnalysisDialog(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.HighlightedSentence hs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PastExamQuestionItem(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.model.PastExamQuestion examQuestion) {
    }
}
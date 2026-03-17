package com.example.insight.ui.state;

import androidx.lifecycle.ViewModel;
import com.example.insight.data.repository.InsightRepository;
import com.example.insight.data.repository.DeepSeekRepository;
import com.example.insight.data.remote.DeepSeekMessage;
import com.example.insight.data.local.entities.StudentEntity;
import com.example.insight.data.local.entities.LessonPlanEntity;
import com.example.insight.data.local.entities.LessonQuestionCrossRef;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognizer;
import android.graphics.Bitmap;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bJ.\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0018J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020\u0018J\u0014\u00100\u001a\u00020\u00182\f\u00101\u001a\b\u0012\u0004\u0012\u00020*02J\u0010\u00103\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u0006\u00104\u001a\u00020\u0018J\u000e\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000bJ\u0006\u00109\u001a\u00020\u0018JR\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\u000b2\b\b\u0002\u0010@\u001a\u00020\u000b2\b\b\u0002\u0010A\u001a\u00020\u000bJ\u0010\u0010B\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u000bJ\u000e\u0010E\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u000bJ\u0006\u0010F\u001a\u00020\u0018J\u0010\u0010G\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000bH\u0002J\u000e\u0010H\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u000bJ\u000e\u0010N\u001a\u00020\u00182\u0006\u0010J\u001a\u00020KJ\u000e\u0010O\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*J\u000e\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020UJ\u000e\u0010V\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006W"}, d2 = {"Lcom/example/insight/ui/state/InsightViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/insight/data/repository/InsightRepository;", "deepSeekRepository", "Lcom/example/insight/data/repository/DeepSeekRepository;", "textRecognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "(Lcom/example/insight/data/repository/InsightRepository;Lcom/example/insight/data/repository/DeepSeekRepository;Lcom/google/mlkit/vision/text/TextRecognizer;)V", "_aiOutput", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_currentScanStudentId", "_uiState", "Lcom/example/insight/ui/state/InsightUiState;", "aiOutput", "Lkotlinx/coroutines/flow/StateFlow;", "getAiOutput", "()Lkotlinx/coroutines/flow/StateFlow;", "currentScanStudentId", "getCurrentScanStudentId", "uiState", "getUiState", "addQuestionToPlan", "", "planId", "questionId", "addStudent", "name", "gender", "", "age", "className", "score", "", "analyzeStudent", "closeGraph", "deletePlan", "plan", "Lcom/example/insight/data/local/entities/LessonPlanEntity;", "deleteStudent", "student", "Lcom/example/insight/data/local/entities/StudentEntity;", "generateAiLessonPlan", "prompt", "generateSimilarQuestions", "text", "generateWeeklyReport", "importStudents", "students", "", "navigateToLessonPlanEditor", "navigateToLessonPlans", "onImageCaptured", "bitmap", "Landroid/graphics/Bitmap;", "onTextCaptured", "reset", "savePlan", "title", "content", "nodeId", "lessonType", "keyPoints", "difficulties", "blocksJson", "selectPlan", "selectStudent", "studentId", "setCurrentScanStudent", "showGraph", "startAnalysis", "updateClassName", "updateDarkMode", "enabled", "", "updateDeepSeekApiKey", "key", "updateHapticFeedback", "updateStudent", "updateThemeStyle", "style", "Lcom/example/insight/ui/state/ThemeStyle;", "updateUserRole", "role", "Lcom/example/insight/ui/state/UserRole;", "updateUsername", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class InsightViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.repository.InsightRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.insight.data.repository.DeepSeekRepository deepSeekRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.text.TextRecognizer textRecognizer = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.insight.ui.state.InsightUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.state.InsightUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _aiOutput = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> aiOutput = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _currentScanStudentId = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> currentScanStudentId = null;
    
    @javax.inject.Inject()
    public InsightViewModel(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.repository.InsightRepository repository, @org.jetbrains.annotations.NotNull()
    com.example.insight.data.repository.DeepSeekRepository deepSeekRepository, @org.jetbrains.annotations.NotNull()
    com.google.mlkit.vision.text.TextRecognizer textRecognizer) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.state.InsightUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getAiOutput() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCurrentScanStudentId() {
        return null;
    }
    
    public final void selectPlan(@org.jetbrains.annotations.Nullable()
    java.lang.String planId) {
    }
    
    public final void savePlan(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.String className, @org.jetbrains.annotations.Nullable()
    java.lang.String nodeId, @org.jetbrains.annotations.NotNull()
    java.lang.String lessonType, @org.jetbrains.annotations.NotNull()
    java.lang.String keyPoints, @org.jetbrains.annotations.NotNull()
    java.lang.String difficulties, @org.jetbrains.annotations.NotNull()
    java.lang.String blocksJson) {
    }
    
    public final void deletePlan(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.LessonPlanEntity plan) {
    }
    
    public final void generateAiLessonPlan(@org.jetbrains.annotations.NotNull()
    java.lang.String prompt) {
    }
    
    public final void addQuestionToPlan(@org.jetbrains.annotations.NotNull()
    java.lang.String planId, @org.jetbrains.annotations.NotNull()
    java.lang.String questionId) {
    }
    
    public final void navigateToLessonPlans() {
    }
    
    public final void navigateToLessonPlanEditor(@org.jetbrains.annotations.Nullable()
    java.lang.String planId) {
    }
    
    public final void onImageCaptured(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
    }
    
    public final void onTextCaptured(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    private final void startAnalysis(java.lang.String text) {
    }
    
    public final void generateWeeklyReport() {
    }
    
    public final void generateSimilarQuestions(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void addStudent(@org.jetbrains.annotations.NotNull()
    java.lang.String name, int gender, int age, @org.jetbrains.annotations.NotNull()
    java.lang.String className, float score) {
    }
    
    public final void updateStudent(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.StudentEntity student) {
    }
    
    public final void deleteStudent(@org.jetbrains.annotations.NotNull()
    com.example.insight.data.local.entities.StudentEntity student) {
    }
    
    public final void importStudents(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.insight.data.local.entities.StudentEntity> students) {
    }
    
    public final void selectStudent(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId) {
    }
    
    public final void analyzeStudent() {
    }
    
    public final void updateDeepSeekApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public final void updateUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void updateClassName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void updateUserRole(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.UserRole role) {
    }
    
    public final void updateDarkMode(boolean enabled) {
    }
    
    public final void updateThemeStyle(@org.jetbrains.annotations.NotNull()
    com.example.insight.ui.state.ThemeStyle style) {
    }
    
    public final void updateHapticFeedback(boolean enabled) {
    }
    
    public final void setCurrentScanStudent(@org.jetbrains.annotations.NotNull()
    java.lang.String studentId) {
    }
    
    public final void reset() {
    }
    
    public final void showGraph() {
    }
    
    public final void closeGraph() {
    }
}
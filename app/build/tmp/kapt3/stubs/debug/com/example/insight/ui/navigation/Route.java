package com.example.insight.ui.navigation;

import androidx.compose.runtime.Composable;
import com.example.insight.ui.screens.*;
import com.example.insight.ui.state.InsightViewModel;
import com.example.insight.ui.state.ScreenState;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000f\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u000f\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$\u00a8\u0006%"}, d2 = {"Lcom/example/insight/ui/navigation/Route;", "", "path", "", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "CoursewareEditor", "CoursewarePlayer", "Export", "KnowledgeDetail", "LessonPlanEditor", "LessonPlanList", "LessonPlanSampleDetail", "Main", "MindMap", "Scanner", "Settings", "Solution", "Starfield", "StudentDetail", "StudentList", "Lcom/example/insight/ui/navigation/Route$CoursewareEditor;", "Lcom/example/insight/ui/navigation/Route$CoursewarePlayer;", "Lcom/example/insight/ui/navigation/Route$Export;", "Lcom/example/insight/ui/navigation/Route$KnowledgeDetail;", "Lcom/example/insight/ui/navigation/Route$LessonPlanEditor;", "Lcom/example/insight/ui/navigation/Route$LessonPlanList;", "Lcom/example/insight/ui/navigation/Route$LessonPlanSampleDetail;", "Lcom/example/insight/ui/navigation/Route$Main;", "Lcom/example/insight/ui/navigation/Route$MindMap;", "Lcom/example/insight/ui/navigation/Route$Scanner;", "Lcom/example/insight/ui/navigation/Route$Settings;", "Lcom/example/insight/ui/navigation/Route$Solution;", "Lcom/example/insight/ui/navigation/Route$Starfield;", "Lcom/example/insight/ui/navigation/Route$StudentDetail;", "Lcom/example/insight/ui/navigation/Route$StudentList;", "app_debug"})
public abstract class Route {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String path = null;
    
    private Route(java.lang.String path) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPath() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/example/insight/ui/navigation/Route$CoursewareEditor;", "Lcom/example/insight/ui/navigation/Route;", "()V", "createRoute", "", "id", "app_debug"})
    public static final class CoursewareEditor extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.CoursewareEditor INSTANCE = null;
        
        private CoursewareEditor() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.Nullable()
        java.lang.String id) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/example/insight/ui/navigation/Route$CoursewarePlayer;", "Lcom/example/insight/ui/navigation/Route;", "()V", "createRoute", "", "id", "app_debug"})
    public static final class CoursewarePlayer extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.CoursewarePlayer INSTANCE = null;
        
        private CoursewarePlayer() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$Export;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class Export extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.Export INSTANCE = null;
        
        private Export() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/example/insight/ui/navigation/Route$KnowledgeDetail;", "Lcom/example/insight/ui/navigation/Route;", "()V", "createRoute", "", "id", "app_debug"})
    public static final class KnowledgeDetail extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.KnowledgeDetail INSTANCE = null;
        
        private KnowledgeDetail() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$LessonPlanEditor;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class LessonPlanEditor extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.LessonPlanEditor INSTANCE = null;
        
        private LessonPlanEditor() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$LessonPlanList;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class LessonPlanList extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.LessonPlanList INSTANCE = null;
        
        private LessonPlanList() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/example/insight/ui/navigation/Route$LessonPlanSampleDetail;", "Lcom/example/insight/ui/navigation/Route;", "()V", "createRoute", "", "id", "app_debug"})
    public static final class LessonPlanSampleDetail extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.LessonPlanSampleDetail INSTANCE = null;
        
        private LessonPlanSampleDetail() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String id) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$Main;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class Main extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.Main INSTANCE = null;
        
        private Main() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$MindMap;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class MindMap extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.MindMap INSTANCE = null;
        
        private MindMap() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$Scanner;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class Scanner extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.Scanner INSTANCE = null;
        
        private Scanner() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$Settings;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class Settings extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$Solution;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class Solution extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.Solution INSTANCE = null;
        
        private Solution() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$Starfield;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class Starfield extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.Starfield INSTANCE = null;
        
        private Starfield() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$StudentDetail;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class StudentDetail extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.StudentDetail INSTANCE = null;
        
        private StudentDetail() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/insight/ui/navigation/Route$StudentList;", "Lcom/example/insight/ui/navigation/Route;", "()V", "app_debug"})
    public static final class StudentList extends com.example.insight.ui.navigation.Route {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.insight.ui.navigation.Route.StudentList INSTANCE = null;
        
        private StudentList() {
        }
    }
}
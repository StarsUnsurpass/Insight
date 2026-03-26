package com.example.insight.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.insight.camera.CameraCaptureScreen
import com.example.insight.ui.screens.*
import com.example.insight.ui.state.InsightViewModel
import com.example.insight.ui.state.ScreenState
import com.example.insight.ui.state.KnowledgeStatus

sealed class Route(val path: String) {
    object Main : Route("main")
    object Scanner : Route("scanner")
    object Solution : Route("solution")
    object Starfield : Route("starfield")
    object Settings : Route("settings")
    object Export : Route("export")
    object StudentList : Route("student_list")
    object StudentDetail : Route("student_detail")
    object LessonPlanList : Route("lesson_plan_list")
    object LessonPlanEditor : Route("lesson_plan_editor")
    object MindMap : Route("mindmap")
    object CoursewarePlayer : Route("courseware_player/{coursewareId}") {
        fun createRoute(id: String) = "courseware_player/$id"
    }
    object CoursewareEditor : Route("courseware_editor?coursewareId={coursewareId}") {
        fun createRoute(id: String?) = if (id != null) "courseware_editor?coursewareId=$id" else "courseware_editor"
    }
    object LessonPlanSampleDetail : Route("lesson_plan_sample/{sampleId}") {
        fun createRoute(id: String) = "lesson_plan_sample/$id"
    }
    object KnowledgeDetail : Route("knowledge_detail/{nodeId}") {
        fun createRoute(id: String) = "knowledge_detail/$id"
    }
    object TextbookDetail : Route("textbook_detail/{unitId}") {
        fun createRoute(id: String) = "textbook_detail/$id"
    }
    object Schedule : Route("schedule")
}

@Composable
fun InsightNavHost(viewModel: InsightViewModel) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Route.Main.path
    ) {
        composable(Route.Main.path) {
            MainScreen(
                viewModel = viewModel,
                onNavigateToScanner = {
                    navController.navigate(Route.Scanner.path)
                },
                onNavigateToSettings = {
                    navController.navigate(Route.Settings.path)
                },
                onNavigateToExport = {
                    navController.navigate(Route.Export.path)
                },
                onNavigateToStudentList = {
                    navController.navigate(Route.StudentList.path)
                },
                onNavigateToLessonPlans = {
                    navController.navigate(Route.LessonPlanList.path)
                },
                onNavigateToMindMap = {
                    navController.navigate(Route.MindMap.path)
                },
                onNavigateToCourseware = { id ->
                    navController.navigate(Route.CoursewarePlayer.createRoute(id))
                },
                onNavigateToLessonPlanSample = { id ->
                    navController.navigate(Route.LessonPlanSampleDetail.createRoute(id))
                },
                onNavigateToKnowledgeDetail = { id ->
                    navController.navigate(Route.KnowledgeDetail.createRoute(id))
                },
                onNavigateToTextbookDetail = { id ->
                    navController.navigate(Route.TextbookDetail.createRoute(id))
                },
                onNavigateToSchedule = {
                    navController.navigate(Route.Schedule.path)
                }
            )
        }

        composable(
            route = Route.TextbookDetail.path,
            arguments = listOf(
                androidx.navigation.navArgument("unitId") {
                    type = androidx.navigation.NavType.StringType
                }
            )
        ) { backStackEntry ->
            val unitId = backStackEntry.arguments?.getString("unitId") ?: ""
            TextbookDetailScreen(
                unitId = unitId,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Route.Schedule.path) {
            com.example.insight.ui.schedule.ScheduleScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Route.KnowledgeDetail.path,
            arguments = listOf(
                androidx.navigation.navArgument("nodeId") {
                    type = androidx.navigation.NavType.StringType
                }
            )
        ) { backStackEntry ->
            val nodeId = backStackEntry.arguments?.getString("nodeId") ?: ""
            val status = uiState.preferences.knowledgeStatuses[nodeId] ?: KnowledgeStatus.PRACTICING
            
            KnowledgeDetailScreen(
                nodeId = nodeId,
                currentStatus = status,
                onStatusChange = { viewModel.updateKnowledgeStatus(nodeId, it) },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Route.LessonPlanSampleDetail.path,
            arguments = listOf(
                androidx.navigation.navArgument("sampleId") {
                    type = androidx.navigation.NavType.StringType
                }
            )
        ) { backStackEntry ->
            val sampleId = backStackEntry.arguments?.getString("sampleId") ?: ""
            LessonPlanDetailScreen(
                sampleId = sampleId,
                onBack = { navController.popBackStack() },
                onClone = { _ ->
                    // For demo, we just go to editor
                    navController.navigate(Route.LessonPlanEditor.path)
                }
            )
        }

        composable(
            route = Route.CoursewareEditor.path,
            arguments = listOf(
                androidx.navigation.navArgument("coursewareId") {
                    type = androidx.navigation.NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val coursewareId = backStackEntry.arguments?.getString("coursewareId")
            CoursewareEditorScreen(
                coursewareId = coursewareId,
                onBack = { navController.popBackStack() },
                onSave = { 
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Route.CoursewarePlayer.path,
            arguments = listOf(
                androidx.navigation.navArgument("coursewareId") {
                    type = androidx.navigation.NavType.StringType
                }
            )
        ) { backStackEntry ->
            val coursewareId = backStackEntry.arguments?.getString("coursewareId") ?: ""
            CoursewarePlayerScreen(
                coursewareId = coursewareId,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Route.MindMap.path) {
            val mindMapViewModel: MindMapViewModel = hiltViewModel()
            MindMapScreen(
                preferences = uiState.preferences,
                viewModel = mindMapViewModel,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Route.Scanner.path) {
            CameraCaptureScreen(
                onBack = { navController.popBackStack() },
                onImageCaptured = { bitmap ->
                    viewModel.onImageCaptured(bitmap)
                    navController.navigate(Route.Solution.path)
                },
                onError = { /* Handle error */ }
            )
        }

        composable(Route.Solution.path) {
            val state = uiState.screen
            val aiOutput by viewModel.aiOutput.collectAsState()
            val currentStudentId by viewModel.currentScanStudentId.collectAsState()
            if (state is ScreenState.Solution) {
                SolutionScreen(
                    capturedText = state.capturedText,
                    concepts = state.concepts,
                    aiOutput = aiOutput,
                    isStreaming = uiState.isStreaming,
                    students = uiState.students,
                    selectedStudentId = currentStudentId,
                    onBack = { 
                        viewModel.reset()
                        navController.popBackStack()
                    },
                    onShowGraph = {
                        navController.navigate(Route.Starfield.path)
                    },
                    onGenerateSimilar = { viewModel.generateSimilarQuestions(it) },
                    onStudentSelected = { viewModel.setCurrentScanStudent(it) }
                )
            }
        }

        composable(Route.Starfield.path) {
            KnowledgeGraphScreen(
                preferences = uiState.preferences,
                dbNodes = uiState.knowledgeNodes,
                dbEdges = uiState.knowledgeEdges,
                dbMastery = uiState.studentMastery,
                onNodeClick = { id ->
                    navController.navigate(Route.KnowledgeDetail.createRoute(id))
                }
            )
        }

        composable(Route.Settings.path) {
            SettingsScreen(
                preferences = uiState.preferences,
                onBack = {
                    navController.popBackStack()
                },
                onUsernameChange = { viewModel.updateUsername(it) },
                onClassNameChange = { viewModel.updateClassName(it) },
                onRoleChange = { viewModel.updateUserRole(it) },
                onDarkModeToggle = { viewModel.updateDarkMode(it) },
                onThemeStyleChange = { viewModel.updateThemeStyle(it) },
                onHapticToggle = { viewModel.updateHapticFeedback(it) },
                onHapticIntensityChange = { viewModel.updateHapticIntensity(it) },
                onDeepSeekApiKeyChange = { viewModel.updateDeepSeekApiKey(it) }
            )
        }

        composable(Route.Export.path) {
            val aiOutput by viewModel.aiOutput.collectAsState()
            ReportExportScreen(
                preferences = uiState.preferences,
                aiOutput = aiOutput,
                isStreaming = uiState.isStreaming,
                onGenerateAiReport = { viewModel.generateWeeklyReport() },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Route.StudentList.path) {
            StudentListScreen(
                students = uiState.students,
                onBack = { navController.popBackStack() },
                onStudentClick = { id ->
                    viewModel.selectStudent(id)
                    navController.navigate(Route.StudentDetail.path)
                },
                onAddStudent = { n, g, a, c, s -> viewModel.addStudent(n, g, a, c, s) },
                onImportStudents = { list -> viewModel.importStudents(list) }
            )
        }

        composable(Route.StudentDetail.path) {
            val aiOutput by viewModel.aiOutput.collectAsState()
            StudentDetailScreen(
                student = uiState.selectedStudent,
                scans = uiState.studentScans,
                aiOutput = aiOutput,
                isStreaming = uiState.isStreaming,
                onBack = { navController.popBackStack() },
                onAnalyze = { viewModel.analyzeStudent() }
            )
        }

        composable(Route.LessonPlanList.path) {
            LessonPlanListScreen(
                plans = uiState.lessonPlans,
                onBack = { navController.popBackStack() },
                onPlanClick = { id ->
                    viewModel.selectPlan(id)
                    navController.navigate(Route.LessonPlanEditor.path)
                },
                onCreateNew = {
                    viewModel.selectPlan(null)
                    navController.navigate(Route.LessonPlanEditor.path)
                },
                onDeletePlan = { viewModel.deletePlan(it) }
            )
        }

        composable(Route.LessonPlanEditor.path) {
            val aiOutput by viewModel.aiOutput.collectAsState()
            LessonPlanEditorScreen(
                plan = uiState.selectedPlan,
                aiOutput = aiOutput,
                isStreaming = uiState.isStreaming,
                allKnowledgeNodes = uiState.knowledgeNodes,
                allQuestions = uiState.allScans,
                onBack = { navController.popBackStack() },
                onSave = { title, content, className, nodeId, type, points, diffs, blocks ->
                    viewModel.savePlan(title, content, className, nodeId, type, points, diffs, blocks)
                    navController.popBackStack()
                },
                onGenerateAi = { viewModel.generateAiLessonPlan(it) }
            )
        }
    }
}

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
                }
            )
        }

        composable(Route.MindMap.path) {
            MindMapScreen(
                preferences = uiState.preferences,
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
                    content = state.content,
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
            KnowledgeGraphScreen(uiState.preferences)
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
                report = uiState.studentReport,
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

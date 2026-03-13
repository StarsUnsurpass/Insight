package com.example.insight.ui.navigation

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.insight.camera.CameraCaptureScreen
import com.example.insight.ui.screens.KnowledgeGraphScreen
import com.example.insight.ui.screens.SolutionScreen
import com.example.insight.ui.state.InsightViewModel
import com.example.insight.ui.state.ScreenState

import com.example.insight.ui.screens.MainScreen

sealed class Route(val path: String) {
    object Main : Route("main")
    object Scanner : Route("scanner")
    object Solution : Route("solution")
    object Starfield : Route("starfield")
}

@Composable
fun InsightNavHost() {
    val navController = rememberNavController()
    val viewModel: InsightViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    NavHost(navController = navController, startDestination = Route.Main.path) {
        composable(Route.Main.path) {
            MainScreen(
                onNavigateToScanner = {
                    navController.navigate(Route.Scanner.path)
                }
            )
        }
        
        composable(Route.Scanner.path) {
            CameraCaptureScreen(
                onImageCaptured = { _ ->
                    viewModel.onTextCaptured("Mock captured text")
                    navController.navigate(Route.Solution.path)
                },
                onError = { /* Handle error */ }
            )
        }
        
        composable(Route.Solution.path) {
            val state = uiState.screen
            if (state is ScreenState.Solution) {
                SolutionScreen(
                    content = state.content,
                    concepts = state.concepts,
                    onBack = {
                        viewModel.reset()
                        navController.popBackStack()
                    },
                    onShowGraph = {
                        navController.navigate(Route.Starfield.path)
                    }
                )
            }
        }

        composable(Route.Starfield.path) {
            KnowledgeGraphScreen(
                onClose = {
                    navController.popBackStack()
                }
            )
        }
    }
}

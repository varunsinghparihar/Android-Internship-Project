package com.example.internship_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.internship_project.browserActivity.BrowserScreen
import com.example.internship_project.recyclerViewActivity.DetailScreen
import com.example.internship_project.recyclerViewActivity.ListScreen
import com.example.internship_project.recyclerViewActivity.API.PostUiState
import com.example.internship_project.recyclerViewActivity.API.PostViewModel
import com.example.internship_project.ui.theme.Internship_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            Internship_ProjectTheme {
                val postViewModel: PostViewModel = viewModel()
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        MainScreen(
                            onListClick = { navController.navigate("list") },
                            onBrowserClick = { navController.navigate("browser")
                            }
                        )
                    }
                    composable("list") {
                        ListScreen(
                            onBack = { navController.popBackStack() },
                            uiState = postViewModel.uiState,
                            onRetry = { postViewModel.loadPosts() },
                            onItemClick = { id -> navController.navigate("detail/$id") },
                            isRefreshing = postViewModel.isRefreshing,
                            onRefresh = { postViewModel.loadPosts() }
                        )
                    }
                    composable(
                        route = "detail/{postId}",
                        arguments = listOf(navArgument("postId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val postId = backStackEntry.arguments?.getInt("postId")
                        val state = postViewModel.uiState
                        val post = (state as? PostUiState.Success)?.posts?.find { it.id == postId }
                        DetailScreen(post = post, onBack = {navController.popBackStack()})
                    }
                    composable("browser"){
                        BrowserScreen { navController.popBackStack() }
                    }
                }
            }
        }
    }
}
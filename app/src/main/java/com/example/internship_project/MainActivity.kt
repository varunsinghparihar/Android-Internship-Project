package com.example.internship_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.internship_project.browserActivity.BrowserScreen
import com.example.internship_project.recyclerViewActivity.DataClass
import com.example.internship_project.recyclerViewActivity.DetailScreen
import com.example.internship_project.recyclerViewActivity.ListScreen
import com.example.internship_project.recyclerViewActivity.getItems
import com.example.internship_project.ui.theme.Internship_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val items = getItems(this)

        setContent {
            Internship_ProjectTheme {
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
                        ListScreen(onBack = { navController.popBackStack() }, items = items) { index ->
                            navController.navigate("detail/$index")
                        }
                    }
                    composable(
                        "detail/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { entry ->
                        val id = entry.arguments?.getInt("id") ?: 0
                        DetailScreen(items[id]) { navController.popBackStack() }
                    }
                    composable("browser"){
                        BrowserScreen { navController.popBackStack() }
                    }
                }
            }
        }
    }
}
package com.example.markiiimark.kmm.android.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

import com.example.markiiimark.kmm.shared.navigatin.Screen;

import com.example.markiiimark.kmm.Greeting
import com.example.markiiimark.kmm.android.presentation.components.GreetingText

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GreetingText(greet())
//            val navController = rememberNavController()
//            NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
//                composable(route = Screen.RecipeList.route) { navBackStackEntry ->
//                    val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
//                    val viewModel: RecipeListViewModel = viewModel("RecipeListViewModel", factory)
//                    RecipeListScreen(
//                        isDarkTheme = false,
//                        onToggleTheme = {},
//                        onNavigateToRecipeDetailScreen = navController::navigate,
//                        viewModel = viewModel,
//                    )
//                }
//                composable(
//                    route = Screen.RecipeDetail.route + "/{recipeId}",
//                    arguments = listOf(navArgument("recipeId") {
//                        type = NavType.IntType
//                    })
//                ) { navBackStackEntry ->
//                    val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
//                    val viewModel: RecipeViewModel = viewModel("RecipeDetailViewModel", factory)
//                    RecipeDetailScreen(
//                        isDarkTheme = false,
//                        recipeId = navBackStackEntry.arguments?.getInt("recipeId"),
//                        viewModel = viewModel,
//                    )
//                }
//            }
        }
    }
}

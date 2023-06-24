package com.example.snake_97_android_game_app.navigaton // ktlint-disable package-name

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snake_97_android_game_app.controllers.GameController
import com.example.snake_97_android_game_app.ui.screens.GameBoardScreen
import com.example.snake_97_android_game_app.ui.screens.MenuScreen

@Composable
fun AppNavigation(gameController: GameController) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MenuScreen.route) {
        composable(route = AppScreens.MenuScreen.route) {
            MenuScreen(
                onNavigateToGameBoard = { navController.navigate(AppScreens.BoardGameScreen.route) },
                /*...*/
            )
        }
        composable(route = AppScreens.BoardGameScreen.route) {
            GameBoardScreen(
                gameController
            )
        }
    }
}

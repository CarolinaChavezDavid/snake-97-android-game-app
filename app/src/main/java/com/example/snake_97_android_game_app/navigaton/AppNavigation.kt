package com.example.snake_97_android_game_app.navigaton // ktlint-disable package-name

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snake_97_android_game_app.ui.screens.MenuScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun AppNavigation(scope: CoroutineScope) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.MenuScreen.route) {
        composable(route = AppScreens.MenuScreen.route) {
            MenuScreen(navController)
        }
    }
}

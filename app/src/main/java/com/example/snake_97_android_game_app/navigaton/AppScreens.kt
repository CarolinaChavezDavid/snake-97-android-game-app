package com.example.snake_97_android_game_app.navigaton // ktlint-disable package-name

sealed class AppScreens(val route: String) {
    object MenuScreen : AppScreens("menu_screen")
    object BoardGameScreen : AppScreens("game_board_screen")
}

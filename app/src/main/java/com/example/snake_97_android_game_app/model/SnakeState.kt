package com.example.snake_97_android_game_app.model // ktlint-disable package-name

data class SnakeState(
    val snake: MutableList<Pair<Int, Int>>,
    val food: Pair<Int, Int>,
    val currentDirection: Directions,
    val score: Int,
)

package com.example.snake_97_android_game_app.model // ktlint-disable package-name

import android.graphics.Point
import java.util.*

data class SnakeState(
    val snake: LinkedList<Point>,
    val food: Point,
    val currentDirection: Directions,
    val score: Int
)

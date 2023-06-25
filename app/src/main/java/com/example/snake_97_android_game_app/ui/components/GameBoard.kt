package com.example.snake_97_android_game_app.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.snake_97_android_game_app.controllers.GameController
import com.example.snake_97_android_game_app.model.Directions
import com.example.snake_97_android_game_app.model.Directions.RIGHT
import com.example.snake_97_android_game_app.ui.theme.davysGray
import com.example.snake_97_android_game_app.ui.theme.red_munsell
import kotlin.math.abs

@Composable
fun GameBoard(gameController: GameController) {
    var dragDirection: Directions
    val state = gameController.state.collectAsState(initial = null)
    var width by remember { mutableStateOf(0) }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .border(4.dp, davysGray, RoundedCornerShape(20.dp))
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    val direction = getDragDirection(dragAmount)
                    dragDirection = direction
                    Log.d("DragDirection", "Drag direction is $dragDirection")
                    change.consume()
                    gameController.direction = dragDirection
                }
            },

    ) {
        val xRate = maxWidth / 20
        val yRate = maxHeight / 20
        gameController.boardWidth = maxWidth
        gameController.boardHeight = maxHeight
        gameController.snakeSize = getSnakeSize(width)
        state.value?.let { snakeState ->
            Box(
                Modifier
                    .offset(x = xRate * snakeState.food.first, y = yRate * snakeState.food.second)
                    .size(yRate)
                    .background(
                        red_munsell,
                        CircleShape,
                    ),
            )
            state.value?.snake?.forEach {
                Box(
                    modifier = Modifier
                        .offset(x = xRate * it.first, y = yRate * it.second)
                        .size(yRate)
                        .background(
                            davysGray,
                            RoundedCornerShape(4.dp),
                        ),
                )
            }
        }
    }
}

@Composable
private fun getSnakeSize(width: Int): Int {
    return convertSizeToDp(width.times(0.1).toInt())
}

fun getDragDirection(dragAmount: Offset): Directions {
    println("offset send $dragAmount")
    return when {
        abs(dragAmount.x) > abs(dragAmount.y) -> {
            if (dragAmount.x > 0) RIGHT else Directions.LEFT
        }
        else -> {
            if (dragAmount.y > 0) Directions.DOWN else Directions.UP
        }
    }
}

@Composable
fun convertSizeToDp(size: Int): Int {
    val density = LocalDensity.current.density
    return size.div(density).toInt()
}

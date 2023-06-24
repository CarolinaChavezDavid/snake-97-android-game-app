package com.example.snake_97_android_game_app.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.snake_97_android_game_app.controllers.GameController
import com.example.snake_97_android_game_app.model.Directions
import com.example.snake_97_android_game_app.model.Directions.RIGHT
import com.example.snake_97_android_game_app.ui.theme.davysGray
import kotlin.math.abs

@Composable
fun GameBoard(gameController: GameController) {
    var dragDirection: Directions
    val state = gameController.state.collectAsState(initial = null)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(4.dp, davysGray, RoundedCornerShape(20.dp))
            .onGloballyPositioned { layoutCoordinates ->
                gameController.boardSize = layoutCoordinates.size.toSize()
            }.pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    val direction = getDragDirection(dragAmount)
                    dragDirection = direction
                    Log.d("DragDirection", "Drag direction is $dragDirection")
                    change.consume()
                    gameController.direction = dragDirection
                }
            },

        contentAlignment = Alignment.Center,
    ) {
        state.value?.let { snakeState ->
            Box(
                Modifier
                    .offset(x = snakeState.food.x.dp, y = snakeState.food.y.dp)
                    .size(gameController.snakeUnit.dp)
                    .background(
                        davysGray,
                        CircleShape,
                    ),
            )
            state.value?.snake?.forEach {
                Box(
                    modifier = Modifier
                        .offset(x = it.x.dp, y = it.x.dp)
                        .size(gameController.snakeUnit.dp)
                        .background(
                            davysGray,
                            RoundedCornerShape(4.dp),
                        ),
                )
            }
        }
    }
//
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

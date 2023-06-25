package com.example.snake_97_android_game_app.controllers // ktlint-disable package-name

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import com.example.snake_97_android_game_app.model.Directions.*
import com.example.snake_97_android_game_app.model.SnakeState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.*

class GameController(
    private val scope: CoroutineScope,
    private val onGameOver: () -> Unit,

) {
    private val mutex = Mutex()

    private var currentFoodPoint: Pair<Int, Int> = Pair(0, 0)
    private var currentScore: Int = 0

    private val mutableGameState =
        MutableStateFlow(
            SnakeState(
                snake = mutableListOf(Pair(7, 7)),
                food = Pair(5, 5),
                currentDirection = RIGHT,
                score = 0,
            ),
        )

    val state: Flow<SnakeState> = mutableGameState

    var direction = RIGHT
        set(value) {
            scope.launch {
                mutex.withLock {
                    field = value
                }
            }
        }

    var movement = Pair(0, 1)
        set(value) {
            scope.launch {
                mutex.withLock {
                    field = value
                }
            }
        }

    fun resetGame() {
        mutableGameState.update { snakeState ->
            snakeState.copy(
                snake = mutableListOf(Pair(7, 7)),
                food = Pair(5, 5),
                currentDirection = RIGHT,
                score = 0,
            )
        }

        movement = Pair(0, 1)
        direction = RIGHT
    }

    var boardWidth = 100.dp
        set(value) {
            scope.launch {
                mutex.withLock {
                    field = value
                }
            }
        }

    var boardHeight = 100.dp
        set(value) {
            scope.launch {
                mutex.withLock {
                    field = value
                }
            }
        }

    var snakeSize = 20
        set(value) {
            scope.launch {
                mutex.withLock {
                    field = value
                }
            }
        }

    var lastMovement = Pair(0, 1)
        set(value) {
            scope.launch {
                mutex.withLock {
                    field = value
                }
            }
        }

    private val isPlaying = mutableStateOf(true)

    init {
        scope.launch {
            var snakeLength = 2
            while (true) {
                delay(200)
                mutableGameState.update { gameState ->
                    val currentPoint = gameState.snake.first()

                    movement = when (direction) {
                        UP -> Pair(0, -1)
                        DOWN -> Pair(0, 1)
                        LEFT -> Pair(-1, 0)
                        RIGHT -> Pair(1, 0)
                    }

                    if (
                        (
                        (movement.first + movement.second == 0) &&
                            (lastMovement.second + lastMovement.second == 0)
                        )
                    ) {
                        movement = lastMovement
                    }

                    val newPosition = Pair(
                        (currentPoint.first + movement.first + SNAKE_SIZE) % SNAKE_SIZE,
                        (currentPoint.second + movement.second + SNAKE_SIZE) % SNAKE_SIZE,
                    )

                    val hasReachedLeftEnd =
                        currentPoint.first == 0 && gameState.currentDirection == LEFT
                    val hasReachedTopEnd =
                        currentPoint.second == 0 && gameState.currentDirection == UP
                    val hasReachedRightEnd =
                        currentPoint.first == SNAKE_SIZE - 1 && gameState.currentDirection == RIGHT
                    val hasReachedBottomEnd =
                        currentPoint.second == SNAKE_SIZE - 1 && gameState.currentDirection == DOWN

                    if (hasReachedLeftEnd || hasReachedTopEnd || hasReachedRightEnd || hasReachedBottomEnd) {
                        isPlaying.value = false
                        resetGame()
                        onGameOver.invoke()
                    }

                    if (newPosition == gameState.food) {
                        currentFoodPoint = Pair(
                            Random().nextInt(10),
                            Random().nextInt(
                                10,
                            ),
                        )
                        snakeLength++
                        currentScore++
                    } else {
                        currentFoodPoint = gameState.food
                    }

                    lastMovement = movement

                    if (gameState.snake.contains(newPosition)) {
                        snakeLength = 2
                        onGameOver.invoke()
                    }

                    gameState.copy(
                        snake = (mutableListOf(newPosition) + gameState.snake.take(snakeLength - 1)).toMutableList(),
                        food = currentFoodPoint,
                        currentDirection = direction,
                        score = currentScore,
                    )
                }
            }
        }
    }

    companion object {
        const val SNAKE_SIZE = 20
    }
}

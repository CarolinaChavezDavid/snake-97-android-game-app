package com.example.snake_97_android_game_app.controllers // ktlint-disable package-name

import android.graphics.Point
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Size
import com.example.snake_97_android_game_app.model.Directions.DOWN
import com.example.snake_97_android_game_app.model.Directions.LEFT
import com.example.snake_97_android_game_app.model.Directions.RIGHT
import com.example.snake_97_android_game_app.model.Directions.UP
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

    var snakeLength = 2

    private lateinit var currentSnakeSize: LinkedList<Point>
    private var currentFoodPoint: Point = Point()
    private var currentScore: Int = 0

    private val mutableGameState =
        MutableStateFlow(
            SnakeState(
                snake = LinkedList(),
                food = Point(500, 500),
                currentDirection = RIGHT,
                score = 0,
            ),
        )

    val state: Flow<SnakeState> = mutableGameState

    private fun resetGame() {
        mutableGameState.update { snakeState ->
            snakeState.copy(
                snake = LinkedList(),
                food = Point(),
                currentDirection = RIGHT,
                score = 0,
            )
        }

       /* scope
        mutableState
        snake.add(Point(boardSize / 2, boardSize / 2))
        generateFood()
        direction = Directions.RIGHT
        gameRunning = true
        score = 0*/
    }

    var direction = RIGHT
        set(value) {
            scope.launch {
                mutex.withLock {
                    field = value
                }
            }
        }

    var boardSize = Size(1000F, 1200F)
        set(value) {
            scope.launch {
                mutex.withLock {
                    field = value
                }
            }
        }

    private val boardWidth = boardSize.width
    private val boardHeight = boardSize.height
    private val isPlaying = mutableStateOf(true)
    private val screenDivider = boardWidth.times(0.1)
    val snakeUnit = boardWidth.div(screenDivider).toInt()

    init {
        scope.launch {
            while (isPlaying.value) {
                delay(100)
                mutableGameState.update { gameState ->
                    val newPoint = gameState.snake.peekFirst()?.let { Point(it) }
                    if (newPoint != null) {
                        when (direction) {
                            UP -> newPoint.y--
                            DOWN -> newPoint.y++
                            LEFT -> newPoint.x--
                            RIGHT -> newPoint.x++
                        }

                        if (newPoint.x < 0 || newPoint.y < 0 || newPoint.x >= boardWidth || newPoint.y >= boardHeight ||
                            mutableGameState.value.snake.contains(newPoint)
                        ) {
                            isPlaying.value = false
                            resetGame()
                            onGameOver.invoke()
                        }
                    }

                    currentSnakeSize = gameState.snake
                    currentSnakeSize.push(newPoint)
                    if (newPoint == gameState.food) {
                        currentFoodPoint = Point(
                            Random().nextInt(boardWidth.toInt()),
                            Random().nextInt(
                                boardHeight.toInt(),
                            ),
                        )
                        currentScore++
                    } else {
                        currentFoodPoint = gameState.food
                        currentSnakeSize.removeLast()
                    }

                    gameState.copy(
                        snake = currentSnakeSize,
                        food = currentFoodPoint,
                        currentDirection = direction,
                        score = currentScore,
                    )
                }
            }
        }
    }
}

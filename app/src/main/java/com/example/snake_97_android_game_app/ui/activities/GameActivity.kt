package com.example.snake_97_android_game_app.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.snake_97_android_game_app.controllers.GameController
import com.example.snake_97_android_game_app.ui.screens.GameBoardScreen
import com.example.snake_97_android_game_app.ui.screens.GameOverScreen

class GameActivity : ComponentActivity() {

    private val isPlaying = mutableStateOf(true)

    private val gameController = GameController(
        scope = lifecycleScope,
        onGameOver = {
            isPlaying.value = false
        },
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                Content()
            }
        }
    }

    @Composable
    fun Content() {
        Column {
            if (isPlaying.value) {
                GameBoardScreen(gameController)
            } else {
                GameOverScreen() {
                    gameController.resetGame()
                    isPlaying.value = true
                }
            }
        }
    }
}

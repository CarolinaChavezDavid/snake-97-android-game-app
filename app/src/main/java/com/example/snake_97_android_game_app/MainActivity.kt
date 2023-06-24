package com.example.snake_97_android_game_app // ktlint-disable package-name

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.snake_97_android_game_app.controllers.GameController
import com.example.snake_97_android_game_app.model.Directions.RIGHT
import com.example.snake_97_android_game_app.navigaton.AppNavigation
import kotlinx.coroutines.CoroutineScope

class MainActivity : AppCompatActivity() {
    private lateinit var scope: CoroutineScope
    private var direction = mutableSetOf(RIGHT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation(
                GameController(
                    scope = lifecycleScope,
                    onGameOver = {},

                ),
            )
        }
        // gameView = GameView(this)
        // setContentView(gameView)
    }
}

/**override fun onResume() {
 super.onResume()
 gameView.resume()
 }

 override fun onPause() {
 super.onPause()
 gameView.pause()
 }
}

@Composable
fun GameNavHost() {
}
**/

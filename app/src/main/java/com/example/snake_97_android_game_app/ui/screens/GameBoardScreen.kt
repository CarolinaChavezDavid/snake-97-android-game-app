package com.example.snake_97_android_game_app.ui.screens // ktlint-disable package-name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.snake_97_android_game_app.R
import com.example.snake_97_android_game_app.controllers.GameController
import com.example.snake_97_android_game_app.ui.theme.GameTypography
import com.example.snake_97_android_game_app.ui.theme.davysGray
import com.example.snake_97_android_game_app.ui.theme.lime
@Composable
fun GameBoardScreen(gameController: GameController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lime)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(0.dp, 16.dp),

            text = stringResource(id = R.string.score),
            color = davysGray,
            style = GameTypography.titleMedium,
        )
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
        ) {
            GameBoard(gameController = gameController)
        }
    }
}

package com.example.snake_97_android_game_app.ui.screens // ktlint-disable package-name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.snake_97_android_game_app.R
import com.example.snake_97_android_game_app.controllers.GameController
import com.example.snake_97_android_game_app.ui.activities.GameActivity
import com.example.snake_97_android_game_app.ui.theme.GameTypography
import com.example.snake_97_android_game_app.ui.theme.davysGray
import com.example.snake_97_android_game_app.ui.theme.lime
@Composable
fun GameBoardScreen(
    gameController: GameController,
) {
    val state = gameController.state.collectAsState(initial = null)
    val activity = LocalContext.current as GameActivity
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(davysGray)
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(0.dp, 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { activity.finish() },
            ) {
                Icon(
                    modifier = Modifier.size(60.dp),
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "",
                    tint = lime,
                )
            }
            Text(
                text = " ${stringResource(id = R.string.score)} ${state.value?.score}",
                color = lime,
                style = GameTypography.titleMedium,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
        ) {
            GameBoard(gameController = gameController)
        }
    }
}

package com.example.snake_97_android_game_app.ui.screens // ktlint-disable package-name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.snake_97_android_game_app.R
import com.example.snake_97_android_game_app.ui.theme.GameTypography
import com.example.snake_97_android_game_app.ui.theme.davysGray
import com.example.snake_97_android_game_app.ui.theme.lime

@Composable
fun Menu() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lime)
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.weight(1f).padding(0.dp, 70.dp),
            text = "Snake 97",
            color = davysGray,
            style = GameTypography.titleLarge,
        )
        Column(modifier = Modifier.weight(2f)) {
            MenuItem(text = stringResource(id = R.string.new_game))
            MenuItem(text = stringResource(id = R.string.high_scores))
            MenuItem(text = stringResource(id = R.string.players))
            MenuItem(text = stringResource(id = R.string.configurations))
            MenuItem(text = stringResource(id = R.string.about))
        }
    }
}

@Composable
fun MenuItem(text: String) {
    Button(
        onClick = {},
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 20.dp,
            end = 20.dp,
            bottom = 12.dp,
        ),
        modifier = Modifier
            .width(350.dp)
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(davysGray),

    ) {
        Text(
            text = text,
            color = lime,
            style = GameTypography.titleMedium,
        )
    }
}

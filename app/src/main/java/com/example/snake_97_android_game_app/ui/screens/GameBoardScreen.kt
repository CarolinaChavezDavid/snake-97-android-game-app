package com.example.snake_97_android_game_app.ui.screens // ktlint-disable package-name

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.snake_97_android_game_app.R
import com.example.snake_97_android_game_app.ui.theme.GameTypography
import com.example.snake_97_android_game_app.ui.theme.davysGray
import com.example.snake_97_android_game_app.ui.theme.lime

@Composable
fun GameBoard() {
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f)
                .border(4.dp, davysGray, RoundedCornerShape(20.dp)),

            contentAlignment = Alignment.Center,
        ) {

        }
    }
}

@Composable
fun Board() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(lime)
            .padding(16.dp)
            .border(4.dp, davysGray),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GameBoard()
}

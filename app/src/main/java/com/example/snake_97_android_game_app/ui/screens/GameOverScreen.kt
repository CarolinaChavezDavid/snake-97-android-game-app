package com.example.snake_97_android_game_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snake_97_android_game_app.R
import com.example.snake_97_android_game_app.ui.activities.GameActivity
import com.example.snake_97_android_game_app.ui.components.MenuItem
import com.example.snake_97_android_game_app.ui.theme.GameTypography
import com.example.snake_97_android_game_app.ui.theme.lime

@Composable
fun GameOverScreen(
    retryGame: () -> Unit,
) {
    val activity = LocalContext.current as GameActivity

    Column(
        modifier = Modifier.fillMaxSize().background(lime).padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,

    ) {
        Text(
            text = stringResource(id = R.string.game_over),
            style = GameTypography.titleLarge,
            fontSize = 30.sp,
        )
        Image(
            modifier = Modifier.size(200.dp).padding(0.dp, 50.dp),
            painter = painterResource(id = R.drawable.ic_sad_emoji),
            contentDescription = "Sad emoji",
        )
        Row(modifier = Modifier.align(CenterHorizontally)) {
            MenuItem(text = "RETRY", action = { retryGame }, width = 150)
            MenuItem(text = "EXIT", action = { activity.finish() }, width = 150)
        }
    }
}

package com.example.snake_97_android_game_app.ui.screens // ktlint-disable package-name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.snake_97_android_game_app.R
import com.example.snake_97_android_game_app.ui.activities.GameActivity
import com.example.snake_97_android_game_app.ui.activities.launchActivity
import com.example.snake_97_android_game_app.ui.components.MenuItem
import com.example.snake_97_android_game_app.ui.theme.GameTypography
import com.example.snake_97_android_game_app.ui.theme.davysGray
import com.example.snake_97_android_game_app.ui.theme.lime

@Composable
fun MenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lime)
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val context = LocalContext.current
        Text(
            modifier = Modifier.weight(1f).padding(0.dp, 70.dp),
            text = "Snake 97",
            color = davysGray,
            style = GameTypography.titleLarge,
        )

        Column(modifier = Modifier.weight(2f)) {
            MenuItem(text = stringResource(id = R.string.new_game), action = { context.launchActivity<GameActivity>() }, 350)
            MenuItem(text = stringResource(id = R.string.high_scores), action = { }, 350)
            MenuItem(text = stringResource(id = R.string.players), action = { }, 350)
            MenuItem(text = stringResource(id = R.string.configurations), action = { }, 350)
            MenuItem(text = stringResource(id = R.string.about), action = { }, 350)
        }
    }
}

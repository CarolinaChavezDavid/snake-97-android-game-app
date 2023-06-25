package com.example.snake_97_android_game_app.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.snake_97_android_game_app.ui.theme.GameTypography
import com.example.snake_97_android_game_app.ui.theme.davysGray
import com.example.snake_97_android_game_app.ui.theme.lime

@Composable
fun MenuItem(text: String, action: (() -> Unit), width: Int) {
    Button(
        onClick = action,
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 20.dp,
            end = 20.dp,
            bottom = 12.dp,
        ),
        modifier = Modifier
            .width(width.dp)
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

package com.example.snake_97_android_game_app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.snake_97_android_game_app.R

val gameFont = FontFamily(
    Font(R.font.press_start_2p),
)

val GameTypography = Typography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = gameFont,
        fontSize = 40.sp,
        lineHeight = 24.sp,
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = gameFont,
        fontSize = 18.sp,
        lineHeight = 24.sp,
    ),

)

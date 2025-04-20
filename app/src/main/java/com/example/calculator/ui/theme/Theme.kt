package com.example.calculator.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CalculatorTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF4CAF50), // Green
            onPrimary = Color.White,
            surface = Color(0xFFF5F5F5), // Light gray
            onSurface = Color.Black
        ),
        typography = Typography(),
        content = content
    )
}

package com.example.calculator

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicCalculatorButtons(onButtonClick: (String) -> Unit) {
    val buttons = listOf(
        listOf("C", "%", "⌫", "÷"),
        listOf("7", "8", "9", "×"),
        listOf("4", "5", "6", "−"),
        listOf("1", "2", "3", "+"),
        listOf("±", "0", ".", "=")
    )

    buttons.forEach { row ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            row.forEach { label ->
                Button(
                    onClick = { onButtonClick(label) },
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (label == "=") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                    )
                ) {
                    Text(
                        text = label,
                        fontSize = 18.sp,
                        color = if (label == "=") MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

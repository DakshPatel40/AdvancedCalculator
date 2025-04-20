package com.example.calculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScientificCalculatorButtons(onButtonClick: (String) -> Unit) {
    val buttons = listOf(
        listOf("C", "sin", "cos", "tan", "⌫", "÷"),
        listOf("π", "7", "8", "9", "ln", "×"),
        listOf("e", "4", "5", "6", "log", "−"),
        listOf("^", "1", "2", "3", "√", "+"),
        listOf("(", ")", "±", "0", ".", "=")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        userScrollEnabled = true
    ) {
        items(buttons.size) { rowIndex ->
            val row = buttons[rowIndex]
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp), // consistent row height
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { label ->
                    Button(
                        onClick = { onButtonClick(label) },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (label == "=") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Text(
                            text = label,
                            fontSize = 9.sp,
                            color = if (label == "=") MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}

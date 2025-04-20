package com.example.calculator

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.objecthunter.exp4j.ExpressionBuilder

@Composable
fun CalculatorApp() {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    var displayText by remember { mutableStateOf("0") }
    var isResultDisplayed by remember { mutableStateOf(false) }

    fun handleInput(input: String) {
        displayText = when (input) {
            "C" -> {
                isResultDisplayed = false
                "0"
            }

            "⌫" -> {
                isResultDisplayed = false
                if (displayText.length > 1) displayText.dropLast(1) else "0"
            }

            "±" -> {
                if (displayText == "0") displayText
                else if (displayText.startsWith("-")) displayText.drop(1)
                else "-$displayText"
            }

            "=" -> {
                try {
                    val expression = displayText
                        .replace("×", "*")
                        .replace("÷", "/")
                        .replace("%", "/100")

                    val result = ExpressionBuilder(expression).build().evaluate()
                    isResultDisplayed = true

                    if (result == result.toLong().toDouble()) result.toLong().toString()
                    else String.format("%.4f", result)
                } catch (e: Exception) {
                    "Error"
                }
            }

            else -> {
                if (isResultDisplayed) {
                    isResultDisplayed = false
                    if (input in listOf("+", "-", "×", "÷")) displayText + input else input
                } else {
                    if (displayText == "0" && input != ".") input else displayText + input
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        DisplayArea(displayText, isPortrait)
        Spacer(modifier = Modifier.height(16.dp))
        if (isPortrait) {
            BasicCalculatorButtons(onButtonClick = ::handleInput)
        } else {
            ScientificCalculatorButtons(onButtonClick = ::handleInput)
        }
    }
}

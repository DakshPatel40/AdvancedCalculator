package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayArea(text: String, isPortrait: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (isPortrait) 120.dp else 100.dp)
            .background(Color.White, MaterialTheme.shapes.medium)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = text,
            fontSize = if (text.length < 10) 40.sp else 24.sp,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            textAlign = TextAlign.End
        )
    }
}

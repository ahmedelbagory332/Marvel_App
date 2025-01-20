package com.example.presentation.characters_screen.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SlantedTextBox(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.Transparent)
            .height(50.dp)
            .width(150.dp)
    ) {
        // Draw the slanted background
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                moveTo(20f, 0f) // Start from top-left with an offset
                lineTo(size.width, 0f) // Top-right corner
                lineTo(size.width - 20f, size.height) // Bottom-right corner with an offset
                lineTo(0f, size.height) // Bottom-left corner
                close() // Close the path
            }
            drawPath(path, color = Color.White) // Draw the path with a white color
        }

        // Add text on top of the slanted background
        Text(
            text = text,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
        )
    }
}
package com.example.presentation.characters_screen.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.presentation.common.CoilImage

@Composable
fun CharacterCard(image: String, name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        CoilImage(
            data = image,
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        SlantedTextBox(
            text = name,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 32.dp, vertical = 32.dp)
        )
    }
}

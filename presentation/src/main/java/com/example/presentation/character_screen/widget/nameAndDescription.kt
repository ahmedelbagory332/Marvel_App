package com.example.presentation.character_screen.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.presentation.character_screen.CharacterState

 fun LazyListScope.nameAndDescription(uiState: CharacterState) {
    item {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)

        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Name", color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = uiState.character.name ?: "", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            if (!uiState.character.description.isNullOrEmpty()) {
                Text(text = "Description", color = Color.Red)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = uiState.character.description ?: "", color = Color.White)
            }
        }
    }
}
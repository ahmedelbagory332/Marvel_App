package com.example.presentation.character_screen.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.presentation.character_screen.CharacterState

 fun LazyListScope.relatedLinks(uiState: CharacterState,onClick: (url: String) -> Unit) {
    item {
        Text(
            text = "Related Links", color = Color.Red,
            modifier = Modifier
                .padding(horizontal = 8.dp),
        )
    }
    item {
        Spacer(modifier = Modifier.height(16.dp))
    }
    items(uiState.character.urls) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable {
                    onClick(it.url ?: "")
                }
        ) {
            Text(
                text = it.type?.uppercase() ?: "",
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Leading Icon",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

    }
}

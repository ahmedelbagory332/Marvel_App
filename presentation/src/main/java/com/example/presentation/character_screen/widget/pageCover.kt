package com.example.presentation.character_screen.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.presentation.character_screen.CharacterState
import com.example.presentation.common.CoilImage

 fun LazyListScope.pageCover(
    uiState: CharacterState,
    mainNavController: NavHostController
) {
    item {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            CoilImage(
                data = uiState.character.cover ?: "",
                contentDescription = "cover",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize()
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "",
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(start = 8.dp)
                    .size(32.dp)
                    .clickable {
                        mainNavController.popBackStack()
                    },
            )
        }
    }
}

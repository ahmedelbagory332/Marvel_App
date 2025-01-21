package com.example.presentation.character_screen.widget

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.presentation.character_screen.CharacterState
import com.example.presentation.common.LoadingIndicator

@Composable
fun ContentScreen(
    uiState: CharacterState,
    mainNavController: NavHostController
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        pageCover(uiState, mainNavController)
        nameAndDescription(uiState)
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            if (uiState.character.comics.isEmpty())
                return@item
            Text(
                text = "Comics", color = Color.Red,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            )
            if (uiState.isComicsLoading) {
                LoadingIndicator(colorText = Color.Red)
            }
            CategoryList(uiState.comics)
        }

        item {
            if (uiState.character.series.isEmpty())
                return@item
            Text(
                text = "Series", color = Color.Red,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            )
            if (uiState.isSeriesLoading) {
                LoadingIndicator(colorText = Color.Red)
            }
            CategoryList(uiState.series)
        }

        item {
            if (uiState.character.stories.isEmpty())
                return@item
            Text(
                text = "Stories", color = Color.Red,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            )
            if (uiState.isStoriesLoading) {
                LoadingIndicator(colorText = Color.Red)
            }
            CategoryList(uiState.stories)
        }

        item {
            if (uiState.character.events.isEmpty())
                return@item
            Text(
                text = "Events", color = Color.Red,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            )
            if (uiState.isEventsLoading) {
                LoadingIndicator(colorText = Color.Red)
            }
            CategoryList(uiState.events)
        }

        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}


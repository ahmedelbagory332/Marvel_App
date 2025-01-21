package com.example.presentation.character_screen.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.domain.navigation.NavItem
import com.example.domain.utils.encodeForRoute
import com.example.presentation.character_screen.CharacterState
import com.example.presentation.common.LoadingIndicator
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


 fun LazyListScope.categories(
    uiState: CharacterState,
    mainNavController: NavHostController
) {
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
        CategoryList(uiState.comics) {
            val encodedCategories = Json.encodeToString(uiState.comics).encodeForRoute()
            mainNavController.navigate(NavItem.CategoryScreen.route + "/${encodedCategories}")
        }
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
        CategoryList(uiState.series) {
            val encodedCategories = Json.encodeToString(uiState.series).encodeForRoute()
            mainNavController.navigate(NavItem.CategoryScreen.route + "/${encodedCategories}")
        }
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
        CategoryList(uiState.stories) {
            val encodedCategories = Json.encodeToString(uiState.stories).encodeForRoute()
            mainNavController.navigate(NavItem.CategoryScreen.route + "/${encodedCategories}")
        }
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
        CategoryList(uiState.events) {
            val encodedCategories = Json.encodeToString(uiState.events).encodeForRoute()
            mainNavController.navigate(NavItem.CategoryScreen.route + "/${encodedCategories}")
        }
    }
}
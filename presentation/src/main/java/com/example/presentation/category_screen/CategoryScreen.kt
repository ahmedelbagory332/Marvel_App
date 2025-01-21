package com.example.presentation.category_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.domain.models.ItemModel
import com.example.domain.utils.decodeFromRoute
import com.example.presentation.category_screen.widget.CategoryImages
import com.example.presentation.category_screen.widget.CloseIcon
import kotlinx.serialization.json.Json

@Composable
fun CategoryScreen(
    mainNavController: NavHostController,
    categoryJson: String
) {
    val decodedCategoryJson = categoryJson.decodeFromRoute()
    val categories = Json.decodeFromString<List<ItemModel>>(decodedCategoryJson)
    // Remember LazyListState to track the scroll position
    val listState = rememberLazyGridState()

    // Track the current item index based on the scroll position
    val currentItemIndex = remember { mutableIntStateOf(0) }

    // Use snapshotFlow to observe changes to the firstVisibleItemIndex
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .collect { index ->
                currentItemIndex.intValue = index
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black.copy(alpha = 0.8f))
    ) {

        Spacer(modifier = Modifier.height(32.dp))
        CloseIcon(mainNavController)
        CategoryImages(listState, categories)
        Text(
            text = " ${categories.getOrNull(currentItemIndex.intValue)?.name ?: "No Name"}",
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "${currentItemIndex.intValue + 1} / ${categories.size}",
            color = Color.Gray.copy(alpha = 0.9f),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}
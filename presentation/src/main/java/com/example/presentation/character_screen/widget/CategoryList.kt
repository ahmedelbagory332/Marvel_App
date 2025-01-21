package com.example.presentation.character_screen.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.models.ItemModel

@Composable
 fun CategoryList(list: List<ItemModel>, onClick: () -> Unit) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier
            .height(250.dp)
            .padding(horizontal = 8.dp)
            .clickable {
                onClick()
            }
        ,
        horizontalArrangement = Arrangement.spacedBy(8.dp),

        ) {
        items(list) { item ->
            CategoryItem(item)
        }
    }
}
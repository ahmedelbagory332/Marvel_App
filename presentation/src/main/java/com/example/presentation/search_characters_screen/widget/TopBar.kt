package com.example.presentation.search_characters_screen.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.presentation.common.ChangeStatusColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    value: String,
    onValueChange: (String) -> Unit,
    onSearchClick: (String) -> Unit,
     onCancelClick: () -> Unit
) {
    ChangeStatusColor()
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(20.dp),
        title = {
            SearchBar(
                value = value,
                onValueChange = onValueChange,
                onSearchClick = onSearchClick,
                onCancelClick = onCancelClick
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        )
    )
}

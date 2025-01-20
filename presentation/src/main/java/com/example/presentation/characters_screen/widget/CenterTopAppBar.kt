package com.example.presentation.characters_screen.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.common.ChangeStatusColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopAppBar(
    onSearchClick: () -> Unit
) {
    ChangeStatusColor()
    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(20.dp),
        title = {
            Image(
                painter = painterResource(id = R.drawable.marvel_logo),
                contentDescription = ""
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Red,
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        onSearchClick()
                    }
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        )
    )
}

package com.example.presentation.character_screen.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.models.ItemModel
import com.example.presentation.common.CoilImage

@Composable
fun CategoryItem(item: ItemModel) {
    Column {
        CoilImage(
            data = item.resourceURI ?: "",
            contentDescription = item.name ?: "",
            modifier = Modifier,
            contentScale = ContentScale.FillBounds,
        )
        Text(
            text = item.name ?: "",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color(0xFF000000),
            modifier = Modifier.width(100.dp),
            maxLines = 4,
            lineHeight = 16.sp

        )
    }
}
package com.example.presentation.character_screen.widget

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.presentation.character_screen.CharacterState

@Composable
fun ContentScreen(
    uiState: CharacterState,
    mainNavController: NavHostController
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        pageCover(uiState, mainNavController)
        nameAndDescription(uiState)
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        categories(uiState, mainNavController)

        relatedLinks(uiState) {
            openLink(it, context)
        }

        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}


private fun openLink(it: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}



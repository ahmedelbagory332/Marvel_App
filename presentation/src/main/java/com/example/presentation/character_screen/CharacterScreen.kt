package com.example.presentation.character_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.R
import com.example.presentation.character_screen.widget.ContentScreen
import com.example.presentation.common.LoadingIndicator
import com.example.presentation.common.PlaceHolder

@Composable
fun CharacterScreen(
    mainNavController: NavHostController,
    characterViewModel: CharacterViewModel = hiltViewModel()
) {
    val uiState by characterViewModel.characterState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black.copy(alpha = 0.8f))
    ) {

        when {
            uiState.isLoading -> {
                LoadingIndicator(colorText = Color.White)
            }

            uiState.error.isNotEmpty() -> {
                PlaceHolder(
                    text = uiState.error,
                    painter = painterResource(id = R.drawable.error)
                )

            }

            uiState.character.name?.isNotEmpty() == true -> {
                ContentScreen(uiState, mainNavController)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }

}




package com.example.presentation.search_characters_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.R
import com.example.presentation.common.LoadingIndicator
import com.example.presentation.common.PlaceHolder
import com.example.presentation.search_characters_screen.widget.SearchCharacterCard
import com.example.presentation.search_characters_screen.widget.TopBar

@Composable
fun SearchCharactersScreen(
    mainNavController: NavHostController,
    searchCharactersViewModel: SearchCharactersViewModel = hiltViewModel()
) {
    val uiState by searchCharactersViewModel.charactersState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                value = uiState.searchValue,
                onValueChange = searchCharactersViewModel::updateName,
                onSearchClick = searchCharactersViewModel::onSearchClick,
                onCancelClick = {
                    mainNavController.popBackStack()
                }
            )
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.8f))
                .padding(innerPadding)
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

                uiState.characters.isNotEmpty() -> {
                    LazyColumn {
                        items(uiState.characters) {
                            SearchCharacterCard(image = it.image ?: "", name = it.name ?: "")
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                }

                uiState.noResult == true -> {
                    PlaceHolder(
                        text = "",
                        painter = painterResource(id = R.drawable.no_result)
                    )
                }
            }
        }
    }
}


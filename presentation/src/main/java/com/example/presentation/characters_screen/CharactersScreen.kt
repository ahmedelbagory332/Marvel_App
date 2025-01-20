package com.example.presentation.characters_screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.domain.navigation.NavItem
import com.example.presentation.R
import com.example.presentation.characters_screen.widget.CenterTopAppBar
import com.example.presentation.characters_screen.widget.CharacterCard
import com.example.presentation.common.LoadingIndicator
import com.example.presentation.common.PlaceHolder

@Composable
fun CharactersScreen(
    mainNavController: NavHostController,
    charactersViewModel: CharactersViewModel = hiltViewModel()
) {

    val uiState by charactersViewModel.charactersState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterTopAppBar {
                mainNavController.navigate(NavItem.SearchCharactersScreen.route)
            }
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            when {
                uiState.isLoading -> {
                    LoadingIndicator()
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
                            CharacterCard(image = it.image ?: "", name = it.name ?: "")
                        }
                    }
                }
            }
        }
    }
}


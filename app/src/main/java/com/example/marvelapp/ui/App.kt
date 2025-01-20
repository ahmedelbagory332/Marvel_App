package com.example.marvelapp.ui


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.domain.navigation.NavItem
import com.example.presentation.characters_screen.CharactersScreen
import com.example.presentation.search_characters_screen.SearchCharactersScreen

@Composable
fun App(mainNavController: NavHostController) {
    NavHost(
        navController = mainNavController,
        startDestination = NavItem.CharactersScreen.route
    ) {

        composable(route = NavItem.CharactersScreen.route) {
            CharactersScreen(mainNavController)
        }
        composable(route = NavItem.SearchCharactersScreen.route) {
            SearchCharactersScreen(mainNavController)
        }
    }

}
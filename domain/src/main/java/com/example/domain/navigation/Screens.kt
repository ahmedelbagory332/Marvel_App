package com.example.domain.navigation

enum class Screen {
    CharactersScreen,
    SearchCharactersScreen,
}

sealed class NavItem(val route: String) {
    data object CharactersScreen : NavItem(Screen.CharactersScreen.name)
    data object SearchCharactersScreen : NavItem(Screen.SearchCharactersScreen.name)
 }
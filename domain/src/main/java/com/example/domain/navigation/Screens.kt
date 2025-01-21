package com.example.domain.navigation

enum class Screen {
    CharactersScreen,
    SearchCharactersScreen,
    CharacterScreen,
    CategoryScreen,
}

sealed class NavItem(val route: String) {
    data object CharactersScreen : NavItem(Screen.CharactersScreen.name)
    data object SearchCharactersScreen : NavItem(Screen.SearchCharactersScreen.name)
    data object CharacterScreen : NavItem(Screen.CharacterScreen.name)
    data object CategoryScreen : NavItem(Screen.CategoryScreen.name)
 }
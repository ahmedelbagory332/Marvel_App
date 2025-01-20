package com.example.presentation.characters_screen

import com.example.domain.models.CharactersModel

data class CharactersState(
    val isLoading: Boolean = false,
    val characters: List<CharactersModel> = emptyList(),
    val error: String = ""
)
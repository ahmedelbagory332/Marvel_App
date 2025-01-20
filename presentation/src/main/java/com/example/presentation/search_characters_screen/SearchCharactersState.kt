package com.example.presentation.search_characters_screen

import com.example.domain.models.CharactersModel

data class SearchCharactersState(
    val isLoading: Boolean = false,
    val characters: List<CharactersModel> = emptyList(),
    val error: String = "",
    val searchValue: String = "",
    val noResult: Boolean? = null,
)
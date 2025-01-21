package com.example.presentation.character_screen

import com.example.domain.models.CharacterModel
import com.example.domain.models.ItemModel

data class CharacterState(
    val isLoading: Boolean = false,
    val character: CharacterModel = CharacterModel(),
    val error: String = "",
    var comics: List<ItemModel> = emptyList(),
    val isComicsLoading: Boolean = false,
    var series: List<ItemModel> = emptyList(),
    val isSeriesLoading: Boolean = false,
    var stories: List<ItemModel> = emptyList(),
    val isStoriesLoading: Boolean = false,
    var events: List<ItemModel> = emptyList(),
    val isEventsLoading: Boolean = false
    )
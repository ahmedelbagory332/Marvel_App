package com.example.data.mapper

import com.example.data.api_service.entity.Results
import com.example.data.utils.landscapeIncredible
import com.example.domain.models.CharactersModel

fun Results.toCharactersModel(): CharactersModel =
    CharactersModel(
        name = name ?: "",
        image = thumbnail?.path.landscapeIncredible() ?: "",
    )
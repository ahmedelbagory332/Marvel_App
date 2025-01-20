package com.example.domain.repo

import com.example.domain.models.CharactersModel

interface CharactersRepo {
    suspend fun getCharacters(name: String?): List<CharactersModel>
}
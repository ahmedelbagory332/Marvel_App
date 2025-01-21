package com.example.domain.repo

import com.example.domain.models.CharacterModel
import com.example.domain.models.CharactersModel

interface CharactersRepo {
    suspend fun getCharacters(name: String?): List<CharactersModel>
    suspend fun getCharacter(characterId: Int): CharacterModel
    suspend fun getImageFromCategory(resourceURI: String): List<String>
}
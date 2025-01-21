package com.example.data.repo

import com.example.data.api_service.MarvelApi
import com.example.data.mapper.toCharacterModel
import com.example.data.mapper.toCharactersModel
import com.example.data.mapper.toImageFromCategory
import com.example.domain.models.CharacterModel
import com.example.domain.models.CharactersModel
import com.example.domain.repo.CharactersRepo

class CharactersRepoImpl(
    private val api: MarvelApi
) : CharactersRepo {
    override suspend fun getCharacters(name: String?): List<CharactersModel> =
        api.getCharacters(name = name).data?.results?.map { it.toCharactersModel() }
            ?: emptyList()

    override suspend fun getCharacter(characterId: Int): CharacterModel =
        api.getCharacter(characterId = characterId).data?.results?.map { it.toCharacterModel() }
            ?.first() ?: CharacterModel()

    override suspend fun getImageFromCategory(resourceURI: String): List<String> =
        api.getResourceURI(fullUrl = resourceURI).data?.results?.map { it.toImageFromCategory() } ?: emptyList()

}
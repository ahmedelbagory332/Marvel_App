package com.example.data.repo

import com.example.data.api_service.MarvelApi
import com.example.data.mapper.toCharactersModel
import com.example.domain.models.CharactersModel
import com.example.domain.repo.CharactersRepo

class CharactersRepoImpl(
    private val api: MarvelApi
) : CharactersRepo {
    override suspend fun getCharacters(name: String?): List<CharactersModel> =
       api.getCharacters(name = name).data?.results?.map { it.toCharactersModel() }
           ?: emptyList()
}
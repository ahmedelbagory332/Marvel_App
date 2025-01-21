package com.example.domain.use_case

import com.example.domain.models.CharacterModel
import com.example.domain.repo.CharactersRepo
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetCharacterUseCase @Inject constructor(
    private val repository: CharactersRepo,
) {
    operator fun invoke(characterId: Int): Flow<Resource<CharacterModel>> = flow {
        try {
            emit(Resource.Loading<CharacterModel>())
            val character = repository.getCharacter(characterId)
            emit(Resource.Success<CharacterModel>(character))
        } catch (e: Exception) {
            emit(Resource.Error<CharacterModel>("${e.localizedMessage} : An unexpected error happened"))
        }
    }
}
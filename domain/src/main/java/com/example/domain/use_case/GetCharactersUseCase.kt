package com.example.domain.use_case

import com.example.domain.models.CharactersModel
import com.example.domain.repo.CharactersRepo
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(
    private val repository: CharactersRepo,
) {
    operator fun invoke(name: String?): Flow<Resource<List<CharactersModel>>> = flow {
        try {
            emit(Resource.Loading<List<CharactersModel>>())
            val characters = repository.getCharacters(name)
            emit(Resource.Success<List<CharactersModel>>(characters))
        } catch (e: Exception) {
            emit(Resource.Error<List<CharactersModel>>("${e.localizedMessage} : An unexpected error happened"))
        }
    }
}
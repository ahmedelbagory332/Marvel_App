package com.example.presentation.characters_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_case.GetCharactersUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CharactersViewModel @Inject constructor(
    val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val charactersState: StateFlow<CharactersState>
        get() = _state

    init {
        getCharacters()
    }


    private fun getCharacters() {
        getCharactersUseCase(name = null).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CharactersState(
                        characters = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _state.value = CharactersState(
                        error = result.message ?: "An unexpected error happened"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CharactersState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}
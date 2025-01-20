package com.example.presentation.search_characters_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_case.GetCharactersUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class SearchCharactersViewModel @Inject constructor(
    val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SearchCharactersState())
    val charactersState: StateFlow<SearchCharactersState>
        get() = _state

    fun updateName(name: String) {
        _state.update { state ->
            state.copy(
                searchValue = name
            )
        }
    }

    fun onSearchClick(name: String) {
        if (name.isNotEmpty()) {
            getCharacters(name)
        }
    }

    private fun getCharacters(name: String) {
        getCharactersUseCase(name = name).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.update { state ->
                        state.copy(
                            isLoading = false,
                            characters = result.data ?: emptyList(),
                            noResult = result.data?.isEmpty() ?: true
                        )
                    }
                }

                is Resource.Error -> {
                    _state.update { state ->
                        state.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error happened"
                        )
                    }
                }

                is Resource.Loading -> {
                    _state.update { state ->
                        state.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)

    }

}
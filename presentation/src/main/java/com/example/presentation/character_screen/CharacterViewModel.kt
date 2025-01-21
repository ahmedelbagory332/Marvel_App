package com.example.presentation.character_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.CharacterModel
import com.example.domain.models.ItemModel
import com.example.domain.use_case.GetCharacterUseCase
import com.example.domain.use_case.GetImageFromCategoryUseCase
import com.example.domain.utils.Resource
import com.example.domain.utils.handleResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(
    val getCharacterUseCase: GetCharacterUseCase,
    val getImageFromCategoryUseCase: GetImageFromCategoryUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel() {
    private val characterId: Int = savedStateHandle["characterId"] ?: 0

    private val _state = MutableStateFlow(CharacterState())
    val characterState: StateFlow<CharacterState>
        get() = _state

    init {
        getCharacters()
    }

    private fun fetchComics(comics: List<ItemModel>) {
        getImageFromCategoryUseCase(comics).onEach { result ->
            handleResourceState(
                result,
                onSuccess = { data ->
                    _state.update { state ->
                        state.copy(comics = data ?: emptyList())
                    }
                },
                onError = { message ->
                    _state.update { state ->
                        state.copy(error = message)
                    }
                },
                loadingState = { isLoading ->
                    _state.update { state ->
                        state.copy(isComicsLoading = isLoading)
                    }
                }
            )
        }.launchIn(viewModelScope)
    }

    private fun fetchSeries(series: List<ItemModel>) {
        getImageFromCategoryUseCase(series).onEach { result ->
            handleResourceState(
                result,
                onSuccess = { data ->
                    _state.update { state ->
                        state.copy(series = data ?: emptyList())
                    }
                },
                onError = { message ->
                    _state.update { state ->
                        state.copy(error = message)
                    }
                },
                loadingState = { isLoading ->
                    _state.update { state ->
                        state.copy(isSeriesLoading = isLoading)
                    }
                }
            )
        }.launchIn(viewModelScope)
    }

    private fun fetchStories(stories: List<ItemModel>) {
        getImageFromCategoryUseCase(stories).onEach { result ->
            handleResourceState(
                result,
                onSuccess = { data ->
                    _state.update { state ->
                        state.copy(stories = data ?: emptyList())
                    }
                },
                onError = { message ->
                    _state.update { state ->
                        state.copy(error = message)
                    }
                },
                loadingState = { isLoading ->
                    _state.update { state ->
                        state.copy(isStoriesLoading = isLoading)
                    }
                }
            )
        }.launchIn(viewModelScope)
    }

    private fun fetchEvents(events: List<ItemModel>) {
        getImageFromCategoryUseCase(events).onEach { result ->
            handleResourceState(
                result,
                onSuccess = { data ->
                    _state.update { state ->
                        state.copy(events = data ?: emptyList())
                    }
                },
                onError = { message ->
                    _state.update { state ->
                        state.copy(error = message)
                    }
                },
                loadingState = { isLoading ->
                    _state.update { state ->
                        state.copy(isEventsLoading = isLoading)
                    }
                }
            )
        }.launchIn(viewModelScope)
    }


    private fun getCharacters() {
        getCharacterUseCase(characterId = characterId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.update { state ->
                        state.copy(
                            isLoading = false,
                            character = result.data ?: CharacterModel()
                        )
                    }
                    getCategories(result)
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

    private fun getCategories(result: Resource<CharacterModel>) {
        viewModelScope.launch {
            val comicsDeferred = if (result.data?.comics?.isNotEmpty() == true) {
                async { fetchComics(result.data?.comics ?: emptyList()) }
            } else {
                null
            }
            val seriesDeferred = if (result.data?.series?.isNotEmpty() == true) {
                async { fetchSeries(result.data?.series ?: emptyList()) }
            } else {
                null
            }

            val storiesDeferred = if (result.data?.stories?.isNotEmpty() == true) {
                async { fetchStories(result.data?.stories ?: emptyList()) }
            } else {
                null
            }

            val eventsDeferred = if (result.data?.events?.isNotEmpty() == true) {
                async { fetchEvents(result.data?.events ?: emptyList()) }
            } else {
                null
            }

            // Wait for both tasks to complete concurrently
            comicsDeferred?.await()
            seriesDeferred?.await()
            storiesDeferred?.await()
            eventsDeferred?.await()
        }
    }

}
package com.example.domain.utils

 fun <T> handleResourceState(
    resource: Resource<T>,
    onSuccess: (T?) -> Unit,
    onError: (String) -> Unit,
    loadingState: (Boolean) -> Unit
) {
    when (resource) {
        is Resource.Success -> {
            loadingState(false)
            onSuccess(resource.data)
        }
        is Resource.Error -> {

            loadingState(false)
            onError(resource.message ?: "An unexpected error happened")
        }
        is Resource.Loading -> {
            loadingState(true)
        }
    }
}

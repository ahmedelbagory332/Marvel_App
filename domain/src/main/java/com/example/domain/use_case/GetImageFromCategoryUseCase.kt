package com.example.domain.use_case


//class GetImageFromCategoryUseCase @Inject constructor(
//    private val repository: CharactersRepo,
//) {
//    operator fun invoke(categories: List<ItemModel>): Flow<Resource<List<ItemModel>>> = flow {
//        try {
//            emit(Resource.Loading<List<ItemModel>>())
//            val imageUrls = categories.flatMap { category ->
//                try {
//                    val images = repository.getImageFromCategory(category.resourceURI ?: "")
//                    images.map { imageUrl ->
//                        ItemModel(
//                            resourceURI = imageUrl, // Populate image URL
//                            name = category.name // Populate the name (or use any other data)
//                        )
//                    }
//                } catch (e: Exception) {
//                    emptyList()
//                }
//            }
//            emit(Resource.Success<List<ItemModel>>(imageUrls))
//        } catch (e: Exception) {
//            emit(Resource.Error<List<ItemModel>>("${e.localizedMessage} : An unexpected error happened"))
//        }
//    }
//}

import com.example.domain.models.ItemModel
import com.example.domain.repo.CharactersRepo
import com.example.domain.utils.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetImageFromCategoryUseCase @Inject constructor(
    private val repository: CharactersRepo,
) {
    operator fun invoke(categories: List<ItemModel>): Flow<Resource<List<ItemModel>>> = flow {
        emit(Resource.Loading<List<ItemModel>>())

        try {
            val imageUrls = coroutineScope {
                categories.map { category ->
                    async {
                        try {
                            val images = repository.getImageFromCategory(category.resourceURI ?: "")
                            images.map { imageUrl ->
                                ItemModel(
                                    resourceURI = imageUrl,
                                    name = category.name
                                )
                            }
                        } catch (e: Exception) {
                            emptyList<ItemModel>()
                        }
                    }
                }.awaitAll().flatten()
            }
            emit(Resource.Success<List<ItemModel>>(imageUrls))
        } catch (e: Exception) {
            emit(Resource.Error<List<ItemModel>>("${e.localizedMessage} : An unexpected error happened"))
        }
    }
}


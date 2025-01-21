package com.example.domain.models

data class CharacterModel(
    var name: String? = null,
    var cover: String? = null,
    var description: String? = null,
    var comics: List<ItemModel> = emptyList(),
    var series: List<ItemModel> = emptyList(),
    var stories: List<ItemModel> = emptyList(),
    var events: List<ItemModel> = emptyList(),
    var urls: List<UrlsModel> = emptyList()
)

data class UrlsModel(
    var type: String? = null,
    var url: String? = null
)

data class ItemModel(
    var resourceURI: String? = null,
    var name: String? = null
)
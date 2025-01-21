package com.example.data.mapper

import com.example.data.api_service.entity.Items
import com.example.data.api_service.entity.Results
import com.example.data.api_service.entity.Urls
import com.example.data.utils.landscapeIncredible
import com.example.data.utils.portraitXlarge
import com.example.domain.models.CharacterModel
import com.example.domain.models.CharactersModel
import com.example.domain.models.ItemModel
import com.example.domain.models.UrlsModel

fun Results.toCharactersModel(): CharactersModel =
    CharactersModel(
        id = id ?: 0,
        name = name ?: "",
        image = thumbnail?.path.landscapeIncredible() ?: "",
    )

fun Items.toItemModel(): ItemModel =
    ItemModel(
        name = name ?: "",
        resourceURI = resourceURI ?: "",
    )

fun Urls.toUrlsModel(): UrlsModel =
    UrlsModel(
        type = type ?: "",
        url = url ?: "",
    )


fun Results.toCharacterModel(): CharacterModel =
    CharacterModel(
        name = name ?: "",
        cover = thumbnail?.path.landscapeIncredible() ?: "",
        description = description ?: "",
        comics = comics?.items?.map { it.toItemModel() } ?: emptyList(),
        series = series?.items?.map { it.toItemModel() } ?: emptyList(),
        stories = stories?.items?.map { it.toItemModel() } ?: emptyList(),
        events = events?.items?.map { it.toItemModel() } ?: emptyList(),
        urls = urls.map { it.toUrlsModel() },
    )

fun Results.toImageFromCategory(): String =
    thumbnail?.path.portraitXlarge() ?: ""
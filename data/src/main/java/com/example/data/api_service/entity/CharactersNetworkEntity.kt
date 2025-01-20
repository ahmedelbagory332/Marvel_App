package com.example.data.api_service.entity

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class CharactersNetworkEntity(

    @SerialName("code") var code: Int? = null,
    @SerialName("status") var status: String? = null,
    @SerialName("copyright") var copyright: String? = null,
    @SerialName("attributionText") var attributionText: String? = null,
    @SerialName("attributionHTML") var attributionHTML: String? = null,
    @SerialName("etag") var etag: String? = null,
    @SerialName("data") var data: CharactersDataNetworkEntity? = CharactersDataNetworkEntity()

)

@Serializable
data class CharactersDataNetworkEntity(

    @SerialName("offset") var offset: Int? = null,
    @SerialName("limit") var limit: Int? = null,
    @SerialName("total") var total: Int? = null,
    @SerialName("count") var count: Int? = null,
    @SerialName("results") var results: ArrayList<Results> = arrayListOf()

)

@Serializable
data class Thumbnail(

    @SerialName("path") var path: String? = null,
    @SerialName("extension") var extension: String? = null

)

@Serializable
data class Items(

    @SerialName("resourceURI") var resourceURI: String? = null,
    @SerialName("name") var name: String? = null

)


@Serializable
data class Comics(

    @SerialName("available") var available: Int? = null,
    @SerialName("collectionURI") var collectionURI: String? = null,
    @SerialName("items") var items: ArrayList<Items> = arrayListOf(),
    @SerialName("returned") var returned: Int? = null

)

@Serializable
data class Series(

    @SerialName("available") var available: Int? = null,
    @SerialName("collectionURI") var collectionURI: String? = null,
    @SerialName("items") var items: ArrayList<Items> = arrayListOf(),
    @SerialName("returned") var returned: Int? = null

)

@Serializable
data class Stories(

    @SerialName("available") var available: Int? = null,
    @SerialName("collectionURI") var collectionURI: String? = null,
    @SerialName("items") var items: ArrayList<Items> = arrayListOf(),
    @SerialName("returned") var returned: Int? = null

)

@Serializable
data class Events(

    @SerialName("available") var available: Int? = null,
    @SerialName("collectionURI") var collectionURI: String? = null,
    @SerialName("items") var items: ArrayList<Items> = arrayListOf(),
    @SerialName("returned") var returned: Int? = null

)


@Serializable
data class Urls(

    @SerialName("type") var type: String? = null,
    @SerialName("url") var url: String? = null

)


@Serializable
data class Results(

    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("modified") var modified: String? = null,
    @SerialName("thumbnail") var thumbnail: Thumbnail? = Thumbnail(),
    @SerialName("resourceURI") var resourceURI: String? = null,
    @SerialName("comics") var comics: Comics? = Comics(),
    @SerialName("series") var series: Series? = Series(),
    @SerialName("stories") var stories: Stories? = Stories(),
    @SerialName("events") var events: Events? = Events(),
    @SerialName("urls") var urls: ArrayList<Urls> = arrayListOf()

)
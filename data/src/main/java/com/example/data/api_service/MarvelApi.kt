package com.example.data.api_service

import com.example.data.BuildConfig
import com.example.data.api_service.entity.CharactersNetworkEntity
import com.example.data.utils.GenerateKeys
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface MarvelApi {

    @GET("public/characters")
    suspend fun getCharacters(
        @Query("apikey") key: String = BuildConfig.MARVEL_PUBLIC_KEY,
        @Query("hash") hash: String = GenerateKeys.md5Hash,
        @Query("ts") ts: String = "${GenerateKeys.ts}",
        @Query("nameStartsWith") name: String? = null, // Make name nullable
    ): CharactersNetworkEntity {
        return if (name.isNullOrEmpty()) {
            // Perform the request without the "name" parameter
            getCharactersWithoutName(key, hash, ts)
        } else {
            // Perform the request with the "name" parameter
            getCharactersWithName(key, hash, ts, name)
        }
    }

    @GET("public/characters")
    suspend fun getCharactersWithoutName(
        @Query("apikey") key: String,
        @Query("hash") hash: String,
        @Query("ts") ts: String
    ): CharactersNetworkEntity

    @GET("public/characters")
    suspend fun getCharactersWithName(
        @Query("apikey") key: String,
        @Query("hash") hash: String,
        @Query("ts") ts: String,
        @Query("nameStartsWith") name: String
    ): CharactersNetworkEntity

    @GET("public/characters/{characterId}")
    suspend fun getCharacter(
        @Path("characterId") characterId: Int,
        @Query("apikey") key: String = BuildConfig.MARVEL_PUBLIC_KEY,
        @Query("hash") hash: String = GenerateKeys.md5Hash,
        @Query("ts") ts: String = "${GenerateKeys.ts}"
    ): CharactersNetworkEntity

    @GET
    suspend fun getResourceURI(
        @Url fullUrl: String,
        @Query("apikey") key: String = BuildConfig.MARVEL_PUBLIC_KEY,
        @Query("hash") hash: String = GenerateKeys.md5Hash,
        @Query("ts") ts: String = "${GenerateKeys.ts}"
    ): CharactersNetworkEntity
}
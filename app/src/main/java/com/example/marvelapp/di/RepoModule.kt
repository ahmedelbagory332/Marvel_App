package com.example.marvelapp.di

import com.example.data.api_service.MarvelApi
import com.example.data.repo.CharactersRepoImpl
import com.example.domain.repo.CharactersRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun charactersRepository(
        api: MarvelApi,
    ): CharactersRepo =
        CharactersRepoImpl(api)
}
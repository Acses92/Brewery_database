package com.anatolykravchenko.brewerydatabase.di

import com.anatolykravchenko.brewerydatabase.data.repository.BreweryRepositoryImpl
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 abstract class RepositoryModule {
    @Binds
    abstract fun bindGetBreweryList(
        breweryRepositoryImpl: BreweryRepositoryImpl
    ): BreweryRepository

}
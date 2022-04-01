package com.anatolykravchenko.brewerydatabase.domain

import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


interface BreweryRepository {
    suspend fun getBreweryList(): List<BreweryDto>

    suspend fun getBrewery(): Brewery

}
package com.anatolykravchenko.brewerydatabase.domain

import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto

interface BreweryRepository {
    suspend fun getBreweryList(): List<BreweryDto>

    suspend fun getBrewery(): Brewery

}
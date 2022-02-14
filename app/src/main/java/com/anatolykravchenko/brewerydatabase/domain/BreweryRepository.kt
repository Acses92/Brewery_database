package com.anatolykravchenko.brewerydatabase.domain

import androidx.lifecycle.LiveData

interface BreweryRepository {
    suspend fun getBreweryList(): LiveData<List<Brewery>>

    suspend fun getBrewery(): LiveData<Brewery>

}
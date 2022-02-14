package com.anatolykravchenko.brewerydatabase.domain

import androidx.lifecycle.LiveData

interface BreweryRepository {
    fun getBreweryList(): LiveData<List<Brewery>>

    fun getBrewery(): LiveData<Brewery>

    suspend fun loadData()
}
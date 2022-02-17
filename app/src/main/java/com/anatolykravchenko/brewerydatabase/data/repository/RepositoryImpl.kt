package com.anatolykravchenko.brewerydatabase.data.repository


import com.anatolykravchenko.brewerydatabase.domain.Brewery
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.data.network.ApiService

class RepositoryImpl(
    private val apiService: ApiService
): BreweryRepository {



    override suspend fun getBreweryList() = apiService.getListBreweries()


    override suspend fun getBrewery() = TODO()

}
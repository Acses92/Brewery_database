package com.anatolykravchenko.brewerydatabase.data.repository


import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.data.network.ApiService
import com.anatolykravchenko.brewerydatabase.di.AppModule
import javax.inject.Inject
import javax.inject.Singleton

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
): BreweryRepository {
    var page: Int = 1

    override suspend fun getBreweryList() = apiService.getListBreweries(page)
    override suspend fun getBrewery(): Brewery {
        TODO("Not yet implemented")
    }
}

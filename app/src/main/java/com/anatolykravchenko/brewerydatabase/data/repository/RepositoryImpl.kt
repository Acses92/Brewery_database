package com.anatolykravchenko.brewerydatabase.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anatolykravchenko.brewerydatabase.domain.Brewery
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.data.network.ApiFactory

class RepositoryImpl(
    private val application: Application
): BreweryRepository {

    private val apiService = ApiFactory.apiService


    override suspend fun getBreweryList(): LiveData<List<Brewery>> {
        val response = apiService.getListBreweries()
        if(response.isSuccessful) {
            val body = response.body()
            val breweries = mutableListOf<Brewery>()

        }
    }

    override suspend fun getBrewery(): LiveData<Brewery> {
        TODO("Not yet implemented")
    }

}
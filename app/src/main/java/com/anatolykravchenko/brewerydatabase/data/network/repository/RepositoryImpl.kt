package com.anatolykravchenko.brewerydatabase.data.network.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.anatolykravchenko.brewerydatabase.domain.Brewery
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository

class RepositoryImpl(
    private val application: Application
): BreweryRepository {
    override fun getBreweryList(): LiveData<List<Brewery>> {
        TODO("Not yet implemented")
    }

    override fun getBrewery(): LiveData<Brewery> {
        TODO("Not yet implemented")
    }

    override suspend fun loadData() {
        TODO("Not yet implemented")
    }
}
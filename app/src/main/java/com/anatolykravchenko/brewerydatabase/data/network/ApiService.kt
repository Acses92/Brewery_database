package com.anatolykravchenko.brewerydatabase.data.network

import retrofit2.http.GET
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.http.Query

interface ApiService {

    @GET("/breweries")
    suspend fun getListBreweries(
        @Query("page") page: Int
    ): List<BreweryDto>
}
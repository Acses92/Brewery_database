package com.anatolykravchenko.brewerydatabase.data.network

import retrofit2.http.GET
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import retrofit2.http.Query

interface ApiService {

    @GET("/breweries")
    suspend fun getListBreweries(
        @Query("page") page: Int
    ): List<BreweryDto>
}
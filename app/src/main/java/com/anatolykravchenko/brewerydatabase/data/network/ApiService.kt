package com.anatolykravchenko.brewerydatabase.data.network

import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/breweries")
    suspend fun getListBreweries(
        @Query("page") page: Int
    ): Result<List<BreweryDto>>
}
package com.anatolykravchenko.brewerydatabase.data.network

import retrofit2.http.GET
import com.anatolykravchenko.brewerydatabase.data.network.model.BreweryDto
import retrofit2.Response

interface ApiService {

    @GET("/breweries")
    suspend fun getListBreweries(): Response<BreweryDto>

}
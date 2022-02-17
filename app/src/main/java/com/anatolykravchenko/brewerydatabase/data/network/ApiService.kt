package com.anatolykravchenko.brewerydatabase.data.network

import retrofit2.http.GET
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto

interface ApiService {

    @GET("/breweries")
    suspend fun getListBreweries(): List<BreweryDto>

}
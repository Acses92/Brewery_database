package com.anatolykravchenko.brewerydatabase.data.network

import retrofit2.http.GET

interface ApiService {

    @GET("/breweries")
    suspend fun getListBreweries()

}
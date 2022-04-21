package com.anatolykravchenko.brewerydatabase.ui.common

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit

object MockRetrofit {
    internal fun generateRetrofit(mockWebServer: MockWebServer): Retrofit = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .addConverterFactory(Json(builderAction = {
            isLenient = true
            ignoreUnknownKeys = true
        }).asConverterFactory("application/json".toMediaType()))
        .build()
}
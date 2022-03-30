package com.anatolykravchenko.brewerydatabase.di

import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import com.anatolykravchenko.brewerydatabase.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String) = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

   
}

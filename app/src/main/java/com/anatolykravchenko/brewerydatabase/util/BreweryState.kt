package com.anatolykravchenko.brewerydatabase.util

sealed class BreweryState {
    object START: BreweryState()
    object LOADING: BreweryState()
    object SUCCESS: BreweryState()
    data class FAILURE(val message: String): BreweryState()
}
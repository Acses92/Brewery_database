package com.anatolykravchenko.brewerydatabase.util

sealed class BreweryState {
    object Start: BreweryState()
    object Loading: BreweryState()
    object Success: BreweryState()
    data class Failure(val message: String): BreweryState()
}
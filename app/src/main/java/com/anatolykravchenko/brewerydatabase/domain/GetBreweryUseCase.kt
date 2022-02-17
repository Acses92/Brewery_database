package com.anatolykravchenko.brewerydatabase.domain

class GetBreweryUseCase(
    private val repository: BreweryRepository
) {
    suspend operator fun invoke() = repository.getBrewery()
}
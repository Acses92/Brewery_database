package com.anatolykravchenko.brewerydatabase.domain

class GetBreweryUseCase(
    private val repository: BreweryRepository
) {
    operator fun invoke() = repository.getBrewery()
}
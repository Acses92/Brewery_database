package com.anatolykravchenko.brewerydatabase.domain

class GetBreweryListUseCase(
    private val repository: BreweryRepository
) {
    operator fun invoke() = repository.getBreweryList()
}
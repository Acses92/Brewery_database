package com.anatolykravchenko.brewerydatabase.domain

class GetBreweryListUseCase(
    private val repository: BreweryRepository
) {
  suspend operator fun invoke() = repository.getBreweryList()
}
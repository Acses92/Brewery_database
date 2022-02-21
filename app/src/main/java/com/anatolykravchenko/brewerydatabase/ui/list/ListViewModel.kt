package com.anatolykravchenko.brewerydatabase.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.Exception

class ListViewModel(private val breweryRepository: BreweryRepository) : ViewModel() {

    private val breweries = MutableLiveData<List<BreweryDto>>()
    private val repository = breweryRepository
    init {
        loadBreweries()
    }

    private fun loadBreweries() {
        viewModelScope.async {
            try {
                val breweriesFromApi = repository.getBreweryList()
                breweries.postValue(breweriesFromApi)
            } catch (e: Exception){

            }
        }
    }

    fun getBreweries(): LiveData<List<BreweryDto>> {
        return breweries
    }


}
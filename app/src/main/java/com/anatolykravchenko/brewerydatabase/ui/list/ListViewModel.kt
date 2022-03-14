package com.anatolykravchenko.brewerydatabase.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import com.anatolykravchenko.brewerydatabase.util.Resource
import kotlinx.coroutines.launch
import kotlin.Exception

class ListViewModel(private val breweryRepository: BreweryRepository) : ViewModel() {

    private val breweries = MutableLiveData<Resource<List<BreweryDto>>>()
    private val repository = breweryRepository
    init {
        loadBreweries()
    }

    private fun loadBreweries() {
        viewModelScope.launch {
            breweries.postValue(Resource.loading(null))
            try {
                val breweriesFromApi = repository.getBreweryList()
                breweries.postValue(Resource.success(breweriesFromApi))
            } catch (e: Exception){
                breweries.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getBreweries(): LiveData<Resource<List<BreweryDto>>> {
        return breweries
    }


}
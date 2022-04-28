package com.anatolykravchenko.brewerydatabase.ui.list

import androidx.lifecycle.*
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.util.Resource
import com.anatolykravchenko.brewerydatabase.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import com.anatolykravchenko.brewerydatabase.data.network.NetworkError
import com.anatolykravchenko.brewerydatabase.util.getException


@HiltViewModel
class ListViewModel @Inject constructor(
    private val breweryRepository: BreweryRepository) : ViewModel() {
    private val breweries = MutableLiveData<Resource<List<Brewery>>>()
    private val _openDetail = SingleLiveEvent<Brewery>()
    private val _errorEvent = SingleLiveEvent<NetworkError>()
    val errorEvent: LiveData<NetworkError> = _errorEvent
    val openDetail: LiveData<Brewery> = _openDetail

    init {
        loadBreweries()
    }

    private fun loadBreweries() {
        viewModelScope.launch {
            try {
            breweries.postValue(Resource.loading(null))
                val breweryUi: List<Brewery> = breweryRepository.getBreweryList().map { it->
                    it.toBrewery()
                }
                breweries.postValue(Resource.success(breweryUi))
            } catch (error: Throwable){
                _errorEvent.value = error.getException()
            }
        }
    }

    fun onClick(brewery: Brewery) {
        _openDetail.value = brewery
    }

    fun getBreweries(): LiveData<Resource<List<Brewery>>> {
        return breweries
    }
}





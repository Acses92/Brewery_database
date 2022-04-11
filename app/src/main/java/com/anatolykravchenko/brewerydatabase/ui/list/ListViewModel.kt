package com.anatolykravchenko.brewerydatabase.ui.list

import androidx.lifecycle.*
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.util.Resource
import com.anatolykravchenko.brewerydatabase.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.anatolykravchenko.brewerydatabase.data.model.Brewery


@HiltViewModel
class ListViewModel @Inject constructor(
    private val breweryRepository: BreweryRepository) : ViewModel() {
    private val breweries = MutableLiveData<Resource<List<Brewery>>>()
    private lateinit var breweriesFromApi: List<BreweryDto>
    private lateinit var breweryUi: List<Brewery>
    private lateinit var brewery: Brewery
    val _openDetail = SingleLiveEvent<Brewery>()
    val openDetail: LiveData<Brewery> = _openDetail
    init {
        loadBreweries()
    }

    private fun loadBreweries() {
        viewModelScope.launch {
            breweries.postValue(Resource.loading(null))
            try {
                breweriesFromApi = breweryRepository.getBreweryList()
                breweryUi = breweriesFromApi.map { it->
                    it.toBrewery()
                }
                breweries.postValue(Resource.success(breweryUi))
            } catch (e: Exception){
                breweries.postValue(Resource.error(e.toString(), null))
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
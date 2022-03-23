package com.anatolykravchenko.brewerydatabase.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import com.anatolykravchenko.brewerydatabase.util.Resource
import com.anatolykravchenko.brewerydatabase.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class ListViewModel @Inject constructor(private val breweryRepository: BreweryRepository) : ViewModel() {

    private val breweries = MutableLiveData<Resource<List<BreweryDto>>>()
    private val repository = breweryRepository
    private val _openDetail = SingleLiveEvent<BreweryDto>()
    val openDetail: LiveData<BreweryDto> = _openDetail
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

    fun onClick(breweryDto: BreweryDto) {
        _openDetail.value = breweryDto
    }

    fun getBreweries(): LiveData<Resource<List<BreweryDto>>> {
        return breweries
    }


}
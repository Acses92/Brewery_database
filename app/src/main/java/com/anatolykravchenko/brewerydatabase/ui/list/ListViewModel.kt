package com.anatolykravchenko.brewerydatabase.ui.list

import androidx.lifecycle.*
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.util.Resource
import com.anatolykravchenko.brewerydatabase.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import retrofit2.HttpException
import java.io.IOException
import com.anatolykravchenko.brewerydatabase.data.network.NetworkError


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
                when(error) {
                    is HttpException -> {
                        when(error.response()?.code()) {
                            400 -> _errorEvent.value = NetworkError.BAD_REQUEST
                            401 -> _errorEvent.value = NetworkError.UNAUTHORIZED
                            404 -> _errorEvent.value = NetworkError.NOT_FOUND
                            408 -> _errorEvent.value = NetworkError.REQUEST_TIMEOUT
                            500 -> _errorEvent.value = NetworkError.INTERNAL_SERVER_ERROR
                            else -> _errorEvent.value = NetworkError.UNKNOWN
                        }
                    }
                    is IOException -> {
                        _errorEvent.value = NetworkError.NO_CONNECTION
                    }
                    else -> {
                        _errorEvent.value = NetworkError.UNKNOWN
                    }
                }
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





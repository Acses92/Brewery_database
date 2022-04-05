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

    private val breweriesDto = MutableLiveData<Resource<List<BreweryDto>>>()
    private lateinit var breweriesFromApi: List<BreweryDto>
    private lateinit var breweryUi: List<Brewery>
    private lateinit var  breweryUiLiveData: MutableLiveData<List<Brewery>>
    private val repository = breweryRepository
    private val _openDetail = SingleLiveEvent<BreweryDto>()
    val openDetail: LiveData<BreweryDto> = _openDetail
    init {
        loadBreweries()
    }

    private fun loadBreweries() {
        viewModelScope.launch {
            breweriesDto.postValue(Resource.loading(null))
            try {
                breweriesFromApi = repository.getBreweryList()
                breweriesDto.postValue(Resource.success(breweriesFromApi))
                breweryUi = breweriesFromApi.map { it->
                    it.toBrewery()
                }
                breweryUiLiveData.postValue(breweryUi)

            } catch (e: Exception){
                breweriesDto.postValue(Resource.error(e.toString(), null))
            }
        }
    }



    fun mapDto(breweryDto: BreweryDto): Brewery {
        return Brewery(
            breweryType = breweryDto.breweryType.toString(),
            city = breweryDto.city.toString(),
            country = breweryDto.country.toString(),
            createdAt = breweryDto.createdAt.toString(),
            id = breweryDto.id.toString(),
            name = breweryDto.name.toString(),
            state = breweryDto.state.toString(),
            websiteUrl = breweryDto.websiteUrl.toString()
        )
    }

    fun onClick(breweryDto: BreweryDto) {
        _openDetail.value = breweryDto
    }

    fun getBreweries(): LiveData<Resource<List<BreweryDto>>> {
        return breweriesDto
    }

}
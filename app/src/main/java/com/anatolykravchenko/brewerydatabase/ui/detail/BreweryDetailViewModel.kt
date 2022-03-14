package com.anatolykravchenko.brewerydatabase.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import kotlinx.coroutines.launch

class BreweryDetailViewModel(private val breweryRepository: BreweryRepository): ViewModel() {

    private val breweryId: Int? = null
    private val repository = breweryRepository
    init {
    }



}
package com.anatolykravchenko.brewerydatabase.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreweryDetailViewModel @Inject constructor(
    private val breweryRepository: BreweryRepository):
    ViewModel() {

    private val breweryId: Int? = null
    private val repository = breweryRepository
    init {
    }



}
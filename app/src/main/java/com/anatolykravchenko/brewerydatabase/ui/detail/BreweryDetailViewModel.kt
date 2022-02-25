package com.anatolykravchenko.brewerydatabase.ui.detail

import androidx.lifecycle.ViewModel
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository

class BreweryDetailViewModel(private val breweryRepository: BreweryRepository): ViewModel() {

    private val repository = breweryRepository

}
package com.anatolykravchenko.brewerydatabase.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository

class SearchViewModel(private val breweryRepository: BreweryRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}
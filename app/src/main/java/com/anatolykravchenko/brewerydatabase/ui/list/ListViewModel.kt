package com.anatolykravchenko.brewerydatabase.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository

class ListViewModel(private val breweryRepository: BreweryRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val repository = breweryRepository

}
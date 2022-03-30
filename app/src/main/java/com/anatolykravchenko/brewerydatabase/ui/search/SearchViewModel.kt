package com.anatolykravchenko.brewerydatabase.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val breweryRepository: BreweryRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}
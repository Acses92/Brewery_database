package com.anatolykravchenko.brewerydatabase.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anatolykravchenko.brewerydatabase.domain.BreweryRepository
import com.anatolykravchenko.brewerydatabase.ui.search.SearchViewModel
import com.anatolykravchenko.brewerydatabase.ui.list.ListViewModel
import com.anatolykravchenko.brewerydatabase.ui.detail.BreweryDetailViewModel

class ViewModelFactory(private val breweryRepository: BreweryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(breweryRepository) as T
        }
        if(modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(breweryRepository) as T
        }
        if(modelClass.isAssignableFrom(BreweryDetailViewModel::class.java)) {
            return BreweryDetailViewModel(breweryRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
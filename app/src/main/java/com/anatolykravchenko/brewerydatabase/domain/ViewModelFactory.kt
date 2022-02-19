package com.anatolykravchenko.brewerydatabase.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anatolykravchenko.brewerydatabase.ui.gallery.GalleryViewModel
import com.anatolykravchenko.brewerydatabase.ui.home.ListViewModel

class ViewModelFactory(private val breweryRepository: BreweryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GalleryViewModel::class.java)) {
            return GalleryViewModel(breweryRepository) as T
        }
        if(modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(breweryRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
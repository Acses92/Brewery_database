package com.anatolykravchenko.brewerydatabase.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.databinding.BreweryDetailFragmentBinding
import com.anatolykravchenko.brewerydatabase.domain.ViewModelFactory
import com.anatolykravchenko.brewerydatabase.data.repository.RepositoryImpl
import com.anatolykravchenko.brewerydatabase.data.network.ApiFactory


class BreweryDetailFragment: Fragment(R.layout.brewery_detail_fragment) {
    private lateinit var breweryDetailViewModel: BreweryDetailViewModel
    private val binding: BreweryDetailFragmentBinding by viewBinding(
        createMethod = CreateMethod.INFLATE)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupViewModel()
        return binding.root
    }

    private fun setupViewModel() {
        breweryDetailViewModel = ViewModelProvider(
            this,
            ViewModelFactory(RepositoryImpl(ApiFactory.apiService))
        ).get(BreweryDetailViewModel::class.java)
    }

    private fun setupUi() {
    }


}
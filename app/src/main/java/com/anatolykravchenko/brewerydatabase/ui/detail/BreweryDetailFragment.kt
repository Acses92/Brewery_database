package com.anatolykravchenko.brewerydatabase.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.databinding.BreweryDetailFragmentBinding
import com.anatolykravchenko.brewerydatabase.util.ViewModelFactory
import com.anatolykravchenko.brewerydatabase.data.repository.RepositoryImpl
import com.anatolykravchenko.brewerydatabase.data.network.ApiFactory
import com.anatolykravchenko.brewerydatabase.data.model.Brewery


class BreweryDetailFragment: Fragment(R.layout.brewery_detail_fragment) {
    private lateinit var breweryDetailViewModel: BreweryDetailViewModel
    private val binding: BreweryDetailFragmentBinding by viewBinding(
        createMethod = CreateMethod.INFLATE)
//    val args: BreweryDetailFragmentArgs by navArgs()
    private  var brewery: Brewery? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
           //     findNavController().navigate(R.id.action_breweryDetailFragment_to_nav_list)
            }
        }
        return true

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        brewery = arguments?.getParcelable("Brewery")
        setupViewModel()
        setupUi()
    }

    private fun setupViewModel() {
        breweryDetailViewModel = ViewModelProvider(
            this,
            ViewModelFactory(RepositoryImpl(ApiFactory.apiService))
        ).get(BreweryDetailViewModel::class.java)
    }

    private fun setupUi() {
        binding.breweryNameDetail.text = brewery?.name
        binding.breweryCityDetail.text = brewery?.city
        binding.breweryCountry.text = brewery?.country
        binding.breweryTypeDetail.text = brewery?.breweryType
        binding.breweryDateOfCreate.text = brewery?.createdAt
        binding.breweryState.text = brewery?.state
        binding.breweryWebsiteUrl.text = brewery?.websiteUrl
    }
}
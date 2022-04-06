package com.anatolykravchenko.brewerydatabase.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import com.anatolykravchenko.brewerydatabase.databinding.BreweryDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreweryDetailFragment: Fragment(R.layout.brewery_detail_fragment) {
    private val breweryDetailViewModel by viewModels<BreweryDetailViewModel>()
    private val binding: BreweryDetailFragmentBinding by viewBinding()
    private  var brewery: Brewery? = null
    private lateinit var  listFragment: ListFragment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        brewery = arguments?.getParcelable("Brewery")
        setupUi()
        backButtonPres()

    }
    private fun backButtonPres() {
        binding.backButton.setOnClickListener {
            parentFragmentManager.popBackStackImmediate()
        }
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

    companion object {
        fun newInstance(brewery: Brewery):Fragment {
            val arg: Bundle = Bundle()
            arg.putParcelable("Brewery", brewery)
            val fragment = BreweryDetailFragment()
            fragment.arguments = arg
            return fragment
        }
    }
}
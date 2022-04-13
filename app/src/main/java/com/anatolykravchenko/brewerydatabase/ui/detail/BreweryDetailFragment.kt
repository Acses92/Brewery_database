package com.anatolykravchenko.brewerydatabase.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import com.anatolykravchenko.brewerydatabase.databinding.BreweryDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreweryDetailFragment: Fragment(R.layout.brewery_detail_fragment) {
    private val breweryDetailViewModel by viewModels<BreweryDetailViewModel>()
    private val binding by viewBinding(BreweryDetailFragmentBinding::bind)
    private var brewery: Brewery? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        brewery = arguments?.getParcelable(DETAIL_KEY)
        setupUi()
        backButtonPres()
    }
    private fun backButtonPres() {
        binding.buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
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
        brewery = null
    }

    companion object {
        private const val DETAIL_KEY = "BREWERY"

        fun newInstance(brewery: Brewery):Fragment {
            val arg = Bundle()
            arg.putParcelable(DETAIL_KEY, brewery)
            val fragment = BreweryDetailFragment()
            fragment.arguments = arg
            return fragment
        }
    }
}
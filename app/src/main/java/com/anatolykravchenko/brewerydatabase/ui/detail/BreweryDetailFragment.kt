package com.anatolykravchenko.brewerydatabase.ui.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.databinding.BreweryDetailFragmentBinding
import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.currentCoroutineContext

@AndroidEntryPoint
class BreweryDetailFragment: Fragment(R.layout.brewery_detail_fragment) {
    private val breweryDetailViewModel by viewModels<BreweryDetailViewModel>()
    private val binding: BreweryDetailFragmentBinding by viewBinding(
        createMethod = CreateMethod.INFLATE)
    private  var brewery: Brewery? = null
    private lateinit var  listFragment: ListFragment

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        brewery = arguments?.getParcelable("Brewery")
        setupUi()
        binding.backButton.setOnClickListener {
            listFragment = ListFragment()
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, listFragment)
                .commit()
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
}
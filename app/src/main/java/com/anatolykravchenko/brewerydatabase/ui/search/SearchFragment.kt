package com.anatolykravchenko.brewerydatabase.ui.search

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.databinding.SearchFragmentBinding
import com.anatolykravchenko.brewerydatabase.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.search_fragment) {

    private val searchViewModel by viewModels<SearchViewModel>()
    private val binding  by viewBinding(SearchFragmentBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView: TextView = binding.textGallery
        searchViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
    }

}
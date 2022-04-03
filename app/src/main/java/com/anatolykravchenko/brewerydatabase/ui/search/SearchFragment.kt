package com.anatolykravchenko.brewerydatabase.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.databinding.SearchFragmentBinding
import com.anatolykravchenko.brewerydatabase.util.ViewModelFactory
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.data.repository.RepositoryImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.search_fragment) {

    private val searchViewModel by viewModels<SearchViewModel>()
    private val binding: SearchFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView: TextView = binding.textGallery
        searchViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
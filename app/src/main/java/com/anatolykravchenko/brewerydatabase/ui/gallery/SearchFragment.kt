package com.anatolykravchenko.brewerydatabase.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.databinding.FragmentSearchBinding
import com.anatolykravchenko.brewerydatabase.domain.ViewModelFactory
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.data.repository.RepositoryImpl
import com.anatolykravchenko.brewerydatabase.data.network.ApiFactory


class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var galleryViewModel: GalleryViewModel
    private val binding: FragmentSearchBinding by viewBinding(createMethod = CreateMethod.INFLATE)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(
                    this,
                    ViewModelFactory(RepositoryImpl(ApiFactory.apiService))
                ).get(GalleryViewModel::class.java)

     //   val root: View = binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
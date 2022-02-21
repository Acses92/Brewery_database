package com.anatolykravchenko.brewerydatabase.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.databinding.FragmentListBinding
import com.anatolykravchenko.brewerydatabase.domain.ViewModelFactory
import com.anatolykravchenko.brewerydatabase.data.repository.RepositoryImpl
import com.anatolykravchenko.brewerydatabase.data.network.ApiFactory
import com.anatolykravchenko.brewerydatabase.ui.adapters.BreweryListAdapter
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto


class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var listViewModel: ListViewModel
    private val binding: FragmentListBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private lateinit var adapter: BreweryListAdapter
    private lateinit var breweriesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setupViewModel()
        val view =  binding.root
        setupUI()
        setupObserver()
        return view
    }

    private fun setupViewModel() {
        listViewModel =
                ViewModelProvider(
                    this,
                    ViewModelFactory(RepositoryImpl(ApiFactory.apiService))
                ).get(ListViewModel::class.java)
    }


    private fun setupUI() {
        breweriesRecyclerView = binding.BreweyListRecyclerView as RecyclerView
        breweriesRecyclerView.layoutManager = LinearLayoutManager(context)
        breweriesRecyclerView.adapter = BreweryListAdapter(arrayListOf())
    }

    private fun setupObserver() {
        listViewModel.getBreweries().observe(this) {
            it.let {breweries -> adapter.addBrewery(breweries) }
        }
    }
}
package com.anatolykravchenko.brewerydatabase.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.databinding.BreweryListFragmentBinding
import com.anatolykravchenko.brewerydatabase.domain.ViewModelFactory
import com.anatolykravchenko.brewerydatabase.data.repository.RepositoryImpl
import com.anatolykravchenko.brewerydatabase.data.network.ApiFactory
import com.anatolykravchenko.brewerydatabase.ui.adapters.BreweryListAdapter
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import com.anatolykravchenko.brewerydatabase.domain.Status


class ListFragment : Fragment(R.layout.brewery_list_fragment) {

    private lateinit var listViewModel: ListViewModel
    private val binding: BreweryListFragmentBinding by viewBinding(
        createMethod = CreateMethod.INFLATE)
    private lateinit var adapter: BreweryListAdapter
    private lateinit var breweriesRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  binding.root
        setupUI()
        setupViewModel()
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
        breweriesRecyclerView  = binding.BreweyListRecyclerView
        breweriesRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = BreweryListAdapter()
        breweriesRecyclerView.adapter  = adapter
    }

    private fun setupObserver() {
        listViewModel.getBreweries().observe(this) {
            when(it.status) {
                Status.SUCCESS ->{
                    it.data?.let { breweries -> renderList(breweries) }
                    binding.progressBar.visibility = View.GONE
                    binding.BreweyListRecyclerView.visibility = View.VISIBLE
                }
                Status.LOADING ->{
                    binding.progressBar.visibility = View.VISIBLE
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun renderList(breweries: List<BreweryDto>) {
        adapter.myData.clear()
        adapter.addBrewery(breweries)
        adapter.notifyDataSetChanged()
    }
}
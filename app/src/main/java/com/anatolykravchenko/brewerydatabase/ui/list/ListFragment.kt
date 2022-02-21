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
import com.anatolykravchenko.brewerydatabase.databinding.FragmentListBinding
import com.anatolykravchenko.brewerydatabase.domain.ViewModelFactory
import com.anatolykravchenko.brewerydatabase.data.repository.RepositoryImpl
import com.anatolykravchenko.brewerydatabase.data.network.ApiFactory
import com.anatolykravchenko.brewerydatabase.ui.adapters.BreweryListAdapter
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import com.anatolykravchenko.brewerydatabase.domain.Status


class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var listViewModel: ListViewModel
    private val binding: FragmentListBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private lateinit var adapter: BreweryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
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
        val breweriesRecyclerView: RecyclerView = binding.BreweyListRecyclerView as RecyclerView
        breweriesRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter  = BreweryListAdapter(arrayListOf())
    }

    private fun setupObserver() {
        listViewModel.getBreweries().observe(this) {
            when(it.status) {
                Status.SUCCESS ->{
                    it.data?.let { breweries -> renderList(breweries) }
                }
                Status.LOADING ->{
        //            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Status.ERROR -> {
        //            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun renderList(breweries: List<BreweryDto>) {
        adapter.addBrewery(breweries)
    }
}
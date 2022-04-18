package com.anatolykravchenko.brewerydatabase.ui.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import com.anatolykravchenko.brewerydatabase.databinding.BreweryListFragmentBinding
import com.anatolykravchenko.brewerydatabase.ui.adapters.BreweryListAdapter
import com.anatolykravchenko.brewerydatabase.ui.detail.BreweryDetailFragment
import com.anatolykravchenko.brewerydatabase.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.brewery_list_fragment) {

    private val listViewModel by viewModels<ListViewModel>()
    private val binding  by viewBinding(BreweryListFragmentBinding::bind)
    private lateinit var adapter: BreweryListAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
        setupOpenDetail()
    }

    private fun setupOpenDetail() {
        listViewModel.openDetail.observe(viewLifecycleOwner){
                openDetail(it)
        }
    }

    private fun setupUI() {
        binding.BreweyListRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = BreweryListAdapter {
            listViewModel.onClick(it)
        }
        binding.BreweyListRecyclerView.adapter  = adapter
    }

    private fun setupObserver() {
        listViewModel.getBreweries().observe(viewLifecycleOwner) {
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
        listViewModel.errorEvent.observe(viewLifecycleOwner) {
     //       Toast.makeText(context, message = it.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun renderList(breweries: List<Brewery>) {
        adapter.myData.clear()
        adapter.addBrewery(breweries)
        adapter.notifyDataSetChanged()
    }

    private fun openDetail(brewery: Brewery) {
        val fragment = BreweryDetailFragment.newInstance(brewery)
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, fragment, "DetailFragment")
            .addToBackStack(null)
            .commit()
    }


}
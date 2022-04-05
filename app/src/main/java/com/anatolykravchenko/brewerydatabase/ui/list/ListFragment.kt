package com.anatolykravchenko.brewerydatabase.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.databinding.BreweryListFragmentBinding
import com.anatolykravchenko.brewerydatabase.ui.adapters.BreweryListAdapter
import com.anatolykravchenko.brewerydatabase.util.Status
import com.anatolykravchenko.brewerydatabase.data.model.Brewery
import com.anatolykravchenko.brewerydatabase.ui.detail.BreweryDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.brewery_list_fragment) {

    private val listViewModel by viewModels<ListViewModel>()
    private val binding: BreweryListFragmentBinding by viewBinding(
        createMethod = CreateMethod.INFLATE)
    private lateinit var adapter: BreweryListAdapter
    private lateinit var breweriesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
        setupOpenDetail()
    }

    private fun setupOpenDetail() {
        listViewModel.openDetail.observe(viewLifecycleOwner) {brewery ->
            openDetail(brewery)
        }
    }

    private fun setupUI() {
        breweriesRecyclerView  = binding.BreweyListRecyclerView
        breweriesRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = BreweryListAdapter {
            listViewModel.onClick(it)
        }
        breweriesRecyclerView.adapter  = adapter
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
    }

    private fun renderList(breweries: List<Brewery>) {
        adapter.myData.clear()
        adapter.addBrewery(breweries)
        adapter.notifyDataSetChanged()
    }

    private fun openDetail(brewery: Brewery) {
        val fragment = newInstance(brewery)
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, fragment)
            .addToBackStack(null)
            .commit()
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
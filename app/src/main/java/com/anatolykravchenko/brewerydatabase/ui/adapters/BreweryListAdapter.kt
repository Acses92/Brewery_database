package com.anatolykravchenko.brewerydatabase.ui.adapters

import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto

class BreweryListAdapter(private val breweries: LiveData<BreweryDto>):
    RecyclerView.Adapter<BreweryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
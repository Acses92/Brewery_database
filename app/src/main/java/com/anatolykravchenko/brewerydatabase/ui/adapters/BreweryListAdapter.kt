package com.anatolykravchenko.brewerydatabase.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto
import com.anatolykravchenko.brewerydatabase.R

class BreweryListAdapter(private val breweries: ArrayList<BreweryDto>):
    RecyclerView.Adapter<BreweryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.brewery_item, parent,false)
        return BreweryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        val brewery = breweries[position]
        holder.apply {
            breweryName.text = brewery.name
            breweryType.text = brewery.breweryType
            breweryCity.text = brewery.city
        }
    }

    override fun getItemCount(): Int = breweries.size

    fun addBrewery(list: List<BreweryDto>) = breweries.addAll(list)
}



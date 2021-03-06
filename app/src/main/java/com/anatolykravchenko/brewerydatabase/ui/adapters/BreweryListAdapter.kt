package com.anatolykravchenko.brewerydatabase.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.data.model.Brewery

class BreweryListAdapter (
    private val onItemClicked: (Brewery) ->Unit
):
    RecyclerView.Adapter<BreweryViewHolder>() {


    val myData = mutableListOf<Brewery>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.brewery_item, parent,false)
        return BreweryViewHolder(itemView)
    }

    override fun getItemCount(): Int = myData.size

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        val brewery = myData[position]
        holder.apply {
            breweryName.text = brewery.name
            breweryType.text = brewery.breweryType
            breweryCity.text = brewery.city
            holder.itemView.setOnClickListener {onItemClicked(brewery)}
        }
    }

    fun addBrewery(list: List<Brewery>) = myData.addAll(list)
}



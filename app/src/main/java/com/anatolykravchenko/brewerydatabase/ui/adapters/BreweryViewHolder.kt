package com.anatolykravchenko.brewerydatabase.ui.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anatolykravchenko.brewerydatabase.R

class BreweryViewHolder (itemView: View,
): RecyclerView.ViewHolder(itemView) {

    val breweryName: TextView = itemView.findViewById(R.id.breweryDetail)
    val breweryType: TextView = itemView.findViewById(R.id.breweryType)
    val breweryCity: TextView = itemView.findViewById(R.id.breweryCity)
}
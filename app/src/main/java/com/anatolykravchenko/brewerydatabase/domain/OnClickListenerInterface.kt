package com.anatolykravchenko.brewerydatabase.domain

import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto

public interface OnClickListenerInterface {

    fun onClickBrewery(brewery: BreweryDto)

}
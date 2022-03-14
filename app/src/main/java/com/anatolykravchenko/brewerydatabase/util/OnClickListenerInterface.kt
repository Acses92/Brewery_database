package com.anatolykravchenko.brewerydatabase.util

import com.anatolykravchenko.brewerydatabase.data.model.BreweryDto

public interface OnClickListenerInterface {

    fun onClickBrewery(brewery: BreweryDto)

}
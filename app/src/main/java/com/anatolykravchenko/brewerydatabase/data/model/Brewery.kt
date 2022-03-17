package com.anatolykravchenko.brewerydatabase.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Brewery(
    val breweryType: String,
    val city: String,
    val country: String,
    val createdAt: String,
    val id: String,
    val name: String,
    val state: String?,
    val websiteUrl: String
): Parcelable

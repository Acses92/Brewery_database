package com.anatolykravchenko.brewerydatabase.data.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreweryDto(
    @SerialName("address_2")
    val address2: Any,
    @SerialName("address_3")
    val address3: Any,
    @SerialName("brewery_type")
    val breweryType: String,
    @SerialName("city")
    val city: String,
    @SerialName("country")
    val country: String,
    @SerialName("county_province")
    val countyProvince: Any,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("id")
    val id: String,
    @SerialName("latitude")
    val latitude: String,
    @SerialName("longitude")
    val longitude: String,
    @SerialName("name")
    val name: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("postal_code")
    val postalCode: String,
    @SerialName("state")
    val state: String,
    @SerialName("street")
    val street: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("website_url")
    val websiteUrl: Any
)
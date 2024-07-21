package com.example.incetroapp.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestaurantList(
    @SerialName("data")
    val `data`: List<Data>,
    @SerialName("meta")
    val meta: Meta
)
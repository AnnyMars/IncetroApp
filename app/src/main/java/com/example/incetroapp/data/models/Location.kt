package com.example.incetroapp.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("address")
    val address: String,
    @SerialName("city")
    val city: String,
    @SerialName("district")
    val district: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("organization")
    val organization: Int
)
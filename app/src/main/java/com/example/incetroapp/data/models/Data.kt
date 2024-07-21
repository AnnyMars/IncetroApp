package com.example.incetroapp.data.models


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("averageCheck")
    val averageCheck: List<@Contextual Any>?,
    @SerialName("cuisines")
    val cuisines: List<String>,
    @SerialName("distance")
    @Contextual
    val distance: Double?,
    @SerialName("id")
    val id: Int,
    @SerialName("isFavorite")
    val isFavorite: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("photo")
    val photo: String,
    @SerialName("rate")
    val rate: Double
)
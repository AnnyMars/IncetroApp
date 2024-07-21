package com.example.incetroapp.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FavoriteResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("organization")
    val organization: Int,
    @SerialName("user")
    val user: String
)
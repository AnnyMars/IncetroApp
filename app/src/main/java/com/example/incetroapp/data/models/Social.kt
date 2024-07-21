package com.example.incetroapp.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Social(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("organization")
    val organization: Int,
    @SerialName("type")
    val type: Int,
    @SerialName("url")
    val url: String
)
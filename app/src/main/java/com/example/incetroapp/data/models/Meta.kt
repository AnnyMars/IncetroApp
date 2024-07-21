package com.example.incetroapp.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("currentPage")
    val currentPage: Int,
    @SerialName("pageCount")
    val pageCount: Int,
    @SerialName("perPage")
    val perPage: Int,
    @SerialName("totalCount")
    val totalCount: Int
)
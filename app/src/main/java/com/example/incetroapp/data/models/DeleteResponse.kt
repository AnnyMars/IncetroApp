package com.example.incetroapp.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeleteResponse(
    @SerialName("detail")
    val detail: String
)
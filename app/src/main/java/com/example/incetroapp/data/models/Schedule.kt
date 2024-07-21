package com.example.incetroapp.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Schedule(
    @SerialName("day")
    val day: Int,
    @SerialName("end")
    val end: Int,
    @SerialName("start")
    val start: Int
)
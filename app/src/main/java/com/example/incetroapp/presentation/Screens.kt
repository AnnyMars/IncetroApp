package com.example.incetroapp.presentation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    object MainScreen

    @Serializable
    data class DetailScreen(
        val id: Int
    )
}
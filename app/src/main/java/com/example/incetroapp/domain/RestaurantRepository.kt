package com.example.incetroapp.domain

import com.example.incetroapp.data.models.Data
import com.example.incetroapp.data.models.Restaurant
import com.example.incetroapp.utils.RequestResult

interface RestaurantRepository {

    suspend fun getAllRestaurants(): RequestResult<List<Data>>

    suspend fun updateFavoriteStatus(id: Int, isFavorite: Boolean): RequestResult<Unit>

    suspend fun getRestaurantById(id: Int): RequestResult<Restaurant>

}
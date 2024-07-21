package com.example.incetroapp.data.remote

import com.example.incetroapp.data.models.Data
import com.example.incetroapp.data.models.DeleteResponse
import com.example.incetroapp.data.models.Restaurant
import com.example.incetroapp.domain.RestaurantRepository
import com.example.incetroapp.utils.RequestResult
import kotlinx.serialization.json.Json

class RestaurantRepositoryImpl(
    private val api: RestaurantApi
): RestaurantRepository {
    override suspend fun getAllRestaurants(): RequestResult<List<Data>> {
        return try {
            val restaurants = api.getAllRestaurants()
            RequestResult.Success(restaurants.data)
        } catch (e: Exception){
            RequestResult.Failure(e)
        }
    }

    override suspend fun updateFavoriteStatus(id: Int, isFavorite: Boolean): RequestResult<Unit> {
        return try {
            when {
                isFavorite -> {
                    val response = api.addFavorite(id)
                    if (response.id > 0) {
                        RequestResult.Success(Unit)
                    } else {
                        RequestResult.Failure(Exception("Failed to add to favorites"))
                    }
                }
                else -> {
                    val response = api.removeFavorite(id)
                    if (response.isSuccessful) {
                        RequestResult.Success(Unit)
                    } else {

                        val errorBody = response.errorBody()?.string()
                        val deleteResponse = Json.decodeFromString<DeleteResponse>(errorBody ?: "")
                        RequestResult.Failure(Exception(deleteResponse.detail))
                    }
                }
            }
        } catch (e: Exception) {
            RequestResult.Failure(e)
        }
    }

    override suspend fun getRestaurantById(id: Int): RequestResult<Restaurant> {
        return try {
            val restaurant = api.getRestaurantById(id)
            RequestResult.Success(restaurant)
        } catch (e: Exception){
            RequestResult.Failure(e)
        }
    }
}
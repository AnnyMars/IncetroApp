package com.example.incetroapp.data.remote


import com.example.incetroapp.data.models.FavoriteResponse
import com.example.incetroapp.data.models.Restaurant
import com.example.incetroapp.data.models.RestaurantList
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestaurantApi {

    @GET("internship/organizations/category/1/organizations/")
    suspend fun getAllRestaurants(): RestaurantList

    @GET("https://api.mycyprus.app/api/internship/organization/{id}")
    suspend fun getRestaurantById(@Path("id") id: Int): Restaurant

    @POST("internship/organization/{id}/favorite/")
    suspend fun addFavorite(@Path("id") id: Int): FavoriteResponse

    @DELETE("internship/organization/{id}/favorite/")
    suspend fun removeFavorite(@Path("id") id: Int): Response<Unit>

}
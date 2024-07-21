package com.example.incetroapp.presentation.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.incetroapp.data.models.Data
import com.example.incetroapp.domain.RestaurantRepository
import com.example.incetroapp.utils.RequestResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _restaurants = MutableStateFlow<RequestResult<List<Data>>>(RequestResult.Loading)
    val restaurants: StateFlow<RequestResult<List<Data>>> = _restaurants

    private val _favoriteCount = MutableStateFlow(0)
    val favoriteCount: StateFlow<Int> = _favoriteCount



    fun fetchRestaurants() {
        viewModelScope.launch(Dispatchers.IO) {
            _restaurants.value = repository.getAllRestaurants()
            (_restaurants.value as? RequestResult.Success)?.data?.let { updateFavoriteCount(it) }
        }
    }

    fun toggleFavoriteStatus(restaurant: Data) {
        viewModelScope.launch(Dispatchers.IO) {
            val updatedRestaurant = restaurant.copy(isFavorite = !restaurant.isFavorite)
            val currentList = (_restaurants.value as? RequestResult.Success)?.data?.toMutableList()
                ?: mutableListOf()
            currentList.replaceAll {
                if (it.id == updatedRestaurant.id) updatedRestaurant else it
            }
            _restaurants.value = RequestResult.Success(currentList)
            updateFavoriteCount(currentList)

            val result =
                repository.updateFavoriteStatus(updatedRestaurant.id, updatedRestaurant.isFavorite)
            if (result is RequestResult.Failure) {

                val revertedRestaurant =
                    updatedRestaurant.copy(isFavorite = !updatedRestaurant.isFavorite)
                currentList.replaceAll {
                    if (it.id == revertedRestaurant.id) revertedRestaurant else it
                }
                _restaurants.value = RequestResult.Success(currentList)
                updateFavoriteCount(currentList)

            }
        }
    }

    private fun updateFavoriteCount(restaurants: List<Data>) {
        val count = restaurants.count { it.isFavorite }
        _favoriteCount.value = count
    }

}
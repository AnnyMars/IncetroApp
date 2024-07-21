package com.example.incetroapp.presentation.detailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.incetroapp.data.models.Restaurant
import com.example.incetroapp.domain.RestaurantRepository
import com.example.incetroapp.utils.RequestResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: RestaurantRepository
): ViewModel() {

    private val _restaurant = MutableStateFlow<RequestResult<Restaurant>>(RequestResult.Loading)
    val restaurant: StateFlow<RequestResult<Restaurant>> = _restaurant

    fun fetchRestaurant(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _restaurant.value = repository.getRestaurantById(id)
        }
    }

}
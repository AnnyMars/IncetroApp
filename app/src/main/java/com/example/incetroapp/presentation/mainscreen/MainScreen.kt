package com.example.incetroapp.presentation.mainscreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.incetroapp.data.models.Data
import com.example.incetroapp.presentation.mainscreen.common.MainTopBar
import com.example.incetroapp.presentation.mainscreen.common.RestaurantItem
import com.example.incetroapp.utils.RequestResult

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel(), navigateToDetail: (Int) -> Unit) {

    val restaurants by viewModel.restaurants.collectAsState()
    val favoriteCount by viewModel.favoriteCount.collectAsState()
    var isFavoriteSelected by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        viewModel.fetchRestaurants()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF2F2F7))
    ) {

        MainTopBar(
            title = if (!isFavoriteSelected) "Рестораны" else "Избранное",
            onActionClick = {
                isFavoriteSelected = !isFavoriteSelected
                Log.d("MyLog", isFavoriteSelected.toString())
            },
            count = favoriteCount,
            isSelected = isFavoriteSelected
        )

        when (restaurants) {
            is RequestResult.Success -> {
                val restaurantList = (restaurants as RequestResult.Success<List<Data>>).data
                Column {
                    LazyColumn {
                        if (!isFavoriteSelected) {
                            items(restaurantList) { restaurant ->
                                RestaurantItem(restaurant, viewModel::toggleFavoriteStatus) {
                                    navigateToDetail(restaurant.id)
                                }
                            }
                        } else {
                            items(restaurantList.filter { it.isFavorite }) { restaurant ->
                                RestaurantItem(restaurant, viewModel::toggleFavoriteStatus) {
                                    navigateToDetail(restaurant.id)
                                }
                            }
                        }

                    }
                }
            }

            is RequestResult.Failure -> {
                Text("Failed to load restaurants")
            }

            RequestResult.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                    CircularProgressIndicator()
                }
            }
        }

    }
}
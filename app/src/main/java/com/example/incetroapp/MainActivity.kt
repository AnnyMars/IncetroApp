package com.example.incetroapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.incetroapp.data.models.Restaurant
import com.example.incetroapp.presentation.Screens
import com.example.incetroapp.presentation.detailscreen.DetailScreen
import com.example.incetroapp.presentation.detailscreen.DetailViewModel
import com.example.incetroapp.presentation.mainscreen.MainScreen
import com.example.incetroapp.utils.RequestResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Screens.MainScreen) {
                composable<Screens.MainScreen> {
                    MainScreen(navigateToDetail = { id ->
                        navController.navigate(Screens.DetailScreen(id))
                    })
                }
                composable<Screens.DetailScreen> {
                    val args = it.toRoute<Screens.DetailScreen>()
                    val viewModel: DetailViewModel = hiltViewModel()
                    LaunchedEffect(Unit) {
                        viewModel.fetchRestaurant(args.id)
                    }
                    val restaurant by viewModel.restaurant.collectAsState()
                    when (restaurant) {
                        is RequestResult.Failure -> Box(modifier = Modifier.fillMaxSize()) {
                            Text("Failed to load info about restaurant")
                        }

                        RequestResult.Loading -> {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                                CircularProgressIndicator()
                            }
                        }

                        is RequestResult.Success -> {
                            val rest = (restaurant as RequestResult.Success<Restaurant>).data
                            DetailScreen(restaurant = rest, navigateBack = {navController.navigateUp()})
                        }
                    }
                    Log.d("MyLog", args.id.toString())

                }
            }
        }
    }
}



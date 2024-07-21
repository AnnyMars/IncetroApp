package com.example.incetroapp.utils

sealed class RequestResult<out T> {
    data class Success<out T>(val data: T) : RequestResult<T>()
    data class Failure(val error: Exception) : RequestResult<Nothing>()
    data object Loading: RequestResult<Nothing>()
}
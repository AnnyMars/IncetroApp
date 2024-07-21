package com.example.incetroapp.data.models


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Restaurant(
    @SerialName("averageCheck")
    val averageCheck: List<@Contextual Any>?,
    @SerialName("categoryName")
    val categoryName: String,
    @SerialName("cuisines")
    val cuisines: List<String>?,
    @SerialName("detailedInfo")
    val detailedInfo: String,
    @SerialName("discount")
    val discount: Int,
    @SerialName("distance")
    @Contextual
    val distance: Any?,
    @SerialName("email")
    val email: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("isFavorite")
    val isFavorite: Boolean,
    @SerialName("location")
    val location: Location,
    @SerialName("name")
    val name: String,
    @SerialName("phones")
    val phones: List<String>,
    @SerialName("photos")
    val photos: List<String>,
    @SerialName("rate")
    val rate: Double,
    @SerialName("rateCount")
    val rateCount: Int,
    @SerialName("review")
    @Contextual
    val review: Any?,
    @SerialName("reviewCount")
    val reviewCount: Int,
    @SerialName("schedule")
    val schedule: List<Schedule>,
    @SerialName("serviceLanguages")
    val serviceLanguages: List<String>,
    @SerialName("services")
    val services: List<@Contextual Any>?,
    @SerialName("socials")
    val socials: List<Social>,
    @SerialName("urls")
    val urls: List<String>
)
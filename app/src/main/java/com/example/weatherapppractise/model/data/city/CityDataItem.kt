package com.example.weatherapppractise.model.data.city

data class CityDataItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)
package com.example.weatherapppractise.model.data.week


data class Week(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeekOfData>,
    val message: Int
)
package com.example.weatherapppractise.model.data.week

data class WeekOfData
    (val clouds: Clouds,
                      val dt: Int,
                      val dt_txt: String,
                      val main: Main,
                      val pop: Double,
                      val rain: Rain,
                      val sys: Sys,
                      val visibility: Int,
                      val weather: List<Weather>,
                      val wind: Wind)

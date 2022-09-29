package com.example.weatherapppractise.model.remote

import com.example.weatherapppractise.model.data.city.CityDataItem
import com.example.weatherapppractise.model.data.today.Today
import com.example.weatherapppractise.model.data.week.Week
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//https://openweathermap.org
// http://api.openweathermap.org/geo/1.0/direct?q=London&limit=5&appid=a090314144b2e9aa128cda27f59c272c

    @GET("/geo/1.0/direct")
suspend fun getCity(
        @Query("q") city: String,
        @Query("appid") appId: String
    ):  Response<List<CityDataItem>>
//https://api.openweathermap.org/data/2.5/weather?lat=41.8755616&lon=-87.6244212&appid=a090314144b2e9aa128cda27f59c272c

@GET("/data/2.5/weather")
suspend fun getTodayWeather(
    @Query("lat") lat: String,
    @Query("lon") lon: String,
    @Query("appid") appId: String,
    @Query("units") units:String="metric"
):  Response<Today>


//http://api.openweathermap.org/data/2.5/forecast?lat=44.34&lon=10.99&appid=a090314144b2e9aa128cda27f59c272c
    @GET("/data/2.5/forecast")
    suspend fun getWeather7(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appId: String,
        @Query("units") units:String="metric"
    ):  Response<Week>

}

//https://pro.openweathermap.org/data/2.5/forecast/climate?lat=35&lon=139&appid={API key}
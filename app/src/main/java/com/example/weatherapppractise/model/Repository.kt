package com.example.weatherapppractise.model

import com.example.weatherapppractise.model.data.city.CityDataItem
import com.example.weatherapppractise.model.data.today.Today
import com.example.weatherapppractise.model.data.week.Week
import com.example.weatherapppractise.model.remote.ApiService
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCity(city:String,appid:String): Response<List<CityDataItem>>{
        return  apiService.getCity(city,appid)
    }

    suspend fun getTodayWeather(lat:String, lon:String,appid:String): Response<Today>{
        return  apiService.getTodayWeather(lat,lon,appid)
    }

    suspend fun getweekWeather(lat:String, lon:String,appid:String): Response<Week>{
        return  apiService.getWeather7(lat,lon,appid)
    }
}
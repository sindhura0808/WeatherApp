package com.example.weatherapppractise.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapppractise.model.Constants
import com.example.weatherapppractise.model.Repository
import com.example.weatherapppractise.model.data.city.CityDataItem
import com.example.weatherapppractise.model.data.today.Today
import com.example.weatherapppractise.model.data.week.Week
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val cityData = MutableLiveData<List<CityDataItem>>()
    val todayweatherData = MutableLiveData<Today>()
    val weekData = MutableLiveData<Week>()
    val error = MutableLiveData<String>()
    val processing = MutableLiveData<Boolean>()
    val appid= Constants.API_KEY

    fun cityName(cityname: String) {

        viewModelScope.launch(Dispatchers.IO)
        {
            try {
                processing.postValue(true)
                val response = repository.getCity(cityname,appid)
                processing.postValue(false)
                if (!response.isSuccessful) {
                    error.postValue("Failed to load data.Error code: ${response.code()}")
                    return@launch
                }
                response.body()?.let {
                    cityData.postValue(it)
                }
            } catch (e: Exception) {
                error.postValue("Error is : $e")
                e.printStackTrace()
                processing.postValue(false)
            }
        }
    }

    fun todayWeather(lat:String, lon:String)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            try {
                processing.postValue(true)
                val response = repository.getTodayWeather(lat,lon,appid)
                processing.postValue(false)
                if (!response.isSuccessful) {
                    error.postValue("Failed to load data.Error code: ${response.code()}")
                    return@launch
                }
                response.body()?.let {
                    todayweatherData.postValue(it)
                }
            } catch (e: Exception) {
                error.postValue("Error is : $e")
                e.printStackTrace()
                processing.postValue(false)
            }
        }
    }

    fun getweekWeather(lat:String, lon:String)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            try {
                processing.postValue(true)
                val response = repository.getweekWeather(lat,lon,appid)
                processing.postValue(false)
                if (!response.isSuccessful) {
                    error.postValue("Failed to load data.Error code: ${response.code()}")
                    return@launch
                }
                response.body()?.let {
                    weekData.postValue(it)
                }
            } catch (e: Exception) {
                error.postValue("Error is : $e")
                e.printStackTrace()
                processing.postValue(false)
            }
        }
    }
}
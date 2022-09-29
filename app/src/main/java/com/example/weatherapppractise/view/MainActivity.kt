package com.example.weatherapppractise.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapppractise.databinding.ActivityMainBinding
import com.example.weatherapppractise.model.data.city.CityDataItem
import com.example.weatherapppractise.model.data.today.Today
import com.example.weatherapppractise.model.data.week.Week
import com.example.weatherapppractise.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var getcityname:String
    lateinit var myDataAdapter: WeatherAdapter

    val vm:MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
  getCityName()
    }
 fun getCityName()
 {
     getcityname= binding.edtCityName.text.toString()

     binding.imgSearch.setOnClickListener {
         getcityname= binding.edtCityName.text.toString()
        // Toast.makeText(this,binding.edtCityName.text.toString(),Toast.LENGTH_LONG).show()
         makeAPIcall()

     }
 }
    fun makeAPIcall()
    {
        vm.cityName(getcityname)
        vm.cityData.observe(this)
        {
            getlatlon(it)
        }
    }

    private fun getlatlon(city:List<CityDataItem>) {
       val lat= city?.get(0)?.lat.toString()
    val lon = city?.get(0)?.lon.toString()
        vm.todayWeather(lat,lon)
        vm.todayweatherData.observe(this)
        {
            getCurrentTemp(it)
        }
        vm.getweekWeather(lat,lon)
        vm.weekData.observe(this)
        {
            getWeekWeather(it)
        }
    }

    private fun getWeekWeather(week: Week) {
        setUpData(week)
    }

    private fun setUpData(week: Week) {
  binding.recycle1.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        myDataAdapter= WeatherAdapter(this,week)
        binding.recycle1.adapter=myDataAdapter

    }

    private fun getCurrentTemp(weather: Today?) {
        binding.weather.text = weather?.main?.temp.toString()
        binding.overcast.text= weather?.weather?.get(0)?.description.toString()

    }


}
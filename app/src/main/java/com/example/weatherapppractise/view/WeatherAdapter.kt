package com.example.weatherapppractise.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapppractise.databinding.WeekListBinding
import com.example.weatherapppractise.model.data.week.Week
import org.w3c.dom.Text
import javax.inject.Inject

class WeatherAdapter constructor(private val context: Context, private val week:Week): RecyclerView.Adapter<WeatherAdapter.DataViewHolder> () {

    lateinit var binding:WeekListBinding
    inner class DataViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val time:TextView= binding.timedate
        val max:TextView= binding.degreeMax
        val min:TextView= binding.degreeMin
        val temp: TextView = binding.temp
        val mile: TextView = binding.mile
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
      binding=WeekListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
    holder.apply {
        val dataInfo= week.list[position]
        time.text=dataInfo.dt_txt
        max.text=dataInfo.main.temp_max.toString()
        min.text=dataInfo.main.temp_min.toString()
        temp.text= dataInfo.main.temp.toString()
        mile.text=dataInfo.wind.speed.toString()
    }
    }

    override fun getItemCount(): Int {
        return week.list.size
    }
}
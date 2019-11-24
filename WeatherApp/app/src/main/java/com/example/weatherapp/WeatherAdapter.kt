package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_weather.view.*

class ModelAdapter(private val model: List<Model>) :
    RecyclerView.Adapter<WeatherHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): WeatherHolder {
        return WeatherHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.item_weather,
                viewGroup,
                false
            )
        )
    }

    override fun getItemCount() = model.size

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bindModel(model[position])
        //holder.bindCurrent(current[position])
    }
}

class WeatherHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val cityName = view.txt_city_name
    private val temperature = view.txt_tmp
    private val tempImg = view.img_view

    fun bindModel(model: Model) {
        cityName.text = model.location.name
        temperature.text = model.current.temperature
        setImgCard(model.current.weather_icons)
    }

    private fun setImgCard(url: List<String>) {
        var strURL = url.toString().replace("[","").replace("]","")
        Glide.with(tempImg)
            .load(strURL)
            .into(tempImg)
    }

}
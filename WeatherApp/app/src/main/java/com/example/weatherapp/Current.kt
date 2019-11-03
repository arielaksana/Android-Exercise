package com.example.weatherapp

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("temperature") val temperature: String,
    @SerializedName("weather_icons") val weather_icons: List<String>,
    @SerializedName("weather_descriptions") val weather_description: List<String>
)

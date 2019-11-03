package com.example.weatherapp

import com.google.gson.annotations.SerializedName

object Model {

    data class ResultTemperature(@SerializedName("current")val current: ModelCurrent.Current)

    data class ResultLocation(@SerializedName("location")val location: Location)
    data class Location(@SerializedName("name")val name: String)
}
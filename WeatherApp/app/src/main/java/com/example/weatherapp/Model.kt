package com.example.weatherapp

import com.google.gson.annotations.SerializedName

data class Model (
    @SerializedName("current")val current: Current,
    @SerializedName("location")val location: Location
)
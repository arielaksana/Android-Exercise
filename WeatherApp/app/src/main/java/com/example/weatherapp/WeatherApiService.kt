package com.example.weatherapp

import io.reactivex.Observable
import retrofit2.http.Query
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


interface WeatherApiService {
    @GET("current")
    fun returnWeather(@Query("access_key") access_key: String,
                      @Query("query") query: String):
            Observable<Model.ResultTemperature>

    @GET("current")
    fun returnLocation(@Query("access_key") access_key: String,
                       @Query("query") query: String):
            Observable<Model.ResultLocation>


    companion object {
        fun create() : WeatherApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.weatherstack.com/")
                .build()

            return retrofit.create(WeatherApiService::class.java)
        }
    }
}
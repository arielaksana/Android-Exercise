package com.example.weatherapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.bumptech.glide.Glide
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private var disposable: Disposable?= null

    private val weatherApiServe by lazy {
        WeatherApiService.create()
    }

    val API_KEY:String = "bcc5536aa9d064ed3d3b6472a6a6bf9a"
    var Query:String = "Jakarta"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeather()
    }

    private fun getWeather() {
        disposable =
            weatherApiServe.returnWeather(API_KEY,Query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    main_temperature.text = "${result.current.temperature}°"
                    city_text.text = "${result.location.name}"
                    weather_desc.text = "${result.current.weather_description.toString().replace("[","").replace("]","")}"
                    val url = result.current.weather_icons.toString().replace("[","").replace("]","")
                    setMainImg(url)
                }
    }

    private fun setMainImg(url:String) {
        Glide.with(this)
            .load(url)
            .into(image_weather_view)
    }

}

package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
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

                    val listLocation = listOf(
                        Model(Current(temperature = "${result.current.temperature}°",
                                      weather_icons = result.current.weather_icons,
                                      weather_description = result.current.weather_description),
                              Location(name = result.location.name))
                    )

                    val rvAdapter = ModelAdapter(listLocation)

                    rv_main.apply {
                        layoutManager = GridLayoutManager(this@MainActivity, 2)
                        adapter = rvAdapter
                    }
                }
    }

    private fun setMainImg(url:String) {
        Glide.with(this)
            .load(url)
            .into(image_weather_view)
    }

}

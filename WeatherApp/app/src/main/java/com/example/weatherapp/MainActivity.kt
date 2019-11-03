package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        getLocation()
        getWeatherDesc()
        //setMainImg()
        getWeatherIcon()
        getLocationFrame1()
        getLocationFrame2()
        getLocationFrame3()
        getLocationFrame4()

        getWeatherIconFrame1()
        getWeatherFrame1()

        getWeatherIconFrame2()
        getWeatherFrame2()

        getWeatherIconFrame3()
        getWeatherFrame3()

        getWeatherIconFrame4()
        getWeatherFrame4()



    }

    private fun getWeather() {
        disposable =
            weatherApiServe.returnWeather(API_KEY,Query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> main_temperature.text = "${result.current.temperature}°"}
                )
    }

    private fun getLocation() {
        disposable =
            weatherApiServe.returnLocation(API_KEY, Query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {result -> city_text.text = "${result.location.name}"}
                )
    }

    private fun getWeatherDesc() {
        disposable =
            weatherApiServe.returnWeather(API_KEY,Query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> weather_desc.text = "${result.current.weather_description.toString().replace("[","").replace("]","")}"}
                    )
    }



    private fun getWeatherIcon() {
        disposable =
            weatherApiServe.returnWeather(API_KEY,Query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> var url = result.current.weather_icons.toString().replace("[","").replace("]","")
                    setMainImg(url)
                }
    }

    private fun getLocationFrame1() {
        disposable =
            weatherApiServe.returnLocation(API_KEY,Query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    result -> textView1.text = result.location.name
                }
    }

    private fun getLocationFrame2() {
        disposable =
            weatherApiServe.returnLocation("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                        result -> textView2.text = result.location.name
                }
    }


    private fun getLocationFrame3() {
        disposable =
            weatherApiServe.returnLocation("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                        result -> textView3.text = result.location.name
                }
    }


    private fun getLocationFrame4() {
        disposable =
            weatherApiServe.returnLocation("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                        result -> textView4.text = result.location.name
                }
    }

    private fun getWeatherIconFrame1() {
        disposable =
            weatherApiServe.returnWeather("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> var url = result.current.weather_icons.toString().replace("[","").replace("]","")
                    setMainImgFrame1(url)
                }
    }

    private fun getWeatherFrame1() {
        disposable =
            weatherApiServe.returnWeather("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> textViewFrame1.text = "${result.current.temperature}°"}
                )
    }

    private fun getWeatherIconFrame2() {
        disposable =
            weatherApiServe.returnWeather("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> var url = result.current.weather_icons.toString().replace("[","").replace("]","")
                    setMainImgFrame2(url)
                }
    }

    private fun getWeatherFrame2() {
        disposable =
            weatherApiServe.returnWeather("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> textViewFrame2.text = "${result.current.temperature}°"}
                )
    }

    private fun getWeatherIconFrame3() {
        disposable =
            weatherApiServe.returnWeather("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> var url = result.current.weather_icons.toString().replace("[","").replace("]","")
                    setMainImgFrame3(url)
                }
    }

    private fun getWeatherFrame3() {
        disposable =
            weatherApiServe.returnWeather("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> textViewFrame3.text = "${result.current.temperature}°"}
                )
    }

    private fun getWeatherIconFrame4() {
        disposable =
            weatherApiServe.returnWeather("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> var url = result.current.weather_icons.toString().replace("[","").replace("]","")
                    setMainImgFrame4(url)
                }
    }

    private fun getWeatherFrame4() {
        disposable =
            weatherApiServe.returnWeather("bcc5536aa9d064ed3d3b6472a6a6bf9a","Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> textViewFrame4.text = "${result.current.temperature}°"}
                )
    }



    private fun setMainImg(url:String) {
        Glide.with(this)
            .load(url)
            .into(image_weather_view)
    }

    private fun setMainImgFrame1(url:String) {
        Glide.with(this)
            .load(url)
            .into(imageViewFrame1)
    }

    private fun setMainImgFrame2(url:String) {
        Glide.with(this)
            .load(url)
            .into(imageViewFrame2)
    }

    private fun setMainImgFrame3(url:String) {
        Glide.with(this)
            .load(url)
            .into(imageViewFrame3)
    }

    private fun setMainImgFrame4(url:String) {
        Glide.with(this)
            .load(url)
            .into(imageViewFrame4)
    }

}

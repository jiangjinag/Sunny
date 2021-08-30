package com.example.caiyun.model



import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object NetWorkModel {


     fun PlaceService(query:String) = WeatherNetWork.placeService(query)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


    fun DailyWeather(lng:String,lat:String) = WeatherNetWork.getDailyWeather(lng, lat)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


    fun RealtimeWeather(lng:String,lat:String) = WeatherNetWork.getRealtimeWeather(lng, lat)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


}
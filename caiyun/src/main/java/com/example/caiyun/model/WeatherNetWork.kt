package com.example.caiyun.model


object WeatherNetWork {

    private val retrofitUtils = RetrofitUtils.create(Api::class.java)

     fun getDailyWeather(lng:String,lat:String) = retrofitUtils.getDailyWeather(lng, lat)

     fun getRealtimeWeather(lng: String,lat: String) = retrofitUtils.getRealtimeWeather(lng, lat)

     fun placeService(query:String) = retrofitUtils.searchPlaces(query)








}
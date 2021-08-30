package com.example.caiyun.model

import com.example.caiyun.App
import com.example.caiyun.model.entity.ForecastWeather
import com.example.caiyun.model.entity.PlaceEntity
import com.example.caiyun.model.entity.RealtimeWeather
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    companion object{
        val BASE_URL = "https://api.caiyunapp.com/"
    }

    @GET("v2/place?token=${App.Token}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String):Observable<PlaceEntity>

    @GET("v2.5/${App.Token}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String): Observable<RealtimeWeather>

    @GET("v2.5/${App.Token}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Observable<ForecastWeather>





}
package com.example.caiyun.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.caiyun.model.NetWorkModel
import com.example.caiyun.model.entity.ForecastWeather
import com.example.caiyun.model.entity.PlaceEntity
import com.example.caiyun.model.entity.RealtimeWeather
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class WeatherViewModel:ViewModel() {

    lateinit var lisener1: MyDailyChangelisent;
    lateinit var lisener2: MyRealtimeChangelisent;

    fun RealtimeWeather(lng:String,lat:String){
        NetWorkModel.RealtimeWeather(lng, lat)
            .subscribe(object :Observer<RealtimeWeather>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: RealtimeWeather) {
                    if (lisener2 != null){
                        lisener2.getK(t)
                    }
                }

                override fun onError(e: Throwable) {
                    Log.i("TAG", "onSubscribe: +++++++++++++++++++++++++++++++"+e.message)
                }

                override fun onComplete() {

                }

            })

    }


    fun DailyWeather(lng:String,lat:String){
        NetWorkModel.DailyWeather(lng, lat)
            .subscribe(object :Observer<ForecastWeather>{
                override fun onSubscribe(d: Disposable) {

                    Log.i("TAG", "onSubscribe: +++++++++++++++++++++++++++++++")
                }

                override fun onNext(t: ForecastWeather) {
                    Log.i("TAG", "onNext: +++++++++++++++++++++++++++++++")
                    if (lisener1 != null){
                        Log.i("TAG", "onNext -------")
                        lisener1.getT(t)
                    }
                }

                override fun onError(e: Throwable) {

                    Log.i("TAG", "onSubscribe: +++++++++++++++++++++++++++++++"+e.message)
                }

                override fun onComplete() {

                }

            })
    }


    interface MyDailyChangelisent{
        fun getT(T:ForecastWeather){
            Log.i("TAG", "getT: +++++++++++++++++++++++++++++++")
        }

    }


    interface MyRealtimeChangelisent{
        fun getK(T:RealtimeWeather){
            Log.i("TAG", "getT: +++++++++++++++++++++++++++++++")
        }
    }



}
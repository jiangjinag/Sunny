package com.example.caiyun.view

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caiyun.R
import com.example.caiyun.adapter.ForecastAdapter
import com.example.caiyun.adapter.TemperatureAdapter
import com.example.caiyun.model.entity.ForecastWeather
import com.example.caiyun.model.entity.RealtimeWeather
import com.example.caiyun.viewmodel.WeatherViewModel
import com.sunnyweather.android.logic.model.getSky
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.forecast.*
import kotlinx.android.synthetic.main.fragment_place.*
import kotlinx.android.synthetic.main.life_index.*
import kotlinx.android.synthetic.main.now.*

class HomeActivity : AppCompatActivity() ,WeatherViewModel.MyDailyChangelisent,WeatherViewModel.MyRealtimeChangelisent{
    val viewModel by lazy { ViewModelProviders.of(this).get(WeatherViewModel::class.java) }
    lateinit var forecastAdapter: ForecastAdapter
    lateinit var temperatureAdapter: TemperatureAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT
        }
        setContentView(R.layout.activity_home)

        init()

        swipeRefresh.setOnRefreshListener {
            init()
            swipeRefresh.isRefreshing = false
        }







    }

    private fun init() {
        val sharedPreferences = getSharedPreferences("lng", 0)
        val lng = sharedPreferences.getString("lng", "")
        val lat = sharedPreferences.getString("lat", "")
        val placename = sharedPreferences.getString(" placename", "")

        if (lng==""||lat==""){
            val lng = intent.getDoubleExtra("lng",0.0).toString()
            val lat = intent.getDoubleExtra("lat",0.0).toString()
            val place = intent.getStringExtra("place")
            viewModel.RealtimeWeather(lng,lat)
            viewModel.DailyWeather(lng, lat)
            viewModel.lisener1 = this
            viewModel.lisener2 = this
            placeName.text ="${place}"
            Log.i("place", "init: "+place)

        }else{
            viewModel.RealtimeWeather(lng!!,lat!!)
            viewModel.DailyWeather(lng, lat)
            viewModel.lisener1 = this
            viewModel.lisener2 = this
            placeName.text = "${placename}"
            Log.i("placeName", "init: "+placename)
        }


    }

    override fun getT(T: ForecastWeather) {
        coldRiskText.text = T.result.daily.life_index.coldRisk[0].desc
        dressingText.text = T.result.daily.life_index.dressing[0].desc
        ultravioletText.text = T.result.daily.life_index.ultraviolet[0].desc
        carWashingText.text = T.result.daily.life_index.carWashing[0].desc
        weatherLayout.visibility = View.VISIBLE

        temperatureAdapter = TemperatureAdapter()
        temperatureAdapter.setNewInstance(T.result.daily.temperature)

        forecastAdapter = ForecastAdapter()
        forecastAdapter.setNewInstance(T.result.daily.skycon)


        val layoutManager1 = LinearLayoutManager(this)

        forecastrv.layoutManager = layoutManager1
        val layoutManager2 = LinearLayoutManager(this)
        temperature_rv.layoutManager = layoutManager2
        forecastrv.adapter = forecastAdapter
        temperature_rv.adapter = temperatureAdapter


    }

    override fun getK(T: RealtimeWeather) {

        Log.i("TAG", "getT: +++++++++++++++++++")
        val skycon = T.result.realtime.skycon
        val sky = getSky(skycon)
        nowLayout.setBackgroundResource(sky.bg)
        currentTemp.text = "${T.result.realtime.temperature}℃"
        currentSky.text = sky.info
        currentAQI.text = "空气质量: ${T.result.realtime.air_quality.description.chn}"


    }


    override fun onPause() {
        super.onPause()
        finish()
    }



}
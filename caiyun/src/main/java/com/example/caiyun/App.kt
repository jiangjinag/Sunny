package com.example.caiyun

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.Toast

class App:Application() {

    companion object{
        const val Token = "smy8RjxpEu0zhvLi"
        @SuppressLint("StaticFiledLeak")
        lateinit var context: Context
    }



    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        Toast.makeText(this, "关怀不是今天才开始，关心也不是今天就结束", Toast.LENGTH_SHORT).show()

    }


}
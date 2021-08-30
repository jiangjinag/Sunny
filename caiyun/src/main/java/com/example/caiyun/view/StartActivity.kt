package com.example.caiyun.view

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.caiyun.MainActivity
import com.example.caiyun.R
import java.util.*
import kotlin.concurrent.timerTask

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT
        }
        setContentView(R.layout.activity_start)



        val place = getSharedPreferences("lng", 0)
            .getBoolean("place", false)







        kotlin.run {

            val timer = Timer()
            timer.schedule(timerTask {
                if (place){
                    val intent = Intent(this@StartActivity, HomeActivity::class.java)
                    startActivity(intent)
                    timer.cancel()
                }else{
                    val intent = Intent(this@StartActivity, MainActivity::class.java)
                    startActivity(intent)
                    timer.cancel()
                }
            },2000,2000)

        }






    }


    override fun onPause() {
        super.onPause()
        finish()
    }

}
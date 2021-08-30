package com.example.caiyun.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.caiyun.R
import com.example.caiyun.model.entity.ForecastWeather
import com.sunnyweather.android.logic.model.Sky
import com.sunnyweather.android.logic.model.getSky

class ForecastAdapter:BaseQuickAdapter<ForecastWeather.ResultBean.DailyBean.SkyconBean,BaseViewHolder>(
    R.layout.forecast_item) {
    override fun convert(
        holder: BaseViewHolder,
        item: ForecastWeather.ResultBean.DailyBean.SkyconBean
    ) {
        val substring = item.date.substring(0, 10)
        holder.setText(R.id.dateInfo,substring)
        val sky = getSky(item.value)
        val skyIcon = holder.getView<ImageView>(R.id.skyIcon)
        skyIcon.setImageResource(sky.icon)
        holder.setText(R.id.skyInfo,sky.info)


    }
}
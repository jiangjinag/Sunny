package com.example.caiyun.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.caiyun.R
import com.example.caiyun.model.entity.ForecastWeather

class TemperatureAdapter:BaseQuickAdapter<ForecastWeather.ResultBean.DailyBean.TemperatureBean,BaseViewHolder>(
    R.layout.temp_item) {
    override fun convert(
        holder: BaseViewHolder,
        item: ForecastWeather.ResultBean.DailyBean.TemperatureBean
    ) {
        holder.setText(R.id.temperatureInfo,"${item.min.toString().substring(0,2)}~${item.max.toString().substring(0,2)}")
    }
}
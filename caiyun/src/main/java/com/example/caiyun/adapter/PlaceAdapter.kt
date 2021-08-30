package com.example.caiyun.adapter


import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.edit
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.caiyun.R
import com.example.caiyun.model.entity.PlaceEntity
import com.example.caiyun.view.HomeActivity

class PlaceAdapter() : BaseQuickAdapter<PlaceEntity.PlacesBean, BaseViewHolder>(R.layout.place_item){
    override fun convert(holder: BaseViewHolder, item: PlaceEntity.PlacesBean) {
        holder.setText(R.id.placeName,item.name)
        holder.setText(R.id.placeAddress,item.formatted_address)

        holder.itemView.setOnClickListener {

            Toast.makeText(context, "${item.name}", Toast.LENGTH_SHORT).show()
            context.getSharedPreferences("lng",0).edit {
                putBoolean("place",true)
                putString("placename","${item.name}")
                putString("lng",item.location.lng.toString())
                putString("lat",item.location.lat.toString())
                    .commit()
            }

            val intent = Intent(context, HomeActivity::class.java)
            intent.putExtra("lng",item.location.lng)
            intent.putExtra("lat",item.location.lat)
            intent.putExtra("place","${item.name}")
            context.startActivity(intent)

        }

    }

}
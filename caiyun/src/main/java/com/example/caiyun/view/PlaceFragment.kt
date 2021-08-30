package com.example.caiyun.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caiyun.R
import com.example.caiyun.adapter.PlaceAdapter
import com.example.caiyun.model.entity.PlaceEntity
import com.example.caiyun.viewmodel.PlaceViewModel
import kotlinx.android.synthetic.main.fragment_place.*


class PlaceFragment : Fragment(),PlaceViewModel.MydataChangelisent {

    val viewModel by lazy { ViewModelProviders.of(this).get(PlaceViewModel::class.java) }
    private lateinit var adapter:PlaceAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.lisener = this
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        adapter = PlaceAdapter()
        recyclerView.adapter = adapter
        searchPlaceEdit.addTextChangedListener {
            adapter.notifyDataSetChanged()
            val text = it.toString()
            if (text.isNotEmpty()){
                placebetwork(text)
            }else{
                recyclerView.visibility = View.GONE
                bgImageView.visibility = View.VISIBLE
                adapter.notifyDataSetChanged()
            }
        }



    }

    private  fun placebetwork(text: String) {
        recyclerView.visibility = View.VISIBLE
        bgImageView.visibility = View.GONE
            viewModel.Place(text)



    }

    override fun getT(T: ArrayList<PlaceEntity.PlacesBean>) {
        if (T!=null){
            adapter.setNewInstance(T)
            adapter.notifyDataSetChanged()
        }else{
            Toast.makeText(context, "无数据", Toast.LENGTH_SHORT).show()
        }


    }


}
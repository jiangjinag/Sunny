package com.example.caiyun.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.caiyun.model.NetWorkModel
import com.example.caiyun.model.entity.PlaceEntity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class PlaceViewModel:ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

         lateinit var lisener:MydataChangelisent;

         fun Place(query:String){
             NetWorkModel.PlaceService(query)
            .subscribe(object :Observer<PlaceEntity>{
                override fun onSubscribe(d: Disposable) {
                    Log.i("jhc", "onSubscribe: ")
                }

                override fun onNext(t: PlaceEntity) {

                    if (t.status.equals("ok")){
                        lisener.getT(t.places as ArrayList<PlaceEntity.PlacesBean>)
                    }


                }

                override fun onError(e: Throwable) {
                    Log.i("jhc", "onError: ")
                }

                override fun onComplete() {
                    Log.i("jhc", "onComplete: ")
                }

            })
    }


    interface MydataChangelisent{
        fun getT(T:ArrayList<PlaceEntity.PlacesBean>)
    }


}
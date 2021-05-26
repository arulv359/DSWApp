package com.arul.dswcodingexercise.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arul.dswcodingexercise.model.Bag
import com.arul.dswcodingexercise.net.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val shoppingBagSetterGetter = MutableLiveData<Bag>()

    fun getServicesApiCall(): MutableLiveData<Bag> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object : Callback<Bag> {
            override fun onFailure(call: Call<Bag>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<Bag>,
                response: Response<Bag>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()

                if (data != null) {
                    shoppingBagSetterGetter.value = Bag(data.products, data.promos, data.summary)
                }
            }
        })

        return shoppingBagSetterGetter
    }
}
package com.arul.dswcodingexercise.net

import com.arul.dswcodingexercise.model.Bag
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("bag")
    fun getServices() : Call<Bag>

}
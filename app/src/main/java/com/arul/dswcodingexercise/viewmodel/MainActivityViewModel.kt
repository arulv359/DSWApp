package com.arul.dswcodingexercise.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arul.dswcodingexercise.model.Bag
import com.arul.dswcodingexercise.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var shoppingBagLiveData: MutableLiveData<Bag>? = null

    fun getBag(): LiveData<Bag>? {
        shoppingBagLiveData = MainActivityRepository.getServicesApiCall()
        return shoppingBagLiveData
    }

}
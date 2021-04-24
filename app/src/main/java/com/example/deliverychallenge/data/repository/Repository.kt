package com.example.deliverychallenge.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.deliverychallenge.Utils.Coroutines

import com.example.deliverychallenge.data.models.deleviryResponse.DeliveryResponseItem
import com.example.deliverychallenge.data.network.MyApi

class Repository(
    private val api: MyApi

) : SafeApiRequest() {

    private val deliveries = MutableLiveData<DeliveryResponseItem>()



    suspend fun getDeliveries() = apiRequest { api.getDelivery() }




}
package com.example.deliverychallenge.data.network

import com.example.deliverychallenge.data.models.deleviryResponse.DeliveryResponseItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("/v2/deliveries")
    suspend fun getDelivery(@Query("offset") offset:Int ,@Query("limit") limit:Int) : Response<List<DeliveryResponseItem>>


    companion object{
        operator fun invoke() : MyApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://mock-api-mobile.dev.lalamove.com")
                .build()
                .create(MyApi::class.java)
        }
    }
}
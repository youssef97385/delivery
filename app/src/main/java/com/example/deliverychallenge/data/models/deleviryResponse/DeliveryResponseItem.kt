package com.example.deliverychallenge.data.models.deleviryResponse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DeliveryResponseItem(
    @PrimaryKey(autoGenerate = false)
    val deliveryFee: String,
    val goodsPicture: String,
    val id: String,
    val pickupTime: String,
    val remarks: String,
    val route: Route,
    val sender: Sender,
    val surcharge: String
)
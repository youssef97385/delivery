package com.example.deliverychallenge.ui.deliveries

import android.view.View
import com.example.deliverychallenge.data.models.deleviryResponse.DeliveryResponseItem

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, delivery: DeliveryResponseItem)
}
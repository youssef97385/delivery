package com.example.deliverychallenge.ui.deliveries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverychallenge.R
import com.example.deliverychallenge.data.models.deleviryResponse.DeliveryResponseItem
import com.example.deliverychallenge.databinding.DeleviryItemBinding

class RecyclerAdapter (
    private val deliveries: List<DeliveryResponseItem>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<RecyclerAdapter.DeliveryViewHolder>(){

    override fun getItemCount() = deliveries.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DeliveryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.deleviry_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.deliveryViewBinding.delivery = deliveries[position]
//        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener {
//            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.buttonBook, movies[position])
//        }
        holder.deliveryViewBinding.deliveryItem.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.deliveryViewBinding.deliveryItem, deliveries[position])
        }
    }


    inner class DeliveryViewHolder(
        val deliveryViewBinding: DeleviryItemBinding
    ) : RecyclerView.ViewHolder(deliveryViewBinding.root)

}
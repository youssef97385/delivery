package com.example.deliverychallenge.ui.DeliveryDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.deliverychallenge.R
import com.example.deliverychallenge.data.models.deleviryResponse.DeliveryResponseItem
import com.example.deliverychallenge.data.models.deleviryResponse.Route
import com.example.deliverychallenge.data.models.deleviryResponse.Sender
import com.example.deliverychallenge.data.repository.ApiException
import com.example.deliverychallenge.databinding.ActivityDeliveryDetailsBinding
import com.example.deliverychallenge.ui.deliveries.DeliveryViewModel
import kotlinx.android.synthetic.main.activity_delivery_details.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

import org.kodein.di.generic.instance
import java.lang.Exception

class DeliveryDetails : AppCompatActivity() , KodeinAware {

    override val kodein by kodein()
    private lateinit var viewModel: DeliveryDetailsViewModel
    private val factory: DeliveryDetailViewModelFactory by instance()
    private lateinit var binding: ActivityDeliveryDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_details)

//        viewModel = ViewModelProvider(this, factory).get(DeliveryDetailsViewModel::class.java)

        val id=intent.getStringExtra("Username")
        val start=intent.getStringExtra("from")
        val end=intent.getStringExtra("to")
        val image=intent.getStringExtra("image")
        val fee=intent.getStringExtra("fee")

        feeId.text = fee;
        fromId.text=start
        toId.text = end
        Glide.with(this)
            .load(image)
            .into(goodsImage)


    }


}



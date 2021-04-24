package com.example.deliverychallenge.ui.deliveries

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliverychallenge.R
import com.example.deliverychallenge.data.network.MyApi
import androidx.lifecycle.Observer
import com.example.deliverychallenge.data.models.deleviryResponse.DeliveryResponseItem
import com.example.deliverychallenge.data.repository.Repository
import com.example.deliverychallenge.ui.DeliveryDetails.DeliveryDetails

import kotlinx.android.synthetic.main.main_fragment.*


class DeliveryFragment : Fragment() ,RecyclerViewClickListener{


    private lateinit var factory: DeliveryViewModelFactory

    private lateinit var viewModel: DeliveryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.delivery_fragment, container, false)

//        var recycler = rootView.findViewById(R.id.recycler_delivery) as RecyclerView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)




        val api = MyApi()
        val repository = Repository(api)


        factory = DeliveryViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(DeliveryViewModel::class.java)
        viewModel.getDeliveries()
        viewModel.deliveries.observe(viewLifecycleOwner, Observer { deliveries ->
            recycler_delivery2.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = RecyclerAdapter(deliveries, this)
            }
        })



    }

    override fun onRecyclerViewItemClick(view: View, delivery: DeliveryResponseItem) {
        when(view.id){
            R.id.deliveryItem -> {

                val intent = Intent(context,DeliveryDetails::class.java)
                intent.putExtra("from",delivery.route.start)
                intent.putExtra("to",delivery.route.end)
                intent.putExtra("fee",delivery.deliveryFee)
                intent.putExtra("image",delivery.goodsPicture)
                intent.putExtra("id",delivery.id)
                startActivity(intent)
            }

        }
    }

}
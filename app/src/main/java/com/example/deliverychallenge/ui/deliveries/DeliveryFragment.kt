package com.example.deliverychallenge.ui.deliveries

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliverychallenge.R
import com.example.deliverychallenge.Utils.show
import com.example.deliverychallenge.data.models.deleviryResponse.DeliveryResponseItem
import com.example.deliverychallenge.data.network.MyApi
import com.example.deliverychallenge.data.repository.Repository
import com.example.deliverychallenge.ui.DeliveryDetails.DeliveryDetails
import kotlinx.android.synthetic.main.delivery_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.recycler_delivery2


class DeliveryFragment : Fragment() ,RecyclerViewClickListener{


    private lateinit var factory: DeliveryViewModelFactory

    private lateinit var viewModel: DeliveryViewModel

    var offset = 0
    var limit = 20



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

        scroll_view.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if(scrollY == v.getChildAt(0).measuredHeight-v.measuredHeight){
                limit+=20


                viewModel.getDeliveries(offset,limit)
                progress_bar.show()
            }
            //Do something
        })

        factory = DeliveryViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(DeliveryViewModel::class.java)
        viewModel.getDeliveries(offset,limit)
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
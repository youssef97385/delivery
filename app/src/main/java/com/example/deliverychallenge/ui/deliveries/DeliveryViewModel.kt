package com.example.deliverychallenge.ui.deliveries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliverychallenge.Utils.Coroutines
import com.example.deliverychallenge.data.models.deleviryResponse.DeliveryResponseItem
import com.example.deliverychallenge.data.repository.Repository
import kotlinx.coroutines.Job

class DeliveryViewModel(
    private val repository: Repository
) : ViewModel() {
    private lateinit var job: Job
    private val _deliveries = MutableLiveData<List<DeliveryResponseItem>>()
    val deliveries :LiveData<List<DeliveryResponseItem>>
    get()=_deliveries

     fun getDeliveries(){
        job = Coroutines.ioThenMain(
            {repository.getDeliveries()},
            {
                _deliveries.value = it
            }
        )

    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
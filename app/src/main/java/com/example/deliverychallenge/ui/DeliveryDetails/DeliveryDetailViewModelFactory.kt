package com.example.deliverychallenge.ui.DeliveryDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliverychallenge.data.repository.Repository
import com.example.deliverychallenge.ui.deliveries.DeliveryViewModel

@Suppress("UNCHECKED_CAST")
class DeliveryDetailViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DeliveryViewModel(repository) as T
    }
}
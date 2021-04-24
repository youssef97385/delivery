package com.example.deliverychallenge.ui.deliveries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliverychallenge.data.repository.Repository

@Suppress("UNCHECKED_CAST")
class DeliveryViewModelFactory (private val repository: Repository):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DeliveryViewModel(repository) as T
    }

}
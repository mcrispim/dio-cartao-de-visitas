package com.example.dio_cartodevisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dio_cartodevisitas.data.CartaoVisitaRepo
import com.example.dio_cartodevisitas.data.CartaoVisitas

class MainViewModel(private val cartaoRepo: CartaoVisitaRepo): ViewModel() {

    fun insert(cartao: CartaoVisitas) {
        cartaoRepo.insert(cartao)
    }

    fun getAll(): LiveData<List<CartaoVisitas>> {
        return cartaoRepo.getAll()
    }

}

class MainViewModelFactory(private val cartaoRepo: CartaoVisitaRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(cartaoRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
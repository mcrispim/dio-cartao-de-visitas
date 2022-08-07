package com.example.dio_cartodevisitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CartaoVisitaRepo(private val dao: CartaoVisitasDao) {

    fun insert(cartao: CartaoVisitas) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(cartao)
        }
    }

    fun getAll() = dao.getAll()

}
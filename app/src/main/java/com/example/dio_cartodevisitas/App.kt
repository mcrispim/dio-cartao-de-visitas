package com.example.dio_cartodevisitas

import android.app.Application
import com.example.dio_cartodevisitas.data.AppDatabase
import com.example.dio_cartodevisitas.data.CartaoVisitaRepo

class App: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
    val repository: CartaoVisitaRepo by lazy { CartaoVisitaRepo(database.cartaoVisitasDao()) }
}
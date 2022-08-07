package com.example.dio_cartodevisitas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartaoVisitas(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val telefone: String,
    val empresa: String,
    val email: String,
    val fundoPersonalizado: String
)

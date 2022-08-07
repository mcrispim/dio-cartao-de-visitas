package com.example.dio_cartodevisitas.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartaoVisitasDao {

    @Query("SELECT * FROM CartaoVisitas")
    fun getAll(): LiveData<List<CartaoVisitas>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cartao: CartaoVisitas)
}
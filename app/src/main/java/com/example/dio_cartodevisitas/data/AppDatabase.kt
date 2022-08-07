package com.example.dio_cartodevisitas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartaoVisitas::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun cartaoVisitasDao(): CartaoVisitasDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "CaratoVisitas_DB"
            ).build()
            INSTANCE = instance
            instance
        }

    }
}
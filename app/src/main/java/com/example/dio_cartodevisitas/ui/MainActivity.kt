package com.example.dio_cartodevisitas.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.example.dio_cartodevisitas.AddCartaoActivity
import com.example.dio_cartodevisitas.App
import com.example.dio_cartodevisitas.data.CartaoVisitas
import com.example.dio_cartodevisitas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getAllCartaoVisita()
        insertListener()
    }

    fun insertListener() {
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddCartaoActivity::class.java)
            startActivity(intent)
        }
    }

    fun getAllCartaoVisita() {
        mainViewModel.getAll().observe(this, { cards ->

        })
    }
}
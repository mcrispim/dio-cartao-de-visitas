package com.example.dio_cartodevisitas.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dio_cartodevisitas.App
import com.example.dio_cartodevisitas.databinding.ActivityMainBinding
import com.example.dio_cartodevisitas.util.Imagem

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { CartaoVisitaAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCartoes.adapter = adapter
        getAllCartaoVisita()
        insertListener()
    }

    fun insertListener() {
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddCartaoActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Imagem.share(this@MainActivity, card)
        }
    }

    fun getAllCartaoVisita() {
        mainViewModel.getAll().observe(this) { cards ->
            adapter.submitList(cards)
        }
    }
}
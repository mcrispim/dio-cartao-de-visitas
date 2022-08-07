package com.example.dio_cartodevisitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.dio_cartodevisitas.databinding.ActivityAddCartaoBinding
import com.example.dio_cartodevisitas.databinding.ActivityMainBinding

class AddCartaoActivity : AppCompatActivity() {

    private val binding by lazy {ActivityAddCartaoBinding.inflate(LayoutInflater.from(this))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
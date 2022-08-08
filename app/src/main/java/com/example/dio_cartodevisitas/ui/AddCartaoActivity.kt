package com.example.dio_cartodevisitas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import com.example.dio_cartodevisitas.App
import com.example.dio_cartodevisitas.R
import com.example.dio_cartodevisitas.data.CartaoVisitas
import com.example.dio_cartodevisitas.databinding.ActivityAddCartaoBinding
import com.example.dio_cartodevisitas.databinding.ActivityMainBinding

class AddCartaoActivity : AppCompatActivity() {

    private val binding by lazy {ActivityAddCartaoBinding.inflate(LayoutInflater.from(this))}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {

        binding.btConfirmar.setOnClickListener {
            val card = CartaoVisitas(
                nome = binding.tilNome.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(card)
            Toast.makeText(this, R.string.sucesso, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btClose.setOnClickListener {

        }
    }
}
package com.example.dio_cartodevisitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dio_cartodevisitas.data.CartaoVisitas
import com.example.dio_cartodevisitas.databinding.ItemCartaoVisitasBinding
import java.util.zip.Inflater

class CartaoVisitaAdapter: ListAdapter<CartaoVisitas, CartaoVisitaAdapter.ViewHolder> (DiffCallback()){

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartaoVisitasBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val itemBinding: ItemCartaoVisitasBinding): RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: CartaoVisitas) {
            itemBinding.tvNome.text = item.nome
            itemBinding.tvTelefone.text = item.telefone
            itemBinding.tvEmpresa.text = item.empresa
            itemBinding.tvEmail.text = item.email
            itemBinding.mcvContent.setBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            itemBinding.mcvContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

class DiffCallback: DiffUtil.ItemCallback<CartaoVisitas>() {

    override fun areItemsTheSame(oldItem: CartaoVisitas, newItem: CartaoVisitas) = oldItem == newItem

    override fun areContentsTheSame(oldItem: CartaoVisitas, newItem: CartaoVisitas) = oldItem.id == newItem.id

}
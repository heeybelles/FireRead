package com.example.fireauthapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fireauthapp.R
import com.example.fireauthapp.model.Produto
import java.util.Locale

class ProdutoAdapter(private val listaProdutos: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNome: TextView = itemView.findViewById(R.id.textNome)
        val textCategoria: TextView = itemView.findViewById(R.id.textCategoria)
        val textPreco: TextView = itemView.findViewById(R.id.textPreco)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = listaProdutos[position]
        holder.textNome.text = produto.nome
        holder.textCategoria.text = "Categoria: ${produto.categoria}"
        holder.textPreco.text = String.format(Locale("pt", "BR"), "R$ %.2f", produto.preco)
    }

    override fun getItemCount(): Int = listaProdutos.size
}

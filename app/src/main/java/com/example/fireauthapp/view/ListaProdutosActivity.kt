package com.example.fireauthapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fireauthapp.R
import com.example.fireauthapp.adapter.ProdutoAdapter
import com.example.fireauthapp.model.Produto
import com.google.firebase.firestore.FirebaseFirestore

class ListaProdutosActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var produtoAdapter: ProdutoAdapter
    private val listaProdutos = mutableListOf<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_produtos)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }

        recyclerView = findViewById(R.id.recyclerViewProdutos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        produtoAdapter = ProdutoAdapter(listaProdutos)
        recyclerView.adapter = produtoAdapter

        db = FirebaseFirestore.getInstance()

        carregarProdutos()
    }

    private fun carregarProdutos() {
        db.collection("Produtos")
            .get()
            .addOnSuccessListener { result ->
                listaProdutos.clear()
                for (document in result) {
                    val produto = document.toObject(Produto::class.java)
                    produto.id = document.id
                    listaProdutos.add(produto)
                }
                produtoAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Erro ao carregar: ${exception.message}", Toast.LENGTH_LONG).show()
            }
    }
}

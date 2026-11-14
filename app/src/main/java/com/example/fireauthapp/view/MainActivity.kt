package com.example.fireauthapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fireauthapp.R
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance()

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtCategoria = findViewById<EditText>(R.id.edtCategoria)
        val edtPreco = findViewById<EditText>(R.id.edtPreco)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnVerLista = findViewById<Button>(R.id.btnVerLista)

        btnSalvar.setOnClickListener {
            val nome = edtNome.text.toString().trim()
            val categoria = edtCategoria.text.toString().trim()
            val precoStr = edtPreco.text.toString().trim()

            if (nome.isNotEmpty() && categoria.isNotEmpty() && precoStr.isNotEmpty()) {
                val preco = precoStr.toDoubleOrNull() ?: 0.0

                val produtoMap = hashMapOf(
                    "nome" to nome,
                    "categoria" to categoria,
                    "preco" to preco
                )

                db.collection("Produtos")
                    .add(produtoMap)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                        edtNome.text.clear()
                        edtCategoria.text.clear()
                        edtPreco.text.clear()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Erro ao salvar: ${e.message}", Toast.LENGTH_LONG).show()
                    }
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

        btnVerLista.setOnClickListener {
            val intent = Intent(this, ListaProdutosActivity::class.java)
            startActivity(intent)
        }
    }
}

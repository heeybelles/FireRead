package com.example.fireauthapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fireauthapp.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtSenha = findViewById<EditText>(R.id.edtSenha)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val btnRecuperar = findViewById<Button>(R.id.btnRecuperar)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                            irParaTelaPrincipal()
                        } else {
                            Toast.makeText(this, "Erro no login: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Preencha e-mail e senha!", Toast.LENGTH_SHORT).show()
            }
        }

        btnCadastrar.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Conta cadastrada com sucesso!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Erro ao cadastrar: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Preencha e-mail e senha para cadastrar!", Toast.LENGTH_SHORT).show()
            }
        }

        btnRecuperar.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            if (email.isNotEmpty()) {
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "E-mail de recuperação enviado!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Erro ao enviar e-mail: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Digite seu e-mail acima para recuperar a senha!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun irParaTelaPrincipal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

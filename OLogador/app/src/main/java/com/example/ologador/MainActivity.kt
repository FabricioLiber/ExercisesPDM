package com.example.ologador

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etSenha: EditText
    private lateinit var btEntrar: Button
    private lateinit var btCancelar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etUsuario = findViewById(R.id.etUsuario)
        this.etSenha = findViewById(R.id.etSenha)
        this.btEntrar = findViewById(R.id.btLogin)
        this.btCancelar = findViewById(R.id.btCancelar)

        this.btEntrar.setOnClickListener({realizarLogin(it)})
        this.btCancelar.setOnClickListener({cancelarLogin(it)})
    }

    fun realizarLogin(view: View) {
        val usuario = this.etUsuario.text.toString()
        val senha = this.etSenha.text.toString()

        if (usuario.equals("ADMIN", true) and senha.equals("123")) {
            val intent = Intent()
            intent.putExtra("LOGIN", usuario)
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else {
            Toast.makeText(this, "Login não Encontrado!", Toast.LENGTH_SHORT).show()
        }
    }

    fun cancelarLogin(view: View) {
        finish()
    }

}

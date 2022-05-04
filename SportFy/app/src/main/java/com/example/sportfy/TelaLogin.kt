package com.example.sportfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaLogin : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var etSenha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        etEmail = findViewById(R.id.et_email_login)
        etSenha = findViewById(R.id.et_senha_login)
    }
    fun teste(v: View){
        val telaHome = Intent(baseContext, TelaHome::class.java)
        startActivity(telaHome)
    }
    fun realizarLogin(v: View) {
        val login = Login(
            etEmail.text.toString(),
            etSenha.text.toString()
        )

        val postLogin = SportyApi.criar().postLogin(login)

        postLogin.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                val telaHome = Intent(baseContext, TelaHome::class.java)
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, "Login realizado", Toast.LENGTH_SHORT).show()

                    startActivity(telaHome)
                } else {
                    Toast.makeText(baseContext, "Login n pode ser realizado" +
                            "", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(baseContext, "Erro na API", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun irParaCadastro(v: View){
        val telaCadastro = Intent(baseContext, TelaCadastro::class.java)
        startActivity(telaCadastro)
    }



}
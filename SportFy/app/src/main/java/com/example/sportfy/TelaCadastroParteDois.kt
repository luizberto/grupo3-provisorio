package com.example.sportfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaCadastroParteDois : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var etSenha: EditText
    lateinit var etConfirmSenha: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_parte_dois)

        etEmail = findViewById(R.id.et_email_cadastro)
        etSenha = findViewById(R.id.et_senha_cadastro)
        etConfirmSenha = findViewById(R.id.et_confirm_senha_cadastro)

    }

    fun realizarCadastro(v: View) {
        var nome = intent.getStringExtra("nome")
        var cpf = intent.getStringExtra("cpf")
        var dataNasc = intent.getStringExtra("dataNasc")

        if(etEmail.text.isEmpty()){
            Toast.makeText(baseContext, "Email não preenchido", Toast.LENGTH_SHORT).show()
            return
        }
        if(etSenha.text.toString() != etConfirmSenha.text.toString()){
            Toast.makeText(baseContext, "Senhas não coincidem", Toast.LENGTH_SHORT).show()
            return
        }

        val atleta = Atleta(
            cpf.toString(),
            nome.toString(),
            etEmail.text.toString(),
            etSenha.text.toString(),
            dataNasc.toString()
        )
        // objeto do endpoint de POST /filmes
        val postLogin = SportyApi.criar().postAtleta(atleta)

        postLogin.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, "Cadastro Realizado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(baseContext, "Cadastro não pode ser realizado" +
                            "", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(baseContext, "Erro na API", Toast.LENGTH_SHORT).show()
            }

        })
    }

}
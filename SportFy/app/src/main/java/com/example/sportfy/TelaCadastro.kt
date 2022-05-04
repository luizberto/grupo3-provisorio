package com.example.sportfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class TelaCadastro : AppCompatActivity() {

    lateinit var etNomeCompleto: EditText
    lateinit var etCpf: EditText
    lateinit var etDataNascimento: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)

        etNomeCompleto = findViewById(R.id.et_nome_completo_cadastro)
        etCpf = findViewById(R.id.et_cpf_cadastro)
        etDataNascimento = findViewById(R.id.et_data_nasc_cadastro)
    }

    fun irParaParteDois(v: View){

        if(etNomeCompleto.text.isEmpty()){
            Toast.makeText(baseContext, "Nome não preenchido", Toast.LENGTH_SHORT).show()
            return
        }else if(etCpf.text.isEmpty()){
            Toast.makeText(baseContext, "CPF Errado", Toast.LENGTH_SHORT).show()
            return
        }else if(etDataNascimento.text.isEmpty()){
            Toast.makeText(baseContext, "Data nascimento errado", Toast.LENGTH_SHORT).show()
            return
        }

        val telaCadastroDois = Intent(baseContext, TelaCadastroParteDois::class.java)

        telaCadastroDois.putExtra("nome", etNomeCompleto.text.toString())
        telaCadastroDois.putExtra("cpf", etCpf.text.toString())
        telaCadastroDois.putExtra("dataNasc", etDataNascimento.text.toString())

        startActivity(telaCadastroDois)

    }
}
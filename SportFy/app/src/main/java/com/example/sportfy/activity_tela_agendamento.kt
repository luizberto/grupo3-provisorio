package com.example.sportfy

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class activity_tela_agendamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_agendamento)

        val c = Calendar.getInstance()
        val ano = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)

        val button1 = findViewById<Button>(R.id.selecioneDataBtn)
        val data1 = findViewById<TextView>(R.id.dataTv)

        button1.setOnClickListener {
            val valor = DatePickerDialog (this, DatePickerDialog.OnDateSetListener { view, mAno, mMes, mDia ->
                data1.setText(""+ mDia + "/" + mMes + "/" + mAno)
            }, ano, mes, dia)
            valor.show()
        }
    }
}
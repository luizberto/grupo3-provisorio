package com.example.sportfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tela2 = Intent(this, TelaLogin::class.java)
        Handler().postDelayed({
            startActivity(tela2)
        }, 1500)

    }
}
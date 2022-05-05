package com.example.sportfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.FragmentContainerView

class TelaHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_home)
        val transaction = supportFragmentManager.beginTransaction()

        for(i in 1..4){

            val fragmento = FragmentContainerView(this)
            fragmento.id = View.generateViewId()
            findViewById<LinearLayout>(R.id.sv_quadras).addView(fragmento)


           transaction.add(fragmento.id, QuadraFragment::class.java, null)
        }

        transaction.commit()
    }



}
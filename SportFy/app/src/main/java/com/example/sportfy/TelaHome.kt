package com.example.sportfy

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaHome : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tela_home)

        val transaction = supportFragmentManager.beginTransaction()

        val getQuadra = SportyApi.criar().getQuadras()

        getQuadra.enqueue(object : Callback<List<Quadra>> {
            override fun onResponse(call: Call<List<Quadra>>, response: Response<List<Quadra>>) {
                if (response.isSuccessful) {
                    response.body()?.forEach { quadra ->


                        val argumentos = Bundle()

                        argumentos.putString("nome", quadra.nomeQuadra)
                        argumentos.putInt("id", quadra.idQuadra)
                        argumentos.putDouble("classificacao", quadra.classificacaoQuadra)
                        //argumentos.putString("imagem", quadra.foto)
                        val fragmento = FragmentContainerView(applicationContext)

                        fragmento.id = View.generateViewId()

                        findViewById<LinearLayout>(R.id.ll_quadras).addView(fragmento)

                        transaction.add(fragmento.id, QuadraFragment::class.java, argumentos)
                    }
                    transaction.commitAllowingStateLoss()
                }

                Toast.makeText(
                    baseContext, "Rodou" +
                            "", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<List<Quadra>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(baseContext, "Erro na API", Toast.LENGTH_SHORT).show()
            }


        })


    }
    fun abrirDescricao(id: Int){
        val telaDesc = Intent(baseContext, activity_tela_agendament::class.java)

        telaDesc.putExtra("id", id)
        startActivity(telaDesc)
    }



}
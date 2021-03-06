package com.example.sportfy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.fragment_quadra.view.*
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import android.util.Base64
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable


class QuadraFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quadra, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvNome: TextView = view.findViewById(R.id.tvNomeQuadra)
        val tvClassificacao: TextView = view.findViewById(R.id.tvClassificacao)
        // recuperando os argumentos enviados pela Activity
        val nome = arguments?.getString("nome")
        val id = arguments?.getInt("id")
        val classificacao = arguments?.getDouble("classificacao")

        //val imagem = arguments?.getString("imagem")

        //val image: ImageView = view.findViewById(R.id.cardImg) as ImageView
        //val imageBytes = Base64.decode(imagem, Base64.DEFAULT)

        //val bMap = imagem?.let { BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size) }
        //println(bMap)
        //image.setImageBitmap(bMap?.let { Bitmap.createScaledBitmap(it, 150, 100, false) });


        println(nome)

        tvClassificacao.text = classificacao.toString()
        tvNome.text = nome.toString()

        val card = view.findViewById(R.id.cardQuadra) as CardView

        card.setOnClickListener {
            if (id != null) {
                    (activity as TelaHome).abrirDescricao(id.toInt())

            }

        }
    }

}


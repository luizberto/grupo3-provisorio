package com.example.sportfy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alespero.expandablecardview.ExpandableCardView


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
        val tvTitle: ExpandableCardView = view.findViewById(R.id.cardQuadra)

        // recuperando os argumentos enviados pela Activity
        val nome = arguments?.getString("nome")


        tvTitle.setTitle(nome.toString())


    }

}


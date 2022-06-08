package com.example.sportfy

import java.util.*

data class Horario(
    val id: Int,
    val dataQuadra: String,
    val reserva: String,
    val fkQuadra: Quadra
)

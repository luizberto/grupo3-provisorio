package com.example.sportfy;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*

interface SportyApi {

    @GET("quadras")
    fun getQuadras(): Call<List<Quadra>> // Call do pacote retrofit2

    @GET("quadras/{id}")
    fun getQuadraById(@Path("id") id: Int): Call<Quadra>

    @DELETE("users/{id}")
    fun delete(@Path("id") id: Int): Call<Void>

    @POST("atletas/login")
    fun postLogin(@Body login: Login): Call<Void>

    @POST("atletas")
    fun postAtleta(@Body atleta: Atleta) : Call<Void>

    @GET("horarios/{id}")
    fun getHorarios(@Path("id") id: Int): Call<List<Horario>>

    // companion object serve para disponibilizar método estático
    companion object {
        var BASE_URL = "http://18.210.124.171:8080/"

        fun criar() : SportyApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(SportyApi::class.java)
        }
    }
}


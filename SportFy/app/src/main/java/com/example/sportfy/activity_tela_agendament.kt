package com.example.sportfy

import android.app.DatePickerDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.*
import androidx.fragment.app.FragmentContainerView
import kotlinx.android.synthetic.main.activity_tela_agendament.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.format.DateTimeFormatter
import java.util.*

class activity_tela_agendament : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_agendament)

        val tvDescricao: TextView = findViewById(R.id.tv_descricao_quadra)
        var id = intent.getIntExtra("id", 1)

        val getQuadraById = SportyApi.criar().getQuadraById(id)

        getQuadraById.enqueue(object : Callback<Quadra> {
            override fun onResponse(call: Call<Quadra>, response: Response<Quadra>) {
                val descricao = response.body()?.descQuadra
                val imagem = response.body()?.foto
                val image: ImageView = findViewById<ImageView>(R.id.iv_img)
                val imageBytes = Base64.decode(imagem, Base64.DEFAULT)

                val bMap = imagem?.let { BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size) }
                println(bMap)
                image.setImageBitmap(bMap?.let { Bitmap.createScaledBitmap(it, 150, 100, false) });

                tvDescricao.text = descricao


            }
            override fun onFailure(call: Call<Quadra>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(baseContext, "Erro na API", Toast.LENGTH_SHORT).show()
            }

        })

        val transaction = supportFragmentManager.beginTransaction()

        val getHorarioByQuadra = SportyApi.criar().getHorarios(id)

        getHorarioByQuadra.enqueue(object : Callback <List<Horario>>{
            override fun onResponse(call: Call<List<Horario>>, response: Response<List<Horario>>) {
                response.body()?.forEach { horario ->
                    val fragmento = FragmentContainerView(applicationContext)
                    val argumentos = Bundle()

                    val formatter = DateTimeFormatter.ofPattern("HH:mm")
                    val formatted = horario.dataQuadra.format(formatter)
                    argumentos.putString("horario", formatted)


                    fragmento.id = View.generateViewId()

                    findViewById<LinearLayout>(R.id.ll_horarios).addView(fragmento)

                    transaction.add(fragmento.id, FragmentBotao::class.java, argumentos)

                }
                transaction.commitAllowingStateLoss()
            }

            override fun onFailure(call: Call<List<Horario>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}






//val c = Calendar.getInstance()
//        val ano = c.get(Calendar.YEAR)
//        val mes = c.get(Calendar.MONTH)
//        val dia = c.get(Calendar.DAY_OF_MONTH)
//
//        val button1 = findViewById<Button>(R.id.selecioneDataBtn)
//        val data1 = findViewById<TextView>(R.id.dataTv)
//
//        button1.setOnClickListener {
//            val valor = DatePickerDialog (this, DatePickerDialog.OnDateSetListener { view, mAno, mMes, mDia ->
//                data1.setText(""+ mDia + "/" + mMes + "/" + mAno)
//            }, ano, mes, dia)
//            valor.show()
//        }
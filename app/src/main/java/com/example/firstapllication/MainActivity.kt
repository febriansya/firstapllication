package com.example.firstapllication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        inisialisasi komponen
        var tglLahir = findViewById<EditText>(R.id.tanggal_lahir)
        var butoon = findViewById<Button>(R.id.btn_click)
        var tampil = findViewById<TextView>(R.id.id_hasil)
        var goto2 = findViewById<Button>(R.id.goto2)

//        melakukan proses
        butoon.setOnClickListener {


            val input = tglLahir.text.toString()

            val hasil = when(input.toInt()){
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "X"
                in 1981..1995 ->"milineal"
                in 1996..2010 -> "z"
                else->"I dont know mas"
            }
            tampil.text = "kamu berada di dalam generasi $hasil"
        }
    }
    fun pindah(view: View) {
        var intent = Intent(this@MainActivity,MainActivity2::class.java)
        startActivity(intent)
    }
}
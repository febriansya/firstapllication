package com.example.firstapllication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth:EditText
    private lateinit var edtHeight:EditText
    private lateinit var edtLength:EditText
    private lateinit var btnCalculate:Button
    private lateinit var tvResult:TextView

    private lateinit var anotherApp:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

//        inisialisasi variabel
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        anotherApp = findViewById(R.id.anotherB)


        anotherApp.setOnClickListener{
            val itent = Intent(this@MainActivity2,anotherapp::class.java)
            startActivity(itent)
        }


//  menampilak hasil yang telah dismipan ketika layar di rotasi
        if (savedInstanceState != null){
            val result  = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
//        menggunakan interface untuk pemanggilan setOnclickListener
        btnCalculate.setOnClickListener(this)
    }

// fungsi untuk menyimpan hasil ketika layar di rotasi
    companion object{
        private const val STATE_RESULT = "state_result"
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        state result sebagai  ket dan tvresult sebagai value
        outState.putString(STATE_RESULT,tvResult.text.toString())
    }
    //akhir fungsi penyimpanan

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate) {
            val inputLenght = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyFields = false
            when {
                inputLenght.isEmpty() -> {
                    isEmptyFields = true
                    edtLength.error = "field ini tidak boleh kosong"
                }
                inputWidth.isEmpty() -> {
                    isEmptyFields = true
                    edtWidth.error = "field ini tidak boleh kosong"
                }
                inputHeight.isEmpty() -> {
                    isEmptyFields = true
                    edtHeight.error = "field ini tidak boleh kosong"
                }
            }
            if (!isEmptyFields) {
                val volume = inputLenght.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }

        }
    }
}
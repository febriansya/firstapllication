package com.example.firstapllication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.badge.BadgeUtils
import org.w3c.dom.Text

class anotherapp : AppCompatActivity(),View.OnClickListener {


    private lateinit var edt1:EditText
    private lateinit var edt2:EditText
    private lateinit var btt:Button
    private lateinit var hasil:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anotherapp)

     btt=findViewById(R.id.buttonr)
     edt1 =findViewById(R.id.kolom1)
     edt2 =findViewById(R.id.kolom2)
     hasil=findViewById(R.id.tvhasil)
        btt.setOnClickListener(this)


//        cek aapakah pada hasil tidak sama dengan null atau datanya tidak ada
//        fungsi save instance

        if (savedInstanceState != null){
            val result  =  savedInstanceState.getString(STATE_RESULT)
            hasil.text = result
        }

        supportActionBar?.hide()
    }

//    bagian dari save instance
    companion object{
        private const val STATE_RESULT = "state_result"
    }



    override fun onClick(v: View?) {

        if (v?.id == btt.id){

//            proses pengambilan data dari editText
            val angka1 = edt1.text.toString().trim()
            val angka2 = edt2.text.toString().trim()

//            kondisi awal pengecekan ada tidak adanya data
            var isEmptyFields = false
            when {

//                proses pengececekan
                angka1.isEmpty() -> {
                    isEmptyFields = true
                    edt1.error = "field ini tidak boleh kosong"
                }
                angka2.isEmpty() -> {
                    isEmptyFields = true
                    edt2.error = "field ini tidak boleh kosong"
                }

            }
            if (!isEmptyFields) {
                val volume = angka1.toLong() * angka2.toLong()
                hasil.text = volume.toString()
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,hasil.text.toString())
    }


}
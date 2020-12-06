package com.example.myapp.horas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_horas.*

class horasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horas)
        botonhrs.setOnClickListener {
            iniciar()
        }
    }

    private fun iniciar() {
        val numhoras=numhrs.text.toString().toIntOrNull()

        if(numhoras!=null){
            val semanas=(numhoras/168)
            val dias= (numhoras-(semanas*168))/24
            val horas=(numhoras-(semanas*168)-(dias*24))
            resultadohrs.text="$semanas SEMANAS $dias DIAS Y $horas HORAS"
        }
        else{
            Toast.makeText(this,"Error, algún valor es nulo", Toast.LENGTH_SHORT).show()
        }
    }
}

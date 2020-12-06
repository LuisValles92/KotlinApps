package com.example.myapp.suma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_suma.*

class sumaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)
        botonsumar.setOnClickListener {
            iniciarVistas()
        }
    }

    private fun iniciarVistas() {
        val num1=numero1.text.toString().toIntOrNull()
        val num2=numero2.text.toString().toIntOrNull()
        val num3=numero3.text.toString().toIntOrNull()

        if(num1!=null && num2!=null && num3!=null){
            val suma= num1+num2+num3
            resultadosuma.text=suma.toString()
        }
        else {
            Toast.makeText(this,"Error, algún valor es nulo", Toast.LENGTH_SHORT).show()
        }
    }
}

package com.example.myapp.juego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_juego.*

class juegoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        var notas = inicio()

        botonstart.setOnClickListener {

            Toast.makeText(this, "DALE", Toast.LENGTH_SHORT).show()

            var num = random.text.toString().toIntOrNull()
            var randomm = notas

            if (num != null) {
                if (num == randomm) resultadordm.text = "ACERTASTE!"
                if (num > randomm) resultadordm.text = "EL NUMERO RANDOM ES MENOR"
                if (num < randomm) resultadordm.text = "EL NUMERO RANDOM ES MAYOR"
            } else {
                Toast.makeText(this, "Introduce número", Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun inicio(): Int {
        var r = (0..100).random()
        return r
    }
}

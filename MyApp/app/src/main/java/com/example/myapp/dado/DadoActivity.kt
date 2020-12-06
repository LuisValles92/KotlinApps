package com.example.myapp.dado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_dado.*

class DadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dado)

        botontiramamut.setOnClickListener {

            val dado = arrayOf(1, 2, 3, 4, 5, 6)
            var r = (0..5).random()
            numdado.text = "${dado.get(r)}"

        }
    }
}

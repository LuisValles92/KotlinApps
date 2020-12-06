package com.example.myapp.Fragment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_fragment2.*

class Fragment2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment2)
        mostrarFragment()
    }

    private fun mostrarFragment() {
        btRosa.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, RosaFragment2())
                .commit()
        }
        btVerde.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.container, VerdeFragment()
            ).commit()
        }
    }
}

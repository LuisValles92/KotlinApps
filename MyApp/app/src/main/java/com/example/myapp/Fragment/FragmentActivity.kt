package com.example.myapp.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        mostrarFragment()
    }
    private fun mostrarFragment() {

        btRosa.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    PerfilFragment()
                )
                .commit()
        }

        btVerde.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    ListaFragment()
                )
                .commit()
        }
    }
}

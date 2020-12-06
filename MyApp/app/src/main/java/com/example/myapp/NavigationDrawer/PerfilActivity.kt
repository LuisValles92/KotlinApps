package com.example.myapp.NavigationDrawer

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_perfil.*
import kotlinx.android.synthetic.main.activity_perfil.dhFoto
import kotlinx.android.synthetic.main.drawer_header.*

class PerfilActivity : AppCompatActivity() {

    private lateinit var usuario: Perfil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        pintarDatosUsuario()

        botonguardar.setOnClickListener {
            val intent = Intent()
            usuario.correoUser = etEmail.text.toString()
            usuario.nombreUser = etNombre.text.toString()
            intent.putExtra("usuario", usuario)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun pintarDatosUsuario() {
        usuario = intent.extras?.getSerializable("usuario") as Perfil
        etEmail.setText(usuario.correoUser)
        etNombre.setText(usuario.nombreUser)
        Picasso.get().load(usuario.fotoURLUser).into(dhFoto)

    }
}

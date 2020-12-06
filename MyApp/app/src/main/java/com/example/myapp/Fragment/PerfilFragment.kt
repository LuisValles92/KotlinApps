package com.example.myapp.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapp.Fragment.usuarioGlobal.usuario
import com.example.myapp.NavigationDrawer.Perfil

import com.example.myapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_perfil.*

/**
 * A simple [Fragment] subclass.
 */
class PerfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_perfil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pintarDatosUsuario()
    }

    private fun pintarDatosUsuario() {

        etEmail.setText(usuario?.correoUser)
        etNombre.setText(usuario?.nombreUser)
        Picasso.get().load(usuario?.fotoURLUser).into(dhFoto)

    }

}

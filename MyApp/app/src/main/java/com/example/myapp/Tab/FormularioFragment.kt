package com.example.myapp.Tab


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import java.util.regex.Pattern

import com.example.myapp.R
import kotlinx.android.synthetic.main.fragment_formulario.*

/**
 * A simple [Fragment] subclass.
 */
class FormularioFragment : Fragment() {
    var EMAIL_REGEX = "[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_formulario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ffGuardar.setOnClickListener {
            var error = ""
            if (!checkRegex(ffCorreo.text.toString(), EMAIL_REGEX)) {
                error += "EMAIL INCORRECTO\n"
            }
            if (ffNombre.text.toString().count() <= 1) {
                error += "NOMBRE INCORRECTO\n"
            }
            if (ffContrasenia.text.toString().count() <= 4) {
                error += "CONTRASEÑA INCORRECTA\n"
            }
            if (error.isNotEmpty()) {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "TODO OK", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun checkRegex(field: String, regex: String): Boolean {
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(field)
        return matcher.matches()
    }

}

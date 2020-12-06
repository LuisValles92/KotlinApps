package com.example.myapp.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_registro.*
import java.util.regex.Pattern

class registroActivity : AppCompatActivity() {
    val TAG = "registroActivity"
    var EMAIL_REGEX = "[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}"
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        auth = FirebaseAuth.getInstance()
        botonfbRegistro.setOnClickListener {

            var error = ""
            if (fbNombre.text.toString().count() <= 1) {
                error += "*Nombre: Debe contener más de un caracter\n"
            }
            if (fbApellidos.text.toString().count() <= 1) {
                error += "*Apellidos: Debe contener más de un caracter\n"
            }
            if (!checkRegex(fbRegistroCorreo.text.toString(), EMAIL_REGEX)) {
                error += "*Email: Debe contener un @ y un punto, ejemplo: X@X.XX\n"
            }
            if (fbRegistroContrasenia.text.toString().count() <= 4) {
                error += "*Contraseña: Debe contener más de 4 caracteres con algún número\n"
            }
            if (fbRegistroRepetirContrasenia.text.toString()!=fbRegistroContrasenia.text.toString()) {
                error += "*Repetir contraseña: No coincide con el campo contraseña\n"
            }
            if (error.isNotEmpty()) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "REGISTRO COMPLETADO", Toast.LENGTH_SHORT).show()
                onSignup(
                    fbNombre.text.toString(),
                    fbApellidos.text.toString(),
                    fbRegistroCorreo.text.toString(),
                    fbRegistroContrasenia.text.toString(),
                    fbRegistroRepetirContrasenia.text.toString()
                )
            }


        }
    }

    private fun onSignup(
        nombre: String,
        apellidos: String,
        correo: String,
        contrasenia: String,
        repcontrasenia: String
    ) {
        auth.createUserWithEmailAndPassword(correo, contrasenia)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                    updateprofile(nombre, apellidos, user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "ERROR EN EL REGISTRO: EL CAMPO CONTRASEÑA NECESITA AL MENOS UN NÚMERO",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }

                // ...
            }

    }

    private fun updateprofile(nombre: String, apellidos: String, user: FirebaseUser?) {
        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName("$nombre $apellidos")
            .build()

        user?.updateProfile(profileUpdates)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "User profile updated.")
                    onBackPressed()
                    //val intent= Intent(this, firebaseActivity::class.java)
                    //startActivity(intent)
                }
            }
    }

    fun checkRegex(field: String, regex: String): Boolean {
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(field)
        return matcher.matches()
    }
}

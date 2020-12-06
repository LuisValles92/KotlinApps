package com.example.myapp.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_firebase.*
import java.util.regex.Pattern

class firebaseActivity : AppCompatActivity() {
    val TAG = "firebaseActivity"
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)

        auth = FirebaseAuth.getInstance()

        /*
        if (auth.currentUser != null) {
            val intent = Intent(this, homeActivity::class.java)
            startActivity(intent)
        }
         */

        botonfbAcceder.setOnClickListener {


            var error = ""
            if (fbCorreo.text.toString().isEmpty()) {
                error += "*Correo electrónico: Campo vacío\n"
            }
            if (fbContrasenia.text.toString().isEmpty()) {
                error += "*Contraseña: Campo vacío\n"
            }
            if (error.isNotEmpty()) {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            } else {
                val email = fbCorreo.text.toString()
                val contrasenia = fbContrasenia.text.toString()
                onLogin(email, contrasenia)
            }


        }
        botonfbRegist.setOnClickListener {
            val intent = Intent(this, registroActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onLogin(Email: String, Password: String) {
        auth.signInWithEmailAndPassword(Email, Password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "signInWithEmail:success")
                    //val user = auth.currentUser
                    //updateUI(user)
                    val intent = Intent(this, homeActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "ERROR EN EL INICIO DE SESIÓN",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }

                // ...
            }
    }

}

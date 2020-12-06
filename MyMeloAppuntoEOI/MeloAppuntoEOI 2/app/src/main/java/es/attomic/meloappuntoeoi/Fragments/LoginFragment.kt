package es.attomic.meloappuntoeoi.Fragments


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import es.attomic.meloappuntoeoi.DataHolder
import es.attomic.meloappuntoeoi.Navigation.NavigationChildFragment
import es.attomic.meloappuntoeoi.Navigation.NavigatorFragment

import es.attomic.meloappuntoeoi.R
import kotlinx.android.synthetic.main.fragment_login.*
import org.w3c.dom.Text

class LoginFragment : NavigationChildFragment() {

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("user")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ocultar el botón de atras
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // Titulo del fragment
        mainActivity.title = "Iniciar sesión"

        btnLogin.setOnClickListener {
            // Mostrar progress bar
            miProgressbar.visibility = View.VISIBLE
            Handler().postDelayed(
                {
                    login(txtEmail.text.toString(), txtPass.text.toString())
                },
                1000 // valor en milisegundos
            )
        }

        btnSignup.setOnClickListener {
            NavigatorFragment.replaceFragment(mainActivity, SignupFragment(), "Signup", true)
        }
    }

    fun login(email: String, pass: String){

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
            Toast.makeText(mainActivity, "Email o contraseña no validos.", Toast.LENGTH_SHORT).show()
            miProgressbar.visibility = View.INVISIBLE
            return
        }

        mAuth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(mainActivity) { task ->
                if (task.isSuccessful) {
                    // Login correcto
                    Log.d(DataHolder.TAG, "signInWithEmail:success")

                    goToHome()
                } else {
                    // Error en el login
                    Log.w(DataHolder.TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(mainActivity, "Email o contraseña no validos.", Toast.LENGTH_SHORT).show()
                    miProgressbar.visibility = View.INVISIBLE
                }


            }
    }

    fun goToHome() {
        NavigatorFragment.replaceFragment(mainActivity, BottomNavFragment(),"Todo", false)
    }


}

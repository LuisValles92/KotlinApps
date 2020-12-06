package es.attomic.meloappuntoeoi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import es.attomic.meloappuntoeoi.Fragments.BottomNavFragment
import es.attomic.meloappuntoeoi.Fragments.HomeFragment
import es.attomic.meloappuntoeoi.Fragments.LoginFragment
import es.attomic.meloappuntoeoi.Fragments.TodoFragment
import es.attomic.meloappuntoeoi.Navigation.NavigatorFragment
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        // Instancia el Toolbar
        setSupportActionBar(miToolbar)

        // Sombra en nuestro "Custom Toolbar"
        miToolbar.elevation = resources.getDimension(R.dimen.elevation_toolbar)

    }

    override fun onBackPressed() {
        // Si hay fragments en el stack (pila)
        if (supportFragmentManager.backStackEntryCount > 0) {
            // volver atras a nivel fragment
            supportFragmentManager.popBackStackImmediate()
        } else {
            // volver atras a nivel activity
            super.onBackPressed()
        }
    }


    override fun onStart() {
        super.onStart()

        // Comprueba si está logueado el usuario
        val currentUser = mAuth.currentUser
        Log.d(DataHolder.TAG, "Usuario logueado con email:${currentUser?.email}")

        if (currentUser?.email != null) {
            NavigatorFragment.replaceFragment(this, BottomNavFragment(), "todo", false)
        } else {
            NavigatorFragment.replaceFragment(this, LoginFragment(), "login", false)
        }

    }


}

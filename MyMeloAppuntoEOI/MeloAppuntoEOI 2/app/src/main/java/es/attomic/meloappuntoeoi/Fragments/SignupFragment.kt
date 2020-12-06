package es.attomic.meloappuntoeoi.Fragments


import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_signup.*


class SignupFragment : NavigationChildFragment() {

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("user")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        // Titulo del fragment
        mainActivity.title = "Crear nueva cuenta"

        btnRegister.setOnClickListener {

            createAccount(
                txtName.text.toString(),
                txtSurname.text.toString(),
                txtEmail.text.toString(),
                txtPass.text.toString()
            )

        }

    }

    fun validateRegister(): Boolean {
        var valid = true

        val email = txtEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            txtEmail.error = "Requerido"
            valid = false
        } else {
            txtEmail.error = null
        }

        val password = txtPass.text.toString()
        val password2 = txtPass2.text.toString()
        if (TextUtils.isEmpty(password) || password2 != password) {
            txtPass2.error = "La contraseña tiene que coincidir."
            valid = false
        } else {
            txtPass2.error = null
        }

        if(password.length < 6 || password2.length < 6){
            txtPass.error = "Mínimo 6 carácteres."
            valid = false
        } else {
            txtPass.error = null
        }

        val name = txtName.text.toString()
        if (TextUtils.isEmpty(name)) {
            txtName.error = "Requerido."
            valid = false
        } else {
            txtName.error = null
        }

        val surname = txtSurname.text.toString()
        if (TextUtils.isEmpty(surname)) {
            txtSurname.error = "Requerido."
            valid = false
        } else {
            txtSurname.error = null
        }

        return valid
    }


    private fun createAccount(name: String, surname: String, email: String, password: String) {

        if (!validateRegister()) {
            return
        }

        // Mostrar progressbar
        miProgressbar.visibility = View.VISIBLE

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(mainActivity) { task ->

            if (task.isSuccessful) {
                Log.d(DataHolder.TAG, "createUserWithEmail:success")

                val user = mAuth.currentUser

                // Guardar los datos en firebase
                val userCollection = myRef.child(user?.uid.toString())
                userCollection.child("Name").setValue(name)
                userCollection.child("Surname").setValue(surname)

                // Ir a la Home
                goToHome()
            } else {

                Log.w(DataHolder.TAG, "createUserWithEmail:failure", task.exception)

                Toast.makeText(mainActivity, "No se ha podido crear la cuenta.", Toast.LENGTH_SHORT).show()

                // Ocultar progressbar
                miProgressbar.visibility = View.INVISIBLE

            }

        }

    }

    fun goToHome() {
        NavigatorFragment.replaceFragment(mainActivity, BottomNavFragment(),"Todo", false)
    }
}

package es.attomic.meloappuntoeoi.Fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import es.attomic.meloappuntoeoi.DataHolder
import es.attomic.meloappuntoeoi.Models.User
import es.attomic.meloappuntoeoi.Navigation.NavigationChildFragment
import es.attomic.meloappuntoeoi.Navigation.NavigatorFragment
import es.attomic.meloappuntoeoi.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : NavigationChildFragment() {

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("user")
    lateinit var userRef: DatabaseReference
    lateinit var userListener: ValueEventListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Titulo del fragment
        mainActivity.title = "Perfil"

        // Ocultar el botón de atras
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)


        // Referencia al objeto de la base de datos
         userRef = myRef.child(mAuth.uid.toString())

        // Oyente de firebase para decirle que hacer en cada caso
         userListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val data = dataSnapshot.getValue(User::class.java)

                    val nombre = data?.Name
                    val apellido = data?.Surname

                    txtUserdata?.text = "$nombre $apellido"

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // No se han podido leer los datos
                Log.d(DataHolder.TAG, "userListener:failure")
            }
        }

        // Inicializamos el oyente
        userRef.addValueEventListener(userListener)
    }


}
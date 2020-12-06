package es.attomic.meloappuntoeoi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import es.attomic.meloappuntoeoi.Models.Task
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar.*


class DetailActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("tareas")
    lateinit var dataListener: ValueEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Instancia el Toolbar
        setSupportActionBar(miToolbar)

        // Intanciamos el FirebaseAuth para obtener luego el uid
        mAuth = FirebaseAuth.getInstance()


        // Obtenemos la tarea por el Bundle
        var idTask = "0"

        val extras = intent.extras
        if (extras != null) {
            idTask = extras.getString("miTarea")
        }


        // Referencia al objeto de la base de datos con mi id de usuario
        val dataRef = myRef.child(mAuth.uid.toString()).child(idTask)

        // Oyente de firebase para decirle que hacer en cada caso
        dataListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val data = dataSnapshot.getValue(Task::class.java)

                    txTitle.text = data?.text
                    txCategory.text = data?.category
                    txDescription.text = data?.description

                    if (data?.image != "" && data?.image != null) {
                        Picasso.get().load(data?.image).into(imgTask)
                    }

                    if (data?.done == true) {
                        txDone.text = "Done"
                        txDone.setBackgroundColor(resources.getColor(R.color.green))
                    } else {
                        txDone.text = "Pending"
                        txDone.setBackgroundColor(resources.getColor(R.color.red))
                    }

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // No se han podido leer los datos
                Log.d(DataHolder.TAG, "dataListener:failure")
            }
        }

        // Inicializamos el oyente
        dataRef.addListenerForSingleValueEvent(dataListener)

    }
}



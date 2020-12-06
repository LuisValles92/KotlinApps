package es.eoi.primerfirebase.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import es.eoi.primerfirebase.R
import es.eoi.primerfirebase.models.Film
import es.eoi.primerfirebase.models.ToDoItem
import kotlinx.android.synthetic.main.activity_peliculas.*
import kotlinx.android.synthetic.main.custom_dialog_modal.view.*
import kotlinx.android.synthetic.main.pelicula_item.view.*

class PeliculasActivity : AppCompatActivity() {

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    lateinit var adapter: FirebaseRecyclerAdapter<*, *>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        fav.setOnClickListener {
            alertFilmDialog()
        }

        initialise()

        setUpRecycler()
    }


    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("films_table")
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo = view.tvTituloSerie
        val description = view.tvDescription
    }

    private fun setUpRecycler() {
        val query = FirebaseDatabase.getInstance()
            .reference
            .child("films_table")


        val options = FirebaseRecyclerOptions.Builder<Film>()
            .setQuery(query, Film::class.java)
            .build()

        items_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = object : FirebaseRecyclerAdapter<Film?, ViewHolder?>(options) {

            override fun onBindViewHolder(holder: ViewHolder, p1: Int, item: Film) {
                holder.titulo?.text = item.title
                holder.description?.text = item.description
            }

            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): ViewHolder { // Create a new instance of the ViewHolder, in this case we are using a custom
                val view: View = LayoutInflater.from(this@PeliculasActivity)
                    .inflate(R.layout.pelicula_item, parent, false)
                return ViewHolder(view)
            }

        }
        items_list.adapter = adapter
    }


    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }


    private fun alertFilmDialog(){
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog_modal, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Añadir Película")
        //show dialog
        val  mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.dialogContinueBtn.setOnClickListener {
            val film = Film()
            val filmTitle = mDialogView.findViewById<EditText>(R.id.filmTitle)
            val description = mDialogView.findViewById<EditText>(R.id.filmDescription)
            val categories = mDialogView.findViewById<EditText>(R.id.filmCategory)


            film.title       = filmTitle.text.toString()
            film.description = description.text.toString()
            film.categories.add(categories.text.toString())
            //We first make a push so that a new item is made with a unique ID
            val newItem = mDatabaseReference!!.push()
            film.objectId = newItem.key
            //then, we used the reference to set the value on that ID
            newItem.setValue(film)




            Toast.makeText(this , "Item saved with ID " + film.objectId, Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }
        //cancel button click of custom layout
        mDialogView.dialogCancelBtn.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }
}



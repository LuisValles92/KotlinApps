package es.eoi.primerfirebase

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
import es.eoi.primerfirebase.models.ToDoItem
import kotlinx.android.synthetic.main.activity_to_do_list.*
import kotlinx.android.synthetic.main.list_item.view.*

class ToDoListActivity : AppCompatActivity() {

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    lateinit var adapter: FirebaseRecyclerAdapter<*, *>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        fab.setOnClickListener {
            addNewItemDialog()
        }

        initialise()

        setUpRecycler()
    }

    private fun setUpRecycler() {
        val query = FirebaseDatabase.getInstance()
            .reference
            .child("todo_table")
        val options = FirebaseRecyclerOptions.Builder<ToDoItem>()
            .setQuery(query, ToDoItem::class.java)
            .build()

        items_list.layoutManager = LinearLayoutManager(this)
        adapter = object : FirebaseRecyclerAdapter<ToDoItem?, ViewHolder?>(options) {

            override fun onBindViewHolder(holder: ViewHolder, p1: Int, item: ToDoItem) {
                holder.titleTodo?.text = item.titulotarea
                holder.checkStatus.isChecked = item.done!!

                holder.delete.setOnClickListener {
                    removeItem(snapshots[holder.adapterPosition])
                }

                //esto de abajo es para poder cambairlo en firebase.
                holder.checkStatus.setOnCheckedChangeListener { buttonView, isChecked ->
                    snapshots[holder.adapterPosition].done = isChecked
                    updateItem(snapshots[holder.adapterPosition])
                }

            }

            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): ViewHolder { // Create a new instance of the ViewHolder, in this case we are using a custom
                val view: View = LayoutInflater.from(this@ToDoListActivity)
                    .inflate(R.layout.list_item, parent, false)
                return ViewHolder(view)
            }

        }
        items_list.adapter = adapter
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTodo = view.tv_item_text
        val checkStatus: CheckBox = view.checkItem
        val delete = view.iv_cross
    }


    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }


    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("todo_table")
    }

    private fun addNewItemDialog() {
        val alert = AlertDialog.Builder(this)
        val itemEditText = EditText(this)
        alert.setMessage("Añadir Item")
        alert.setTitle("Introduce Todo item texto")
        alert.setView(itemEditText)
        alert.setPositiveButton("Añadir") { dialog, positiveButton ->


            val todoItem = ToDoItem()
            todoItem.titulotarea = itemEditText.text.toString()
            todoItem.done = false
            //We first make a push so that a new item is made with a unique ID
            val newItem = mDatabaseReference!!.push()
            todoItem.objectId = newItem.key
            //then, we used the reference to set the value on that ID
            newItem.setValue(todoItem)


            dialog.dismiss()
            Toast.makeText(this, "Item saved with ID " + todoItem.objectId, Toast.LENGTH_SHORT)
                .show()
        }
        alert.show()
    }


    private fun updateItem(todoItem: ToDoItem) {
        mDatabaseReference!!.child(todoItem.objectId!!).setValue(todoItem)
    }

    private fun removeItem(todoItem: ToDoItem) {
        mDatabaseReference!!.child(todoItem.objectId.toString()).removeValue()
    }

//esto hace que en el firebase puedas modificar los datos.
}

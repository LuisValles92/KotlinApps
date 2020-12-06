package es.attomic.meloappuntoeoi.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.firebase.ui.common.ChangeEventType
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import es.attomic.meloappuntoeoi.AddTaskActivity
import es.attomic.meloappuntoeoi.DetailActivity
import es.attomic.meloappuntoeoi.Interfaces.TaskListener
import es.attomic.meloappuntoeoi.Models.Task
import es.attomic.meloappuntoeoi.Navigation.NavigationChildFragment
import es.attomic.meloappuntoeoi.R
import es.attomic.meloappuntoeoi.ViewHolders.TaskViewHolder

class TodoFragment : NavigationChildFragment(), TaskListener {

    // Referencia a bbdd de firebase
    var mDatabase = FirebaseDatabase.getInstance().reference

    // Nombre de nuestra tabla/collection
    val taskTable = "tareas"

    // Intancia del adapter
    var mAdapter: FirebaseRecyclerAdapter<Task, TaskViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Titulo del fragment
        mainActivity.title = "Tareas por hacer"

        // Ocultar el botón de atras
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // Boton flotante
        val fab = view.findViewById<FloatingActionButton>(R.id.floatButton)
        fab.setOnClickListener {
            //addNewTaskDialog()

            val intent = Intent(context, AddTaskActivity::class.java)
            startActivity(intent)

        }

        // Listado de tareas
        val taskList = view.findViewById<RecyclerView>(R.id.rvTaskList)
        taskList.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        // Loader
        val progressBar = view.findViewById<ProgressBar>(R.id.progressbar)

        // Peticion a bbdd de firebase
        val query =
            mDatabase.child(taskTable).child(mAuth.currentUser?.uid.toString()).orderByChild("done").equalTo(false)
        val options = FirebaseRecyclerOptions.Builder<Task>()
            .setQuery(query, Task::class.java)
            .build()

        // Adapter de firebase
        mAdapter = object : FirebaseRecyclerAdapter<Task, TaskViewHolder>(options) {

            override fun onDataChanged() {
                super.onDataChanged()

                // Yo tengo un progress bar, y aqui lo escondo porque hay datos :)
                progressBar.visibility = View.GONE
            }

            override fun onChildChanged(type: ChangeEventType, snapshot: DataSnapshot, newIndex: Int, oldIndex: Int) {
                super.onChildChanged(type, snapshot, newIndex, oldIndex)

                // Cada vez que cambia un dato o se añade, el scrollview crece,
                // asi que hago scroll del recycler a la ultima posicion
                taskList.scrollToPosition(newIndex)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
                val myView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
                return TaskViewHolder(myView)
            }

            // Esta funcion carga tantas veces como objetos tengas en firebase database
            override fun onBindViewHolder(holder: TaskViewHolder, position: Int, model: Task) {
                holder.bindTask(model)
                // Cada vez que una tarea carge, le ponemos si esta done (realizada) o no
                holder.check.isChecked = model.done!!

                holder.delete.setOnClickListener {
                    // Eliminar tarea
                    deleteTask(model.id!!)
                }

                holder.check.setOnClickListener {
                    // Marcar como tarea completada
                    completeTask(model.id!!, true)
                }

                holder.cardView.setOnClickListener {
                    // Abrir activity, cambiar fragemnt, lo que quieas

                    val detail = Intent(context, DetailActivity::class.java)
                    detail.putExtra("miTarea", model.id!!)
                    startActivity(detail)
                }
            }

        }

        taskList.adapter = mAdapter
    }

    fun addNewTaskDialog() {

        // Alerta
        val alert = AlertDialog.Builder(context!!)
        // Campo de texto en la alerta
        val itemEditText = EditText(context)

        alert.setMessage("Añade una nueva tarea")
        alert.setTitle("Crear tarea")
        alert.setView(itemEditText) // Añado el campo de texto al alert

        alert.setPositiveButton("Submit") { dialog, _ ->

            val todoItem = Task()
            todoItem.text = itemEditText.text.toString()
            todoItem.done = false

            // Creamos una tarea en la tabla y nos dará una id única
            val newItem = mDatabase.child(taskTable).push()
            todoItem.id = newItem.key

            // Y finalizando... usamos la referencia para asignar valor a esa id
            newItem.setValue(todoItem)

            dialog.dismiss()
            Toast.makeText(context, "Tarea creada con el este id:" + todoItem.id, Toast.LENGTH_SHORT).show()

        }
        alert.show()
    }

    override fun deleteTask(idTask: String) {
        mDatabase.child(taskTable).child(mAuth.currentUser?.uid.toString()).child(idTask).removeValue()
    }

    override fun completeTask(idTask: String, isDone: Boolean) {
        mDatabase.child(taskTable).child(mAuth.currentUser?.uid.toString()).child(idTask).child("done").setValue(isDone)
    }


    override fun onStart() {
        super.onStart()
        mAdapter?.startListening()
    }

    override fun onStop() {
        super.onStop()
        mAdapter?.stopListening()
    }

}

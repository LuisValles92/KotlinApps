package es.attomic.meloappuntoeoi.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.firebase.ui.common.ChangeEventType
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import es.attomic.meloappuntoeoi.DetailActivity
import es.attomic.meloappuntoeoi.Interfaces.TaskListener
import es.attomic.meloappuntoeoi.Models.Task
import es.attomic.meloappuntoeoi.Navigation.NavigationChildFragment
import es.attomic.meloappuntoeoi.R
import es.attomic.meloappuntoeoi.ViewHolders.TaskViewHolder

class DoneFragment : NavigationChildFragment(), TaskListener {

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
        return inflater.inflate(R.layout.fragment_done, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Titulo del fragment
        mainActivity.title = "Tareas hechas"

        // Ocultar el botón de atras
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // Listado de tareas
        val taskList = view.findViewById<RecyclerView>(R.id.rvTaskList)
        taskList.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        // Loader
        val progressBar = view.findViewById<ProgressBar>(R.id.progressbar)

        // Peticion a bbdd de firebase
        val query = mDatabase.child(taskTable).child(mAuth.currentUser?.uid.toString()).orderByChild("done").equalTo(true)
        val options = FirebaseRecyclerOptions.Builder<Task>()
            .setQuery(query, Task::class.java)
            .build()

        // Adapter de firebase
        mAdapter = object : FirebaseRecyclerAdapter<Task, TaskViewHolder>(options) {

            override fun onDataChanged() {
                super.onDataChanged()
                progressBar.visibility = View.GONE
            }

            override fun onChildChanged(type: ChangeEventType, snapshot: DataSnapshot, newIndex: Int, oldIndex: Int) {
                super.onChildChanged(type, snapshot, newIndex, oldIndex)
                taskList.scrollToPosition(newIndex)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
                val myView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
                return TaskViewHolder(myView)
            }

            override fun onBindViewHolder(holder: TaskViewHolder, position: Int, model: Task) {
                holder.bindTask(model)
                holder.check.isChecked = true

                holder.delete.setOnClickListener {
                    // Eliminar tarea
                    deleteTask(model.id!!)
                }

                holder.check.setOnClickListener {
                    // Marcar como tarea completada
                    completeTask(model.id!!, false)
                }

                holder.cardView.setOnClickListener{
                    holder.cardView.setOnClickListener {
                        // Abrir activity, cambiar fragemnt, lo que quieas

                        val detail = Intent(context, DetailActivity::class.java)
                        detail.putExtra("miTarea", model.id!!)
                        startActivity(detail)
                    }
                }
            }

        }

        taskList.adapter = mAdapter
    }


    override fun deleteTask(idTask: String) {
        mDatabase.child(taskTable).child(idTask).removeValue()
    }

    override fun completeTask(idTask: String, isDone: Boolean) {
        mDatabase.child(taskTable).child(idTask).child("done").setValue(isDone)
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

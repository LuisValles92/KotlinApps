package es.attomic.meloappuntoeoi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import es.attomic.meloappuntoeoi.Models.Task
import kotlinx.android.synthetic.main.activity_add_task.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.IOException

class AddTaskActivity : AppCompatActivity() {

    // Referencia a bbdd de firebase
    var mDatabase = FirebaseDatabase.getInstance().reference

    // Nombre de nuestra tabla/collection
    val taskTable = "tareas"

    lateinit var mAuth: FirebaseAuth

    private var fileUri: Uri? = null
    private var imageReference: StorageReference? = null

    private val TAG = "StorageActivity"
    private val CHOOSING_IMAGE_REQUEST = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        // Instancia el Toolbar
        setSupportActionBar(miToolbar)

        mAuth = FirebaseAuth.getInstance()

        imageReference = FirebaseStorage.getInstance().reference.child("images")

        btn_choose_file.setOnClickListener {
            showChoosingFile()
        }

        btnAddtask.setOnClickListener {
            uploadFile()
        }

    }

    // Crea nuestra tarea en firebase
    private fun createTaskInFirebase(imageUri: String) {

        val todoItem = Task()
        todoItem.text = edTitle.text.toString()
        todoItem.done = false
        todoItem.description = edDescription.text.toString()
        todoItem.category = edCategory.text.toString()
        todoItem.image = imageUri

        // Creamos una tarea en la tabla y nos dará una id única
        val newItem = mDatabase.child(taskTable).child(mAuth.currentUser?.uid.toString()).push()
        todoItem.id = newItem.key

        // Y finalizando... usamos la referencia para asignar valor a esa id
        newItem.setValue(todoItem)

        // Cierra la activity
        this.finish()
    }

    private fun uploadFile() {
        if (fileUri != null) {
            val fileName = edtFileName.text.toString()

            if (!validateInputFileName(fileName)) {
                return
            }

            val fileRef = imageReference!!.child(fileName + "." + getFileExtension(fileUri!!))
            fileRef.putFile(fileUri!!)
                .addOnSuccessListener { taskSnapshot ->

                    taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
                        Log.e(TAG, "Uri: $uri")

                        // Creamos nuestra tarea en firebase
                        createTaskInFirebase(uri.toString())

                        Toast.makeText(this, "Fichero subido ", Toast.LENGTH_LONG).show()
                    }

                }
                .addOnFailureListener { exception ->
                    // Mostramos mensaje en caso de fallo
                    Toast.makeText(this, exception.message, Toast.LENGTH_LONG).show()
                }


        } else {
            Toast.makeText(this, "No hay fichero!", Toast.LENGTH_LONG).show()
        }
    }

    // LLama a la pantalla para seleccionar una imagen
    private fun showChoosingFile() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Selecciona una imágen"), CHOOSING_IMAGE_REQUEST)
    }


    // Obtiene la extension del fichero
    private fun getFileExtension(uri: Uri): String {
        val contentResolver = contentResolver
        val mime = MimeTypeMap.getSingleton()

        return mime.getExtensionFromMimeType(contentResolver.getType(uri))!!
    }

    // Valida que el dichero tenga un nombre
    private fun validateInputFileName(fileName: String): Boolean {
        if (TextUtils.isEmpty(fileName)) {
            Toast.makeText(this, "La foto necesita un nombre!", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    // Se ejecuta despues de seleccionar la foto esta atento a cuando seleccionas un valor tu galeria de fotos
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSING_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            fileUri = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, fileUri)
                imgFile.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}

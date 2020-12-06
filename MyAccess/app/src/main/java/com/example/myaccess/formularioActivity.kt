package com.example.myaccess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class formularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        /*
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:layout_marginTop="10dp"
                android:labelFor="@id/edad"
                android:text="Edad (opcional)" />

            <EditText
                android:id="@+id/edad"
                android:layout_width="130dp"
                android:layout_height="match_parent"
                android:inputType="number"
		        android:hint="27" />

		    *Habla el text y no la id o laberFor


		    <TextView
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:layout_marginTop="10dp"
                android:text="Formato de salida" />

            <RadioGroup
                android:layout_width="wrap_content"
                android:layout_height="match_parent">

                <RadioButton
                    android:layout_width="wrap_content"
                    android:layout_height="match_parent"
                    android:text="PDF" />

                <RadioButton
                    android:layout_width="wrap_content"
                    android:layout_height="match_parent"
                    android:text="Word" />

                <RadioButton
                    android:layout_width="wrap_content"
                    android:layout_height="match_parent"
                    android:text="HTML" />
            </RadioGroup>


            <CheckBox
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:text="Boletín semanal" />


            Feedback visual en el boton, para que veas que ha apretado el boton
            AutoCompleteTextView
            android:clickable:true Framework?
            botones 48x48
            material design
         */
    }
}

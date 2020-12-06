package com.example.myapp.Horario

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapp.R
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class HorarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horario)
        initCalendar()
    }


    private fun initCalendar() {
        val builder = MaterialDatePicker.Builder.datePicker()
        //Titulo
        builder.setTitleText("FECHA")
        val picker = builder.build()
        //Mostramos la ventana de elegir Fecha
        picker.show(supportFragmentManager, picker.toString())
        //Evento para el boton de ACEPTAR
        picker.addOnPositiveButtonClickListener {
            //Convertimos la fecha en algo visible para el usuario
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = it
            Log.i("FechaHorario", calendar.time.toString())

            val fechaFormateada = formatDate(calendar.time, "EEE, MMM, d. YYYY")
            Log.i("FechaHorario", fechaFormateada)
            initTime()
        }
    }

    private fun initTime() {
        val calendar = Calendar.getInstance()
        //Obtenemos la hora
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        //Obtenemos los minutos
        val minutes = calendar.get(Calendar.MINUTE)
        //instanciamos el time picker con su evento de Aceptar y la hora por defecto
        val picker = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { tp, sHour, sMinute ->
                Log.i("FechaHorario", "$sHour:$sMinute")
            },
            hour,
            minutes,
            true
        )
        picker.show()
    }

    fun formatDate(date: Date?, formatTarget: String): String? {
        var dateFormatted: String? = null
        if (date != null) {
            try {
                val formatter = SimpleDateFormat(formatTarget, Locale.getDefault())
                dateFormatted = formatter.format(date)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return dateFormatted
    }
}

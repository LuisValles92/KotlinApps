package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.RAW.RawIdFActivity
import com.luisvalles.mywwe.RAW.RawIdHActivity
import kotlinx.android.synthetic.main.activity_raw_id.*

class RawIdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw_id)

        BotonRAWIDF.setOnClickListener{
            val intent= Intent(this, RawIdFActivity::class.java)
            startActivity(intent)
        }

        BotonRAWIDH.setOnClickListener{
            val intent= Intent(this, RawIdHActivity::class.java)
            startActivity(intent)
        }
    }
}

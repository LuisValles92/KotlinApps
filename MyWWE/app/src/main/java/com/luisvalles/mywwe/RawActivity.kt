package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_raw.*

class RawActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw)

        BotonRAWIS.setOnClickListener{
            val intent= Intent(this, RawIsActivity::class.java)
            startActivity(intent)
        }

        BotonRAWID.setOnClickListener{
            val intent= Intent(this, RawIdActivity::class.java)
            startActivity(intent)
        }

        BotonRAWTG.setOnClickListener{
            val intent= Intent(this, RawTgActivity::class.java)
            startActivity(intent)
        }
    }
}

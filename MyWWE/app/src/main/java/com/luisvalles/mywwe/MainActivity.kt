package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BotonRAW.setOnClickListener{
            val intent= Intent(this, RawActivity::class.java)
            startActivity(intent)
        }

        BotonNXT.setOnClickListener{
            val intent= Intent(this, NxtActivity::class.java)
            startActivity(intent)
        }

        BotonSD.setOnClickListener{
            val intent= Intent(this, SdActivity::class.java)
            startActivity(intent)
        }

        BotonECW.setOnClickListener{
            val intent= Intent(this, EcwActivity::class.java)
            startActivity(intent)
        }
    }
}

package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sd.*

class SdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd)

        BotonSDIS.setOnClickListener{
            val intent= Intent(this, SdIsActivity::class.java)
            startActivity(intent)
        }

        BotonSDID.setOnClickListener{
            val intent= Intent(this, SdIdActivity::class.java)
            startActivity(intent)
        }

        BotonSDTG.setOnClickListener{
            val intent= Intent(this, SdTgActivity::class.java)
            startActivity(intent)
        }
    }
}

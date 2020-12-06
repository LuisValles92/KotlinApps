package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.SD.SdIdFActivity
import com.luisvalles.mywwe.SD.SdIdHActivity
import kotlinx.android.synthetic.main.activity_sd_id.*

class SdIdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd_id)

        BotonSDIDF.setOnClickListener{
            val intent= Intent(this, SdIdFActivity::class.java)
            startActivity(intent)
        }

        BotonSDIDH.setOnClickListener{
            val intent= Intent(this, SdIdHActivity::class.java)
            startActivity(intent)
        }
    }
}

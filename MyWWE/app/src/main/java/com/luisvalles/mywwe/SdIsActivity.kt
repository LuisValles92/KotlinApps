package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.SD.SdIsFActivity
import com.luisvalles.mywwe.SD.SdIsHActivity
import kotlinx.android.synthetic.main.activity_sd_is.*

class SdIsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd_is)

        BotonSDISF.setOnClickListener{
            val intent= Intent(this, SdIsFActivity::class.java)
            startActivity(intent)
        }

        BotonSDISH.setOnClickListener{
            val intent= Intent(this, SdIsHActivity::class.java)
            startActivity(intent)
        }
    }
}

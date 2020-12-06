package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.RAW.RawIsFActivity
import com.luisvalles.mywwe.RAW.RawIsHActivity
import kotlinx.android.synthetic.main.activity_raw_is.*

class RawIsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw_is)

        BotonRAWISF.setOnClickListener{
            val intent= Intent(this, RawIsFActivity::class.java)
            startActivity(intent)
        }

        BotonRAWISH.setOnClickListener{
            val intent= Intent(this, RawIsHActivity::class.java)
            startActivity(intent)
        }
    }
}

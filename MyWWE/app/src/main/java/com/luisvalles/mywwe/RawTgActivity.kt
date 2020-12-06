package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.RAW.RawTgFActivity
import com.luisvalles.mywwe.RAW.RawTgHActivity
import kotlinx.android.synthetic.main.activity_raw_tg.*

class RawTgActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw_tg)

        BotonRAWTGF.setOnClickListener{
            val intent= Intent(this, RawTgFActivity::class.java)
            startActivity(intent)
        }

        BotonRAWTGH.setOnClickListener{
            val intent= Intent(this, RawTgHActivity::class.java)
            startActivity(intent)
        }
    }
}

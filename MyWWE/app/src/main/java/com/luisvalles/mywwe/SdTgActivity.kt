package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.SD.SdTgFActivity
import com.luisvalles.mywwe.SD.SdTgHActivity
import kotlinx.android.synthetic.main.activity_sd_tg.*

class SdTgActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd_tg)

        BotonSDTGF.setOnClickListener{
            val intent= Intent(this, SdTgFActivity::class.java)
            startActivity(intent)
        }

        BotonSDTGH.setOnClickListener{
            val intent= Intent(this, SdTgHActivity::class.java)
            startActivity(intent)
        }
    }
}

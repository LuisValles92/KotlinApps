package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.ECW.EcwTgFActivity
import com.luisvalles.mywwe.ECW.EcwTgHActivity
import kotlinx.android.synthetic.main.activity_ecw_tg.*

class EcwTgActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw_tg)

        BotonECWTGF.setOnClickListener{
            val intent= Intent(this, EcwTgFActivity::class.java)
            startActivity(intent)
        }

        BotonECWTGH.setOnClickListener{
            val intent= Intent(this, EcwTgHActivity::class.java)
            startActivity(intent)
        }
    }
}

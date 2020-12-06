package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ecw.*

class EcwActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw)

        BotonECWIS.setOnClickListener{
            val intent= Intent(this, EcwIsActivity::class.java)
            startActivity(intent)
        }

        BotonECWID.setOnClickListener{
            val intent= Intent(this, EcwIdActivity::class.java)
            startActivity(intent)
        }

        BotonECWTG.setOnClickListener{
            val intent= Intent(this, EcwTgActivity::class.java)
            startActivity(intent)
        }
    }
}

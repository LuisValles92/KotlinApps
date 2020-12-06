package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.ECW.EcwIsFActivity
import com.luisvalles.mywwe.ECW.EcwIsHActivity
import kotlinx.android.synthetic.main.activity_ecw_is.*

class EcwIsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw_is)

        BotonECWISF.setOnClickListener{
            val intent= Intent(this, EcwIsFActivity::class.java)
            startActivity(intent)
        }

        BotonECWISH.setOnClickListener{
            val intent= Intent(this, EcwIsHActivity::class.java)
            startActivity(intent)
        }
    }
}

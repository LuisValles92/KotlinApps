package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.ECW.EcwIdFActivity
import com.luisvalles.mywwe.ECW.EcwIdHActivity
import kotlinx.android.synthetic.main.activity_ecw_id.*

class EcwIdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw_id)

        BotonECWIDF.setOnClickListener {
            val intent = Intent(this, EcwIdFActivity::class.java)
            startActivity(intent)
        }

        BotonECWIDH.setOnClickListener {
            val intent = Intent(this, EcwIdHActivity::class.java)
            startActivity(intent)
        }
    }
}

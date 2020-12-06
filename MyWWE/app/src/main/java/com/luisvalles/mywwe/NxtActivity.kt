package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nxt.*

class NxtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt)

        BotonNXTIS.setOnClickListener{
            val intent= Intent(this, NxtIsActivity::class.java)
            startActivity(intent)
        }

        BotonNXTID.setOnClickListener{
            val intent= Intent(this, NxtIdActivity::class.java)
            startActivity(intent)
        }

        BotonNXTTG.setOnClickListener{
            val intent= Intent(this, NxtTgActivity::class.java)
            startActivity(intent)
        }
    }
}

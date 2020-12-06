package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.NXT.NxtIdFActivity
import com.luisvalles.mywwe.NXT.NxtIdHActivity
import kotlinx.android.synthetic.main.activity_nxt_id.*

class NxtIdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt_id)

        BotonNXTIDF.setOnClickListener {
            val intent = Intent(this, NxtIdFActivity::class.java)
            startActivity(intent)
        }

        BotonNXTIDH.setOnClickListener {
            val intent = Intent(this, NxtIdHActivity::class.java)
            startActivity(intent)
        }
    }
}

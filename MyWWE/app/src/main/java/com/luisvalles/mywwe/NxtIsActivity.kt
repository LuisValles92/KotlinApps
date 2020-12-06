package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.NXT.NxtIsFActivity
import com.luisvalles.mywwe.NXT.NxtIsHActivity
import kotlinx.android.synthetic.main.activity_nxt_is.*

class NxtIsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt_is)

        BotonNXTISF.setOnClickListener{
            val intent= Intent(this, NxtIsFActivity::class.java)
            startActivity(intent)
        }

        BotonNXTISH.setOnClickListener{
            val intent= Intent(this, NxtIsHActivity::class.java)
            startActivity(intent)
        }
    }
}

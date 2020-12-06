package com.luisvalles.mywwe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.NXT.NxtTgFActivity
import com.luisvalles.mywwe.NXT.NxtTgHActivity
import kotlinx.android.synthetic.main.activity_nxt_tg.*

class NxtTgActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt_tg)

        BotonNXTTGF.setOnClickListener{
            val intent= Intent(this, NxtTgFActivity::class.java)
            startActivity(intent)
        }

        BotonNXTTGH.setOnClickListener{
            val intent= Intent(this, NxtTgHActivity::class.java)
            startActivity(intent)
        }
    }
}

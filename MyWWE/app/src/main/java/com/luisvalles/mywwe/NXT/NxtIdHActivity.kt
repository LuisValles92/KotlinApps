package com.luisvalles.mywwe.NXT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_nxt_id_h.*

class NxtIdHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt_id_h)

        val array = arrayOf(
            "(\n", "ALEXA BLISS\n", "CARMELLA\n"
            , "LANA\n", "MANDY ROSE\n", "TAMINA\n", "_"
        )
        val sorted = array.sortedArray()
        TxtDivasHellN.text = sorted.contentDeepToString()
    }
}

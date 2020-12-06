package com.luisvalles.mywwe.NXT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_nxt_id_f.*

class NxtIdFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt_id_f)

        val array = arrayOf("(\n", "BIANCA BELAIR\n", "EMBER MOON\n", "NAOMI\n", "NATALYA\n","BETH PHOENIX\n", "_")
        val sorted = array.sortedArray()
        TxtDivasFaceN.text = sorted.contentDeepToString()
    }
}

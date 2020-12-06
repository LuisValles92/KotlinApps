package com.luisvalles.mywwe.RAW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_raw_id_f.*

class RawIdFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw_id_f)

        val array = arrayOf("(\n", "BAYLEY\n", "BECKY LYNCH\n", "MICKIE JAMES\n", "PAIGE\n", "(C) ROWDY RONDA ROUSEY\n","(C) KAITLYN\n", "_")
        val sorted = array.sortedArray()
        TxtDivasFace.text = sorted.contentDeepToString()

    }
}

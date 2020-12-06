package com.luisvalles.mywwe.SD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_sd_id_h.*

class SdIdHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd_id_h)

        val array = arrayOf(
            "(\n", "THE RIOTT SQUAD - RUBY RIOTT\n", "THE RIOTT SQUAD - SARAH LOGAN\n"
            , "THE RIOTT SQUAD - LIV MORGAN\n", "MARYSE\n", "SONYA DEVILLE\n", "_"
        )
        val sorted = array.sortedArray()
        TxtDivasHellS.text = sorted.contentDeepToString()
    }
}

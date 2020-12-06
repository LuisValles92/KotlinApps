package com.luisvalles.mywwe.RAW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_raw_tg_h.*

class RawTgHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw_tg_h)

        val array = arrayOf(
            "(\n",
            "BC & DM - (C) BARON CORBIN\n",
            "BC & DM - DREW MCINTYRE\n",
            "KO & SZ - KEVIN OWENS '18\n",
            "KO & SZ - SAMI ZAYN\n",
            "WYATT FAMILY - ROWAN\n",
            "WYATT FAMILY - HARPER\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtTGSH.text = sorted.contentDeepToString()
    }
}

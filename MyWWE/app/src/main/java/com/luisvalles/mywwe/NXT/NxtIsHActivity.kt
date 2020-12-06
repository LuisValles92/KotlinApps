package com.luisvalles.mywwe.NXT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_nxt_is_h.*

class NxtIsHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt_is_h)

        val array = arrayOf(
            "(\n",
            "ANDRADE 'CIEN' ALMAS\n",
            "(C) BRIAN KENDRICK\n",
            "CHRIS JERICHO '10\n",
            "JINDER MAHAL\n",
            "KILLIAN DAIN\n",
            "(C) MARK HENRY\n",
            "SHINSUKE NAKAMURA\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtSuperHellN.text = sorted.contentDeepToString()
    }
}

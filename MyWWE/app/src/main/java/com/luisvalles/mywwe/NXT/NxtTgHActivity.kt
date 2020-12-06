package com.luisvalles.mywwe.NXT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_nxt_tg_h.*

class NxtTgHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt_tg_h)

        val array = arrayOf(
            "(\n",
            "THE ASCENSION - KONNOR\n",
            "THE ASCENSION - VIKTOR\n",
            "THE BROTHERHOOD - (C) STARDUST\n",
            "THE BROTHERHOOD - GOLDUST\n",
            "THE REVIVAL - SCOTT DAWSON\n",
            "THE REVIVAL - DASH WILDER\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtTGSHN.text = sorted.contentDeepToString()
    }
}

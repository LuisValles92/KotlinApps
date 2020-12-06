package com.luisvalles.mywwe.NXT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_nxt_tg_f.*

class NxtTgFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt_tg_f)

        val array = arrayOf(
            "(\n",
            "L & K - LUKE GALLOWS\n",
            "L & K - KARL ANDERSON\n",
            "TM-61 - SHANE THORNE\n",
            "TM-61 - NICK MILLER\n",
            "THE STREET PROFITS - MONTEZ FORD\n",
            "THE STREET PROFITS - ANGELO DAWKINS\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtTGSFN.text = sorted.contentDeepToString()
    }
}

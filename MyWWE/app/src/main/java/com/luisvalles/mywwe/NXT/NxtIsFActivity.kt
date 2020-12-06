package com.luisvalles.mywwe.NXT

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_nxt_is_f.*

class NxtIsFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nxt_is_f)

        val array = arrayOf(
            "(\n",
            "ALEISTER BLACK\n",
            "BOBBY ROODE\n",
            "FINN BÁLOR DEMON\n",
            "MUSTAFA ALI\n",
            "(C) RICOCHET\n",
            "(C) ROB VAN DAM\n",
            "TYLER BATE\n",
            "(C) LUIZEM RULES\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtSuperFaceN.text = sorted.contentDeepToString()
    }
}

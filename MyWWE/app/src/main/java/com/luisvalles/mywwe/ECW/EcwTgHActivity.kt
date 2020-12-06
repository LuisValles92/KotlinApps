package com.luisvalles.mywwe.ECW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_ecw_tg_h.*

class EcwTgHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw_tg_h)

        val array = arrayOf(
            "(\n",
            "C & MR-(C) MATT RIDDLE\n",
            "C & MR-(C) CARLITO\n",
            "THE FORGOTTEN SONS-(C) STEVE CUTLER\n",
            "THE FORGOTTEN SONS-(C) WESLEY BLAKE\n",
            "IMPERIUM-(C) FABIAN AICHNER\n",
            "IMPERIUM-(C) ALEXANDER WOLFE\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtTGSHE.text = sorted.contentDeepToString()
    }
}

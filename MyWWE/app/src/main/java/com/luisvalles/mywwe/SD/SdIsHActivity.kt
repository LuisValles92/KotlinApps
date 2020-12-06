package com.luisvalles.mywwe.SD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_sd_is_h.*

class SdIsHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd_is_h)

        val array = arrayOf(
            "(\n",
            "THE UNDISPUTED ERA - ADAM COLE\n",
            "(C) BOBBY LASHLEY\n",
            "RUSEV\n",
            "CHRISTIAN\n",
            "(C) THE GREAT KHALI\n",
            "(C) MVP\n",
            "ROMAN REIGNS\n",
            "(C) RYBACK\n",
            "SETH ROLLINS\n",
            "SAMOA JOE\n",
            "THE UNDISPUTED ERA - RODERICK STRONG\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtSuperHellS.text = sorted.contentDeepToString()
    }
}

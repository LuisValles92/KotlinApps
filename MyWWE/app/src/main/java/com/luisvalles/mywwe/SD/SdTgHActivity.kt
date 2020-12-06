package com.luisvalles.mywwe.SD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_sd_tg_h.*

class SdTgHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd_tg_h)

        val array = arrayOf(
            "(\n",
            "THE AUTHORS OF PAIN - AKAM\n",
            "THE AUTHORS OF PAIN - REZAR\n",
            "THE PATRIOTS - KURT ANGLE '06\n",
            "THE PATRIOTS -(C) JACK SWAGGER\n",
            "THE UNDISPUTED ERA - KYLE O'REILLY\n",
            "THE UNDISPUTED ERA - BOBBY FISH\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtTGSHS.text = sorted.contentDeepToString()
    }
}

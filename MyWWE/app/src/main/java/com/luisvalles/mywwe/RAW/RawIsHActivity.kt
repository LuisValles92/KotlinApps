package com.luisvalles.mywwe.RAW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_raw_is_h.*

class RawIsHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw_is_h)

        val array = arrayOf(
            "(\n",
            "W. F. -(C)  B. W. 'THE FIEND'\n",
            "(C) ALBERTO DEL RÍO\n",
            "(C) ANGEL GARZA\n",
            "CURTIS AXEL\n",
            "DOLPH ZIGGLER\n",
            "(C) BUDDY MURPHY\n",
            "THE MIZ\n",
            "KEVIN NASH\n",
            "RANDY ORTON '13\n",
            "SHEAMUS\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtSuperHell.text = sorted.contentDeepToString()
    }
}

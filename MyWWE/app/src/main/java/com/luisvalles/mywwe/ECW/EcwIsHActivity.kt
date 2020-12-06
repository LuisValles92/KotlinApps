package com.luisvalles.mywwe.ECW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_ecw_is_h.*

class EcwIsHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw_is_h)

        val array = arrayOf(
            "(\n",
            "BIG SHOW\n",
            "(C) CHRIS MASTERS\n",
            "THE FORGOTTEN SONS-(C) JAXSON RYKER\n",
            "(C) JBL\n",
            "(C) WADE BARRETT\n",
            "IMPERIUM - (C) WALTER\n",
            "IMPERIUM - (C) MARCEL BARTHEL\n",
            "(C) TOMMASO CIAMPA\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtSuperHellE.text = sorted.contentDeepToString()
    }
}

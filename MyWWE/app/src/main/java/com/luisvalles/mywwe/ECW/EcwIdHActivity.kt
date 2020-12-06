package com.luisvalles.mywwe.ECW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_ecw_id_h.*

class EcwIdHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw_id_h)

        val array = arrayOf(
            "(\n", "(C) AJ LEE\n","(C) LACEY EVANS\n", "(C) LAYLA\n"
            , "ALICIA FOX\n", "NIA JAX\n", "_"
        )
        val sorted = array.sortedArray()
        TxtDivasHellE.text = sorted.contentDeepToString()
    }
}

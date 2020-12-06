package com.luisvalles.mywwe.RAW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_raw_id_h.*

class RawIdHActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw_id_h)

        val array = arrayOf(
            "(\n", "THE IICONICS - PEYTON ROYCE\n", "THE IICONICS - BILLIE KAY\n"
            , "ASUKA\n", "KAIRI SANE\n", "SHAYNA BASZLER\n", "_"
        )
        val sorted = array.sortedArray()
        TxtDivasHell.text = sorted.contentDeepToString()
    }
}

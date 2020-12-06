package com.luisvalles.mywwe.RAW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_raw_tg_f.*

class RawTgFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw_tg_f)

        val array = arrayOf(
            "(\n",
            "THE HARDY BOYZ - MATT HARDY\n",
            "THE HARDY BOYZ - JEFF HARDY\n",
            "THE NEW DAY - BIG E\n",
            "THE NEW DAY - KOFI KINGSTON\n",
            "THE NEW DAY - XAVIER WOODS\n",
            "THE USOS - JEY USO '14\n",
            "THE USOS - JIMMY USO '14\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtTGSF.text = sorted.contentDeepToString()
    }
}

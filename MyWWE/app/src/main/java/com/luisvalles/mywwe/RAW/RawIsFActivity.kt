package com.luisvalles.mywwe.RAW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_raw_is_f.*

class RawIsFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raw_is_f)

        /*
        val array= arrayOf("@\n","\n","\n","\n","\n","_")
        val sorted= array.sortedArray()
        .text=sorted.contentDeepToString()
         */

        val array = arrayOf(
            "(\n",
            "(C) CM PUNK\n",
            "DEAN AMBROSE\n",
            "SHAWN MICHAELS '05\n",
            "JOHNNY GARGANO\n",
            "PETE DUNNE\n",
            "CHAD GABLE\n",
            "(C) REY MYSTERIO\n",
            "SHELTON BENJAMIN\n",
            "VELVETEEN DREAM\n",
            "(C) GREGORY HELMS\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtSuperFace.text = sorted.contentDeepToString()
    }
}

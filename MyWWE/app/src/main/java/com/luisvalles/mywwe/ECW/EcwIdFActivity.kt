package com.luisvalles.mywwe.ECW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_ecw_id_f.*

class EcwIdFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw_id_f)

        val array = arrayOf("(\n", "(C) EVA MARIE\n","(C) MIA YIM\n", "(C) RHEA RIPLEY\n", "(C) TEGAN NOX\n", "TRISH STRATUS\n", "_")
        val sorted = array.sortedArray()
        TxtDivasFaceE.text = sorted.contentDeepToString()
    }
}

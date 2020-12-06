package com.luisvalles.mywwe.SD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_sd_id_f.*

class SdIdFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd_id_f)

        val array = arrayOf(
            "(\n",
            "TITUS WORLDWIDE - DANA BROOKE\n",
            "CHARLOTTE FLAIR\n",
            "(C) MELINA\n",
            "SASHA BANKS\n",
            "LITA\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtDivasFaceS.text = sorted.contentDeepToString()
    }
}

package com.luisvalles.mywwe.SD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_sd_is_f.*

class SdIsFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd_is_f)

        val array = arrayOf(
            "(\n",
            "BATISTA\n",
            "AJ STYLES\n",
            "BRAUN STROWMAN\n",
            "CEDRIC ALEXANDER\n",
            "KALISTO\n",
            "LINCE DORADO\n",
            "R-TRUTH '12\n",
            "(C) REY FÉNIX\n",
            "(C) JOHN MORRISON\n",
            "RIKISHI\n",
            "SIN CARA\n",
            "CESARO\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtSuperFaceS.text = sorted.contentDeepToString()
    }
}

package com.luisvalles.mywwe.SD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_sd_tg_f.*

class SdTgFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sd_tg_f)

        val array = arrayOf(
            "(\n",
            "TITUS WORLDWIDE - TITUS O'NEIL\n",
            "TITUS WORLDWIDE - APOLLO CREWS\n",
            "HEAVY MACHINERY - TUCKER KNIGHT\n",
            "HEAVY MACHINERY - OTIS DOZOVIC\n",
            "TEAM HELL NO - DANIEL BRYAN '12(NO)\n",
            "TEAM HELL NO - KANE '12\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtTGSFS.text = sorted.contentDeepToString()
    }
}

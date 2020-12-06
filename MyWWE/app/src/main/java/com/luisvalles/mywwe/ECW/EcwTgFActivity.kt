package com.luisvalles.mywwe.ECW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_ecw_tg_f.*

class EcwTgFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw_tg_f)

        val array = arrayOf(
            "(\n",
            "JG & TK-(C) JUSTIN GABRIEL\n",
            "JG & TK-(C) TYSON KIDD\n",
            "CRYME TIME-(C) JTG\n",
            "CRYME TIME-(C) SHAD\n",
            "THE VIKING RAIDERS-(C) ERIK\n",
            "THE VIKING RAIDERS-(C) IVAR\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtTGSFE.text = sorted.contentDeepToString()
    }
}

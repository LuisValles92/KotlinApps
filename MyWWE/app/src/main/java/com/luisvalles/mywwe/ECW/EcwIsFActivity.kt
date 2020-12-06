package com.luisvalles.mywwe.ECW

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luisvalles.mywwe.R
import kotlinx.android.synthetic.main.activity_ecw_is_f.*

class EcwIsFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecw_is_f)

        val array = arrayOf(
            "(\n",
            "(C) EC3\n",
            "(C) FINLAY\n",
            "(C) KEITH LEE\n",
            "(C) MR KENNEDY\n",
            "(C) NEVILLE\n",
            "JOHN CENA\n",
            "RIC FLAIR '91\n",
            "_"
        )
        val sorted = array.sortedArray()
        TxtSuperFaceE.text = sorted.contentDeepToString()
    }
}

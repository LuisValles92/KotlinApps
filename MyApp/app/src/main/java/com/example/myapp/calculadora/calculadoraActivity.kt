package com.example.myapp.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_calculadora.*
import net.objecthunter.exp4j.ExpressionBuilder


class calculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        caluno.setOnClickListener { appendOnExpresstion("1", true) }
        caldos.setOnClickListener { appendOnExpresstion("2", true) }
        caltres.setOnClickListener { appendOnExpresstion("3", true) }
        calcuatro.setOnClickListener { appendOnExpresstion("4", true) }
        calcinco.setOnClickListener { appendOnExpresstion("5", true) }
        calseis.setOnClickListener { appendOnExpresstion("6", true) }
        calsiete.setOnClickListener { appendOnExpresstion("7", true) }
        calocho.setOnClickListener { appendOnExpresstion("8", true) }
        calnueve.setOnClickListener { appendOnExpresstion("9", true) }
        calcero.setOnClickListener { appendOnExpresstion("0", true) }
        calcoma.setOnClickListener { appendOnExpresstion(".", true) }

        calsuma.setOnClickListener { appendOnExpresstion("+", false) }
        calresta.setOnClickListener { appendOnExpresstion("-", false) }
        calmultiplicacion.setOnClickListener { appendOnExpresstion("*", false) }
        caldivision.setOnClickListener { appendOnExpresstion("/", false) }
        calparAbrir.setOnClickListener { appendOnExpresstion("(", false) }
        calparCerrar.setOnClickListener { appendOnExpresstion(")", false) }

        calreset.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        caldelete.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(0, string.length - 1)
            }
            tvResult.text = ""
        }

        caligual.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result.toFloat() == longResult.toFloat())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toFloat().toString()

            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }

        /*
        caligual.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }
         */

    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if (tvResult.text.isNotEmpty()) {
            tvExpression.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }

}

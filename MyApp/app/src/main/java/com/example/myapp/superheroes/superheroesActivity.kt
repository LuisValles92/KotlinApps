package com.example.myapp.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.R
import com.example.myapp.superheroes.modelo.HeroesResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_superheroes.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class superheroesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)
        init()
    }

    private fun init() {
        val json = readJsonFromFile()
        val heroes = Gson().fromJson(json, HeroesResponse::class.java)

        recyclerSuperheroes.layoutManager = LinearLayoutManager(this)
        recyclerSuperheroes.adapter = HeroesAdapter(heroes.results)
    }

    fun readJsonFromFile(): String {
        var json = ""
        try {
            val url = "heroes.json"
            val bufferedReader = BufferedReader(
                InputStreamReader(assets.open(url))
            )
            val paramsBuilder = StringBuilder()
            var line: String? = bufferedReader.readLine()
            while (line != null) {
                paramsBuilder.append(line)
                line = bufferedReader.readLine()
            }
            json = paramsBuilder.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }

}

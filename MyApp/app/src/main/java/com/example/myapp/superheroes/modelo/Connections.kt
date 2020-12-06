package com.example.myapp.superheroes.modelo


import com.google.gson.annotations.SerializedName

data class Connections(
    @SerializedName("group-affiliation")
    val groupAffiliation: String,
    @SerializedName("relatives")
    val relatives: String
)
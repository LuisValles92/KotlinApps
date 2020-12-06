package com.example.myapp.superheroes.modelo


import com.google.gson.annotations.SerializedName

data class HeroesResponse(
    @SerializedName("response")
    val response: String,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("results-for")
    val resultsFor: String
)
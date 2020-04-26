package com.example.data.entities.countries


import com.squareup.moshi.Json

data class RegionalBloc(
    @Json(name = "acronym")
    val acronym: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "otherAcronyms")
    val otherAcronyms: List<Any>,
    @Json(name = "otherNames")
    val otherNames: List<String>
)
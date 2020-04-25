package com.example.data.entities.topheadlines


import com.squareup.moshi.Json

data class Source(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String
)
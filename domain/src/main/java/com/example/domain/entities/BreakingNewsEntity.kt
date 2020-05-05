package com.example.domain.entities

data class BreakingNewsEntity(
    val source: String? = "",
    val title: String?,
    val description: String?,
    val imgUrl: String? = "",
    val publishedAt: String?
)
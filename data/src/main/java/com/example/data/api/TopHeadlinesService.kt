package com.example.data.api

import com.example.data.BuildConfig
import com.example.data.entities.TopHeadlines
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesService {
    @GET(BuildConfig.TOP_HEADLINES_ENDPOINT)
    fun getTopHeadlines(@Query("country") name: String): Single<TopHeadlines>
}
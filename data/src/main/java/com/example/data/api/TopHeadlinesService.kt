package com.example.data.api

import com.example.data.BuildConfig
import com.example.data.entities.TopHeadlines
import io.reactivex.Single
import retrofit2.http.GET

interface TopHeadlinesService {
    @GET(BuildConfig.TOP_HEADLINES_ENDPOINT)
    fun getTopHeadlines(): Single<TopHeadlines>
}
package com.example.data.api


import com.example.data.BuildConfig
import com.example.data.entities.countries.RestCountriesItem
import io.reactivex.Single
import retrofit2.http.GET

interface RestCountriesService {
    @GET(BuildConfig.COUNTRIES_ENDPOINT)
    fun getCountries(): Single<List<RestCountriesItem>>
}
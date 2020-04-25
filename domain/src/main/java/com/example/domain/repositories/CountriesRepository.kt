package com.example.domain.repositories

import com.example.domain.entities.CountriesEntity
import io.reactivex.Observable

interface CountriesRepository {
    fun getCountries(): Observable<List<CountriesEntity>>
}
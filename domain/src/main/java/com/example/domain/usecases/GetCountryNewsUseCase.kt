package com.example.domain.usecases

import com.example.domain.entities.ScreenState
import com.example.domain.repositories.CountriesRepository
import io.reactivex.Observable

interface GetCountryNewsUseCase {
    fun getCountries(): Observable<ScreenState>
}
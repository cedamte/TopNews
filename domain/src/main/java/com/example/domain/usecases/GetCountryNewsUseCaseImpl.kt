package com.example.domain.usecases

import com.example.domain.entities.CountriesScreenState
import com.example.domain.entities.ScreenState
import com.example.domain.repositories.CountriesRepository
import io.reactivex.Observable

class GetCountryNewsUseCaseImpl constructor(private val repository: CountriesRepository) :
    GetCountryNewsUseCase {
    override fun getCountries(): Observable<ScreenState> {
        return repository.getCountries()
            .map {
                if (it.isEmpty()) ScreenState.Empty else
                    CountriesScreenState.Content(it)
            }.onErrorReturn {
                ScreenState.Error(it.message ?: "Unknown Error")
            }.startWith(
                ScreenState.Loading(true)
            )
    }

}
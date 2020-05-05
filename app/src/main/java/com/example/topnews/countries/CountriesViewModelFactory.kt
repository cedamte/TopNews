package com.example.topnews.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.GetCountryNewsUseCase
import io.reactivex.disposables.CompositeDisposable
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class CountriesViewModelFactory constructor(
    private val getCountryNewsUseCase: GetCountryNewsUseCase,
    private val compositeDisposable: CompositeDisposable
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountriesViewModel::class.java)) {
            return CountriesViewModel(
                getCountryNewsUseCase,
                compositeDisposable
            ) as T
        }
        throw IllegalArgumentException("Unsupported Class")
    }
}
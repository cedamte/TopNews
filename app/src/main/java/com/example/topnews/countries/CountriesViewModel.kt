package com.example.topnews.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entities.ScreenState
import com.example.domain.usecases.GetCountryNewsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CountriesViewModel(
    private val getCountryNewsUseCase: GetCountryNewsUseCase,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    private val _countriesObservable: MutableLiveData<ScreenState> =
        MutableLiveData()
    val countriesObservable: LiveData<ScreenState>
        get() = _countriesObservable


    private fun getCountries() {
        compositeDisposable.add(
            getCountryNewsUseCase.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { list ->
                        _countriesObservable.value = list
                    }, { error ->
                        error.printStackTrace()
                    }
                )
        )
    }

    init {
        getCountries()
    }
}
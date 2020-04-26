package com.example.data.repository

import com.example.data.api.RestCountriesService
import com.example.data.entities.countries.RestCountriesItem
import com.example.data.mapper.Mapper
import com.example.domain.entities.CountriesEntity
import com.example.domain.repositories.CountriesRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CountriesRepositoryImpl constructor(
    private val restCountriesService: RestCountriesService,
    private val countriesEntityMapper: Mapper<RestCountriesItem, CountriesEntity>
) : CountriesRepository {
    override fun getCountries(): Observable<List<CountriesEntity>> {
        return restCountriesService.getCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                countriesEntityMapper.mapList(item = it)
            }
            .toObservable()
    }
}
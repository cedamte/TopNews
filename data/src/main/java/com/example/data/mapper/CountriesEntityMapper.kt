package com.example.data.mapper

import com.example.data.entities.countries.RestCountriesItem
import com.example.domain.entities.CountriesEntity

class CountriesEntityMapper : Mapper<RestCountriesItem, CountriesEntity> {
    override fun map(item: RestCountriesItem): CountriesEntity {
        return CountriesEntity(
            name = item.name,
            alpha2Code = item.alpha2Code,
            flagUrl = item.flag
        )
    }

}

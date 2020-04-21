package com.example.data.mapper

interface Mapper<T, R> {
    fun map(item: T): R
    fun mapList(item: List<T>): List<R> {
        return item.map { map(item = it) }
    }
}
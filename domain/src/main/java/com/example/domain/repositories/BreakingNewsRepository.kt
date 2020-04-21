package com.example.domain.repositories

import com.example.domain.entities.BreakingNewsEntity
import io.reactivex.Observable

interface BreakingNewsRepository {
    fun getBreakingNews(): Observable<List<BreakingNewsEntity>>
}
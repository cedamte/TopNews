package com.example.domain.usecases

import com.example.domain.entities.ScreenState
import io.reactivex.rxjava3.core.Observable

interface GetBreakingNewsUseCase {
    fun getNews(name: String): Observable<ScreenState>
}
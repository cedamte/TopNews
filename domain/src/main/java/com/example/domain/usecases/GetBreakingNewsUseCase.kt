package com.example.domain.usecases

import com.example.domain.entities.ScreenState
import io.reactivex.Observable

interface GetBreakingNewsUseCase {
    fun getNews(name: String): Observable<ScreenState>
}
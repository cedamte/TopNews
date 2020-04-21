package com.example.domain.usecases

import com.example.domain.entities.BreakingNewsScreenState
import com.example.domain.entities.ScreenState
import com.example.domain.repositories.BreakingNewsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBreakingNewsUseCaseImpl @Inject constructor(private val repository: BreakingNewsRepository) :
    GetBreakingNewsUseCase {
    override fun getNews(name: String): Observable<ScreenState> {
        return repository.getBreakingNews()
            .map {
                if (it.isEmpty()) ScreenState.Empty else
                    BreakingNewsScreenState.Content(it)
            }
            .onErrorReturn {
                ScreenState.Error(it.message ?: "Unknown Error")
            }
            .startWith(ScreenState.Loading(isLoading = true))
    }
}
package com.example.topnews.breakingnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.GetBreakingNewsUseCase
import io.reactivex.disposables.CompositeDisposable
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class BreakingNewsViewModelFactory(
    private val getBreakingNewsUseCase: GetBreakingNewsUseCase,
    private val compositeDisposable: CompositeDisposable
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BreakingNewsViewModel::class.java)) {
            return BreakingNewsViewModel(
                getBreakingNewsUseCase = getBreakingNewsUseCase,
                compositeDisposable = compositeDisposable
            ) as T
        }
        throw IllegalArgumentException("Unsupported Class")
    }
}
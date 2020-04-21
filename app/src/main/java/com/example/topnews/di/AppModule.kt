package com.example.topnews.di

import com.example.domain.usecases.GetBreakingNewsUseCase
import com.example.topnews.breakingnews.BreakingNewsViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideBreakingNewsViewModelFactory(getBreakingNewsUseCase: GetBreakingNewsUseCase):
            BreakingNewsViewModelFactory {
        return BreakingNewsViewModelFactory(
            getBreakingNewsUseCase,
            CompositeDisposable()
        )
    }
}

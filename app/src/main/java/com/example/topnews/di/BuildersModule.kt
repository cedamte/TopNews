package com.example.topnews.di

import com.example.data.entities.topheadlines.Article
import com.example.data.mapper.BreakingNewsEntityMapper
import com.example.data.mapper.Mapper
import com.example.data.repository.BreakingNewsRepositoryImpl
import com.example.domain.entities.BreakingNewsEntity
import com.example.domain.repositories.BreakingNewsRepository
import com.example.domain.usecases.GetBreakingNewsUseCase
import com.example.domain.usecases.GetBreakingNewsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class BuildersModule {
    @Binds
    abstract fun bindGetBreakingNewsUseCase(getBreakingNewsUseCaseImpl: GetBreakingNewsUseCaseImpl):
            GetBreakingNewsUseCase

    @Binds
    abstract fun bindBreakingNewsRepository(breakingNewsRepositoryImpl: BreakingNewsRepositoryImpl):
            BreakingNewsRepository

    @Binds
    abstract fun bindBreakingNewMapper(getBreakingNewsEntityMapper: BreakingNewsEntityMapper):
            Mapper<Article, BreakingNewsEntity>
}
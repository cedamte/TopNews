package com.example.data.repository

import com.example.data.api.TopHeadlinesService
import com.example.data.entities.topheadlines.Article
import com.example.data.mapper.Mapper
import com.example.domain.entities.BreakingNewsEntity
import com.example.domain.repositories.BreakingNewsRepository
import io.reactivex.Observable
import javax.inject.Inject

class BreakingNewsRepositoryImpl @Inject constructor(
    private val topHeadlinesService: TopHeadlinesService,
    private val breakingNewsEntityMapper: Mapper<Article, BreakingNewsEntity>
) : BreakingNewsRepository {
    override fun getBreakingNews(name: String): Observable<List<BreakingNewsEntity>> {
        return topHeadlinesService.getTopHeadlines(name)
            .map {
                breakingNewsEntityMapper.mapList(item = it.articles)
            }
            .toObservable()
    }
}
package com.example.data.mapper

import com.example.data.entities.Article
import com.example.domain.entities.BreakingNewsEntity
import javax.inject.Inject

class BreakingNewsEntityMapper @Inject constructor() : Mapper<Article, BreakingNewsEntity> {
    override fun map(item: Article): BreakingNewsEntity {
        return BreakingNewsEntity(
            source = item.source.name,
            title = item.title,
            description = item.description,
            imgUrl = item.urlToImage,
            publishedAt = item.publishedAt
        )
    }
}
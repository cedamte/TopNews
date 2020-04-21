package com.example.topnews.di

import com.example.topnews.app.TopNewsApplication
import com.example.topnews.breakingnews.BreakingNewsFragment
import dagger.Component

@Component(modules = [ApiModule::class, AppModule::class, BuildersModule::class])
interface AppComponent {
    fun inject(topNewsApplication: TopNewsApplication)
    fun inject(breakingNewsFragment: BreakingNewsFragment)
}
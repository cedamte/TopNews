package com.example.topnews.di

import com.example.topnews.app.TopNewsApplication
import com.example.topnews.breakingnews.BreakingNewsFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApiModule::class, AppModule::class, BuildersModule::class])
@Singleton
interface AppComponent {
    fun inject(topNewsApplication: TopNewsApplication)
    fun inject(breakingNewsFragment: BreakingNewsFragment)
}
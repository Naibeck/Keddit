package intro.keddit.kotlin.com.network.di

import dagger.Module
import dagger.Provides
import intro.keddit.kotlin.com.network.api.NewsApi
import intro.keddit.kotlin.com.network.api.RedditApi
import intro.keddit.kotlin.com.network.service.RedditService
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Alex Gomez on 5/8/2017.
 */
@Module
class NewsModule {
    @Provides
    @Singleton
    fun providesNewsApi(redditApi: RedditApi): NewsApi {
        return RedditService(redditApi)
    }

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi {
        return retrofit.create(RedditApi::class.java)
    }
}
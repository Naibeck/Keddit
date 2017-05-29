package intro.keddit.kotlin.com.network

import intro.keddit.kotlin.com.network.api.NewsApi
import intro.keddit.kotlin.com.network.model.News
import intro.keddit.kotlin.com.network.model.RedditNews
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Alex Gomez on 4/28/2017.
 */
@Singleton
class NewsManager @Inject constructor(val mApi: NewsApi) {

    fun getNews(after: String, limit: String = "10"): Single<RedditNews> {
        return mApi.getNews(after, limit)
                .flatMap {
                    val dataResponse = it.data
                    val news = dataResponse.children.map {
                        val item = it.data
                        News(item.author, item.title, item.num_comments.toInt(),
                                item.created, item.thumbnail, item.url)
                    }
                    val redditNews = RedditNews(dataResponse.after ?: "",
                            dataResponse.before ?: "",
                            news)

                    Observable.just(redditNews)
                }
                .singleOrError()
    }
}


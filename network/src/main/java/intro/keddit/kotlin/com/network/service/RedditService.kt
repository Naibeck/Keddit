package intro.keddit.kotlin.com.network.service

import intro.keddit.kotlin.com.network.api.NewsApi
import intro.keddit.kotlin.com.network.api.RedditApi
import intro.keddit.kotlin.com.network.model.RedditNewsResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Alex Gomez on 5/2/2017.
 */
class RedditService @Inject constructor(val redditApi: RedditApi) : NewsApi {
    override fun getNews(after: String, before: String): Observable<RedditNewsResponse> = redditApi.getTop(after, before)
}
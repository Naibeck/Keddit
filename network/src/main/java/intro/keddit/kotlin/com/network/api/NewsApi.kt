package intro.keddit.kotlin.com.network.api

import intro.keddit.kotlin.com.network.model.RedditNewsResponse
import io.reactivex.Observable

/**
 * Created by Alex Gomez on 5/5/2017.
 */
interface NewsApi {
    fun getNews(after: String, before: String): Observable<RedditNewsResponse>
}
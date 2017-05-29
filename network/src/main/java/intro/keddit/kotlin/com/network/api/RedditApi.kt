package intro.keddit.kotlin.com.network.api

import intro.keddit.kotlin.com.network.model.RedditNewsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Created by Alex Gomez on 5/2/2017.
 */
interface RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String): Observable<RedditNewsResponse>

}
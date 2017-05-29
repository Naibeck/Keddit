package intro.keddit.kotlin.com.network.model

/**
 * Created by Alex Gomez on 5/2/2017.
 */
data class RedditNewsDataResponse (val author: String,
                                   val title: String,
                                   val num_comments: String,
                                   val created: Long,
                                   val thumbnail: String,
                                   val url: String)
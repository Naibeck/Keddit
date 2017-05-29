package intro.keddit.kotlin.com.network.model

/**
 * Created by Alex Gomez on 5/2/2017.
 */
data class RedditDataResponse (val children: List<RedditChildrenResponse>,
                               val after: String?,
                               val before: String?)
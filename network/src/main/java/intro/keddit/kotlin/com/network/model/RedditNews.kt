package intro.keddit.kotlin.com.network.model

import android.os.Parcel
import android.os.Parcelable
import intro.keddit.kotlin.com.commonutility.createParcel

/**
 * Created by Alex Gomez on 5/2/2017.
 */
data class RedditNews(val after: String,
                      val before: String,
                      val news: List<News>) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<RedditNews> = createParcel { RedditNews(it) }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            mutableListOf<News>().apply {
                source.readTypedList(this, News.CREATOR)
            }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(after)
        dest?.writeString(before)
        dest?.writeTypedList(news)
    }
}
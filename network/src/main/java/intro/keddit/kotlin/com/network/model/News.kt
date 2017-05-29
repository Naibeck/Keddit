package intro.keddit.kotlin.com.network.model

import android.os.Parcel
import android.os.Parcelable
import intro.keddit.kotlin.com.commonutility.createParcel
import intro.keddit.kotlin.com.delegateadapters.ViewType
import intro.keddit.kotlin.com.delegateadapters.constants.ViewTypeConstants

/**
 * Created by Alex Gomez on 4/28/2017.
 */
data class News(
        val mAuthor: String,
        val mTitle: String,
        val mNumComments: Int,
        val mCreated: Long,
        val mThumbnail: String,
        val mUrl: String
) : ViewType, Parcelable {
    override fun getViewType(): Int = ViewTypeConstants.NEWS

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<News> = createParcel { News(it) }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readLong(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(mAuthor)
        dest?.writeString(mTitle)
        dest?.writeInt(mNumComments)
        dest?.writeLong(mCreated)
        dest?.writeString(mThumbnail)
        dest?.writeString(mUrl)
    }
}
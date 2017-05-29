package intro.keddit.kotlin.com.commonutility

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Alex Gomez on 5/2/2017.
 */

inline fun <reified T : Parcelable> createParcel(
        crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
        object : Parcelable.Creator<T> {
            override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
            override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
        }

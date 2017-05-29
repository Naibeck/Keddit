@file:JvmName("ViewGroupExtensionsUtil")
package intro.keddit.kotlin.com.commonutility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Alex Gomez on 4/28/2017.
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View? {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
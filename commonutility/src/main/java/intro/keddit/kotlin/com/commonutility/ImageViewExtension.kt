@file:JvmName("ImageViewExtensionUtil")
package intro.keddit.kotlin.com.commonutility

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Alex Gomez on 4/28/2017.
 */
fun ImageView.loadImg(imageUrl: String) {
    if (false) {
        Picasso.with(context)
                .load(R.drawable.placeholder)
                .into(this)
    } else {
        Picasso.with(context)
                .load(imageUrl)
                .into(this)
    }
}
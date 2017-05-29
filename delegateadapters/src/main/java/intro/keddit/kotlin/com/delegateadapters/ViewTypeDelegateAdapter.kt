package intro.keddit.kotlin.com.delegateadapters

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup

/**
 * Created by Alex Gomez on 4/28/2017.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup?): ViewHolder

    fun onBindViewHolder(viewHolder: ViewHolder?, item: ViewType)
}
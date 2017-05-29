package intro.keddit.kotlin.com.keddit.ui.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import intro.keddit.kotlin.com.commonutility.inflate
import intro.keddit.kotlin.com.delegateadapters.ViewType
import intro.keddit.kotlin.com.delegateadapters.ViewTypeDelegateAdapter
import intro.keddit.kotlin.com.keddit.R

/**
 * Created by Alex Gomez on 4/28/2017.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?, item: ViewType) {

    }

    class TurnsViewHolder(parent: ViewGroup?) : RecyclerView.ViewHolder(parent?.inflate(R.layout.news_item_loading))
}
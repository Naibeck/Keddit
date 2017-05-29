package intro.keddit.kotlin.com.keddit.ui.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import intro.keddit.kotlin.com.commonutility.getFriendlyTime
import intro.keddit.kotlin.com.commonutility.inflate
import intro.keddit.kotlin.com.commonutility.loadImg
import intro.keddit.kotlin.com.delegateadapters.ViewType
import intro.keddit.kotlin.com.delegateadapters.ViewTypeDelegateAdapter
import intro.keddit.kotlin.com.keddit.R
import intro.keddit.kotlin.com.network.model.News
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by Alex Gomez on 4/28/2017.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?, item: ViewType) {
        val turnsViewHolder = viewHolder as TurnsViewHolder
        turnsViewHolder.bind(item as News)
    }

    class TurnsViewHolder(parent: ViewGroup?) : RecyclerView.ViewHolder(parent?.inflate(R.layout.news_item)) {
        fun bind(item: News) = with(itemView) {

        }
//                with(itemView) {
//            img_thumbnail.loadImg(item.mThumbnail)
//            description.text = item.mTitle
//            author.text = item.mAuthor
//            comments.text = "${item.mNumComments} comments"
//            time.text = item.mCreated.getFriendlyTime()
//        }
    }
}
package intro.keddit.kotlin.com.keddit.ui.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import intro.keddit.kotlin.com.delegateadapters.ViewType
import intro.keddit.kotlin.com.delegateadapters.ViewTypeDelegateAdapter
import intro.keddit.kotlin.com.delegateadapters.constants.ViewTypeConstants
import intro.keddit.kotlin.com.keddit.ui.adapter.delegates.LoadingDelegateAdapter
import intro.keddit.kotlin.com.keddit.ui.adapter.delegates.NewsDelegateAdapter
import intro.keddit.kotlin.com.network.model.News

/**
 * Created by Alex Gomez on 4/28/2017.
 */
class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mNewsItems: ArrayList<ViewType>
    private var mDelegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val mLoadingItem = object : ViewType {
        override fun getViewType(): Int = ViewTypeConstants.LOADING
    }
    private val mNewsItem = object : ViewType {
        override fun getViewType(): Int = ViewTypeConstants.NEWS
    }

    init {
        mDelegateAdapters.put(ViewTypeConstants.LOADING, LoadingDelegateAdapter())
        mDelegateAdapters.put(ViewTypeConstants.NEWS, NewsDelegateAdapter())
        mNewsItems = ArrayList()
        mNewsItems.add(mLoadingItem)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        mDelegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.mNewsItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return mDelegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun getItemCount(): Int = mNewsItems.size

    override fun getItemViewType(position: Int): Int = this.mNewsItems[position].getViewType()

    fun removeAndAddNews(news: List<News>) {
        val initPosition: Int = mNewsItems.size - 1
        mNewsItems.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        addNews(news)
        notifyItemRangeChanged(initPosition, mNewsItems.size + 1)
    }

    fun clearAndAddNews(news: List<News>) {
        mNewsItems.clear()
        notifyItemRangeChanged(0, getLastPosition())

        addNews(news)
        notifyItemRangeInserted(0, mNewsItems.size)
    }

    fun getNews(): List<News> {
        return mNewsItems.filter { it.getViewType() == ViewTypeConstants.NEWS }
                .map { it as News }
    }

    private fun addNews(news: List<News>) {
        mNewsItems.addAll(news)
        mNewsItems.add(mLoadingItem)
    }

    private fun getLastPosition(): Int {
        if (mNewsItems.lastIndex == -1) {
           return 0
        } else {
            return mNewsItems.lastIndex
        }
    }
}
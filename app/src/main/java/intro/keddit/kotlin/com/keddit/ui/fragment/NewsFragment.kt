package intro.keddit.kotlin.com.keddit.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.components.support.RxFragment
import intro.keddit.kotlin.com.commonutility.InfiniteScrollListener
import intro.keddit.kotlin.com.commonutility.inflate
import intro.keddit.kotlin.com.keddit.KedditApplication
import intro.keddit.kotlin.com.keddit.R
import intro.keddit.kotlin.com.keddit.ui.adapter.NewsAdapter
import intro.keddit.kotlin.com.network.NewsManager
import intro.keddit.kotlin.com.network.model.RedditNews
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

/**
 * Created by Alex Gomez on 4/28/2017.
 */
class NewsFragment : RxFragment() {
    companion object {
        private val KEY_REDDIT_NEWS = "redditNews"
    }

    private var mRedditNews: RedditNews? = null

    private val mNewsRecycler by lazy {
        newsRecycler
    }

    @Inject lateinit var mNewsManager: NewsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KedditApplication.newsComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_news)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle: Bundle? = savedInstanceState

        initRecyclerView()
        initAdapter()

        if (savedInstanceState != null && bundle!!.containsKey(KEY_REDDIT_NEWS)) {
            mRedditNews = bundle.get(KEY_REDDIT_NEWS) as RedditNews
            (mNewsRecycler.adapter as NewsAdapter).clearAndAddNews(mRedditNews!!.news)
        } else {
            requestNews()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        KedditApplication.newsComponent.inject(this)

        val news = (mNewsRecycler.adapter as NewsAdapter).getNews()
        if (mRedditNews != null && news.isNotEmpty()) {
            outState?.putParcelable(KEY_REDDIT_NEWS, mRedditNews?.copy(news = news))
        }
    }

    private fun requestNews() {
        mNewsManager.getNews(mRedditNews?.after ?: "").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindToLifecycle())
                .subscribe({
                    mRedditNews = it
                    (mNewsRecycler.adapter as NewsAdapter).removeAndAddNews(it.news)
                },
                        { Log.e("Error", "An error occurred retrieving the list", it) })
    }

    private fun initRecyclerView() {
        mNewsRecycler.apply {
            setHasFixedSize(true)
            clearOnScrollListeners()
            addOnScrollListener(InfiniteScrollListener({ requestNews() },
                    layoutManager as LinearLayoutManager))
        }

    }

    private fun initAdapter() {
        mNewsRecycler.adapter = NewsAdapter()
    }
}
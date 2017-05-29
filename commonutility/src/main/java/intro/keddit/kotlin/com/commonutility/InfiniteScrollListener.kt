package intro.keddit.kotlin.com.commonutility

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

/**
 * Created by Alex Gomez on 5/2/2017.
 *
 * Check: @see https://developer.android.com/reference/android/support/v7/widget/RecyclerView.OnScrollListener.html
 */
class InfiniteScrollListener(val func: () -> Unit,
                             val layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {
    private var mPreviousTotal = 0
    private var mLoading = true
    private var mVisibleThreshold = 2
    private var mFirstVisibleItem = 0
    private var mVisibleItemCount = 0
    private var mTotalItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (dy > 0) {
            mVisibleItemCount = recyclerView!!.childCount
            mTotalItemCount = layoutManager.itemCount
            mFirstVisibleItem = layoutManager.findFirstVisibleItemPosition()

            if (mLoading) {
                if (mTotalItemCount > mPreviousTotal) {
                    mLoading = false
                    mPreviousTotal = mTotalItemCount
                }
            }

            if (!mLoading && (mTotalItemCount - mVisibleItemCount) <= (mFirstVisibleItem + mVisibleThreshold)) {
                Log.i("InfiniteScrollListener", "Limit reached")
                func()
                mLoading = true
            }


        }
    }

}
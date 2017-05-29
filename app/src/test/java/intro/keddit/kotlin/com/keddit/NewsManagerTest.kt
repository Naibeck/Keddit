package intro.keddit.kotlin.com.keddit

import intro.keddit.kotlin.com.network.api.NewsApi
import intro.keddit.kotlin.com.network.model.News
import intro.keddit.kotlin.com.network.model.RedditNewsResponse
import io.reactivex.Observable
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`

/**
 * Created by Alex Gomez on 5/5/2017.
 */
class NewsManagerTest {
    private var mTestSub = TestSubscriber<News>()
    private var mApiMock = mock<NewsApi>()
    private var mObservableMock = mock<Observable<RedditNewsResponse>>()

    @Before
    fun setup() {
        mTestSub = TestSubscriber<News>()
        mApiMock = mock<NewsApi>()
        mObservableMock = mock<Observable<RedditNewsResponse>>()
        `when`(mApiMock.getNews(anyString(), anyString())).thenReturn(mObservableMock)
    }
}
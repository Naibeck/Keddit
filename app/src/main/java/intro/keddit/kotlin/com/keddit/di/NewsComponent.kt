package intro.keddit.kotlin.com.keddit.di

import dagger.Component
import intro.keddit.kotlin.com.keddit.ui.fragment.NewsFragment
import intro.keddit.kotlin.com.network.di.NetworkModule
import intro.keddit.kotlin.com.network.di.NewsModule
import javax.inject.Singleton

/**
 * Created by Alex Gomez on 5/8/2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}